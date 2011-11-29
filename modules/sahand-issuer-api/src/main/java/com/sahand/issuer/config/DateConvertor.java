package com.sahand.issuer.config;

import java.util.Calendar;
import java.util.Date;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class DateConvertor {

	public static XMLGregorianCalendar convertDateToXMLGr(Date inputDt) {

		try {
			DatatypeFactory dtf;
			XMLGregorianCalendar xgc;

			dtf = DatatypeFactory.newInstance();
			xgc = dtf.newXMLGregorianCalendar();
			Calendar cal = Calendar.getInstance();
			cal.setTime(inputDt);
			xgc.setYear(cal.get(Calendar.YEAR));
			xgc.setDay(cal.get(Calendar.DAY_OF_MONTH));
			xgc.setMonth(cal.get(Calendar.MONTH) + 1);
			xgc.setHour(cal.get(Calendar.HOUR_OF_DAY));
			xgc.setMinute(cal.get(Calendar.MINUTE));
			xgc.setSecond(cal.get(Calendar.SECOND));
			xgc.setMillisecond(cal.get(Calendar.MILLISECOND));
		
			return xgc;
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
			return null;
//			throw new IssuerException("convertion.date.failed");
		}
	}

	public static Date convertXMLGrToDate(XMLGregorianCalendar inputDate) {

		Calendar cal = Calendar.getInstance();
		cal.set(inputDate.getYear(), inputDate.getMonth() - 1,
				inputDate.getDay(), inputDate.getHour(), inputDate.getMinute(),
				inputDate.getSecond());
		Date date = cal.getTime();
		return date;

	}

}
