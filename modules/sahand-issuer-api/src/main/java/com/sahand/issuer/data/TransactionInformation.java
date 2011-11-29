package com.sahand.issuer.data;

import java.math.BigDecimal;
import java.util.Date;

public class TransactionInformation {



	private Date dateMissingTrn;
	
	private Date transactionDate;
	
	private Long transactionId;
	
	private Short MTI;

	private String PAN;

	private Long processCode;

	private BigDecimal amountTxn;

	private String PINBloc;

	private Long programId;
	
	private String refrenceData;
	
	private String terminalId;
	
	private Long traceNumber;
	
	private String cardAcceptorId;
	
	private Date LocalMissingTrnDate;
	
	private String additionalAmount;
	
	private String responseCodeEnum;
	
	private Integer responseCode;
	
//	private com.sahand.cms.enumeration.ResponseCodeException ResponseCodeException;
	
	private String message;
	
	/**
	 * @return the mTI
	 */
	public Short getMTI() {
		return MTI;
	}

	/**
	 * @param mTI the mTI to set
	 */
	public void setMTI(Short mTI) {
		MTI = mTI;
	}

	/**
	 * @return the pAN
	 */
	public String getPAN() {
		return PAN;
	}

	/**
	 * @param pAN the pAN to set
	 */
	public void setPAN(String pAN) {
		PAN = pAN;
	}

	/**
	 * @return the processCode
	 */
	public Long getProcessCode() {
		return processCode;
	}

	/**
	 * @param processCode the processCode to set
	 */
	public void setProcessCode(Long processCode) {
		this.processCode = processCode;
	}

	/**
	 * @return the amountTxn
	 */
	public BigDecimal getAmountTxn() {
		return amountTxn;
	}

	/**
	 * @param amountTxn the amountTxn to set
	 */
	public void setAmountTxn(BigDecimal amountTxn) {
		this.amountTxn = amountTxn;
	}

	/**
	 * @return the pINBloc
	 */
	public String getPINBloc() {
		return PINBloc;
	}

	/**
	 * @param pINBloc the pINBloc to set
	 */
	public void setPINBloc(String pINBloc) {
		PINBloc = pINBloc;
	}

	/**
	 * @return the programId
	 */
	public Long getProgramId() {
		return programId;
	}

	/**
	 * @param programId the programId to set
	 */
	public void setProgramId(Long programId) {
		this.programId = programId;
	}

	/**
	 * @return the refrenceData
	 */
	public String getRefrenceData() {
		return refrenceData;
	}

	/**
	 * @param refrenceData the refrenceData to set
	 */
	public void setRefrenceData(String refrenceData) {
		this.refrenceData = refrenceData;
	}

	/**
	 * @return the terminalId
	 */
	public String getTerminalId() {
		return terminalId;
	}

	/**
	 * @param terminalId the terminalId to set
	 */
	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	/**
	 * @return the traceNumber
	 */
	public Long getTraceNumber() {
		return traceNumber;
	}

	/**
	 * @param traceNumber the traceNumber to set
	 */
	public void setTraceNumber(Long traceNumber) {
		this.traceNumber = traceNumber;
	}

	/**
	 * @return the cardAcceptorId
	 */
	public String getCardAcceptorId() {
		return cardAcceptorId;
	}

	/**
	 * @param cardAcceptorId the cardAcceptorId to set
	 */
	public void setCardAcceptorId(String cardAcceptorId) {
		this.cardAcceptorId = cardAcceptorId;
	}

	/**
	 * @return the dateMissingTrn
	 */
	public Date getDateMissingTrn() {
		return dateMissingTrn;
	}

	/**
	 * @param dateMissingTrn the dateMissingTrn to set
	 */
	public void setDateMissingTrn(Date dateTrn) {
		this.dateMissingTrn = dateTrn;
	}

	/**
	 * @return the additionalAmount
	 */
	public String getAdditionalAmount() {
		return additionalAmount;
	}

	/**
	 * @param additionalAmount the additionalAmount to set
	 */
	public void setAdditionalAmount(String additionalAmount) {
		this.additionalAmount = additionalAmount;
	}

	/**
	 * @return the responseCodeEnum
	 */
	public String getResponseCodeEnum() {
		return responseCodeEnum;
	}

	/**
	 * @param responseCodeEnum the responseCodeEnum to set
	 */
	public void setResponseCodeEnum(String responseCodeEnum) {
		this.responseCodeEnum = responseCodeEnum;
	}

	/**
	 * @return the responseCode
	 */
	public Integer getResponseCode() {
		return responseCode;
	}

	/**
	 * @param responseCode the responseCode to set
	 */
	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the transactionDate
	 */
	public Date getTransactionDate() {
		return transactionDate;
	}

	/**
	 * @param transactionDate the transactionDate to set
	 */
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	/**
	 * @return the transactionId
	 */
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
	 * @return the localMissingTrnDate
	 */
	public Date getLocalMissingTrnDate() {
		return LocalMissingTrnDate;
	}

	/**
	 * @param localMissingTrnDate the localMissingTrnDate to set
	 */
	public void setLocalMissingTrnDate(Date localMissingTrnDate) {
		LocalMissingTrnDate = localMissingTrnDate;
	}

}
