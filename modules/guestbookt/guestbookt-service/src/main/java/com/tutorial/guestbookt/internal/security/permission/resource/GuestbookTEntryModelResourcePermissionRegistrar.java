package com.tutorial.guestbookt.internal.security.permission.resource;

import com.liferay.exportimport.kernel.staging.permission.StagingPermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionFactory;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.StagedModelPermissionLogic;
import com.liferay.portal.kernel.security.permission.resource.WorkflowedModelPermissionLogic;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.util.HashMapDictionary;
import com.liferay.portal.kernel.workflow.permission.WorkflowPermission;
import com.tutorial.guestbookt.constants.GuestbookTConstants;
import com.tutorial.guestbookt.constants.GuestbookTPortletKeys;
import com.tutorial.guestbookt.model.GuestbookTEntry;
import com.tutorial.guestbookt.service.GuestbookTEntryLocalService;

import java.util.Dictionary;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true)
public class GuestbookTEntryModelResourcePermissionRegistrar {
	
	 @Activate
	    public void activate(BundleContext bundleContext) {
	        Dictionary<String, Object> properties = new HashMapDictionary<>();

	        properties.put("model.class.name", GuestbookTEntry.class.getName());

	        _serviceRegistration = bundleContext.registerService(
	            ModelResourcePermission.class,
	            ModelResourcePermissionFactory.create(
	                GuestbookTEntry.class, 
	                GuestbookTEntry::getEntryId,
	                _guestbookTEntryLocalService::getGuestbookTEntry, 
	                _portletResourcePermission,
	                (modelResourcePermission, consumer) -> {
	                    consumer.accept(
	                        new StagedModelPermissionLogic<>(
	                            _stagingPermission, GuestbookTPortletKeys.GUESTBOOKT,
	                            GuestbookTEntry::getEntryId));
	                    consumer.accept(
	                        new WorkflowedModelPermissionLogic<>(
	                                _workflowPermission, modelResourcePermission,
	                                _groupLocalService, GuestbookTEntry::getEntryId));
	                }),
	            properties);
	    }

	    @Deactivate
	    public void deactivate() {
	        _serviceRegistration.unregister();
	    }

	    @Reference
	    private GuestbookTEntryLocalService _guestbookTEntryLocalService;

	    @Reference(target = "(resource.name=" + GuestbookTConstants.RESOURCE_NAME + ")")
	    private PortletResourcePermission _portletResourcePermission;

	    private ServiceRegistration<ModelResourcePermission> _serviceRegistration;

	    @Reference
	    private StagingPermission _stagingPermission;

	    @Reference
	    private WorkflowPermission _workflowPermission;

	    @Reference
	    private GroupLocalService _groupLocalService;

}
