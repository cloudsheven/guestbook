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

package com.tutorial.liferay.my.gradebook.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.tutorial.liferay.my.gradebook.model.MyGradebook;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the my gradebook service. This utility wraps <code>com.tutorial.liferay.my.gradebook.service.persistence.impl.MyGradebookPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Andrea Luzzi
 * @see MyGradebookPersistence
 * @generated
 */
public class MyGradebookUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(MyGradebook myGradebook) {
		getPersistence().clearCache(myGradebook);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, MyGradebook> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<MyGradebook> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MyGradebook> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MyGradebook> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<MyGradebook> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static MyGradebook update(MyGradebook myGradebook) {
		return getPersistence().update(myGradebook);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static MyGradebook update(
		MyGradebook myGradebook, ServiceContext serviceContext) {

		return getPersistence().update(myGradebook, serviceContext);
	}

	/**
	 * Returns all the my gradebooks where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching my gradebooks
	 */
	public static List<MyGradebook> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the my gradebooks where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MyGradebookModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of my gradebooks
	 * @param end the upper bound of the range of my gradebooks (not inclusive)
	 * @return the range of matching my gradebooks
	 */
	public static List<MyGradebook> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the my gradebooks where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MyGradebookModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of my gradebooks
	 * @param end the upper bound of the range of my gradebooks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching my gradebooks
	 */
	public static List<MyGradebook> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<MyGradebook> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the my gradebooks where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MyGradebookModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of my gradebooks
	 * @param end the upper bound of the range of my gradebooks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching my gradebooks
	 */
	public static List<MyGradebook> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<MyGradebook> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first my gradebook in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching my gradebook
	 * @throws NoSuchMyGradebookException if a matching my gradebook could not be found
	 */
	public static MyGradebook findByUuid_First(
			String uuid, OrderByComparator<MyGradebook> orderByComparator)
		throws com.tutorial.liferay.my.gradebook.exception.
			NoSuchMyGradebookException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first my gradebook in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching my gradebook, or <code>null</code> if a matching my gradebook could not be found
	 */
	public static MyGradebook fetchByUuid_First(
		String uuid, OrderByComparator<MyGradebook> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last my gradebook in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching my gradebook
	 * @throws NoSuchMyGradebookException if a matching my gradebook could not be found
	 */
	public static MyGradebook findByUuid_Last(
			String uuid, OrderByComparator<MyGradebook> orderByComparator)
		throws com.tutorial.liferay.my.gradebook.exception.
			NoSuchMyGradebookException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last my gradebook in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching my gradebook, or <code>null</code> if a matching my gradebook could not be found
	 */
	public static MyGradebook fetchByUuid_Last(
		String uuid, OrderByComparator<MyGradebook> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the my gradebooks before and after the current my gradebook in the ordered set where uuid = &#63;.
	 *
	 * @param myGradebookId the primary key of the current my gradebook
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next my gradebook
	 * @throws NoSuchMyGradebookException if a my gradebook with the primary key could not be found
	 */
	public static MyGradebook[] findByUuid_PrevAndNext(
			long myGradebookId, String uuid,
			OrderByComparator<MyGradebook> orderByComparator)
		throws com.tutorial.liferay.my.gradebook.exception.
			NoSuchMyGradebookException {

		return getPersistence().findByUuid_PrevAndNext(
			myGradebookId, uuid, orderByComparator);
	}

	/**
	 * Removes all the my gradebooks where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of my gradebooks where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching my gradebooks
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the my gradebook where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchMyGradebookException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching my gradebook
	 * @throws NoSuchMyGradebookException if a matching my gradebook could not be found
	 */
	public static MyGradebook findByUUID_G(String uuid, long groupId)
		throws com.tutorial.liferay.my.gradebook.exception.
			NoSuchMyGradebookException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the my gradebook where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching my gradebook, or <code>null</code> if a matching my gradebook could not be found
	 */
	public static MyGradebook fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the my gradebook where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching my gradebook, or <code>null</code> if a matching my gradebook could not be found
	 */
	public static MyGradebook fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the my gradebook where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the my gradebook that was removed
	 */
	public static MyGradebook removeByUUID_G(String uuid, long groupId)
		throws com.tutorial.liferay.my.gradebook.exception.
			NoSuchMyGradebookException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of my gradebooks where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching my gradebooks
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the my gradebooks where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching my gradebooks
	 */
	public static List<MyGradebook> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the my gradebooks where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MyGradebookModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of my gradebooks
	 * @param end the upper bound of the range of my gradebooks (not inclusive)
	 * @return the range of matching my gradebooks
	 */
	public static List<MyGradebook> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the my gradebooks where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MyGradebookModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of my gradebooks
	 * @param end the upper bound of the range of my gradebooks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching my gradebooks
	 */
	public static List<MyGradebook> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<MyGradebook> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the my gradebooks where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MyGradebookModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of my gradebooks
	 * @param end the upper bound of the range of my gradebooks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching my gradebooks
	 */
	public static List<MyGradebook> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<MyGradebook> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first my gradebook in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching my gradebook
	 * @throws NoSuchMyGradebookException if a matching my gradebook could not be found
	 */
	public static MyGradebook findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<MyGradebook> orderByComparator)
		throws com.tutorial.liferay.my.gradebook.exception.
			NoSuchMyGradebookException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first my gradebook in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching my gradebook, or <code>null</code> if a matching my gradebook could not be found
	 */
	public static MyGradebook fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<MyGradebook> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last my gradebook in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching my gradebook
	 * @throws NoSuchMyGradebookException if a matching my gradebook could not be found
	 */
	public static MyGradebook findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<MyGradebook> orderByComparator)
		throws com.tutorial.liferay.my.gradebook.exception.
			NoSuchMyGradebookException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last my gradebook in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching my gradebook, or <code>null</code> if a matching my gradebook could not be found
	 */
	public static MyGradebook fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<MyGradebook> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the my gradebooks before and after the current my gradebook in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param myGradebookId the primary key of the current my gradebook
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next my gradebook
	 * @throws NoSuchMyGradebookException if a my gradebook with the primary key could not be found
	 */
	public static MyGradebook[] findByUuid_C_PrevAndNext(
			long myGradebookId, String uuid, long companyId,
			OrderByComparator<MyGradebook> orderByComparator)
		throws com.tutorial.liferay.my.gradebook.exception.
			NoSuchMyGradebookException {

		return getPersistence().findByUuid_C_PrevAndNext(
			myGradebookId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the my gradebooks where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of my gradebooks where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching my gradebooks
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the my gradebooks where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching my gradebooks
	 */
	public static List<MyGradebook> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the my gradebooks where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MyGradebookModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of my gradebooks
	 * @param end the upper bound of the range of my gradebooks (not inclusive)
	 * @return the range of matching my gradebooks
	 */
	public static List<MyGradebook> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the my gradebooks where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MyGradebookModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of my gradebooks
	 * @param end the upper bound of the range of my gradebooks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching my gradebooks
	 */
	public static List<MyGradebook> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<MyGradebook> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the my gradebooks where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MyGradebookModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of my gradebooks
	 * @param end the upper bound of the range of my gradebooks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching my gradebooks
	 */
	public static List<MyGradebook> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<MyGradebook> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first my gradebook in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching my gradebook
	 * @throws NoSuchMyGradebookException if a matching my gradebook could not be found
	 */
	public static MyGradebook findByGroupId_First(
			long groupId, OrderByComparator<MyGradebook> orderByComparator)
		throws com.tutorial.liferay.my.gradebook.exception.
			NoSuchMyGradebookException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first my gradebook in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching my gradebook, or <code>null</code> if a matching my gradebook could not be found
	 */
	public static MyGradebook fetchByGroupId_First(
		long groupId, OrderByComparator<MyGradebook> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last my gradebook in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching my gradebook
	 * @throws NoSuchMyGradebookException if a matching my gradebook could not be found
	 */
	public static MyGradebook findByGroupId_Last(
			long groupId, OrderByComparator<MyGradebook> orderByComparator)
		throws com.tutorial.liferay.my.gradebook.exception.
			NoSuchMyGradebookException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last my gradebook in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching my gradebook, or <code>null</code> if a matching my gradebook could not be found
	 */
	public static MyGradebook fetchByGroupId_Last(
		long groupId, OrderByComparator<MyGradebook> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the my gradebooks before and after the current my gradebook in the ordered set where groupId = &#63;.
	 *
	 * @param myGradebookId the primary key of the current my gradebook
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next my gradebook
	 * @throws NoSuchMyGradebookException if a my gradebook with the primary key could not be found
	 */
	public static MyGradebook[] findByGroupId_PrevAndNext(
			long myGradebookId, long groupId,
			OrderByComparator<MyGradebook> orderByComparator)
		throws com.tutorial.liferay.my.gradebook.exception.
			NoSuchMyGradebookException {

		return getPersistence().findByGroupId_PrevAndNext(
			myGradebookId, groupId, orderByComparator);
	}

	/**
	 * Removes all the my gradebooks where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of my gradebooks where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching my gradebooks
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Caches the my gradebook in the entity cache if it is enabled.
	 *
	 * @param myGradebook the my gradebook
	 */
	public static void cacheResult(MyGradebook myGradebook) {
		getPersistence().cacheResult(myGradebook);
	}

	/**
	 * Caches the my gradebooks in the entity cache if it is enabled.
	 *
	 * @param myGradebooks the my gradebooks
	 */
	public static void cacheResult(List<MyGradebook> myGradebooks) {
		getPersistence().cacheResult(myGradebooks);
	}

	/**
	 * Creates a new my gradebook with the primary key. Does not add the my gradebook to the database.
	 *
	 * @param myGradebookId the primary key for the new my gradebook
	 * @return the new my gradebook
	 */
	public static MyGradebook create(long myGradebookId) {
		return getPersistence().create(myGradebookId);
	}

	/**
	 * Removes the my gradebook with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param myGradebookId the primary key of the my gradebook
	 * @return the my gradebook that was removed
	 * @throws NoSuchMyGradebookException if a my gradebook with the primary key could not be found
	 */
	public static MyGradebook remove(long myGradebookId)
		throws com.tutorial.liferay.my.gradebook.exception.
			NoSuchMyGradebookException {

		return getPersistence().remove(myGradebookId);
	}

	public static MyGradebook updateImpl(MyGradebook myGradebook) {
		return getPersistence().updateImpl(myGradebook);
	}

	/**
	 * Returns the my gradebook with the primary key or throws a <code>NoSuchMyGradebookException</code> if it could not be found.
	 *
	 * @param myGradebookId the primary key of the my gradebook
	 * @return the my gradebook
	 * @throws NoSuchMyGradebookException if a my gradebook with the primary key could not be found
	 */
	public static MyGradebook findByPrimaryKey(long myGradebookId)
		throws com.tutorial.liferay.my.gradebook.exception.
			NoSuchMyGradebookException {

		return getPersistence().findByPrimaryKey(myGradebookId);
	}

	/**
	 * Returns the my gradebook with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param myGradebookId the primary key of the my gradebook
	 * @return the my gradebook, or <code>null</code> if a my gradebook with the primary key could not be found
	 */
	public static MyGradebook fetchByPrimaryKey(long myGradebookId) {
		return getPersistence().fetchByPrimaryKey(myGradebookId);
	}

	/**
	 * Returns all the my gradebooks.
	 *
	 * @return the my gradebooks
	 */
	public static List<MyGradebook> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the my gradebooks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MyGradebookModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of my gradebooks
	 * @param end the upper bound of the range of my gradebooks (not inclusive)
	 * @return the range of my gradebooks
	 */
	public static List<MyGradebook> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the my gradebooks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MyGradebookModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of my gradebooks
	 * @param end the upper bound of the range of my gradebooks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of my gradebooks
	 */
	public static List<MyGradebook> findAll(
		int start, int end, OrderByComparator<MyGradebook> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the my gradebooks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MyGradebookModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of my gradebooks
	 * @param end the upper bound of the range of my gradebooks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of my gradebooks
	 */
	public static List<MyGradebook> findAll(
		int start, int end, OrderByComparator<MyGradebook> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the my gradebooks from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of my gradebooks.
	 *
	 * @return the number of my gradebooks
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static MyGradebookPersistence getPersistence() {
		return _persistence;
	}

	private static volatile MyGradebookPersistence _persistence;

}