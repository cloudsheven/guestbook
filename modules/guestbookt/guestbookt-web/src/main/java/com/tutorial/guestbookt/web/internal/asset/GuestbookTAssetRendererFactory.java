package com.tutorial.guestbookt.web.internal.asset;

import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.tutorial.guestbookt.constants.GuestbookTPortletKeys;
import com.tutorial.guestbookt.model.GuestbookT;
import com.tutorial.guestbookt.service.GuestbookTLocalService;
import com.tutorial.guestbookt.web.internal.security.permission.resource.GuestbookTPermission;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.servlet.ServletContext;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		property = {"javax.portlet.name=" + GuestbookTPortletKeys.GUESTBOOKT}, 
		service = AssetRendererFactory.class
)
public class GuestbookTAssetRendererFactory 
	extends BaseAssetRendererFactory<GuestbookT> {
	
	  public GuestbookTAssetRendererFactory() {
		    setClassName(CLASS_NAME);
		    setLinkable(_LINKABLE);
		    setPortletId(GuestbookTPortletKeys.GUESTBOOKT); setSearchable(true);
		    setSelectable(true); 
	  } 
	  
	  
//	 Add the other methods here	  
	  @Override
	  public AssetRenderer<GuestbookT> getAssetRenderer(long classPK, int type) 
	  throws PortalException {
	    
	    GuestbookT guestbookt = _guestbookTLocalService.getGuestbookT(classPK);

	    GuestbookTAssetRenderer guestbookTAssetRenderer = 
	    new GuestbookTAssetRenderer(guestbookt, _guestbookTModelResourcePermission);

	    guestbookTAssetRenderer.setAssetRendererType(type);
	    guestbookTAssetRenderer.setServletContext(_servletContext);

	    return guestbookTAssetRenderer;
	  }
	  
//	  GETTER	  
	  @Override
	  public String getClassName() {
		  return CLASS_NAME;
	  }
	  
	  @Override
	  public String getType() {
		  return TYPE;
	  }
	  
//	  PORTLET CODE
	  @Override
	  public PortletURL getURLAdd(LiferayPortletRequest liferayPortletRequest,
			  LiferayPortletResponse liferayPortletResponse, long classTypeId) {
		  PortletURL portletURL = null;
		  
		  try {
			  ThemeDisplay themeDisplay = (ThemeDisplay) 
					  liferayPortletRequest.getAttribute(WebKeys.THEME_DISPLAY);
			  
			  portletURL = liferayPortletResponse.createLiferayPortletURL(getControlPanelPlid(themeDisplay),
					  GuestbookTPortletKeys.GUESTBOOKT, PortletRequest.RENDER_PHASE);
			  portletURL.setParameter("mvcPath", "/guestbookt_admin/edit_guestbookt.jsp");
			  portletURL.setParameter("showback", Boolean.FALSE.toString());
			  
		  } catch (PortalException e) {
			  
			  logger.log(Level.SEVERE, e.getMessage()); 
			  
		  }
		  
		  return portletURL;
	  }
	  	  
	  @Override
	  public boolean isLinkable() {
		  return _LINKABLE;
	  }
	  
	  @Override
	  public String getIconCssClass() {
		  return "bookmarks";
	  }
	  
	  @Reference(target = "(osgi.web.symbolicname=com.tutorial.guestbookt-web)",
			  unbind = "-")
	  public void setServletContext(ServletContext servletContext) {
		  _servletContext = servletContext;
	  }
	  
	  @Reference(unbind = "-")
	  protected void setGuestbookLocalService(GuestbookTLocalService guestbookTLocalService) {
		  _guestbookTLocalService = guestbookTLocalService; 
	  }  
	  
	  @Override
	  public boolean hasPermission(PermissionChecker permissionChecker, 
	  long classPK, String actionId) throws Exception {

	    GuestbookT guestbookt = _guestbookTLocalService.getGuestbookT(classPK);
	    long groupId = guestbookt.getGroupId();
	    return GuestbookTPermission.contains(permissionChecker, groupId, 
	    actionId);
	  }

	  

	  private ServletContext _servletContext;
	  private GuestbookTLocalService _guestbookTLocalService;
	  private static final boolean _LINKABLE = true;
	  public static final String CLASS_NAME = GuestbookT.class.getName();
	  public static final String TYPE = "guestbookt";
	  private Logger logger = Logger.getLogger(this.getClass().getName());
	  private ModelResourcePermission<GuestbookT> _guestbookTModelResourcePermission;
}
