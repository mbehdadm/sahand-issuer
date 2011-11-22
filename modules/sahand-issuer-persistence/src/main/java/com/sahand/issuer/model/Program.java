
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

	@Id
	@Column(name = "PGID", unique = true, nullable = false, precision = 6, scale = 0)
	private Long id;
	@Column(name = "PGNAME", nullable = false, length = 100)
	@Length(max = 100)
	private String name;
	@Column(name = "PGDISPNAME", nullable = false, length = 100)
	@NotNull
	@Length(max = 32)
	private String displayName;
	@Column(name = "PGDESC")
	private String description;
	@Column(name = "PGRULES")
	@NotNull
	private String rules;
	@Column(name = "PGLIMITS")
	@NotNull
	private String limitation;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "program")
	private Set<ProgramParameter> programParameters = new HashSet<ProgramParameter>(0);
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "program")
	private Set<ProgramPartner> programPartners = new HashSet<ProgramPartner>(0);
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "program")
	private Set<TransactionInstalment> transactionInstalments = new HashSet<TransactionInstalment>(0);
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "program")
	private Set<CardTypeValidProgram> CardTypeValidPrograms = new HashSet<CardTypeValidProgram>(0);


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


	public Long getId()
	{

		return id;
	}

	public void setId(Long id)
	{

		this.id = id;
	}


	public String getName()
	{

		return name;
	}

	public void setName(String name)
	{

		this.name = name;
	}


	public String getDisplayName()
	{

		return displayName;
	}

	public void setDisplayName(String displayName)
	{

		this.displayName = displayName;
	}

	public Set<ProgramParameter> getProgramParameters()
	{

		return programParameters;
	}

	public void setProgramParameters(Set<ProgramParameter> programParameters)
	{

		this.programParameters = programParameters;
	}

	public Set<ProgramPartner> getProgramPartners()
	{

		return programPartners;
	}

	public void setProgramPartners(Set<ProgramPartner> programPartners)
	{

		this.programPartners = programPartners;
	}

	public Set<TransactionInstalment> getTransactionInstalments()
	{

		return transactionInstalments;
	}

	public void setTransactionInstalments(Set<TransactionInstalment> transactionInstalments)
	{

		this.transactionInstalments = transactionInstalments;
	}

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


	@Override
	public String toString() {
		return "Program [id=" + id + ", name=" + name + ", displayName="
				+ displayName + ", description=" + description + ", rules="
				+ rules + ", limitation=" + limitation + ", programParameters="
				+ programParameters + ", programPartners=" + programPartners
				+ ", transactionInstalments=" + transactionInstalments
				+ ", CardTypeValidPrograms=" + CardTypeValidPrograms + "]";
	}

}
