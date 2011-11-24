package com.sahand.issuer.service;

import com.sahand.issuer.message.IssuerSetupRequest;
import com.sahand.issuer.message.IssuerSetupResponse;

public interface IssuerSetup {
	
	public IssuerSetupResponse registerProgram(IssuerSetupRequest request);
	public IssuerSetupResponse editProgram(IssuerSetupRequest request);
	public IssuerSetupResponse removeProgram(IssuerSetupRequest request);
	
	public IssuerSetupResponse addProgramPartner(IssuerSetupRequest request);
	public IssuerSetupResponse editProgramPartner(IssuerSetupRequest request);
	////////modifyCardHolderInfo
	////    CardAcceptorRs importCardHoldersInfo(CardAcceptorRq rq)
	//// CardAcceptorRs modifyMember(CardAcceptorRq rq)
    public IssuerSetupResponse registerMemberInformation(IssuerSetupRequest request);
    public IssuerSetupResponse editMemberInformation(IssuerSetupRequest request);
    public IssuerSetupResponse assignCardToMember(IssuerSetupRequest request);
    public IssuerSetupResponse editMemberCard(IssuerSetupRequest request);
    
    public IssuerSetupResponse registerCardType(IssuerSetupRequest request);
	public IssuerSetupResponse editCardType(IssuerSetupRequest request);
	
	public IssuerSetupResponse registerCreditOrganization(IssuerSetupRequest request);
	public IssuerSetupResponse editCreditOrganization(IssuerSetupRequest request);
	
    
//    public IssuerSetupResponse registerMissingTransaction(IssuerSetupRequest request);
////    public CardAcceptorRs acpRegisterMissingTransaction(CardAcceptorRq rq)
//    
//    public IssuerSetupResponse registerMissingTransactionRedeem(IssuerSetupRequest request);
////    public CardAcceptorRs acpRegisterMissingTransactionRedeem(CardAcceptorRq rq)
//    
//    public IssuerSetupResponse confirmMissingTransactions(IssuerSetupRequest request);
//    
//    public IssuerSetupResponse deleteMissingTransaction(IssuerSetupRequest request);
//
//    
//    //modifyCardAcceptorSpecification go tooo acquirer  ---> editInstitute();
////    public CardAcceptorRs modifyCardAcceptorSpecification(CardAcceptorRq rq){}
//    
////    public CardAcceptorRs registerPrintCardDemand(CardAcceptorRq rq)


}
