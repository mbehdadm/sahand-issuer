
package com.sahand.issuer.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class ProgramPartnerId implements Serializable
{
    
    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    private Long programId;
    private Byte programPartnerType;
    private String institutionId;
    
    public ProgramPartnerId()
    {

    }
    
    public ProgramPartnerId(Long programId, Byte programPartnerType, String institutionId)
    {

	super();
	this.programId = programId;
	this.programPartnerType = programPartnerType;
	this.institutionId = institutionId;
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
    
    @Column(name = "PTTYPE", nullable = false, precision = 2, scale = 0)
    @NotNull
    public Byte getProgramPartnerType()
    {

	return programPartnerType;
    }
    
    /**
     * @param programPartnerType
     *            the programPartnerType to set
     */
    public void setProgramPartnerType(Byte programPartnerType)
    {

	this.programPartnerType = programPartnerType;
    }
    
    @Column(name = "ISID", nullable = false, length = 8)
    @NotNull
    public String getInstitutionId()
    {

	return institutionId;
    }
    
    public void setInstitutionId(String institutionId)
    {

	this.institutionId = institutionId;
    }
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {

	final int prime = 31;
	int result = 1;
	result = prime * result
				+ ((institutionId == null) ? 0 : institutionId.hashCode());
	result = prime * result
				+ ((programId == null) ? 0 : programId.hashCode());
	result = prime * result + ((programPartnerType == null) ? 0 : programPartnerType.hashCode());
	return result;
    }
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj)
    {

	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (!(obj instanceof ProgramPartnerId))
	    return false;
	final ProgramPartnerId other = (ProgramPartnerId) obj;
	if (institutionId == null)
	{
	    if (other.institutionId != null)
		return false;
	}
	else if (!institutionId.equals(other.institutionId))
	    return false;
	if (programId == null)
	{
	    if (other.programId != null)
		return false;
	}
	else if (!programId.equals(other.programId))
	    return false;
	if (programPartnerType == null)
	{
	    if (other.programPartnerType != null)
		return false;
	}
	else if (!programPartnerType.equals(other.programPartnerType))
	    return false;
	return true;
    }
    
}
