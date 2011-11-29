package com.sahand.cms.entity;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.validator.NotNull;

@Table(name="TRNSXNRSP")
@Entity
public class TransactionResponse implements Cloneable
{
	private TransactionResponsePK pk;
	private Date trnsRspDate;
	private Integer trnsRspCode;
	private String trnsRspMessage;
	
	@EmbeddedId
	@AttributeOverrides({
		@AttributeOverride(name = "txunqid", column = @Column(name = "TXUNQID", nullable = false, precision = 6, scale = 0)),		
		@AttributeOverride(name = "txreqdt", column = @Column(name = "TXREQDT", nullable=false))})
	@NotNull
	public TransactionResponsePK getPk() {
		return pk;
	}
	/**
	 * @param pk the pk to set
	 */
	public void setPk(TransactionResponsePK pk) {
		this.pk = pk;
	}

	/**
	 * @return the trnsRspDate
	 */
	@Column(name="TXRSPDT",nullable = false)
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
	@Column(name="TXRSPCOD",nullable = false)
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
	@Column(name="TXRSPMSG")
	public String getTrnsRspMessage() {
		return trnsRspMessage;
	}
	/**
	 * @param trnsRspMessage the trnsRspMessage to set
	 */
	public void setTrnsRspMessage(String trnsRspMessage) {
		this.trnsRspMessage = trnsRspMessage;
	}
	
	  
    public TransactionResponse clone()throws CloneNotSupportedException {
   
	TransactionResponse that;
			that = (TransactionResponse)super.clone();
			return that;
    }

    
}
