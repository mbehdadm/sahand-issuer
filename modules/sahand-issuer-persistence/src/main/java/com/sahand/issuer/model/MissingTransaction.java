
package com.sahand.issuer.model;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "MISSINGTRN")
public class MissingTransaction implements java.io.Serializable, Cloneable
{
    
    private static final long serialVersionUID = 1L;
    private MissingTransactionId id;
    private Long transactionid;
    private Date transactionDate;
    private char missStatus;
    private Date missStatusDate;
    private String missPan;
    private String missCardAcceptorId;
    private String missTerminalId;
    private String missDescription;
    private Double missAmount;
    private Integer missMTI;
    private Integer missProcessCode;
    private String missProgramRefrenceData;
    private Long missProgramId;
    private Date missDateLocalTransaction;
    
    /**
     * @return the id
     */
    @EmbeddedId
    @AttributeOverrides( {
		@AttributeOverride(name = "missTransactionId", column = @Column(name = "MISTRNUNQID", nullable = false, length = 6, scale = 0)),
		@AttributeOverride(name = "missTransactionDate", column = @Column(name = "MISTRNREQDT", nullable = false)) })
    @NotNull
    public MissingTransactionId getId()
    {

	return id;
    }
    
    /**
     * @param id
     *            the id to set
     */
    public void setId(MissingTransactionId id)
    {

	this.id = id;
    }
    
    /**
     * @return the transactionid
     */
    @Column(name = "TRN_TXUNQID", nullable = true, length = 6, scale = 0)
    public Long getTransactionid()
    {

	return transactionid;
    }
    
    /**
     * @param transactionid
     *            the transactionid to set
     */
    public void setTransactionid(Long transactionid)
    {

	this.transactionid = transactionid;
    }
    
    /**
     * @return the transactionDate
     */
    @Column(name = "TRN_TXREQDT", nullable = true)
    public Date getTransactionDate()
    {

	return transactionDate;
    }
    
    /**
     * @param transactionDate
     *            the transactionDate to set
     */
    public void setTransactionDate(Date transactionDate)
    {

	this.transactionDate = transactionDate;
    }
    
    /**
     * @return the missStatus
     */
    @Column(name = "MISTRNSTS", nullable = false, length = 1)
    @NotNull
    public char getMissStatus()
    {

	return missStatus;
    }
    
    /**
     * @param missStatus
     *            the missStatus to set
     */
    public void setMissStatus(char status)
    {

	this.missStatus = status;
    }
    
    /**
     * @return the missStatusDate
     */
    @Column(name = "MISTRNSTSDT", nullable = false)
    @NotNull
    public Date getMissStatusDate()
    {

	return missStatusDate;
    }
    
    /**
     * @param missStatusDate
     *            the missStatusDate to set
     */
    public void setMissStatusDate(Date statusDate)
    {

	this.missStatusDate = statusDate;
    }
    
    /**
     * @return the missPan
     */
    @Column(name = "MISTRNPAN", nullable = false, length = 19)
    @NotNull
    public String getMissPan()
    {

	return missPan;
    }
    
    /**
     * @param missPan
     *            the missPan to set
     */
    public void setMissPan(String pan)
    {

	this.missPan = pan;
    }
    
    /**
     * @return the missCardAcceptorId
     */
    @Column(name = "MISTRNCAID", nullable = false, length = 15)
    @NotNull
    public String getMissCardAcceptorId()
    {

	return missCardAcceptorId;
    }
    
    /**
     * @param missCardAcceptorId
     *            the missCardAcceptorId to set
     */
    public void setMissCardAcceptorId(String cardAcceptorId)
    {

	this.missCardAcceptorId = cardAcceptorId;
    }
    
    /**
     * @return the missTerminalId
     */
    @Column(name = "MISTRNTERMID", nullable = true, length = 8)
    public String getMissTerminalId()
    {

	return missTerminalId;
    }
    
    /**
     * @param missTerminalId
     *            the missTerminalId to set
     */
    public void setMissTerminalId(String terminalId)
    {

	this.missTerminalId = terminalId;
    }
    
    /**
     * @return the message
     */
    @Column(name = "MISTRNDESC", nullable = true, length = 1024)
    public String getMissDescription()
    {

	return missDescription;
    }
    
    /**
     * @param message
     *            the message to set
     */
    public void setMissDescription(String message)
    {

	missDescription = message;
    }
    
    /**
     * @return the amount
     */
    @Column(name = "MISTRNAMNT", nullable = false, length = 14, scale = 2)
    @NotNull
    public Double getMissAmount()
    {

	return missAmount;
    }
    
    /**
     * @param amount
     *            the amount to set
     */
    public void setMissAmount(Double amount)
    {

	missAmount = amount;
    }
    
    /**
     * @return the mTI
     */
    @Column(name = "MISTRNMTI", nullable = false, length = 4, scale = 0)
    @NotNull
    public Integer getMissMTI()
    {

	return missMTI;
    }
    
    /**
     * @param mTI
     *            the mTI to set
     */
    public void setMissMTI(Integer mTI)
    {

	missMTI = mTI;
    }
    
    /**
     * @return the processCode
     */
    @Column(name = "MISTRNPROC", nullable = false, length = 6, scale = 0)
    @NotNull
    public Integer getMissProcessCode()
    {

	return missProcessCode;
    }
    
    /**
     * @param processCode
     *            the processCode to set
     */
    public void setMissProcessCode(Integer processCode)
    {

	missProcessCode = processCode;
    }
    
    /**
     * @return the missProgramRefrenceData
     */
    @Column(name = "MISPROGREFDATA", nullable = true, length = 1024)
    public String getMissProgramRefrenceData()
    {

	return missProgramRefrenceData;
    }
    
    /**
     * @param missProgramRefrenceData
     *            the missProgramRefrenceData to set
     */
    public void setMissProgramRefrenceData(String programRefrenceData)
    {

	this.missProgramRefrenceData = programRefrenceData;
    }
    
    /**
     * @return the missProgramId
     */
    @Column(name = "MISPROGID", nullable = false, length = 6, scale = 0)
    @NotNull
    public Long getMissProgramId()
    {

	return missProgramId;
    }
    
    /**
     * @param missProgramId
     *            the missProgramId to set
     */
    public void setMissProgramId(Long programId)
    {

	this.missProgramId = programId;
    }
    
    /**
     * @return the missDateLocalTransaction
     */
    @Column(name = "MISDTLCTRN", nullable = true)
    public Date getMissDateLocalTransaction()
    {

	return missDateLocalTransaction;
    }
    
    /**
     * @param missDateLocalTransaction
     *            the missDateLocalTransaction to set
     */
    public void setMissDateLocalTransaction(Date missDateLocalTransaction)
    {

	this.missDateLocalTransaction = missDateLocalTransaction;
    }
    
    public MissingTransaction clone() throws CloneNotSupportedException
    {

	MissingTransaction that;
	that = (MissingTransaction) super.clone();
	return that;
    }
    
}
