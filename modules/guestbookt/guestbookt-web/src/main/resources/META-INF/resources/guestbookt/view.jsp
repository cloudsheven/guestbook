<%@page import="com.liferay.asset.kernel.model.AssetRendererFactory"%>
<%@page import="com.liferay.asset.kernel.model.AssetRenderer"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>

<%@include file="../init.jsp"%>

<liferay-ui:success key="entryAdded" message="entry-added" />
<liferay-ui:success key="entryDeleted" message="entry-deleted" />

<%
long guestbookTId = Long.valueOf((Long) renderRequest.getAttribute("guestbookTId"));
%>

<portlet:renderURL var="searchURL">
    <portlet:param name="mvcPath" 
    value="/guestbookt/view_search.jsp" />
</portlet:renderURL>

<aui:form action="<%=searchURL.toString() %>" name="fm">

    <div class="row">
        <div class="col-md-8">
            <aui:input inlineLabel="left" label="" name="keywords" placeholder="search-entries" size="256" />
        </div>

        <div class="col-md-4">
            <aui:button type="submit" value="search" />
        </div>
    </div>

 </aui:form>

<aui:nav cssClass="nav-tabs">

    <%
        List<GuestbookT> guestbooks = GuestbookTLocalServiceUtil.getGuestbooks(
        		scopeGroupId, WorkflowConstants.STATUS_APPROVED);

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

<liferay-ui:search-container total="<%=GuestbookTEntryLocalServiceUtil.getGuestbookEntriesCount(
		scopeGroupId.longValue(), guestbookTId, WorkflowConstants.STATUS_APPROVED)%>">
	<liferay-ui:search-container-results results="<%=GuestbookTEntryLocalServiceUtil.getGuestbookTEntries(
			scopeGroupId.longValue(), guestbookTId, WorkflowConstants.STATUS_APPROVED, 
            searchContainer.getStart(), searchContainer.getEnd())%>"
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