package com.tutorial.guestbookt.search;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import com.tutorial.guestbookt.model.GuestbookT;
import com.tutorial.guestbookt.service.GuestbookTLocalService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = "indexer.class.name=com.tutorial.guestbookt.model.GuestbookT",
        service = ModelIndexerWriterContributor.class
)
public class GuestbookTModelIndexerWriterContributor 
	implements ModelIndexerWriterContributor<GuestbookT> {

	@Override
	public void customize(
			BatchIndexingActionable batchIndexingActionable,
			ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {

        batchIndexingActionable.setPerformActionMethod((GuestbookT guestbookt) -> {
            Document document = modelIndexerWriterDocumentHelper.getDocument(
            guestbookt);

            batchIndexingActionable.addDocuments(document);
        });
		
	}

	@Override
	public BatchIndexingActionable getBatchIndexingActionable() {
		return dynamicQueryBatchIndexingActionableFactory.getBatchIndexingActionable(
			    guestbookTLocalService.getIndexableActionableDynamicQuery());
	}

	@Override
	public long getCompanyId(GuestbookT guestbookt) {
		return guestbookt.getCompanyId();
	}
	
    @Override
	public void modelIndexed(GuestbookT guestbookT) {
    	
    	guestbookTEntryBatchReindexer.reindex(
    		    guestbookT.getGuestbookTId(), guestbookT.getCompanyId());
	}	

	
    @Reference
    protected DynamicQueryBatchIndexingActionableFactory
    dynamicQueryBatchIndexingActionableFactory;

	@Reference
    protected GuestbookTEntryBatchReindexer guestbookTEntryBatchReindexer;

    @Reference
    protected GuestbookTLocalService guestbookTLocalService;

}
