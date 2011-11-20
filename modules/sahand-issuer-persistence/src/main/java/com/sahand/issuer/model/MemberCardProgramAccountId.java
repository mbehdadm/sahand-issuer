
package com.sahand.issuer.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;


@Embeddable
public class MemberCardProgramAccountId implements Serializable
{
    
    @Id
    @Column(name = "MCPAN", nullable = false, length = 19)
    @Length(max = 19)
    @NotNull
    private String pan;
    @Id
    @Column(name = "PGID", nullable = false, length = 6)
    @Range(max = 6)
    @NotNull
    private Long programId;
    
    /**
     * @return the pan
     */
   
    public String getPan()
    {

	return pan;
    }
    
    /**
     * @param pan
     *            the pan to set
     */
    public void setPan(String pan)
    {

	this.pan = pan;
    }
    
    /**
     * @return the programId
     */
   
    public Long getProgramId()
    {

	return programId;
    }
    
    /**
     * @param programId
     *            the programId to set
     */
    public void setProgramId(Long programId)
    {

	this.programId = programId;
    }
    
    @Override
    public int hashCode()
    {

	final int prime = 31;
	int result = 1;
	result = prime * result + ((pan == null) ? 0 : pan.hashCode());
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
	if (!(obj instanceof MemberCardProgramAccountId))
	    return false;
	MemberCardProgramAccountId other = (MemberCardProgramAccountId) obj;
	if (pan == null)
	{
	    if (other.pan != null)
		return false;
	}
	else if (!pan.equals(other.pan))
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
