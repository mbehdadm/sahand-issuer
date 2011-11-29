
package com.sahand.issuer.services.missingTransaction;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for transactionData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="transactionData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="additionalAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="amountTxn" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="cardAcceptorId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dateMissingTrn" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="localMissingTrnDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="MTI" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="missingTrnId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="PAN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PINBloc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="processCode" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="programId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="refrenceData" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="responseCode" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="responseCodeEnum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="responseCodeException" type="{http://service.loyalty.authorizer.sahand.com/}responseCodeException" minOccurs="0"/>
 *         &lt;element name="terminalId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="traceNumber" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="transactionDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="transactionId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "transactionData", propOrder = {
    "additionalAmount",
    "amountTxn",
    "cardAcceptorId",
    "dateMissingTrn",
    "localMissingTrnDate",
    "mti",
    "message",
    "missingTrnId",
    "pan",
    "pinBloc",
    "processCode",
    "programId",
    "refrenceData",
    "responseCode",
    "responseCodeEnum",
    "responseCodeException",
    "terminalId",
    "traceNumber",
    "transactionDate",
    "transactionId"
})
public class TransactionData {

    protected String additionalAmount;
    protected BigDecimal amountTxn;
    protected String cardAcceptorId;
    protected XMLGregorianCalendar dateMissingTrn;
    protected XMLGregorianCalendar localMissingTrnDate;
    @XmlElement(name = "MTI")
    protected Short mti;
    protected String message;
    protected Long missingTrnId;
    @XmlElement(name = "PAN")
    protected String pan;
    @XmlElement(name = "PINBloc")
    protected String pinBloc;
    protected Long processCode;
    protected Long programId;
    protected String refrenceData;
    protected Integer responseCode;
    protected String responseCodeEnum;
    protected ResponseCodeException responseCodeException;
    protected String terminalId;
    protected Long traceNumber;
    protected XMLGregorianCalendar transactionDate;
    protected Long transactionId;

    /**
     * Gets the value of the additionalAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdditionalAmount() {
        return additionalAmount;
    }

    /**
     * Sets the value of the additionalAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdditionalAmount(String value) {
        this.additionalAmount = value;
    }

    /**
     * Gets the value of the amountTxn property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmountTxn() {
        return amountTxn;
    }

    /**
     * Sets the value of the amountTxn property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmountTxn(BigDecimal value) {
        this.amountTxn = value;
    }

    /**
     * Gets the value of the cardAcceptorId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardAcceptorId() {
        return cardAcceptorId;
    }

    /**
     * Sets the value of the cardAcceptorId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardAcceptorId(String value) {
        this.cardAcceptorId = value;
    }

    /**
     * Gets the value of the dateMissingTrn property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateMissingTrn() {
        return dateMissingTrn;
    }

    /**
     * Sets the value of the dateMissingTrn property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateMissingTrn(XMLGregorianCalendar value) {
        this.dateMissingTrn = value;
    }

    /**
     * Gets the value of the localMissingTrnDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLocalMissingTrnDate() {
        return localMissingTrnDate;
    }

    /**
     * Sets the value of the localMissingTrnDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLocalMissingTrnDate(XMLGregorianCalendar value) {
        this.localMissingTrnDate = value;
    }

    /**
     * Gets the value of the mti property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getMTI() {
        return mti;
    }

    /**
     * Sets the value of the mti property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setMTI(Short value) {
        this.mti = value;
    }

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage(String value) {
        this.message = value;
    }

    /**
     * Gets the value of the missingTrnId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMissingTrnId() {
        return missingTrnId;
    }

    /**
     * Sets the value of the missingTrnId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMissingTrnId(Long value) {
        this.missingTrnId = value;
    }

    /**
     * Gets the value of the pan property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAN() {
        return pan;
    }

    /**
     * Sets the value of the pan property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAN(String value) {
        this.pan = value;
    }

    /**
     * Gets the value of the pinBloc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPINBloc() {
        return pinBloc;
    }

    /**
     * Sets the value of the pinBloc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPINBloc(String value) {
        this.pinBloc = value;
    }

    /**
     * Gets the value of the processCode property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getProcessCode() {
        return processCode;
    }

    /**
     * Sets the value of the processCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setProcessCode(Long value) {
        this.processCode = value;
    }

    /**
     * Gets the value of the programId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getProgramId() {
        return programId;
    }

    /**
     * Sets the value of the programId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setProgramId(Long value) {
        this.programId = value;
    }

    /**
     * Gets the value of the refrenceData property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRefrenceData() {
        return refrenceData;
    }

    /**
     * Sets the value of the refrenceData property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRefrenceData(String value) {
        this.refrenceData = value;
    }

    /**
     * Gets the value of the responseCode property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getResponseCode() {
        return responseCode;
    }

    /**
     * Sets the value of the responseCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setResponseCode(Integer value) {
        this.responseCode = value;
    }

    /**
     * Gets the value of the responseCodeEnum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponseCodeEnum() {
        return responseCodeEnum;
    }

    /**
     * Sets the value of the responseCodeEnum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponseCodeEnum(String value) {
        this.responseCodeEnum = value;
    }

    /**
     * Gets the value of the responseCodeException property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseCodeException }
     *     
     */
    public ResponseCodeException getResponseCodeException() {
        return responseCodeException;
    }

    /**
     * Sets the value of the responseCodeException property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseCodeException }
     *     
     */
    public void setResponseCodeException(ResponseCodeException value) {
        this.responseCodeException = value;
    }

    /**
     * Gets the value of the terminalId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTerminalId() {
        return terminalId;
    }

    /**
     * Sets the value of the terminalId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTerminalId(String value) {
        this.terminalId = value;
    }

    /**
     * Gets the value of the traceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTraceNumber() {
        return traceNumber;
    }

    /**
     * Sets the value of the traceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTraceNumber(Long value) {
        this.traceNumber = value;
    }

    /**
     * Gets the value of the transactionDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTransactionDate() {
        return transactionDate;
    }

    /**
     * Sets the value of the transactionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTransactionDate(XMLGregorianCalendar value) {
        this.transactionDate = value;
    }

    /**
     * Gets the value of the transactionId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTransactionId() {
        return transactionId;
    }

    /**
     * Sets the value of the transactionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTransactionId(Long value) {
        this.transactionId = value;
    }

}
