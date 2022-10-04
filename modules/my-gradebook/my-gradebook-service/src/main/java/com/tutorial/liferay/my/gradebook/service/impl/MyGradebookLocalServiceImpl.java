/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.tutorial.liferay.my.gradebook.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;
import com.tutorial.liferay.my.gradebook.exception.MyGradebookNameException;
import com.tutorial.liferay.my.gradebook.model.Course;
import com.tutorial.liferay.my.gradebook.model.MyGradebook;
import com.tutorial.liferay.my.gradebook.service.CourseLocalService;
import com.tutorial.liferay.my.gradebook.service.base.MyGradebookLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Andrea Luzzi
 */
@Component(
	property = "model.class.name=com.tutorial.liferay.my.gradebook.model.MyGradebook",
	service = AopService.class
)
public class MyGradebookLocalServiceImpl
	extends MyGradebookLocalServiceBaseImpl {
	
	public MyGradebook addMyGradebook(
			long userId, String name, ServiceContext serviceContext)
	throws PortalException {
		
		long groupId = serviceContext.getScopeGroupId();
		
		User user = userLocalService.getUserById(userId);
		
		Date now = new Date();
		
		validate(name);
		
		long myGradebookId = counterLocalService.increment();
		
		MyGradebook myGradebook = myGradebookPersistence.create(myGradebookId);
		
		myGradebook.setUuid(serviceContext.getUuid());
		myGradebook.setUserId(userId);
		myGradebook.setGroupId(groupId);
		myGradebook.setCompanyId(user.getCompanyId());
		myGradebook.setUserName(user.getFullName());
		myGradebook.setCreateDate(serviceContext.getCreateDate(now));
		myGradebook.setModifiedDate(serviceContext.getModifiedDate(now));
		myGradebook.setName(name);
		myGradebook.setExpandoBridgeAttributes(serviceContext);
		
		myGradebookPersistence.update(myGradebook);
		
		resourceLocalService.addResources(
				user.getCompanyId(),
				groupId,
				userId,
				MyGradebook.class.getName(),
				myGradebookId,
				false,
				true,
				true);
		
		return myGradebook;
	}
	public MyGradebook deleteMyGradebook(
			long myGradebookId, ServiceContext serviceContext)
	throws PortalException, SystemException  {
		
		MyGradebook myGradebook = getMyGradebook(myGradebookId);
		
		List<Course> courses = _courseLocalService
				.getCourses(serviceContext.getScopeGroupId(), myGradebookId);
		
		for(Course course : courses) {
			_courseLocalService.deleteCourse(course.getCourseId());			
		}
		
		myGradebook = deleteMyGradebook(myGradebook);
		
		resourceLocalService.deleteResource(
				serviceContext.getCompanyId(), 
				MyGradebook.class.getName(),
				ResourceConstants.SCOPE_INDIVIDUAL,
				myGradebookId);
		
		return myGradebook;
	}
	
	public MyGradebook updateMyGradebook(
			long userId, long myGradebookId, String name, 
			ServiceContext serviceContext)
	throws PortalException, SystemException {
		
		Date now = new Date();
		
		validate(name);
		
		MyGradebook myGradebook = getMyGradebook(myGradebookId);
		
		User user = userLocalService.getUser(userId);
		
		myGradebook.setUserId(userId);
		myGradebook.setUserName(user.getFullName());
		myGradebook.setModifiedDate(serviceContext.getModifiedDate(now));
		myGradebook.setName(name);
		myGradebook.setExpandoBridgeAttributes(serviceContext);
		
		myGradebookPersistence.update(myGradebook);
		
		resourceLocalService.updateResources(
				serviceContext.getCompanyId(), 
				serviceContext.getScopeGroupId(), 
				MyGradebook.class.getName(), 
				myGradebookId,
				serviceContext.getModelPermissions());
		
		return myGradebook;
	}
	
	protected void validate(String name) throws PortalException {
		if (Validator.isNull(name)) {
			throw new MyGradebookNameException();
		}
	}
	
	@Reference
	private CourseLocalService _courseLocalService;
}