
package com.sahand.issuer.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class CardTypeValidProgramId implements Serializable
{

	private Integer cardTypeId;
	private Long programId;

	public CardTypeValidProgramId()
	{

	}

	public CardTypeValidProgramId(Integer cardTypeId, Long programId)
	{

		this.cardTypeId = cardTypeId;
		this.programId = programId;
	}

	@Column(name = "CTID", nullable = false, precision = 3, scale = 0)
	@NotNull
	public Integer getCardTypeId()
	{

		return cardTypeId;
	}

	public void setCardTypeId(Integer cardTypeId)
	{

		this.cardTypeId = cardTypeId;
	}

	@Column(name = "PGID", nullable = false, precision = 6, scale = 0)
	@NotNull
	public Long getProgramId()
	{

		return programId;
	}

	public void setProgramId(Long programId)
	{

		this.programId = programId;
	}

	@Override
	public int hashCode()
	{

		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((cardTypeId == null) ? 0 : cardTypeId.hashCode());
		result = prime * result
				+ ((programId == null) ? 0 : programId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof CardTypeValidProgramId))
			return false;
		CardTypeValidProgramId other = (CardTypeValidProgramId) obj;
		if (cardTypeId == null)
		{
			if (other.cardTypeId != null)
				return false;
		}
		else if (!cardTypeId.equals(other.cardTypeId))
			return false;
		if (programId == null)
		{
			if (other.programId != null)
				return false;
		}
		else if (!programId.equals(other.programId))
			return false;
		return true;
	}

}
