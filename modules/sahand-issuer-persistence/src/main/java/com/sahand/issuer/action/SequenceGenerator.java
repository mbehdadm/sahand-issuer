package com.sahand.issuer.action;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import org.slf4j.Logger;

import com.sahand.acquirer.action.ConfigChecker;
import com.sahand.acquirer.action.SequenceGenerator;
import com.sahand.acquirer.config.AcquirerConfigLoader;
import com.sahand.common.util.logger.SahandLogger;

/**
 * @author Bmoodi
 *
 */
public class SequenceGenerator {
	
	private static Logger logger = SahandLogger.getSahandLogger(SequenceGenerator.class);

	
	public static String sequenceGenerator(EntityManager em,Class clazz,String id,String key){
		
		try {
			BigDecimal bd = null;
			String direction ="";
			String formatString ="";
			String padding = "";
			Integer length ;
			String sequnceName="";
			int generateType = 0; 
			String ppfix = "";
			String ppDirection = "";


			formatString = AcquirerConfigLoader.getValue(key);
			
			
			String[] split = formatString.split("-");
			length = Integer.valueOf(split[0]);
			direction = split[1];
			padding = split[2];
			sequnceName = split[3];
			generateType = Integer.valueOf(split[4]);
			ppDirection = split[5];
			ppfix = split[6];
			if(generateType == 0 && em != null){
				bd = (BigDecimal)em.createNativeQuery("SELECT "+sequnceName+".NEXTVAL FROM DUAL")
								.getSingleResult();
				
				id = String.valueOf(bd);
				logger.debug("ID that generated : "+id);
			}
			
			id = ConfigChecker.adjustment(length, direction, padding,ppDirection,ppfix, id);
			
//			if(!ppDirection.equalsIgnoreCase("N")){
//				
//				id = ConfigChecker.adjustPPfix(ppfix,id);
//				
//			}
				
			
//			if(direction.equalsIgnoreCase("N")){
//				
//				return id;
//				
//			}
			return id;
			
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.warn(e.getMessage());
		}
		return null;
		
	}
	
	
	

}
