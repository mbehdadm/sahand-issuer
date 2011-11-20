
package com.sahand.issuer.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class CardStatementId implements Serializable
{

	@Column(name = "CSID", nullable = false, precision = 8, scale = 0)
	private Long id;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CSISSDT", nullable = false, length = 7)
	private Date issueDate;

	public CardStatementId()
	{

	}

	public CardStatementId(Long id, Date issueDate)
	{

		this.id = id;
		this.issueDate = issueDate;
	}


	public Long getId()
	{

		return id;
	}

	public void setId(Long id)
	{

		this.id = id;
	}


	public Date getIssueDate()
	{

		return issueDate;
	}

	public void setIssueDate(Date issueDate)
	{

		this.issueDate = issueDate;
	}

	@Override
	public int hashCode()
	{

		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((issueDate == null) ? 0 : issueDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof CardStatementId))
			return false;
		CardStatementId other = (CardStatementId) obj;
		if (id == null)
		{
			if (other.id != null)
				return false;
		}
		else if (!id.equals(other.id))
			return false;
		if (issueDate == null)
		{
			if (other.issueDate != null)
				return false;
		}
		else if (!issueDate.equals(other.issueDate))
			return false;
		return true;
	}

}
