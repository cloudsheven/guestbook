<%@page import="java.util.Currency"%>

<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@ page import="com.liferay.portal.kernel.security.permission.ActionKeys" %>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>

<%@ page import="com.tutorial.guestbookt.web.internal.security.permission.resource.GuestbookTModelPermission" %>
<%@ page import="com.tutorial.guestbookt.web.internal.security.permission.resource.GuestbookTPermission" %>
<%@ page import="com.tutorial.guestbookt.web.internal.security.permission.resource.GuestbookTEntryPermission" %>

<%@include file="../init.jsp"%>

<liferay-ui:success key="entryAdded" message="entry-added" />
<liferay-ui:success key="entryDeleted" message="entry-deleted" />

<%
long guestbookTId = Long.valueOf((Long) renderRequest.getAttribute("guestbookTId"));
long companyId = themeDisplay.getCompanyId();
long groupId = themeDisplay.getScopeGroupId();
GuestbookT guestbookT = GuestbookTLocalServiceUtil.getGuestbookT(guestbookTId);
String guestbookUUID = guestbookT.getUuid();
%>
<aui:nav cssClass="nav-tabs">

    <%
        List<GuestbookT> guestbooks = GuestbookTLocalServiceUtil.getGuestbooks(scopeGroupId);

            for (int i = 0; i < guestbooks.size(); i++) {

                GuestbookT curGuestbook = guestbooks.get(i);
                String cssClass = StringPool.BLANK;

                if (curGuestbook.getGuestbookTId() == guestbookTId) {
                    cssClass = "active";
                }

                if (GuestbookTModelPermission.contains(
                    permissionChecker, curGuestbook.getGuestbookTId(), "VIEW")) {

    %>

    <portlet:renderURL var="viewPageURL">
        <portlet:param name="mvcPath" value="/guestbookt/view.jsp" />
        <portlet:param name="guestbookTId"
            value="<%=String.valueOf(curGuestbook.getGuestbookTId())%>" />
    </portlet:renderURL>


    <aui:nav-item cssClass="<%=cssClass%>" href="<%=viewPageURL%>"
        label="<%=HtmlUtil.escape(curGuestbook.getName())%>" />

    <%  
                }

            }
    %>

</aui:nav>

<aui:button-row cssClass="guestbookt-buttons">

	<c:if test='<%= GuestbookTPermission.contains(permissionChecker, scopeGroupId, "ADD_ENTRY") %>'>
    	<portlet:renderURL var="addEntryURL">
        	<portlet:param name="mvcPath" value="/guestbookt/edit_entry.jsp" />
        	<portlet:param name="guestbookTId"
        	    value="<%=String.valueOf(guestbookTId)%>" />
    	</portlet:renderURL>
    	<aui:button onClick="<%=addEntryURL.toString()%>" value="Add Entry"></aui:button>
	</c:if>
</aui:button-row>

<liferay-ui:search-container total="<%=GuestbookTEntryLocalServiceUtil.getGuestbookTEntriesCount()%>">
	<liferay-ui:search-container-results results="<%=GuestbookTEntryLocalServiceUtil.getGuestbookTEntries(groupId, guestbookTId)%>"
    	 />
	<liferay-ui:search-container-row
    	className="com.tutorial.guestbookt.model.GuestbookTEntry" modelVar="entry">

    <liferay-ui:search-container-column-text property="message" />

    <liferay-ui:search-container-column-text property="name" />

    <liferay-ui:search-container-column-jsp
        align="right" 
        path="/guestbookt/entry_actions.jsp" />

</liferay-ui:search-container-row>

<liferay-ui:search-iterator />

</liferay-ui:search-container>