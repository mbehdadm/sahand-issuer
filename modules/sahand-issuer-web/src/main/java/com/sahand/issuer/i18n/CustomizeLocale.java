package com.sahand.issuer.i18n;

import java.util.Locale;

import javax.enterprise.event.Event;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.seam.international.Alter;
import org.jboss.seam.international.locale.LocaleConfiguration;
import org.jboss.solder.core.Client;
import org.joda.time.DateTimeZone;
import org.slf4j.Logger;

import com.sahand.common.util.logger.SahandLogger;

@Named
public class CustomizeLocale extends LocaleConfiguration{

	private static Logger logger = SahandLogger.getSahandLogger(CustomizeLocale.class);
	
	@Inject Locale defaultLocale;
	@Inject DateTimeZone defaultTimeZone;
	
	@Inject @Client/*@UserLocale*/ Locale userlocale;
	@Inject @Client/*@UserTimeZone*/ DateTimeZone userTimeZone;

	@Inject @Alter/*@Changed*/ Event<Locale> localeEvent;
	@Inject @Alter/*@Changed*/ Event<DateTimeZone> timeZoneEvent;
	private String selectLocale;
	
	public void setUserLocale() {
		localeEvent.fire(userlocale);
	}
	
	public void setUserTimeZone() {
		timeZoneEvent.fire(
				DateTimeZone.forID(userTimeZone.getID()));
	}

	public String getSelectLocale() {
		logger.debug("locale that get : "+selectLocale);
		return selectLocale;
	}

	public void setSelectLocale(String selectLocale) {
		this.selectLocale = selectLocale;
		logger.debug("locale that set : "+selectLocale);
	}
	
//	public String change(){
//		localeEvent.fire(new Locale(selectLocale));
//		return null;
//	}
	public void change(ActionEvent event){
		localeEvent.fire(new Locale(selectLocale));
		
	}
	
	

}
