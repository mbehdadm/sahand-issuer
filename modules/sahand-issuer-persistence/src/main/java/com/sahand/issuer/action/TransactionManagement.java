package com.sahand.issuer.action;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;

import com.sahand.common.util.logger.SahandLogger;
import com.sahand.issuer.enumeration.TLV;
import com.sahand.issuer.exception.IssuerException;
import com.sahand.issuer.model.Transaction;

@Stateless
public class TransactionManagement {

	private static Logger logger = SahandLogger.getSahandLogger(MemberManagementImpl.class);
	
	@Inject
	@AcquirerRepository
	EntityManager entityManager;
	
    public List<Transaction> checkUniqueFactorNum(String terminalId, String cardAcceptorId, String refrence)throws Exception 
    {

	// String termId = IsoType.hexStr2Str(terminalId.toString());
	// String acceptorId = IsoType.hexStr2Str(cardAcceptorId.toString());
	String len = String.format("%02d", refrence.length());
	String ref = "%" + TLV.FactorNumber.toValue() + len + refrence + "%";
	try
	{
	    Query query = entityManager.createNativeQuery(" select trnsxn.* from" + "	(" + "	 select  " + "		trn87.TXUNQID, " + "         trn87.TXREQDT  "
		    + "	 from "
		    + "		TRNSXN87 trn87 , AUTHRSP rsp "
		    + "	 where "
		    + "		rsp.TXUNQID = trn87.TXUNQID "
		    + "	 and "
		    + "		rsp.TXREQDT = trn87.TXREQDT "
		    + "	 and  "
		    + "		trn87.tx87de62 like :refrence "
		    // + "	 and "
		    // + "		trn87.tx87de41 = :terminalId "
		    // + "	 and "
		    // + "		trn87.tx87de42 = :merchantId "
		    + "	 and " + "		rsp.ATRSPCODE = '0' )tx87 " + "    ,trnsxn " + " where " + "       tx87.TXUNQID = trnsxn.TXUNQID " + " and "
		    + "       tx87.TXREQDT = trnsxn.TXREQDT " + " and " + "       trnsxn.TXREV = 1 "+ /*+ ReversalFlagEnum.FALSE.toValue() +*/
		    " and "
		    + " to_char(trnsxn.TXREQDT,'YYYY') = to_char(sysdate,'YYYY') ", Transaction.class);
	    query.setParameter("refrence", ref)
	    // .setParameter("terminalId", terminalId)
	    // .setParameter("merchantId", cardAcceptorId)
	    ;
	    return query.getResultList();
	    
	}
	catch (Exception e)
	{
	    e.printStackTrace();
	    throw new IssuerException("transactions.load.exception");
	}
    }
}
