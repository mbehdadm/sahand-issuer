
package com.sahand.issuer.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "CARDSTMT")
public class CardStatement implements Serializable
{

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	@AttributeOverrides(
			{
				@AttributeOverride(name = "csid", column = @Column(name = "CSID", nullable = false, precision = 8, scale = 0)),
				@AttributeOverride(name = "csissdt", column = @Column(name = "CSISSDT", nullable = false, precision = 4, scale = 0)) })
	private CardStatementId cardStatementId;
	@Column(name = "CSSTS", nullable = false, precision = 2, scale = 0)
	private Byte status;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CDSTSDT", nullable = false, length = 7)
	private Date statusDate;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CSSTLDT", length = 7)
	private Date setEllementDate;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MCPAN", nullable = false)
	@NotNull
	private MemberCard memberCard;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cardStatement")
	private Set<CardStatementItem> CardStatementItems = new HashSet<CardStatementItem>(0);

	public CardStatement()
	{

	}

	
	public CardStatementId getCardStatementId()
	{

		return cardStatementId;
	}

	public void setCardStatementId(CardStatementId cardStatementId)
	{

		this.cardStatementId = cardStatementId;
	}

	
	public Byte getStatus()
	{

		return status;
	}

	public void setStatus(Byte status)
	{

		this.status = status;
	}

	
	public Date getStatusDate()
	{

		return statusDate;
	}

	public void setStatusDate(Date statusDate)
	{

		this.statusDate = statusDate;
	}

	
	public Date getSetEllementDate()
	{

		return setEllementDate;
	}

	public void setSetEllementDate(Date setEllementDate)
	{

		this.setEllementDate = setEllementDate;
	}

	
	public MemberCard getMemberCard()
	{

		return memberCard;
	}

	public void setMemberCard(MemberCard memberCard)
	{

		this.memberCard = memberCard;
	}

	public Set<CardStatementItem> getCardStatementItems()
	{

		return CardStatementItems;
	}

	public void setCardStatementItems(Set<CardStatementItem> cardStatementItems)
	{

		CardStatementItems = cardStatementItems;
	}

	@Override
	public int hashCode()
	{

		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((CardStatementItems == null) ? 0 : CardStatementItems
						.hashCode());
		result = prime * result
				+ ((cardStatementId == null) ? 0 : cardStatementId.hashCode());
		result = prime * result
				+ ((memberCard == null) ? 0 : memberCard.hashCode());
		result = prime * result
				+ ((setEllementDate == null) ? 0 : setEllementDate.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result
				+ ((statusDate == null) ? 0 : statusDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof CardStatement))
			return false;
		CardStatement other = (CardStatement) obj;
		if (CardStatementItems == null)
		{
			if (other.CardStatementItems != null)
				return false;
		}
		else if (!CardStatementItems.equals(other.CardStatementItems))
			return false;
		if (cardStatementId == null)
		{
			if (other.cardStatementId != null)
				return false;
		}
		else if (!cardStatementId.equals(other.cardStatementId))
			return false;
		if (memberCard == null)
		{
			if (other.memberCard != null)
				return false;
		}
		else if (!memberCard.equals(other.memberCard))
			return false;
		if (setEllementDate == null)
		{
			if (other.setEllementDate != null)
				return false;
		}
		else if (!setEllementDate.equals(other.setEllementDate))
			return false;
		if (status == null)
		{
			if (other.status != null)
				return false;
		}
		else if (!status.equals(other.status))
			return false;
		if (statusDate == null)
		{
			if (other.statusDate != null)
				return false;
		}
		else if (!statusDate.equals(other.statusDate))
			return false;
		return true;
	}

}
