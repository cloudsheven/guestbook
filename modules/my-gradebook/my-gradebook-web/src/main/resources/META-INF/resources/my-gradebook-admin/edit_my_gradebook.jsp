<%@ include file="../init.jsp" %>

<%
	long myGradebookId = ParamUtil.getLong(request, "myGradebookId");
	
	MyGradebook myGradebook = null;
	
	if (myGradebookId > 0) {
		myGradebook = MyGradebookLocalServiceUtil.getMyGradebook(myGradebookId);
	}
%>

<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="/my_gradebook_admin/view.jsp"/>
</portlet:renderURL>

<portlet:actionURL name='<%= myGradebook == null ? "addMyGradebook" : "updateMyGradebook" %>' var="editMyGradebookURL" />

<aui:form action="<%=editMyGradebookURL%>" name="fm">
	
	<aui:model-context bean="<%=myGradebook%>" model="<%=MyGradebook.class %>" />
	
	<aui:input type="hidden" name="myGradebookId"
		value="<%=myGradebook == null ? "" : myGradebook.getMyGradebookId() %>" />
		
	<aui:fieldset>
		<aui:input name="name" />
	</aui:fieldset>
	
	<aui:button-row>
		<aui:button type="submit" />
		<aui:button onClick="<%=viewURL%>" type="cancel" />
	</aui:button-row>
	
	<liferay-asset:asset-categories-error />
	<liferay-asset:asset-tags-error />
	
	<c:if test="<%=myGradebook != null %>">
		<liferay-ui:panel 
		defaultState="closed" 
		extended="<%= false %>"
		id="myGradebookCategorizationPanel" 
		persistState="<%= true %>"
		title="categorization">
			<aui:fieldset>
				<liferay-asset:asset-categories-selector className="<%= MyGradebook.class.getName() %>" classPK="<%= myGradebook.getMyGradebookId() %>" />
				<liferay-asset:asset-tags-selector className="<%= MyGradebook.class.getName() %>" classPK="<%= myGradebook.getMyGradebookId() %>" />
			</aui:fieldset>
		</liferay-ui:panel>
	</c:if>
	
	<liferay-ui:panel 
	defaultState="closed" 
	extended="<%= false %>"
	id="myGradebookAssetLinksPanel" 
	persistState="<%= true %>"
	title="related-assets">
		<aui:fieldset>
			<liferay-asset:input-asset-links
				className="<%= MyGradebook.class.getName() %>"
				classPK="<%= myGradebookId %>" />
		</aui:fieldset>
	</liferay-ui:panel>
</aui:form>
	