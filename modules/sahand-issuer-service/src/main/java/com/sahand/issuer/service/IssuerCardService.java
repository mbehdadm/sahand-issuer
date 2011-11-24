package com.sahand.issuer.service;

import com.sahand.issuer.message.IssuerCardRequest;
import com.sahand.issuer.message.IssuerCardResponse;


public interface IssuerCardService {
	
    public IssuerCardResponse changeCardPin(IssuerCardRequest  rq);
    public IssuerCardResponse forgetPassword(IssuerCardRequest rq);
    
    public IssuerCardResponse generateCard(IssuerCardRequest rq);
    public IssuerCardResponse generateBatchCards(IssuerCardRequest rq);
    
    public IssuerCardResponse modifyCardStatus(IssuerCardRequest request);
    public IssuerCardResponse temporaryDisableCard(IssuerCardRequest request);
    public IssuerCardResponse disableCardWithResetPoint(IssuerCardRequest request);
    public IssuerCardResponse disableCardWithoutResetPoint(IssuerCardRequest request);

}
