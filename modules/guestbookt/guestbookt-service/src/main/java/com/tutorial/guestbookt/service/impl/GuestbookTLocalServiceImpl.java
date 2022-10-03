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

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetLinkConstants;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
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
@Component(
		property = "model.class.name=com.tutorial.guestbookt.model.GuestbookT", 
		service = AopService.class
)
public class GuestbookTLocalServiceImpl extends GuestbookTLocalServiceBaseImpl {

	@Indexable(type = IndexableType.REINDEX)
	public GuestbookT addGuestbook(
			long userId, String name, ServiceContext serviceContext) 
					throws PortalException {

		long groupId = serviceContext.getScopeGroupId();

		User user = userLocalService.getUserById(userId);

		Date now = new Date();

		validate(name);

		long guestbookTId = counterLocalService.increment();

		GuestbookT guestbookt = guestbookTPersistence.create(guestbookTId);

		guestbookt.setUuid(serviceContext.getUuid());
		guestbookt.setUserId(userId);
		guestbookt.setGroupId(groupId);
		guestbookt.setCompanyId(user.getCompanyId());
		guestbookt.setUserName(user.getFullName());
		guestbookt.setCreateDate(serviceContext.getCreateDate(now));
		guestbookt.setModifiedDate(serviceContext.getModifiedDate(now));
		guestbookt.setName(name);
		guestbookt.setExpandoBridgeAttributes(serviceContext);
		
		guestbookt.setStatus(WorkflowConstants.STATUS_DRAFT);
		guestbookt.setStatusByUserId(userId);
		guestbookt.setStatusByUserName(user.getFullName());
		guestbookt.setStatusDate(serviceContext.getModifiedDate(null));

		guestbookTPersistence.update(guestbookt);

		resourceLocalService.addResources(user.getCompanyId(), groupId, userId,
			    GuestbookT.class.getName(), guestbookTId, false, true, true);
		
		AssetEntry assetEntry = assetEntryLocalService.updateEntry(userId,
                groupId, guestbookt.getCreateDate(),
                guestbookt.getModifiedDate(), GuestbookT.class.getName(),
                guestbookTId, guestbookt.getUuid(), 0,
                serviceContext.getAssetCategoryIds(),
                serviceContext.getAssetTagNames(), true, true, null, null, null, null,
                ContentTypes.TEXT_HTML, guestbookt.getName(), null, null, null,
                null, 0, 0, null);

		assetLinkLocalService.updateLinks(userId, assetEntry.getEntryId(),
                serviceContext.getAssetLinkEntryIds(),
                AssetLinkConstants.TYPE_RELATED);
		
		WorkflowHandlerRegistryUtil.startWorkflowInstance(guestbookt.getCompanyId(), 
	            guestbookt.getGroupId(), guestbookt.getUserId(), GuestbookT.class.getName(), 
	            guestbookt.getPrimaryKey(), guestbookt, serviceContext);
		
		return guestbookt;
	}

	@Indexable(type = IndexableType.REINDEX)
	public GuestbookT updateGuestbookT(
			long userId, long guestbookTId, 
			String name, ServiceContext serviceContext)
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
		
		AssetEntry assetEntry = assetEntryLocalService.updateEntry(guestbookT.getUserId(),
				guestbookT.getGroupId(), guestbookT.getCreateDate(),
				guestbookT.getModifiedDate(), GuestbookT.class.getName(),
				guestbookTId, guestbookT.getUuid(), 0,
				serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(), true, true, guestbookT.getCreateDate(), 
				null, null, null, ContentTypes.TEXT_HTML, guestbookT.getName(), null, null, 
				null, null, 0, 0, serviceContext.getAssetPriority());
		
		assetLinkLocalService.updateLinks(serviceContext.getUserId(),
				assetEntry.getEntryId(), serviceContext.getAssetLinkEntryIds(),
				AssetLinkConstants.TYPE_RELATED);
		
		return guestbookT;
	}
	
	@Indexable(type = IndexableType.DELETE)
	public GuestbookT deleteGuestbookT(
			long guestbookTId, ServiceContext serviceContext) 
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
		
		AssetEntry assetEntry = assetEntryLocalService.fetchEntry(
				GuestbookT.class.getName(), guestbookTId);
		
		assetLinkLocalService.deleteLinks(assetEntry.getEntryId());
		
		assetEntryLocalService.deleteEntry(assetEntry);
		
		workflowInstanceLinkLocalService.deleteWorkflowInstanceLinks(
			    guestbookT.getCompanyId(), guestbookT.getGroupId(),
			    GuestbookT.class.getName(), guestbookT.getGuestbookTId());
		
		return guestbookT;
	}
	
	public GuestbookT updateStatus(long userId, long guestbookTId, int status,
			ServiceContext serviceContext) throws PortalException,
			SystemException {

		User user = userLocalService.getUser(userId);
		GuestbookT guestbookt = getGuestbookT(guestbookTId);

		guestbookt.setStatus(status);
		guestbookt.setStatusByUserId(userId);
		guestbookt.setStatusByUserName(user.getFullName());
		guestbookt.setStatusDate(new Date());

		guestbookTPersistence.update(guestbookt);
		
		if (status == WorkflowConstants.STATUS_APPROVED) {

			assetEntryLocalService.updateVisible(GuestbookT.class.getName(),
					guestbookTId, true);

		} else {

			assetEntryLocalService.updateVisible(GuestbookT.class.getName(),
					guestbookTId, false);
		}

		return guestbookt;
	}
	
//	GETTER
	public List<GuestbookT> getGuestbooks(long groupId) {

		return guestbookTPersistence.findByGroupId(groupId);
	}

	public List<GuestbookT> getGuestbooks(
			long groupId, int start, int end, OrderByComparator<GuestbookT> obc) {

		return guestbookTPersistence.findByGroupId(groupId, start, end, obc);
	}

	public List<GuestbookT> getGuestbooks(long groupId, int start, int end) {

		return guestbookTPersistence.findByGroupId(groupId, start, end);
	}

	public int getGuestbooksCount(long groupId) {

		return guestbookTPersistence.countByGroupId(groupId);
	}
	
	public List<GuestbookT> getGuestbooks(long groupId, int status)
			throws SystemException {
			
			return guestbookTPersistence.findByG_S(
				groupId, WorkflowConstants.STATUS_APPROVED);
	}
	
	protected void validate(String name) throws PortalException {
		if (Validator.isNull(name)) {
			throw new GuestbookNameException();
		}
	}

	@Reference
	private GuestbookTEntryLocalService _guestbookTEntryLocalService;
}