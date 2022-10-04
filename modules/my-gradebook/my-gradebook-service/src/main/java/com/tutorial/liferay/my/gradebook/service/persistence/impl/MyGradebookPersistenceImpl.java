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

package com.tutorial.liferay.my.gradebook.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import com.tutorial.liferay.my.gradebook.exception.NoSuchMyGradebookException;
import com.tutorial.liferay.my.gradebook.model.MyGradebook;
import com.tutorial.liferay.my.gradebook.model.MyGradebookTable;
import com.tutorial.liferay.my.gradebook.model.impl.MyGradebookImpl;
import com.tutorial.liferay.my.gradebook.model.impl.MyGradebookModelImpl;
import com.tutorial.liferay.my.gradebook.service.persistence.MyGradebookPersistence;
import com.tutorial.liferay.my.gradebook.service.persistence.MyGradebookUtil;
import com.tutorial.liferay.my.gradebook.service.persistence.impl.constants.MYGDBPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the my gradebook service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Andrea Luzzi
 * @generated
 */
@Component(service = {MyGradebookPersistence.class, BasePersistence.class})
public class MyGradebookPersistenceImpl
	extends BasePersistenceImpl<MyGradebook> implements MyGradebookPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>MyGradebookUtil</code> to access the my gradebook persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		MyGradebookImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the my gradebooks where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching my gradebooks
	 */
	@Override
	public List<MyGradebook> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the my gradebooks where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MyGradebookModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of my gradebooks
	 * @param end the upper bound of the range of my gradebooks (not inclusive)
	 * @return the range of matching my gradebooks
	 */
	@Override
	public List<MyGradebook> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the my gradebooks where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MyGradebookModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of my gradebooks
	 * @param end the upper bound of the range of my gradebooks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching my gradebooks
	 */
	@Override
	public List<MyGradebook> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<MyGradebook> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the my gradebooks where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MyGradebookModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of my gradebooks
	 * @param end the upper bound of the range of my gradebooks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching my gradebooks
	 */
	@Override
	public List<MyGradebook> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<MyGradebook> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<MyGradebook> list = null;

		if (useFinderCache) {
			list = (List<MyGradebook>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (MyGradebook myGradebook : list) {
					if (!uuid.equals(myGradebook.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_MYGRADEBOOK_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MyGradebookModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<MyGradebook>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first my gradebook in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching my gradebook
	 * @throws NoSuchMyGradebookException if a matching my gradebook could not be found
	 */
	@Override
	public MyGradebook findByUuid_First(
			String uuid, OrderByComparator<MyGradebook> orderByComparator)
		throws NoSuchMyGradebookException {

		MyGradebook myGradebook = fetchByUuid_First(uuid, orderByComparator);

		if (myGradebook != null) {
			return myGradebook;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchMyGradebookException(sb.toString());
	}

	/**
	 * Returns the first my gradebook in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching my gradebook, or <code>null</code> if a matching my gradebook could not be found
	 */
	@Override
	public MyGradebook fetchByUuid_First(
		String uuid, OrderByComparator<MyGradebook> orderByComparator) {

		List<MyGradebook> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last my gradebook in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching my gradebook
	 * @throws NoSuchMyGradebookException if a matching my gradebook could not be found
	 */
	@Override
	public MyGradebook findByUuid_Last(
			String uuid, OrderByComparator<MyGradebook> orderByComparator)
		throws NoSuchMyGradebookException {

		MyGradebook myGradebook = fetchByUuid_Last(uuid, orderByComparator);

		if (myGradebook != null) {
			return myGradebook;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchMyGradebookException(sb.toString());
	}

	/**
	 * Returns the last my gradebook in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching my gradebook, or <code>null</code> if a matching my gradebook could not be found
	 */
	@Override
	public MyGradebook fetchByUuid_Last(
		String uuid, OrderByComparator<MyGradebook> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<MyGradebook> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the my gradebooks before and after the current my gradebook in the ordered set where uuid = &#63;.
	 *
	 * @param myGradebookId the primary key of the current my gradebook
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next my gradebook
	 * @throws NoSuchMyGradebookException if a my gradebook with the primary key could not be found
	 */
	@Override
	public MyGradebook[] findByUuid_PrevAndNext(
			long myGradebookId, String uuid,
			OrderByComparator<MyGradebook> orderByComparator)
		throws NoSuchMyGradebookException {

		uuid = Objects.toString(uuid, "");

		MyGradebook myGradebook = findByPrimaryKey(myGradebookId);

		Session session = null;

		try {
			session = openSession();

			MyGradebook[] array = new MyGradebookImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, myGradebook, uuid, orderByComparator, true);

			array[1] = myGradebook;

			array[2] = getByUuid_PrevAndNext(
				session, myGradebook, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected MyGradebook getByUuid_PrevAndNext(
		Session session, MyGradebook myGradebook, String uuid,
		OrderByComparator<MyGradebook> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_MYGRADEBOOK_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(MyGradebookModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(myGradebook)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MyGradebook> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the my gradebooks where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (MyGradebook myGradebook :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(myGradebook);
		}
	}

	/**
	 * Returns the number of my gradebooks where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching my gradebooks
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MYGRADEBOOK_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"myGradebook.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(myGradebook.uuid IS NULL OR myGradebook.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the my gradebook where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchMyGradebookException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching my gradebook
	 * @throws NoSuchMyGradebookException if a matching my gradebook could not be found
	 */
	@Override
	public MyGradebook findByUUID_G(String uuid, long groupId)
		throws NoSuchMyGradebookException {

		MyGradebook myGradebook = fetchByUUID_G(uuid, groupId);

		if (myGradebook == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchMyGradebookException(sb.toString());
		}

		return myGradebook;
	}

	/**
	 * Returns the my gradebook where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching my gradebook, or <code>null</code> if a matching my gradebook could not be found
	 */
	@Override
	public MyGradebook fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the my gradebook where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching my gradebook, or <code>null</code> if a matching my gradebook could not be found
	 */
	@Override
	public MyGradebook fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs);
		}

		if (result instanceof MyGradebook) {
			MyGradebook myGradebook = (MyGradebook)result;

			if (!Objects.equals(uuid, myGradebook.getUuid()) ||
				(groupId != myGradebook.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_MYGRADEBOOK_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<MyGradebook> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					MyGradebook myGradebook = list.get(0);

					result = myGradebook;

					cacheResult(myGradebook);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (MyGradebook)result;
		}
	}

	/**
	 * Removes the my gradebook where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the my gradebook that was removed
	 */
	@Override
	public MyGradebook removeByUUID_G(String uuid, long groupId)
		throws NoSuchMyGradebookException {

		MyGradebook myGradebook = findByUUID_G(uuid, groupId);

		return remove(myGradebook);
	}

	/**
	 * Returns the number of my gradebooks where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching my gradebooks
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_MYGRADEBOOK_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"myGradebook.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(myGradebook.uuid IS NULL OR myGradebook.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"myGradebook.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the my gradebooks where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching my gradebooks
	 */
	@Override
	public List<MyGradebook> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the my gradebooks where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MyGradebookModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of my gradebooks
	 * @param end the upper bound of the range of my gradebooks (not inclusive)
	 * @return the range of matching my gradebooks
	 */
	@Override
	public List<MyGradebook> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the my gradebooks where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MyGradebookModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of my gradebooks
	 * @param end the upper bound of the range of my gradebooks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching my gradebooks
	 */
	@Override
	public List<MyGradebook> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<MyGradebook> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the my gradebooks where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MyGradebookModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of my gradebooks
	 * @param end the upper bound of the range of my gradebooks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching my gradebooks
	 */
	@Override
	public List<MyGradebook> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<MyGradebook> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<MyGradebook> list = null;

		if (useFinderCache) {
			list = (List<MyGradebook>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (MyGradebook myGradebook : list) {
					if (!uuid.equals(myGradebook.getUuid()) ||
						(companyId != myGradebook.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_MYGRADEBOOK_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MyGradebookModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<MyGradebook>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first my gradebook in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching my gradebook
	 * @throws NoSuchMyGradebookException if a matching my gradebook could not be found
	 */
	@Override
	public MyGradebook findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<MyGradebook> orderByComparator)
		throws NoSuchMyGradebookException {

		MyGradebook myGradebook = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (myGradebook != null) {
			return myGradebook;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchMyGradebookException(sb.toString());
	}

	/**
	 * Returns the first my gradebook in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching my gradebook, or <code>null</code> if a matching my gradebook could not be found
	 */
	@Override
	public MyGradebook fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<MyGradebook> orderByComparator) {

		List<MyGradebook> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last my gradebook in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching my gradebook
	 * @throws NoSuchMyGradebookException if a matching my gradebook could not be found
	 */
	@Override
	public MyGradebook findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<MyGradebook> orderByComparator)
		throws NoSuchMyGradebookException {

		MyGradebook myGradebook = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (myGradebook != null) {
			return myGradebook;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchMyGradebookException(sb.toString());
	}

	/**
	 * Returns the last my gradebook in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching my gradebook, or <code>null</code> if a matching my gradebook could not be found
	 */
	@Override
	public MyGradebook fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<MyGradebook> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<MyGradebook> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the my gradebooks before and after the current my gradebook in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param myGradebookId the primary key of the current my gradebook
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next my gradebook
	 * @throws NoSuchMyGradebookException if a my gradebook with the primary key could not be found
	 */
	@Override
	public MyGradebook[] findByUuid_C_PrevAndNext(
			long myGradebookId, String uuid, long companyId,
			OrderByComparator<MyGradebook> orderByComparator)
		throws NoSuchMyGradebookException {

		uuid = Objects.toString(uuid, "");

		MyGradebook myGradebook = findByPrimaryKey(myGradebookId);

		Session session = null;

		try {
			session = openSession();

			MyGradebook[] array = new MyGradebookImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, myGradebook, uuid, companyId, orderByComparator, true);

			array[1] = myGradebook;

			array[2] = getByUuid_C_PrevAndNext(
				session, myGradebook, uuid, companyId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected MyGradebook getByUuid_C_PrevAndNext(
		Session session, MyGradebook myGradebook, String uuid, long companyId,
		OrderByComparator<MyGradebook> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_MYGRADEBOOK_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(MyGradebookModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(myGradebook)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MyGradebook> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the my gradebooks where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (MyGradebook myGradebook :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(myGradebook);
		}
	}

	/**
	 * Returns the number of my gradebooks where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching my gradebooks
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_MYGRADEBOOK_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"myGradebook.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(myGradebook.uuid IS NULL OR myGradebook.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"myGradebook.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the my gradebooks where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching my gradebooks
	 */
	@Override
	public List<MyGradebook> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the my gradebooks where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MyGradebookModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of my gradebooks
	 * @param end the upper bound of the range of my gradebooks (not inclusive)
	 * @return the range of matching my gradebooks
	 */
	@Override
	public List<MyGradebook> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the my gradebooks where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MyGradebookModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of my gradebooks
	 * @param end the upper bound of the range of my gradebooks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching my gradebooks
	 */
	@Override
	public List<MyGradebook> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<MyGradebook> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the my gradebooks where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MyGradebookModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of my gradebooks
	 * @param end the upper bound of the range of my gradebooks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching my gradebooks
	 */
	@Override
	public List<MyGradebook> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<MyGradebook> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGroupId;
				finderArgs = new Object[] {groupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGroupId;
			finderArgs = new Object[] {groupId, start, end, orderByComparator};
		}

		List<MyGradebook> list = null;

		if (useFinderCache) {
			list = (List<MyGradebook>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (MyGradebook myGradebook : list) {
					if (groupId != myGradebook.getGroupId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_MYGRADEBOOK_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MyGradebookModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<MyGradebook>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first my gradebook in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching my gradebook
	 * @throws NoSuchMyGradebookException if a matching my gradebook could not be found
	 */
	@Override
	public MyGradebook findByGroupId_First(
			long groupId, OrderByComparator<MyGradebook> orderByComparator)
		throws NoSuchMyGradebookException {

		MyGradebook myGradebook = fetchByGroupId_First(
			groupId, orderByComparator);

		if (myGradebook != null) {
			return myGradebook;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchMyGradebookException(sb.toString());
	}

	/**
	 * Returns the first my gradebook in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching my gradebook, or <code>null</code> if a matching my gradebook could not be found
	 */
	@Override
	public MyGradebook fetchByGroupId_First(
		long groupId, OrderByComparator<MyGradebook> orderByComparator) {

		List<MyGradebook> list = findByGroupId(
			groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last my gradebook in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching my gradebook
	 * @throws NoSuchMyGradebookException if a matching my gradebook could not be found
	 */
	@Override
	public MyGradebook findByGroupId_Last(
			long groupId, OrderByComparator<MyGradebook> orderByComparator)
		throws NoSuchMyGradebookException {

		MyGradebook myGradebook = fetchByGroupId_Last(
			groupId, orderByComparator);

		if (myGradebook != null) {
			return myGradebook;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchMyGradebookException(sb.toString());
	}

	/**
	 * Returns the last my gradebook in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching my gradebook, or <code>null</code> if a matching my gradebook could not be found
	 */
	@Override
	public MyGradebook fetchByGroupId_Last(
		long groupId, OrderByComparator<MyGradebook> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<MyGradebook> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the my gradebooks before and after the current my gradebook in the ordered set where groupId = &#63;.
	 *
	 * @param myGradebookId the primary key of the current my gradebook
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next my gradebook
	 * @throws NoSuchMyGradebookException if a my gradebook with the primary key could not be found
	 */
	@Override
	public MyGradebook[] findByGroupId_PrevAndNext(
			long myGradebookId, long groupId,
			OrderByComparator<MyGradebook> orderByComparator)
		throws NoSuchMyGradebookException {

		MyGradebook myGradebook = findByPrimaryKey(myGradebookId);

		Session session = null;

		try {
			session = openSession();

			MyGradebook[] array = new MyGradebookImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, myGradebook, groupId, orderByComparator, true);

			array[1] = myGradebook;

			array[2] = getByGroupId_PrevAndNext(
				session, myGradebook, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected MyGradebook getByGroupId_PrevAndNext(
		Session session, MyGradebook myGradebook, long groupId,
		OrderByComparator<MyGradebook> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_MYGRADEBOOK_WHERE);

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(MyGradebookModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(myGradebook)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MyGradebook> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the my gradebooks where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (MyGradebook myGradebook :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(myGradebook);
		}
	}

	/**
	 * Returns the number of my gradebooks where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching my gradebooks
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MYGRADEBOOK_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 =
		"myGradebook.groupId = ?";

	public MyGradebookPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(MyGradebook.class);

		setModelImplClass(MyGradebookImpl.class);
		setModelPKClass(long.class);

		setTable(MyGradebookTable.INSTANCE);
	}

	/**
	 * Caches the my gradebook in the entity cache if it is enabled.
	 *
	 * @param myGradebook the my gradebook
	 */
	@Override
	public void cacheResult(MyGradebook myGradebook) {
		entityCache.putResult(
			MyGradebookImpl.class, myGradebook.getPrimaryKey(), myGradebook);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {myGradebook.getUuid(), myGradebook.getGroupId()},
			myGradebook);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the my gradebooks in the entity cache if it is enabled.
	 *
	 * @param myGradebooks the my gradebooks
	 */
	@Override
	public void cacheResult(List<MyGradebook> myGradebooks) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (myGradebooks.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (MyGradebook myGradebook : myGradebooks) {
			if (entityCache.getResult(
					MyGradebookImpl.class, myGradebook.getPrimaryKey()) ==
						null) {

				cacheResult(myGradebook);
			}
		}
	}

	/**
	 * Clears the cache for all my gradebooks.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MyGradebookImpl.class);

		finderCache.clearCache(MyGradebookImpl.class);
	}

	/**
	 * Clears the cache for the my gradebook.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MyGradebook myGradebook) {
		entityCache.removeResult(MyGradebookImpl.class, myGradebook);
	}

	@Override
	public void clearCache(List<MyGradebook> myGradebooks) {
		for (MyGradebook myGradebook : myGradebooks) {
			entityCache.removeResult(MyGradebookImpl.class, myGradebook);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(MyGradebookImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(MyGradebookImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		MyGradebookModelImpl myGradebookModelImpl) {

		Object[] args = new Object[] {
			myGradebookModelImpl.getUuid(), myGradebookModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, myGradebookModelImpl);
	}

	/**
	 * Creates a new my gradebook with the primary key. Does not add the my gradebook to the database.
	 *
	 * @param myGradebookId the primary key for the new my gradebook
	 * @return the new my gradebook
	 */
	@Override
	public MyGradebook create(long myGradebookId) {
		MyGradebook myGradebook = new MyGradebookImpl();

		myGradebook.setNew(true);
		myGradebook.setPrimaryKey(myGradebookId);

		String uuid = PortalUUIDUtil.generate();

		myGradebook.setUuid(uuid);

		myGradebook.setCompanyId(CompanyThreadLocal.getCompanyId());

		return myGradebook;
	}

	/**
	 * Removes the my gradebook with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param myGradebookId the primary key of the my gradebook
	 * @return the my gradebook that was removed
	 * @throws NoSuchMyGradebookException if a my gradebook with the primary key could not be found
	 */
	@Override
	public MyGradebook remove(long myGradebookId)
		throws NoSuchMyGradebookException {

		return remove((Serializable)myGradebookId);
	}

	/**
	 * Removes the my gradebook with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the my gradebook
	 * @return the my gradebook that was removed
	 * @throws NoSuchMyGradebookException if a my gradebook with the primary key could not be found
	 */
	@Override
	public MyGradebook remove(Serializable primaryKey)
		throws NoSuchMyGradebookException {

		Session session = null;

		try {
			session = openSession();

			MyGradebook myGradebook = (MyGradebook)session.get(
				MyGradebookImpl.class, primaryKey);

			if (myGradebook == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMyGradebookException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(myGradebook);
		}
		catch (NoSuchMyGradebookException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected MyGradebook removeImpl(MyGradebook myGradebook) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(myGradebook)) {
				myGradebook = (MyGradebook)session.get(
					MyGradebookImpl.class, myGradebook.getPrimaryKeyObj());
			}

			if (myGradebook != null) {
				session.delete(myGradebook);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (myGradebook != null) {
			clearCache(myGradebook);
		}

		return myGradebook;
	}

	@Override
	public MyGradebook updateImpl(MyGradebook myGradebook) {
		boolean isNew = myGradebook.isNew();

		if (!(myGradebook instanceof MyGradebookModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(myGradebook.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(myGradebook);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in myGradebook proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom MyGradebook implementation " +
					myGradebook.getClass());
		}

		MyGradebookModelImpl myGradebookModelImpl =
			(MyGradebookModelImpl)myGradebook;

		if (Validator.isNull(myGradebook.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			myGradebook.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (myGradebook.getCreateDate() == null)) {
			if (serviceContext == null) {
				myGradebook.setCreateDate(date);
			}
			else {
				myGradebook.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!myGradebookModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				myGradebook.setModifiedDate(date);
			}
			else {
				myGradebook.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(myGradebook);
			}
			else {
				myGradebook = (MyGradebook)session.merge(myGradebook);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			MyGradebookImpl.class, myGradebookModelImpl, false, true);

		cacheUniqueFindersCache(myGradebookModelImpl);

		if (isNew) {
			myGradebook.setNew(false);
		}

		myGradebook.resetOriginalValues();

		return myGradebook;
	}

	/**
	 * Returns the my gradebook with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the my gradebook
	 * @return the my gradebook
	 * @throws NoSuchMyGradebookException if a my gradebook with the primary key could not be found
	 */
	@Override
	public MyGradebook findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMyGradebookException {

		MyGradebook myGradebook = fetchByPrimaryKey(primaryKey);

		if (myGradebook == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMyGradebookException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return myGradebook;
	}

	/**
	 * Returns the my gradebook with the primary key or throws a <code>NoSuchMyGradebookException</code> if it could not be found.
	 *
	 * @param myGradebookId the primary key of the my gradebook
	 * @return the my gradebook
	 * @throws NoSuchMyGradebookException if a my gradebook with the primary key could not be found
	 */
	@Override
	public MyGradebook findByPrimaryKey(long myGradebookId)
		throws NoSuchMyGradebookException {

		return findByPrimaryKey((Serializable)myGradebookId);
	}

	/**
	 * Returns the my gradebook with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param myGradebookId the primary key of the my gradebook
	 * @return the my gradebook, or <code>null</code> if a my gradebook with the primary key could not be found
	 */
	@Override
	public MyGradebook fetchByPrimaryKey(long myGradebookId) {
		return fetchByPrimaryKey((Serializable)myGradebookId);
	}

	/**
	 * Returns all the my gradebooks.
	 *
	 * @return the my gradebooks
	 */
	@Override
	public List<MyGradebook> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the my gradebooks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MyGradebookModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of my gradebooks
	 * @param end the upper bound of the range of my gradebooks (not inclusive)
	 * @return the range of my gradebooks
	 */
	@Override
	public List<MyGradebook> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the my gradebooks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MyGradebookModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of my gradebooks
	 * @param end the upper bound of the range of my gradebooks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of my gradebooks
	 */
	@Override
	public List<MyGradebook> findAll(
		int start, int end, OrderByComparator<MyGradebook> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the my gradebooks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MyGradebookModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of my gradebooks
	 * @param end the upper bound of the range of my gradebooks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of my gradebooks
	 */
	@Override
	public List<MyGradebook> findAll(
		int start, int end, OrderByComparator<MyGradebook> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<MyGradebook> list = null;

		if (useFinderCache) {
			list = (List<MyGradebook>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_MYGRADEBOOK);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_MYGRADEBOOK;

				sql = sql.concat(MyGradebookModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<MyGradebook>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the my gradebooks from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (MyGradebook myGradebook : findAll()) {
			remove(myGradebook);
		}
	}

	/**
	 * Returns the number of my gradebooks.
	 *
	 * @return the number of my gradebooks
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_MYGRADEBOOK);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "myGradebookId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_MYGRADEBOOK;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return MyGradebookModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the my gradebook persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathFetchByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathCountByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, false);

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_finderPathWithPaginationFindByGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"groupId"}, true);

		_finderPathWithoutPaginationFindByGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] {Long.class.getName()}, new String[] {"groupId"},
			true);

		_finderPathCountByGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] {Long.class.getName()}, new String[] {"groupId"},
			false);

		_setMyGradebookUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setMyGradebookUtilPersistence(null);

		entityCache.removeCache(MyGradebookImpl.class.getName());
	}

	private void _setMyGradebookUtilPersistence(
		MyGradebookPersistence myGradebookPersistence) {

		try {
			Field field = MyGradebookUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, myGradebookPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = MYGDBPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = MYGDBPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = MYGDBPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_MYGRADEBOOK =
		"SELECT myGradebook FROM MyGradebook myGradebook";

	private static final String _SQL_SELECT_MYGRADEBOOK_WHERE =
		"SELECT myGradebook FROM MyGradebook myGradebook WHERE ";

	private static final String _SQL_COUNT_MYGRADEBOOK =
		"SELECT COUNT(myGradebook) FROM MyGradebook myGradebook";

	private static final String _SQL_COUNT_MYGRADEBOOK_WHERE =
		"SELECT COUNT(myGradebook) FROM MyGradebook myGradebook WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "myGradebook.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No MyGradebook exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No MyGradebook exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		MyGradebookPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private MyGradebookModelArgumentsResolver
		_myGradebookModelArgumentsResolver;

}