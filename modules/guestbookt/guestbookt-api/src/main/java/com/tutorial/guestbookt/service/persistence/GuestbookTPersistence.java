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

import com.tutorial.guestbookt.exception.NoSuchGuestbookTException;
import com.tutorial.guestbookt.model.GuestbookT;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the guestbook t service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Andrea Luzzi
 * @see GuestbookTUtil
 * @generated
 */
@ProviderType
public interface GuestbookTPersistence extends BasePersistence<GuestbookT> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GuestbookTUtil} to access the guestbook t persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the guestbook ts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching guestbook ts
	 */
	public java.util.List<GuestbookT> findByUuid(String uuid);

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
	public java.util.List<GuestbookT> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<GuestbookT> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GuestbookT>
			orderByComparator);

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
	public java.util.List<GuestbookT> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GuestbookT>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first guestbook t in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching guestbook t
	 * @throws NoSuchGuestbookTException if a matching guestbook t could not be found
	 */
	public GuestbookT findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<GuestbookT>
				orderByComparator)
		throws NoSuchGuestbookTException;

	/**
	 * Returns the first guestbook t in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching guestbook t, or <code>null</code> if a matching guestbook t could not be found
	 */
	public GuestbookT fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<GuestbookT>
			orderByComparator);

	/**
	 * Returns the last guestbook t in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching guestbook t
	 * @throws NoSuchGuestbookTException if a matching guestbook t could not be found
	 */
	public GuestbookT findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<GuestbookT>
				orderByComparator)
		throws NoSuchGuestbookTException;

	/**
	 * Returns the last guestbook t in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching guestbook t, or <code>null</code> if a matching guestbook t could not be found
	 */
	public GuestbookT fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<GuestbookT>
			orderByComparator);

	/**
	 * Returns the guestbook ts before and after the current guestbook t in the ordered set where uuid = &#63;.
	 *
	 * @param guestbookTId the primary key of the current guestbook t
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next guestbook t
	 * @throws NoSuchGuestbookTException if a guestbook t with the primary key could not be found
	 */
	public GuestbookT[] findByUuid_PrevAndNext(
			long guestbookTId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<GuestbookT>
				orderByComparator)
		throws NoSuchGuestbookTException;

	/**
	 * Removes all the guestbook ts where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of guestbook ts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching guestbook ts
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the guestbook t where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchGuestbookTException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching guestbook t
	 * @throws NoSuchGuestbookTException if a matching guestbook t could not be found
	 */
	public GuestbookT findByUUID_G(String uuid, long groupId)
		throws NoSuchGuestbookTException;

	/**
	 * Returns the guestbook t where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching guestbook t, or <code>null</code> if a matching guestbook t could not be found
	 */
	public GuestbookT fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the guestbook t where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching guestbook t, or <code>null</code> if a matching guestbook t could not be found
	 */
	public GuestbookT fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the guestbook t where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the guestbook t that was removed
	 */
	public GuestbookT removeByUUID_G(String uuid, long groupId)
		throws NoSuchGuestbookTException;

	/**
	 * Returns the number of guestbook ts where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching guestbook ts
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the guestbook ts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching guestbook ts
	 */
	public java.util.List<GuestbookT> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<GuestbookT> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<GuestbookT> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GuestbookT>
			orderByComparator);

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
	public java.util.List<GuestbookT> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GuestbookT>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first guestbook t in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching guestbook t
	 * @throws NoSuchGuestbookTException if a matching guestbook t could not be found
	 */
	public GuestbookT findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<GuestbookT>
				orderByComparator)
		throws NoSuchGuestbookTException;

	/**
	 * Returns the first guestbook t in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching guestbook t, or <code>null</code> if a matching guestbook t could not be found
	 */
	public GuestbookT fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<GuestbookT>
			orderByComparator);

	/**
	 * Returns the last guestbook t in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching guestbook t
	 * @throws NoSuchGuestbookTException if a matching guestbook t could not be found
	 */
	public GuestbookT findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<GuestbookT>
				orderByComparator)
		throws NoSuchGuestbookTException;

	/**
	 * Returns the last guestbook t in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching guestbook t, or <code>null</code> if a matching guestbook t could not be found
	 */
	public GuestbookT fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<GuestbookT>
			orderByComparator);

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
	public GuestbookT[] findByUuid_C_PrevAndNext(
			long guestbookTId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<GuestbookT>
				orderByComparator)
		throws NoSuchGuestbookTException;

	/**
	 * Removes all the guestbook ts where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of guestbook ts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching guestbook ts
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the guestbook ts where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching guestbook ts
	 */
	public java.util.List<GuestbookT> findByGroupId(long groupId);

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
	public java.util.List<GuestbookT> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<GuestbookT> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GuestbookT>
			orderByComparator);

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
	public java.util.List<GuestbookT> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GuestbookT>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first guestbook t in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching guestbook t
	 * @throws NoSuchGuestbookTException if a matching guestbook t could not be found
	 */
	public GuestbookT findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<GuestbookT>
				orderByComparator)
		throws NoSuchGuestbookTException;

	/**
	 * Returns the first guestbook t in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching guestbook t, or <code>null</code> if a matching guestbook t could not be found
	 */
	public GuestbookT fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<GuestbookT>
			orderByComparator);

	/**
	 * Returns the last guestbook t in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching guestbook t
	 * @throws NoSuchGuestbookTException if a matching guestbook t could not be found
	 */
	public GuestbookT findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<GuestbookT>
				orderByComparator)
		throws NoSuchGuestbookTException;

	/**
	 * Returns the last guestbook t in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching guestbook t, or <code>null</code> if a matching guestbook t could not be found
	 */
	public GuestbookT fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<GuestbookT>
			orderByComparator);

	/**
	 * Returns the guestbook ts before and after the current guestbook t in the ordered set where groupId = &#63;.
	 *
	 * @param guestbookTId the primary key of the current guestbook t
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next guestbook t
	 * @throws NoSuchGuestbookTException if a guestbook t with the primary key could not be found
	 */
	public GuestbookT[] findByGroupId_PrevAndNext(
			long guestbookTId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<GuestbookT>
				orderByComparator)
		throws NoSuchGuestbookTException;

	/**
	 * Returns all the guestbook ts that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching guestbook ts that the user has permission to view
	 */
	public java.util.List<GuestbookT> filterFindByGroupId(long groupId);

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
	public java.util.List<GuestbookT> filterFindByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<GuestbookT> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GuestbookT>
			orderByComparator);

	/**
	 * Returns the guestbook ts before and after the current guestbook t in the ordered set of guestbook ts that the user has permission to view where groupId = &#63;.
	 *
	 * @param guestbookTId the primary key of the current guestbook t
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next guestbook t
	 * @throws NoSuchGuestbookTException if a guestbook t with the primary key could not be found
	 */
	public GuestbookT[] filterFindByGroupId_PrevAndNext(
			long guestbookTId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<GuestbookT>
				orderByComparator)
		throws NoSuchGuestbookTException;

	/**
	 * Removes all the guestbook ts where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of guestbook ts where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching guestbook ts
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns the number of guestbook ts that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching guestbook ts that the user has permission to view
	 */
	public int filterCountByGroupId(long groupId);

	/**
	 * Returns all the guestbook ts where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching guestbook ts
	 */
	public java.util.List<GuestbookT> findByStatus(int status);

	/**
	 * Returns a range of all the guestbook ts where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of guestbook ts
	 * @param end the upper bound of the range of guestbook ts (not inclusive)
	 * @return the range of matching guestbook ts
	 */
	public java.util.List<GuestbookT> findByStatus(
		int status, int start, int end);

	/**
	 * Returns an ordered range of all the guestbook ts where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of guestbook ts
	 * @param end the upper bound of the range of guestbook ts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching guestbook ts
	 */
	public java.util.List<GuestbookT> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GuestbookT>
			orderByComparator);

	/**
	 * Returns an ordered range of all the guestbook ts where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of guestbook ts
	 * @param end the upper bound of the range of guestbook ts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching guestbook ts
	 */
	public java.util.List<GuestbookT> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GuestbookT>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first guestbook t in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching guestbook t
	 * @throws NoSuchGuestbookTException if a matching guestbook t could not be found
	 */
	public GuestbookT findByStatus_First(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<GuestbookT>
				orderByComparator)
		throws NoSuchGuestbookTException;

	/**
	 * Returns the first guestbook t in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching guestbook t, or <code>null</code> if a matching guestbook t could not be found
	 */
	public GuestbookT fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<GuestbookT>
			orderByComparator);

	/**
	 * Returns the last guestbook t in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching guestbook t
	 * @throws NoSuchGuestbookTException if a matching guestbook t could not be found
	 */
	public GuestbookT findByStatus_Last(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<GuestbookT>
				orderByComparator)
		throws NoSuchGuestbookTException;

	/**
	 * Returns the last guestbook t in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching guestbook t, or <code>null</code> if a matching guestbook t could not be found
	 */
	public GuestbookT fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<GuestbookT>
			orderByComparator);

	/**
	 * Returns the guestbook ts before and after the current guestbook t in the ordered set where status = &#63;.
	 *
	 * @param guestbookTId the primary key of the current guestbook t
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next guestbook t
	 * @throws NoSuchGuestbookTException if a guestbook t with the primary key could not be found
	 */
	public GuestbookT[] findByStatus_PrevAndNext(
			long guestbookTId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<GuestbookT>
				orderByComparator)
		throws NoSuchGuestbookTException;

	/**
	 * Removes all the guestbook ts where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByStatus(int status);

	/**
	 * Returns the number of guestbook ts where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching guestbook ts
	 */
	public int countByStatus(int status);

	/**
	 * Returns all the guestbook ts where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching guestbook ts
	 */
	public java.util.List<GuestbookT> findByG_S(long groupId, int status);

	/**
	 * Returns a range of all the guestbook ts where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of guestbook ts
	 * @param end the upper bound of the range of guestbook ts (not inclusive)
	 * @return the range of matching guestbook ts
	 */
	public java.util.List<GuestbookT> findByG_S(
		long groupId, int status, int start, int end);

	/**
	 * Returns an ordered range of all the guestbook ts where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of guestbook ts
	 * @param end the upper bound of the range of guestbook ts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching guestbook ts
	 */
	public java.util.List<GuestbookT> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GuestbookT>
			orderByComparator);

	/**
	 * Returns an ordered range of all the guestbook ts where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of guestbook ts
	 * @param end the upper bound of the range of guestbook ts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching guestbook ts
	 */
	public java.util.List<GuestbookT> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GuestbookT>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first guestbook t in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching guestbook t
	 * @throws NoSuchGuestbookTException if a matching guestbook t could not be found
	 */
	public GuestbookT findByG_S_First(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<GuestbookT>
				orderByComparator)
		throws NoSuchGuestbookTException;

	/**
	 * Returns the first guestbook t in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching guestbook t, or <code>null</code> if a matching guestbook t could not be found
	 */
	public GuestbookT fetchByG_S_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<GuestbookT>
			orderByComparator);

	/**
	 * Returns the last guestbook t in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching guestbook t
	 * @throws NoSuchGuestbookTException if a matching guestbook t could not be found
	 */
	public GuestbookT findByG_S_Last(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<GuestbookT>
				orderByComparator)
		throws NoSuchGuestbookTException;

	/**
	 * Returns the last guestbook t in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching guestbook t, or <code>null</code> if a matching guestbook t could not be found
	 */
	public GuestbookT fetchByG_S_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<GuestbookT>
			orderByComparator);

	/**
	 * Returns the guestbook ts before and after the current guestbook t in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param guestbookTId the primary key of the current guestbook t
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next guestbook t
	 * @throws NoSuchGuestbookTException if a guestbook t with the primary key could not be found
	 */
	public GuestbookT[] findByG_S_PrevAndNext(
			long guestbookTId, long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<GuestbookT>
				orderByComparator)
		throws NoSuchGuestbookTException;

	/**
	 * Returns all the guestbook ts that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching guestbook ts that the user has permission to view
	 */
	public java.util.List<GuestbookT> filterFindByG_S(long groupId, int status);

	/**
	 * Returns a range of all the guestbook ts that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of guestbook ts
	 * @param end the upper bound of the range of guestbook ts (not inclusive)
	 * @return the range of matching guestbook ts that the user has permission to view
	 */
	public java.util.List<GuestbookT> filterFindByG_S(
		long groupId, int status, int start, int end);

	/**
	 * Returns an ordered range of all the guestbook ts that the user has permissions to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of guestbook ts
	 * @param end the upper bound of the range of guestbook ts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching guestbook ts that the user has permission to view
	 */
	public java.util.List<GuestbookT> filterFindByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GuestbookT>
			orderByComparator);

	/**
	 * Returns the guestbook ts before and after the current guestbook t in the ordered set of guestbook ts that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param guestbookTId the primary key of the current guestbook t
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next guestbook t
	 * @throws NoSuchGuestbookTException if a guestbook t with the primary key could not be found
	 */
	public GuestbookT[] filterFindByG_S_PrevAndNext(
			long guestbookTId, long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<GuestbookT>
				orderByComparator)
		throws NoSuchGuestbookTException;

	/**
	 * Removes all the guestbook ts where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public void removeByG_S(long groupId, int status);

	/**
	 * Returns the number of guestbook ts where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching guestbook ts
	 */
	public int countByG_S(long groupId, int status);

	/**
	 * Returns the number of guestbook ts that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching guestbook ts that the user has permission to view
	 */
	public int filterCountByG_S(long groupId, int status);

	/**
	 * Caches the guestbook t in the entity cache if it is enabled.
	 *
	 * @param guestbookT the guestbook t
	 */
	public void cacheResult(GuestbookT guestbookT);

	/**
	 * Caches the guestbook ts in the entity cache if it is enabled.
	 *
	 * @param guestbookTs the guestbook ts
	 */
	public void cacheResult(java.util.List<GuestbookT> guestbookTs);

	/**
	 * Creates a new guestbook t with the primary key. Does not add the guestbook t to the database.
	 *
	 * @param guestbookTId the primary key for the new guestbook t
	 * @return the new guestbook t
	 */
	public GuestbookT create(long guestbookTId);

	/**
	 * Removes the guestbook t with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param guestbookTId the primary key of the guestbook t
	 * @return the guestbook t that was removed
	 * @throws NoSuchGuestbookTException if a guestbook t with the primary key could not be found
	 */
	public GuestbookT remove(long guestbookTId)
		throws NoSuchGuestbookTException;

	public GuestbookT updateImpl(GuestbookT guestbookT);

	/**
	 * Returns the guestbook t with the primary key or throws a <code>NoSuchGuestbookTException</code> if it could not be found.
	 *
	 * @param guestbookTId the primary key of the guestbook t
	 * @return the guestbook t
	 * @throws NoSuchGuestbookTException if a guestbook t with the primary key could not be found
	 */
	public GuestbookT findByPrimaryKey(long guestbookTId)
		throws NoSuchGuestbookTException;

	/**
	 * Returns the guestbook t with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param guestbookTId the primary key of the guestbook t
	 * @return the guestbook t, or <code>null</code> if a guestbook t with the primary key could not be found
	 */
	public GuestbookT fetchByPrimaryKey(long guestbookTId);

	/**
	 * Returns all the guestbook ts.
	 *
	 * @return the guestbook ts
	 */
	public java.util.List<GuestbookT> findAll();

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
	public java.util.List<GuestbookT> findAll(int start, int end);

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
	public java.util.List<GuestbookT> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GuestbookT>
			orderByComparator);

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
	public java.util.List<GuestbookT> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GuestbookT>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the guestbook ts from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of guestbook ts.
	 *
	 * @return the number of guestbook ts
	 */
	public int countAll();

}