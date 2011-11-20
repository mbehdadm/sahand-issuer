
package com.sahand.issuer.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class CreditOrganizationId implements Serializable
{

	@Column(name = "ISID", unique = true, nullable = false, length = 8)
	@NotNull
	private String institutionId;

	public CreditOrganizationId()
	{

	}

	public CreditOrganizationId(String institutionId)
	{

		this.institutionId = institutionId;
	}
	
	public String getInstitutionId()
	{

		return institutionId;
	}

	public void setInstitutionId(String institutionId)
	{

		this.institutionId = institutionId;
	}


	@Override
	public int hashCode()
	{

		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((institutionId == null) ? 0 : institutionId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof CreditOrganizationId))
			return false;
		CreditOrganizationId other = (CreditOrganizationId) obj;
		if (institutionId == null)
		{
			if (other.institutionId != null)
				return false;
		}
		else if (!institutionId.equals(other.institutionId))
			return false;
		return true;
	}

	
}
