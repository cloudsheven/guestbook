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

import com.tutorial.guestbookt.model.GuestbookT;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for GuestbookT. This utility wraps
 * <code>com.tutorial.guestbookt.service.impl.GuestbookTLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Andrea Luzzi
 * @see GuestbookTLocalService
 * @generated
 */
public class GuestbookTLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.tutorial.guestbookt.service.impl.GuestbookTLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static GuestbookT addGuestbook(
			long userId, String name,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addGuestbook(userId, name, serviceContext);
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
	public static GuestbookT addGuestbookT(GuestbookT guestbookT) {
		return getService().addGuestbookT(guestbookT);
	}

	/**
	 * Creates a new guestbook t with the primary key. Does not add the guestbook t to the database.
	 *
	 * @param guestbookTId the primary key for the new guestbook t
	 * @return the new guestbook t
	 */
	public static GuestbookT createGuestbookT(long guestbookTId) {
		return getService().createGuestbookT(guestbookTId);
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
	 * Deletes the guestbook t from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GuestbookTLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param guestbookT the guestbook t
	 * @return the guestbook t that was removed
	 */
	public static GuestbookT deleteGuestbookT(GuestbookT guestbookT) {
		return getService().deleteGuestbookT(guestbookT);
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
	public static GuestbookT deleteGuestbookT(long guestbookTId)
		throws PortalException {

		return getService().deleteGuestbookT(guestbookTId);
	}

	public static GuestbookT deleteGuestbookT(
			long guestbookTId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException, SystemException {

		return getService().deleteGuestbookT(guestbookTId, serviceContext);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.tutorial.guestbookt.model.impl.GuestbookTModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.tutorial.guestbookt.model.impl.GuestbookTModelImpl</code>.
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

	public static GuestbookT fetchGuestbookT(long guestbookTId) {
		return getService().fetchGuestbookT(guestbookTId);
	}

	/**
	 * Returns the guestbook t matching the UUID and group.
	 *
	 * @param uuid the guestbook t's UUID
	 * @param groupId the primary key of the group
	 * @return the matching guestbook t, or <code>null</code> if a matching guestbook t could not be found
	 */
	public static GuestbookT fetchGuestbookTByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchGuestbookTByUuidAndGroupId(uuid, groupId);
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

	public static List<GuestbookT> getGuestbooks(long groupId) {
		return getService().getGuestbooks(groupId);
	}

	public static List<GuestbookT> getGuestbooks(
		long groupId, int start, int end) {

		return getService().getGuestbooks(groupId, start, end);
	}

	public static List<GuestbookT> getGuestbooks(
		long groupId, int start, int end, OrderByComparator<GuestbookT> obc) {

		return getService().getGuestbooks(groupId, start, end, obc);
	}

	public static int getGuestbooksCount(long groupId) {
		return getService().getGuestbooksCount(groupId);
	}

	/**
	 * Returns the guestbook t with the primary key.
	 *
	 * @param guestbookTId the primary key of the guestbook t
	 * @return the guestbook t
	 * @throws PortalException if a guestbook t with the primary key could not be found
	 */
	public static GuestbookT getGuestbookT(long guestbookTId)
		throws PortalException {

		return getService().getGuestbookT(guestbookTId);
	}

	/**
	 * Returns the guestbook t matching the UUID and group.
	 *
	 * @param uuid the guestbook t's UUID
	 * @param groupId the primary key of the group
	 * @return the matching guestbook t
	 * @throws PortalException if a matching guestbook t could not be found
	 */
	public static GuestbookT getGuestbookTByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getGuestbookTByUuidAndGroupId(uuid, groupId);
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
	public static List<GuestbookT> getGuestbookTs(int start, int end) {
		return getService().getGuestbookTs(start, end);
	}

	/**
	 * Returns all the guestbook ts matching the UUID and company.
	 *
	 * @param uuid the UUID of the guestbook ts
	 * @param companyId the primary key of the company
	 * @return the matching guestbook ts, or an empty list if no matches were found
	 */
	public static List<GuestbookT> getGuestbookTsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getGuestbookTsByUuidAndCompanyId(uuid, companyId);
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
	public static List<GuestbookT> getGuestbookTsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<GuestbookT> orderByComparator) {

		return getService().getGuestbookTsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of guestbook ts.
	 *
	 * @return the number of guestbook ts
	 */
	public static int getGuestbookTsCount() {
		return getService().getGuestbookTsCount();
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
	 * Updates the guestbook t in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GuestbookTLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param guestbookT the guestbook t
	 * @return the guestbook t that was updated
	 */
	public static GuestbookT updateGuestbookT(GuestbookT guestbookT) {
		return getService().updateGuestbookT(guestbookT);
	}

	public static GuestbookT updateGuestbookT(
			long userId, long guestbookTId, String name,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException, SystemException {

		return getService().updateGuestbookT(
			userId, guestbookTId, name, serviceContext);
	}

	public static GuestbookTLocalService getService() {
		return _service;
	}

	private static volatile GuestbookTLocalService _service;

}