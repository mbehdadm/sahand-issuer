
package com.sahand.issuer.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "PROGREFRNC")
public class ProgramRefrence
{
    
    private ProgramRefrenceId id;
    private String refrenceName;
    private Integer programRefIsRequired;
    private Integer programRefIsRendered;
    
    @EmbeddedId
    @AttributeOverrides(
    {
		@AttributeOverride(name = "programId", column = @Column(name = "PGID", nullable = false, precision = 6, scale = 0)),
		@AttributeOverride(name = "programRefrenceType", column = @Column(name = "PGREFTYPE", nullable = false)) })
    @NotNull
    public ProgramRefrenceId getId()
    {

	return id;
    }
    
    public void setId(ProgramRefrenceId id)
    {

	this.id = id;
    }
    
    @Column(name = "PGREFNAME")
    @Length(max = 100)
    public String getRefrenceName()
    {

	return refrenceName;
    }
    
    public void setRefrenceName(String refrenceName)
    {

	this.refrenceName = refrenceName;
    }
    
    @Column(name = "PGREFISRQUR")
    @NotNull
    public Integer getProgramRefIsRequired()
    {

	return programRefIsRequired;
    }
    
    public void setProgramRefIsRequired(Integer programRefIsRequired)
    {

	this.programRefIsRequired = programRefIsRequired;
    }
    
    @Column(name = "PGREFISRNDR")
    @NotNull
    public Integer getProgramRefIsRendered()
    {

	return programRefIsRendered;
    }
    
    public void setProgramRefIsRendered(Integer programRefIsRendered)
    {

	this.programRefIsRendered = programRefIsRendered;
    }
    
}
