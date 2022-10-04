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

import com.tutorial.liferay.my.gradebook.exception.NoSuchGradebookException;
import com.tutorial.liferay.my.gradebook.model.Gradebook;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the gradebook service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Andrea Luzzi
 * @see GradebookUtil
 * @generated
 */
@ProviderType
public interface GradebookPersistence extends BasePersistence<Gradebook> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GradebookUtil} to access the gradebook persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the gradebooks where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching gradebooks
	 */
	public java.util.List<Gradebook> findByUuid(String uuid);

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
	public java.util.List<Gradebook> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<Gradebook> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Gradebook>
			orderByComparator);

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
	public java.util.List<Gradebook> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Gradebook>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first gradebook in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gradebook
	 * @throws NoSuchGradebookException if a matching gradebook could not be found
	 */
	public Gradebook findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Gradebook>
				orderByComparator)
		throws NoSuchGradebookException;

	/**
	 * Returns the first gradebook in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gradebook, or <code>null</code> if a matching gradebook could not be found
	 */
	public Gradebook fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Gradebook>
			orderByComparator);

	/**
	 * Returns the last gradebook in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gradebook
	 * @throws NoSuchGradebookException if a matching gradebook could not be found
	 */
	public Gradebook findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Gradebook>
				orderByComparator)
		throws NoSuchGradebookException;

	/**
	 * Returns the last gradebook in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gradebook, or <code>null</code> if a matching gradebook could not be found
	 */
	public Gradebook fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Gradebook>
			orderByComparator);

	/**
	 * Returns the gradebooks before and after the current gradebook in the ordered set where uuid = &#63;.
	 *
	 * @param gradebookId the primary key of the current gradebook
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gradebook
	 * @throws NoSuchGradebookException if a gradebook with the primary key could not be found
	 */
	public Gradebook[] findByUuid_PrevAndNext(
			long gradebookId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Gradebook>
				orderByComparator)
		throws NoSuchGradebookException;

	/**
	 * Removes all the gradebooks where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of gradebooks where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching gradebooks
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the gradebook where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchGradebookException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching gradebook
	 * @throws NoSuchGradebookException if a matching gradebook could not be found
	 */
	public Gradebook findByUUID_G(String uuid, long groupId)
		throws NoSuchGradebookException;

	/**
	 * Returns the gradebook where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching gradebook, or <code>null</code> if a matching gradebook could not be found
	 */
	public Gradebook fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the gradebook where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching gradebook, or <code>null</code> if a matching gradebook could not be found
	 */
	public Gradebook fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the gradebook where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the gradebook that was removed
	 */
	public Gradebook removeByUUID_G(String uuid, long groupId)
		throws NoSuchGradebookException;

	/**
	 * Returns the number of gradebooks where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching gradebooks
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the gradebooks where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching gradebooks
	 */
	public java.util.List<Gradebook> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<Gradebook> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<Gradebook> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Gradebook>
			orderByComparator);

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
	public java.util.List<Gradebook> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Gradebook>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first gradebook in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gradebook
	 * @throws NoSuchGradebookException if a matching gradebook could not be found
	 */
	public Gradebook findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Gradebook>
				orderByComparator)
		throws NoSuchGradebookException;

	/**
	 * Returns the first gradebook in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gradebook, or <code>null</code> if a matching gradebook could not be found
	 */
	public Gradebook fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Gradebook>
			orderByComparator);

	/**
	 * Returns the last gradebook in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gradebook
	 * @throws NoSuchGradebookException if a matching gradebook could not be found
	 */
	public Gradebook findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Gradebook>
				orderByComparator)
		throws NoSuchGradebookException;

	/**
	 * Returns the last gradebook in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gradebook, or <code>null</code> if a matching gradebook could not be found
	 */
	public Gradebook fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Gradebook>
			orderByComparator);

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
	public Gradebook[] findByUuid_C_PrevAndNext(
			long gradebookId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Gradebook>
				orderByComparator)
		throws NoSuchGradebookException;

	/**
	 * Removes all the gradebooks where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of gradebooks where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching gradebooks
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the gradebooks where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching gradebooks
	 */
	public java.util.List<Gradebook> findByGroupId(long groupId);

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
	public java.util.List<Gradebook> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<Gradebook> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Gradebook>
			orderByComparator);

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
	public java.util.List<Gradebook> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Gradebook>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first gradebook in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gradebook
	 * @throws NoSuchGradebookException if a matching gradebook could not be found
	 */
	public Gradebook findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Gradebook>
				orderByComparator)
		throws NoSuchGradebookException;

	/**
	 * Returns the first gradebook in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gradebook, or <code>null</code> if a matching gradebook could not be found
	 */
	public Gradebook fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Gradebook>
			orderByComparator);

	/**
	 * Returns the last gradebook in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gradebook
	 * @throws NoSuchGradebookException if a matching gradebook could not be found
	 */
	public Gradebook findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Gradebook>
				orderByComparator)
		throws NoSuchGradebookException;

	/**
	 * Returns the last gradebook in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gradebook, or <code>null</code> if a matching gradebook could not be found
	 */
	public Gradebook fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Gradebook>
			orderByComparator);

	/**
	 * Returns the gradebooks before and after the current gradebook in the ordered set where groupId = &#63;.
	 *
	 * @param gradebookId the primary key of the current gradebook
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gradebook
	 * @throws NoSuchGradebookException if a gradebook with the primary key could not be found
	 */
	public Gradebook[] findByGroupId_PrevAndNext(
			long gradebookId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Gradebook>
				orderByComparator)
		throws NoSuchGradebookException;

	/**
	 * Removes all the gradebooks where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of gradebooks where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching gradebooks
	 */
	public int countByGroupId(long groupId);

	/**
	 * Caches the gradebook in the entity cache if it is enabled.
	 *
	 * @param gradebook the gradebook
	 */
	public void cacheResult(Gradebook gradebook);

	/**
	 * Caches the gradebooks in the entity cache if it is enabled.
	 *
	 * @param gradebooks the gradebooks
	 */
	public void cacheResult(java.util.List<Gradebook> gradebooks);

	/**
	 * Creates a new gradebook with the primary key. Does not add the gradebook to the database.
	 *
	 * @param gradebookId the primary key for the new gradebook
	 * @return the new gradebook
	 */
	public Gradebook create(long gradebookId);

	/**
	 * Removes the gradebook with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param gradebookId the primary key of the gradebook
	 * @return the gradebook that was removed
	 * @throws NoSuchGradebookException if a gradebook with the primary key could not be found
	 */
	public Gradebook remove(long gradebookId) throws NoSuchGradebookException;

	public Gradebook updateImpl(Gradebook gradebook);

	/**
	 * Returns the gradebook with the primary key or throws a <code>NoSuchGradebookException</code> if it could not be found.
	 *
	 * @param gradebookId the primary key of the gradebook
	 * @return the gradebook
	 * @throws NoSuchGradebookException if a gradebook with the primary key could not be found
	 */
	public Gradebook findByPrimaryKey(long gradebookId)
		throws NoSuchGradebookException;

	/**
	 * Returns the gradebook with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param gradebookId the primary key of the gradebook
	 * @return the gradebook, or <code>null</code> if a gradebook with the primary key could not be found
	 */
	public Gradebook fetchByPrimaryKey(long gradebookId);

	/**
	 * Returns all the gradebooks.
	 *
	 * @return the gradebooks
	 */
	public java.util.List<Gradebook> findAll();

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
	public java.util.List<Gradebook> findAll(int start, int end);

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
	public java.util.List<Gradebook> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Gradebook>
			orderByComparator);

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
	public java.util.List<Gradebook> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Gradebook>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the gradebooks from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of gradebooks.
	 *
	 * @return the number of gradebooks
	 */
	public int countAll();

}