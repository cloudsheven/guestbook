<%@include file="../init.jsp"%>

<%
  String keywords = ParamUtil.getString(request, "keywords");
  long guestbookTId = ParamUtil.getLong(renderRequest, "guestbookTId");
%>

<portlet:renderURL var="searchURL">
        <portlet:param 
        	name="mvcPath" 
        	value="/guestbookt/view_search.jsp" 
        />
</portlet:renderURL>

<portlet:renderURL var="viewURL">
    <portlet:param 
        name="mvcPath" 
        value="/guestbookt/view.jsp" 
    />
</portlet:renderURL>

<aui:form action="${searchURL}" name="fm">

    <liferay-ui:header backURL="${viewURL}" title="back" />

    <div class="row">
        <div class="col-md-8">
            <aui:input inlineLabel="left" label="" name="keywords" placeholder="search-entries" size="256" />
        </div>

        <div class="col-md-4">
            <aui:button type="submit" value="search" />
        </div>
    </div>
</aui:form>

<%
    SearchContext searchContext = SearchContextFactory.getInstance(request);

    searchContext.setKeywords(keywords);
    searchContext.setAttribute("paginationType", "more");
    searchContext.setStart(0);
    searchContext.setEnd(10);
    
    Indexer<GuestbookTEntry> indexer = IndexerRegistryUtil.getIndexer(GuestbookTEntry.class);
    
    Hits hits = indexer.search(searchContext);

    List<GuestbookTEntry> entries = new ArrayList<GuestbookTEntry>();

    for (int i = 0; i < hits.getDocs().length; i++) {
            Document doc = hits.doc(i);

            long entryId = GetterUtil
            .getLong(doc.get(Field.ENTRY_CLASS_PK));

            GuestbookTEntry entry = null;

            try {
                    entry = GuestbookTEntryLocalServiceUtil.getGuestbookTEntry(entryId);
            } catch (PortalException pe) {
                    _log.error(pe.getLocalizedMessage());
            } catch (SystemException se) {
                    _log.error(se.getLocalizedMessage());
            }

            entries.add(entry);
    }
    
    List<GuestbookT> guestbooks = GuestbookTLocalServiceUtil.getGuestbooks(scopeGroupId);

    Map<String, String> guestbookTMap = new HashMap<String, String>();

    for (GuestbookT guestbookt : guestbooks) {
            guestbookTMap.put(Long.toString(guestbookt.getGuestbookTId()), guestbookt.getName());
    }
%>

<liferay-ui:search-container delta="10" 
    emptyResultsMessage="no-entries-were-found" 
    total="<%= entries.size() %>">
        <liferay-ui:search-container-results
                results="<%= entries %>"
/>

	<liferay-ui:search-container-row
	        className="com.tutorial.guestbookt.model.GuestbookTEntry"
	        keyProperty="entryId" modelVar="entry" escapedModel="<%=true%>">
	        
	        <liferay-ui:search-container-column-text name="guestbookt"
	        value="<%=guestbookTMap.get(Long.toString(entry.getGuestbookTId()))%>" />
	        
	        <liferay-ui:search-container-column-text property="message" />
	        
	        <liferay-ui:search-container-column-text property="name" />
	        
	        <liferay-ui:search-container-column-jsp
	        path="/guestbookt/entry_actions.jsp"
	        align="right" />
	</liferay-ui:search-container-row>
	
	<liferay-ui:search-iterator />
</liferay-ui:search-container>

<%!
    private static Log _log = LogFactoryUtil.getLog("html.guestbookt.view_search_jsp");
%>
    