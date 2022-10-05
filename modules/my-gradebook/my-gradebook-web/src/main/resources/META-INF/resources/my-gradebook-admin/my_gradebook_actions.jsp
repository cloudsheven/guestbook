<%@include file="../init.jsp" %>

<%  
	String mvcPath = ParamUtil.getString(request, "mvcPath");
	
	ResultRow row = (ResultRow) request.getAttribute("SEARCH_CONTAINER_RESULT_ROW");
	
	MyGradebook myGradebook = (MyGradebook) row.getObject();

%>

<liferay-ui:icon-menu>

	<portlet:renderURL var="editUrl">
	
		<portlet:param name="myGradebookId" 
		value="<%=String.valueOf(myGradebook.getMyGradebookId())%>" />
		
		<portlet:param name="mvcPath" 
		value="/my-gradebook-admin/edit_my_gradebook.jsp" />	
	</portlet:renderURL>
	
	<liferay-ui:icon image="edit" message="Edit" url="<%=editUrl.toString() %>"/>
	
		<portlet:actionURL name="deleteMyGradebook" var="deleteURL">
		<portlet:param name="myGradebookId" 
			value="<%=String.valueOf(myGradebook.getMyGradebookId()) %>"/>
	</portlet:actionURL>	
	
	<liferay-ui:icon-delete url="<%=deleteURL.toString()%>" />
	
	<c:if
		test="<%=MyGradebookModelPermission.contains(permissionChecker, myGradebook.getMyGradebookId(), ActionKeys.PERMISSIONS) %>">
		
		<liferay-security:permissionsURL
		modelResource="<%= MyGradebook.class.getName() %>"
		modelResourceDescription="<%= myGradebook.getName() %>"
		resourcePrimKey="<%= String.valueOf(myGradebook.getMyGradebookId()) %>"
		var="permissionsURL" />
		
		<liferay-ui:icon image="permissions" url="<%= permissionsURL %>" />	
	</c:if>

</liferay-ui:icon-menu>

</liferay-ui:icon-menu>