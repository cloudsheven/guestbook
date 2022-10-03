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

package com.tutorial.guestbookt.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.security.permission.InlineSQLHelperUtil;
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

import com.tutorial.guestbookt.exception.NoSuchGuestbookTEntryException;
import com.tutorial.guestbookt.model.GuestbookTEntry;
import com.tutorial.guestbookt.model.GuestbookTEntryTable;
import com.tutorial.guestbookt.model.impl.GuestbookTEntryImpl;
import com.tutorial.guestbookt.model.impl.GuestbookTEntryModelImpl;
import com.tutorial.guestbookt.service.persistence.GuestbookTEntryPersistence;
import com.tutorial.guestbookt.service.persistence.GuestbookTEntryUtil;
import com.tutorial.guestbookt.service.persistence.impl.constants.GBTPersistenceConstants;

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
 * The persistence implementation for the guestbook t entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Andrea Luzzi
 * @generated
 */
@Component(service = {GuestbookTEntryPersistence.class, BasePersistence.class})
public class GuestbookTEntryPersistenceImpl
	extends BasePersistenceImpl<GuestbookTEntry>
	implements GuestbookTEntryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>GuestbookTEntryUtil</code> to access the guestbook t entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		GuestbookTEntryImpl.class.getName();

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
	 * Returns all the guestbook t entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching guestbook t entries
	 */
	@Override
	public List<GuestbookTEntry> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the guestbook t entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of guestbook t entries
	 * @param end the upper bound of the range of guestbook t entries (not inclusive)
	 * @return the range of matching guestbook t entries
	 */
	@Override
	public List<GuestbookTEntry> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the guestbook t entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of guestbook t entries
	 * @param end the upper bound of the range of guestbook t entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching guestbook t entries
	 */
	@Override
	public List<GuestbookTEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<GuestbookTEntry> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the guestbook t entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of guestbook t entries
	 * @param end the upper bound of the range of guestbook t entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching guestbook t entries
	 */
	@Override
	public List<GuestbookTEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<GuestbookTEntry> orderByComparator,
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

		List<GuestbookTEntry> list = null;

		if (useFinderCache) {
			list = (List<GuestbookTEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (GuestbookTEntry guestbookTEntry : list) {
					if (!uuid.equals(guestbookTEntry.getUuid())) {
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

			sb.append(_SQL_SELECT_GUESTBOOKTENTRY_WHERE);

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
				sb.append(GuestbookTEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<GuestbookTEntry>)QueryUtil.list(
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
	 * Returns the first guestbook t entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching guestbook t entry
	 * @throws NoSuchGuestbookTEntryException if a matching guestbook t entry could not be found
	 */
	@Override
	public GuestbookTEntry findByUuid_First(
			String uuid, OrderByComparator<GuestbookTEntry> orderByComparator)
		throws NoSuchGuestbookTEntryException {

		GuestbookTEntry guestbookTEntry = fetchByUuid_First(
			uuid, orderByComparator);

		if (guestbookTEntry != null) {
			return guestbookTEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchGuestbookTEntryException(sb.toString());
	}

	/**
	 * Returns the first guestbook t entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching guestbook t entry, or <code>null</code> if a matching guestbook t entry could not be found
	 */
	@Override
	public GuestbookTEntry fetchByUuid_First(
		String uuid, OrderByComparator<GuestbookTEntry> orderByComparator) {

		List<GuestbookTEntry> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last guestbook t entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching guestbook t entry
	 * @throws NoSuchGuestbookTEntryException if a matching guestbook t entry could not be found
	 */
	@Override
	public GuestbookTEntry findByUuid_Last(
			String uuid, OrderByComparator<GuestbookTEntry> orderByComparator)
		throws NoSuchGuestbookTEntryException {

		GuestbookTEntry guestbookTEntry = fetchByUuid_Last(
			uuid, orderByComparator);

		if (guestbookTEntry != null) {
			return guestbookTEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchGuestbookTEntryException(sb.toString());
	}

	/**
	 * Returns the last guestbook t entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching guestbook t entry, or <code>null</code> if a matching guestbook t entry could not be found
	 */
	@Override
	public GuestbookTEntry fetchByUuid_Last(
		String uuid, OrderByComparator<GuestbookTEntry> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<GuestbookTEntry> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the guestbook t entries before and after the current guestbook t entry in the ordered set where uuid = &#63;.
	 *
	 * @param entryId the primary key of the current guestbook t entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next guestbook t entry
	 * @throws NoSuchGuestbookTEntryException if a guestbook t entry with the primary key could not be found
	 */
	@Override
	public GuestbookTEntry[] findByUuid_PrevAndNext(
			long entryId, String uuid,
			OrderByComparator<GuestbookTEntry> orderByComparator)
		throws NoSuchGuestbookTEntryException {

		uuid = Objects.toString(uuid, "");

		GuestbookTEntry guestbookTEntry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			GuestbookTEntry[] array = new GuestbookTEntryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, guestbookTEntry, uuid, orderByComparator, true);

			array[1] = guestbookTEntry;

			array[2] = getByUuid_PrevAndNext(
				session, guestbookTEntry, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected GuestbookTEntry getByUuid_PrevAndNext(
		Session session, GuestbookTEntry guestbookTEntry, String uuid,
		OrderByComparator<GuestbookTEntry> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_GUESTBOOKTENTRY_WHERE);

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
			sb.append(GuestbookTEntryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						guestbookTEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<GuestbookTEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the guestbook t entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (GuestbookTEntry guestbookTEntry :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(guestbookTEntry);
		}
	}

	/**
	 * Returns the number of guestbook t entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching guestbook t entries
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_GUESTBOOKTENTRY_WHERE);

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
		"guestbookTEntry.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(guestbookTEntry.uuid IS NULL OR guestbookTEntry.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the guestbook t entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchGuestbookTEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching guestbook t entry
	 * @throws NoSuchGuestbookTEntryException if a matching guestbook t entry could not be found
	 */
	@Override
	public GuestbookTEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchGuestbookTEntryException {

		GuestbookTEntry guestbookTEntry = fetchByUUID_G(uuid, groupId);

		if (guestbookTEntry == null) {
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

			throw new NoSuchGuestbookTEntryException(sb.toString());
		}

		return guestbookTEntry;
	}

	/**
	 * Returns the guestbook t entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching guestbook t entry, or <code>null</code> if a matching guestbook t entry could not be found
	 */
	@Override
	public GuestbookTEntry fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the guestbook t entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching guestbook t entry, or <code>null</code> if a matching guestbook t entry could not be found
	 */
	@Override
	public GuestbookTEntry fetchByUUID_G(
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

		if (result instanceof GuestbookTEntry) {
			GuestbookTEntry guestbookTEntry = (GuestbookTEntry)result;

			if (!Objects.equals(uuid, guestbookTEntry.getUuid()) ||
				(groupId != guestbookTEntry.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_GUESTBOOKTENTRY_WHERE);

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

				List<GuestbookTEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					GuestbookTEntry guestbookTEntry = list.get(0);

					result = guestbookTEntry;

					cacheResult(guestbookTEntry);
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
			return (GuestbookTEntry)result;
		}
	}

	/**
	 * Removes the guestbook t entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the guestbook t entry that was removed
	 */
	@Override
	public GuestbookTEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchGuestbookTEntryException {

		GuestbookTEntry guestbookTEntry = findByUUID_G(uuid, groupId);

		return remove(guestbookTEntry);
	}

	/**
	 * Returns the number of guestbook t entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching guestbook t entries
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_GUESTBOOKTENTRY_WHERE);

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
		"guestbookTEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(guestbookTEntry.uuid IS NULL OR guestbookTEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"guestbookTEntry.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the guestbook t entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching guestbook t entries
	 */
	@Override
	public List<GuestbookTEntry> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the guestbook t entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of guestbook t entries
	 * @param end the upper bound of the range of guestbook t entries (not inclusive)
	 * @return the range of matching guestbook t entries
	 */
	@Override
	public List<GuestbookTEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the guestbook t entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of guestbook t entries
	 * @param end the upper bound of the range of guestbook t entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching guestbook t entries
	 */
	@Override
	public List<GuestbookTEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<GuestbookTEntry> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the guestbook t entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of guestbook t entries
	 * @param end the upper bound of the range of guestbook t entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching guestbook t entries
	 */
	@Override
	public List<GuestbookTEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<GuestbookTEntry> orderByComparator,
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

		List<GuestbookTEntry> list = null;

		if (useFinderCache) {
			list = (List<GuestbookTEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (GuestbookTEntry guestbookTEntry : list) {
					if (!uuid.equals(guestbookTEntry.getUuid()) ||
						(companyId != guestbookTEntry.getCompanyId())) {

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

			sb.append(_SQL_SELECT_GUESTBOOKTENTRY_WHERE);

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
				sb.append(GuestbookTEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<GuestbookTEntry>)QueryUtil.list(
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
	 * Returns the first guestbook t entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching guestbook t entry
	 * @throws NoSuchGuestbookTEntryException if a matching guestbook t entry could not be found
	 */
	@Override
	public GuestbookTEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<GuestbookTEntry> orderByComparator)
		throws NoSuchGuestbookTEntryException {

		GuestbookTEntry guestbookTEntry = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (guestbookTEntry != null) {
			return guestbookTEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchGuestbookTEntryException(sb.toString());
	}

	/**
	 * Returns the first guestbook t entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching guestbook t entry, or <code>null</code> if a matching guestbook t entry could not be found
	 */
	@Override
	public GuestbookTEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<GuestbookTEntry> orderByComparator) {

		List<GuestbookTEntry> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last guestbook t entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching guestbook t entry
	 * @throws NoSuchGuestbookTEntryException if a matching guestbook t entry could not be found
	 */
	@Override
	public GuestbookTEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<GuestbookTEntry> orderByComparator)
		throws NoSuchGuestbookTEntryException {

		GuestbookTEntry guestbookTEntry = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (guestbookTEntry != null) {
			return guestbookTEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchGuestbookTEntryException(sb.toString());
	}

	/**
	 * Returns the last guestbook t entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching guestbook t entry, or <code>null</code> if a matching guestbook t entry could not be found
	 */
	@Override
	public GuestbookTEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<GuestbookTEntry> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<GuestbookTEntry> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the guestbook t entries before and after the current guestbook t entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param entryId the primary key of the current guestbook t entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next guestbook t entry
	 * @throws NoSuchGuestbookTEntryException if a guestbook t entry with the primary key could not be found
	 */
	@Override
	public GuestbookTEntry[] findByUuid_C_PrevAndNext(
			long entryId, String uuid, long companyId,
			OrderByComparator<GuestbookTEntry> orderByComparator)
		throws NoSuchGuestbookTEntryException {

		uuid = Objects.toString(uuid, "");

		GuestbookTEntry guestbookTEntry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			GuestbookTEntry[] array = new GuestbookTEntryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, guestbookTEntry, uuid, companyId, orderByComparator,
				true);

			array[1] = guestbookTEntry;

			array[2] = getByUuid_C_PrevAndNext(
				session, guestbookTEntry, uuid, companyId, orderByComparator,
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

	protected GuestbookTEntry getByUuid_C_PrevAndNext(
		Session session, GuestbookTEntry guestbookTEntry, String uuid,
		long companyId, OrderByComparator<GuestbookTEntry> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_GUESTBOOKTENTRY_WHERE);

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
			sb.append(GuestbookTEntryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						guestbookTEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<GuestbookTEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the guestbook t entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (GuestbookTEntry guestbookTEntry :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(guestbookTEntry);
		}
	}

	/**
	 * Returns the number of guestbook t entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching guestbook t entries
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_GUESTBOOKTENTRY_WHERE);

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
		"guestbookTEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(guestbookTEntry.uuid IS NULL OR guestbookTEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"guestbookTEntry.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByG_G;
	private FinderPath _finderPathWithoutPaginationFindByG_G;
	private FinderPath _finderPathCountByG_G;

	/**
	 * Returns all the guestbook t entries where groupId = &#63; and guestbookTId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @return the matching guestbook t entries
	 */
	@Override
	public List<GuestbookTEntry> findByG_G(long groupId, long guestbookTId) {
		return findByG_G(
			groupId, guestbookTId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the guestbook t entries where groupId = &#63; and guestbookTId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param start the lower bound of the range of guestbook t entries
	 * @param end the upper bound of the range of guestbook t entries (not inclusive)
	 * @return the range of matching guestbook t entries
	 */
	@Override
	public List<GuestbookTEntry> findByG_G(
		long groupId, long guestbookTId, int start, int end) {

		return findByG_G(groupId, guestbookTId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the guestbook t entries where groupId = &#63; and guestbookTId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param start the lower bound of the range of guestbook t entries
	 * @param end the upper bound of the range of guestbook t entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching guestbook t entries
	 */
	@Override
	public List<GuestbookTEntry> findByG_G(
		long groupId, long guestbookTId, int start, int end,
		OrderByComparator<GuestbookTEntry> orderByComparator) {

		return findByG_G(
			groupId, guestbookTId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the guestbook t entries where groupId = &#63; and guestbookTId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param start the lower bound of the range of guestbook t entries
	 * @param end the upper bound of the range of guestbook t entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching guestbook t entries
	 */
	@Override
	public List<GuestbookTEntry> findByG_G(
		long groupId, long guestbookTId, int start, int end,
		OrderByComparator<GuestbookTEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_G;
				finderArgs = new Object[] {groupId, guestbookTId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_G;
			finderArgs = new Object[] {
				groupId, guestbookTId, start, end, orderByComparator
			};
		}

		List<GuestbookTEntry> list = null;

		if (useFinderCache) {
			list = (List<GuestbookTEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (GuestbookTEntry guestbookTEntry : list) {
					if ((groupId != guestbookTEntry.getGroupId()) ||
						(guestbookTId != guestbookTEntry.getGuestbookTId())) {

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

			sb.append(_SQL_SELECT_GUESTBOOKTENTRY_WHERE);

			sb.append(_FINDER_COLUMN_G_G_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_G_GUESTBOOKTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(GuestbookTEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(guestbookTId);

				list = (List<GuestbookTEntry>)QueryUtil.list(
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
	 * Returns the first guestbook t entry in the ordered set where groupId = &#63; and guestbookTId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching guestbook t entry
	 * @throws NoSuchGuestbookTEntryException if a matching guestbook t entry could not be found
	 */
	@Override
	public GuestbookTEntry findByG_G_First(
			long groupId, long guestbookTId,
			OrderByComparator<GuestbookTEntry> orderByComparator)
		throws NoSuchGuestbookTEntryException {

		GuestbookTEntry guestbookTEntry = fetchByG_G_First(
			groupId, guestbookTId, orderByComparator);

		if (guestbookTEntry != null) {
			return guestbookTEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", guestbookTId=");
		sb.append(guestbookTId);

		sb.append("}");

		throw new NoSuchGuestbookTEntryException(sb.toString());
	}

	/**
	 * Returns the first guestbook t entry in the ordered set where groupId = &#63; and guestbookTId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching guestbook t entry, or <code>null</code> if a matching guestbook t entry could not be found
	 */
	@Override
	public GuestbookTEntry fetchByG_G_First(
		long groupId, long guestbookTId,
		OrderByComparator<GuestbookTEntry> orderByComparator) {

		List<GuestbookTEntry> list = findByG_G(
			groupId, guestbookTId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last guestbook t entry in the ordered set where groupId = &#63; and guestbookTId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching guestbook t entry
	 * @throws NoSuchGuestbookTEntryException if a matching guestbook t entry could not be found
	 */
	@Override
	public GuestbookTEntry findByG_G_Last(
			long groupId, long guestbookTId,
			OrderByComparator<GuestbookTEntry> orderByComparator)
		throws NoSuchGuestbookTEntryException {

		GuestbookTEntry guestbookTEntry = fetchByG_G_Last(
			groupId, guestbookTId, orderByComparator);

		if (guestbookTEntry != null) {
			return guestbookTEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", guestbookTId=");
		sb.append(guestbookTId);

		sb.append("}");

		throw new NoSuchGuestbookTEntryException(sb.toString());
	}

	/**
	 * Returns the last guestbook t entry in the ordered set where groupId = &#63; and guestbookTId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching guestbook t entry, or <code>null</code> if a matching guestbook t entry could not be found
	 */
	@Override
	public GuestbookTEntry fetchByG_G_Last(
		long groupId, long guestbookTId,
		OrderByComparator<GuestbookTEntry> orderByComparator) {

		int count = countByG_G(groupId, guestbookTId);

		if (count == 0) {
			return null;
		}

		List<GuestbookTEntry> list = findByG_G(
			groupId, guestbookTId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the guestbook t entries before and after the current guestbook t entry in the ordered set where groupId = &#63; and guestbookTId = &#63;.
	 *
	 * @param entryId the primary key of the current guestbook t entry
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next guestbook t entry
	 * @throws NoSuchGuestbookTEntryException if a guestbook t entry with the primary key could not be found
	 */
	@Override
	public GuestbookTEntry[] findByG_G_PrevAndNext(
			long entryId, long groupId, long guestbookTId,
			OrderByComparator<GuestbookTEntry> orderByComparator)
		throws NoSuchGuestbookTEntryException {

		GuestbookTEntry guestbookTEntry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			GuestbookTEntry[] array = new GuestbookTEntryImpl[3];

			array[0] = getByG_G_PrevAndNext(
				session, guestbookTEntry, groupId, guestbookTId,
				orderByComparator, true);

			array[1] = guestbookTEntry;

			array[2] = getByG_G_PrevAndNext(
				session, guestbookTEntry, groupId, guestbookTId,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected GuestbookTEntry getByG_G_PrevAndNext(
		Session session, GuestbookTEntry guestbookTEntry, long groupId,
		long guestbookTId, OrderByComparator<GuestbookTEntry> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_GUESTBOOKTENTRY_WHERE);

		sb.append(_FINDER_COLUMN_G_G_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_G_GUESTBOOKTID_2);

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
			sb.append(GuestbookTEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(guestbookTId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						guestbookTEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<GuestbookTEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the guestbook t entries that the user has permission to view where groupId = &#63; and guestbookTId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @return the matching guestbook t entries that the user has permission to view
	 */
	@Override
	public List<GuestbookTEntry> filterFindByG_G(
		long groupId, long guestbookTId) {

		return filterFindByG_G(
			groupId, guestbookTId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the guestbook t entries that the user has permission to view where groupId = &#63; and guestbookTId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param start the lower bound of the range of guestbook t entries
	 * @param end the upper bound of the range of guestbook t entries (not inclusive)
	 * @return the range of matching guestbook t entries that the user has permission to view
	 */
	@Override
	public List<GuestbookTEntry> filterFindByG_G(
		long groupId, long guestbookTId, int start, int end) {

		return filterFindByG_G(groupId, guestbookTId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the guestbook t entries that the user has permissions to view where groupId = &#63; and guestbookTId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param start the lower bound of the range of guestbook t entries
	 * @param end the upper bound of the range of guestbook t entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching guestbook t entries that the user has permission to view
	 */
	@Override
	public List<GuestbookTEntry> filterFindByG_G(
		long groupId, long guestbookTId, int start, int end,
		OrderByComparator<GuestbookTEntry> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_G(
				groupId, guestbookTId, start, end, orderByComparator);
		}

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByFields().length * 2));
		}
		else {
			sb = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_GUESTBOOKTENTRY_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_GUESTBOOKTENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_G_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_G_GUESTBOOKTID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_GUESTBOOKTENTRY_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator, true);
			}
			else {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_TABLE, orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(GuestbookTEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(GuestbookTEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), GuestbookTEntry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(
					_FILTER_ENTITY_ALIAS, GuestbookTEntryImpl.class);
			}
			else {
				sqlQuery.addEntity(
					_FILTER_ENTITY_TABLE, GuestbookTEntryImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			queryPos.add(guestbookTId);

			return (List<GuestbookTEntry>)QueryUtil.list(
				sqlQuery, getDialect(), start, end);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the guestbook t entries before and after the current guestbook t entry in the ordered set of guestbook t entries that the user has permission to view where groupId = &#63; and guestbookTId = &#63;.
	 *
	 * @param entryId the primary key of the current guestbook t entry
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next guestbook t entry
	 * @throws NoSuchGuestbookTEntryException if a guestbook t entry with the primary key could not be found
	 */
	@Override
	public GuestbookTEntry[] filterFindByG_G_PrevAndNext(
			long entryId, long groupId, long guestbookTId,
			OrderByComparator<GuestbookTEntry> orderByComparator)
		throws NoSuchGuestbookTEntryException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_G_PrevAndNext(
				entryId, groupId, guestbookTId, orderByComparator);
		}

		GuestbookTEntry guestbookTEntry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			GuestbookTEntry[] array = new GuestbookTEntryImpl[3];

			array[0] = filterGetByG_G_PrevAndNext(
				session, guestbookTEntry, groupId, guestbookTId,
				orderByComparator, true);

			array[1] = guestbookTEntry;

			array[2] = filterGetByG_G_PrevAndNext(
				session, guestbookTEntry, groupId, guestbookTId,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected GuestbookTEntry filterGetByG_G_PrevAndNext(
		Session session, GuestbookTEntry guestbookTEntry, long groupId,
		long guestbookTId, OrderByComparator<GuestbookTEntry> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_GUESTBOOKTENTRY_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_GUESTBOOKTENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_G_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_G_GUESTBOOKTID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_GUESTBOOKTENTRY_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByConditionFields[i],
							true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByConditionFields[i],
							true));
				}

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
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByFields[i], true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByFields[i], true));
				}

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
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(GuestbookTEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(GuestbookTEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), GuestbookTEntry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, GuestbookTEntryImpl.class);
		}
		else {
			sqlQuery.addEntity(_FILTER_ENTITY_TABLE, GuestbookTEntryImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(groupId);

		queryPos.add(guestbookTId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						guestbookTEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<GuestbookTEntry> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the guestbook t entries where groupId = &#63; and guestbookTId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 */
	@Override
	public void removeByG_G(long groupId, long guestbookTId) {
		for (GuestbookTEntry guestbookTEntry :
				findByG_G(
					groupId, guestbookTId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(guestbookTEntry);
		}
	}

	/**
	 * Returns the number of guestbook t entries where groupId = &#63; and guestbookTId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @return the number of matching guestbook t entries
	 */
	@Override
	public int countByG_G(long groupId, long guestbookTId) {
		FinderPath finderPath = _finderPathCountByG_G;

		Object[] finderArgs = new Object[] {groupId, guestbookTId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_GUESTBOOKTENTRY_WHERE);

			sb.append(_FINDER_COLUMN_G_G_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_G_GUESTBOOKTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(guestbookTId);

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

	/**
	 * Returns the number of guestbook t entries that the user has permission to view where groupId = &#63; and guestbookTId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @return the number of matching guestbook t entries that the user has permission to view
	 */
	@Override
	public int filterCountByG_G(long groupId, long guestbookTId) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_G(groupId, guestbookTId);
		}

		StringBundler sb = new StringBundler(3);

		sb.append(_FILTER_SQL_COUNT_GUESTBOOKTENTRY_WHERE);

		sb.append(_FINDER_COLUMN_G_G_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_G_GUESTBOOKTID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), GuestbookTEntry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			sqlQuery.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			queryPos.add(guestbookTId);

			Long count = (Long)sqlQuery.uniqueResult();

			return count.intValue();
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_G_G_GROUPID_2 =
		"guestbookTEntry.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_G_GUESTBOOKTID_2 =
		"guestbookTEntry.guestbookTId = ?";

	private FinderPath _finderPathWithPaginationFindByStatus;
	private FinderPath _finderPathWithoutPaginationFindByStatus;
	private FinderPath _finderPathCountByStatus;

	/**
	 * Returns all the guestbook t entries where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching guestbook t entries
	 */
	@Override
	public List<GuestbookTEntry> findByStatus(int status) {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the guestbook t entries where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTEntryModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of guestbook t entries
	 * @param end the upper bound of the range of guestbook t entries (not inclusive)
	 * @return the range of matching guestbook t entries
	 */
	@Override
	public List<GuestbookTEntry> findByStatus(int status, int start, int end) {
		return findByStatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the guestbook t entries where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTEntryModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of guestbook t entries
	 * @param end the upper bound of the range of guestbook t entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching guestbook t entries
	 */
	@Override
	public List<GuestbookTEntry> findByStatus(
		int status, int start, int end,
		OrderByComparator<GuestbookTEntry> orderByComparator) {

		return findByStatus(status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the guestbook t entries where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTEntryModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of guestbook t entries
	 * @param end the upper bound of the range of guestbook t entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching guestbook t entries
	 */
	@Override
	public List<GuestbookTEntry> findByStatus(
		int status, int start, int end,
		OrderByComparator<GuestbookTEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByStatus;
				finderArgs = new Object[] {status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByStatus;
			finderArgs = new Object[] {status, start, end, orderByComparator};
		}

		List<GuestbookTEntry> list = null;

		if (useFinderCache) {
			list = (List<GuestbookTEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (GuestbookTEntry guestbookTEntry : list) {
					if (status != guestbookTEntry.getStatus()) {
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

			sb.append(_SQL_SELECT_GUESTBOOKTENTRY_WHERE);

			sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(GuestbookTEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

				list = (List<GuestbookTEntry>)QueryUtil.list(
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
	 * Returns the first guestbook t entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching guestbook t entry
	 * @throws NoSuchGuestbookTEntryException if a matching guestbook t entry could not be found
	 */
	@Override
	public GuestbookTEntry findByStatus_First(
			int status, OrderByComparator<GuestbookTEntry> orderByComparator)
		throws NoSuchGuestbookTEntryException {

		GuestbookTEntry guestbookTEntry = fetchByStatus_First(
			status, orderByComparator);

		if (guestbookTEntry != null) {
			return guestbookTEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchGuestbookTEntryException(sb.toString());
	}

	/**
	 * Returns the first guestbook t entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching guestbook t entry, or <code>null</code> if a matching guestbook t entry could not be found
	 */
	@Override
	public GuestbookTEntry fetchByStatus_First(
		int status, OrderByComparator<GuestbookTEntry> orderByComparator) {

		List<GuestbookTEntry> list = findByStatus(
			status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last guestbook t entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching guestbook t entry
	 * @throws NoSuchGuestbookTEntryException if a matching guestbook t entry could not be found
	 */
	@Override
	public GuestbookTEntry findByStatus_Last(
			int status, OrderByComparator<GuestbookTEntry> orderByComparator)
		throws NoSuchGuestbookTEntryException {

		GuestbookTEntry guestbookTEntry = fetchByStatus_Last(
			status, orderByComparator);

		if (guestbookTEntry != null) {
			return guestbookTEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchGuestbookTEntryException(sb.toString());
	}

	/**
	 * Returns the last guestbook t entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching guestbook t entry, or <code>null</code> if a matching guestbook t entry could not be found
	 */
	@Override
	public GuestbookTEntry fetchByStatus_Last(
		int status, OrderByComparator<GuestbookTEntry> orderByComparator) {

		int count = countByStatus(status);

		if (count == 0) {
			return null;
		}

		List<GuestbookTEntry> list = findByStatus(
			status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the guestbook t entries before and after the current guestbook t entry in the ordered set where status = &#63;.
	 *
	 * @param entryId the primary key of the current guestbook t entry
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next guestbook t entry
	 * @throws NoSuchGuestbookTEntryException if a guestbook t entry with the primary key could not be found
	 */
	@Override
	public GuestbookTEntry[] findByStatus_PrevAndNext(
			long entryId, int status,
			OrderByComparator<GuestbookTEntry> orderByComparator)
		throws NoSuchGuestbookTEntryException {

		GuestbookTEntry guestbookTEntry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			GuestbookTEntry[] array = new GuestbookTEntryImpl[3];

			array[0] = getByStatus_PrevAndNext(
				session, guestbookTEntry, status, orderByComparator, true);

			array[1] = guestbookTEntry;

			array[2] = getByStatus_PrevAndNext(
				session, guestbookTEntry, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected GuestbookTEntry getByStatus_PrevAndNext(
		Session session, GuestbookTEntry guestbookTEntry, int status,
		OrderByComparator<GuestbookTEntry> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_GUESTBOOKTENTRY_WHERE);

		sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

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
			sb.append(GuestbookTEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						guestbookTEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<GuestbookTEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the guestbook t entries where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	@Override
	public void removeByStatus(int status) {
		for (GuestbookTEntry guestbookTEntry :
				findByStatus(
					status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(guestbookTEntry);
		}
	}

	/**
	 * Returns the number of guestbook t entries where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching guestbook t entries
	 */
	@Override
	public int countByStatus(int status) {
		FinderPath finderPath = _finderPathCountByStatus;

		Object[] finderArgs = new Object[] {status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_GUESTBOOKTENTRY_WHERE);

			sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

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

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 =
		"guestbookTEntry.status = ?";

	private FinderPath _finderPathWithPaginationFindByG_G_S;
	private FinderPath _finderPathWithoutPaginationFindByG_G_S;
	private FinderPath _finderPathCountByG_G_S;

	/**
	 * Returns all the guestbook t entries where groupId = &#63; and guestbookTId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param status the status
	 * @return the matching guestbook t entries
	 */
	@Override
	public List<GuestbookTEntry> findByG_G_S(
		long groupId, long guestbookTId, int status) {

		return findByG_G_S(
			groupId, guestbookTId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the guestbook t entries where groupId = &#63; and guestbookTId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param status the status
	 * @param start the lower bound of the range of guestbook t entries
	 * @param end the upper bound of the range of guestbook t entries (not inclusive)
	 * @return the range of matching guestbook t entries
	 */
	@Override
	public List<GuestbookTEntry> findByG_G_S(
		long groupId, long guestbookTId, int status, int start, int end) {

		return findByG_G_S(groupId, guestbookTId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the guestbook t entries where groupId = &#63; and guestbookTId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param status the status
	 * @param start the lower bound of the range of guestbook t entries
	 * @param end the upper bound of the range of guestbook t entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching guestbook t entries
	 */
	@Override
	public List<GuestbookTEntry> findByG_G_S(
		long groupId, long guestbookTId, int status, int start, int end,
		OrderByComparator<GuestbookTEntry> orderByComparator) {

		return findByG_G_S(
			groupId, guestbookTId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the guestbook t entries where groupId = &#63; and guestbookTId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param status the status
	 * @param start the lower bound of the range of guestbook t entries
	 * @param end the upper bound of the range of guestbook t entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching guestbook t entries
	 */
	@Override
	public List<GuestbookTEntry> findByG_G_S(
		long groupId, long guestbookTId, int status, int start, int end,
		OrderByComparator<GuestbookTEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_G_S;
				finderArgs = new Object[] {groupId, guestbookTId, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_G_S;
			finderArgs = new Object[] {
				groupId, guestbookTId, status, start, end, orderByComparator
			};
		}

		List<GuestbookTEntry> list = null;

		if (useFinderCache) {
			list = (List<GuestbookTEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (GuestbookTEntry guestbookTEntry : list) {
					if ((groupId != guestbookTEntry.getGroupId()) ||
						(guestbookTId != guestbookTEntry.getGuestbookTId()) ||
						(status != guestbookTEntry.getStatus())) {

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
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_GUESTBOOKTENTRY_WHERE);

			sb.append(_FINDER_COLUMN_G_G_S_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_G_S_GUESTBOOKTID_2);

			sb.append(_FINDER_COLUMN_G_G_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(GuestbookTEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(guestbookTId);

				queryPos.add(status);

				list = (List<GuestbookTEntry>)QueryUtil.list(
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
	 * Returns the first guestbook t entry in the ordered set where groupId = &#63; and guestbookTId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching guestbook t entry
	 * @throws NoSuchGuestbookTEntryException if a matching guestbook t entry could not be found
	 */
	@Override
	public GuestbookTEntry findByG_G_S_First(
			long groupId, long guestbookTId, int status,
			OrderByComparator<GuestbookTEntry> orderByComparator)
		throws NoSuchGuestbookTEntryException {

		GuestbookTEntry guestbookTEntry = fetchByG_G_S_First(
			groupId, guestbookTId, status, orderByComparator);

		if (guestbookTEntry != null) {
			return guestbookTEntry;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", guestbookTId=");
		sb.append(guestbookTId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchGuestbookTEntryException(sb.toString());
	}

	/**
	 * Returns the first guestbook t entry in the ordered set where groupId = &#63; and guestbookTId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching guestbook t entry, or <code>null</code> if a matching guestbook t entry could not be found
	 */
	@Override
	public GuestbookTEntry fetchByG_G_S_First(
		long groupId, long guestbookTId, int status,
		OrderByComparator<GuestbookTEntry> orderByComparator) {

		List<GuestbookTEntry> list = findByG_G_S(
			groupId, guestbookTId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last guestbook t entry in the ordered set where groupId = &#63; and guestbookTId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching guestbook t entry
	 * @throws NoSuchGuestbookTEntryException if a matching guestbook t entry could not be found
	 */
	@Override
	public GuestbookTEntry findByG_G_S_Last(
			long groupId, long guestbookTId, int status,
			OrderByComparator<GuestbookTEntry> orderByComparator)
		throws NoSuchGuestbookTEntryException {

		GuestbookTEntry guestbookTEntry = fetchByG_G_S_Last(
			groupId, guestbookTId, status, orderByComparator);

		if (guestbookTEntry != null) {
			return guestbookTEntry;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", guestbookTId=");
		sb.append(guestbookTId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchGuestbookTEntryException(sb.toString());
	}

	/**
	 * Returns the last guestbook t entry in the ordered set where groupId = &#63; and guestbookTId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching guestbook t entry, or <code>null</code> if a matching guestbook t entry could not be found
	 */
	@Override
	public GuestbookTEntry fetchByG_G_S_Last(
		long groupId, long guestbookTId, int status,
		OrderByComparator<GuestbookTEntry> orderByComparator) {

		int count = countByG_G_S(groupId, guestbookTId, status);

		if (count == 0) {
			return null;
		}

		List<GuestbookTEntry> list = findByG_G_S(
			groupId, guestbookTId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the guestbook t entries before and after the current guestbook t entry in the ordered set where groupId = &#63; and guestbookTId = &#63; and status = &#63;.
	 *
	 * @param entryId the primary key of the current guestbook t entry
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next guestbook t entry
	 * @throws NoSuchGuestbookTEntryException if a guestbook t entry with the primary key could not be found
	 */
	@Override
	public GuestbookTEntry[] findByG_G_S_PrevAndNext(
			long entryId, long groupId, long guestbookTId, int status,
			OrderByComparator<GuestbookTEntry> orderByComparator)
		throws NoSuchGuestbookTEntryException {

		GuestbookTEntry guestbookTEntry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			GuestbookTEntry[] array = new GuestbookTEntryImpl[3];

			array[0] = getByG_G_S_PrevAndNext(
				session, guestbookTEntry, groupId, guestbookTId, status,
				orderByComparator, true);

			array[1] = guestbookTEntry;

			array[2] = getByG_G_S_PrevAndNext(
				session, guestbookTEntry, groupId, guestbookTId, status,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected GuestbookTEntry getByG_G_S_PrevAndNext(
		Session session, GuestbookTEntry guestbookTEntry, long groupId,
		long guestbookTId, int status,
		OrderByComparator<GuestbookTEntry> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_GUESTBOOKTENTRY_WHERE);

		sb.append(_FINDER_COLUMN_G_G_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_G_S_GUESTBOOKTID_2);

		sb.append(_FINDER_COLUMN_G_G_S_STATUS_2);

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
			sb.append(GuestbookTEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(guestbookTId);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						guestbookTEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<GuestbookTEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the guestbook t entries that the user has permission to view where groupId = &#63; and guestbookTId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param status the status
	 * @return the matching guestbook t entries that the user has permission to view
	 */
	@Override
	public List<GuestbookTEntry> filterFindByG_G_S(
		long groupId, long guestbookTId, int status) {

		return filterFindByG_G_S(
			groupId, guestbookTId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the guestbook t entries that the user has permission to view where groupId = &#63; and guestbookTId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param status the status
	 * @param start the lower bound of the range of guestbook t entries
	 * @param end the upper bound of the range of guestbook t entries (not inclusive)
	 * @return the range of matching guestbook t entries that the user has permission to view
	 */
	@Override
	public List<GuestbookTEntry> filterFindByG_G_S(
		long groupId, long guestbookTId, int status, int start, int end) {

		return filterFindByG_G_S(
			groupId, guestbookTId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the guestbook t entries that the user has permissions to view where groupId = &#63; and guestbookTId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param status the status
	 * @param start the lower bound of the range of guestbook t entries
	 * @param end the upper bound of the range of guestbook t entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching guestbook t entries that the user has permission to view
	 */
	@Override
	public List<GuestbookTEntry> filterFindByG_G_S(
		long groupId, long guestbookTId, int status, int start, int end,
		OrderByComparator<GuestbookTEntry> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_G_S(
				groupId, guestbookTId, status, start, end, orderByComparator);
		}

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByFields().length * 2));
		}
		else {
			sb = new StringBundler(6);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_GUESTBOOKTENTRY_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_GUESTBOOKTENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_G_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_G_S_GUESTBOOKTID_2);

		sb.append(_FINDER_COLUMN_G_G_S_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_GUESTBOOKTENTRY_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator, true);
			}
			else {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_TABLE, orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(GuestbookTEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(GuestbookTEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), GuestbookTEntry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(
					_FILTER_ENTITY_ALIAS, GuestbookTEntryImpl.class);
			}
			else {
				sqlQuery.addEntity(
					_FILTER_ENTITY_TABLE, GuestbookTEntryImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			queryPos.add(guestbookTId);

			queryPos.add(status);

			return (List<GuestbookTEntry>)QueryUtil.list(
				sqlQuery, getDialect(), start, end);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the guestbook t entries before and after the current guestbook t entry in the ordered set of guestbook t entries that the user has permission to view where groupId = &#63; and guestbookTId = &#63; and status = &#63;.
	 *
	 * @param entryId the primary key of the current guestbook t entry
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next guestbook t entry
	 * @throws NoSuchGuestbookTEntryException if a guestbook t entry with the primary key could not be found
	 */
	@Override
	public GuestbookTEntry[] filterFindByG_G_S_PrevAndNext(
			long entryId, long groupId, long guestbookTId, int status,
			OrderByComparator<GuestbookTEntry> orderByComparator)
		throws NoSuchGuestbookTEntryException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_G_S_PrevAndNext(
				entryId, groupId, guestbookTId, status, orderByComparator);
		}

		GuestbookTEntry guestbookTEntry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			GuestbookTEntry[] array = new GuestbookTEntryImpl[3];

			array[0] = filterGetByG_G_S_PrevAndNext(
				session, guestbookTEntry, groupId, guestbookTId, status,
				orderByComparator, true);

			array[1] = guestbookTEntry;

			array[2] = filterGetByG_G_S_PrevAndNext(
				session, guestbookTEntry, groupId, guestbookTId, status,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected GuestbookTEntry filterGetByG_G_S_PrevAndNext(
		Session session, GuestbookTEntry guestbookTEntry, long groupId,
		long guestbookTId, int status,
		OrderByComparator<GuestbookTEntry> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				7 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(6);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_GUESTBOOKTENTRY_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_GUESTBOOKTENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_G_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_G_S_GUESTBOOKTID_2);

		sb.append(_FINDER_COLUMN_G_G_S_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_GUESTBOOKTENTRY_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByConditionFields[i],
							true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByConditionFields[i],
							true));
				}

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
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByFields[i], true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByFields[i], true));
				}

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
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(GuestbookTEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(GuestbookTEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), GuestbookTEntry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, GuestbookTEntryImpl.class);
		}
		else {
			sqlQuery.addEntity(_FILTER_ENTITY_TABLE, GuestbookTEntryImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(groupId);

		queryPos.add(guestbookTId);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						guestbookTEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<GuestbookTEntry> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the guestbook t entries where groupId = &#63; and guestbookTId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param status the status
	 */
	@Override
	public void removeByG_G_S(long groupId, long guestbookTId, int status) {
		for (GuestbookTEntry guestbookTEntry :
				findByG_G_S(
					groupId, guestbookTId, status, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(guestbookTEntry);
		}
	}

	/**
	 * Returns the number of guestbook t entries where groupId = &#63; and guestbookTId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param status the status
	 * @return the number of matching guestbook t entries
	 */
	@Override
	public int countByG_G_S(long groupId, long guestbookTId, int status) {
		FinderPath finderPath = _finderPathCountByG_G_S;

		Object[] finderArgs = new Object[] {groupId, guestbookTId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_GUESTBOOKTENTRY_WHERE);

			sb.append(_FINDER_COLUMN_G_G_S_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_G_S_GUESTBOOKTID_2);

			sb.append(_FINDER_COLUMN_G_G_S_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(guestbookTId);

				queryPos.add(status);

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

	/**
	 * Returns the number of guestbook t entries that the user has permission to view where groupId = &#63; and guestbookTId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param guestbookTId the guestbook t ID
	 * @param status the status
	 * @return the number of matching guestbook t entries that the user has permission to view
	 */
	@Override
	public int filterCountByG_G_S(long groupId, long guestbookTId, int status) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_G_S(groupId, guestbookTId, status);
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_FILTER_SQL_COUNT_GUESTBOOKTENTRY_WHERE);

		sb.append(_FINDER_COLUMN_G_G_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_G_S_GUESTBOOKTID_2);

		sb.append(_FINDER_COLUMN_G_G_S_STATUS_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), GuestbookTEntry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			sqlQuery.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			queryPos.add(guestbookTId);

			queryPos.add(status);

			Long count = (Long)sqlQuery.uniqueResult();

			return count.intValue();
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_G_G_S_GROUPID_2 =
		"guestbookTEntry.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_G_S_GUESTBOOKTID_2 =
		"guestbookTEntry.guestbookTId = ? AND ";

	private static final String _FINDER_COLUMN_G_G_S_STATUS_2 =
		"guestbookTEntry.status = ?";

	public GuestbookTEntryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(GuestbookTEntry.class);

		setModelImplClass(GuestbookTEntryImpl.class);
		setModelPKClass(long.class);

		setTable(GuestbookTEntryTable.INSTANCE);
	}

	/**
	 * Caches the guestbook t entry in the entity cache if it is enabled.
	 *
	 * @param guestbookTEntry the guestbook t entry
	 */
	@Override
	public void cacheResult(GuestbookTEntry guestbookTEntry) {
		entityCache.putResult(
			GuestbookTEntryImpl.class, guestbookTEntry.getPrimaryKey(),
			guestbookTEntry);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				guestbookTEntry.getUuid(), guestbookTEntry.getGroupId()
			},
			guestbookTEntry);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the guestbook t entries in the entity cache if it is enabled.
	 *
	 * @param guestbookTEntries the guestbook t entries
	 */
	@Override
	public void cacheResult(List<GuestbookTEntry> guestbookTEntries) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (guestbookTEntries.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (GuestbookTEntry guestbookTEntry : guestbookTEntries) {
			if (entityCache.getResult(
					GuestbookTEntryImpl.class,
					guestbookTEntry.getPrimaryKey()) == null) {

				cacheResult(guestbookTEntry);
			}
		}
	}

	/**
	 * Clears the cache for all guestbook t entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(GuestbookTEntryImpl.class);

		finderCache.clearCache(GuestbookTEntryImpl.class);
	}

	/**
	 * Clears the cache for the guestbook t entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GuestbookTEntry guestbookTEntry) {
		entityCache.removeResult(GuestbookTEntryImpl.class, guestbookTEntry);
	}

	@Override
	public void clearCache(List<GuestbookTEntry> guestbookTEntries) {
		for (GuestbookTEntry guestbookTEntry : guestbookTEntries) {
			entityCache.removeResult(
				GuestbookTEntryImpl.class, guestbookTEntry);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(GuestbookTEntryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(GuestbookTEntryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		GuestbookTEntryModelImpl guestbookTEntryModelImpl) {

		Object[] args = new Object[] {
			guestbookTEntryModelImpl.getUuid(),
			guestbookTEntryModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, guestbookTEntryModelImpl);
	}

	/**
	 * Creates a new guestbook t entry with the primary key. Does not add the guestbook t entry to the database.
	 *
	 * @param entryId the primary key for the new guestbook t entry
	 * @return the new guestbook t entry
	 */
	@Override
	public GuestbookTEntry create(long entryId) {
		GuestbookTEntry guestbookTEntry = new GuestbookTEntryImpl();

		guestbookTEntry.setNew(true);
		guestbookTEntry.setPrimaryKey(entryId);

		String uuid = PortalUUIDUtil.generate();

		guestbookTEntry.setUuid(uuid);

		guestbookTEntry.setCompanyId(CompanyThreadLocal.getCompanyId());

		return guestbookTEntry;
	}

	/**
	 * Removes the guestbook t entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entryId the primary key of the guestbook t entry
	 * @return the guestbook t entry that was removed
	 * @throws NoSuchGuestbookTEntryException if a guestbook t entry with the primary key could not be found
	 */
	@Override
	public GuestbookTEntry remove(long entryId)
		throws NoSuchGuestbookTEntryException {

		return remove((Serializable)entryId);
	}

	/**
	 * Removes the guestbook t entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the guestbook t entry
	 * @return the guestbook t entry that was removed
	 * @throws NoSuchGuestbookTEntryException if a guestbook t entry with the primary key could not be found
	 */
	@Override
	public GuestbookTEntry remove(Serializable primaryKey)
		throws NoSuchGuestbookTEntryException {

		Session session = null;

		try {
			session = openSession();

			GuestbookTEntry guestbookTEntry = (GuestbookTEntry)session.get(
				GuestbookTEntryImpl.class, primaryKey);

			if (guestbookTEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGuestbookTEntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(guestbookTEntry);
		}
		catch (NoSuchGuestbookTEntryException noSuchEntityException) {
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
	protected GuestbookTEntry removeImpl(GuestbookTEntry guestbookTEntry) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(guestbookTEntry)) {
				guestbookTEntry = (GuestbookTEntry)session.get(
					GuestbookTEntryImpl.class,
					guestbookTEntry.getPrimaryKeyObj());
			}

			if (guestbookTEntry != null) {
				session.delete(guestbookTEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (guestbookTEntry != null) {
			clearCache(guestbookTEntry);
		}

		return guestbookTEntry;
	}

	@Override
	public GuestbookTEntry updateImpl(GuestbookTEntry guestbookTEntry) {
		boolean isNew = guestbookTEntry.isNew();

		if (!(guestbookTEntry instanceof GuestbookTEntryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(guestbookTEntry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					guestbookTEntry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in guestbookTEntry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom GuestbookTEntry implementation " +
					guestbookTEntry.getClass());
		}

		GuestbookTEntryModelImpl guestbookTEntryModelImpl =
			(GuestbookTEntryModelImpl)guestbookTEntry;

		if (Validator.isNull(guestbookTEntry.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			guestbookTEntry.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (guestbookTEntry.getCreateDate() == null)) {
			if (serviceContext == null) {
				guestbookTEntry.setCreateDate(date);
			}
			else {
				guestbookTEntry.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!guestbookTEntryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				guestbookTEntry.setModifiedDate(date);
			}
			else {
				guestbookTEntry.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(guestbookTEntry);
			}
			else {
				guestbookTEntry = (GuestbookTEntry)session.merge(
					guestbookTEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			GuestbookTEntryImpl.class, guestbookTEntryModelImpl, false, true);

		cacheUniqueFindersCache(guestbookTEntryModelImpl);

		if (isNew) {
			guestbookTEntry.setNew(false);
		}

		guestbookTEntry.resetOriginalValues();

		return guestbookTEntry;
	}

	/**
	 * Returns the guestbook t entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the guestbook t entry
	 * @return the guestbook t entry
	 * @throws NoSuchGuestbookTEntryException if a guestbook t entry with the primary key could not be found
	 */
	@Override
	public GuestbookTEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGuestbookTEntryException {

		GuestbookTEntry guestbookTEntry = fetchByPrimaryKey(primaryKey);

		if (guestbookTEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGuestbookTEntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return guestbookTEntry;
	}

	/**
	 * Returns the guestbook t entry with the primary key or throws a <code>NoSuchGuestbookTEntryException</code> if it could not be found.
	 *
	 * @param entryId the primary key of the guestbook t entry
	 * @return the guestbook t entry
	 * @throws NoSuchGuestbookTEntryException if a guestbook t entry with the primary key could not be found
	 */
	@Override
	public GuestbookTEntry findByPrimaryKey(long entryId)
		throws NoSuchGuestbookTEntryException {

		return findByPrimaryKey((Serializable)entryId);
	}

	/**
	 * Returns the guestbook t entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param entryId the primary key of the guestbook t entry
	 * @return the guestbook t entry, or <code>null</code> if a guestbook t entry with the primary key could not be found
	 */
	@Override
	public GuestbookTEntry fetchByPrimaryKey(long entryId) {
		return fetchByPrimaryKey((Serializable)entryId);
	}

	/**
	 * Returns all the guestbook t entries.
	 *
	 * @return the guestbook t entries
	 */
	@Override
	public List<GuestbookTEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the guestbook t entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of guestbook t entries
	 * @param end the upper bound of the range of guestbook t entries (not inclusive)
	 * @return the range of guestbook t entries
	 */
	@Override
	public List<GuestbookTEntry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the guestbook t entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of guestbook t entries
	 * @param end the upper bound of the range of guestbook t entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of guestbook t entries
	 */
	@Override
	public List<GuestbookTEntry> findAll(
		int start, int end,
		OrderByComparator<GuestbookTEntry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the guestbook t entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GuestbookTEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of guestbook t entries
	 * @param end the upper bound of the range of guestbook t entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of guestbook t entries
	 */
	@Override
	public List<GuestbookTEntry> findAll(
		int start, int end,
		OrderByComparator<GuestbookTEntry> orderByComparator,
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

		List<GuestbookTEntry> list = null;

		if (useFinderCache) {
			list = (List<GuestbookTEntry>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_GUESTBOOKTENTRY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_GUESTBOOKTENTRY;

				sql = sql.concat(GuestbookTEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<GuestbookTEntry>)QueryUtil.list(
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
	 * Removes all the guestbook t entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (GuestbookTEntry guestbookTEntry : findAll()) {
			remove(guestbookTEntry);
		}
	}

	/**
	 * Returns the number of guestbook t entries.
	 *
	 * @return the number of guestbook t entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_GUESTBOOKTENTRY);

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
		return "entryId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_GUESTBOOKTENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return GuestbookTEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the guestbook t entry persistence.
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

		_finderPathWithPaginationFindByG_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_G",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"groupId", "guestbookTId"}, true);

		_finderPathWithoutPaginationFindByG_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_G",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"groupId", "guestbookTId"}, true);

		_finderPathCountByG_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_G",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"groupId", "guestbookTId"}, false);

		_finderPathWithPaginationFindByStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"status"}, true);

		_finderPathWithoutPaginationFindByStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] {Integer.class.getName()}, new String[] {"status"},
			true);

		_finderPathCountByStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] {Integer.class.getName()}, new String[] {"status"},
			false);

		_finderPathWithPaginationFindByG_G_S = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_G_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"groupId", "guestbookTId", "status"}, true);

		_finderPathWithoutPaginationFindByG_G_S = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_G_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			new String[] {"groupId", "guestbookTId", "status"}, true);

		_finderPathCountByG_G_S = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_G_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			new String[] {"groupId", "guestbookTId", "status"}, false);

		_setGuestbookTEntryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setGuestbookTEntryUtilPersistence(null);

		entityCache.removeCache(GuestbookTEntryImpl.class.getName());
	}

	private void _setGuestbookTEntryUtilPersistence(
		GuestbookTEntryPersistence guestbookTEntryPersistence) {

		try {
			Field field = GuestbookTEntryUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, guestbookTEntryPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = GBTPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = GBTPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = GBTPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_GUESTBOOKTENTRY =
		"SELECT guestbookTEntry FROM GuestbookTEntry guestbookTEntry";

	private static final String _SQL_SELECT_GUESTBOOKTENTRY_WHERE =
		"SELECT guestbookTEntry FROM GuestbookTEntry guestbookTEntry WHERE ";

	private static final String _SQL_COUNT_GUESTBOOKTENTRY =
		"SELECT COUNT(guestbookTEntry) FROM GuestbookTEntry guestbookTEntry";

	private static final String _SQL_COUNT_GUESTBOOKTENTRY_WHERE =
		"SELECT COUNT(guestbookTEntry) FROM GuestbookTEntry guestbookTEntry WHERE ";

	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN =
		"guestbookTEntry.entryId";

	private static final String _FILTER_SQL_SELECT_GUESTBOOKTENTRY_WHERE =
		"SELECT DISTINCT {guestbookTEntry.*} FROM GBT_GuestbookTEntry guestbookTEntry WHERE ";

	private static final String
		_FILTER_SQL_SELECT_GUESTBOOKTENTRY_NO_INLINE_DISTINCT_WHERE_1 =
			"SELECT {GBT_GuestbookTEntry.*} FROM (SELECT DISTINCT guestbookTEntry.entryId FROM GBT_GuestbookTEntry guestbookTEntry WHERE ";

	private static final String
		_FILTER_SQL_SELECT_GUESTBOOKTENTRY_NO_INLINE_DISTINCT_WHERE_2 =
			") TEMP_TABLE INNER JOIN GBT_GuestbookTEntry ON TEMP_TABLE.entryId = GBT_GuestbookTEntry.entryId";

	private static final String _FILTER_SQL_COUNT_GUESTBOOKTENTRY_WHERE =
		"SELECT COUNT(DISTINCT guestbookTEntry.entryId) AS COUNT_VALUE FROM GBT_GuestbookTEntry guestbookTEntry WHERE ";

	private static final String _FILTER_ENTITY_ALIAS = "guestbookTEntry";

	private static final String _FILTER_ENTITY_TABLE = "GBT_GuestbookTEntry";

	private static final String _ORDER_BY_ENTITY_ALIAS = "guestbookTEntry.";

	private static final String _ORDER_BY_ENTITY_TABLE = "GBT_GuestbookTEntry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No GuestbookTEntry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No GuestbookTEntry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		GuestbookTEntryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private GuestbookTEntryModelArgumentsResolver
		_guestbookTEntryModelArgumentsResolver;

}