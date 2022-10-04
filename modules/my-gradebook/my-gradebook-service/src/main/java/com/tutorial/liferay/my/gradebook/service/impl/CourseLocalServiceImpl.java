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
import com.tutorial.liferay.my.gradebook.model.Course;
import com.tutorial.liferay.my.gradebook.service.base.CourseLocalServiceBaseImpl;

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
	
	public List<Course> getCourses(long groupId, long myGradebookId) {
		return coursePersistence.findByG_G(groupId, myGradebookId);
	}
}