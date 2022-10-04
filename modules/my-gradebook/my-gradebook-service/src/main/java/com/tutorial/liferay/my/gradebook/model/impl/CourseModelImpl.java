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

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import com.tutorial.liferay.my.gradebook.model.Course;
import com.tutorial.liferay.my.gradebook.model.CourseModel;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the Course service. Represents a row in the &quot;MYGDB_Course&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>CourseModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CourseImpl}.
 * </p>
 *
 * @author Andrea Luzzi
 * @see CourseImpl
 * @generated
 */
@JSON(strict = true)
public class CourseModelImpl
	extends BaseModelImpl<Course> implements CourseModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a course model instance should use the <code>Course</code> interface instead.
	 */
	public static final String TABLE_NAME = "MYGDB_Course";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"courseId", Types.BIGINT},
		{"myGradebookId", Types.BIGINT}, {"name", Types.VARCHAR},
		{"topic", Types.VARCHAR}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("courseId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("myGradebookId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("topic", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE =
		"create table MYGDB_Course (uuid_ VARCHAR(75) null,courseId LONG not null primary key,myGradebookId LONG,name VARCHAR(75) null,topic VARCHAR(75) null,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null)";

	public static final String TABLE_SQL_DROP = "drop table MYGDB_Course";

	public static final String ORDER_BY_JPQL =
		" ORDER BY course.createDate DESC";

	public static final String ORDER_BY_SQL =
		" ORDER BY MYGDB_Course.createDate DESC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long MYGRADEBOOKID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long CREATEDATE_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	public CourseModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _courseId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCourseId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _courseId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Course.class;
	}

	@Override
	public String getModelClassName() {
		return Course.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Course, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Course, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Course, Object> attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Course)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Course, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Course, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Course)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Course, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Course, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Course>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Course.class.getClassLoader(), Course.class, ModelWrapper.class);

		try {
			Constructor<Course> constructor =
				(Constructor<Course>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<Course, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Course, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Course, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Course, Object>>();
		Map<String, BiConsumer<Course, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Course, ?>>();

		attributeGetterFunctions.put("uuid", Course::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<Course, String>)Course::setUuid);
		attributeGetterFunctions.put("courseId", Course::getCourseId);
		attributeSetterBiConsumers.put(
			"courseId", (BiConsumer<Course, Long>)Course::setCourseId);
		attributeGetterFunctions.put("myGradebookId", Course::getMyGradebookId);
		attributeSetterBiConsumers.put(
			"myGradebookId",
			(BiConsumer<Course, Long>)Course::setMyGradebookId);
		attributeGetterFunctions.put("name", Course::getName);
		attributeSetterBiConsumers.put(
			"name", (BiConsumer<Course, String>)Course::setName);
		attributeGetterFunctions.put("topic", Course::getTopic);
		attributeSetterBiConsumers.put(
			"topic", (BiConsumer<Course, String>)Course::setTopic);
		attributeGetterFunctions.put("groupId", Course::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<Course, Long>)Course::setGroupId);
		attributeGetterFunctions.put("companyId", Course::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId", (BiConsumer<Course, Long>)Course::setCompanyId);
		attributeGetterFunctions.put("userId", Course::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<Course, Long>)Course::setUserId);
		attributeGetterFunctions.put("userName", Course::getUserName);
		attributeSetterBiConsumers.put(
			"userName", (BiConsumer<Course, String>)Course::setUserName);
		attributeGetterFunctions.put("createDate", Course::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate", (BiConsumer<Course, Date>)Course::setCreateDate);
		attributeGetterFunctions.put("modifiedDate", Course::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate", (BiConsumer<Course, Date>)Course::setModifiedDate);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_uuid = uuid;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUuid() {
		return getColumnOriginalValue("uuid_");
	}

	@JSON
	@Override
	public long getCourseId() {
		return _courseId;
	}

	@Override
	public void setCourseId(long courseId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_courseId = courseId;
	}

	@JSON
	@Override
	public long getMyGradebookId() {
		return _myGradebookId;
	}

	@Override
	public void setMyGradebookId(long myGradebookId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_myGradebookId = myGradebookId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalMyGradebookId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("myGradebookId"));
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_name = name;
	}

	@JSON
	@Override
	public String getTopic() {
		if (_topic == null) {
			return "";
		}
		else {
			return _topic;
		}
	}

	@Override
	public void setTopic(String topic) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_topic = topic;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_groupId = groupId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalGroupId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("groupId"));
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCompanyId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("companyId"));
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(Course.class.getName()));
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), Course.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Course toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Course>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CourseImpl courseImpl = new CourseImpl();

		courseImpl.setUuid(getUuid());
		courseImpl.setCourseId(getCourseId());
		courseImpl.setMyGradebookId(getMyGradebookId());
		courseImpl.setName(getName());
		courseImpl.setTopic(getTopic());
		courseImpl.setGroupId(getGroupId());
		courseImpl.setCompanyId(getCompanyId());
		courseImpl.setUserId(getUserId());
		courseImpl.setUserName(getUserName());
		courseImpl.setCreateDate(getCreateDate());
		courseImpl.setModifiedDate(getModifiedDate());

		courseImpl.resetOriginalValues();

		return courseImpl;
	}

	@Override
	public Course cloneWithOriginalValues() {
		CourseImpl courseImpl = new CourseImpl();

		courseImpl.setUuid(this.<String>getColumnOriginalValue("uuid_"));
		courseImpl.setCourseId(this.<Long>getColumnOriginalValue("courseId"));
		courseImpl.setMyGradebookId(
			this.<Long>getColumnOriginalValue("myGradebookId"));
		courseImpl.setName(this.<String>getColumnOriginalValue("name"));
		courseImpl.setTopic(this.<String>getColumnOriginalValue("topic"));
		courseImpl.setGroupId(this.<Long>getColumnOriginalValue("groupId"));
		courseImpl.setCompanyId(this.<Long>getColumnOriginalValue("companyId"));
		courseImpl.setUserId(this.<Long>getColumnOriginalValue("userId"));
		courseImpl.setUserName(this.<String>getColumnOriginalValue("userName"));
		courseImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		courseImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));

		return courseImpl;
	}

	@Override
	public int compareTo(Course course) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), course.getCreateDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Course)) {
			return false;
		}

		Course course = (Course)object;

		long primaryKey = course.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<Course> toCacheModel() {
		CourseCacheModel courseCacheModel = new CourseCacheModel();

		courseCacheModel.uuid = getUuid();

		String uuid = courseCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			courseCacheModel.uuid = null;
		}

		courseCacheModel.courseId = getCourseId();

		courseCacheModel.myGradebookId = getMyGradebookId();

		courseCacheModel.name = getName();

		String name = courseCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			courseCacheModel.name = null;
		}

		courseCacheModel.topic = getTopic();

		String topic = courseCacheModel.topic;

		if ((topic != null) && (topic.length() == 0)) {
			courseCacheModel.topic = null;
		}

		courseCacheModel.groupId = getGroupId();

		courseCacheModel.companyId = getCompanyId();

		courseCacheModel.userId = getUserId();

		courseCacheModel.userName = getUserName();

		String userName = courseCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			courseCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			courseCacheModel.createDate = createDate.getTime();
		}
		else {
			courseCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			courseCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			courseCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		return courseCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Course, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Course, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Course, Object> attributeGetterFunction = entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((Course)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<Course, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Course, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Course, Object> attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Course)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Course>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private long _courseId;
	private long _myGradebookId;
	private String _name;
	private String _topic;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<Course, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((Course)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("uuid_", _uuid);
		_columnOriginalValues.put("courseId", _courseId);
		_columnOriginalValues.put("myGradebookId", _myGradebookId);
		_columnOriginalValues.put("name", _name);
		_columnOriginalValues.put("topic", _topic);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("uuid_", 1L);

		columnBitmasks.put("courseId", 2L);

		columnBitmasks.put("myGradebookId", 4L);

		columnBitmasks.put("name", 8L);

		columnBitmasks.put("topic", 16L);

		columnBitmasks.put("groupId", 32L);

		columnBitmasks.put("companyId", 64L);

		columnBitmasks.put("userId", 128L);

		columnBitmasks.put("userName", 256L);

		columnBitmasks.put("createDate", 512L);

		columnBitmasks.put("modifiedDate", 1024L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private Course _escapedModel;

}