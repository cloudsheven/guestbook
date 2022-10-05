package com.tutorial.liferay.my.gradebook.web.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.PortletParameterUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.tutorial.liferay.my.gradebook.constants.MyGradebookPortletKeys;
import com.tutorial.liferay.my.gradebook.model.MyGradebook;
import com.tutorial.liferay.my.gradebook.service.MyGradebookLocalService;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletParameters;
import javax.portlet.filter.PortletParametersWrapper;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		property = {
				"javax.portlet.version=3.0",
				"com.liferay.portlet.display-category=category.hidden",
				"com.liferay.portlet.scopeable=true",
				"javax.portlet.display-name=" + MyGradebookPortletKeys.GRADEBOOK_ADMIN_NAME,
				"javax.portlet.expiration-cache=0",
				"javax.portlet.init-param.portlet-title-based-navigation=true",
				"javax.portlet.init-param.template-path=/",
				"javax.portlet.init-param.view-template=/my-gradebook-admin/view.jsp",
				"javax.portlet.name=" + MyGradebookPortletKeys.GRADEBOOK_ADMIN,
				"javax.portlet.resource-bundle=contet.Language",
				"javax.portlet.security-role-ref=administrator",
				"javax.portlet.supports.mime-type=text/html",
				"com.liferay.portlet.add-default-resource=true"
		},
		service = Portlet.class
)
public class MyGradebookAdminPortlet  extends MVCPortlet {
	
	public void addMyGradebook(ActionRequest request, ActionResponse response)
	throws PortalException {
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(MyGradebook.class.getName(), request);
		
		String name = ParamUtil.getString(request, "name");
		
		try {
			_myGradebookLocalService.addMyGradebook(serviceContext.getUserId(), name, serviceContext);
			
			SessionMessages.add(request, "myGradebookAdded");
			
		} catch (PortalException pe) {
			Logger.getLogger(MyGradebookAdminPortlet.class.getName()).log(Level.SEVERE, null, pe);
			
//			TODO controllare il set dei parameter
			response.getRenderParameters().setValue("mvcPath", "/my-gradebook-admin/edit_my_gradebook.jsp");
			
			SessionErrors.add(request, pe.getClass().getName());
		}
	}
	
	public void deleteMyGradebook(ActionRequest request, ActionResponse response)
	throws PortalException {
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(MyGradebook.class.getName(), request);
		
		long myGradebookId = ParamUtil.getLong(request, "myGradebookId");
		
		try {
			
			_myGradebookLocalService.deleteMyGradebook(myGradebookId, serviceContext);
			
			SessionMessages.add(request, "myGradebookDeleted");
			
		} catch (PortalException pe) {
			
			Logger.getLogger(MyGradebook.class.getName()).log(Level.SEVERE, null, pe);
			
			SessionErrors.add(request, pe.getClass().getName());
		}
	}
	
	public void updateMyGradebook(ActionRequest request, ActionResponse response)
	throws PortalException {
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(MyGradebook.class.getName(), request);
		
		String name = ParamUtil.getString(request, "name");
		
		long myGradebookId = ParamUtil.getLong(request, "myGradebookId");
		
		try {
			_myGradebookLocalService.updateMyGradebook(
					serviceContext.getUserId(),
					myGradebookId,
					name,
					serviceContext);
			
		} catch (PortalException pe) {

			Logger.getLogger(MyGradebookAdminPortlet.class.getName()).log(Level.SEVERE, null, pe);
			
			response.getRenderParameters().setValue("mvcPath", "/my-gradebook-admin/edit_my_gradebook.jsp");
			
			SessionErrors.add(request, pe.getClass().getName());
		}
	}
	
	@Reference
	private MyGradebookLocalService _myGradebookLocalService;
}
