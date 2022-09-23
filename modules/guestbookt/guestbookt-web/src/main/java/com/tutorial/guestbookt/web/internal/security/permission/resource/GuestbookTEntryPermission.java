package com.tutorial.guestbookt.web.internal.security.permission.resource;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.tutorial.guestbookt.model.GuestbookTEntry;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true)
public class GuestbookTEntryPermission {
	
	  public static boolean contains(
	            PermissionChecker permissionChecker, GuestbookTEntry entry, String actionId) throws PortalException {

	        return _guestbookTEntryModelResourcePermission.contains(permissionChecker, entry, actionId);
	    }
	  
	    public static boolean contains(
	            PermissionChecker permissionChecker, long entryId, String actionId) throws PortalException {

	        return _guestbookTEntryModelResourcePermission.contains(permissionChecker, entryId, actionId);
	    }

	    @Reference(
	            target = "(model.class.name=com.tutorial.guestbookt.model.GuestbookTEntry)", 
	            unbind = "-")
	    protected void setEntryModelPermission(ModelResourcePermission<GuestbookTEntry> modelResourcePermission) {

	    	_guestbookTEntryModelResourcePermission = modelResourcePermission;
	    }

	    private static ModelResourcePermission<GuestbookTEntry> _guestbookTEntryModelResourcePermission;


}
