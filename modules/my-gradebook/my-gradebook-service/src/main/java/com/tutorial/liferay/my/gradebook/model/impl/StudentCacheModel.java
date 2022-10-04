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

import com.tutorial.liferay.my.gradebook.model.Student;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Student in entity cache.
 *
 * @author Andrea Luzzi
 * @generated
 */
public class StudentCacheModel implements CacheModel<Student>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof StudentCacheModel)) {
			return false;
		}

		StudentCacheModel studentCacheModel = (StudentCacheModel)object;

		if (studentId == studentCacheModel.studentId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, studentId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", studentId=");
		sb.append(studentId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", surname=");
		sb.append(surname);
		sb.append(", birthday=");
		sb.append(birthday);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", myGradebookId=");
		sb.append(myGradebookId);
		sb.append(", courseId=");
		sb.append(courseId);
		sb.append(", enrollDate=");
		sb.append(enrollDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Student toEntityModel() {
		StudentImpl studentImpl = new StudentImpl();

		if (uuid == null) {
			studentImpl.setUuid("");
		}
		else {
			studentImpl.setUuid(uuid);
		}

		studentImpl.setStudentId(studentId);

		if (name == null) {
			studentImpl.setName("");
		}
		else {
			studentImpl.setName(name);
		}

		if (surname == null) {
			studentImpl.setSurname("");
		}
		else {
			studentImpl.setSurname(surname);
		}

		if (birthday == Long.MIN_VALUE) {
			studentImpl.setBirthday(null);
		}
		else {
			studentImpl.setBirthday(new Date(birthday));
		}

		studentImpl.setUserId(userId);

		if (userName == null) {
			studentImpl.setUserName("");
		}
		else {
			studentImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			studentImpl.setCreateDate(null);
		}
		else {
			studentImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			studentImpl.setModifiedDate(null);
		}
		else {
			studentImpl.setModifiedDate(new Date(modifiedDate));
		}

		studentImpl.setGroupId(groupId);
		studentImpl.setCompanyId(companyId);
		studentImpl.setMyGradebookId(myGradebookId);
		studentImpl.setCourseId(courseId);

		if (enrollDate == Long.MIN_VALUE) {
			studentImpl.setEnrollDate(null);
		}
		else {
			studentImpl.setEnrollDate(new Date(enrollDate));
		}

		studentImpl.resetOriginalValues();

		return studentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		studentId = objectInput.readLong();
		name = objectInput.readUTF();
		surname = objectInput.readUTF();
		birthday = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		myGradebookId = objectInput.readLong();

		courseId = objectInput.readLong();
		enrollDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(studentId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (surname == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(surname);
		}

		objectOutput.writeLong(birthday);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(myGradebookId);

		objectOutput.writeLong(courseId);
		objectOutput.writeLong(enrollDate);
	}

	public String uuid;
	public long studentId;
	public String name;
	public String surname;
	public long birthday;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long groupId;
	public long companyId;
	public long myGradebookId;
	public long courseId;
	public long enrollDate;

}