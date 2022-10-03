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
import com.tutorial.guestbookt.exception.GuestbookEntryEmailException;
import com.tutorial.guestbookt.exception.GuestbookEntryMessageException;
import com.tutorial.guestbookt.exception.GuestbookEntryNameException;
import com.tutorial.guestbookt.model.GuestbookTEntry;
import com.tutorial.guestbookt.service.base.GuestbookTEntryLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Andrea Luzzi
 */
@Component(property = "model.class.name=com.tutorial.guestbookt.model.GuestbookTEntry", service = AopService.class)
public class GuestbookTEntryLocalServiceImpl extends GuestbookTEntryLocalServiceBaseImpl {

	
	@Indexable(type = IndexableType.REINDEX)
	public GuestbookTEntry addGuestbookTEntry(
			long userId, long guestbookTId, 
			String name, String email, String message,
			ServiceContext serviceContext) 
					throws PortalException {

		long groupId = serviceContext.getScopeGroupId();

		User user = userLocalService.getUserById(userId);

		Date now = new Date();

		validate(name, email, message);

		long entryId = counterLocalService.increment();

		GuestbookTEntry entry = guestbookTEntryPersistence.create(entryId);

		entry.setUuid(serviceContext.getUuid());
		entry.setUserId(userId);
		entry.setGroupId(groupId);
		entry.setCompanyId(user.getCompanyId());
		entry.setUserName(user.getFullName());
		entry.setCreateDate(serviceContext.getCreateDate(now));
		entry.setModifiedDate(serviceContext.getModifiedDate(now));
		entry.setExpandoBridgeAttributes(serviceContext);
		entry.setGuestbookTId(guestbookTId);
		entry.setName(name);
		entry.setEmail(email);
		entry.setMessage(message);
		
		entry.setStatus(WorkflowConstants.STATUS_DRAFT);
		entry.setStatusByUserId(userId);
		entry.setStatusByUserName(user.getFullName());
		entry.setStatusDate(serviceContext.getModifiedDate(null));

		guestbookTEntryPersistence.update(entry);

		// Calls to other Liferay frameworks go here

		resourceLocalService.addResources(user.getCompanyId(), groupId, userId,
			    GuestbookTEntry.class.getName(), entryId, false, true, true);
		
		AssetEntry assetEntry = assetEntryLocalService.updateEntry(userId,
                groupId, entry.getCreateDate(), entry.getModifiedDate(),
                GuestbookTEntry.class.getName(), entryId, entry.getUuid(), 0,
                serviceContext.getAssetCategoryIds(),
                serviceContext.getAssetTagNames(), true, true, null, null, null, null,
                ContentTypes.TEXT_HTML, entry.getMessage(), null, null, null,
                null, 0, 0, null);

		assetLinkLocalService.updateLinks(userId, assetEntry.getEntryId(),
                serviceContext.getAssetLinkEntryIds(),
                AssetLinkConstants.TYPE_RELATED);
		
		WorkflowHandlerRegistryUtil.startWorkflowInstance(entry.getCompanyId(), 
				entry.getGroupId(), entry.getUserId(), GuestbookTEntry.class.getName(), 
				entry.getPrimaryKey(), entry, serviceContext);
		
		return entry;
	}
	
	@Indexable(type = IndexableType.REINDEX)
	public GuestbookTEntry updateGuestbookEntry(
			long userId, long guestbookId, long entryId, 
			String name, String email, String message, 
			ServiceContext serviceContext) 
					throws PortalException, SystemException {
		
		Date now = new Date();
		
		validate(name, email, message);
		
		GuestbookTEntry entry = guestbookTEntryPersistence.findByPrimaryKey(entryId);
		
		User user = userLocalService.getUserById(userId);
		
		entry.setUserId(userId);
		entry.setUserName(user.getFullName());
		entry.setModifiedDate(serviceContext.getModifiedDate(now));
		entry.setName(name);
		entry.setEmail(email);
		entry.setMessage(message);
		entry.setExpandoBridgeAttributes(serviceContext);
		
		guestbookTEntryPersistence.update(entry);
		
		// Integrate with Liferay frameworks here.
		
		resourceLocalService.updateResources(
				user.getCompanyId(), serviceContext.getScopeGroupId(), 
				GuestbookTEntry.class.getName(), entryId, 
				serviceContext.getModelPermissions());
		
		AssetEntry assetEntry = assetEntryLocalService.updateEntry(userId,
				serviceContext.getScopeGroupId(),
				entry.getCreateDate(), entry.getModifiedDate(),
				GuestbookTEntry.class.getName(), entryId, entry.getUuid(),
				0, serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(), true, true,
				entry.getCreateDate(), null, null, null,
				ContentTypes.TEXT_HTML, entry.getMessage(), null,
				null, null, null, 0, 0,
				serviceContext.getAssetPriority());
		
		assetLinkLocalService.updateLinks(userId, assetEntry.getEntryId(),
				serviceContext.getAssetLinkEntryIds(),
				AssetLinkConstants.TYPE_RELATED);
		
		return entry;
	}	
	
	@Indexable(type = IndexableType.DELETE)
	public GuestbookTEntry deleteGuestbookEntry(GuestbookTEntry entry) 
			throws PortalException {
		
		guestbookTEntryPersistence.remove(entry);
		
		resourceLocalService.deleteResource(
				entry.getCompanyId(), GuestbookTEntry.class.getName(),
				ResourceConstants.SCOPE_INDIVIDUAL, entry.getEntryId());
		
		AssetEntry assetEntry = assetEntryLocalService.fetchEntry(
				GuestbookTEntry.class.getName(), entry.getEntryId());
		
		assetLinkLocalService.deleteLinks(assetEntry.getEntryId());
		
		assetEntryLocalService.deleteEntry(assetEntry);
		
		workflowInstanceLinkLocalService.deleteWorkflowInstanceLinks(
			    entry.getCompanyId(), entry.getGroupId(),
			    GuestbookTEntry.class.getName(), entry.getEntryId());
		
		return entry;
	}
	
	public GuestbookTEntry deleteGuestbookEntry(long entryId) 
			throws PortalException {
		
		GuestbookTEntry entry = guestbookTEntryPersistence.findByPrimaryKey(entryId);		
		
		return deleteGuestbookEntry(entry);
	}
	
	
//	GETTER
	public List<GuestbookTEntry> getGuestbookTEntries(long groupId, long guestbookId) {
		return guestbookTEntryPersistence.findByG_G(groupId, guestbookId);
		
	}
	
	public List<GuestbookTEntry> getGuestbookTEntries(long groupId, long guestbookId,
			int start, int end) throws SystemException {
		
		return guestbookTEntryPersistence.findByG_G(groupId, guestbookId, start,
				end);
	}
	
	public List<GuestbookTEntry> getGuestbookTEntries(long groupId, long guestbookId,
			int start, int end, OrderByComparator<GuestbookTEntry> obc) {
		
		return guestbookTEntryPersistence.findByG_G(groupId, guestbookId, start,
				end, obc);
	}
	
	public GuestbookTEntry getGuestbookEntry(long entryId) 
			throws PortalException {
		return guestbookTEntryPersistence.findByPrimaryKey(entryId);
	}
	
	public int getGuestbookEntriesCount(long groupId, long guestbookId) {
		return guestbookTEntryPersistence.countByG_G(groupId, guestbookId);
	}
	
	public List<GuestbookTEntry> getGuestbookTEntries(
			long groupId, long guestbookId, int status, int start, int end)
			throws SystemException {

			return guestbookTEntryPersistence.findByG_G_S(
				groupId, guestbookId, WorkflowConstants.STATUS_APPROVED);
		}

		public int getGuestbookEntriesCount(
			long groupId, long guestbookId, int status)
			throws SystemException {

			return guestbookTEntryPersistence.countByG_G_S(
				groupId, guestbookId, WorkflowConstants.STATUS_APPROVED);
		}
	
	protected void validate(String name, String email, String entry)
			throws PortalException {
		
		if (Validator.isNull(name)) {
			throw new GuestbookEntryNameException();
		}
		
		if (!Validator.isEmailAddress(email)) {
			throw new GuestbookEntryEmailException();
		}
		
		if (Validator.isNull(entry)) {
			throw new GuestbookEntryMessageException();
		}
	}
	
	public GuestbookTEntry updateStatus(long userId, long guestbookId, long entryId, int status,
		   	ServiceContext serviceContext) throws PortalException,
		   	SystemException {

		   User user = userLocalService.getUser(userId);
		   GuestbookTEntry entry = getGuestbookEntry(entryId);

		   entry.setStatus(status);
		   entry.setStatusByUserId(userId);
		   entry.setStatusByUserName(user.getFullName());
		   entry.setStatusDate(new Date());

		   guestbookTEntryPersistence.update(entry);

		   if (status == WorkflowConstants.STATUS_APPROVED) {

		   	assetEntryLocalService.updateVisible(GuestbookTEntry.class.getName(),
		   			entryId, true);

		   } else {

		   	assetEntryLocalService.updateVisible(GuestbookTEntry.class.getName(),
		   			entryId, false);
		   }

		   return entry;
		}
}