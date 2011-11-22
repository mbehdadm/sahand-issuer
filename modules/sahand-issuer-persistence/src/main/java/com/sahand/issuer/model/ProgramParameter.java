
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

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "PROGPARAM")
public class ProgramParameter implements Serializable
{

	@EmbeddedId
	@AttributeOverrides(
			{
				@AttributeOverride(name = "pgid", column = @Column(name = "PGID", nullable = false, precision = 6, scale = 0)),
				@AttributeOverride(name = "pptype", column = @Column(name = "PPTYPE", nullable = false, precision = 4, scale = 0)) })
	@NotNull
	private ProgramParameterId programParameterId;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PGID", nullable = false, insertable = false, updatable = false)
	@NotNull
	private Program program;
	@Column(name = "PPVALUE", nullable = false, length = 100)
	@NotNull
	@Length(max = 100)
	private String value;
	@Column(name = "PPVLVDTYPE", nullable = false, length = 100)
	@NotNull
	private Integer valueDataType;

	public ProgramParameter()
	{

	}


	public ProgramParameterId getProgramParameterId()
	{

		return programParameterId;
	}

	public void setProgramParameterId(ProgramParameterId programParameterId)
	{

		this.programParameterId = programParameterId;
	}

	
	public Program getProgram()
	{

		return program;
	}

	public void setProgram(Program program)
	{

		this.program = program;
	}

	
	public String getValue()
	{

		return value;
	}

	public void setValue(String value)
	{

		this.value = value;
	}

	
	public Integer getValueDataType()
	{

		return valueDataType;
	}

	public void setValueDataType(Integer valueDataType)
	{

		this.valueDataType = valueDataType;
	}


	@Override
	public String toString() {
		return "ProgramParameter [programParameterId=" + programParameterId
				+ ", program=" + program + ", value=" + value
				+ ", valueDataType=" + valueDataType + "]";
	}


}
