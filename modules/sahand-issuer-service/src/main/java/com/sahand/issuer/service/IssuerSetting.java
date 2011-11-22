package com.sahand.issuer.service;

import com.sahand.issuer.message.IssuerSettingRequest;
import com.sahand.issuer.message.IssuerSettingResponse;


public interface IssuerSetting {
	
    public IssuerSettingResponse changeCardPin(IssuerSettingRequest  rq);
    public IssuerSettingResponse forgetPassword(IssuerSettingRequest rq);

}
