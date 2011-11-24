
package com.sahand.issuer.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.sahand.acquirer.model.Institute;

@Entity
@Table(name = "CARDTYPE")
public class CardType implements Serializable
{
	@Id
	@Column(name = "CTID", unique = true, nullable = false, precision = 3, scale = 0)
	@NotNull
	private Integer id;
	@Column(name = "CTPANFMT", unique = true, nullable = true, length = 30)
	private String panFormat;
	@Column(name = "CTPINENC", nullable = false, precision = 2, scale = 0)
	@NotNull
	private Byte pinEncrytion;
	@Column(name = "CTPINFMT", nullable = false, precision = 2, scale = 0)
	@NotNull
	private Byte pinFormat;
	@Column(name = "CTAUTHORIZ", nullable = true, precision = 2, scale = 0)
	private Byte authorization;
	@Column(name = "CTAUTHENT", nullable = true, precision = 2, scale = 0)
	private Byte authentication;
	@Column(name = "CTAPP", nullable = false, precision = 8, scale = 0)
	@NotNull
	private Integer application;
	@Column(name = "CTDEFSRVCD", nullable = false, precision = 3, scale = 0)
	@NotNull
	private Short defaultServiceCode;
	@Column(name = "CTTRKFMT", nullable = false, precision = 2, scale = 0)
	@NotNull
	private Byte trackDataFormat;
	@Column(name = "CTDESC", unique = true, nullable = false, length = 30)
	@NotNull
	private String description;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ISID", nullable = false)
	@NotNull
	private Institute institution;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cardType")
	private Set<CardType2Key> cardType2Keys = new HashSet<CardType2Key>(0);
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cardType")
	private Set<MemberCard> memberCard = new HashSet<MemberCard>(0);
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cardType")
	private Set<CardTypeValidProgram> cardTypeValidPrograms = new HashSet<CardTypeValidProgram>(0);

	public CardType()
	{

	}

	public CardType(Integer id, String panFormat, Byte pinEncrytion,
			Byte pinFormat, Byte authorization, Byte authentication,
			Integer application, Short defaultServiceCode,
			Byte trackDataFormat, String description, Institute institution,
			Set<CardType2Key> cardType2Keys, Set<MemberCard> memberCard,
			Set<CardTypeValidProgram> cardTypeValidPrograms)
	{

		super();
		this.id = id;
		this.panFormat = panFormat;
		this.pinEncrytion = pinEncrytion;
		this.pinFormat = pinFormat;
		this.authorization = authorization;
		this.authentication = authentication;
		this.application = application;
		this.defaultServiceCode = defaultServiceCode;
		this.trackDataFormat = trackDataFormat;
		this.description = description;
		this.institution = institution;
		this.cardType2Keys = cardType2Keys;
		this.memberCard = memberCard;
		this.cardTypeValidPrograms = cardTypeValidPrograms;
	}

	
	public Integer getId()
	{

		return id;
	}

	public void setId(Integer id)
	{

		this.id = id;
	}

	public String getPanFormat()
	{

		return panFormat;
	}

	public void setPanFormat(String panFormat)
	{

		this.panFormat = panFormat;
	}


	public Byte getPinEncrytion()
	{

		return pinEncrytion;
	}

	public void setPinEncrytion(Byte pinEncrytion)
	{

		this.pinEncrytion = pinEncrytion;
	}

	
	public Byte getPinFormat()
	{

		return pinFormat;
	}

	public void setPinFormat(Byte pinFormat)
	{

		this.pinFormat = pinFormat;
	}

	public Byte getAuthorization()
	{

		return authorization;
	}

	public void setAuthorization(Byte authorization)
	{

		this.authorization = authorization;
	}

	public Byte getAuthentication()
	{

		return authentication;
	}

	public void setAuthentication(Byte authentication)
	{

		this.authentication = authentication;
	}


	public Integer getApplication()
	{

		return application;
	}

	public void setApplication(Integer aplication)
	{

		this.application = aplication;
	}


	public Short getDefaultServiceCode()
	{

		return defaultServiceCode;
	}

	public void setDefaultServiceCode(Short defaultServiceCode)
	{

		this.defaultServiceCode = defaultServiceCode;
	}


	public Byte getTrackDataFormat()
	{

		return trackDataFormat;
	}

	public void setTrackDataFormat(Byte trackDataFormat)
	{

		this.trackDataFormat = trackDataFormat;
	}


	public String getDescription()
	{

		return description;
	}

	public void setDescription(String description)
	{

		this.description = description;
	}


	public Institute getInstitution()
	{

		return institution;
	}

	public void setInstitution(Institute institution)
	{

		this.institution = institution;
	}

	public Set<CardType2Key> getCardType2Keys()
	{

		return cardType2Keys;
	}

	public void setCardType2Keys(Set<CardType2Key> cardType2Keys)
	{

		this.cardType2Keys = cardType2Keys;
	}

	public Set<MemberCard> getMemberCard()
	{

		return memberCard;
	}

	public void setMemberCard(Set<MemberCard> memberCard)
	{

		this.memberCard = memberCard;
	}

	public Set<CardTypeValidProgram> getCardTypeValidPrograms()
	{

		return cardTypeValidPrograms;
	}

	public void setCardTypeValidPrograms(
			Set<CardTypeValidProgram> cardTypeValidPrograms)
	{

		this.cardTypeValidPrograms = cardTypeValidPrograms;
	}

	@Override
	public int hashCode()
	{

		if (getId() != null) { return getId().hashCode(); }
		return 1;
	}

	@Override
	public boolean equals(Object obj)
	{

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof CardType))
			return false;
		CardType other = (CardType) obj;
		if (application == null)
		{
			if (other.application != null)
				return false;
		}
		else if (!application.equals(other.application))
			return false;
		if (authentication == null)
		{
			if (other.authentication != null)
				return false;
		}
		else if (!authentication.equals(other.authentication))
			return false;
		if (authorization == null)
		{
			if (other.authorization != null)
				return false;
		}
		else if (!authorization.equals(other.authorization))
			return false;
		if (cardType2Keys == null)
		{
			if (other.cardType2Keys != null)
				return false;
		}
		else if (!cardType2Keys.equals(other.cardType2Keys))
			return false;
		if (cardTypeValidPrograms == null)
		{
			if (other.cardTypeValidPrograms != null)
				return false;
		}
		else if (!cardTypeValidPrograms.equals(other.cardTypeValidPrograms))
			return false;
		if (defaultServiceCode == null)
		{
			if (other.defaultServiceCode != null)
				return false;
		}
		else if (!defaultServiceCode.equals(other.defaultServiceCode))
			return false;
		if (description == null)
		{
			if (other.description != null)
				return false;
		}
		else if (!description.equals(other.description))
			return false;
		if (id == null)
		{
			if (other.id != null)
				return false;
		}
		else if (!id.equals(other.id))
			return false;
		if (institution == null)
		{
			if (other.institution != null)
				return false;
		}
		else if (!institution.equals(other.institution))
			return false;
		if (memberCard == null)
		{
			if (other.memberCard != null)
				return false;
		}
		else if (!memberCard.equals(other.memberCard))
			return false;
		if (panFormat == null)
		{
			if (other.panFormat != null)
				return false;
		}
		else if (!panFormat.equals(other.panFormat))
			return false;
		if (pinEncrytion == null)
		{
			if (other.pinEncrytion != null)
				return false;
		}
		else if (!pinEncrytion.equals(other.pinEncrytion))
			return false;
		if (pinFormat == null)
		{
			if (other.pinFormat != null)
				return false;
		}
		else if (!pinFormat.equals(other.pinFormat))
			return false;
		if (trackDataFormat == null)
		{
			if (other.trackDataFormat != null)
				return false;
		}
		else if (!trackDataFormat.equals(other.trackDataFormat))
			return false;
		return true;
	}

}
