package com.sahand.security.service;

import com.sahand.issuer.message.IssuerAuthorizerSetupRequest;
import com.sahand.issuer.message.IssuerAuthorizerSetupResponse;

public interface IssuerAuthorizerSetup {
	
    public IssuerAuthorizerSetupResponse registerMissingTransaction(IssuerAuthorizerSetupRequest request);
//    public CardAcceptorRs acpRegisterMissingTransaction(CardAcceptorRq rq)
    
    public IssuerAuthorizerSetupResponse registerMissingTransactionRedeem(IssuerAuthorizerSetupRequest request);
//    public CardAcceptorRs acpRegisterMissingTransactionRedeem(CardAcceptorRq rq)
    
    public IssuerAuthorizerSetupResponse confirmMissingTransactions(IssuerAuthorizerSetupRequest request);
    
    public IssuerAuthorizerSetupResponse deleteMissingTransaction(IssuerAuthorizerSetupRequest request);

    
    //modifyCardAcceptorSpecification go tooo acquirer  ---> editInstitute();
//    public CardAcceptorRs modifyCardAcceptorSpecification(CardAcceptorRq rq){}
    
//    public CardAcceptorRs registerPrintCardDemand(CardAcceptorRq rq)


}
