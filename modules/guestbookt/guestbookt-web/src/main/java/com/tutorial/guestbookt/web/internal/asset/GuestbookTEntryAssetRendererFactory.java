package com.tutorial.guestbookt.web.internal.asset;

import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.tutorial.guestbookt.constants.GuestbookTPortletKeys;
import com.tutorial.guestbookt.model.GuestbookTEntry;
import com.tutorial.guestbookt.service.GuestbookTEntryLocalService;
import com.tutorial.guestbookt.web.internal.security.permission.resource.GuestbookTEntryPermission;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;
import javax.servlet.ServletContext;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = {"javax.portlet.name=" + GuestbookTPortletKeys.GUESTBOOKT},
        service = AssetRendererFactory.class
)
public class GuestbookTEntryAssetRendererFactory 
	extends BaseAssetRendererFactory<GuestbookTEntry> {
	
    public GuestbookTEntryAssetRendererFactory() {
        setClassName(CLASS_NAME);
        setLinkable(_LINKABLE);
        setPortletId(GuestbookTPortletKeys.GUESTBOOKT);
        setSearchable(true);
        setSelectable(true);

    }

    @Override
    public AssetRenderer<GuestbookTEntry> getAssetRenderer(long classPK, int type)
            throws PortalException {

        GuestbookTEntry entry = 
        		_guestbookTEntryLocalService.getGuestbookTEntry(classPK);

        GuestbookTEntryAssetRenderer guestbookEntryAssetRenderer = 
        		new GuestbookTEntryAssetRenderer(entry, _guestbookTEntryModelResourcePermission);

        guestbookEntryAssetRenderer.setAssetRendererType(type);
        guestbookEntryAssetRenderer.setServletContext(_servletContext);

        return guestbookEntryAssetRenderer;
    }

    @Override
    public String getClassName() {
        return CLASS_NAME;
    }

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    public boolean hasPermission(PermissionChecker permissionChecker,
            long classPK, String actionId) throws Exception {

        GuestbookTEntry entry = _guestbookTEntryLocalService.getGuestbookTEntry(classPK);
        return GuestbookTEntryPermission.contains(permissionChecker, entry, actionId);
    }

    @Override
    public PortletURL getURLAdd(LiferayPortletRequest liferayPortletRequest,
            LiferayPortletResponse liferayPortletResponse, long classTypeId) {

        PortletURL portletURL = null;

        try {
            ThemeDisplay themeDisplay = (ThemeDisplay) liferayPortletRequest.getAttribute(WebKeys.THEME_DISPLAY);

            portletURL = liferayPortletResponse.createLiferayPortletURL(getControlPanelPlid(themeDisplay),
                    GuestbookTPortletKeys.GUESTBOOKT, PortletRequest.RENDER_PHASE);
            portletURL.setParameter("mvcPath", "/guestbookt/edit_entry");
            portletURL.setParameter("showback", Boolean.FALSE.toString());
        } catch (PortalException e) {
        }

        return portletURL;
    }

    @Override
    public PortletURL getURLView(LiferayPortletResponse liferayPortletResponse, WindowState windowState) {

        LiferayPortletURL liferayPortletURL
        = liferayPortletResponse.createLiferayPortletURL(
                GuestbookTPortletKeys.GUESTBOOKT, PortletRequest.RENDER_PHASE);

        try {
            liferayPortletURL.setWindowState(windowState);
        } catch (WindowStateException wse) {

        }
        return liferayPortletURL;
    }

    @Override
    public boolean isLinkable() {
        return _LINKABLE;
    }

    @Override
    public String getIconCssClass() {
        return "pencil";
    }

    @Reference(target = "(osgi.web.symbolicname=com.tutorial.guestbookt-web)",
            unbind = "-")
    public void setServletContext (ServletContext servletContext) {
        _servletContext = servletContext;
    }

    @Reference(unbind = "-")
    protected void setGuestbookTEntryLocalService(GuestbookTEntryLocalService guestbookTEntryLocalService) {
        _guestbookTEntryLocalService = guestbookTEntryLocalService;
    }


    private GuestbookTEntryLocalService _guestbookTEntryLocalService;
    
//    @Reference(target = "(osgi.web.symbolicname=com.tutorial.guestbookt.web)")
    private ServletContext _servletContext;
    private static final boolean _LINKABLE = true;
    public static final String CLASS_NAME = GuestbookTEntry.class.getName();
    public static final String TYPE = "entry";

    private ModelResourcePermission<GuestbookTEntry>
    _guestbookTEntryModelResourcePermission;
}
