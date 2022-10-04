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
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.tutorial.liferay.my.gradebook.model.MyGradebook;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for MyGradebook. This utility wraps
 * <code>com.tutorial.liferay.my.gradebook.service.impl.MyGradebookLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Andrea Luzzi
 * @see MyGradebookLocalService
 * @generated
 */
public class MyGradebookLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.tutorial.liferay.my.gradebook.service.impl.MyGradebookLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static MyGradebook addMyGradebook(
			long userId, String name,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addMyGradebook(userId, name, serviceContext);
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
	public static MyGradebook addMyGradebook(MyGradebook myGradebook) {
		return getService().addMyGradebook(myGradebook);
	}

	/**
	 * Creates a new my gradebook with the primary key. Does not add the my gradebook to the database.
	 *
	 * @param myGradebookId the primary key for the new my gradebook
	 * @return the new my gradebook
	 */
	public static MyGradebook createMyGradebook(long myGradebookId) {
		return getService().createMyGradebook(myGradebookId);
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
	public static MyGradebook deleteMyGradebook(long myGradebookId)
		throws PortalException {

		return getService().deleteMyGradebook(myGradebookId);
	}

	public static MyGradebook deleteMyGradebook(
			long myGradebookId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException, SystemException {

		return getService().deleteMyGradebook(myGradebookId, serviceContext);
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
	public static MyGradebook deleteMyGradebook(MyGradebook myGradebook) {
		return getService().deleteMyGradebook(myGradebook);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.tutorial.liferay.my.gradebook.model.impl.MyGradebookModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.tutorial.liferay.my.gradebook.model.impl.MyGradebookModelImpl</code>.
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

	public static MyGradebook fetchMyGradebook(long myGradebookId) {
		return getService().fetchMyGradebook(myGradebookId);
	}

	/**
	 * Returns the my gradebook matching the UUID and group.
	 *
	 * @param uuid the my gradebook's UUID
	 * @param groupId the primary key of the group
	 * @return the matching my gradebook, or <code>null</code> if a matching my gradebook could not be found
	 */
	public static MyGradebook fetchMyGradebookByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchMyGradebookByUuidAndGroupId(uuid, groupId);
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

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the my gradebook with the primary key.
	 *
	 * @param myGradebookId the primary key of the my gradebook
	 * @return the my gradebook
	 * @throws PortalException if a my gradebook with the primary key could not be found
	 */
	public static MyGradebook getMyGradebook(long myGradebookId)
		throws PortalException {

		return getService().getMyGradebook(myGradebookId);
	}

	/**
	 * Returns the my gradebook matching the UUID and group.
	 *
	 * @param uuid the my gradebook's UUID
	 * @param groupId the primary key of the group
	 * @return the matching my gradebook
	 * @throws PortalException if a matching my gradebook could not be found
	 */
	public static MyGradebook getMyGradebookByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getMyGradebookByUuidAndGroupId(uuid, groupId);
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
	public static List<MyGradebook> getMyGradebooks(int start, int end) {
		return getService().getMyGradebooks(start, end);
	}

	/**
	 * Returns all the my gradebooks matching the UUID and company.
	 *
	 * @param uuid the UUID of the my gradebooks
	 * @param companyId the primary key of the company
	 * @return the matching my gradebooks, or an empty list if no matches were found
	 */
	public static List<MyGradebook> getMyGradebooksByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getMyGradebooksByUuidAndCompanyId(uuid, companyId);
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
	public static List<MyGradebook> getMyGradebooksByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<MyGradebook> orderByComparator) {

		return getService().getMyGradebooksByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of my gradebooks.
	 *
	 * @return the number of my gradebooks
	 */
	public static int getMyGradebooksCount() {
		return getService().getMyGradebooksCount();
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

	public static MyGradebook updateMyGradebook(
			long userId, long myGradebookId, String name,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException, SystemException {

		return getService().updateMyGradebook(
			userId, myGradebookId, name, serviceContext);
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
	public static MyGradebook updateMyGradebook(MyGradebook myGradebook) {
		return getService().updateMyGradebook(myGradebook);
	}

	public static MyGradebookLocalService getService() {
		return _service;
	}

	private static volatile MyGradebookLocalService _service;

}