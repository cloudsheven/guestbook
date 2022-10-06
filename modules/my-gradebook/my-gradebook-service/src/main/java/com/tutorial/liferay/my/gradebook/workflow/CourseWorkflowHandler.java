package com.tutorial.liferay.my.gradebook.workflow;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.ResourceActions;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandler;
import com.tutorial.liferay.my.gradebook.model.Course;
import com.tutorial.liferay.my.gradebook.service.CourseLocalService;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		service = WorkflowHandler.class)
public class CourseWorkflowHandler 
	extends BaseWorkflowHandler<Course>{
	
	@Override
	public String getClassName() {
		return Course.class.getName();
	}
		
	@Override
	public String getType(Locale locale) {
		return _resourceActions.getModelResource(locale, getClassName());
	}
	
	@Override
	public Course updateStatus(
			int status, Map<String, Serializable> workflowContext)
	throws PortalException {
		
		long userId = GetterUtil.getLong(
				(String) workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
		
		long resourcePrimKey = GetterUtil.getLong(
				(String) workflowContext.get(
						WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));
		
		ServiceContext serviceContext = 
				(ServiceContext) workflowContext.get("serviceContext");
		
		long myGradebookId =
				_courseLocalService.getCourse(resourcePrimKey).getMyGradebookId();
		
		return _courseLocalService.updateStatus(
				userId,
				myGradebookId,
				resourcePrimKey,
				status,
				serviceContext);
	}

	@Reference(unbind = "-")
	protected void setCourseLocalService(CourseLocalService courseLocalService) {
		_courseLocalService = courseLocalService;
	}
	@Reference(unbind = "-")
	protected void setResourceActions(ResourceActions resourceActions) {
		_resourceActions = resourceActions;
	}
	
	private CourseLocalService _courseLocalService;
	
	private ResourceActions _resourceActions;
}
