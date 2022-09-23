<%@ page import="java.util.List" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>

<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchEntry" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.portal.kernel.model.PersistedModel" %>
<%@ page import="com.liferay.portal.kernel.security.permission.ActionKeys" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>

<%@ page import="com.liferay.petra.string.StringPool" %>

<%@ page import="com.tutorial.guestbookt.model.GuestbookT" %>
<%@ page import="com.tutorial.guestbookt.model.GuestbookTEntry" %>
<%@ page import="com.tutorial.guestbookt.service.GuestbookTLocalServiceUtil" %> 
<%@ page import="com.tutorial.guestbookt.service.GuestbookTEntryLocalServiceUtil" %>
<%@ page import="com.tutorial.guestbookt.web.internal.security.permission.resource.GuestbookTEntryPermission" %>
<%@ page import="com.tutorial.guestbookt.web.internal.security.permission.resource.GuestbookTModelPermission" %>
<%@ page import="com.tutorial.guestbookt.web.internal.security.permission.resource.GuestbookTPermission" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />