package com.tutorial.liferay.my.gradebook.workflow;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.ResourceActions;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandler;
import com.tutorial.liferay.my.gradebook.model.MyGradebook;
import com.tutorial.liferay.my.gradebook.service.MyGradebookLocalService;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		service = WorkflowHandler.class
)
public class MyGradebookWorkflowHandler 
	extends BaseWorkflowHandler<MyGradebook>{
	
	@Override
	public String getClassName() {
		return MyGradebook.class.getName();
	}
	
	@Override
	public String getType(Locale locale) {
		return _resourceActions.getModelResource(locale, getClassName());
	}
	
	@Override
	public MyGradebook updateStatus(
			int status, Map<String, Serializable> workflowContext)
	throws PortalException {
		
		long userId = GetterUtil.getLong(
				(String) workflowContext.get(
						WorkflowConstants.CONTEXT_USER_ID));
		
		long resourcePrimKey = GetterUtil.getLong(
				(String) workflowContext.get(
						WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));
		
		ServiceContext serviceContext = (ServiceContext) workflowContext.get(
				"serviceContext");
		
		return _myGradebookLocalService.updateStatus(
				userId, resourcePrimKey, status, serviceContext);
	}
	
	
	@Reference(unbind = "-")
	protected void setResourceActions(ResourceActions resourceActions ) {
		_resourceActions = resourceActions;
	}
	
	@Reference(unbind = "-")
	protected void setMyGradebookLocalService(
			MyGradebookLocalService myGradebookLocalService) {
		_myGradebookLocalService = myGradebookLocalService;
	}
	
	private ResourceActions _resourceActions;
	
	private MyGradebookLocalService _myGradebookLocalService;
}
