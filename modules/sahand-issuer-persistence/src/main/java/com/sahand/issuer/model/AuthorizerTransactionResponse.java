package com.sahand.issuer.model;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="AUTHRSP")
public class AuthorizerTransactionResponse implements Cloneable{


	//	private Long transactionId;
//	private Date trnsReqDate;
	private AuthorizerTransactionResponsePK pk;
	private Date trnsRspDate;
	private Integer trnsRspCode;
	private String trnsRspMessage;
	
	@EmbeddedId
	@AttributeOverrides({
		@AttributeOverride(name = "txunqid", column = @Column(name = "TXUNQID", nullable = false, precision = 6, scale = 0)),		
		@AttributeOverride(name = "txreqdt", column = @Column(name = "TXREQDT", nullable=false))})
	@NotNull
	public AuthorizerTransactionResponsePK getPk() {
		return pk;
	}
	/**
	 * @param pk the pk to set
	 */
	public void setPk(AuthorizerTransactionResponsePK pk) {
		this.pk = pk;
	}
//	/**
//	 * @return the transactionId
//	 */
//	@Id
//	@Column(name="TXUNQID",nullable = false, precision = 6, scale = 0)
//	@NotNull
//	@Range(max=999999)
//	public Long getTransactionId() {
//		return transactionId;
//	}
//	/**
//	 * @param transactionId the transactionId to set
//	 */
//	public void setTransactionId(Long transactionId) {
//		this.transactionId = transactionId;
//	}
//	/**
//	 * @return the trnsReqDate
//	 */
//	@Id
//	@Column(name="TXREQDT",nullable = false)
//	@NotNull
//	public Date getTrnsReqDate() {
//		return trnsReqDate;
//	}
//	/**
//	 * @param trnsReqDate the trnsReqDate to set
//	 */
//	public void setTrnsReqDate(Date trnsReqDate) {
//		this.trnsReqDate = trnsReqDate;
//	}

	/**
	 * @return the trnsRspDate
	 */
	@Column(name="ATRSPDATE",nullable = false)
	@NotNull
	public Date getTrnsRspDate() {
		return trnsRspDate;
	}
	/**
	 * @param trnsRspDate the trnsRspDate to set
	 */
	public void setTrnsRspDate(Date trnsRspDate) {
		this.trnsRspDate = trnsRspDate;
	}
	/**
	 * @return the trnsRspCode
	 */
	@Column(name="ATRSPCODE",nullable = false)
	@NotNull
	public Integer getTrnsRspCode() {
		return trnsRspCode;
	}
	/**
	 * @param trnsRspCode the trnsRspCode to set
	 */
	public void setTrnsRspCode(Integer trnsRspCode) {
		this.trnsRspCode = trnsRspCode;
	}
	/**
	 * @return the trnsRspMessage
	 */
	@Column(name="ATRSPMSG")
	public String getTrnsRspMessage() {
		return trnsRspMessage;
	}
	/**
	 * @param trnsRspMessage the trnsRspMessage to set
	 */
	public void setTrnsRspMessage(String trnsRspMessage) {
		this.trnsRspMessage = trnsRspMessage;
	}
	
	  
    public AuthorizerTransactionResponse clone()throws CloneNotSupportedException {
   
    	AuthorizerTransactionResponse that;
			that = (AuthorizerTransactionResponse)super.clone();
			return that;
    }
}
