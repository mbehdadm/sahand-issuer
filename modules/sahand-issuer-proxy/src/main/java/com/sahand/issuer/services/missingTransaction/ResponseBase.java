
package com.sahand.issuer.services.missingTransaction;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for responseBase complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="responseBase">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="myResponse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "responseBase", propOrder = {
    "myResponse"
})
@XmlSeeAlso({
    AuthorizerResponse.class
})
public class ResponseBase {

    protected String myResponse;

    /**
     * Gets the value of the myResponse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMyResponse() {
        return myResponse;
    }

    /**
     * Sets the value of the myResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMyResponse(String value) {
        this.myResponse = value;
    }

}
