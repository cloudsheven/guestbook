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

package com.tutorial.guestbookt.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;
import com.liferay.portal.kernel.model.WorkflowedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the GuestbookT service. Represents a row in the &quot;GBT_GuestbookT&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.tutorial.guestbookt.model.impl.GuestbookTModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.tutorial.guestbookt.model.impl.GuestbookTImpl</code>.
 * </p>
 *
 * @author Andrea Luzzi
 * @see GuestbookT
 * @generated
 */
@ProviderType
public interface GuestbookTModel
	extends BaseModel<GuestbookT>, GroupedModel, ShardedModel,
			StagedAuditedModel, WorkflowedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a guestbook t model instance should use the {@link GuestbookT} interface instead.
	 */

	/**
	 * Returns the primary key of this guestbook t.
	 *
	 * @return the primary key of this guestbook t
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this guestbook t.
	 *
	 * @param primaryKey the primary key of this guestbook t
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this guestbook t.
	 *
	 * @return the uuid of this guestbook t
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this guestbook t.
	 *
	 * @param uuid the uuid of this guestbook t
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the guestbook t ID of this guestbook t.
	 *
	 * @return the guestbook t ID of this guestbook t
	 */
	public long getGuestbookTId();

	/**
	 * Sets the guestbook t ID of this guestbook t.
	 *
	 * @param guestbookTId the guestbook t ID of this guestbook t
	 */
	public void setGuestbookTId(long guestbookTId);

	/**
	 * Returns the name of this guestbook t.
	 *
	 * @return the name of this guestbook t
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this guestbook t.
	 *
	 * @param name the name of this guestbook t
	 */
	public void setName(String name);

	/**
	 * Returns the group ID of this guestbook t.
	 *
	 * @return the group ID of this guestbook t
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this guestbook t.
	 *
	 * @param groupId the group ID of this guestbook t
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this guestbook t.
	 *
	 * @return the company ID of this guestbook t
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this guestbook t.
	 *
	 * @param companyId the company ID of this guestbook t
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this guestbook t.
	 *
	 * @return the user ID of this guestbook t
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this guestbook t.
	 *
	 * @param userId the user ID of this guestbook t
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this guestbook t.
	 *
	 * @return the user uuid of this guestbook t
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this guestbook t.
	 *
	 * @param userUuid the user uuid of this guestbook t
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this guestbook t.
	 *
	 * @return the user name of this guestbook t
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this guestbook t.
	 *
	 * @param userName the user name of this guestbook t
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this guestbook t.
	 *
	 * @return the create date of this guestbook t
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this guestbook t.
	 *
	 * @param createDate the create date of this guestbook t
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this guestbook t.
	 *
	 * @return the modified date of this guestbook t
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this guestbook t.
	 *
	 * @param modifiedDate the modified date of this guestbook t
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the status of this guestbook t.
	 *
	 * @return the status of this guestbook t
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this guestbook t.
	 *
	 * @param status the status of this guestbook t
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this guestbook t.
	 *
	 * @return the status by user ID of this guestbook t
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this guestbook t.
	 *
	 * @param statusByUserId the status by user ID of this guestbook t
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this guestbook t.
	 *
	 * @return the status by user uuid of this guestbook t
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this guestbook t.
	 *
	 * @param statusByUserUuid the status by user uuid of this guestbook t
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this guestbook t.
	 *
	 * @return the status by user name of this guestbook t
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this guestbook t.
	 *
	 * @param statusByUserName the status by user name of this guestbook t
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this guestbook t.
	 *
	 * @return the status date of this guestbook t
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this guestbook t.
	 *
	 * @param statusDate the status date of this guestbook t
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns <code>true</code> if this guestbook t is approved.
	 *
	 * @return <code>true</code> if this guestbook t is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this guestbook t is denied.
	 *
	 * @return <code>true</code> if this guestbook t is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this guestbook t is a draft.
	 *
	 * @return <code>true</code> if this guestbook t is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this guestbook t is expired.
	 *
	 * @return <code>true</code> if this guestbook t is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this guestbook t is inactive.
	 *
	 * @return <code>true</code> if this guestbook t is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this guestbook t is incomplete.
	 *
	 * @return <code>true</code> if this guestbook t is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this guestbook t is pending.
	 *
	 * @return <code>true</code> if this guestbook t is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this guestbook t is scheduled.
	 *
	 * @return <code>true</code> if this guestbook t is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled();

	@Override
	public GuestbookT cloneWithOriginalValues();

}