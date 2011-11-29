
package com.sahand.issuer.services.missingTransaction;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for programRefrences complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="programRefrences">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="factorNumber" type="{http://service.loyalty.authorizer.sahand.com/}programRefrenceSpecification" minOccurs="0"/>
 *         &lt;element name="introducerCardNumber" type="{http://service.loyalty.authorizer.sahand.com/}programRefrenceSpecification" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numOfBox" type="{http://service.loyalty.authorizer.sahand.com/}programRefrenceSpecification" minOccurs="0"/>
 *         &lt;element name="pointOfFactor" type="{http://service.loyalty.authorizer.sahand.com/}programRefrenceSpecification" minOccurs="0"/>
 *         &lt;element name="voucherNumber" type="{http://service.loyalty.authorizer.sahand.com/}programRefrenceSpecification" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "programRefrences", propOrder = {
    "code",
    "factorNumber",
    "introducerCardNumber",
    "name",
    "numOfBox",
    "pointOfFactor",
    "voucherNumber"
})
public class ProgramRefrences {

    protected String code;
    protected ProgramRefrenceSpecification factorNumber;
    protected ProgramRefrenceSpecification introducerCardNumber;
    protected String name;
    protected ProgramRefrenceSpecification numOfBox;
    protected ProgramRefrenceSpecification pointOfFactor;
    protected ProgramRefrenceSpecification voucherNumber;

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the factorNumber property.
     * 
     * @return
     *     possible object is
     *     {@link ProgramRefrenceSpecification }
     *     
     */
    public ProgramRefrenceSpecification getFactorNumber() {
        return factorNumber;
    }

    /**
     * Sets the value of the factorNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProgramRefrenceSpecification }
     *     
     */
    public void setFactorNumber(ProgramRefrenceSpecification value) {
        this.factorNumber = value;
    }

    /**
     * Gets the value of the introducerCardNumber property.
     * 
     * @return
     *     possible object is
     *     {@link ProgramRefrenceSpecification }
     *     
     */
    public ProgramRefrenceSpecification getIntroducerCardNumber() {
        return introducerCardNumber;
    }

    /**
     * Sets the value of the introducerCardNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProgramRefrenceSpecification }
     *     
     */
    public void setIntroducerCardNumber(ProgramRefrenceSpecification value) {
        this.introducerCardNumber = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the numOfBox property.
     * 
     * @return
     *     possible object is
     *     {@link ProgramRefrenceSpecification }
     *     
     */
    public ProgramRefrenceSpecification getNumOfBox() {
        return numOfBox;
    }

    /**
     * Sets the value of the numOfBox property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProgramRefrenceSpecification }
     *     
     */
    public void setNumOfBox(ProgramRefrenceSpecification value) {
        this.numOfBox = value;
    }

    /**
     * Gets the value of the pointOfFactor property.
     * 
     * @return
     *     possible object is
     *     {@link ProgramRefrenceSpecification }
     *     
     */
    public ProgramRefrenceSpecification getPointOfFactor() {
        return pointOfFactor;
    }

    /**
     * Sets the value of the pointOfFactor property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProgramRefrenceSpecification }
     *     
     */
    public void setPointOfFactor(ProgramRefrenceSpecification value) {
        this.pointOfFactor = value;
    }

    /**
     * Gets the value of the voucherNumber property.
     * 
     * @return
     *     possible object is
     *     {@link ProgramRefrenceSpecification }
     *     
     */
    public ProgramRefrenceSpecification getVoucherNumber() {
        return voucherNumber;
    }

    /**
     * Sets the value of the voucherNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProgramRefrenceSpecification }
     *     
     */
    public void setVoucherNumber(ProgramRefrenceSpecification value) {
        this.voucherNumber = value;
    }

}
