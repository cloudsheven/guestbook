package com.tutorial.guestbookt.application.list;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.model.Portlet;
import com.tutorial.guestbookt.constants.GuestbookTPortletKeys;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	property = {
			"panel.app.order:Integer=300",
			"panel.category.key=" + PanelCategoryKeys.SITE_ADMINISTRATION_CONTENT
	},
	service = PanelApp.class
		
)
public class GuestbookTAdminPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return GuestbookTPortletKeys.GUESTBOOKT_ADMIN;
	} 
    
	@Override
	@Reference(
			target = "(javax.portlet.name=" + GuestbookTPortletKeys.GUESTBOOKT_ADMIN + ")",
			unbind = "-"
			)
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
    }
}
