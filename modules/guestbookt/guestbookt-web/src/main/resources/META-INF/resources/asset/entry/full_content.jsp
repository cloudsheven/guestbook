<%@include file="../../init.jsp"%>

<%
GuestbookTEntry entry = (GuestbookTEntry)request.getAttribute("gbt_entry");
entry = entry.toEscapedModel();
%>

<dl>
		<dt>GuestbookT</dt>
		<dd><%= GuestbookTLocalServiceUtil.getGuestbookT(entry.getGuestbookTId()).getName() %></dd>
		<dt>Name</dt>
		<dd><%= entry.getName() %></dd>
		<dt>Message</dt>
		<dd><%= entry.getMessage() %></dd>
</dl>