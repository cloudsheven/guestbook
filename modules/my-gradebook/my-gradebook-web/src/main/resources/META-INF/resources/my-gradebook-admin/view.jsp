<%@ include file="../init.jsp" %>

<liferay-ui:success key="myGradebookAdded" message="my-gradebook-added" />
<liferay-ui:success key="myGradebookUpdated" message="my-gradebook-updated" />
<liferay-ui:success key="myGradebookDeleted" message="my-gradebook-deleted" />

<liferay-ui:search-container
	total ="<%=MyGradebookLocalServiceUtil.getMyGradebooksCount(scopeGroupId)%>">
	
	<liferay-ui:search-container-results 
	results="<%=MyGradebookLocalServiceUtil.getMyGradebooks(scopeGroupId, searchContainer.getStart(), searchContainer.getEnd()) %>" />
	
	<liferay-ui:search-container-row
	className="com.tutorial.liferay.my.gradebook.model.MyGradebook" modelVar="myGradebook">
	
		<liferay-ui:search-container-column-text property="name"/>		
		
		<liferay-ui:search-container-column-status property="status" />
		
		<liferay-ui:search-container-column-jsp 
		align="right"
		path="/my-gradebook-admin/my_gradebook_actions.jsp" />
	
	</liferay-ui:search-container-row>	
	<liferay-ui:search-iterator />
</liferay-ui:search-container>

<aui:button-row cssClass="my-gradebook-admin-buttons">
	
	<portlet:renderURL var="addMyGradebookURL">
		
		<portlet:param name="mvcPath"
		value="/my-gradebook-admin/edit_my_gradebook.jsp"/>
		
		<portlet:param name="redirect" value="<%="currentURL"%>" />
	</portlet:renderURL>
	
	<aui:button onClick="<%=addMyGradebookURL.toString() %>"
	value="Add MyGradebook" />
</aui:button-row>
	
	
