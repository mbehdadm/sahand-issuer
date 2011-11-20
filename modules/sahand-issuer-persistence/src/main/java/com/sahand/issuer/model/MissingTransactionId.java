
package com.sahand.issuer.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

/**
 * MissingTransactionId entity. @author MyEclipse Persistence Tools
 */

@Embeddable
@SequenceGenerator(name = "MISSINGTRN_SEQ", sequenceName = "MISSINGTRN_SEQ")
public class MissingTransactionId implements java.io.Serializable
{
    
    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    
    private Long missTransactionId;
    private Date missTransactionDate;
    
    /**
     * @return the missTransactionId
     */
    @Column(name = "MISTRNUNQID", unique = true, nullable = false, precision = 6, scale = 0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MISSINGTRN_SEQ")
    public Long getMissTransactionId()
    {

	return missTransactionId;
    }
    
    /**
     * @param missTransactionId
     *            the missTransactionId to set
     */
    public void setMissTransactionId(Long missTransactionId)
    {

	this.missTransactionId = missTransactionId;
    }
    
    /**
     * @return the missTransactionDate
     */
    @Column(name = "MISTRNREQDT", nullable = false)
    @NotNull
    public Date getMissTransactionDate()
    {

	return missTransactionDate;
    }
    
    /**
     * @param missTransactionDate
     *            the missTransactionDate to set
     */
    public void setMissTransactionDate(Date missTransactionDate)
    {

	this.missTransactionDate = missTransactionDate;
    }
    
    @Override
    public int hashCode()
    {

	final int prime = 31;
	int result = 1;
	result = prime * result + ((missTransactionId == null) ? 0 : missTransactionId.hashCode());
	result = prime * result
				+ ((missTransactionDate == null) ? 0 : missTransactionDate.hashCode());
	return result;
    }
    
    @Override
    public boolean equals(Object obj)
    {

	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (!(obj instanceof MissingTransactionId))
	    return false;
	MissingTransactionId other = (MissingTransactionId) obj;
	if (missTransactionId == null)
	{
	    if (other.missTransactionId != null)
		return false;
	}
	else if (!missTransactionId.equals(other.missTransactionId))
	    return false;
	if (missTransactionDate == null)
	{
	    if (other.missTransactionDate != null)
		return false;
	}
	else if (!missTransactionDate.equals(other.missTransactionDate))
	    return false;
	return true;
    }
    
}
