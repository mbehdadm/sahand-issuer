
package com.sahand.issuer.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "MEMBRCARD")
public class MemberCard implements Serializable
{
	@Id
    @Column(name = "MCPAN", unique = true, nullable = false, length = 19)
    @Length(max = 19)
    @NotNull
    private String pan;
	@Column(name = "MCFLRLMT", precision = 14)
    private BigDecimal floorLimit;
	@Column(name = "MCOTB", precision = 14)
    private BigDecimal openToBuy;
	@Column(name = "MCSTS", nullable = false, precision = 2, scale = 0)
    @NotNull
    private Byte status;
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MCSTSDT", nullable = false)
    private Date statusDate;
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MCISSDT", nullable = false)
    private Date issueDate;
    @Temporal(TemporalType.DATE)
    @Column(name = "MCEXPDT", length = 7)
    private Date expirationDate;
    @Column(name = "MCPANCVV", nullable = false, length = 3)
    @Length(max = 3)
    @NotNull
    private String panCvv;
    @Column(name = "MCPINBLK")
    private byte[] pinBlock;
    @Column(name = "MCPANPVV", length = 4)
    @Length(max = 4)
    private String panPvv;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MCCYCLBDT")
    private Date cycleBeginDate;
    @Column(name = "MCCYCLEN", precision = 2, scale = 0)
    private Byte cycleLength;
    @Column(name = "MCSRVCD", precision = 3, scale = 0)
    private Integer serviceCode;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MMID", nullable = false)
    @NotNull
    private Members member;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CTID", nullable = false)
    @NotNull
    private CardType cardType;
    @Column(name = "MCSTSRSN", nullable = false, precision = 2, scale = 0)
    @NotNull
    private Byte statusReason;
    @Column(name = "MCLSTRNDT", nullable = false)
    private Date lastTransactionDate;
    @Column(name = "MCISURSN", nullable = false, precision = 2, scale = 0)
    @NotNull
    private Byte issueReason;
    @Column(name = "MCTRACK1", length = 79)
    @Length(max = 70)
    private String track1;
    @Column(name = "MCTRACK2", length = 40)
    @Length(max = 40)
    private String track2;
    @Column(name = "MCTRACK3", length = 107)
    @Length(max = 107)
    private String track3;
    
    // //////////////////////////////
    // /// Setters and Getters /// //
    // //////////////////////////////
    
    
    public String getPan()
    {

	return pan;
    }
    
    public void setPan(String pan)
    {

	this.pan = pan;
    }
    
    
    public BigDecimal getFloorLimit()
    {

	return floorLimit;
    }
    
    public void setFloorLimit(BigDecimal floorLimit)
    {

	this.floorLimit = floorLimit;
    }
    
    
    public BigDecimal getOpenToBuy()
    {

	return openToBuy;
    }
    
    public void setOpenToBuy(BigDecimal openToBuy)
    {

	this.openToBuy = openToBuy;
    }
    
    
    public Byte getStatus()
    {

	return status;
    }
    
   
    public Date getStatusDate()
    {

	return statusDate;
    }
    
    public void setStatusDate(Date statusDate)
    {

	this.statusDate = statusDate;
    }
    
   
    public Date getIssueDate()
    {

	return issueDate;
    }
    
    public void setIssueDate(Date issueDate)
    {

	this.issueDate = issueDate;
    }
    
 
    public Date getExpirationDate()
    {

	return expirationDate;
    }
    
    public void setExpirationDate(Date expirationDate)
    {

	this.expirationDate = expirationDate;
    }
    

    public String getPanCvv()
    {

	return panCvv;
    }
    
    public void setPanCvv(String panCvv)
    {

	this.panCvv = panCvv;
    }
    
   
    public byte[] getPinBlock()
    {

	return pinBlock;
    }
    
    public void setPinBlock(byte[] pinBlock)
    {

	this.pinBlock = pinBlock;
    }
    

    public String getPanPvv()
    {

	return panPvv;
    }
    
    public void setPanPvv(String panPvv)
    {

	this.panPvv = panPvv;
    }
    
 
    public Date getCycleBeginDate()
    {

	return cycleBeginDate;
    }
    
    public void setCycleBeginDate(Date cyclebeginDate)
    {

	this.cycleBeginDate = cyclebeginDate;
    }
    
    public Byte getCycleLength()
    {

	return cycleLength;
    }
    
    public void setCycleLength(Byte cycleLength)
    {

	this.cycleLength = cycleLength;
    }
    
    public Integer getServiceCode()
    {

	return serviceCode;
    }
    
    public void setServiceCode(Integer serviceCode)
    {

	this.serviceCode = serviceCode;
    }
    

    public Byte getStatusReason()
    {

	return statusReason;
    }
    

    public Byte getIssueReason()
    {

	return issueReason;
    }
    
   
    public String getTrack1()
    {

	return track1;
    }
    
    public void setTrack1(String track1)
    {

	this.track1 = track1;
    }
    
  
    public String getTrack2()
    {

	return track2;
    }
    
    public void setTrack2(String track2)
    {

	this.track2 = track2;
    }
    
   
    public String getTrack3()
    {

	return track3;
    }
    
    public void setTrack3(String track3)
    {

	this.track3 = track3;
    }
    
   
    public Members getMember()
    {

	return member;
    }
    
    public void setMember(Members member)
    {

	this.member = member;
    }
    
    
    public CardType getCardType()
    {

	return cardType;
    }
    
    public void setCardType(CardType cardType)
    {

	this.cardType = cardType;
    }
    
    /**
     * @return the lastTransactionDate
     */
    public Date getLastTransactionDate()
    {

	return lastTransactionDate;
    }
    
    /**
     * @param lastTransactionDate
     *            the lastTransactionDate to set
     */
    public void setLastTransactionDate(Date lastTransactionDate)
    {

	this.lastTransactionDate = lastTransactionDate;
    }
    
    /**
     * @param status
     *            the status to set
     */
    public void setStatus(Byte status)
    {

	this.status = status;
    }
    
    /**
     * @param statusReason
     *            the statusReason to set
     */
    public void setStatusReason(Byte statusReason)
    {

	this.statusReason = statusReason;
    }
    
    /**
     * @param issueReason
     *            the issueReason to set
     */
    public void setIssueReason(Byte issueReason)
    {

	this.issueReason = issueReason;
    }
    
    // ///////////////////
    // /// Override /// //
    // ///////////////////
    
    @Override
    public int hashCode()
    {

	if (getPan() != null) { return getPan().hashCode(); }
	return 1;
    }
    
    @Override
    public boolean equals(Object obj)
    {

	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (!(obj instanceof MemberCard))
	    return false;
	MemberCard other = (MemberCard) obj;
	if (issueDate == null)
	{
	    if (other.issueDate != null)
		return false;
	} else if (!issueDate.equals(other.issueDate))
	    return false;
	/*
	 * if (cardStatements == null) { if (other.cardStatements != null)
	 * return false; } else if
	 * (!cardStatements.equals(other.cardStatements)) return false;
	 */
	if (cardType == null)
	{
	    if (other.cardType != null)
		return false;
	} else if (!cardType.equals(other.cardType))
	    return false;
	if (cycleLength == null)
	{
	    if (other.cycleLength != null)
		return false;
	} else if (!cycleLength.equals(other.cycleLength))
	    return false;
	if (cycleBeginDate == null)
	{
	    if (other.cycleBeginDate != null)
		return false;
	} else if (!cycleBeginDate.equals(other.cycleBeginDate))
	    return false;
	if (expirationDate == null)
	{
	    if (other.expirationDate != null)
		return false;
	} else if (!expirationDate.equals(other.expirationDate))
	    return false;
	if (floorLimit == null)
	{
	    if (other.floorLimit != null)
		return false;
	} else if (!floorLimit.equals(other.floorLimit))
	    return false;
	if (member == null)
	{
	    if (other.member != null)
		return false;
	} else if (!member.equals(other.member))
	    return false;
	if (openToBuy == null)
	{
	    if (other.openToBuy != null)
		return false;
	} else if (!openToBuy.equals(other.openToBuy))
	    return false;
	if (pan == null)
	{
	    if (other.pan != null)
		return false;
	} else if (!pan.equals(other.pan))
	    return false;
	if (panCvv == null)
	{
	    if (other.panCvv != null)
		return false;
	} else if (!panCvv.equals(other.panCvv))
	    return false;
	if (panPvv == null)
	{
	    if (other.panPvv != null)
		return false;
	} else if (!panPvv.equals(other.panPvv))
	    return false;
	if (pinBlock == null)
	{
	    if (other.pinBlock != null)
		return false;
	} else if (!pinBlock.equals(other.pinBlock))
	    return false;
	if (serviceCode == null)
	{
	    if (other.serviceCode != null)
		return false;
	} else if (!serviceCode.equals(other.serviceCode))
	    return false;
	if (status == null)
	{
	    if (other.status != null)
		return false;
	} else if (!status.equals(other.status))
	    return false;
	if (statusReason == null)
	{
	    if (other.statusReason != null)
		return false;
	} else if (!statusReason.equals(other.statusReason))
	    return false;
	if (issueReason == null)
	{
	    if (other.issueReason != null)
		return false;
	} else if (!issueReason.equals(other.issueReason))
	    return false;
	if (statusDate == null)
	{
	    if (other.statusDate != null)
		return false;
	} else if (!statusDate.equals(other.statusDate))
	    return false;
	return true;
    }
    
    // ////////////////////
    // /// to String /// //
    // ////////////////////
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString(){
    	return "MemberCard [member=" + member + ", pan=" + pan + "]";
    }
    
}
