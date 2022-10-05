package com.tutorial.liferay.my.gradebook.internal.security.permission.resource;

import com.liferay.exportimport.kernel.staging.permission.StagingPermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermissionFactory;
import com.liferay.portal.kernel.security.permission.resource.StagedPortletPermissionLogic;
import com.liferay.portal.kernel.util.HashMapDictionary;
import com.tutorial.liferay.my.gradebook.constants.MyGradebookConstants;
import com.tutorial.liferay.my.gradebook.constants.MyGradebookPortletKeys;

import java.util.Dictionary;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

public class MyGradebookPortletResourcePermissionRegistrar {
	
	@Activate
	public void activate(BundleContext bundleContext) {
		Dictionary<String, Object> properties = new HashMapDictionary<>();
		
		properties.put("resource.name", MyGradebookConstants.RESOURCE_NAME);
		
		_serviceRegistration = bundleContext.registerService(
				PortletResourcePermission.class, 
				PortletResourcePermissionFactory.create(
						MyGradebookConstants.RESOURCE_NAME, 
						new StagedPortletPermissionLogic(
								_stagingPermission, 
								MyGradebookPortletKeys.GRADEBOOK)),
				properties);				
	}
	
	@Deactivate
	public void deactivate() {
		_serviceRegistration.unregister();
	}
	
	private ServiceRegistration<PortletResourcePermission> _serviceRegistration;
	
	@Reference
	private StagingPermission _stagingPermission;

}
