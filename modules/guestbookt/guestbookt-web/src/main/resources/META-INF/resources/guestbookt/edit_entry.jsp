<%@page import="java.util.Date"%>
<%@page import="com.tutorial.guestbookt.service.GuestbookTEntryLocalServiceUtil"%>
<%@page import="com.tutorial.guestbookt.service.GuestbookTEntryLocalService"%>
<%@page import="com.tutorial.guestbookt.model.GuestbookTEntry"%>
<%@page import="com.tutorial.guestbookt.exception.GuestbookEntryEmailException"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="../init.jsp" %>

<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/guestbookt/view.jsp"></portlet:param>
</portlet:renderURL>

<portlet:actionURL name="addEntry" var="addEntryURL" />
<%
	long entryId = ParamUtil.getLong(renderRequest, "entryId");
	GuestbookTEntry entry = null;
	if (entryId > 0) {
		entry = GuestbookTEntryLocalServiceUtil.getGuestbookTEntry(entryId);
	}
	long guestbookTId = ParamUtil.getLong(renderRequest, "guestbookTId");
%>

<aui:form action="<%= addEntryURL %>" name="<portlet:namespace />fm">

<aui:model-context bean="<%= entry %>" model="<%= GuestbookTEntry.class %>" />

	<aui:fieldset>
		<aui:input name="name" />
		<aui:input name="email" />
		<aui:input name="message" />
		<aui:input name="entryId" type="hidden" />
		<aui:input name="guestbookTId" type="hidden" value='<%= entry == null ? guestbookTId : entry.getGuestbookTId() %>'/>

	</aui:fieldset>

	<aui:button-row>

		<aui:button type="submit"></aui:button>
		<aui:button type="cancel" onClick="<%= viewURL.toString() %>"></aui:button>

	</aui:button-row>
</aui:form>