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

package com.tutorial.guestbookt.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.tutorial.guestbookt.model.GuestbookT;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the guestbook t service. This utility wraps <code>com.tutorial.guestbookt.service.persistence.impl.GuestbookTPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Andrea Luzzi
 * @see GuestbookTPersistence
 * @generated
 */
public class GuestbookTUtil {

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
	public static void clearCache(GuestbookT guestbookT) {
		getPersistence().clearCache(guestbookT);
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
	public static Map<Serializable, GuestbookT> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<GuestbookT> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GuestbookT> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GuestbookT> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<GuestbookT> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static GuestbookT update(GuestbookT guestbookT) {
		return getPersistence().update(guestbookT);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static GuestbookT update(
		GuestbookT guestbookT, ServiceContext serviceContext) {

		return getPersistence().update(guestbookT, serviceContext);
	}

	/**
	 * Returns all the guestbook ts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching guestbook ts
	 */
	public static List<GuestbookT> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the guestbook ts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of guestbook ts
	 * @param end the upper bound of the range of guestbook ts (not inclusive)
	 * @return the range of matching guestbook ts
	 */
	public static List<GuestbookT> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the guestbook ts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of guestbook ts
	 * @param end the upper bound of the range of guestbook ts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching guestbook ts
	 */
	public static List<GuestbookT> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<GuestbookT> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the guestbook ts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of guestbook ts
	 * @param end the upper bound of the range of guestbook ts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching guestbook ts
	 */
	public static List<GuestbookT> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<GuestbookT> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first guestbook t in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching guestbook t
	 * @throws NoSuchGuestbookTException if a matching guestbook t could not be found
	 */
	public static GuestbookT findByUuid_First(
			String uuid, OrderByComparator<GuestbookT> orderByComparator)
		throws com.tutorial.guestbookt.exception.NoSuchGuestbookTException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first guestbook t in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching guestbook t, or <code>null</code> if a matching guestbook t could not be found
	 */
	public static GuestbookT fetchByUuid_First(
		String uuid, OrderByComparator<GuestbookT> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last guestbook t in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching guestbook t
	 * @throws NoSuchGuestbookTException if a matching guestbook t could not be found
	 */
	public static GuestbookT findByUuid_Last(
			String uuid, OrderByComparator<GuestbookT> orderByComparator)
		throws com.tutorial.guestbookt.exception.NoSuchGuestbookTException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last guestbook t in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching guestbook t, or <code>null</code> if a matching guestbook t could not be found
	 */
	public static GuestbookT fetchByUuid_Last(
		String uuid, OrderByComparator<GuestbookT> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the guestbook ts before and after the current guestbook t in the ordered set where uuid = &#63;.
	 *
	 * @param guestbookTId the primary key of the current guestbook t
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next guestbook t
	 * @throws NoSuchGuestbookTException if a guestbook t with the primary key could not be found
	 */
	public static GuestbookT[] findByUuid_PrevAndNext(
			long guestbookTId, String uuid,
			OrderByComparator<GuestbookT> orderByComparator)
		throws com.tutorial.guestbookt.exception.NoSuchGuestbookTException {

		return getPersistence().findByUuid_PrevAndNext(
			guestbookTId, uuid, orderByComparator);
	}

	/**
	 * Removes all the guestbook ts where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of guestbook ts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching guestbook ts
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the guestbook t where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchGuestbookTException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching guestbook t
	 * @throws NoSuchGuestbookTException if a matching guestbook t could not be found
	 */
	public static GuestbookT findByUUID_G(String uuid, long groupId)
		throws com.tutorial.guestbookt.exception.NoSuchGuestbookTException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the guestbook t where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching guestbook t, or <code>null</code> if a matching guestbook t could not be found
	 */
	public static GuestbookT fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the guestbook t where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching guestbook t, or <code>null</code> if a matching guestbook t could not be found
	 */
	public static GuestbookT fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the guestbook t where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the guestbook t that was removed
	 */
	public static GuestbookT removeByUUID_G(String uuid, long groupId)
		throws com.tutorial.guestbookt.exception.NoSuchGuestbookTException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of guestbook ts where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching guestbook ts
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the guestbook ts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching guestbook ts
	 */
	public static List<GuestbookT> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the guestbook ts where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of guestbook ts
	 * @param end the upper bound of the range of guestbook ts (not inclusive)
	 * @return the range of matching guestbook ts
	 */
	public static List<GuestbookT> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the guestbook ts where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of guestbook ts
	 * @param end the upper bound of the range of guestbook ts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching guestbook ts
	 */
	public static List<GuestbookT> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<GuestbookT> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the guestbook ts where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of guestbook ts
	 * @param end the upper bound of the range of guestbook ts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching guestbook ts
	 */
	public static List<GuestbookT> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<GuestbookT> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first guestbook t in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching guestbook t
	 * @throws NoSuchGuestbookTException if a matching guestbook t could not be found
	 */
	public static GuestbookT findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<GuestbookT> orderByComparator)
		throws com.tutorial.guestbookt.exception.NoSuchGuestbookTException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first guestbook t in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching guestbook t, or <code>null</code> if a matching guestbook t could not be found
	 */
	public static GuestbookT fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<GuestbookT> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last guestbook t in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching guestbook t
	 * @throws NoSuchGuestbookTException if a matching guestbook t could not be found
	 */
	public static GuestbookT findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<GuestbookT> orderByComparator)
		throws com.tutorial.guestbookt.exception.NoSuchGuestbookTException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last guestbook t in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching guestbook t, or <code>null</code> if a matching guestbook t could not be found
	 */
	public static GuestbookT fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<GuestbookT> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the guestbook ts before and after the current guestbook t in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param guestbookTId the primary key of the current guestbook t
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next guestbook t
	 * @throws NoSuchGuestbookTException if a guestbook t with the primary key could not be found
	 */
	public static GuestbookT[] findByUuid_C_PrevAndNext(
			long guestbookTId, String uuid, long companyId,
			OrderByComparator<GuestbookT> orderByComparator)
		throws com.tutorial.guestbookt.exception.NoSuchGuestbookTException {

		return getPersistence().findByUuid_C_PrevAndNext(
			guestbookTId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the guestbook ts where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of guestbook ts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching guestbook ts
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the guestbook ts where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching guestbook ts
	 */
	public static List<GuestbookT> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the guestbook ts where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of guestbook ts
	 * @param end the upper bound of the range of guestbook ts (not inclusive)
	 * @return the range of matching guestbook ts
	 */
	public static List<GuestbookT> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the guestbook ts where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of guestbook ts
	 * @param end the upper bound of the range of guestbook ts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching guestbook ts
	 */
	public static List<GuestbookT> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<GuestbookT> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the guestbook ts where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of guestbook ts
	 * @param end the upper bound of the range of guestbook ts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching guestbook ts
	 */
	public static List<GuestbookT> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<GuestbookT> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first guestbook t in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching guestbook t
	 * @throws NoSuchGuestbookTException if a matching guestbook t could not be found
	 */
	public static GuestbookT findByGroupId_First(
			long groupId, OrderByComparator<GuestbookT> orderByComparator)
		throws com.tutorial.guestbookt.exception.NoSuchGuestbookTException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first guestbook t in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching guestbook t, or <code>null</code> if a matching guestbook t could not be found
	 */
	public static GuestbookT fetchByGroupId_First(
		long groupId, OrderByComparator<GuestbookT> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last guestbook t in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching guestbook t
	 * @throws NoSuchGuestbookTException if a matching guestbook t could not be found
	 */
	public static GuestbookT findByGroupId_Last(
			long groupId, OrderByComparator<GuestbookT> orderByComparator)
		throws com.tutorial.guestbookt.exception.NoSuchGuestbookTException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last guestbook t in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching guestbook t, or <code>null</code> if a matching guestbook t could not be found
	 */
	public static GuestbookT fetchByGroupId_Last(
		long groupId, OrderByComparator<GuestbookT> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the guestbook ts before and after the current guestbook t in the ordered set where groupId = &#63;.
	 *
	 * @param guestbookTId the primary key of the current guestbook t
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next guestbook t
	 * @throws NoSuchGuestbookTException if a guestbook t with the primary key could not be found
	 */
	public static GuestbookT[] findByGroupId_PrevAndNext(
			long guestbookTId, long groupId,
			OrderByComparator<GuestbookT> orderByComparator)
		throws com.tutorial.guestbookt.exception.NoSuchGuestbookTException {

		return getPersistence().findByGroupId_PrevAndNext(
			guestbookTId, groupId, orderByComparator);
	}

	/**
	 * Returns all the guestbook ts that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching guestbook ts that the user has permission to view
	 */
	public static List<GuestbookT> filterFindByGroupId(long groupId) {
		return getPersistence().filterFindByGroupId(groupId);
	}

	/**
	 * Returns a range of all the guestbook ts that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of guestbook ts
	 * @param end the upper bound of the range of guestbook ts (not inclusive)
	 * @return the range of matching guestbook ts that the user has permission to view
	 */
	public static List<GuestbookT> filterFindByGroupId(
		long groupId, int start, int end) {

		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the guestbook ts that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of guestbook ts
	 * @param end the upper bound of the range of guestbook ts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching guestbook ts that the user has permission to view
	 */
	public static List<GuestbookT> filterFindByGroupId(
		long groupId, int start, int end,
		OrderByComparator<GuestbookT> orderByComparator) {

		return getPersistence().filterFindByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns the guestbook ts before and after the current guestbook t in the ordered set of guestbook ts that the user has permission to view where groupId = &#63;.
	 *
	 * @param guestbookTId the primary key of the current guestbook t
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next guestbook t
	 * @throws NoSuchGuestbookTException if a guestbook t with the primary key could not be found
	 */
	public static GuestbookT[] filterFindByGroupId_PrevAndNext(
			long guestbookTId, long groupId,
			OrderByComparator<GuestbookT> orderByComparator)
		throws com.tutorial.guestbookt.exception.NoSuchGuestbookTException {

		return getPersistence().filterFindByGroupId_PrevAndNext(
			guestbookTId, groupId, orderByComparator);
	}

	/**
	 * Removes all the guestbook ts where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of guestbook ts where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching guestbook ts
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns the number of guestbook ts that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching guestbook ts that the user has permission to view
	 */
	public static int filterCountByGroupId(long groupId) {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	 * Caches the guestbook t in the entity cache if it is enabled.
	 *
	 * @param guestbookT the guestbook t
	 */
	public static void cacheResult(GuestbookT guestbookT) {
		getPersistence().cacheResult(guestbookT);
	}

	/**
	 * Caches the guestbook ts in the entity cache if it is enabled.
	 *
	 * @param guestbookTs the guestbook ts
	 */
	public static void cacheResult(List<GuestbookT> guestbookTs) {
		getPersistence().cacheResult(guestbookTs);
	}

	/**
	 * Creates a new guestbook t with the primary key. Does not add the guestbook t to the database.
	 *
	 * @param guestbookTId the primary key for the new guestbook t
	 * @return the new guestbook t
	 */
	public static GuestbookT create(long guestbookTId) {
		return getPersistence().create(guestbookTId);
	}

	/**
	 * Removes the guestbook t with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param guestbookTId the primary key of the guestbook t
	 * @return the guestbook t that was removed
	 * @throws NoSuchGuestbookTException if a guestbook t with the primary key could not be found
	 */
	public static GuestbookT remove(long guestbookTId)
		throws com.tutorial.guestbookt.exception.NoSuchGuestbookTException {

		return getPersistence().remove(guestbookTId);
	}

	public static GuestbookT updateImpl(GuestbookT guestbookT) {
		return getPersistence().updateImpl(guestbookT);
	}

	/**
	 * Returns the guestbook t with the primary key or throws a <code>NoSuchGuestbookTException</code> if it could not be found.
	 *
	 * @param guestbookTId the primary key of the guestbook t
	 * @return the guestbook t
	 * @throws NoSuchGuestbookTException if a guestbook t with the primary key could not be found
	 */
	public static GuestbookT findByPrimaryKey(long guestbookTId)
		throws com.tutorial.guestbookt.exception.NoSuchGuestbookTException {

		return getPersistence().findByPrimaryKey(guestbookTId);
	}

	/**
	 * Returns the guestbook t with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param guestbookTId the primary key of the guestbook t
	 * @return the guestbook t, or <code>null</code> if a guestbook t with the primary key could not be found
	 */
	public static GuestbookT fetchByPrimaryKey(long guestbookTId) {
		return getPersistence().fetchByPrimaryKey(guestbookTId);
	}

	/**
	 * Returns all the guestbook ts.
	 *
	 * @return the guestbook ts
	 */
	public static List<GuestbookT> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the guestbook ts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of guestbook ts
	 * @param end the upper bound of the range of guestbook ts (not inclusive)
	 * @return the range of guestbook ts
	 */
	public static List<GuestbookT> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the guestbook ts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of guestbook ts
	 * @param end the upper bound of the range of guestbook ts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of guestbook ts
	 */
	public static List<GuestbookT> findAll(
		int start, int end, OrderByComparator<GuestbookT> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the guestbook ts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of guestbook ts
	 * @param end the upper bound of the range of guestbook ts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of guestbook ts
	 */
	public static List<GuestbookT> findAll(
		int start, int end, OrderByComparator<GuestbookT> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the guestbook ts from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of guestbook ts.
	 *
	 * @return the number of guestbook ts
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static GuestbookTPersistence getPersistence() {
		return _persistence;
	}

	private static volatile GuestbookTPersistence _persistence;

}