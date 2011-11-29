package com.sahand.cms.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class AuthorizerTransactionResponsePK implements Serializable,Cloneable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long transactionId;
	private Date trnsReqDate;

	/**
	 * @return the transactionId
	 */
	
	@Column(name="TXUNQID",nullable = false, precision = 6, scale = 0)
	public Long getTransactionId() {
		return transactionId;
	}
	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}
	/**
	 * @return the trnsReqDate
	 */

	@Column(name="TXREQDT",nullable = false)
	public Date getTrnsReqDate() {
		return trnsReqDate;
	}
	/**
	 * @param trnsReqDate the trnsReqDate to set
	 */
	public void setTrnsReqDate(Date trnsReqDate) {
		this.trnsReqDate = trnsReqDate;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((transactionId == null) ? 0 : transactionId.hashCode());
		result = prime * result
				+ ((trnsReqDate == null) ? 0 : trnsReqDate.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof TransactionId))
			return false;
		AuthorizerTransactionResponsePK other = (AuthorizerTransactionResponsePK) obj;
		if (transactionId == null) {
			if (other.transactionId != null)
				return false;
		} else if (!transactionId.equals(other.transactionId))
			return false;
		if (trnsReqDate == null) {
			if (other.trnsReqDate != null)
				return false;
		} else if (!trnsReqDate.equals(other.trnsReqDate))
			return false;
		return true;
	}
	  
    public AuthorizerTransactionResponsePK clone()throws CloneNotSupportedException {
   
    	AuthorizerTransactionResponsePK that;
			that = (AuthorizerTransactionResponsePK)super.clone();
			return that;
    }
	

}
