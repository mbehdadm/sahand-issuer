
package com.sahand.issuer.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Embeddable
public class CardType2KeyId implements Serializable
{

	private String keyId;
	private Integer cardTypeId;

	public CardType2KeyId(String keyId, Integer cardTypeId)
	{

		this.keyId = keyId;
		this.cardTypeId = cardTypeId;
	}

	public CardType2KeyId()
	{

	}

	@Column(name = "KYID", nullable = false, length = 15)
	@Length(max = 15)
	@NotNull
	public String getKeyId()
	{

		return keyId;
	}

	public void setKeyId(String keyId)
	{

		this.keyId = keyId;
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

	@Override
	public int hashCode()
	{

		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((cardTypeId == null) ? 0 : cardTypeId.hashCode());
		result = prime * result + ((keyId == null) ? 0 : keyId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof CardType2KeyId))
			return false;
		CardType2KeyId other = (CardType2KeyId) obj;
		if (cardTypeId == null)
		{
			if (other.cardTypeId != null)
				return false;
		}
		else if (!cardTypeId.equals(other.cardTypeId))
			return false;
		if (keyId == null)
		{
			if (other.keyId != null)
				return false;
		}
		else if (!keyId.equals(other.keyId))
			return false;
		return true;
	}

}
