<%@include file="../init.jsp" %>

<% 
	String mvcPath = ParamUtil.getString(request, "mvcPatch");

	ResultRow row = (ResultRow) request.getAttribute("SEARCH_CONTAINER_RESULT_ROW");
	
	GuestbookT guestbookt = (GuestbookT) row.getObject();
%>

<liferay-ui:icon-menu>
	
	<portlet:renderURL var="editURL">
		<portlet:param name="guestbookTId" 
			value="<%=String.valueOf(guestbookt.getGuestbookTId()) %>"/>
			<portlet:param name="mvcPath" 
				value="/guestbookt_admin/edit_guestbookt.jsp"/>	
	</portlet:renderURL>
	
	<liferay-ui:icon image="edit" message="Edit" url="<%=editURL.toString() %>" />
	
	<portlet:actionURL name="deleteGuestbookT" var="deleteURL">
		<portlet:param name="guestbookTId" 
			value="<%=String.valueOf(guestbookt.getGuestbookTId()) %>"/>
	</portlet:actionURL>
	
	<liferay-ui:icon-delete url="<%=deleteURL.toString()%>" />
	
	<c:if
		test="<%=GuestbookTModelPermission.contains(permissionChecker, guestbookt.getGuestbookTId(), ActionKeys.PERMISSIONS) %>">

    <liferay-security:permissionsURL
        modelResource="<%= GuestbookT.class.getName() %>"
        modelResourceDescription="<%= guestbookt.getName() %>"
        resourcePrimKey="<%= String.valueOf(guestbookt.getGuestbookTId()) %>"
        var="permissionsURL" />

    <liferay-ui:icon image="permissions" url="<%= permissionsURL %>" />

</c:if>

</liferay-ui:icon-menu>