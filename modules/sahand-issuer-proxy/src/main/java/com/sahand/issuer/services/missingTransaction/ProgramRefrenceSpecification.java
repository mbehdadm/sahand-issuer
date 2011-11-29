
package com.sahand.issuer.services.missingTransaction;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for programRefrenceSpecification complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="programRefrenceSpecification">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="isRender" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isRequire" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "programRefrenceSpecification", propOrder = {
    "isRender",
    "isRequire"
})
public class ProgramRefrenceSpecification {

    protected String isRender;
    protected String isRequire;

    /**
     * Gets the value of the isRender property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsRender() {
        return isRender;
    }

    /**
     * Sets the value of the isRender property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsRender(String value) {
        this.isRender = value;
    }

    /**
     * Gets the value of the isRequire property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsRequire() {
        return isRequire;
    }

    /**
     * Sets the value of the isRequire property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsRequire(String value) {
        this.isRequire = value;
    }

}
