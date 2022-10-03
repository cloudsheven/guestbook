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

import com.tutorial.guestbookt.model.GuestbookTEntry;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the guestbook t entry service. This utility wraps <code>com.tutorial.guestbookt.service.persistence.impl.GuestbookTEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Andrea Luzzi
 * @see GuestbookTEntryPersistence
 * @generated
 */
public class GuestbookTEntryUtil {

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
	public static void clearCache(GuestbookTEntry guestbookTEntry) {
		getPersistence().clearCache(guestbookTEntry);
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
	public static Map<Serializable, GuestbookTEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<GuestbookTEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GuestbookTEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GuestbookTEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<GuestbookTEntry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static GuestbookTEntry update(GuestbookTEntry guestbookTEntry) {
		return getPersistence().update(guestbookTEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static GuestbookTEntry update(
		GuestbookTEntry guestbookTEntry, ServiceContext serviceContext) {

		return getPersistence().update(guestbookTEntry, serviceContext);
	}

	/**
	 * Returns all the guestbook t entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching guestbook t entries
	 */
	public static List<GuestbookTEntry> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the guestbook t entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of guestbook t entries
	 * @param end the upper bound of the range of guestbook t entries (not inclusive)
	 * @return the range of matching guestbook t entries
	 */
	public static List<GuestbookTEntry> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the guestbook t entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of guestbook t entries
	 * @param end the upper bound of the range of guestbook t entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching guestbook t entries
	 */
	public static List<GuestbookTEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<GuestbookTEntry> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the guestbook t entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of guestbook t entries
	 * @param end the upper bound of the range of guestbook t entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching guestbook t entries
	 */
	public static List<GuestbookTEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<GuestbookTEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first guestbook t entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching guestbook t entry
	 * @throws NoSuchGuestbookTEntryException if a matching guestbook t entry could not be found
	 */
	public static GuestbookTEntry findByUuid_First(
			String uuid, OrderByComparator<GuestbookTEntry> orderByComparator)
		throws com.tutorial.guestbookt.exception.
			NoSuchGuestbookTEntryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first guestbook t entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching guestbook t entry, or <code>null</code> if a matching guestbook t entry could not be found
	 */
	public static GuestbookTEntry fetchByUuid_First(
		String uuid, OrderByComparator<GuestbookTEntry> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last guestbook t entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching guestbook t entry
	 * @throws NoSuchGuestbookTEntryException if a matching guestbook t entry could not be found
	 */
	public static GuestbookTEntry findByUuid_Last(
			String uuid, OrderByComparator<GuestbookTEntry> orderByComparator)
		throws com.tutorial.guestbookt.exception.
			NoSuchGuestbookTEntryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last guestbook t entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching guestbook t entry, or <code>null</code> if a matching guestbook t entry could not be found
	 */
	public static GuestbookTEntry fetchByUuid_Last(
		String uuid, OrderByComparator<GuestbookTEntry> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the guestbook t entries before and after the current guestbook t entry in the ordered set where uuid = &#63;.
	 *
	 * @param entryId the primary key of the current guestbook t entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next guestbook t entry
	 * @throws NoSuchGuestbookTEntryException if a guestbook t entry with the primary key could not be found
	 */
	public static GuestbookTEntry[] findByUuid_PrevAndNext(
			long entryId, String uuid,
			OrderByComparator<GuestbookTEntry> orderByComparator)
		throws com.tutorial.guestbookt.exception.
			NoSuchGuestbookTEntryException {

		return getPersistence().findByUuid_PrevAndNext(
			entryId, uuid, orderByComparator);
	}

	/**
	 * Removes all the guestbook t entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of guestbook t entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching guestbook t entries
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the guestbook t entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchGuestbookTEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching guestbook t entry
	 * @throws NoSuchGuestbookTEntryException if a matching guestbook t entry could not be found
	 */
	public static GuestbookTEntry findByUUID_G(String uuid, long groupId)
		throws com.tutorial.guestbookt.exception.
			NoSuchGuestbookTEntryException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the guestbook t entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching guestbook t entry, or <code>null</code> if a matching guestbook t entry could not be found
	 */
	public static GuestbookTEntry fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the guestbook t entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching guestbook t entry, or <code>null</code> if a matching guestbook t entry could not be found
	 */
	public static GuestbookTEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the guestbook t entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the guestbook t entry that was removed
	 */
	public static GuestbookTEntry removeByUUID_G(String uuid, long groupId)
		throws com.tutorial.guestbookt.exception.
			NoSuchGuestbookTEntryException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of guestbook t entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching guestbook t entries
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the guestbook t entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching guestbook t entries
	 */
	public static List<GuestbookTEntry> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the guestbook t entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of guestbook t entries
	 * @param end the upper bound of the range of guestbook t entries (not inclusive)
	 * @return the range of matching guestbook t entries
	 */
	public static List<GuestbookTEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the guestbook t entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of guestbook t entries
	 * @param end the upper bound of the range of guestbook t entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching guestbook t entries
	 */
	public static List<GuestbookTEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<GuestbookTEntry> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the guestbook t entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of guestbook t entries
	 * @param end the upper bound of the range of guestbook t entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching guestbook t entries
	 */
	public static List<GuestbookTEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<GuestbookTEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first guestbook t entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching guestbook t entry
	 * @throws NoSuchGuestbookTEntryException if a matching guestbook t entry could not be found
	 */
	public static GuestbookTEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<GuestbookTEntry> orderByComparator)
		throws com.tutorial.guestbookt.exception.
			NoSuchGuestbookTEntryException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first guestbook t entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching guestbook t entry, or <code>null</code> if a matching guestbook t entry could not be found
	 */
	public static GuestbookTEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<GuestbookTEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last guestbook t entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching guestbook t entry
	 * @throws NoSuchGuestbookTEntryException if a matching guestbook t entry could not be found
	 */
	public static GuestbookTEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<GuestbookTEntry> orderByComparator)
		throws com.tutorial.guestbookt.exception.
			NoSuchGuestbookTEntryException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last guestbook t entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching guestbook t entry, or <code>null</code> if a matching guestbook t entry could not be found
	 */
	public static GuestbookTEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<GuestbookTEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the guestbook t entries before and after the current guestbook t entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param entryId the primary key of the current guestbook t entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next guestbook t entry
	 * @throws NoSuchGuestbookTEntryException if a guestbook t entry with the primary key could not be found
	 */
	public static GuestbookTEntry[] findByUuid_C_PrevAndNext(
			long entryId, String uuid, long companyId,
			OrderByComparator<GuestbookTEntry> orderByComparator)
		throws com.tutorial.guestbookt.exception.
			NoSuchGuestbookTEntryException {

		return getPersistence().findByUuid_C_PrevAndNext(
			entryId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the guestbook t entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of guestbook t entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching guestbook t entries
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the guestbook t entries where groupId = &#63; and guestbookTId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @return the matching guestbook t entries
	 */
	public static List<GuestbookTEntry> findByG_G(
		long groupId, long guestbookTId) {

		return getPersistence().findByG_G(groupId, guestbookTId);
	}

	/**
	 * Returns a range of all the guestbook t entries where groupId = &#63; and guestbookTId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param start the lower bound of the range of guestbook t entries
	 * @param end the upper bound of the range of guestbook t entries (not inclusive)
	 * @return the range of matching guestbook t entries
	 */
	public static List<GuestbookTEntry> findByG_G(
		long groupId, long guestbookTId, int start, int end) {

		return getPersistence().findByG_G(groupId, guestbookTId, start, end);
	}

	/**
	 * Returns an ordered range of all the guestbook t entries where groupId = &#63; and guestbookTId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param start the lower bound of the range of guestbook t entries
	 * @param end the upper bound of the range of guestbook t entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching guestbook t entries
	 */
	public static List<GuestbookTEntry> findByG_G(
		long groupId, long guestbookTId, int start, int end,
		OrderByComparator<GuestbookTEntry> orderByComparator) {

		return getPersistence().findByG_G(
			groupId, guestbookTId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the guestbook t entries where groupId = &#63; and guestbookTId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param start the lower bound of the range of guestbook t entries
	 * @param end the upper bound of the range of guestbook t entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching guestbook t entries
	 */
	public static List<GuestbookTEntry> findByG_G(
		long groupId, long guestbookTId, int start, int end,
		OrderByComparator<GuestbookTEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_G(
			groupId, guestbookTId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first guestbook t entry in the ordered set where groupId = &#63; and guestbookTId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching guestbook t entry
	 * @throws NoSuchGuestbookTEntryException if a matching guestbook t entry could not be found
	 */
	public static GuestbookTEntry findByG_G_First(
			long groupId, long guestbookTId,
			OrderByComparator<GuestbookTEntry> orderByComparator)
		throws com.tutorial.guestbookt.exception.
			NoSuchGuestbookTEntryException {

		return getPersistence().findByG_G_First(
			groupId, guestbookTId, orderByComparator);
	}

	/**
	 * Returns the first guestbook t entry in the ordered set where groupId = &#63; and guestbookTId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching guestbook t entry, or <code>null</code> if a matching guestbook t entry could not be found
	 */
	public static GuestbookTEntry fetchByG_G_First(
		long groupId, long guestbookTId,
		OrderByComparator<GuestbookTEntry> orderByComparator) {

		return getPersistence().fetchByG_G_First(
			groupId, guestbookTId, orderByComparator);
	}

	/**
	 * Returns the last guestbook t entry in the ordered set where groupId = &#63; and guestbookTId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching guestbook t entry
	 * @throws NoSuchGuestbookTEntryException if a matching guestbook t entry could not be found
	 */
	public static GuestbookTEntry findByG_G_Last(
			long groupId, long guestbookTId,
			OrderByComparator<GuestbookTEntry> orderByComparator)
		throws com.tutorial.guestbookt.exception.
			NoSuchGuestbookTEntryException {

		return getPersistence().findByG_G_Last(
			groupId, guestbookTId, orderByComparator);
	}

	/**
	 * Returns the last guestbook t entry in the ordered set where groupId = &#63; and guestbookTId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching guestbook t entry, or <code>null</code> if a matching guestbook t entry could not be found
	 */
	public static GuestbookTEntry fetchByG_G_Last(
		long groupId, long guestbookTId,
		OrderByComparator<GuestbookTEntry> orderByComparator) {

		return getPersistence().fetchByG_G_Last(
			groupId, guestbookTId, orderByComparator);
	}

	/**
	 * Returns the guestbook t entries before and after the current guestbook t entry in the ordered set where groupId = &#63; and guestbookTId = &#63;.
	 *
	 * @param entryId the primary key of the current guestbook t entry
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next guestbook t entry
	 * @throws NoSuchGuestbookTEntryException if a guestbook t entry with the primary key could not be found
	 */
	public static GuestbookTEntry[] findByG_G_PrevAndNext(
			long entryId, long groupId, long guestbookTId,
			OrderByComparator<GuestbookTEntry> orderByComparator)
		throws com.tutorial.guestbookt.exception.
			NoSuchGuestbookTEntryException {

		return getPersistence().findByG_G_PrevAndNext(
			entryId, groupId, guestbookTId, orderByComparator);
	}

	/**
	 * Returns all the guestbook t entries that the user has permission to view where groupId = &#63; and guestbookTId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @return the matching guestbook t entries that the user has permission to view
	 */
	public static List<GuestbookTEntry> filterFindByG_G(
		long groupId, long guestbookTId) {

		return getPersistence().filterFindByG_G(groupId, guestbookTId);
	}

	/**
	 * Returns a range of all the guestbook t entries that the user has permission to view where groupId = &#63; and guestbookTId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param start the lower bound of the range of guestbook t entries
	 * @param end the upper bound of the range of guestbook t entries (not inclusive)
	 * @return the range of matching guestbook t entries that the user has permission to view
	 */
	public static List<GuestbookTEntry> filterFindByG_G(
		long groupId, long guestbookTId, int start, int end) {

		return getPersistence().filterFindByG_G(
			groupId, guestbookTId, start, end);
	}

	/**
	 * Returns an ordered range of all the guestbook t entries that the user has permissions to view where groupId = &#63; and guestbookTId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param start the lower bound of the range of guestbook t entries
	 * @param end the upper bound of the range of guestbook t entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching guestbook t entries that the user has permission to view
	 */
	public static List<GuestbookTEntry> filterFindByG_G(
		long groupId, long guestbookTId, int start, int end,
		OrderByComparator<GuestbookTEntry> orderByComparator) {

		return getPersistence().filterFindByG_G(
			groupId, guestbookTId, start, end, orderByComparator);
	}

	/**
	 * Returns the guestbook t entries before and after the current guestbook t entry in the ordered set of guestbook t entries that the user has permission to view where groupId = &#63; and guestbookTId = &#63;.
	 *
	 * @param entryId the primary key of the current guestbook t entry
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next guestbook t entry
	 * @throws NoSuchGuestbookTEntryException if a guestbook t entry with the primary key could not be found
	 */
	public static GuestbookTEntry[] filterFindByG_G_PrevAndNext(
			long entryId, long groupId, long guestbookTId,
			OrderByComparator<GuestbookTEntry> orderByComparator)
		throws com.tutorial.guestbookt.exception.
			NoSuchGuestbookTEntryException {

		return getPersistence().filterFindByG_G_PrevAndNext(
			entryId, groupId, guestbookTId, orderByComparator);
	}

	/**
	 * Removes all the guestbook t entries where groupId = &#63; and guestbookTId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 */
	public static void removeByG_G(long groupId, long guestbookTId) {
		getPersistence().removeByG_G(groupId, guestbookTId);
	}

	/**
	 * Returns the number of guestbook t entries where groupId = &#63; and guestbookTId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @return the number of matching guestbook t entries
	 */
	public static int countByG_G(long groupId, long guestbookTId) {
		return getPersistence().countByG_G(groupId, guestbookTId);
	}

	/**
	 * Returns the number of guestbook t entries that the user has permission to view where groupId = &#63; and guestbookTId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @return the number of matching guestbook t entries that the user has permission to view
	 */
	public static int filterCountByG_G(long groupId, long guestbookTId) {
		return getPersistence().filterCountByG_G(groupId, guestbookTId);
	}

	/**
	 * Returns all the guestbook t entries where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching guestbook t entries
	 */
	public static List<GuestbookTEntry> findByStatus(int status) {
		return getPersistence().findByStatus(status);
	}

	/**
	 * Returns a range of all the guestbook t entries where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTEntryModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of guestbook t entries
	 * @param end the upper bound of the range of guestbook t entries (not inclusive)
	 * @return the range of matching guestbook t entries
	 */
	public static List<GuestbookTEntry> findByStatus(
		int status, int start, int end) {

		return getPersistence().findByStatus(status, start, end);
	}

	/**
	 * Returns an ordered range of all the guestbook t entries where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTEntryModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of guestbook t entries
	 * @param end the upper bound of the range of guestbook t entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching guestbook t entries
	 */
	public static List<GuestbookTEntry> findByStatus(
		int status, int start, int end,
		OrderByComparator<GuestbookTEntry> orderByComparator) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the guestbook t entries where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTEntryModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of guestbook t entries
	 * @param end the upper bound of the range of guestbook t entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching guestbook t entries
	 */
	public static List<GuestbookTEntry> findByStatus(
		int status, int start, int end,
		OrderByComparator<GuestbookTEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first guestbook t entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching guestbook t entry
	 * @throws NoSuchGuestbookTEntryException if a matching guestbook t entry could not be found
	 */
	public static GuestbookTEntry findByStatus_First(
			int status, OrderByComparator<GuestbookTEntry> orderByComparator)
		throws com.tutorial.guestbookt.exception.
			NoSuchGuestbookTEntryException {

		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the first guestbook t entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching guestbook t entry, or <code>null</code> if a matching guestbook t entry could not be found
	 */
	public static GuestbookTEntry fetchByStatus_First(
		int status, OrderByComparator<GuestbookTEntry> orderByComparator) {

		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the last guestbook t entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching guestbook t entry
	 * @throws NoSuchGuestbookTEntryException if a matching guestbook t entry could not be found
	 */
	public static GuestbookTEntry findByStatus_Last(
			int status, OrderByComparator<GuestbookTEntry> orderByComparator)
		throws com.tutorial.guestbookt.exception.
			NoSuchGuestbookTEntryException {

		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the last guestbook t entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching guestbook t entry, or <code>null</code> if a matching guestbook t entry could not be found
	 */
	public static GuestbookTEntry fetchByStatus_Last(
		int status, OrderByComparator<GuestbookTEntry> orderByComparator) {

		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the guestbook t entries before and after the current guestbook t entry in the ordered set where status = &#63;.
	 *
	 * @param entryId the primary key of the current guestbook t entry
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next guestbook t entry
	 * @throws NoSuchGuestbookTEntryException if a guestbook t entry with the primary key could not be found
	 */
	public static GuestbookTEntry[] findByStatus_PrevAndNext(
			long entryId, int status,
			OrderByComparator<GuestbookTEntry> orderByComparator)
		throws com.tutorial.guestbookt.exception.
			NoSuchGuestbookTEntryException {

		return getPersistence().findByStatus_PrevAndNext(
			entryId, status, orderByComparator);
	}

	/**
	 * Removes all the guestbook t entries where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public static void removeByStatus(int status) {
		getPersistence().removeByStatus(status);
	}

	/**
	 * Returns the number of guestbook t entries where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching guestbook t entries
	 */
	public static int countByStatus(int status) {
		return getPersistence().countByStatus(status);
	}

	/**
	 * Returns all the guestbook t entries where groupId = &#63; and guestbookTId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param status the status
	 * @return the matching guestbook t entries
	 */
	public static List<GuestbookTEntry> findByG_G_S(
		long groupId, long guestbookTId, int status) {

		return getPersistence().findByG_G_S(groupId, guestbookTId, status);
	}

	/**
	 * Returns a range of all the guestbook t entries where groupId = &#63; and guestbookTId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param status the status
	 * @param start the lower bound of the range of guestbook t entries
	 * @param end the upper bound of the range of guestbook t entries (not inclusive)
	 * @return the range of matching guestbook t entries
	 */
	public static List<GuestbookTEntry> findByG_G_S(
		long groupId, long guestbookTId, int status, int start, int end) {

		return getPersistence().findByG_G_S(
			groupId, guestbookTId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the guestbook t entries where groupId = &#63; and guestbookTId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param status the status
	 * @param start the lower bound of the range of guestbook t entries
	 * @param end the upper bound of the range of guestbook t entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching guestbook t entries
	 */
	public static List<GuestbookTEntry> findByG_G_S(
		long groupId, long guestbookTId, int status, int start, int end,
		OrderByComparator<GuestbookTEntry> orderByComparator) {

		return getPersistence().findByG_G_S(
			groupId, guestbookTId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the guestbook t entries where groupId = &#63; and guestbookTId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param status the status
	 * @param start the lower bound of the range of guestbook t entries
	 * @param end the upper bound of the range of guestbook t entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching guestbook t entries
	 */
	public static List<GuestbookTEntry> findByG_G_S(
		long groupId, long guestbookTId, int status, int start, int end,
		OrderByComparator<GuestbookTEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_G_S(
			groupId, guestbookTId, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first guestbook t entry in the ordered set where groupId = &#63; and guestbookTId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching guestbook t entry
	 * @throws NoSuchGuestbookTEntryException if a matching guestbook t entry could not be found
	 */
	public static GuestbookTEntry findByG_G_S_First(
			long groupId, long guestbookTId, int status,
			OrderByComparator<GuestbookTEntry> orderByComparator)
		throws com.tutorial.guestbookt.exception.
			NoSuchGuestbookTEntryException {

		return getPersistence().findByG_G_S_First(
			groupId, guestbookTId, status, orderByComparator);
	}

	/**
	 * Returns the first guestbook t entry in the ordered set where groupId = &#63; and guestbookTId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching guestbook t entry, or <code>null</code> if a matching guestbook t entry could not be found
	 */
	public static GuestbookTEntry fetchByG_G_S_First(
		long groupId, long guestbookTId, int status,
		OrderByComparator<GuestbookTEntry> orderByComparator) {

		return getPersistence().fetchByG_G_S_First(
			groupId, guestbookTId, status, orderByComparator);
	}

	/**
	 * Returns the last guestbook t entry in the ordered set where groupId = &#63; and guestbookTId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching guestbook t entry
	 * @throws NoSuchGuestbookTEntryException if a matching guestbook t entry could not be found
	 */
	public static GuestbookTEntry findByG_G_S_Last(
			long groupId, long guestbookTId, int status,
			OrderByComparator<GuestbookTEntry> orderByComparator)
		throws com.tutorial.guestbookt.exception.
			NoSuchGuestbookTEntryException {

		return getPersistence().findByG_G_S_Last(
			groupId, guestbookTId, status, orderByComparator);
	}

	/**
	 * Returns the last guestbook t entry in the ordered set where groupId = &#63; and guestbookTId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching guestbook t entry, or <code>null</code> if a matching guestbook t entry could not be found
	 */
	public static GuestbookTEntry fetchByG_G_S_Last(
		long groupId, long guestbookTId, int status,
		OrderByComparator<GuestbookTEntry> orderByComparator) {

		return getPersistence().fetchByG_G_S_Last(
			groupId, guestbookTId, status, orderByComparator);
	}

	/**
	 * Returns the guestbook t entries before and after the current guestbook t entry in the ordered set where groupId = &#63; and guestbookTId = &#63; and status = &#63;.
	 *
	 * @param entryId the primary key of the current guestbook t entry
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next guestbook t entry
	 * @throws NoSuchGuestbookTEntryException if a guestbook t entry with the primary key could not be found
	 */
	public static GuestbookTEntry[] findByG_G_S_PrevAndNext(
			long entryId, long groupId, long guestbookTId, int status,
			OrderByComparator<GuestbookTEntry> orderByComparator)
		throws com.tutorial.guestbookt.exception.
			NoSuchGuestbookTEntryException {

		return getPersistence().findByG_G_S_PrevAndNext(
			entryId, groupId, guestbookTId, status, orderByComparator);
	}

	/**
	 * Returns all the guestbook t entries that the user has permission to view where groupId = &#63; and guestbookTId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param status the status
	 * @return the matching guestbook t entries that the user has permission to view
	 */
	public static List<GuestbookTEntry> filterFindByG_G_S(
		long groupId, long guestbookTId, int status) {

		return getPersistence().filterFindByG_G_S(
			groupId, guestbookTId, status);
	}

	/**
	 * Returns a range of all the guestbook t entries that the user has permission to view where groupId = &#63; and guestbookTId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param status the status
	 * @param start the lower bound of the range of guestbook t entries
	 * @param end the upper bound of the range of guestbook t entries (not inclusive)
	 * @return the range of matching guestbook t entries that the user has permission to view
	 */
	public static List<GuestbookTEntry> filterFindByG_G_S(
		long groupId, long guestbookTId, int status, int start, int end) {

		return getPersistence().filterFindByG_G_S(
			groupId, guestbookTId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the guestbook t entries that the user has permissions to view where groupId = &#63; and guestbookTId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param status the status
	 * @param start the lower bound of the range of guestbook t entries
	 * @param end the upper bound of the range of guestbook t entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching guestbook t entries that the user has permission to view
	 */
	public static List<GuestbookTEntry> filterFindByG_G_S(
		long groupId, long guestbookTId, int status, int start, int end,
		OrderByComparator<GuestbookTEntry> orderByComparator) {

		return getPersistence().filterFindByG_G_S(
			groupId, guestbookTId, status, start, end, orderByComparator);
	}

	/**
	 * Returns the guestbook t entries before and after the current guestbook t entry in the ordered set of guestbook t entries that the user has permission to view where groupId = &#63; and guestbookTId = &#63; and status = &#63;.
	 *
	 * @param entryId the primary key of the current guestbook t entry
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next guestbook t entry
	 * @throws NoSuchGuestbookTEntryException if a guestbook t entry with the primary key could not be found
	 */
	public static GuestbookTEntry[] filterFindByG_G_S_PrevAndNext(
			long entryId, long groupId, long guestbookTId, int status,
			OrderByComparator<GuestbookTEntry> orderByComparator)
		throws com.tutorial.guestbookt.exception.
			NoSuchGuestbookTEntryException {

		return getPersistence().filterFindByG_G_S_PrevAndNext(
			entryId, groupId, guestbookTId, status, orderByComparator);
	}

	/**
	 * Removes all the guestbook t entries where groupId = &#63; and guestbookTId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param status the status
	 */
	public static void removeByG_G_S(
		long groupId, long guestbookTId, int status) {

		getPersistence().removeByG_G_S(groupId, guestbookTId, status);
	}

	/**
	 * Returns the number of guestbook t entries where groupId = &#63; and guestbookTId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param status the status
	 * @return the number of matching guestbook t entries
	 */
	public static int countByG_G_S(
		long groupId, long guestbookTId, int status) {

		return getPersistence().countByG_G_S(groupId, guestbookTId, status);
	}

	/**
	 * Returns the number of guestbook t entries that the user has permission to view where groupId = &#63; and guestbookTId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param status the status
	 * @return the number of matching guestbook t entries that the user has permission to view
	 */
	public static int filterCountByG_G_S(
		long groupId, long guestbookTId, int status) {

		return getPersistence().filterCountByG_G_S(
			groupId, guestbookTId, status);
	}

	/**
	 * Caches the guestbook t entry in the entity cache if it is enabled.
	 *
	 * @param guestbookTEntry the guestbook t entry
	 */
	public static void cacheResult(GuestbookTEntry guestbookTEntry) {
		getPersistence().cacheResult(guestbookTEntry);
	}

	/**
	 * Caches the guestbook t entries in the entity cache if it is enabled.
	 *
	 * @param guestbookTEntries the guestbook t entries
	 */
	public static void cacheResult(List<GuestbookTEntry> guestbookTEntries) {
		getPersistence().cacheResult(guestbookTEntries);
	}

	/**
	 * Creates a new guestbook t entry with the primary key. Does not add the guestbook t entry to the database.
	 *
	 * @param entryId the primary key for the new guestbook t entry
	 * @return the new guestbook t entry
	 */
	public static GuestbookTEntry create(long entryId) {
		return getPersistence().create(entryId);
	}

	/**
	 * Removes the guestbook t entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entryId the primary key of the guestbook t entry
	 * @return the guestbook t entry that was removed
	 * @throws NoSuchGuestbookTEntryException if a guestbook t entry with the primary key could not be found
	 */
	public static GuestbookTEntry remove(long entryId)
		throws com.tutorial.guestbookt.exception.
			NoSuchGuestbookTEntryException {

		return getPersistence().remove(entryId);
	}

	public static GuestbookTEntry updateImpl(GuestbookTEntry guestbookTEntry) {
		return getPersistence().updateImpl(guestbookTEntry);
	}

	/**
	 * Returns the guestbook t entry with the primary key or throws a <code>NoSuchGuestbookTEntryException</code> if it could not be found.
	 *
	 * @param entryId the primary key of the guestbook t entry
	 * @return the guestbook t entry
	 * @throws NoSuchGuestbookTEntryException if a guestbook t entry with the primary key could not be found
	 */
	public static GuestbookTEntry findByPrimaryKey(long entryId)
		throws com.tutorial.guestbookt.exception.
			NoSuchGuestbookTEntryException {

		return getPersistence().findByPrimaryKey(entryId);
	}

	/**
	 * Returns the guestbook t entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param entryId the primary key of the guestbook t entry
	 * @return the guestbook t entry, or <code>null</code> if a guestbook t entry with the primary key could not be found
	 */
	public static GuestbookTEntry fetchByPrimaryKey(long entryId) {
		return getPersistence().fetchByPrimaryKey(entryId);
	}

	/**
	 * Returns all the guestbook t entries.
	 *
	 * @return the guestbook t entries
	 */
	public static List<GuestbookTEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the guestbook t entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of guestbook t entries
	 * @param end the upper bound of the range of guestbook t entries (not inclusive)
	 * @return the range of guestbook t entries
	 */
	public static List<GuestbookTEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the guestbook t entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of guestbook t entries
	 * @param end the upper bound of the range of guestbook t entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of guestbook t entries
	 */
	public static List<GuestbookTEntry> findAll(
		int start, int end,
		OrderByComparator<GuestbookTEntry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the guestbook t entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of guestbook t entries
	 * @param end the upper bound of the range of guestbook t entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of guestbook t entries
	 */
	public static List<GuestbookTEntry> findAll(
		int start, int end,
		OrderByComparator<GuestbookTEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the guestbook t entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of guestbook t entries.
	 *
	 * @return the number of guestbook t entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static GuestbookTEntryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile GuestbookTEntryPersistence _persistence;

}