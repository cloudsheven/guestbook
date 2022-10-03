<%@ include file="../init.jsp" %>

<%  
	long guestbookTId = ParamUtil.getLong(request, "guestbookTId");
	
	GuestbookT guestbookT = null;
	
	if (guestbookTId > 0) {
		guestbookT = GuestbookTLocalServiceUtil.getGuestbookT(guestbookTId);
	}

%>

<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="/guestbookt_admin/view.jsp"/>
</portlet:renderURL>

<portlet:actionURL name='<%= guestbookT == null ? "addGuestbookT" : "updateGuestbookT" %>' var="editGuestbookTURL" />

<aui:form action="<%=editGuestbookTURL%>" name="fm">
	
	<aui:model-context bean="<%=guestbookT%>" model="<%=GuestbookT.class %>" />
	
	<aui:input type="hidden" name="guestbookTId"
		value="<%=guestbookT == null ? "" : guestbookT.getGuestbookTId() %>" />
		
	<aui:fieldset>
		<aui:input name="name" />
	</aui:fieldset>
	
	<aui:button-row>
		<aui:button type="submit" />
		<aui:button onClick="<%=viewURL%>" type="cancel" />
	</aui:button-row>
	
	<liferay-asset:asset-categories-error />
	<liferay-asset:asset-tags-error />
	
	<c:if test="<%=guestbookT != null %>">
    	<liferay-ui:panel 
    	defaultState="closed" 
    	extended="<%= false %>"
    	id="guestbookTCategorizationPanel" 
    	persistState="<%= true %>"
    	title="categorization">      
      		<aui:fieldset>
      			<liferay-asset:asset-categories-selector className="<%= GuestbookT.class.getName() %>" classPK="<%= guestbookT.getGuestbookTId() %>" />
				<liferay-asset:asset-tags-selector className="<%= GuestbookT.class.getName() %>" classPK="<%= guestbookT.getGuestbookTId() %>" />
			</aui:fieldset>
    	</liferay-ui:panel>
    </c:if>
    
    <liferay-ui:panel 
    defaultState="closed" 
    extended="<%= false %>"
    id="guestbookTAssetLinksPanel" 
    persistState="<%= true %>"
    title="related-assets">
  		<aui:fieldset>
    		<liferay-asset:input-asset-links
      			className="<%= GuestbookT.class.getName() %>"
      			classPK="<%= guestbookTId %>" />
  		</aui:fieldset>
	</liferay-ui:panel>


</aui:form>