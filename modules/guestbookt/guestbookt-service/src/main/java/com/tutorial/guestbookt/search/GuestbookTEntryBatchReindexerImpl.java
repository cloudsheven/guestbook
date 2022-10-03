package com.tutorial.guestbookt.search;

import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.indexer.IndexerDocumentBuilder;
import com.liferay.portal.search.indexer.IndexerWriter;
import com.tutorial.guestbookt.model.GuestbookTEntry;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true, 
		service = GuestbookTEntryBatchReindexer.class
)
public class GuestbookTEntryBatchReindexerImpl implements GuestbookTEntryBatchReindexer {

	@Override
	public void reindex(long guestbookTId, long companyId) {
		
		BatchIndexingActionable batchIndexingActionable = indexerWriter.getBatchIndexingActionable();

		batchIndexingActionable.setAddCriteriaMethod(dynamicQuery -> {
			Property guestbookIdPropery = PropertyFactoryUtil.forName("guestbookTId");

			dynamicQuery.add(guestbookIdPropery.eq(guestbookTId));
		});

		batchIndexingActionable.setCompanyId(companyId);

		batchIndexingActionable.setPerformActionMethod((GuestbookTEntry entry) -> {
			Document document = indexerDocumentBuilder.getDocument(entry);

			batchIndexingActionable.addDocuments(document);
		});

		batchIndexingActionable.performActions();

	}

	@Reference(target = "(indexer.class.name=com.tutorial.model.GuestbookTEntry)")
	protected IndexerDocumentBuilder indexerDocumentBuilder;

	@Reference(target = "(indexer.class.name=com.tutorial.model.GuestbookTEntry)")
	protected IndexerWriter<GuestbookTEntry> indexerWriter;
}
