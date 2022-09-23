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
 * Provides a wrapper for {@link GuestbookTLocalService}.
 *
 * @author Andrea Luzzi
 * @see GuestbookTLocalService
 * @generated
 */
public class GuestbookTLocalServiceWrapper
	implements GuestbookTLocalService, ServiceWrapper<GuestbookTLocalService> {

	public GuestbookTLocalServiceWrapper() {
		this(null);
	}

	public GuestbookTLocalServiceWrapper(
		GuestbookTLocalService guestbookTLocalService) {

		_guestbookTLocalService = guestbookTLocalService;
	}

	@Override
	public com.tutorial.guestbookt.model.GuestbookT addGuestbook(
			long userId, String name,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _guestbookTLocalService.addGuestbook(
			userId, name, serviceContext);
	}

	/**
	 * Adds the guestbook t to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GuestbookTLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param guestbookT the guestbook t
	 * @return the guestbook t that was added
	 */
	@Override
	public com.tutorial.guestbookt.model.GuestbookT addGuestbookT(
		com.tutorial.guestbookt.model.GuestbookT guestbookT) {

		return _guestbookTLocalService.addGuestbookT(guestbookT);
	}

	/**
	 * Creates a new guestbook t with the primary key. Does not add the guestbook t to the database.
	 *
	 * @param guestbookTId the primary key for the new guestbook t
	 * @return the new guestbook t
	 */
	@Override
	public com.tutorial.guestbookt.model.GuestbookT createGuestbookT(
		long guestbookTId) {

		return _guestbookTLocalService.createGuestbookT(guestbookTId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _guestbookTLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the guestbook t from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GuestbookTLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param guestbookT the guestbook t
	 * @return the guestbook t that was removed
	 */
	@Override
	public com.tutorial.guestbookt.model.GuestbookT deleteGuestbookT(
		com.tutorial.guestbookt.model.GuestbookT guestbookT) {

		return _guestbookTLocalService.deleteGuestbookT(guestbookT);
	}

	/**
	 * Deletes the guestbook t with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GuestbookTLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param guestbookTId the primary key of the guestbook t
	 * @return the guestbook t that was removed
	 * @throws PortalException if a guestbook t with the primary key could not be found
	 */
	@Override
	public com.tutorial.guestbookt.model.GuestbookT deleteGuestbookT(
			long guestbookTId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _guestbookTLocalService.deleteGuestbookT(guestbookTId);
	}

	@Override
	public com.tutorial.guestbookt.model.GuestbookT deleteGuestbookT(
			long guestbookTId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _guestbookTLocalService.deleteGuestbookT(
			guestbookTId, serviceContext);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _guestbookTLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _guestbookTLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _guestbookTLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _guestbookTLocalService.dynamicQuery();
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

		return _guestbookTLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.tutorial.guestbookt.model.impl.GuestbookTModelImpl</code>.
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

		return _guestbookTLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.tutorial.guestbookt.model.impl.GuestbookTModelImpl</code>.
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

		return _guestbookTLocalService.dynamicQuery(
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

		return _guestbookTLocalService.dynamicQueryCount(dynamicQuery);
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

		return _guestbookTLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.tutorial.guestbookt.model.GuestbookT fetchGuestbookT(
		long guestbookTId) {

		return _guestbookTLocalService.fetchGuestbookT(guestbookTId);
	}

	/**
	 * Returns the guestbook t matching the UUID and group.
	 *
	 * @param uuid the guestbook t's UUID
	 * @param groupId the primary key of the group
	 * @return the matching guestbook t, or <code>null</code> if a matching guestbook t could not be found
	 */
	@Override
	public com.tutorial.guestbookt.model.GuestbookT
		fetchGuestbookTByUuidAndGroupId(String uuid, long groupId) {

		return _guestbookTLocalService.fetchGuestbookTByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _guestbookTLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _guestbookTLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public java.util.List<com.tutorial.guestbookt.model.GuestbookT>
		getGuestbooks(long groupId) {

		return _guestbookTLocalService.getGuestbooks(groupId);
	}

	@Override
	public java.util.List<com.tutorial.guestbookt.model.GuestbookT>
		getGuestbooks(long groupId, int start, int end) {

		return _guestbookTLocalService.getGuestbooks(groupId, start, end);
	}

	@Override
	public java.util.List<com.tutorial.guestbookt.model.GuestbookT>
		getGuestbooks(
			long groupId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.tutorial.guestbookt.model.GuestbookT> obc) {

		return _guestbookTLocalService.getGuestbooks(groupId, start, end, obc);
	}

	@Override
	public int getGuestbooksCount(long groupId) {
		return _guestbookTLocalService.getGuestbooksCount(groupId);
	}

	/**
	 * Returns the guestbook t with the primary key.
	 *
	 * @param guestbookTId the primary key of the guestbook t
	 * @return the guestbook t
	 * @throws PortalException if a guestbook t with the primary key could not be found
	 */
	@Override
	public com.tutorial.guestbookt.model.GuestbookT getGuestbookT(
			long guestbookTId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _guestbookTLocalService.getGuestbookT(guestbookTId);
	}

	/**
	 * Returns the guestbook t matching the UUID and group.
	 *
	 * @param uuid the guestbook t's UUID
	 * @param groupId the primary key of the group
	 * @return the matching guestbook t
	 * @throws PortalException if a matching guestbook t could not be found
	 */
	@Override
	public com.tutorial.guestbookt.model.GuestbookT
			getGuestbookTByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _guestbookTLocalService.getGuestbookTByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the guestbook ts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.tutorial.guestbookt.model.impl.GuestbookTModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of guestbook ts
	 * @param end the upper bound of the range of guestbook ts (not inclusive)
	 * @return the range of guestbook ts
	 */
	@Override
	public java.util.List<com.tutorial.guestbookt.model.GuestbookT>
		getGuestbookTs(int start, int end) {

		return _guestbookTLocalService.getGuestbookTs(start, end);
	}

	/**
	 * Returns all the guestbook ts matching the UUID and company.
	 *
	 * @param uuid the UUID of the guestbook ts
	 * @param companyId the primary key of the company
	 * @return the matching guestbook ts, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.tutorial.guestbookt.model.GuestbookT>
		getGuestbookTsByUuidAndCompanyId(String uuid, long companyId) {

		return _guestbookTLocalService.getGuestbookTsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of guestbook ts matching the UUID and company.
	 *
	 * @param uuid the UUID of the guestbook ts
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of guestbook ts
	 * @param end the upper bound of the range of guestbook ts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching guestbook ts, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.tutorial.guestbookt.model.GuestbookT>
		getGuestbookTsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.tutorial.guestbookt.model.GuestbookT> orderByComparator) {

		return _guestbookTLocalService.getGuestbookTsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of guestbook ts.
	 *
	 * @return the number of guestbook ts
	 */
	@Override
	public int getGuestbookTsCount() {
		return _guestbookTLocalService.getGuestbookTsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _guestbookTLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _guestbookTLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _guestbookTLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the guestbook t in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GuestbookTLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param guestbookT the guestbook t
	 * @return the guestbook t that was updated
	 */
	@Override
	public com.tutorial.guestbookt.model.GuestbookT updateGuestbookT(
		com.tutorial.guestbookt.model.GuestbookT guestbookT) {

		return _guestbookTLocalService.updateGuestbookT(guestbookT);
	}

	@Override
	public com.tutorial.guestbookt.model.GuestbookT updateGuestbookT(
			long userId, long guestbookTId, String name,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _guestbookTLocalService.updateGuestbookT(
			userId, guestbookTId, name, serviceContext);
	}

	@Override
	public GuestbookTLocalService getWrappedService() {
		return _guestbookTLocalService;
	}

	@Override
	public void setWrappedService(
		GuestbookTLocalService guestbookTLocalService) {

		_guestbookTLocalService = guestbookTLocalService;
	}

	private GuestbookTLocalService _guestbookTLocalService;

}