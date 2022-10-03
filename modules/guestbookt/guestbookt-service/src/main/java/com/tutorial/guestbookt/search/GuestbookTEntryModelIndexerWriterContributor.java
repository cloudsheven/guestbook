package com.tutorial.guestbookt.search;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import com.tutorial.guestbookt.model.GuestbookTEntry;
import com.tutorial.guestbookt.service.GuestbookTEntryLocalService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		property = "indexer.class.name=com.tutorial.guestbookt.model.GuestbookTEntry",
		service = ModelIndexerWriterContributor.class

)
public class GuestbookTEntryModelIndexerWriterContributor 
	implements ModelIndexerWriterContributor<GuestbookTEntry> {

	@Override
    public void customize(
            BatchIndexingActionable batchIndexingActionable,
            ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {

            batchIndexingActionable.setPerformActionMethod((GuestbookTEntry entry) -> {
                Document document = modelIndexerWriterDocumentHelper.getDocument(
        entry);

                batchIndexingActionable.addDocuments(document);
                
            });
        }
	@Override
	public BatchIndexingActionable getBatchIndexingActionable() {
		 return dynamicQueryBatchIndexingActionableFactory.getBatchIndexingActionable(
				    guestbookTEntryLocalService.getIndexableActionableDynamicQuery());
	}

	@Override
	public long getCompanyId(GuestbookTEntry entry) {
		return entry.getCompanyId();
	}
	
    @Reference
    protected DynamicQueryBatchIndexingActionableFactory
    dynamicQueryBatchIndexingActionableFactory;

    @Reference
    protected GuestbookTEntryLocalService guestbookTEntryLocalService;
}
