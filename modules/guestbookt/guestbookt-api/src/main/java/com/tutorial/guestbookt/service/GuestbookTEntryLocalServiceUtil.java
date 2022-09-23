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

package com.tutorial.guestbookt.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.tutorial.guestbookt.model.GuestbookTEntry;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for GuestbookTEntry. This utility wraps
 * <code>com.tutorial.guestbookt.service.impl.GuestbookTEntryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Andrea Luzzi
 * @see GuestbookTEntryLocalService
 * @generated
 */
public class GuestbookTEntryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.tutorial.guestbookt.service.impl.GuestbookTEntryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the guestbook t entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GuestbookTEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param guestbookTEntry the guestbook t entry
	 * @return the guestbook t entry that was added
	 */
	public static GuestbookTEntry addGuestbookTEntry(
		GuestbookTEntry guestbookTEntry) {

		return getService().addGuestbookTEntry(guestbookTEntry);
	}

	public static GuestbookTEntry addGuestbookTEntry(
			long userId, long guestbookTId, String name, String email,
			String message,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addGuestbookTEntry(
			userId, guestbookTId, name, email, message, serviceContext);
	}

	/**
	 * Creates a new guestbook t entry with the primary key. Does not add the guestbook t entry to the database.
	 *
	 * @param entryId the primary key for the new guestbook t entry
	 * @return the new guestbook t entry
	 */
	public static GuestbookTEntry createGuestbookTEntry(long entryId) {
		return getService().createGuestbookTEntry(entryId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	public static GuestbookTEntry deleteGuestbookEntry(GuestbookTEntry entry)
		throws PortalException {

		return getService().deleteGuestbookEntry(entry);
	}

	public static GuestbookTEntry deleteGuestbookEntry(long entryId)
		throws PortalException {

		return getService().deleteGuestbookEntry(entryId);
	}

	/**
	 * Deletes the guestbook t entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GuestbookTEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param guestbookTEntry the guestbook t entry
	 * @return the guestbook t entry that was removed
	 */
	public static GuestbookTEntry deleteGuestbookTEntry(
		GuestbookTEntry guestbookTEntry) {

		return getService().deleteGuestbookTEntry(guestbookTEntry);
	}

	/**
	 * Deletes the guestbook t entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GuestbookTEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param entryId the primary key of the guestbook t entry
	 * @return the guestbook t entry that was removed
	 * @throws PortalException if a guestbook t entry with the primary key could not be found
	 */
	public static GuestbookTEntry deleteGuestbookTEntry(long entryId)
		throws PortalException {

		return getService().deleteGuestbookTEntry(entryId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.tutorial.guestbookt.model.impl.GuestbookTEntryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.tutorial.guestbookt.model.impl.GuestbookTEntryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static GuestbookTEntry fetchGuestbookTEntry(long entryId) {
		return getService().fetchGuestbookTEntry(entryId);
	}

	/**
	 * Returns the guestbook t entry matching the UUID and group.
	 *
	 * @param uuid the guestbook t entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching guestbook t entry, or <code>null</code> if a matching guestbook t entry could not be found
	 */
	public static GuestbookTEntry fetchGuestbookTEntryByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchGuestbookTEntryByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	/**
	 * Returns a range of all the guestbook t entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.tutorial.guestbookt.model.impl.GuestbookTEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of guestbook t entries
	 * @param end the upper bound of the range of guestbook t entries (not inclusive)
	 * @return the range of guestbook t entries
	 */
	public static List<GuestbookTEntry> getGuestbookTEntries(
		int start, int end) {

		return getService().getGuestbookTEntries(start, end);
	}

	public static List<GuestbookTEntry> getGuestbookTEntries(
		long groupId, long guestbookId) {

		return getService().getGuestbookTEntries(groupId, guestbookId);
	}

	/**
	 * Returns all the guestbook t entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the guestbook t entries
	 * @param companyId the primary key of the company
	 * @return the matching guestbook t entries, or an empty list if no matches were found
	 */
	public static List<GuestbookTEntry> getGuestbookTEntriesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getGuestbookTEntriesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of guestbook t entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the guestbook t entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of guestbook t entries
	 * @param end the upper bound of the range of guestbook t entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching guestbook t entries, or an empty list if no matches were found
	 */
	public static List<GuestbookTEntry> getGuestbookTEntriesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<GuestbookTEntry> orderByComparator) {

		return getService().getGuestbookTEntriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of guestbook t entries.
	 *
	 * @return the number of guestbook t entries
	 */
	public static int getGuestbookTEntriesCount() {
		return getService().getGuestbookTEntriesCount();
	}

	/**
	 * Returns the guestbook t entry with the primary key.
	 *
	 * @param entryId the primary key of the guestbook t entry
	 * @return the guestbook t entry
	 * @throws PortalException if a guestbook t entry with the primary key could not be found
	 */
	public static GuestbookTEntry getGuestbookTEntry(long entryId)
		throws PortalException {

		return getService().getGuestbookTEntry(entryId);
	}

	/**
	 * Returns the guestbook t entry matching the UUID and group.
	 *
	 * @param uuid the guestbook t entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching guestbook t entry
	 * @throws PortalException if a matching guestbook t entry could not be found
	 */
	public static GuestbookTEntry getGuestbookTEntryByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getGuestbookTEntryByUuidAndGroupId(uuid, groupId);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static GuestbookTEntry updateGuestbookEntry(
			long userId, long guestbookId, long entryId, String name,
			String email, String message,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException, SystemException {

		return getService().updateGuestbookEntry(
			userId, guestbookId, entryId, name, email, message, serviceContext);
	}

	/**
	 * Updates the guestbook t entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GuestbookTEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param guestbookTEntry the guestbook t entry
	 * @return the guestbook t entry that was updated
	 */
	public static GuestbookTEntry updateGuestbookTEntry(
		GuestbookTEntry guestbookTEntry) {

		return getService().updateGuestbookTEntry(guestbookTEntry);
	}

	public static GuestbookTEntryLocalService getService() {
		return _service;
	}

	private static volatile GuestbookTEntryLocalService _service;

}