<%@ include file="../init.jsp"%>

<%
  long entryId = ParamUtil.getLong(renderRequest, "entryId");

  long guestbookId = ParamUtil.getLong(renderRequest, "guestbookTId");

  GuestbookTEntry entry = null;

  entry = GuestbookTEntryLocalServiceUtil.getGuestbookTEntry(entryId);

  entryId = entry.getEntryId();

  entry = entry.toEscapedModel();

  AssetEntry assetEntry = 
  AssetEntryLocalServiceUtil.getEntry(GuestbookTEntry.class.getName(), 
  entry.getEntryId());
  
  String currentURL = PortalUtil.getCurrentURL(request);
  
  PortalUtil.addPortletBreadcrumbEntry(request, entry.getMessage(), currentURL);
  PortalUtil.setPageSubtitle(entry.getMessage(), request);
  PortalUtil.setPageDescription(entry.getMessage(), request);

  List<AssetTag> assetTags = 
		  AssetTagLocalServiceUtil.getTags(
				  GuestbookTEntry.class.getName(), entry.getEntryId());
  
  PortalUtil.setPageKeywords(ListUtil.toString(assetTags, "name"), 
    request);
%>

<liferay-portlet:renderURL varImpl="viewEntryURL">
  <portlet:param name="mvcPath"
    value="/guestbookt/view_entry.jsp" />
  <portlet:param name="entryId" value="<%=String.valueOf(entryId)%>" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL varImpl="viewURL">
  <portlet:param name="mvcPath"
    value="/guestbookt/view.jsp" />
</liferay-portlet:renderURL>

<liferay-ui:header backURL="<%=viewURL.toString()%>"
  title="<%=entry.getName()%>" 
/>

<dl>
  <dt>GuestbookT</dt>
  <dd><%=GuestbookTLocalServiceUtil.getGuestbookT(entry.getGuestbookTId()).getName()%></dd>
  <dt>Name</dt>
  <dd><%=entry.getName()%></dd>
  <dt>Message</dt>
  <dd><%=entry.getMessage()%></dd>
</dl>

<c:if test="<%= themeDisplay.isSignedIn() %>">
	<liferay-ui:panel-container extended="<%=false%>"
		id="guestbookTCollaborationPanelContainer" persistState="<%=true%>">
		<liferay-ui:panel collapsible="<%=true%>" extended="<%=true%>"
			id="guestbookTCollaborationPanel" persistState="<%=true%>"
			title="Collaboration">
			<liferay-ratings:ratings
				className="<%= GuestbookTEntry.class.getName() %>"
				classPK="<%= entry.getEntryId() %>"
				type="stars"
			/>			
			
			<br />

			<%
		Discussion discussion = CommentManagerUtil.getDiscussion(
				user.getUserId(), scopeGroupId, GuestbookTEntry.class.getName(),
				entry.getEntryId(), new ServiceContextFunction(request));
		%>

			<c:if test="<%= discussion != null %>">
				<h2>
					<strong> <liferay-ui:message
							arguments="<%= discussion.getDiscussionCommentsCount() %>"
							key='<%= (discussion.getDiscussionCommentsCount() == 1) ? "x-comment" : "x-comments" %>' />
					</strong>
				</h2>

				<liferay-comment:discussion
					className="<%= GuestbookTEntry.class.getName() %>"
					classPK="<%= entry.getEntryId() %>" discussion="<%= discussion %>"
					formName="fm2" ratingsEnabled="true" redirect="<%= currentURL %>"
					userId="<%= entry.getUserId() %>" />
			</c:if>

		</liferay-ui:panel>
	</liferay-ui:panel-container>
</c:if>





