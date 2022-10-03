<%@page import="java.util.Date"%>
<%@page
	import="com.tutorial.guestbookt.service.GuestbookTEntryLocalServiceUtil"%>
<%@page
	import="com.tutorial.guestbookt.service.GuestbookTEntryLocalService"%>
<%@page import="com.tutorial.guestbookt.model.GuestbookTEntry"%>
<%@page
	import="com.tutorial.guestbookt.exception.GuestbookEntryEmailException"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="../init.jsp"%>

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

<liferay-ui:header backURL="<%=viewURL.toString()%>"
	title="<%=entry == null ? "Add Entry" : entry.getName()%>" />

<aui:form action="<%=addEntryURL%>" name="<portlet:namespace />fm">

	<aui:model-context bean="<%=entry%>"
		model="<%=GuestbookTEntry.class%>" />

	<aui:fieldset>
		<aui:input name="name" />
		<aui:input name="email" />
		<aui:input name="message" />
		<aui:input name="entryId" type="hidden" />
		<aui:input name="guestbookTId" type="hidden"
			value='<%=entry == null ? guestbookTId : entry.getGuestbookTId()%>' />

	</aui:fieldset>

	<liferay-asset:asset-categories-error />
	<liferay-asset:asset-tags-error />

	<liferay-ui:panel defaultState="closed" extended="<%=false%>"
		id="entryCategorizationPanel" persistState="<%=true%>"
		title="categorization">

		<aui:fieldset>
			<liferay-asset:asset-categories-selector
				className="<%=GuestbookTEntry.class.getName()%>"
				classPK="<%=entryId%>" />
			<liferay-asset:asset-tags-selector
				className="<%=GuestbookTEntry.class.getName()%>"
				classPK="<%=entryId%>" />
		</aui:fieldset>

	</liferay-ui:panel>

	<liferay-ui:panel defaultState="closed" extended="<%=false%>"
		id="entryAssetLinksPanel" persistState="<%=true%>"
		title="related-assets">

		<aui:fieldset collapsed="<%=true%>" collapsible="<%=true%>"
			label="related-assets">

			<liferay-asset:input-asset-links
				className="<%=GuestbookTEntry.class.getName()%>"
				classPK="<%=entryId%>" />

		</aui:fieldset>

	</liferay-ui:panel>

	<aui:button-row>

		<aui:button type="submit"></aui:button>
		<aui:button type="cancel" onClick="<%=viewURL.toString()%>"></aui:button>

	</aui:button-row>
</aui:form>