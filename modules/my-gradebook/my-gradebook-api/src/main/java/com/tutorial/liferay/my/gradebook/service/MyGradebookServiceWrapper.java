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

package com.tutorial.liferay.my.gradebook.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MyGradebookService}.
 *
 * @author Andrea Luzzi
 * @see MyGradebookService
 * @generated
 */
public class MyGradebookServiceWrapper
	implements MyGradebookService, ServiceWrapper<MyGradebookService> {

	public MyGradebookServiceWrapper() {
		this(null);
	}

	public MyGradebookServiceWrapper(MyGradebookService myGradebookService) {
		_myGradebookService = myGradebookService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _myGradebookService.getOSGiServiceIdentifier();
	}

	@Override
	public MyGradebookService getWrappedService() {
		return _myGradebookService;
	}

	@Override
	public void setWrappedService(MyGradebookService myGradebookService) {
		_myGradebookService = myGradebookService;
	}

	private MyGradebookService _myGradebookService;

}