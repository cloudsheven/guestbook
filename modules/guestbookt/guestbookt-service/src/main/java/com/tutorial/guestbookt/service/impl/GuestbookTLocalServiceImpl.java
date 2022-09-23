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

package com.tutorial.guestbookt.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.tutorial.guestbookt.exception.GuestbookNameException;
import com.tutorial.guestbookt.model.GuestbookT;
import com.tutorial.guestbookt.model.GuestbookTEntry;
import com.tutorial.guestbookt.service.GuestbookTEntryLocalService;
import com.tutorial.guestbookt.service.base.GuestbookTLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Andrea Luzzi
 */
@Component(property = "model.class.name=com.tutorial.guestbookt.model.GuestbookT", service = AopService.class)
public class GuestbookTLocalServiceImpl extends GuestbookTLocalServiceBaseImpl {

	public GuestbookT addGuestbook(long userId, String name, ServiceContext serviceContext) throws PortalException {

		long groupId = serviceContext.getScopeGroupId();

		User user = userLocalService.getUserById(userId);

		Date now = new Date();

		validate(name);

		long guestbookTId = counterLocalService.increment();

		GuestbookT guestbook = guestbookTPersistence.create(guestbookTId);

		guestbook.setUuid(serviceContext.getUuid());
		guestbook.setUserId(userId);
		guestbook.setGroupId(groupId);
		guestbook.setCompanyId(user.getCompanyId());
		guestbook.setUserName(user.getFullName());
		guestbook.setCreateDate(serviceContext.getCreateDate(now));
		guestbook.setModifiedDate(serviceContext.getModifiedDate(now));
		guestbook.setName(name);
		guestbook.setExpandoBridgeAttributes(serviceContext);

		guestbookTPersistence.update(guestbook);

		resourceLocalService.addResources(user.getCompanyId(), groupId, userId,
			    GuestbookT.class.getName(), guestbookTId, false, true, true);
		
		return guestbook;
	}

	public GuestbookT deleteGuestbookT(long guestbookTId, ServiceContext serviceContext)
			throws PortalException, SystemException {

		GuestbookT guestbookT = getGuestbookT(guestbookTId);

		List<GuestbookTEntry> entries = _guestbookTEntryLocalService
				.getGuestbookTEntries(serviceContext.getScopeGroupId(), guestbookTId);

		for (GuestbookTEntry entry : entries) {
			_guestbookTEntryLocalService.deleteGuestbookTEntry(entry.getEntryId());

		}

		guestbookT = deleteGuestbookT(guestbookT);

		resourceLocalService.deleteResource(serviceContext.getCompanyId(),
			    GuestbookT.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
			    guestbookTId);
		
		return guestbookT;
	}

	public List<GuestbookT> getGuestbooks(long groupId) {

		return guestbookTPersistence.findByGroupId(groupId);
	}

	public List<GuestbookT> getGuestbooks(long groupId, int start, int end, OrderByComparator<GuestbookT> obc) {

		return guestbookTPersistence.findByGroupId(groupId, start, end, obc);
	}

	public List<GuestbookT> getGuestbooks(long groupId, int start, int end) {

		return guestbookTPersistence.findByGroupId(groupId, start, end);
	}

	public int getGuestbooksCount(long groupId) {

		return guestbookTPersistence.countByGroupId(groupId);
	}

	public GuestbookT updateGuestbookT(long userId, long guestbookTId, String name, ServiceContext serviceContext)
			throws PortalException, SystemException {

		Date now = new Date();

		validate(name);

		GuestbookT guestbookT = getGuestbookT(guestbookTId);

		User user = userLocalService.getUser(userId);

		guestbookT.setUserId(userId);
		guestbookT.setUserName(user.getFullName());
		guestbookT.setModifiedDate(serviceContext.getModifiedDate(now));
		guestbookT.setName(name);
		guestbookT.setExpandoBridgeAttributes(serviceContext);

		guestbookTPersistence.update(guestbookT);

		resourceLocalService.updateResources(serviceContext.getCompanyId(),
			    serviceContext.getScopeGroupId(), 
			    GuestbookT.class.getName(), guestbookTId,
			    serviceContext.getModelPermissions());
		
		return guestbookT;
	}

	protected void validate(String name) throws PortalException {
		if (Validator.isNull(name)) {
			throw new GuestbookNameException();
		}
	}

	@Reference
	private GuestbookTEntryLocalService _guestbookTEntryLocalService;
}