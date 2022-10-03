package com.tutorial.guestbookt.workflow;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.ResourceActions;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandler;
import com.tutorial.guestbookt.model.GuestbookTEntry;
import com.tutorial.guestbookt.service.GuestbookTEntryLocalService;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = WorkflowHandler.class)
public class GuestbookTEntryWorkflowHandler extends BaseWorkflowHandler<GuestbookTEntry> {
	
	   @Override
	    public String getClassName() {

	        return GuestbookTEntry.class.getName();

	    }

	    @Override
	    public String getType(Locale locale) {

	        return _resourceActions.getModelResource(locale, getClassName());

	    }

	    @Override
	    public GuestbookTEntry updateStatus(
	        int status, Map<String, Serializable> workflowContext)
	        throws PortalException {

	        long userId = GetterUtil.getLong(
	            (String) workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
	        long resourcePrimKey = GetterUtil.getLong(
	            (String) workflowContext.get(
	                WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));

	        ServiceContext serviceContext =
	            (ServiceContext) workflowContext.get("serviceContext");

	        long guestbookTId =
	            _guestbookTEntryLocalService.getGuestbookTEntry(resourcePrimKey).getGuestbookTId();
	        
	        return _guestbookTEntryLocalService.updateStatus(
	            userId, guestbookTId, resourcePrimKey, status, serviceContext);
	    }

	    @Reference(unbind = "-")
	    protected void setGuestbookEntryLocalService(GuestbookTEntryLocalService guestbookTEntryLocalService) {

	        _guestbookTEntryLocalService = guestbookTEntryLocalService;
	    }

	    @Reference(unbind = "-")
	    protected void setResourceActions(ResourceActions resourceActions) {

	        _resourceActions = resourceActions;
	    }

	    private GuestbookTEntryLocalService _guestbookTEntryLocalService;
	    private ResourceActions _resourceActions;

}
