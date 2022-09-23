package com.tutorial.guestbookt.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.tutorial.guestbookt.constants.GuestbookTPortletKeys;
import com.tutorial.guestbookt.model.GuestbookT;
import com.tutorial.guestbookt.service.GuestbookTLocalService;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=category.hidden",
			"com.liferay.portlet.scopeable=true",
			"javax.portlet.display-name=GuestbooksT",
			"javax.portlet.expiration-cache=0",
			"javax.portlet.init-param.portlet-title-based-navigation=true",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/guestbookt_admin/view.jsp",
			"javax.portlet.name=" + GuestbookTPortletKeys.GUESTBOOKT_ADMIN,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=administrator",
			"javax.portlet.supports.mime-type=text/html",
			"com.liferay.portlet.add-default-resource=true"			
		},
		service = Portlet.class	
)

public class GuestbookTAdminPortlet extends MVCPortlet {
	
	public void addGuestbookT(ActionRequest request, ActionResponse response)
		throws PortalException {
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(GuestbookT.class.getName(), request);
		
		String name = ParamUtil.getString(request, "name");
		
		try {
			_guestbookTLocalService.addGuestbook(serviceContext.getUserId(), name, serviceContext);
			
			SessionMessages.add(request, "guestbookAdded");
			
		} catch (PortalException pe) {

			Logger.getLogger(GuestbookTAdminPortlet.class.getName()).log(Level.SEVERE, null, pe);
			
			response.setRenderParameter("mvcPath", "/guestbookt_admin/edit_guestbookt.jsp");
			
			SessionErrors.add(request, pe.getClass().getName());
		}
	}
	
	public void deleteGuestbookT(ActionRequest request, ActionResponse response)
		throws PortalException {
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(GuestbookT.class.getName(), request);
		
		long guestbookTId = ParamUtil.getLong(request, "guestbookTId");
		
		try {
			
			_guestbookTLocalService.deleteGuestbookT(guestbookTId, serviceContext);
			
			SessionMessages.add(request, "guestbookDeleted");
			
		} catch (PortalException pe) {

			Logger.getLogger(GuestbookTAdminPortlet.class.getName()).log(Level.SEVERE, null, pe);
			
			SessionErrors.add(request, pe.getClass().getName());
		}
	}
	
	public void updateGuestbookT(ActionRequest request, ActionResponse response)
		throws PortalException {
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(GuestbookT.class.getName(), request);
		
		String name = ParamUtil.getString(request, "name");
		
		long guestbookTId = ParamUtil.getLong(request, "guestbookTId");
		
		try {
			
			_guestbookTLocalService.updateGuestbookT(serviceContext.getUserId(), guestbookTId, name, serviceContext);
	
			SessionMessages.add(request, "guestbookUpdated");
			
		} catch (PortalException pe) {

			Logger.getLogger(GuestbookTAdminPortlet.class.getName()).log(Level.SEVERE, null, pe);
			
			response.setRenderParameter("mvcPath", "/guestbookt_admin/edit_guestbookt.jsp");
			
			SessionErrors.add(request, pe.getClass().getName());
		}
	}

	@Reference
	private GuestbookTLocalService _guestbookTLocalService;
}
