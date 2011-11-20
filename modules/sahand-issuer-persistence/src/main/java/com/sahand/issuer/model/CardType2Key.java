
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

import com.sahand.acquirer.model.Key;

@Entity
@Table(name = "CRDTYP2KEY")
public class CardType2Key implements Serializable
{

	private CardType2KeyId cardType2KeyId;
	private Key key;
	private CardType cardType;

	public CardType2Key()
	{

	}

	public CardType2Key(CardType2KeyId cardType2KeyId, Key key,
			CardType cardType)
	{

		this.cardType2KeyId = cardType2KeyId;
		this.key = key;
		this.cardType = cardType;
	}

	@EmbeddedId
	@AttributeOverrides(
			{
				@AttributeOverride(name = "kyid", column = @Column(name = "KYID", nullable = false, length = 15)),
				@AttributeOverride(name = "ctid", column = @Column(name = "CTID", nullable = false, precision = 3, scale = 0)) })
	@NotNull
	public CardType2KeyId getCardType2KeyId()
	{

		return cardType2KeyId;
	}

	public void setCardType2KeyId(CardType2KeyId cardType2KeyId)
	{

		this.cardType2KeyId = cardType2KeyId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "kyid")
	@NotNull
	public Key getKey()
	{

		return key;
	}

	public void setKey(Key key)
	{

		this.key = key;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ctid", nullable = false)
	@NotNull
	public CardType getCardType()
	{

		return cardType;
	}

	public void setCardType(CardType cardType)
	{

		this.cardType = cardType;
	}

	@Override
	public int hashCode()
	{

		if (getCardType2KeyId() != null) { return getCardType2KeyId().hashCode(); }
		return 1;
	}

	@Override
	public boolean equals(Object obj)
	{

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof CardType2Key))
			return false;
		CardType2Key other = (CardType2Key) obj;
		if (cardType == null)
		{
			if (other.cardType != null)
				return false;
		}
		else if (!cardType.equals(other.cardType))
			return false;
		if (cardType2KeyId == null)
		{
			if (other.cardType2KeyId != null)
				return false;
		}
		else if (!cardType2KeyId.equals(other.cardType2KeyId))
			return false;
		if (key == null)
		{
			if (other.key != null)
				return false;
		}
		else if (!key.equals(other.key))
			return false;
		return true;
	}

}
