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
</aui:form>