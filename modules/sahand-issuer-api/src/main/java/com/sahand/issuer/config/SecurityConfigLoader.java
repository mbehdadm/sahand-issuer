package com.sahand.issuer.config;

import java.util.Properties;

import com.sahand.common.util.reader.CommonConfigLoader;

public class SecurityConfigLoader {

	
	private static Properties CONFIGURATION;
	private static String FILE_NAME = "switch-issuer-cfg.properties";
	private static String BASE_DIR = "switch";
	
	public static String getValue(String key){
		if(CONFIGURATION == null)
			getInstance();
		String value = null;
		try{
			value  = (String)CONFIGURATION.get(key);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return value;
		
	}
	
	
	private static void getInstance() {
		CONFIGURATION = CommonConfigLoader.readExternalConfiguration(FILE_NAME, BASE_DIR);
		
	}


	public static boolean clear(){
		boolean check = false;
		try{
			CONFIGURATION = null;
			check = true;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}
	
	public static boolean relaod(){
		boolean check = false;
		try{
			CONFIGURATION = CommonConfigLoader.readExternalConfiguration(FILE_NAME, BASE_DIR);
			check = true;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}
}
