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
import com.tutorial.liferay.my.gradebook.model.Course;
import com.tutorial.liferay.my.gradebook.service.CourseLocalService;

import java.util.Dictionary;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true)
public class CourseModelResourcePermissionRegistrar {
	
	@Activate
	public void activate(BundleContext bundleContext) {
		Dictionary<String, Object> properties = new HashMapDictionary<>();
		
		properties.put("model.class.name", Course.class.getName());
		
		_serviceRegistration = bundleContext.registerService(
				ModelResourcePermission.class,
				ModelResourcePermissionFactory.create(
						Course.class,
						Course::getCourseId,
						_courseLocalService::getCourse,
						_portletResourcePermission,
						(modelResourcePermission, consumer) -> {
							consumer.accept(new StagedModelPermissionLogic<>(
									_stagingPermission,
									MyGradebookPortletKeys.GRADEBOOK,
									Course::getCourseId));
							consumer.accept(
									new WorkflowedModelPermissionLogic<>(
											_workflowPermission, 
											modelResourcePermission, 
											_groupLocalService, 
											Course::getCourseId));
						}),
				properties);		
	}

	@Deactivate
	public void deactivate() {
		_serviceRegistration.unregister();
	}
	
	
	@Reference
	private CourseLocalService _courseLocalService;
	
	@Reference
	private GroupLocalService _groupLocalService;
	
	@Reference(
			target = "(resource.name=" + MyGradebookConstants.RESOURCE_NAME + ")")
	private PortletResourcePermission _portletResourcePermission;
	
	private ServiceRegistration<ModelResourcePermission> _serviceRegistration;
	
	@Reference
	private StagingPermission _stagingPermission;
	
	@Reference
	private WorkflowPermission _workflowPermission;
}
