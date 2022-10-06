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
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;
import com.tutorial.liferay.my.gradebook.exception.CourseNameException;
import com.tutorial.liferay.my.gradebook.model.Course;
import com.tutorial.liferay.my.gradebook.service.base.CourseLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Andrea Luzzi
 */
@Component(
	property = "model.class.name=com.tutorial.liferay.my.gradebook.model.Course",
	service = AopService.class
)
public class CourseLocalServiceImpl extends CourseLocalServiceBaseImpl {
	
	public Course addCourse(
			long userId, long myGradebookId, String name, 
			ServiceContext serviceContext)
	throws PortalException{
		
		long groupId = serviceContext.getScopeGroupId();
		
		User user = userLocalService.getUserById(userId);
		
		Date now = new Date();
		
		validate (name);
		
		long courseId = counterLocalService.increment();
		
		Course course = coursePersistence.create(courseId);
		
		course.setUuid(serviceContext.getUuid());
		course.setUserId(userId);
		course.setGroupId(groupId);
		course.setCompanyId(user.getCompanyId());
		course.setUserName(user.getFullName());
		course.setCreateDate(serviceContext.getCreateDate(now));
		course.setModifiedDate(serviceContext.getModifiedDate(now));
		course.setExpandoBridgeAttributes(serviceContext);
		course.setMyGradebookId(myGradebookId);
		
		course.setName(name);		
		
		coursePersistence.update(course);
		
		resourceLocalService.addResources(
				user.getCompanyId(), 
				groupId, 
				userId, 
				Course.class.getName(),
				courseId,
				false,
				true,
				true);
		

	}
	
	public List<Course> getCourses(long groupId, long myGradebookId) {
		return coursePersistence.findByG_G(groupId, myGradebookId);
	}
	
	public Course updateStatus(
			long userId, long myGradebookId, long courseId, int status, 
			ServiceContext serviceContext)
	throws PortalException {
		
		return null;
	}
	protected void validate(String name)
	throws PortalException{
		
		if(Validator.isNull(name)) {
			throw new CourseNameException();
		}		
	}
}