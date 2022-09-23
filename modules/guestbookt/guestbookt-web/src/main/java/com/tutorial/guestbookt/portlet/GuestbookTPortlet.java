package com.tutorial.guestbookt.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.tutorial.guestbookt.constants.GuestbookTPortletKeys;
import com.tutorial.guestbookt.model.GuestbookT;
import com.tutorial.guestbookt.model.GuestbookTEntry;
import com.tutorial.guestbookt.service.GuestbookTEntryLocalService;
import com.tutorial.guestbookt.service.GuestbookTLocalService;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author HP
 */
@Component(
		immediate = true, 
		property = { 
				"com.liferay.portlet.display-category=category.social",
				"com.liferay.portlet.instanceable=false", 
				"com.liferay.portlet.scopeable=true",
				"javax.portlet.display-name=GuestbookT", 
				"javax.portlet.expiration-cache=0",
				"javax.portlet.init-param.template-path=/", 
				"javax.portlet.init-param.view-template=/guestbookt/view.jsp",
				"javax.portlet.name=" + GuestbookTPortletKeys.GUESTBOOKT, 
				"javax.portlet.resource-bundle=content.Language",
				"javax.portlet.security-role-ref=power-user,user",
				"javax.portlet.supports.mime-type=text/html" 
				}, 
		service = Portlet.class)

public class GuestbookTPortlet extends MVCPortlet {

	public void addEntry(ActionRequest request, ActionResponse response) throws PortalException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(GuestbookTEntry.class.getName(), request);

		String userName = ParamUtil.getString(request, "name");
		String email = ParamUtil.getString(request, "email");
		String message = ParamUtil.getString(request, "message");
		long guestbookTId = ParamUtil.getLong(request, "guestbookTId");
		long entryId = ParamUtil.getLong(request, "entryId");

		if (entryId > 0) {

			try {

				_guestbookTEntryLocalService.updateGuestbookEntry(serviceContext.getUserId(), guestbookTId, entryId,
						userName, email, message, serviceContext);
				
//				response.getRenderParameters().setValue("guestbookTId", Long.toString(guestbookTId));
				response.setRenderParameter("guestbookTId", Long.toString(guestbookTId));
				
			} catch (Exception e) {
				System.out.println(e);
				
				SessionErrors.add(request, e.getClass().getName());

				PortalUtil.copyRequestParameters(request, response);
				
//				response.getRenderParameters().setValue("mvcPath", "/guestbookt/edit_entry.jsp");
				response.setRenderParameter("mvcPath", "/guestbookt/edit_entry.jsp");
			}

		} else {

			try {
				_guestbookTEntryLocalService.addGuestbookTEntry(serviceContext.getUserId(), guestbookTId, userName, email,
						message, serviceContext);				

//				response.getRenderParameters().setValue("guestbookTId", Long.toString(guestbookTId));
				response.setRenderParameter("guestbookTId", Long.toString(guestbookTId));
				
				SessionMessages.add(request, "entryAdded");

			} catch (Exception e) {
				System.out.println(e);
				
				SessionErrors.add(request, e.getClass().getName());

				PortalUtil.copyRequestParameters(request, response);

//				response.getRenderParameters().setValue("mvcPath", "/guestbookt/edit_entry.jsp");
				response.setRenderParameter("mvcPath", "/guestbookt/edit_entry.jsp");
			}
		}
	}
	
	public void deleteEntry(ActionRequest request, ActionResponse response) throws PortalException {
        long entryId = ParamUtil.getLong(request, "entryId");
        long guestbookTId = ParamUtil.getLong(request, "guestbookTId");

        ServiceContext serviceContext = ServiceContextFactory.getInstance(
            GuestbookTEntry.class.getName(), request);

        try {
//        	response.getRenderParameters().setValue("guestbookTId", Long.toString(guestbookTId));
            response.setRenderParameter("guestbookTclsId", Long.toString(guestbookTId));

            _guestbookTEntryLocalService.deleteGuestbookEntry(entryId);
            
            SessionMessages.add(request, "entryDeleted");
        }

        catch (Exception e) {
            Logger.getLogger(GuestbookTPortlet.class.getName()).log(
                Level.SEVERE, null, e);
            
            SessionErrors.add(request, e.getClass().getName());
        }
	}
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
	    throws IOException, PortletException {

	    try {
	        ServiceContext serviceContext = ServiceContextFactory.getInstance(
	            GuestbookT.class.getName(), renderRequest);

	        long groupId = serviceContext.getScopeGroupId();

	        long guestbookTId = ParamUtil.getLong(renderRequest, "guestbookTId");

	        List<GuestbookT> guestbooks = _guestbookTLocalService.getGuestbooks(
	            groupId);

	        if (guestbooks.isEmpty()) {
	            GuestbookT guestbookt = _guestbookTLocalService.addGuestbook(
	                serviceContext.getUserId(), "Main", serviceContext);

	            guestbookTId = guestbookt.getGuestbookTId();
	        }

	        if (guestbookTId == 0) {
	            guestbookTId = guestbooks.get(0).getGuestbookTId();
	        }

	        renderRequest.setAttribute("guestbookTId", guestbookTId);
	    }
	    catch (Exception e) {
	        throw new PortletException(e);
	    }

	    super.render(renderRequest, renderResponse);
	}

	@Reference
	private GuestbookTEntryLocalService _guestbookTEntryLocalService;

	@Reference
	private GuestbookTLocalService _guestbookTLocalService;
}
