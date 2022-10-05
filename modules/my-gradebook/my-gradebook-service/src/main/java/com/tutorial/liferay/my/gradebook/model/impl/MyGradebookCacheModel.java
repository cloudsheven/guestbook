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

import com.tutorial.liferay.my.gradebook.model.MyGradebook;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing MyGradebook in entity cache.
 *
 * @author Andrea Luzzi
 * @generated
 */
public class MyGradebookCacheModel
	implements CacheModel<MyGradebook>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof MyGradebookCacheModel)) {
			return false;
		}

		MyGradebookCacheModel myGradebookCacheModel =
			(MyGradebookCacheModel)object;

		if (myGradebookId == myGradebookCacheModel.myGradebookId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, myGradebookId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", myGradebookId=");
		sb.append(myGradebookId);
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
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MyGradebook toEntityModel() {
		MyGradebookImpl myGradebookImpl = new MyGradebookImpl();

		if (uuid == null) {
			myGradebookImpl.setUuid("");
		}
		else {
			myGradebookImpl.setUuid(uuid);
		}

		myGradebookImpl.setMyGradebookId(myGradebookId);

		if (name == null) {
			myGradebookImpl.setName("");
		}
		else {
			myGradebookImpl.setName(name);
		}

		myGradebookImpl.setGroupId(groupId);
		myGradebookImpl.setCompanyId(companyId);
		myGradebookImpl.setUserId(userId);

		if (userName == null) {
			myGradebookImpl.setUserName("");
		}
		else {
			myGradebookImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			myGradebookImpl.setCreateDate(null);
		}
		else {
			myGradebookImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			myGradebookImpl.setModifiedDate(null);
		}
		else {
			myGradebookImpl.setModifiedDate(new Date(modifiedDate));
		}

		myGradebookImpl.setStatus(status);
		myGradebookImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			myGradebookImpl.setStatusByUserName("");
		}
		else {
			myGradebookImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			myGradebookImpl.setStatusDate(null);
		}
		else {
			myGradebookImpl.setStatusDate(new Date(statusDate));
		}

		myGradebookImpl.resetOriginalValues();

		return myGradebookImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		myGradebookId = objectInput.readLong();
		name = objectInput.readUTF();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(myGradebookId);

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

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);
	}

	public String uuid;
	public long myGradebookId;
	public String name;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;

}