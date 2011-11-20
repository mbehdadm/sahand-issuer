package com.sahand.issuer.action;

import com.sahand.common.util.message.RequestHeader;


public interface AuthenticationManagement {
	
	public boolean isSessionValid(RequestHeader header)  throws Exception ;
	

}
