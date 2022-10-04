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

package com.tutorial.liferay.my.gradebook.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MyGradebookLocalService}.
 *
 * @author Andrea Luzzi
 * @see MyGradebookLocalService
 * @generated
 */
public class MyGradebookLocalServiceWrapper
	implements MyGradebookLocalService,
			   ServiceWrapper<MyGradebookLocalService> {

	public MyGradebookLocalServiceWrapper() {
		this(null);
	}

	public MyGradebookLocalServiceWrapper(
		MyGradebookLocalService myGradebookLocalService) {

		_myGradebookLocalService = myGradebookLocalService;
	}

	/**
	 * Adds the my gradebook to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MyGradebookLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param myGradebook the my gradebook
	 * @return the my gradebook that was added
	 */
	@Override
	public com.tutorial.liferay.my.gradebook.model.MyGradebook addMyGradebook(
		com.tutorial.liferay.my.gradebook.model.MyGradebook myGradebook) {

		return _myGradebookLocalService.addMyGradebook(myGradebook);
	}

	/**
	 * Creates a new my gradebook with the primary key. Does not add the my gradebook to the database.
	 *
	 * @param myGradebookId the primary key for the new my gradebook
	 * @return the new my gradebook
	 */
	@Override
	public com.tutorial.liferay.my.gradebook.model.MyGradebook
		createMyGradebook(long myGradebookId) {

		return _myGradebookLocalService.createMyGradebook(myGradebookId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _myGradebookLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the my gradebook with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MyGradebookLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param myGradebookId the primary key of the my gradebook
	 * @return the my gradebook that was removed
	 * @throws PortalException if a my gradebook with the primary key could not be found
	 */
	@Override
	public com.tutorial.liferay.my.gradebook.model.MyGradebook
			deleteMyGradebook(long myGradebookId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _myGradebookLocalService.deleteMyGradebook(myGradebookId);
	}

	/**
	 * Deletes the my gradebook from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MyGradebookLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param myGradebook the my gradebook
	 * @return the my gradebook that was removed
	 */
	@Override
	public com.tutorial.liferay.my.gradebook.model.MyGradebook
		deleteMyGradebook(
			com.tutorial.liferay.my.gradebook.model.MyGradebook myGradebook) {

		return _myGradebookLocalService.deleteMyGradebook(myGradebook);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _myGradebookLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _myGradebookLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _myGradebookLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _myGradebookLocalService.dynamicQuery();
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

		return _myGradebookLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.tutorial.liferay.my.gradebook.model.impl.MyGradebookModelImpl</code>.
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

		return _myGradebookLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.tutorial.liferay.my.gradebook.model.impl.MyGradebookModelImpl</code>.
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

		return _myGradebookLocalService.dynamicQuery(
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

		return _myGradebookLocalService.dynamicQueryCount(dynamicQuery);
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

		return _myGradebookLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.tutorial.liferay.my.gradebook.model.MyGradebook fetchMyGradebook(
		long myGradebookId) {

		return _myGradebookLocalService.fetchMyGradebook(myGradebookId);
	}

	/**
	 * Returns the my gradebook matching the UUID and group.
	 *
	 * @param uuid the my gradebook's UUID
	 * @param groupId the primary key of the group
	 * @return the matching my gradebook, or <code>null</code> if a matching my gradebook could not be found
	 */
	@Override
	public com.tutorial.liferay.my.gradebook.model.MyGradebook
		fetchMyGradebookByUuidAndGroupId(String uuid, long groupId) {

		return _myGradebookLocalService.fetchMyGradebookByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _myGradebookLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _myGradebookLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _myGradebookLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the my gradebook with the primary key.
	 *
	 * @param myGradebookId the primary key of the my gradebook
	 * @return the my gradebook
	 * @throws PortalException if a my gradebook with the primary key could not be found
	 */
	@Override
	public com.tutorial.liferay.my.gradebook.model.MyGradebook getMyGradebook(
			long myGradebookId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _myGradebookLocalService.getMyGradebook(myGradebookId);
	}

	/**
	 * Returns the my gradebook matching the UUID and group.
	 *
	 * @param uuid the my gradebook's UUID
	 * @param groupId the primary key of the group
	 * @return the matching my gradebook
	 * @throws PortalException if a matching my gradebook could not be found
	 */
	@Override
	public com.tutorial.liferay.my.gradebook.model.MyGradebook
			getMyGradebookByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _myGradebookLocalService.getMyGradebookByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the my gradebooks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.tutorial.liferay.my.gradebook.model.impl.MyGradebookModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of my gradebooks
	 * @param end the upper bound of the range of my gradebooks (not inclusive)
	 * @return the range of my gradebooks
	 */
	@Override
	public java.util.List<com.tutorial.liferay.my.gradebook.model.MyGradebook>
		getMyGradebooks(int start, int end) {

		return _myGradebookLocalService.getMyGradebooks(start, end);
	}

	/**
	 * Returns all the my gradebooks matching the UUID and company.
	 *
	 * @param uuid the UUID of the my gradebooks
	 * @param companyId the primary key of the company
	 * @return the matching my gradebooks, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.tutorial.liferay.my.gradebook.model.MyGradebook>
		getMyGradebooksByUuidAndCompanyId(String uuid, long companyId) {

		return _myGradebookLocalService.getMyGradebooksByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of my gradebooks matching the UUID and company.
	 *
	 * @param uuid the UUID of the my gradebooks
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of my gradebooks
	 * @param end the upper bound of the range of my gradebooks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching my gradebooks, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.tutorial.liferay.my.gradebook.model.MyGradebook>
		getMyGradebooksByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.tutorial.liferay.my.gradebook.model.MyGradebook>
					orderByComparator) {

		return _myGradebookLocalService.getMyGradebooksByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of my gradebooks.
	 *
	 * @return the number of my gradebooks
	 */
	@Override
	public int getMyGradebooksCount() {
		return _myGradebookLocalService.getMyGradebooksCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _myGradebookLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _myGradebookLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the my gradebook in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MyGradebookLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param myGradebook the my gradebook
	 * @return the my gradebook that was updated
	 */
	@Override
	public com.tutorial.liferay.my.gradebook.model.MyGradebook
		updateMyGradebook(
			com.tutorial.liferay.my.gradebook.model.MyGradebook myGradebook) {

		return _myGradebookLocalService.updateMyGradebook(myGradebook);
	}

	@Override
	public MyGradebookLocalService getWrappedService() {
		return _myGradebookLocalService;
	}

	@Override
	public void setWrappedService(
		MyGradebookLocalService myGradebookLocalService) {

		_myGradebookLocalService = myGradebookLocalService;
	}

	private MyGradebookLocalService _myGradebookLocalService;

}