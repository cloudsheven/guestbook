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

package com.tutorial.liferay.my.gradebook.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.tutorial.liferay.my.gradebook.model.Gradebook;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Gradebook in entity cache.
 *
 * @author Andrea Luzzi
 * @generated
 */
public class GradebookCacheModel
	implements CacheModel<Gradebook>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof GradebookCacheModel)) {
			return false;
		}

		GradebookCacheModel gradebookCacheModel = (GradebookCacheModel)object;

		if (gradebookId == gradebookCacheModel.gradebookId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, gradebookId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", gradebookId=");
		sb.append(gradebookId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Gradebook toEntityModel() {
		GradebookImpl gradebookImpl = new GradebookImpl();

		if (uuid == null) {
			gradebookImpl.setUuid("");
		}
		else {
			gradebookImpl.setUuid(uuid);
		}

		gradebookImpl.setGradebookId(gradebookId);

		if (name == null) {
			gradebookImpl.setName("");
		}
		else {
			gradebookImpl.setName(name);
		}

		gradebookImpl.setGroupId(groupId);
		gradebookImpl.setCompanyId(companyId);
		gradebookImpl.setUserId(userId);

		if (userName == null) {
			gradebookImpl.setUserName("");
		}
		else {
			gradebookImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			gradebookImpl.setCreateDate(null);
		}
		else {
			gradebookImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			gradebookImpl.setModifiedDate(null);
		}
		else {
			gradebookImpl.setModifiedDate(new Date(modifiedDate));
		}

		gradebookImpl.resetOriginalValues();

		return gradebookImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		gradebookId = objectInput.readLong();
		name = objectInput.readUTF();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(gradebookId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public String uuid;
	public long gradebookId;
	public String name;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}