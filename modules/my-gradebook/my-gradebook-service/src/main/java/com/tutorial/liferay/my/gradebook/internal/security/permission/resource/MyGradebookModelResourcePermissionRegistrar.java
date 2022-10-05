package com.tutorial.liferay.my.gradebook.internal.security.permission.resource;

import com.liferay.exportimport.kernel.staging.permission.StagingPermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionFactory;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.StagedModelPermissionLogic;
import com.liferay.portal.kernel.security.permission.resource.WorkflowedModelPermissionLogic;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.util.HashMapDictionary;
import com.liferay.portal.kernel.workflow.permission.WorkflowPermission;
import com.tutorial.liferay.my.gradebook.constants.MyGradebookConstants;
import com.tutorial.liferay.my.gradebook.constants.MyGradebookPortletKeys;
import com.tutorial.liferay.my.gradebook.model.MyGradebook;
import com.tutorial.liferay.my.gradebook.service.MyGradebookLocalService;

import java.util.Dictionary;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true)
public class MyGradebookModelResourcePermissionRegistrar {

	@Activate
	public void activate(BundleContext bundleContext) {
		Dictionary<String, Object> properties = new HashMapDictionary<String, Object>();
		
		properties.put("model.class.name", MyGradebook.class.getName());
		
		_serviceRegistration = bundleContext.registerService(
				ModelResourcePermission.class, 
				ModelResourcePermissionFactory.create(
						MyGradebook.class,
						MyGradebook::getMyGradebookId, 
						_myGradebookLocalService::getMyGradebook, 
						_portletResourcePermission, 
						(modelResourcePermission, consumer)  -> {
							consumer.accept(
									new StagedModelPermissionLogic<MyGradebook>(
											_stagingPermission, 
											MyGradebookPortletKeys.GRADEBOOK_ADMIN, 
											MyGradebook::getMyGradebookId));
							consumer.accept(
									new WorkflowedModelPermissionLogic<MyGradebook>(
											_workflowPermission,
											modelResourcePermission, 
											_groupLocalService, 
											MyGradebook::getMyGradebookId));
						}),
				properties);
	}
	
	@Deactivate
	public void deactivate() {
		_serviceRegistration.unregister();
	}
	
    @Reference
    private MyGradebookLocalService _myGradebookLocalService;
    
    @Reference(target = "(resource.name=" + MyGradebookConstants.RESOURCE_NAME + ")")
    private PortletResourcePermission _portletResourcePermission;
    
	private ServiceRegistration<ModelResourcePermission> _serviceRegistration;
	
    @Reference
    private StagingPermission _stagingPermission;

    @Reference
    private WorkflowPermission _workflowPermission;

    @Reference
    private GroupLocalService _groupLocalService;
}
