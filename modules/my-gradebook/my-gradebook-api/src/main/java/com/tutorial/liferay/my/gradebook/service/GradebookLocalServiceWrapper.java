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
 * Provides a wrapper for {@link GradebookLocalService}.
 *
 * @author Andrea Luzzi
 * @see GradebookLocalService
 * @generated
 */
public class GradebookLocalServiceWrapper
	implements GradebookLocalService, ServiceWrapper<GradebookLocalService> {

	public GradebookLocalServiceWrapper() {
		this(null);
	}

	public GradebookLocalServiceWrapper(
		GradebookLocalService gradebookLocalService) {

		_gradebookLocalService = gradebookLocalService;
	}

	/**
	 * Adds the gradebook to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GradebookLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param gradebook the gradebook
	 * @return the gradebook that was added
	 */
	@Override
	public com.tutorial.liferay.my.gradebook.model.Gradebook addGradebook(
		com.tutorial.liferay.my.gradebook.model.Gradebook gradebook) {

		return _gradebookLocalService.addGradebook(gradebook);
	}

	/**
	 * Creates a new gradebook with the primary key. Does not add the gradebook to the database.
	 *
	 * @param gradebookId the primary key for the new gradebook
	 * @return the new gradebook
	 */
	@Override
	public com.tutorial.liferay.my.gradebook.model.Gradebook createGradebook(
		long gradebookId) {

		return _gradebookLocalService.createGradebook(gradebookId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _gradebookLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the gradebook from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GradebookLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param gradebook the gradebook
	 * @return the gradebook that was removed
	 */
	@Override
	public com.tutorial.liferay.my.gradebook.model.Gradebook deleteGradebook(
		com.tutorial.liferay.my.gradebook.model.Gradebook gradebook) {

		return _gradebookLocalService.deleteGradebook(gradebook);
	}

	/**
	 * Deletes the gradebook with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GradebookLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param gradebookId the primary key of the gradebook
	 * @return the gradebook that was removed
	 * @throws PortalException if a gradebook with the primary key could not be found
	 */
	@Override
	public com.tutorial.liferay.my.gradebook.model.Gradebook deleteGradebook(
			long gradebookId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _gradebookLocalService.deleteGradebook(gradebookId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _gradebookLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _gradebookLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _gradebookLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _gradebookLocalService.dynamicQuery();
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

		return _gradebookLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.tutorial.liferay.my.gradebook.model.impl.GradebookModelImpl</code>.
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

		return _gradebookLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.tutorial.liferay.my.gradebook.model.impl.GradebookModelImpl</code>.
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

		return _gradebookLocalService.dynamicQuery(
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

		return _gradebookLocalService.dynamicQueryCount(dynamicQuery);
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

		return _gradebookLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.tutorial.liferay.my.gradebook.model.Gradebook fetchGradebook(
		long gradebookId) {

		return _gradebookLocalService.fetchGradebook(gradebookId);
	}

	/**
	 * Returns the gradebook matching the UUID and group.
	 *
	 * @param uuid the gradebook's UUID
	 * @param groupId the primary key of the group
	 * @return the matching gradebook, or <code>null</code> if a matching gradebook could not be found
	 */
	@Override
	public com.tutorial.liferay.my.gradebook.model.Gradebook
		fetchGradebookByUuidAndGroupId(String uuid, long groupId) {

		return _gradebookLocalService.fetchGradebookByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _gradebookLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _gradebookLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	/**
	 * Returns the gradebook with the primary key.
	 *
	 * @param gradebookId the primary key of the gradebook
	 * @return the gradebook
	 * @throws PortalException if a gradebook with the primary key could not be found
	 */
	@Override
	public com.tutorial.liferay.my.gradebook.model.Gradebook getGradebook(
			long gradebookId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _gradebookLocalService.getGradebook(gradebookId);
	}

	/**
	 * Returns the gradebook matching the UUID and group.
	 *
	 * @param uuid the gradebook's UUID
	 * @param groupId the primary key of the group
	 * @return the matching gradebook
	 * @throws PortalException if a matching gradebook could not be found
	 */
	@Override
	public com.tutorial.liferay.my.gradebook.model.Gradebook
			getGradebookByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _gradebookLocalService.getGradebookByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the gradebooks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.tutorial.liferay.my.gradebook.model.impl.GradebookModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of gradebooks
	 * @param end the upper bound of the range of gradebooks (not inclusive)
	 * @return the range of gradebooks
	 */
	@Override
	public java.util.List<com.tutorial.liferay.my.gradebook.model.Gradebook>
		getGradebooks(int start, int end) {

		return _gradebookLocalService.getGradebooks(start, end);
	}

	/**
	 * Returns all the gradebooks matching the UUID and company.
	 *
	 * @param uuid the UUID of the gradebooks
	 * @param companyId the primary key of the company
	 * @return the matching gradebooks, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.tutorial.liferay.my.gradebook.model.Gradebook>
		getGradebooksByUuidAndCompanyId(String uuid, long companyId) {

		return _gradebookLocalService.getGradebooksByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of gradebooks matching the UUID and company.
	 *
	 * @param uuid the UUID of the gradebooks
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of gradebooks
	 * @param end the upper bound of the range of gradebooks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching gradebooks, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.tutorial.liferay.my.gradebook.model.Gradebook>
		getGradebooksByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.tutorial.liferay.my.gradebook.model.Gradebook>
					orderByComparator) {

		return _gradebookLocalService.getGradebooksByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of gradebooks.
	 *
	 * @return the number of gradebooks
	 */
	@Override
	public int getGradebooksCount() {
		return _gradebookLocalService.getGradebooksCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _gradebookLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _gradebookLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _gradebookLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the gradebook in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GradebookLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param gradebook the gradebook
	 * @return the gradebook that was updated
	 */
	@Override
	public com.tutorial.liferay.my.gradebook.model.Gradebook updateGradebook(
		com.tutorial.liferay.my.gradebook.model.Gradebook gradebook) {

		return _gradebookLocalService.updateGradebook(gradebook);
	}

	@Override
	public GradebookLocalService getWrappedService() {
		return _gradebookLocalService;
	}

	@Override
	public void setWrappedService(GradebookLocalService gradebookLocalService) {
		_gradebookLocalService = gradebookLocalService;
	}

	private GradebookLocalService _gradebookLocalService;

}