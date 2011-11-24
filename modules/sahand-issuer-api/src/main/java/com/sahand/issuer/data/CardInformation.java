package com.sahand.issuer.data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

public class CardInformation implements Serializable {

	private String pan;
	private BigDecimal floorLimit;
	private BigDecimal openToBuy;
	private Byte status;
	private Date statusDate;
	private Date issueDate;
	private Date expirationDate;
	private String panCvv;
	private byte[] pinBlock;
	private String panPvv;
	private Date cycleBeginDate;
	private Byte cycleLength;
	private Integer serviceCode;
	private Byte statusReason;
	private Date lastTransactionDate;
	private Byte issueReason;
	private String track1;
	private String track2;
	private String track3;
	//generate type
	private boolean autoGenerate;
	
	
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public BigDecimal getFloorLimit() {
		return floorLimit;
	}
	public void setFloorLimit(BigDecimal floorLimit) {
		this.floorLimit = floorLimit;
	}
	public BigDecimal getOpenToBuy() {
		return openToBuy;
	}
	public void setOpenToBuy(BigDecimal openToBuy) {
		this.openToBuy = openToBuy;
	}
	public Byte getStatus() {
		return status;
	}
	public void setStatus(Byte status) {
		this.status = status;
	}
	public Date getStatusDate() {
		return statusDate;
	}
	public void setStatusDate(Date statusDate) {
		this.statusDate = statusDate;
	}
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getPanCvv() {
		return panCvv;
	}
	public void setPanCvv(String panCvv) {
		this.panCvv = panCvv;
	}
	public byte[] getPinBlock() {
		return pinBlock;
	}
	public void setPinBlock(byte[] pinBlock) {
		this.pinBlock = pinBlock;
	}
	public String getPanPvv() {
		return panPvv;
	}
	public void setPanPvv(String panPvv) {
		this.panPvv = panPvv;
	}
	public Date getCycleBeginDate() {
		return cycleBeginDate;
	}
	public void setCycleBeginDate(Date cycleBeginDate) {
		this.cycleBeginDate = cycleBeginDate;
	}
	public Byte getCycleLength() {
		return cycleLength;
	}
	public void setCycleLength(Byte cycleLength) {
		this.cycleLength = cycleLength;
	}
	public Integer getServiceCode() {
		return serviceCode;
	}
	public void setServiceCode(Integer serviceCode) {
		this.serviceCode = serviceCode;
	}
	public Byte getStatusReason() {
		return statusReason;
	}
	public void setStatusReason(Byte statusReason) {
		this.statusReason = statusReason;
	}
	public Date getLastTransactionDate() {
		return lastTransactionDate;
	}
	public void setLastTransactionDate(Date lastTransactionDate) {
		this.lastTransactionDate = lastTransactionDate;
	}
	public Byte getIssueReason() {
		return issueReason;
	}
	public void setIssueReason(Byte issueReason) {
		this.issueReason = issueReason;
	}
	public String getTrack1() {
		return track1;
	}
	public void setTrack1(String track1) {
		this.track1 = track1;
	}
	public String getTrack2() {
		return track2;
	}
	public void setTrack2(String track2) {
		this.track2 = track2;
	}
	public String getTrack3() {
		return track3;
	}
	public void setTrack3(String track3) {
		this.track3 = track3;
	}
	
	public boolean isAutoGenerate() {
		return autoGenerate;
	}
	public void setAutoGenerate(boolean autoGenerate) {
		this.autoGenerate = autoGenerate;
	}
	@Override
	public String toString() {
		return "CardInformation [pan=" + pan + ", floorLimit=" + floorLimit
				+ ", openToBuy=" + openToBuy + ", status=" + status
				+ ", statusDate=" + statusDate + ", issueDate=" + issueDate
				+ ", expirationDate=" + expirationDate + ", panCvv=" + panCvv
				+ ", pinBlock=" + Arrays.toString(pinBlock) + ", panPvv="
				+ panPvv + ", cycleBeginDate=" + cycleBeginDate
				+ ", cycleLength=" + cycleLength + ", serviceCode="
				+ serviceCode + ", statusReason=" + statusReason
				+ ", lastTransactionDate=" + lastTransactionDate
				+ ", issueReason=" + issueReason + ", track1=" + track1
				+ ", track2=" + track2 + ", track3=" + track3
				+ ", autoGenerate=" + autoGenerate + "]";
	}




}
