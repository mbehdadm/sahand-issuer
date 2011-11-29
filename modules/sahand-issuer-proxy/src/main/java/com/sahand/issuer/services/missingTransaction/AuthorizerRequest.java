package com.sahand.issuer.services.missingTransaction;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for authorizerRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="authorizerRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="msg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pinData" type="{http://service.loyalty.authorizer.sahand.com/}changePinData" minOccurs="0"/>
 *         &lt;element name="trnasactionData" type="{http://service.loyalty.authorizer.sahand.com/}transactionData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "authorizerRequest", propOrder = {
    "msg",
    "pinData",
    "trnasactionData"
})
public class AuthorizerRequest {

    protected String msg;
    protected ChangePinData pinData;
    protected TransactionData trnasactionData;

    /**
     * Gets the value of the msg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsg() {
        return msg;
    }

    /**
     * Sets the value of the msg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsg(String value) {
        this.msg = value;
    }

    /**
     * Gets the value of the pinData property.
     * 
     * @return
     *     possible object is
     *     {@link ChangePinData }
     *     
     */
    public ChangePinData getPinData() {
        return pinData;
    }

    /**
     * Sets the value of the pinData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChangePinData }
     *     
     */
    public void setPinData(ChangePinData value) {
        this.pinData = value;
    }

    /**
     * Gets the value of the trnasactionData property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionData }
     *     
     */
    public TransactionData getTrnasactionData() {
        return trnasactionData;
    }

    /**
     * Sets the value of the trnasactionData property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionData }
     *     
     */
    public void setTrnasactionData(TransactionData value) {
        this.trnasactionData = value;
    }

}
