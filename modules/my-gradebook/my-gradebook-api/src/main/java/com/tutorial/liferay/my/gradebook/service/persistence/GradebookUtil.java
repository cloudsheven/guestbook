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

import com.tutorial.liferay.my.gradebook.model.Gradebook;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the gradebook service. This utility wraps <code>com.tutorial.liferay.my.gradebook.service.persistence.impl.GradebookPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Andrea Luzzi
 * @see GradebookPersistence
 * @generated
 */
public class GradebookUtil {

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
	public static void clearCache(Gradebook gradebook) {
		getPersistence().clearCache(gradebook);
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
	public static Map<Serializable, Gradebook> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Gradebook> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Gradebook> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Gradebook> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Gradebook> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Gradebook update(Gradebook gradebook) {
		return getPersistence().update(gradebook);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Gradebook update(
		Gradebook gradebook, ServiceContext serviceContext) {

		return getPersistence().update(gradebook, serviceContext);
	}

	/**
	 * Returns all the gradebooks where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching gradebooks
	 */
	public static List<Gradebook> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the gradebooks where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GradebookModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of gradebooks
	 * @param end the upper bound of the range of gradebooks (not inclusive)
	 * @return the range of matching gradebooks
	 */
	public static List<Gradebook> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the gradebooks where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GradebookModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of gradebooks
	 * @param end the upper bound of the range of gradebooks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching gradebooks
	 */
	public static List<Gradebook> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Gradebook> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the gradebooks where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GradebookModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of gradebooks
	 * @param end the upper bound of the range of gradebooks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching gradebooks
	 */
	public static List<Gradebook> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Gradebook> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first gradebook in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gradebook
	 * @throws NoSuchGradebookException if a matching gradebook could not be found
	 */
	public static Gradebook findByUuid_First(
			String uuid, OrderByComparator<Gradebook> orderByComparator)
		throws com.tutorial.liferay.my.gradebook.exception.
			NoSuchGradebookException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first gradebook in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gradebook, or <code>null</code> if a matching gradebook could not be found
	 */
	public static Gradebook fetchByUuid_First(
		String uuid, OrderByComparator<Gradebook> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last gradebook in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gradebook
	 * @throws NoSuchGradebookException if a matching gradebook could not be found
	 */
	public static Gradebook findByUuid_Last(
			String uuid, OrderByComparator<Gradebook> orderByComparator)
		throws com.tutorial.liferay.my.gradebook.exception.
			NoSuchGradebookException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last gradebook in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gradebook, or <code>null</code> if a matching gradebook could not be found
	 */
	public static Gradebook fetchByUuid_Last(
		String uuid, OrderByComparator<Gradebook> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the gradebooks before and after the current gradebook in the ordered set where uuid = &#63;.
	 *
	 * @param gradebookId the primary key of the current gradebook
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gradebook
	 * @throws NoSuchGradebookException if a gradebook with the primary key could not be found
	 */
	public static Gradebook[] findByUuid_PrevAndNext(
			long gradebookId, String uuid,
			OrderByComparator<Gradebook> orderByComparator)
		throws com.tutorial.liferay.my.gradebook.exception.
			NoSuchGradebookException {

		return getPersistence().findByUuid_PrevAndNext(
			gradebookId, uuid, orderByComparator);
	}

	/**
	 * Removes all the gradebooks where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of gradebooks where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching gradebooks
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the gradebook where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchGradebookException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching gradebook
	 * @throws NoSuchGradebookException if a matching gradebook could not be found
	 */
	public static Gradebook findByUUID_G(String uuid, long groupId)
		throws com.tutorial.liferay.my.gradebook.exception.
			NoSuchGradebookException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the gradebook where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching gradebook, or <code>null</code> if a matching gradebook could not be found
	 */
	public static Gradebook fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the gradebook where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching gradebook, or <code>null</code> if a matching gradebook could not be found
	 */
	public static Gradebook fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the gradebook where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the gradebook that was removed
	 */
	public static Gradebook removeByUUID_G(String uuid, long groupId)
		throws com.tutorial.liferay.my.gradebook.exception.
			NoSuchGradebookException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of gradebooks where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching gradebooks
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the gradebooks where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching gradebooks
	 */
	public static List<Gradebook> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the gradebooks where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GradebookModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of gradebooks
	 * @param end the upper bound of the range of gradebooks (not inclusive)
	 * @return the range of matching gradebooks
	 */
	public static List<Gradebook> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the gradebooks where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GradebookModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of gradebooks
	 * @param end the upper bound of the range of gradebooks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching gradebooks
	 */
	public static List<Gradebook> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Gradebook> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the gradebooks where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GradebookModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of gradebooks
	 * @param end the upper bound of the range of gradebooks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching gradebooks
	 */
	public static List<Gradebook> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Gradebook> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first gradebook in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gradebook
	 * @throws NoSuchGradebookException if a matching gradebook could not be found
	 */
	public static Gradebook findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Gradebook> orderByComparator)
		throws com.tutorial.liferay.my.gradebook.exception.
			NoSuchGradebookException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first gradebook in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gradebook, or <code>null</code> if a matching gradebook could not be found
	 */
	public static Gradebook fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Gradebook> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last gradebook in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gradebook
	 * @throws NoSuchGradebookException if a matching gradebook could not be found
	 */
	public static Gradebook findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Gradebook> orderByComparator)
		throws com.tutorial.liferay.my.gradebook.exception.
			NoSuchGradebookException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last gradebook in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gradebook, or <code>null</code> if a matching gradebook could not be found
	 */
	public static Gradebook fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Gradebook> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the gradebooks before and after the current gradebook in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param gradebookId the primary key of the current gradebook
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gradebook
	 * @throws NoSuchGradebookException if a gradebook with the primary key could not be found
	 */
	public static Gradebook[] findByUuid_C_PrevAndNext(
			long gradebookId, String uuid, long companyId,
			OrderByComparator<Gradebook> orderByComparator)
		throws com.tutorial.liferay.my.gradebook.exception.
			NoSuchGradebookException {

		return getPersistence().findByUuid_C_PrevAndNext(
			gradebookId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the gradebooks where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of gradebooks where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching gradebooks
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the gradebooks where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching gradebooks
	 */
	public static List<Gradebook> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the gradebooks where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GradebookModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of gradebooks
	 * @param end the upper bound of the range of gradebooks (not inclusive)
	 * @return the range of matching gradebooks
	 */
	public static List<Gradebook> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the gradebooks where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GradebookModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of gradebooks
	 * @param end the upper bound of the range of gradebooks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching gradebooks
	 */
	public static List<Gradebook> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Gradebook> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the gradebooks where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GradebookModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of gradebooks
	 * @param end the upper bound of the range of gradebooks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching gradebooks
	 */
	public static List<Gradebook> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Gradebook> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first gradebook in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gradebook
	 * @throws NoSuchGradebookException if a matching gradebook could not be found
	 */
	public static Gradebook findByGroupId_First(
			long groupId, OrderByComparator<Gradebook> orderByComparator)
		throws com.tutorial.liferay.my.gradebook.exception.
			NoSuchGradebookException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first gradebook in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gradebook, or <code>null</code> if a matching gradebook could not be found
	 */
	public static Gradebook fetchByGroupId_First(
		long groupId, OrderByComparator<Gradebook> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last gradebook in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gradebook
	 * @throws NoSuchGradebookException if a matching gradebook could not be found
	 */
	public static Gradebook findByGroupId_Last(
			long groupId, OrderByComparator<Gradebook> orderByComparator)
		throws com.tutorial.liferay.my.gradebook.exception.
			NoSuchGradebookException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last gradebook in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gradebook, or <code>null</code> if a matching gradebook could not be found
	 */
	public static Gradebook fetchByGroupId_Last(
		long groupId, OrderByComparator<Gradebook> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the gradebooks before and after the current gradebook in the ordered set where groupId = &#63;.
	 *
	 * @param gradebookId the primary key of the current gradebook
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gradebook
	 * @throws NoSuchGradebookException if a gradebook with the primary key could not be found
	 */
	public static Gradebook[] findByGroupId_PrevAndNext(
			long gradebookId, long groupId,
			OrderByComparator<Gradebook> orderByComparator)
		throws com.tutorial.liferay.my.gradebook.exception.
			NoSuchGradebookException {

		return getPersistence().findByGroupId_PrevAndNext(
			gradebookId, groupId, orderByComparator);
	}

	/**
	 * Removes all the gradebooks where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of gradebooks where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching gradebooks
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Caches the gradebook in the entity cache if it is enabled.
	 *
	 * @param gradebook the gradebook
	 */
	public static void cacheResult(Gradebook gradebook) {
		getPersistence().cacheResult(gradebook);
	}

	/**
	 * Caches the gradebooks in the entity cache if it is enabled.
	 *
	 * @param gradebooks the gradebooks
	 */
	public static void cacheResult(List<Gradebook> gradebooks) {
		getPersistence().cacheResult(gradebooks);
	}

	/**
	 * Creates a new gradebook with the primary key. Does not add the gradebook to the database.
	 *
	 * @param gradebookId the primary key for the new gradebook
	 * @return the new gradebook
	 */
	public static Gradebook create(long gradebookId) {
		return getPersistence().create(gradebookId);
	}

	/**
	 * Removes the gradebook with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param gradebookId the primary key of the gradebook
	 * @return the gradebook that was removed
	 * @throws NoSuchGradebookException if a gradebook with the primary key could not be found
	 */
	public static Gradebook remove(long gradebookId)
		throws com.tutorial.liferay.my.gradebook.exception.
			NoSuchGradebookException {

		return getPersistence().remove(gradebookId);
	}

	public static Gradebook updateImpl(Gradebook gradebook) {
		return getPersistence().updateImpl(gradebook);
	}

	/**
	 * Returns the gradebook with the primary key or throws a <code>NoSuchGradebookException</code> if it could not be found.
	 *
	 * @param gradebookId the primary key of the gradebook
	 * @return the gradebook
	 * @throws NoSuchGradebookException if a gradebook with the primary key could not be found
	 */
	public static Gradebook findByPrimaryKey(long gradebookId)
		throws com.tutorial.liferay.my.gradebook.exception.
			NoSuchGradebookException {

		return getPersistence().findByPrimaryKey(gradebookId);
	}

	/**
	 * Returns the gradebook with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param gradebookId the primary key of the gradebook
	 * @return the gradebook, or <code>null</code> if a gradebook with the primary key could not be found
	 */
	public static Gradebook fetchByPrimaryKey(long gradebookId) {
		return getPersistence().fetchByPrimaryKey(gradebookId);
	}

	/**
	 * Returns all the gradebooks.
	 *
	 * @return the gradebooks
	 */
	public static List<Gradebook> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the gradebooks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GradebookModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of gradebooks
	 * @param end the upper bound of the range of gradebooks (not inclusive)
	 * @return the range of gradebooks
	 */
	public static List<Gradebook> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the gradebooks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GradebookModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of gradebooks
	 * @param end the upper bound of the range of gradebooks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of gradebooks
	 */
	public static List<Gradebook> findAll(
		int start, int end, OrderByComparator<Gradebook> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the gradebooks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GradebookModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of gradebooks
	 * @param end the upper bound of the range of gradebooks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of gradebooks
	 */
	public static List<Gradebook> findAll(
		int start, int end, OrderByComparator<Gradebook> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the gradebooks from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of gradebooks.
	 *
	 * @return the number of gradebooks
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static GradebookPersistence getPersistence() {
		return _persistence;
	}

	private static volatile GradebookPersistence _persistence;

}