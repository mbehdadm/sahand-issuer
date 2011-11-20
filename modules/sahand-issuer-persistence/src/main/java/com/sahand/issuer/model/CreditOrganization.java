
package com.sahand.issuer.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.sahand.acquirer.model.Institute;

@Entity
@Table(name = "CRDTORG")
public class CreditOrganization implements Serializable
{

	
	@Column(name = "ISID", unique = true, nullable = false, length = 8)
	@NotNull
	private String institutionId;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "isid", nullable = false, insertable = false, updatable = false)
	@NotNull
	private Institute institution;


	public CreditOrganization()
	{

	}

	
	public String getInstitutionId() {
		return institutionId;
	}



	public void setInstitutionId(String institutionId) {
		this.institutionId = institutionId;
	}



	public Institute getInstitution()
	{

		return institution;
	}

	public void setInstitution(Institute institution)
	{

		this.institution = institution;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((institution == null) ? 0 : institution.hashCode());
		result = prime * result
				+ ((institutionId == null) ? 0 : institutionId.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreditOrganization other = (CreditOrganization) obj;
		if (institution == null) {
			if (other.institution != null)
				return false;
		} else if (!institution.equals(other.institution))
			return false;
		if (institutionId == null) {
			if (other.institutionId != null)
				return false;
		} else if (!institutionId.equals(other.institutionId))
			return false;
		return true;
	}
	
	
}
