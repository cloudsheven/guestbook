package com.tutorial.liferay.my.gradebook.web.internal.security.permission.resource;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.tutorial.liferay.my.gradebook.model.MyGradebook;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true)
public class MyGradebookModelPermission {
	
	public static boolean contains(
			PermissionChecker permissionChecker, MyGradebook myGradebook, String actionId) 
	throws PortalException{
		return _myGradebookModelResourcePermission.contains(permissionChecker, myGradebook, actionId);
	}
	
	public static boolean contains(
			PermissionChecker permissionChecker, long myGradebookId, String actionId)
	throws PortalException {
		return _myGradebookModelResourcePermission.contains(permissionChecker, myGradebookId, actionId)
;	}
	
	@Reference(
			target = "(model.class.name=com.tutorial.liferay.my.gradebook.model.MyGradebook)",
			unbind = "-")
	protected void setEntryModelPermission(
			ModelResourcePermission<MyGradebook> modelResourcePermission) {
		_myGradebookModelResourcePermission = modelResourcePermission;
	}	
	
	private static ModelResourcePermission<MyGradebook> _myGradebookModelResourcePermission;
}
