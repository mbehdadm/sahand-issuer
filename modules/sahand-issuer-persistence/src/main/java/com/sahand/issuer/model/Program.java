
package com.sahand.issuer.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "PROGRAM")
public class Program implements Serializable
{
    
    // ////////////////////////
    // /// static fields /// //
    // ////////////////////////
    
    private static final long serialVersionUID = 1L;
    
    // /////////////////
    // /// fields /// //
    // /////////////////
    
    private Long id;
    private String name;
    private String displayName;
    private String description;
    private String rules;
    private String limitation;
    private Set<ProgramParameter> programParameters = new HashSet<ProgramParameter>(0);
    private Set<ProgramPartner> programPartners = new HashSet<ProgramPartner>(0);
    private Set<TransactionInstalment> transactionInstalments = new HashSet<TransactionInstalment>(0);
    private Set<CardTypeValidProgram> CardTypeValidPrograms = new HashSet<CardTypeValidProgram>(0);
    
    // //////////////////////
    // /// Constructor /// //
    // //////////////////////
    
    public Program()
    {

    }
    
    public Program(Long id, String name, String displayName, Set<ProgramParameter> programParameters, Set<ProgramPartner> programPartners, Set<TransactionInstalment> transactionInstalments,
	    Set<CardTypeValidProgram> cardTypeValidPrograms)
    {

	this.id = id;
	this.name = name;
	this.displayName = displayName;
	this.programParameters = programParameters;
	this.programPartners = programPartners;
	this.transactionInstalments = transactionInstalments;
	CardTypeValidPrograms = cardTypeValidPrograms;
    }
    
    // //////////////////////////////
    // /// Setters and Getters /// //
    // //////////////////////////////
    
    @Id
    @Column(name = "PGID", unique = true, nullable = false, precision = 6, scale = 0)
    public Long getId()
    {

	return id;
    }
    
    public void setId(Long id)
    {

	this.id = id;
    }
    
    @Column(name = "PGNAME", nullable = false, length = 100)
    @NotNull
    @Length(max = 100)
    public String getName()
    {

	return name;
    }
    
    public void setName(String name)
    {

	this.name = name;
    }
    
    @Column(name = "PGDISPNAME", nullable = false, length = 100)
    @NotNull
    @Length(max = 32)
    public String getDisplayName()
    {

	return displayName;
    }
    
    public void setDisplayName(String displayName)
    {

	this.displayName = displayName;
    }
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "program")
    public Set<ProgramParameter> getProgramParameters()
    {

	return programParameters;
    }
    
    public void setProgramParameters(Set<ProgramParameter> programParameters)
    {

	this.programParameters = programParameters;
    }
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "program")
    public Set<ProgramPartner> getProgramPartners()
    {

	return programPartners;
    }
    
    public void setProgramPartners(Set<ProgramPartner> programPartners)
    {

	this.programPartners = programPartners;
    }
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "program")
    public Set<TransactionInstalment> getTransactionInstalments()
    {

	return transactionInstalments;
    }
    
    public void setTransactionInstalments(Set<TransactionInstalment> transactionInstalments)
    {

	this.transactionInstalments = transactionInstalments;
    }
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "program")
    public Set<CardTypeValidProgram> getCardTypeValidPrograms()
    {

	return CardTypeValidPrograms;
    }
    
    public void setCardTypeValidPrograms(Set<CardTypeValidProgram> cardTypeValidPrograms)
    {

	CardTypeValidPrograms = cardTypeValidPrograms;
    }
    
    /**
     * @return the description
     */
    @Column(name = "PGDESC")
    public String getDescription()
    {

	return description;
    }
    
    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description)
    {

	this.description = description;
    }
    
    /**
     * @return the rules
     */
    @Column(name = "PGRULES")
    @NotNull
    public String getRules()
    {

	return rules;
    }
    
    /**
     * @param rules
     *            the rules to set
     */
    public void setRules(String rules)
    {

	this.rules = rules;
    }
    
    /**
     * @return the limitation
     */
    @Column(name = "PGLIMITS")
    @NotNull
    public String getLimitation()
    {

	return limitation;
    }
    
    /**
     * @param limitation
     *            the limitation to set
     */
    public void setLimitation(String limitation)
    {

	this.limitation = limitation;
    }
    
    // ////////////////////
    // /// to String /// //
    // ////////////////////
    
    @Override
    public String toString()
    {

	return "Program [id=" + id + ", name=" + name + "]";
    }
    
}
