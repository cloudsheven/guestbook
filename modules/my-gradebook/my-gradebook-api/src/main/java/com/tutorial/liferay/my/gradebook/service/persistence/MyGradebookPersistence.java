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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.tutorial.liferay.my.gradebook.exception.NoSuchMyGradebookException;
import com.tutorial.liferay.my.gradebook.model.MyGradebook;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the my gradebook service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Andrea Luzzi
 * @see MyGradebookUtil
 * @generated
 */
@ProviderType
public interface MyGradebookPersistence extends BasePersistence<MyGradebook> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MyGradebookUtil} to access the my gradebook persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the my gradebooks where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching my gradebooks
	 */
	public java.util.List<MyGradebook> findByUuid(String uuid);

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
	public java.util.List<MyGradebook> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<MyGradebook> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MyGradebook>
			orderByComparator);

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
	public java.util.List<MyGradebook> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MyGradebook>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first my gradebook in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching my gradebook
	 * @throws NoSuchMyGradebookException if a matching my gradebook could not be found
	 */
	public MyGradebook findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<MyGradebook>
				orderByComparator)
		throws NoSuchMyGradebookException;

	/**
	 * Returns the first my gradebook in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching my gradebook, or <code>null</code> if a matching my gradebook could not be found
	 */
	public MyGradebook fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<MyGradebook>
			orderByComparator);

	/**
	 * Returns the last my gradebook in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching my gradebook
	 * @throws NoSuchMyGradebookException if a matching my gradebook could not be found
	 */
	public MyGradebook findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<MyGradebook>
				orderByComparator)
		throws NoSuchMyGradebookException;

	/**
	 * Returns the last my gradebook in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching my gradebook, or <code>null</code> if a matching my gradebook could not be found
	 */
	public MyGradebook fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<MyGradebook>
			orderByComparator);

	/**
	 * Returns the my gradebooks before and after the current my gradebook in the ordered set where uuid = &#63;.
	 *
	 * @param myGradebookId the primary key of the current my gradebook
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next my gradebook
	 * @throws NoSuchMyGradebookException if a my gradebook with the primary key could not be found
	 */
	public MyGradebook[] findByUuid_PrevAndNext(
			long myGradebookId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<MyGradebook>
				orderByComparator)
		throws NoSuchMyGradebookException;

	/**
	 * Removes all the my gradebooks where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of my gradebooks where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching my gradebooks
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the my gradebook where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchMyGradebookException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching my gradebook
	 * @throws NoSuchMyGradebookException if a matching my gradebook could not be found
	 */
	public MyGradebook findByUUID_G(String uuid, long groupId)
		throws NoSuchMyGradebookException;

	/**
	 * Returns the my gradebook where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching my gradebook, or <code>null</code> if a matching my gradebook could not be found
	 */
	public MyGradebook fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the my gradebook where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching my gradebook, or <code>null</code> if a matching my gradebook could not be found
	 */
	public MyGradebook fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the my gradebook where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the my gradebook that was removed
	 */
	public MyGradebook removeByUUID_G(String uuid, long groupId)
		throws NoSuchMyGradebookException;

	/**
	 * Returns the number of my gradebooks where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching my gradebooks
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the my gradebooks where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching my gradebooks
	 */
	public java.util.List<MyGradebook> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<MyGradebook> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<MyGradebook> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MyGradebook>
			orderByComparator);

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
	public java.util.List<MyGradebook> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MyGradebook>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first my gradebook in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching my gradebook
	 * @throws NoSuchMyGradebookException if a matching my gradebook could not be found
	 */
	public MyGradebook findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<MyGradebook>
				orderByComparator)
		throws NoSuchMyGradebookException;

	/**
	 * Returns the first my gradebook in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching my gradebook, or <code>null</code> if a matching my gradebook could not be found
	 */
	public MyGradebook fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<MyGradebook>
			orderByComparator);

	/**
	 * Returns the last my gradebook in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching my gradebook
	 * @throws NoSuchMyGradebookException if a matching my gradebook could not be found
	 */
	public MyGradebook findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<MyGradebook>
				orderByComparator)
		throws NoSuchMyGradebookException;

	/**
	 * Returns the last my gradebook in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching my gradebook, or <code>null</code> if a matching my gradebook could not be found
	 */
	public MyGradebook fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<MyGradebook>
			orderByComparator);

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
	public MyGradebook[] findByUuid_C_PrevAndNext(
			long myGradebookId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<MyGradebook>
				orderByComparator)
		throws NoSuchMyGradebookException;

	/**
	 * Removes all the my gradebooks where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of my gradebooks where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching my gradebooks
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the my gradebooks where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching my gradebooks
	 */
	public java.util.List<MyGradebook> findByGroupId(long groupId);

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
	public java.util.List<MyGradebook> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<MyGradebook> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MyGradebook>
			orderByComparator);

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
	public java.util.List<MyGradebook> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MyGradebook>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first my gradebook in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching my gradebook
	 * @throws NoSuchMyGradebookException if a matching my gradebook could not be found
	 */
	public MyGradebook findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<MyGradebook>
				orderByComparator)
		throws NoSuchMyGradebookException;

	/**
	 * Returns the first my gradebook in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching my gradebook, or <code>null</code> if a matching my gradebook could not be found
	 */
	public MyGradebook fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<MyGradebook>
			orderByComparator);

	/**
	 * Returns the last my gradebook in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching my gradebook
	 * @throws NoSuchMyGradebookException if a matching my gradebook could not be found
	 */
	public MyGradebook findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<MyGradebook>
				orderByComparator)
		throws NoSuchMyGradebookException;

	/**
	 * Returns the last my gradebook in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching my gradebook, or <code>null</code> if a matching my gradebook could not be found
	 */
	public MyGradebook fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<MyGradebook>
			orderByComparator);

	/**
	 * Returns the my gradebooks before and after the current my gradebook in the ordered set where groupId = &#63;.
	 *
	 * @param myGradebookId the primary key of the current my gradebook
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next my gradebook
	 * @throws NoSuchMyGradebookException if a my gradebook with the primary key could not be found
	 */
	public MyGradebook[] findByGroupId_PrevAndNext(
			long myGradebookId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<MyGradebook>
				orderByComparator)
		throws NoSuchMyGradebookException;

	/**
	 * Removes all the my gradebooks where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of my gradebooks where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching my gradebooks
	 */
	public int countByGroupId(long groupId);

	/**
	 * Caches the my gradebook in the entity cache if it is enabled.
	 *
	 * @param myGradebook the my gradebook
	 */
	public void cacheResult(MyGradebook myGradebook);

	/**
	 * Caches the my gradebooks in the entity cache if it is enabled.
	 *
	 * @param myGradebooks the my gradebooks
	 */
	public void cacheResult(java.util.List<MyGradebook> myGradebooks);

	/**
	 * Creates a new my gradebook with the primary key. Does not add the my gradebook to the database.
	 *
	 * @param myGradebookId the primary key for the new my gradebook
	 * @return the new my gradebook
	 */
	public MyGradebook create(long myGradebookId);

	/**
	 * Removes the my gradebook with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param myGradebookId the primary key of the my gradebook
	 * @return the my gradebook that was removed
	 * @throws NoSuchMyGradebookException if a my gradebook with the primary key could not be found
	 */
	public MyGradebook remove(long myGradebookId)
		throws NoSuchMyGradebookException;

	public MyGradebook updateImpl(MyGradebook myGradebook);

	/**
	 * Returns the my gradebook with the primary key or throws a <code>NoSuchMyGradebookException</code> if it could not be found.
	 *
	 * @param myGradebookId the primary key of the my gradebook
	 * @return the my gradebook
	 * @throws NoSuchMyGradebookException if a my gradebook with the primary key could not be found
	 */
	public MyGradebook findByPrimaryKey(long myGradebookId)
		throws NoSuchMyGradebookException;

	/**
	 * Returns the my gradebook with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param myGradebookId the primary key of the my gradebook
	 * @return the my gradebook, or <code>null</code> if a my gradebook with the primary key could not be found
	 */
	public MyGradebook fetchByPrimaryKey(long myGradebookId);

	/**
	 * Returns all the my gradebooks.
	 *
	 * @return the my gradebooks
	 */
	public java.util.List<MyGradebook> findAll();

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
	public java.util.List<MyGradebook> findAll(int start, int end);

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
	public java.util.List<MyGradebook> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MyGradebook>
			orderByComparator);

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
	public java.util.List<MyGradebook> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MyGradebook>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the my gradebooks from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of my gradebooks.
	 *
	 * @return the number of my gradebooks
	 */
	public int countAll();

}