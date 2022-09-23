package com.tutorial.guestbookt.web.internal.security.permission.resource;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.tutorial.guestbookt.model.GuestbookT;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true)
public class GuestbookTModelPermission {

	  public static boolean contains(
	            PermissionChecker permissionChecker, GuestbookT guestbookt, String actionId) throws PortalException {

	        return _guestbookTModelResourcePermission.contains(permissionChecker, guestbookt, actionId);
	    }

	    public static boolean contains(
	            PermissionChecker permissionChecker, long guestbookTId, String actionId) throws PortalException {

	        return _guestbookTModelResourcePermission.contains(permissionChecker, guestbookTId, actionId);
	    }

	    @Reference(
	            target = "(model.class.name=com.tutorial.guestbookt.model.GuestbookT)", 
	            unbind = "-")
	    protected void setEntryModelPermission(ModelResourcePermission<GuestbookT> modelResourcePermission) {

	        _guestbookTModelResourcePermission = modelResourcePermission;
	    }

	    private static ModelResourcePermission<GuestbookT>_guestbookTModelResourcePermission;

}
