<%@include file="../init.jsp" %>

<liferay-ui:success key="guestbookAdded" message="guestbookt-added" />
<liferay-ui:success key="guestbookUpdated" message="guestbookt-updated" />
<liferay-ui:success key="guestbookDeleted" message="guestbookt-deleted" />

<liferay-ui:search-container
	total ="<%=GuestbookTLocalServiceUtil.getGuestbooksCount(scopeGroupId) %>">
	<liferay-ui:search-container-results
		results="<%=GuestbookTLocalServiceUtil.getGuestbooks(scopeGroupId, searchContainer.getStart(), searchContainer.getEnd()) %>" />
	
	<liferay-ui:search-container-row 
		className="com.tutorial.guestbookt.model.GuestbookT" modelVar="guestbookt">
		
		<liferay-ui:search-container-column-text property="name" />
		
		<liferay-ui:search-container-column-jsp 
			align="right" 
			path="/guestbookt_admin/guestbookt_actions.jsp"/>
	
	</liferay-ui:search-container-row>
	
	<liferay-ui:search-iterator />
</liferay-ui:search-container>

<aui:button-row cssClass="guestbookt-admin-buttons">
	<portlet:renderURL var="addGuestbookTURL">
		<portlet:param name="mvcPath" 
			value="/guestbookt_admin/edit_guestbookt.jsp"/>
		<portlet:param name="redirect" value="<%="currentURL"%>" />
	</portlet:renderURL>
	
	<aui:button onClick="<%=addGuestbookTURL.toString() %>"
		value="Add GuestbookT" />
</aui:button-row>