package com.sahand.issuer.action;

import java.io.Serializable;

import org.slf4j.Logger;

import com.sahand.acquirer.action.ConfigChecker;
import com.sahand.acquirer.config.AcquirerConfigLoader;
import com.sahand.common.util.logger.SahandLogger;

public class ConfigChecker implements Serializable{

	private static Logger logger = SahandLogger.getSahandLogger(ConfigChecker.class);
	
	public static String checkSerialNumber(String serialNo) {
		try {
			logger.info("Serial Number is : "+ serialNo);
			String serialChecker = AcquirerConfigLoader.getValue("serial-number");
			logger.info("Serial Checker is : "+ serialChecker);
			String[] split ;
			String delimiter = "-";
			split = serialChecker.split(delimiter);
			serialNo = adjustment(Integer.valueOf(split[0]),split[1],split[2],serialNo);
			logger.info("Serial Number after adjust : "+ serialNo);
			return serialNo;
		} catch (Exception e) {
			e.printStackTrace();
			logger.warn("in checkAndConfigSerialNumber this error occured in "+ e.getMessage());
		}
		return null;
	}

	public static String adjustment(int length, String direction, String padding,
			String ppDirection, String ppFix,String adjustable) {
		try {
			logger.info("Before adjustment : "+adjustable);
			String tmpPad = "";
			if(!direction.equalsIgnoreCase("N")){
				while(length > adjustable.length()){
					tmpPad += padding;
					length-- ;
				}
				if(direction.equalsIgnoreCase("L")){
					adjustable = tmpPad + adjustable;
				}
				else if(direction.equalsIgnoreCase("R")){
					adjustable = adjustable + tmpPad ;
				}
			}
			if(!ppDirection.equalsIgnoreCase("N")){
				
				if(ppDirection.equalsIgnoreCase("L")){
					adjustable = ppFix + adjustable;
				}
				else if(ppDirection.equalsIgnoreCase("R")){
					adjustable = adjustable + ppFix ;
				}
			}
			logger.info("After adjustment : "+adjustable);
			return adjustable;
			
		} catch (Exception e) {
			 e.printStackTrace();
			 logger.warn("in adjustmnet this error occured : "+ e.getMessage());
			 return adjustable;
		}
	}

	public static String adjustment(int length, String direction, String padding,
			String adjustable) {
		try {
			logger.info("Before adjustment : "+adjustable);
			String tmpPad = "";
			if(!direction.equalsIgnoreCase("N")){
				while(length > adjustable.length()){
					tmpPad += padding;
					length-- ;
				}
				if(direction.equalsIgnoreCase("L")){
					adjustable = tmpPad + adjustable;
				}
				else if(direction.equalsIgnoreCase("R")){
					adjustable = adjustable + tmpPad ;
				}
			}
			logger.info("After adjustment : "+adjustable);
			return adjustable;
			
		} catch (Exception e) {
			 e.printStackTrace();
			 logger.warn("in adjustmnet this error occured : "+ e.getMessage());
			 return adjustable;
		}
	}
//	/**
//	 * @param account
//	 * @return
//	 */
//	public boolean checkPanNumber(String pan) {
//		try {
//			
//			if(!CardNumberChecking(pan)){
//				StatusMessages.instance().addFromResourceBundle(Severity.ERROR,"external.pan.checkdigit.invalid");
//				return false;
//			}
//			
////			if(extacntHome.isUniquePan(pan))
////				return true;
//			return true;
//		} catch (Exception e) {
//			 e.printStackTrace();
//			 StatusMessages.instance().addFromResourceBundle(Severity.ERROR,"general.error.unknown",e.getMessage());
//			 logger.warn("in checkPanNumber this error occured : "+ e.getMessage());
//			 return false;
//		}
//	} 


	
	public static boolean CardNumberChecking(String pan) {
		try{
			logger.info("Pan is : "+ pan);
			int panLength = pan.length();
			logger.info("Pan Length is : "+ panLength);
			String panCheck = pan.substring(0, panLength -1 );
			logger.info("PanCheck is : "+ panCheck);
			if(panCheck.length() != 15 ){
				logger.error("PAN length without checkdigit not equal with 15");
				return false;
			}
			int panCheckLength = panCheck.length();
			String checkDigit = pan.substring(panLength -1 );
			logger.info("Check Digit is : "+ checkDigit);
			int total = 0;
			boolean oddPosition = true;
			for (int n = panCheckLength ; n > 0; n--) {
				logger.info("Before : PanCheck is : "+ panCheck);

				String panCheckTmp = panCheck.substring(n-1);
				panCheck = panCheck.substring(0,n-1);
				
				logger.info("After : PanCheck is : "+ panCheck);
				logger.info("Digit is : "+ panCheckTmp);
				int digit = Integer.valueOf(panCheckTmp);
				if (oddPosition) {
					digit *= 2;
					if (digit > 9){
						int tmp = (digit / 10) + (digit % 10);
						digit = tmp;
					}
				}
				logger.info("Digit is : "+ digit);

				total += digit;
				logger.info("Sum is : "+ total);
				oddPosition = !oddPosition;
			}
			total += Integer.valueOf(checkDigit); 
			logger.info("Total Sum is : "+ total);
			
			int check = total % 10;
			if(check == 0 )
				return true;
			return false;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static  boolean checkPropertyNumber() {
		try {
			String propertyChecker = AcquirerConfigLoader.getValue("property-number") ;
			logger.info("Property Checker is : "+ propertyChecker);
			if(propertyChecker.equals("1"))
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			logger.warn("in check property number error occured : "+ e.getMessage());
		}
		return true;
	}
	

	
	
	
}
