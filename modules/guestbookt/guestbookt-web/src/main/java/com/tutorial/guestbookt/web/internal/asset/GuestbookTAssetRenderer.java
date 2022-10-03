package com.tutorial.guestbookt.web.internal.asset;

import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.petra.string.StringUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.LayoutConstants;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.tutorial.guestbookt.constants.GuestbookTPortletKeys;
import com.tutorial.guestbookt.model.GuestbookT;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GuestbookTAssetRenderer extends BaseJSPAssetRenderer<GuestbookT>{
	
	public GuestbookTAssetRenderer(
			GuestbookT guestbookt, 
			ModelResourcePermission<GuestbookT> modelResourcePermission) {

        _guestbookt = guestbookt;
        _guestbookTModelResourcePermission = modelResourcePermission;
	}

	@Override
	public boolean hasEditPermission(PermissionChecker permissionChecker) 
	{
	    try {
	        return _guestbookTModelResourcePermission.contains(
	            permissionChecker, _guestbookt, ActionKeys.UPDATE);
	    }
	    catch (Exception e) {
	    }

	    return false;
	}	

	@Override
	public boolean hasViewPermission(PermissionChecker permissionChecker)
	{
		
	    try {
	        return _guestbookTModelResourcePermission.contains(
	            permissionChecker, _guestbookt, ActionKeys.VIEW);
	    }
	    catch (Exception e) {
	    }

	    return true;
	}
	
//	GETTER
	@Override
	public GuestbookT getAssetObject() {
	  return _guestbookt;
	}

	@Override
	public long getGroupId() {
	  return _guestbookt.getGroupId();
	}

	@Override
	public long getUserId() {

	  return _guestbookt.getUserId();
	}

	@Override
	public String getUserName() {
	  return _guestbookt.getUserName();
	}

	@Override
	public String getUuid() {
	  return _guestbookt.getUuid();
	}

	@Override
	public String getClassName() {
	  return GuestbookT.class.getName();
	}

	@Override
	public long getClassPK() {
	  return _guestbookt.getGuestbookTId();
	}

	@Override
	public String getSummary(PortletRequest portletRequest, PortletResponse 
	  portletResponse) {
	    return "Name: " + _guestbookt.getName();
	}

	@Override
	public String getTitle(Locale locale) {
	  return _guestbookt.getName();
	}
	
	@Override
	public boolean include(HttpServletRequest request, HttpServletResponse 
			response, String template) throws Exception {
		request.setAttribute("GUESTBOOKT", _guestbookt);
		request.setAttribute("HtmlUtil", HtmlUtil.getHtml());
		request.setAttribute("StringUtil", new StringUtil());
		return super.include(request, response, template);
	}
	
	@Override
	public String getJspPath(HttpServletRequest request, String template) {

	    if (template.equals(TEMPLATE_FULL_CONTENT)) {
	      request.setAttribute("gbt_guestbookt", _guestbookt);

	      return "/asset/guestbookt/" + template + ".jsp";
	    } else {
	      return null;
	    }
	}
	
	@Override 
	public PortletURL getURLEdit(
			LiferayPortletRequest liferayPortletRequest, LiferayPortletResponse liferayPortletResponse) 
					throws Exception {

		PortletURL portletURL = liferayPortletResponse.createLiferayPortletURL(
		    getControlPanelPlid(liferayPortletRequest), GuestbookTPortletKeys.GUESTBOOKT,
		    PortletRequest.RENDER_PHASE);
		portletURL.setParameter("mvcPath", "/guestbookt_admin/edit_guestbookt.jsp");
		portletURL.setParameter("guestbookTId", String.valueOf(_guestbookt.getGuestbookTId()));
		portletURL.setParameter("showback", Boolean.FALSE.toString());

		return portletURL;		
	}
	
	@Override
	public String getURLViewInContext(LiferayPortletRequest liferayPortletRequest,
	  LiferayPortletResponse liferayPortletResponse, String noSuchEntryRedirect) 
			  throws Exception {		
	    try {
	    	
	      long plid = PortalUtil.getPlidFromPortletId(_guestbookt.getGroupId(),
	          GuestbookTPortletKeys.GUESTBOOKT);

	      PortletURL portletURL;
	      
	      if (plid == LayoutConstants.DEFAULT_PLID) {
	        portletURL = liferayPortletResponse.createLiferayPortletURL(getControlPanelPlid(liferayPortletRequest),
	            GuestbookTPortletKeys.GUESTBOOKT, PortletRequest.RENDER_PHASE);
	      } else {
	        portletURL = PortletURLFactoryUtil.create(liferayPortletRequest,
	            GuestbookTPortletKeys.GUESTBOOKT, plid, PortletRequest.RENDER_PHASE);
	      }

	      portletURL.setParameter("mvcPath", "/guestbookt_admin/view.jsp");
	      portletURL.setParameter("guestbookTId", String.valueOf(_guestbookt.getGuestbookTId()));

	      String currentUrl = PortalUtil.getCurrentURL(liferayPortletRequest);

	      portletURL.setParameter("redirect", currentUrl);

	      return portletURL.toString();

	    } catch (PortalException e) {

	        logger.log(Level.SEVERE, e.getMessage());

	    } catch (SystemException e) {

	        logger.log(Level.SEVERE, e.getMessage());

	    }

	    return noSuchEntryRedirect;
	}
	
	@Override
	public String getURLView(LiferayPortletResponse liferayPortletResponse, 
	WindowState windowState) throws Exception {

	    return super.getURLView(liferayPortletResponse, windowState);
	}

	private GuestbookT _guestbookt;
	private final ModelResourcePermission<GuestbookT> _guestbookTModelResourcePermission;   
	private Logger logger = Logger.getLogger(this.getClass().getName());

}
