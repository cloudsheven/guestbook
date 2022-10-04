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

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.tutorial.liferay.my.gradebook.model.Gradebook;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Gradebook. This utility wraps
 * <code>com.tutorial.liferay.my.gradebook.service.impl.GradebookLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Andrea Luzzi
 * @see GradebookLocalService
 * @generated
 */
public class GradebookLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.tutorial.liferay.my.gradebook.service.impl.GradebookLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static Gradebook addGradebook(Gradebook gradebook) {
		return getService().addGradebook(gradebook);
	}

	/**
	 * Creates a new gradebook with the primary key. Does not add the gradebook to the database.
	 *
	 * @param gradebookId the primary key for the new gradebook
	 * @return the new gradebook
	 */
	public static Gradebook createGradebook(long gradebookId) {
		return getService().createGradebook(gradebookId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
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
	public static Gradebook deleteGradebook(Gradebook gradebook) {
		return getService().deleteGradebook(gradebook);
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
	public static Gradebook deleteGradebook(long gradebookId)
		throws PortalException {

		return getService().deleteGradebook(gradebookId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.tutorial.liferay.my.gradebook.model.impl.GradebookModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.tutorial.liferay.my.gradebook.model.impl.GradebookModelImpl</code>.
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

	public static Gradebook fetchGradebook(long gradebookId) {
		return getService().fetchGradebook(gradebookId);
	}

	/**
	 * Returns the gradebook matching the UUID and group.
	 *
	 * @param uuid the gradebook's UUID
	 * @param groupId the primary key of the group
	 * @return the matching gradebook, or <code>null</code> if a matching gradebook could not be found
	 */
	public static Gradebook fetchGradebookByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchGradebookByUuidAndGroupId(uuid, groupId);
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
	 * Returns the gradebook with the primary key.
	 *
	 * @param gradebookId the primary key of the gradebook
	 * @return the gradebook
	 * @throws PortalException if a gradebook with the primary key could not be found
	 */
	public static Gradebook getGradebook(long gradebookId)
		throws PortalException {

		return getService().getGradebook(gradebookId);
	}

	/**
	 * Returns the gradebook matching the UUID and group.
	 *
	 * @param uuid the gradebook's UUID
	 * @param groupId the primary key of the group
	 * @return the matching gradebook
	 * @throws PortalException if a matching gradebook could not be found
	 */
	public static Gradebook getGradebookByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getGradebookByUuidAndGroupId(uuid, groupId);
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
	public static List<Gradebook> getGradebooks(int start, int end) {
		return getService().getGradebooks(start, end);
	}

	/**
	 * Returns all the gradebooks matching the UUID and company.
	 *
	 * @param uuid the UUID of the gradebooks
	 * @param companyId the primary key of the company
	 * @return the matching gradebooks, or an empty list if no matches were found
	 */
	public static List<Gradebook> getGradebooksByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getGradebooksByUuidAndCompanyId(uuid, companyId);
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
	public static List<Gradebook> getGradebooksByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Gradebook> orderByComparator) {

		return getService().getGradebooksByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of gradebooks.
	 *
	 * @return the number of gradebooks
	 */
	public static int getGradebooksCount() {
		return getService().getGradebooksCount();
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
	public static Gradebook updateGradebook(Gradebook gradebook) {
		return getService().updateGradebook(gradebook);
	}

	public static GradebookLocalService getService() {
		return _service;
	}

	private static volatile GradebookLocalService _service;

}