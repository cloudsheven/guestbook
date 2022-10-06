package com.tutorial.liferay.my.gradebook.application.list;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.model.Portlet;
import com.tutorial.liferay.my.gradebook.constants.MyGradebookPortletKeys;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		property = {
				"panel.app.order:Integer=300",
				"panel.category.key=" + PanelCategoryKeys.SITE_ADMINISTRATION_CONTENT
		},
		service = PanelApp.class)
public class MyGradebookAdminPanelApp extends BasePanelApp{
	
	@Override
	public String getPortletId() {
		return MyGradebookPortletKeys.GRADEBOOK_ADMIN;
	}
	
	@Override
	@Reference(
			target = "(javax.portlet.name=" + MyGradebookPortletKeys.GRADEBOOK_ADMIN + ")",
			unbind =  "-")	
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}
}
