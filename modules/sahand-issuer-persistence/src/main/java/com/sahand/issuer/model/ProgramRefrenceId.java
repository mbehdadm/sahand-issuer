
package com.sahand.issuer.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProgramRefrenceId
{
    
    private Long programId;
    private Integer programRefrenceType;
    
    @Column(name = "PGID")
    public Long getProgramId()
    {

	return programId;
    }
    
    public void setProgramId(Long programId)
    {

	this.programId = programId;
    }
    
    @Column(name = "PGREFTYPE")
    public Integer getProgramRefrenceType()
    {

	return programRefrenceType;
    }
    
    public void setProgramRefrenceType(Integer programRefrenceType)
    {

	this.programRefrenceType = programRefrenceType;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((programId == null) ? 0 : programId.hashCode());
		result = prime
				* result
				+ ((programRefrenceType == null) ? 0 : programRefrenceType
						.hashCode());
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
		ProgramRefrenceId other = (ProgramRefrenceId) obj;
		if (programId == null) {
			if (other.programId != null)
				return false;
		} else if (!programId.equals(other.programId))
			return false;
		if (programRefrenceType == null) {
			if (other.programRefrenceType != null)
				return false;
		} else if (!programRefrenceType.equals(other.programRefrenceType))
			return false;
		return true;
	}
    
  
}
