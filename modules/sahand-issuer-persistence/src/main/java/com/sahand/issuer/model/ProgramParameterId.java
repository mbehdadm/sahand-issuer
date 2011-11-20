
package com.sahand.issuer.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Embeddable
public class ProgramParameterId implements Serializable
{
    
    private Long programId;
    private Integer programParameterType;
    
    
    @Column(name = "PPTYPE", nullable = false, precision = 4, scale = 0)
    @Enumerated(EnumType.ORDINAL)
    @NotNull
    public Integer getProgramParameterType()
    {

	return programParameterType;
    }
    
    /**
     * @param programParameterType
     *            the programParameterType to set
     */
    public void setProgramParameterType(Integer programParameterType)
    {

	this.programParameterType = programParameterType;
    }
    
    public ProgramParameterId()
    {

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
    
    // public void setProgramParameterType(Integer programParameterType) {
    // this.programParameterType = programParameterType;
    // try {
    // Context ctx = Contexts.getApplicationContext () ;
    // SelectItems selectItems = (SelectItems) ctx.get ("selectItems") ;
    // if (selectItems == null) {
    // return;
    // }
    // Map<String, ProgramParameterType> entityMap = selectItems.getEntityMap
    // (ProgramParameterType.class) ;
    // if (entityMap == null) {
    // throw new ConverterException ("Unable to get entity map for "
    // + ProgramParameterType.class.getCanonicalName()) ;
    // }
    // this.setProgramParameterTypeClass (entityMap.get
    // (String.valueOf(Integer.valueOf(programParameterType).intValue())));
    // }
    // catch (Exception e) {
    // e.printStackTrace();
    // }
    // }
    
    @Override
    public int hashCode()
    {

	final int prime = 31;
	int result = 1;
	result = prime
				* result
				+ ((programParameterType == null) ? 0 : programParameterType
						.hashCode());
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
	if (!(obj instanceof ProgramParameterId))
	    return false;
	ProgramParameterId other = (ProgramParameterId) obj;
	if (programParameterType == null)
	{
	    if (other.programParameterType != null)
		return false;
	}
	else if (!programParameterType.equals(other.programParameterType))
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
