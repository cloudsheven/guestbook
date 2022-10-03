<%@include file="../../init.jsp"%>

<%
GuestbookT guestbookt = (GuestbookT)request.getAttribute("gbt_guestbookt");
guestbookt = guestbookt.toEscapedModel();
%>

<dl>
		<dt>Name</dt>
		<dd><%= guestbookt.getName() %></dd>
</dl>