package com.tutorial.guestbookt.workflow;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.ResourceActions;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandler;
import com.tutorial.guestbookt.model.GuestbookT;
import com.tutorial.guestbookt.service.GuestbookTLocalService;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = WorkflowHandler.class)
public class GuestbookTWorkflowHandler extends BaseWorkflowHandler<GuestbookT> {
	
	@Override
	public String getClassName() {
	    return GuestbookT.class.getName();
	}
	
	@Override
	public String getType(Locale locale) {
	    return _resourceActions.getModelResource(locale, getClassName());
	}
	
	@Override
	public GuestbookT updateStatus(
	        int status, Map<String, Serializable> workflowContext)
	    throws PortalException {

	    long userId = GetterUtil.getLong(
	        (String)workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
	    
	    long resourcePrimKey = GetterUtil.getLong(
	        (String)workflowContext.get(
	            WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));

	    ServiceContext serviceContext = (ServiceContext)workflowContext.get(
	        "serviceContext");

	    return _guestbookTLocalService.updateStatus(
	        userId, resourcePrimKey, status, serviceContext);
	}
	
	@Reference(unbind = "-")
	protected void setResourceActions(ResourceActions resourceActions) {

	    _resourceActions = resourceActions;
	}

	private ResourceActions _resourceActions;
	
    @Reference(unbind = "-")
    protected void setGuestbookLocalService(
        GuestbookTLocalService guestbookTLocalService) {

        _guestbookTLocalService = guestbookTLocalService;
    }

    private GuestbookTLocalService _guestbookTLocalService;

}
