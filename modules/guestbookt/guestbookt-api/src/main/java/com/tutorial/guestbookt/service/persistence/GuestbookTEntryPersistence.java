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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.tutorial.guestbookt.exception.NoSuchGuestbookTEntryException;
import com.tutorial.guestbookt.model.GuestbookTEntry;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the guestbook t entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Andrea Luzzi
 * @see GuestbookTEntryUtil
 * @generated
 */
@ProviderType
public interface GuestbookTEntryPersistence
	extends BasePersistence<GuestbookTEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GuestbookTEntryUtil} to access the guestbook t entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the guestbook t entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching guestbook t entries
	 */
	public java.util.List<GuestbookTEntry> findByUuid(String uuid);

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
	public java.util.List<GuestbookTEntry> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<GuestbookTEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GuestbookTEntry>
			orderByComparator);

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
	public java.util.List<GuestbookTEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GuestbookTEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first guestbook t entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching guestbook t entry
	 * @throws NoSuchGuestbookTEntryException if a matching guestbook t entry could not be found
	 */
	public GuestbookTEntry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<GuestbookTEntry>
				orderByComparator)
		throws NoSuchGuestbookTEntryException;

	/**
	 * Returns the first guestbook t entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching guestbook t entry, or <code>null</code> if a matching guestbook t entry could not be found
	 */
	public GuestbookTEntry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<GuestbookTEntry>
			orderByComparator);

	/**
	 * Returns the last guestbook t entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching guestbook t entry
	 * @throws NoSuchGuestbookTEntryException if a matching guestbook t entry could not be found
	 */
	public GuestbookTEntry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<GuestbookTEntry>
				orderByComparator)
		throws NoSuchGuestbookTEntryException;

	/**
	 * Returns the last guestbook t entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching guestbook t entry, or <code>null</code> if a matching guestbook t entry could not be found
	 */
	public GuestbookTEntry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<GuestbookTEntry>
			orderByComparator);

	/**
	 * Returns the guestbook t entries before and after the current guestbook t entry in the ordered set where uuid = &#63;.
	 *
	 * @param entryId the primary key of the current guestbook t entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next guestbook t entry
	 * @throws NoSuchGuestbookTEntryException if a guestbook t entry with the primary key could not be found
	 */
	public GuestbookTEntry[] findByUuid_PrevAndNext(
			long entryId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<GuestbookTEntry>
				orderByComparator)
		throws NoSuchGuestbookTEntryException;

	/**
	 * Removes all the guestbook t entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of guestbook t entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching guestbook t entries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the guestbook t entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchGuestbookTEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching guestbook t entry
	 * @throws NoSuchGuestbookTEntryException if a matching guestbook t entry could not be found
	 */
	public GuestbookTEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchGuestbookTEntryException;

	/**
	 * Returns the guestbook t entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching guestbook t entry, or <code>null</code> if a matching guestbook t entry could not be found
	 */
	public GuestbookTEntry fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the guestbook t entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching guestbook t entry, or <code>null</code> if a matching guestbook t entry could not be found
	 */
	public GuestbookTEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the guestbook t entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the guestbook t entry that was removed
	 */
	public GuestbookTEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchGuestbookTEntryException;

	/**
	 * Returns the number of guestbook t entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching guestbook t entries
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the guestbook t entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching guestbook t entries
	 */
	public java.util.List<GuestbookTEntry> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<GuestbookTEntry> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<GuestbookTEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GuestbookTEntry>
			orderByComparator);

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
	public java.util.List<GuestbookTEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GuestbookTEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first guestbook t entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching guestbook t entry
	 * @throws NoSuchGuestbookTEntryException if a matching guestbook t entry could not be found
	 */
	public GuestbookTEntry findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<GuestbookTEntry>
				orderByComparator)
		throws NoSuchGuestbookTEntryException;

	/**
	 * Returns the first guestbook t entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching guestbook t entry, or <code>null</code> if a matching guestbook t entry could not be found
	 */
	public GuestbookTEntry fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<GuestbookTEntry>
			orderByComparator);

	/**
	 * Returns the last guestbook t entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching guestbook t entry
	 * @throws NoSuchGuestbookTEntryException if a matching guestbook t entry could not be found
	 */
	public GuestbookTEntry findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<GuestbookTEntry>
				orderByComparator)
		throws NoSuchGuestbookTEntryException;

	/**
	 * Returns the last guestbook t entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching guestbook t entry, or <code>null</code> if a matching guestbook t entry could not be found
	 */
	public GuestbookTEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<GuestbookTEntry>
			orderByComparator);

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
	public GuestbookTEntry[] findByUuid_C_PrevAndNext(
			long entryId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<GuestbookTEntry>
				orderByComparator)
		throws NoSuchGuestbookTEntryException;

	/**
	 * Removes all the guestbook t entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of guestbook t entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching guestbook t entries
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the guestbook t entries where groupId = &#63; and guestbookTId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @return the matching guestbook t entries
	 */
	public java.util.List<GuestbookTEntry> findByG_G(
		long groupId, long guestbookTId);

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
	public java.util.List<GuestbookTEntry> findByG_G(
		long groupId, long guestbookTId, int start, int end);

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
	public java.util.List<GuestbookTEntry> findByG_G(
		long groupId, long guestbookTId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GuestbookTEntry>
			orderByComparator);

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
	public java.util.List<GuestbookTEntry> findByG_G(
		long groupId, long guestbookTId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GuestbookTEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first guestbook t entry in the ordered set where groupId = &#63; and guestbookTId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching guestbook t entry
	 * @throws NoSuchGuestbookTEntryException if a matching guestbook t entry could not be found
	 */
	public GuestbookTEntry findByG_G_First(
			long groupId, long guestbookTId,
			com.liferay.portal.kernel.util.OrderByComparator<GuestbookTEntry>
				orderByComparator)
		throws NoSuchGuestbookTEntryException;

	/**
	 * Returns the first guestbook t entry in the ordered set where groupId = &#63; and guestbookTId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching guestbook t entry, or <code>null</code> if a matching guestbook t entry could not be found
	 */
	public GuestbookTEntry fetchByG_G_First(
		long groupId, long guestbookTId,
		com.liferay.portal.kernel.util.OrderByComparator<GuestbookTEntry>
			orderByComparator);

	/**
	 * Returns the last guestbook t entry in the ordered set where groupId = &#63; and guestbookTId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching guestbook t entry
	 * @throws NoSuchGuestbookTEntryException if a matching guestbook t entry could not be found
	 */
	public GuestbookTEntry findByG_G_Last(
			long groupId, long guestbookTId,
			com.liferay.portal.kernel.util.OrderByComparator<GuestbookTEntry>
				orderByComparator)
		throws NoSuchGuestbookTEntryException;

	/**
	 * Returns the last guestbook t entry in the ordered set where groupId = &#63; and guestbookTId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching guestbook t entry, or <code>null</code> if a matching guestbook t entry could not be found
	 */
	public GuestbookTEntry fetchByG_G_Last(
		long groupId, long guestbookTId,
		com.liferay.portal.kernel.util.OrderByComparator<GuestbookTEntry>
			orderByComparator);

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
	public GuestbookTEntry[] findByG_G_PrevAndNext(
			long entryId, long groupId, long guestbookTId,
			com.liferay.portal.kernel.util.OrderByComparator<GuestbookTEntry>
				orderByComparator)
		throws NoSuchGuestbookTEntryException;

	/**
	 * Returns all the guestbook t entries that the user has permission to view where groupId = &#63; and guestbookTId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @return the matching guestbook t entries that the user has permission to view
	 */
	public java.util.List<GuestbookTEntry> filterFindByG_G(
		long groupId, long guestbookTId);

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
	public java.util.List<GuestbookTEntry> filterFindByG_G(
		long groupId, long guestbookTId, int start, int end);

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
	public java.util.List<GuestbookTEntry> filterFindByG_G(
		long groupId, long guestbookTId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GuestbookTEntry>
			orderByComparator);

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
	public GuestbookTEntry[] filterFindByG_G_PrevAndNext(
			long entryId, long groupId, long guestbookTId,
			com.liferay.portal.kernel.util.OrderByComparator<GuestbookTEntry>
				orderByComparator)
		throws NoSuchGuestbookTEntryException;

	/**
	 * Removes all the guestbook t entries where groupId = &#63; and guestbookTId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 */
	public void removeByG_G(long groupId, long guestbookTId);

	/**
	 * Returns the number of guestbook t entries where groupId = &#63; and guestbookTId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @return the number of matching guestbook t entries
	 */
	public int countByG_G(long groupId, long guestbookTId);

	/**
	 * Returns the number of guestbook t entries that the user has permission to view where groupId = &#63; and guestbookTId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @return the number of matching guestbook t entries that the user has permission to view
	 */
	public int filterCountByG_G(long groupId, long guestbookTId);

	/**
	 * Returns all the guestbook t entries where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching guestbook t entries
	 */
	public java.util.List<GuestbookTEntry> findByStatus(int status);

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
	public java.util.List<GuestbookTEntry> findByStatus(
		int status, int start, int end);

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
	public java.util.List<GuestbookTEntry> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GuestbookTEntry>
			orderByComparator);

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
	public java.util.List<GuestbookTEntry> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GuestbookTEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first guestbook t entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching guestbook t entry
	 * @throws NoSuchGuestbookTEntryException if a matching guestbook t entry could not be found
	 */
	public GuestbookTEntry findByStatus_First(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<GuestbookTEntry>
				orderByComparator)
		throws NoSuchGuestbookTEntryException;

	/**
	 * Returns the first guestbook t entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching guestbook t entry, or <code>null</code> if a matching guestbook t entry could not be found
	 */
	public GuestbookTEntry fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<GuestbookTEntry>
			orderByComparator);

	/**
	 * Returns the last guestbook t entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching guestbook t entry
	 * @throws NoSuchGuestbookTEntryException if a matching guestbook t entry could not be found
	 */
	public GuestbookTEntry findByStatus_Last(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<GuestbookTEntry>
				orderByComparator)
		throws NoSuchGuestbookTEntryException;

	/**
	 * Returns the last guestbook t entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching guestbook t entry, or <code>null</code> if a matching guestbook t entry could not be found
	 */
	public GuestbookTEntry fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<GuestbookTEntry>
			orderByComparator);

	/**
	 * Returns the guestbook t entries before and after the current guestbook t entry in the ordered set where status = &#63;.
	 *
	 * @param entryId the primary key of the current guestbook t entry
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next guestbook t entry
	 * @throws NoSuchGuestbookTEntryException if a guestbook t entry with the primary key could not be found
	 */
	public GuestbookTEntry[] findByStatus_PrevAndNext(
			long entryId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<GuestbookTEntry>
				orderByComparator)
		throws NoSuchGuestbookTEntryException;

	/**
	 * Removes all the guestbook t entries where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByStatus(int status);

	/**
	 * Returns the number of guestbook t entries where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching guestbook t entries
	 */
	public int countByStatus(int status);

	/**
	 * Returns all the guestbook t entries where groupId = &#63; and guestbookTId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param status the status
	 * @return the matching guestbook t entries
	 */
	public java.util.List<GuestbookTEntry> findByG_G_S(
		long groupId, long guestbookTId, int status);

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
	public java.util.List<GuestbookTEntry> findByG_G_S(
		long groupId, long guestbookTId, int status, int start, int end);

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
	public java.util.List<GuestbookTEntry> findByG_G_S(
		long groupId, long guestbookTId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GuestbookTEntry>
			orderByComparator);

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
	public java.util.List<GuestbookTEntry> findByG_G_S(
		long groupId, long guestbookTId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GuestbookTEntry>
			orderByComparator,
		boolean useFinderCache);

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
	public GuestbookTEntry findByG_G_S_First(
			long groupId, long guestbookTId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<GuestbookTEntry>
				orderByComparator)
		throws NoSuchGuestbookTEntryException;

	/**
	 * Returns the first guestbook t entry in the ordered set where groupId = &#63; and guestbookTId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching guestbook t entry, or <code>null</code> if a matching guestbook t entry could not be found
	 */
	public GuestbookTEntry fetchByG_G_S_First(
		long groupId, long guestbookTId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<GuestbookTEntry>
			orderByComparator);

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
	public GuestbookTEntry findByG_G_S_Last(
			long groupId, long guestbookTId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<GuestbookTEntry>
				orderByComparator)
		throws NoSuchGuestbookTEntryException;

	/**
	 * Returns the last guestbook t entry in the ordered set where groupId = &#63; and guestbookTId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching guestbook t entry, or <code>null</code> if a matching guestbook t entry could not be found
	 */
	public GuestbookTEntry fetchByG_G_S_Last(
		long groupId, long guestbookTId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<GuestbookTEntry>
			orderByComparator);

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
	public GuestbookTEntry[] findByG_G_S_PrevAndNext(
			long entryId, long groupId, long guestbookTId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<GuestbookTEntry>
				orderByComparator)
		throws NoSuchGuestbookTEntryException;

	/**
	 * Returns all the guestbook t entries that the user has permission to view where groupId = &#63; and guestbookTId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param status the status
	 * @return the matching guestbook t entries that the user has permission to view
	 */
	public java.util.List<GuestbookTEntry> filterFindByG_G_S(
		long groupId, long guestbookTId, int status);

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
	public java.util.List<GuestbookTEntry> filterFindByG_G_S(
		long groupId, long guestbookTId, int status, int start, int end);

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
	public java.util.List<GuestbookTEntry> filterFindByG_G_S(
		long groupId, long guestbookTId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GuestbookTEntry>
			orderByComparator);

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
	public GuestbookTEntry[] filterFindByG_G_S_PrevAndNext(
			long entryId, long groupId, long guestbookTId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<GuestbookTEntry>
				orderByComparator)
		throws NoSuchGuestbookTEntryException;

	/**
	 * Removes all the guestbook t entries where groupId = &#63; and guestbookTId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param status the status
	 */
	public void removeByG_G_S(long groupId, long guestbookTId, int status);

	/**
	 * Returns the number of guestbook t entries where groupId = &#63; and guestbookTId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param status the status
	 * @return the number of matching guestbook t entries
	 */
	public int countByG_G_S(long groupId, long guestbookTId, int status);

	/**
	 * Returns the number of guestbook t entries that the user has permission to view where groupId = &#63; and guestbookTId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param status the status
	 * @return the number of matching guestbook t entries that the user has permission to view
	 */
	public int filterCountByG_G_S(long groupId, long guestbookTId, int status);

	/**
	 * Caches the guestbook t entry in the entity cache if it is enabled.
	 *
	 * @param guestbookTEntry the guestbook t entry
	 */
	public void cacheResult(GuestbookTEntry guestbookTEntry);

	/**
	 * Caches the guestbook t entries in the entity cache if it is enabled.
	 *
	 * @param guestbookTEntries the guestbook t entries
	 */
	public void cacheResult(java.util.List<GuestbookTEntry> guestbookTEntries);

	/**
	 * Creates a new guestbook t entry with the primary key. Does not add the guestbook t entry to the database.
	 *
	 * @param entryId the primary key for the new guestbook t entry
	 * @return the new guestbook t entry
	 */
	public GuestbookTEntry create(long entryId);

	/**
	 * Removes the guestbook t entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entryId the primary key of the guestbook t entry
	 * @return the guestbook t entry that was removed
	 * @throws NoSuchGuestbookTEntryException if a guestbook t entry with the primary key could not be found
	 */
	public GuestbookTEntry remove(long entryId)
		throws NoSuchGuestbookTEntryException;

	public GuestbookTEntry updateImpl(GuestbookTEntry guestbookTEntry);

	/**
	 * Returns the guestbook t entry with the primary key or throws a <code>NoSuchGuestbookTEntryException</code> if it could not be found.
	 *
	 * @param entryId the primary key of the guestbook t entry
	 * @return the guestbook t entry
	 * @throws NoSuchGuestbookTEntryException if a guestbook t entry with the primary key could not be found
	 */
	public GuestbookTEntry findByPrimaryKey(long entryId)
		throws NoSuchGuestbookTEntryException;

	/**
	 * Returns the guestbook t entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param entryId the primary key of the guestbook t entry
	 * @return the guestbook t entry, or <code>null</code> if a guestbook t entry with the primary key could not be found
	 */
	public GuestbookTEntry fetchByPrimaryKey(long entryId);

	/**
	 * Returns all the guestbook t entries.
	 *
	 * @return the guestbook t entries
	 */
	public java.util.List<GuestbookTEntry> findAll();

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
	public java.util.List<GuestbookTEntry> findAll(int start, int end);

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
	public java.util.List<GuestbookTEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GuestbookTEntry>
			orderByComparator);

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
	public java.util.List<GuestbookTEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GuestbookTEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the guestbook t entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of guestbook t entries.
	 *
	 * @return the number of guestbook t entries
	 */
	public int countAll();

}