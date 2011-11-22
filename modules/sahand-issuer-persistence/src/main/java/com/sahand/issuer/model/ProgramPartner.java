
package com.sahand.issuer.model;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.sahand.acquirer.model.Institute;

@Entity
@Table(name = "PROGPARTNR")
public class ProgramPartner implements Serializable
{

	@EmbeddedId
	@AttributeOverrides(
			{
				@AttributeOverride(name = "pgid", column = @Column(name = "PGID", nullable = false, precision = 6, scale = 0)),
				@AttributeOverride(name = "pttype", column = @Column(name = "PTTYPE", nullable = false, precision = 2, scale = 0)),
				@AttributeOverride(name = "isid", column = @Column(name = "ISID", nullable = false, precision = 8, scale = 0)) })
	@NotNull
	private ProgramPartnerId programPartnerId;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PGID", insertable = false, updatable = false)
	@NotNull
	private Program program;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ISID", nullable = false, insertable = false, updatable = false)
	@NotNull
	private Institute institution;
	@Column(name = "FSID", nullable = true)
	private Long feeId;

	public ProgramPartner()
	{

	}

	public ProgramPartner(ProgramPartnerId programPartnerId, Program program,
			Institute institution)
	{

		super();
		this.programPartnerId = programPartnerId;
		this.program = program;
		this.institution = institution;
	}


	public ProgramPartnerId getProgramPartnerId()
	{

		return programPartnerId;
	}

	public void setProgramPartnerId(ProgramPartnerId programPartnerId)
	{

		this.programPartnerId = programPartnerId;
	}


	public Program getProgram()
	{

		return program;
	}

	public void setProgram(Program program)
	{

		this.program = program;
	}


	public Institute getInstitution()
	{

		return institution;
	}

	public void setInstitution(Institute institution)
	{

		this.institution = institution;
	}

	/**
	 * @return the feeId
	 */
	 public Long getFeeId()
	{

		return feeId;
	}

	/**
	 * @param feeId
	 *            the feeId to set
	 */
	 public void setFeeId(Long feeId)
	 {

		 this.feeId = feeId;
	 }

	@Override
	public String toString() {
		return "ProgramPartner [programPartnerId=" + programPartnerId + "]";
	}
	 
	 


}
