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

import java.util.Locale;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		property ="indexer.class.name=com.tutorial.guestbookt.model.GuestbookT",
		service = ModelDocumentContributor.class
)
public class GuestbookTModelDocumentContributor
	implements ModelDocumentContributor<GuestbookT>{

	@Override
	public void contribute(Document document, GuestbookT guestbookt) {		
		
		try {
			document.addDate(Field.MODIFIED_DATE, guestbookt.getModifiedDate());
			
			Locale defaultLocale = PortalUtil.getSiteDefaultLocale(
					guestbookt.getGroupId());
			
			String localizedTitle = LocalizationUtil.getLocalizedName(
				    Field.TITLE, defaultLocale.toString());
			
			document.addText(localizedTitle, guestbookt.getName());
			
		} catch (PortalException pe) {
			
			if (_log.isWarnEnabled()) {
                _log.warn(
    "Unable to index guestbookt " + guestbookt.getGuestbookTId(), pe);
            }
		}
		
	}
	
	private static final Log _log = LogFactoryUtil.getLog(
		    GuestbookTModelDocumentContributor.class);

}
