package com.tutorial.guestbookt.search;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import com.tutorial.guestbookt.model.GuestbookT;
import com.tutorial.guestbookt.model.GuestbookTEntry;
import com.tutorial.guestbookt.service.GuestbookTLocalService;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = "indexer.class.name=com.tutorial.guestbookt.model.GuestbookTEntry",
        service = ModelDocumentContributor.class
)
public class GuestbookTEntryModelDocumentContributor 
	implements ModelDocumentContributor<GuestbookTEntry> {

    @Override
    public void contribute(Document document, GuestbookTEntry entry) {
        try {
            Locale defaultLocale = PortalUtil.getSiteDefaultLocale(
    entry.getGroupId());

            document.addDate(Field.MODIFIED_DATE, entry.getModifiedDate());
            document.addText("entryEmail", entry.getEmail());

            String localizedTitle = LocalizationUtil.getLocalizedName(
    Field.TITLE, defaultLocale.toString());
            String localizedContent = LocalizationUtil.getLocalizedName(
    Field.CONTENT, defaultLocale.toString());

            document.addText(localizedTitle, entry.getName());
            document.addText(localizedContent, entry.getMessage());

            long guestbookTId = entry.getGuestbookTId();

            GuestbookT guestbookT = _guestbookTLocalService.getGuestbookT(
    guestbookTId);

            String guestbookTName = guestbookT.getName();

            String localizedGbName = LocalizationUtil.getLocalizedName(
    Field.NAME, defaultLocale.toString());

            document.addText(localizedGbName, guestbookTName);
        } catch (PortalException pe) {
            if (_log.isWarnEnabled()) {
                _log.warn("Unable to index entry " + entry.getEntryId(), pe);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static final Log _log = LogFactoryUtil.getLog(
    GuestbookTEntryModelDocumentContributor.class);

    @Reference
    private GuestbookTLocalService _guestbookTLocalService;
}
