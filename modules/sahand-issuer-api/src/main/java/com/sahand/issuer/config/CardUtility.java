package com.sahand.issuer.config;

import java.util.Random;

public class CardUtility {

	
	public static String createServiceCode() {

		Random rand = new Random();
		int n = 999;
		return rand.nextInt(n + 1) + "";
	}

	public static String createCardPVV() {

		Random rand = new Random();
		int n = 9999;
		String strPVV= rand.nextInt(n + 1) + "";
		while (strPVV.length() < 4)
			strPVV = "0" + strPVV;
		
		return strPVV;
	}

	public static String createCardCVV() {
		Random rand = new Random();
		int n = 999;
		String strCVV= rand.nextInt(n + 1) + "";
		while (strCVV.length() < 3)
			strCVV = "0" + strCVV;
		
		return strCVV;
	}

	public static boolean isValidCardPan(String s) {
		return doLuhn(s, false) % 10 == 0;
	}

	public static String createCardPan(String iin, String cardTypeId, String panSeq) {
		while (iin.length() < 6)
			iin = "0" + iin;
		while (cardTypeId.length() < 3)
			cardTypeId = "0" + cardTypeId;
		while (panSeq.length() < 6)
			panSeq = "0" + panSeq;
		String pan = iin + cardTypeId + panSeq;

		int checkDigit=doLuhn(pan, true) % 10;
		int digit = 10 - (checkDigit != 0 ? checkDigit : 10);

		System.out.println("           ----------      createCardPan:" + pan
				+ digit + " Validation is : " + isValidCardPan(pan + digit));
		return pan + digit;
	}

	private static int doLuhn(String s, boolean evenPosition) {
		int sum = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			int n = Integer.parseInt(s.substring(i, i + 1));
			if (evenPosition) {
				n *= 2;
				if (n > 9) {
					n = (n % 10) + 1;
				}
			}
			sum += n;
			evenPosition = !evenPosition;
		}

		return sum;
	}

	/*
	 * ** Track 1 Layout: *** | SS | PAN | Name | Additional Data | ES |
	 * 
	 * SS=Start Sentinel "%" FC=Format Code "B" PAN=Primary Acct. # (19 digits
	 * max) FS=Field Separator "^" Name=26 alphanumeric characters max.
	 * Additional Data=Expiration Date, Service Code, PVKI ,PVV , Padding , CVV
	 * ,Padding ES=End Sentinel "?"
	 */
	public String createCardTrack1(String pan, String cardHolderName,
			String expiryDate, String serviceCode, String pvv, String cvv) {

		return "%B" + pan + "^" + cardHolderName.toUpperCase() + "^" + expiryDate
				+ serviceCode + "1"+pvv + "00" + cvv + "000000" + "?";

	}

	/*
	 * ** Track 1 Layout: *** | SS | PAN | | Additional Data | ES |
	 * 
	 * SS=Start Sentinel ";" PAN=Primary Acct. # (19 digits max) FS=Field
	 * Separator "=" Additional Data=Expiration Date, Service Code, PVKI ,PVV ,
	 * CVV ,Padding ES=End Sentinel "?"
	 */
	public String createCardTrack2(String pan, String expiryDate,
			String serviceCode, String pvv, String cvv) {

		return ";" + pan + "=" + expiryDate + serviceCode + pvv + cvv + "0"
				+ "?";

	}

	public String createCardTrack3(String formatCode, String pan,
			String currencyCode, String currencyExponent, String pvv, String cvv) {

		return "";
	}
}
