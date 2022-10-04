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

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.tutorial.liferay.my.gradebook.model.MyGradebook;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for MyGradebook. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Andrea Luzzi
 * @see MyGradebookLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface MyGradebookLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.tutorial.liferay.my.gradebook.service.impl.MyGradebookLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the my gradebook local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link MyGradebookLocalServiceUtil} if injection and service tracking are not available.
	 */
	public MyGradebook addMyGradebook(
			long userId, String name, ServiceContext serviceContext)
		throws PortalException;

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
	@Indexable(type = IndexableType.REINDEX)
	public MyGradebook addMyGradebook(MyGradebook myGradebook);

	/**
	 * Creates a new my gradebook with the primary key. Does not add the my gradebook to the database.
	 *
	 * @param myGradebookId the primary key for the new my gradebook
	 * @return the new my gradebook
	 */
	@Transactional(enabled = false)
	public MyGradebook createMyGradebook(long myGradebookId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

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
	@Indexable(type = IndexableType.DELETE)
	public MyGradebook deleteMyGradebook(long myGradebookId)
		throws PortalException;

	public MyGradebook deleteMyGradebook(
			long myGradebookId, ServiceContext serviceContext)
		throws PortalException, SystemException;

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
	@Indexable(type = IndexableType.DELETE)
	public MyGradebook deleteMyGradebook(MyGradebook myGradebook);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> T dslQuery(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int dslQueryCount(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MyGradebook fetchMyGradebook(long myGradebookId);

	/**
	 * Returns the my gradebook matching the UUID and group.
	 *
	 * @param uuid the my gradebook's UUID
	 * @param groupId the primary key of the group
	 * @return the matching my gradebook, or <code>null</code> if a matching my gradebook could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MyGradebook fetchMyGradebookByUuidAndGroupId(
		String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the my gradebook with the primary key.
	 *
	 * @param myGradebookId the primary key of the my gradebook
	 * @return the my gradebook
	 * @throws PortalException if a my gradebook with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MyGradebook getMyGradebook(long myGradebookId)
		throws PortalException;

	/**
	 * Returns the my gradebook matching the UUID and group.
	 *
	 * @param uuid the my gradebook's UUID
	 * @param groupId the primary key of the group
	 * @return the matching my gradebook
	 * @throws PortalException if a matching my gradebook could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MyGradebook getMyGradebookByUuidAndGroupId(String uuid, long groupId)
		throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<MyGradebook> getMyGradebooks(int start, int end);

	/**
	 * Returns all the my gradebooks matching the UUID and company.
	 *
	 * @param uuid the UUID of the my gradebooks
	 * @param companyId the primary key of the company
	 * @return the matching my gradebooks, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<MyGradebook> getMyGradebooksByUuidAndCompanyId(
		String uuid, long companyId);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<MyGradebook> getMyGradebooksByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<MyGradebook> orderByComparator);

	/**
	 * Returns the number of my gradebooks.
	 *
	 * @return the number of my gradebooks
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getMyGradebooksCount();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	public MyGradebook updateMyGradebook(
			long userId, long myGradebookId, String name,
			ServiceContext serviceContext)
		throws PortalException, SystemException;

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
	@Indexable(type = IndexableType.REINDEX)
	public MyGradebook updateMyGradebook(MyGradebook myGradebook);

}