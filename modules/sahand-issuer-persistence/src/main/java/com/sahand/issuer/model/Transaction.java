package com.sahand.issuer.model;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name="TRNSXN")
public class Transaction implements Serializable,Cloneable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private TransactionId transactionId;
	private Long traceNumber;
	private Integer MessageTypeIdentifier;
	private Integer processingCode;
	private String pan;
	private String AdditionalData;
	
	private Integer reversalFlag;
	private BigDecimal amount;
	private Integer currency;
	private BigDecimal settllementAmount;
	private Integer settllementCurrency;
	private String terminalId;
	private String cardAcceptorId;
	private Long acqInstitution;
	private Long fwdInstitution;
	private Integer direction;
	private String message;
	private String peerId;
	
	private Long transactionIdOut;
	private Date transactionDateOut;

	@EmbeddedId
	@AttributeOverrides({
		@AttributeOverride(name = "txunqid", column = @Column(name = "TXUNQID", nullable = false, precision = 6, scale = 0)),		
		@AttributeOverride(name = "txreqdt", column = @Column(name = "TXREQDT", nullable=false))})
//	@NotNull
	public TransactionId getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(TransactionId transactionId) {
		this.transactionId = transactionId;
		}

		
	@Column(name="TXTRACE" , unique=true  , precision=6 , scale=0)
	public Long getTraceNumber() {
		return traceNumber;
	}
	public void setTraceNumber(Long traceNumber) {
		this.traceNumber = traceNumber;
	}
	
	@Column(name="TXMTI" , unique=true , precision=4 , scale=0)
	public Integer getMessageTypeIdentifier() {
		return MessageTypeIdentifier;
	}
	public void setMessageTypeIdentifier(Integer messageTypeIdentifier) {
		MessageTypeIdentifier = messageTypeIdentifier;
	}
	
	@Column(name="TXPROCD" , unique=true  , precision=6 , scale=0)
	public Integer getProcessingCode() {
		return processingCode;
	}
	public void setProcessingCode(Integer processingCode) {
		this.processingCode = processingCode;
	}
	
	@Column(name = "TXPAN",  length = 19)
//	@Length(max = 19)
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	
	@Column(name = "TXADDATA",  length = 1000)
//	@Length(max = 1000)
	public String getAdditionalData() {
		return AdditionalData;
	}
	public void setAdditionalData(String additionalData) {
		AdditionalData = additionalData;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((AdditionalData == null) ? 0 : AdditionalData.hashCode());
		result = prime
				* result
				+ ((MessageTypeIdentifier == null) ? 0 : MessageTypeIdentifier
						.hashCode());
		result = prime * result + ((pan == null) ? 0 : pan.hashCode());
		result = prime * result
				+ ((processingCode == null) ? 0 : processingCode.hashCode());
		result = prime * result
				+ ((traceNumber == null) ? 0 : traceNumber.hashCode());
		result = prime * result
				+ ((transactionId == null) ? 0 : transactionId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Transaction))
			return false;
		Transaction other = (Transaction) obj;
		if (AdditionalData == null) {
			if (other.AdditionalData != null)
				return false;
		} else if (!AdditionalData.equals(other.AdditionalData))
			return false;
		if (MessageTypeIdentifier == null) {
			if (other.MessageTypeIdentifier != null)
				return false;
		} else if (!MessageTypeIdentifier.equals(other.MessageTypeIdentifier))
			return false;
		if (pan == null) {
			if (other.pan != null)
				return false;
		} else if (!pan.equals(other.pan))
			return false;
		if (processingCode == null) {
			if (other.processingCode != null)
				return false;
		} else if (!processingCode.equals(other.processingCode))
			return false;
		if (traceNumber == null) {
			if (other.traceNumber != null)
				return false;
		} else if (!traceNumber.equals(other.traceNumber))
			return false;
		if (transactionId == null) {
			if (other.transactionId != null)
				return false;
		} else if (!transactionId.equals(other.transactionId))
			return false;

		return true;
	}
	
	@Column(name="TXREV",nullable = true,length = 1)
	public Integer getReversalFlag() {
		return reversalFlag;
	}
	public void setReversalFlag(Integer reversalFlag) {
		this.reversalFlag = reversalFlag;
	}

	@Column(name="TXAMNT",nullable = true,length = 14, precision = 2 )
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Column(name="TXCUR",nullable= true,length =3)
	public Integer getCurrency() {
		return currency;
	}
	public void setCurrency(Integer currency) {
		this.currency = currency;
	}
	
	@Column(name="TXSTLAMNT",nullable = true,length = 14, precision = 2)
	public BigDecimal getSettllementAmount() {
		return settllementAmount;
	}
	public void setSettllementAmount(BigDecimal settllementAmount) {
		this.settllementAmount = settllementAmount;
	}
	
	@Column(name="TXSTLCUR",nullable= true,length =3)
	public Integer getSettllementCurrency() {
		return settllementCurrency;
	}
	public void setSettllementCurrency(Integer settllementCurrency) {
		this.settllementCurrency = settllementCurrency;
	}
	
	@Column(name="TXTERMID",nullable= true ,length=8)
	public String getTerminalId() {
		return terminalId;
	}
	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}
	
	@Column(name="TXCAID",nullable= true ,length=15)
	public String getCardAcceptorId() {
		return cardAcceptorId;
	}
	public void setCardAcceptorId(String cardAcceptorId) {
		this.cardAcceptorId = cardAcceptorId;
	}

	@Column(name="TXACQINST",length=6)
	public Long getAcqInstitution() {
		return acqInstitution;
	}
	public void setAcqInstitution(Long acqInstitution) {
		this.acqInstitution = acqInstitution;
	}

	@Column(name="TXFWDINST",length=6)
	public Long getFwdInstitution() {
		return fwdInstitution;
	}
	public void setFwdInstitution(Long fwdInstitution) {
		this.fwdInstitution = fwdInstitution;
	}
	
	@Column(name="TXDRCTN",nullable= false ,length=2)
	public Integer getDirection() {
		return direction;
	}
	public void setDirection(Integer direction) {
		this.direction = direction;
	}
	
	@Column(name="TXREQMSG" ,length=1024)
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	@Column(name="TXPEERID" ,length=12 )
	public String getPeerId() {
		return peerId;
	}
	public void setPeerId(String peerId) {
		this.peerId = peerId;
	}
	
    public Transaction clone() throws CloneNotSupportedException
    {

	Transaction that;
	that = (Transaction) super.clone();
	return that;
    }
    
    
    
    /**
     * @return the transactionIdOut
     */
    @Column(name = "TRN_TXUNQID", nullable = true)
    public Long getTransactionIdOut()
    {
    
        return transactionIdOut;
    }
    
    /**
     * @param transactionIdOut the transactionIdOut to set
     */
    public void setTransactionIdOut(Long transactionIdOut)
    {
    
        this.transactionIdOut = transactionIdOut;
    }
    
    /**
     * @return the transactionDateOut
     */
    @Column(name = "TRN_TXREQDT", nullable = true)
    public Date getTransactionDateOut()
    {
    
        return transactionDateOut;
    }
    
    /**
     * @param transactionDateOut the transactionDateOut to set
     */
    public void setTransactionDateOut(Date transactionDateOut)
    {
    
        this.transactionDateOut = transactionDateOut;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {

	return "Transaction [AdditionalData=" + AdditionalData + ", MessageTypeIdentifier=" + MessageTypeIdentifier + ", acqInstitution=" + acqInstitution + ", amount=" + amount + ", cardAcceptorId="
		+ cardAcceptorId + ", currency=" + currency + ", direction=" + direction + ", fwdInstitution=" + fwdInstitution + ", message=" + message + ", pan=" + pan + ", peerId=" + peerId
		+ ", processingCode=" + processingCode + ", reversalFlag=" + reversalFlag + ", settllementAmount=" + settllementAmount + ", settllementCurrency=" + settllementCurrency
		+ ", terminalId=" + terminalId + ", traceNumber=" + traceNumber + ", transactionDateOut=" + transactionDateOut + ", transactionId=" + transactionId + ", transactionIdOut="
		+ transactionIdOut + "]";
    }

}
