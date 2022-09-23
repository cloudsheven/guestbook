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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link GuestbookTEntryLocalService}.
 *
 * @author Andrea Luzzi
 * @see GuestbookTEntryLocalService
 * @generated
 */
public class GuestbookTEntryLocalServiceWrapper
	implements GuestbookTEntryLocalService,
			   ServiceWrapper<GuestbookTEntryLocalService> {

	public GuestbookTEntryLocalServiceWrapper() {
		this(null);
	}

	public GuestbookTEntryLocalServiceWrapper(
		GuestbookTEntryLocalService guestbookTEntryLocalService) {

		_guestbookTEntryLocalService = guestbookTEntryLocalService;
	}

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
	@Override
	public com.tutorial.guestbookt.model.GuestbookTEntry addGuestbookTEntry(
		com.tutorial.guestbookt.model.GuestbookTEntry guestbookTEntry) {

		return _guestbookTEntryLocalService.addGuestbookTEntry(guestbookTEntry);
	}

	@Override
	public com.tutorial.guestbookt.model.GuestbookTEntry addGuestbookTEntry(
			long userId, long guestbookTId, String name, String email,
			String message,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _guestbookTEntryLocalService.addGuestbookTEntry(
			userId, guestbookTId, name, email, message, serviceContext);
	}

	/**
	 * Creates a new guestbook t entry with the primary key. Does not add the guestbook t entry to the database.
	 *
	 * @param entryId the primary key for the new guestbook t entry
	 * @return the new guestbook t entry
	 */
	@Override
	public com.tutorial.guestbookt.model.GuestbookTEntry createGuestbookTEntry(
		long entryId) {

		return _guestbookTEntryLocalService.createGuestbookTEntry(entryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _guestbookTEntryLocalService.createPersistedModel(primaryKeyObj);
	}

	@Override
	public com.tutorial.guestbookt.model.GuestbookTEntry deleteGuestbookEntry(
			com.tutorial.guestbookt.model.GuestbookTEntry entry)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _guestbookTEntryLocalService.deleteGuestbookEntry(entry);
	}

	@Override
	public com.tutorial.guestbookt.model.GuestbookTEntry deleteGuestbookEntry(
			long entryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _guestbookTEntryLocalService.deleteGuestbookEntry(entryId);
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
	@Override
	public com.tutorial.guestbookt.model.GuestbookTEntry deleteGuestbookTEntry(
		com.tutorial.guestbookt.model.GuestbookTEntry guestbookTEntry) {

		return _guestbookTEntryLocalService.deleteGuestbookTEntry(
			guestbookTEntry);
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
	@Override
	public com.tutorial.guestbookt.model.GuestbookTEntry deleteGuestbookTEntry(
			long entryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _guestbookTEntryLocalService.deleteGuestbookTEntry(entryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _guestbookTEntryLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _guestbookTEntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _guestbookTEntryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _guestbookTEntryLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _guestbookTEntryLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _guestbookTEntryLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _guestbookTEntryLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _guestbookTEntryLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _guestbookTEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.tutorial.guestbookt.model.GuestbookTEntry fetchGuestbookTEntry(
		long entryId) {

		return _guestbookTEntryLocalService.fetchGuestbookTEntry(entryId);
	}

	/**
	 * Returns the guestbook t entry matching the UUID and group.
	 *
	 * @param uuid the guestbook t entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching guestbook t entry, or <code>null</code> if a matching guestbook t entry could not be found
	 */
	@Override
	public com.tutorial.guestbookt.model.GuestbookTEntry
		fetchGuestbookTEntryByUuidAndGroupId(String uuid, long groupId) {

		return _guestbookTEntryLocalService.
			fetchGuestbookTEntryByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _guestbookTEntryLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _guestbookTEntryLocalService.getExportActionableDynamicQuery(
			portletDataContext);
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
	@Override
	public java.util.List<com.tutorial.guestbookt.model.GuestbookTEntry>
		getGuestbookTEntries(int start, int end) {

		return _guestbookTEntryLocalService.getGuestbookTEntries(start, end);
	}

	@Override
	public java.util.List<com.tutorial.guestbookt.model.GuestbookTEntry>
		getGuestbookTEntries(long groupId, long guestbookId) {

		return _guestbookTEntryLocalService.getGuestbookTEntries(
			groupId, guestbookId);
	}

	/**
	 * Returns all the guestbook t entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the guestbook t entries
	 * @param companyId the primary key of the company
	 * @return the matching guestbook t entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.tutorial.guestbookt.model.GuestbookTEntry>
		getGuestbookTEntriesByUuidAndCompanyId(String uuid, long companyId) {

		return _guestbookTEntryLocalService.
			getGuestbookTEntriesByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public java.util.List<com.tutorial.guestbookt.model.GuestbookTEntry>
		getGuestbookTEntriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.tutorial.guestbookt.model.GuestbookTEntry>
					orderByComparator) {

		return _guestbookTEntryLocalService.
			getGuestbookTEntriesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of guestbook t entries.
	 *
	 * @return the number of guestbook t entries
	 */
	@Override
	public int getGuestbookTEntriesCount() {
		return _guestbookTEntryLocalService.getGuestbookTEntriesCount();
	}

	/**
	 * Returns the guestbook t entry with the primary key.
	 *
	 * @param entryId the primary key of the guestbook t entry
	 * @return the guestbook t entry
	 * @throws PortalException if a guestbook t entry with the primary key could not be found
	 */
	@Override
	public com.tutorial.guestbookt.model.GuestbookTEntry getGuestbookTEntry(
			long entryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _guestbookTEntryLocalService.getGuestbookTEntry(entryId);
	}

	/**
	 * Returns the guestbook t entry matching the UUID and group.
	 *
	 * @param uuid the guestbook t entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching guestbook t entry
	 * @throws PortalException if a matching guestbook t entry could not be found
	 */
	@Override
	public com.tutorial.guestbookt.model.GuestbookTEntry
			getGuestbookTEntryByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _guestbookTEntryLocalService.getGuestbookTEntryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _guestbookTEntryLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _guestbookTEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _guestbookTEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.tutorial.guestbookt.model.GuestbookTEntry updateGuestbookEntry(
			long userId, long guestbookId, long entryId, String name,
			String email, String message,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _guestbookTEntryLocalService.updateGuestbookEntry(
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
	@Override
	public com.tutorial.guestbookt.model.GuestbookTEntry updateGuestbookTEntry(
		com.tutorial.guestbookt.model.GuestbookTEntry guestbookTEntry) {

		return _guestbookTEntryLocalService.updateGuestbookTEntry(
			guestbookTEntry);
	}

	@Override
	public GuestbookTEntryLocalService getWrappedService() {
		return _guestbookTEntryLocalService;
	}

	@Override
	public void setWrappedService(
		GuestbookTEntryLocalService guestbookTEntryLocalService) {

		_guestbookTEntryLocalService = guestbookTEntryLocalService;
	}

	private GuestbookTEntryLocalService _guestbookTEntryLocalService;

}