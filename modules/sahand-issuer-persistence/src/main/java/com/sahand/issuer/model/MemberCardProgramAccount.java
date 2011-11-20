
package com.sahand.issuer.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "MCPA")
public class MemberCardProgramAccount
{
   
	@EmbeddedId
	@AttributeOverrides(
			{
				@AttributeOverride(name = "mcpan", column = @Column(name = "MCPAN", nullable = false, length = 19)),
				@AttributeOverride(name = "pgid", column = @Column(name = "PGID", nullable = false, length = 6)) })
	@NotNull
	private MemberCardProgramAccountId id;
    @Column(name = "MCPAFLRLMT", nullable = true, length = 14, precision = 2)
    private Double floorLimit;
    @Column(name = "MCPABAL", nullable = true, length = 14, precision = 2)
    private Double balanceAmount;
    @Column(name = "MCPAAVLBAL", nullable = true, length = 14, precision = 2)
    private Double availableBalanceAmount;
   
    
    /**
     * @return the floorLimit
     */
    public Double getFloorLimit()
    {

	return floorLimit;
    }
    
    /**
     * @param floorLimit
     *            the floorLimit to set
     */
    public void setFloorLimit(Double floorLimit)
    {

	this.floorLimit = floorLimit;
    }
    
    /**
     * @return the balanceAmount
     */
    public Double getBalanceAmount()
    {

	return balanceAmount;
    }
    
    /**
     * @param balanceAmount
     *            the balanceAmount to set
     */
    public void setBalanceAmount(Double balanceAmount)
    {

	this.balanceAmount = balanceAmount;
    }
    
    /**
     * @return the availableBalanceAmount
     */
    public Double getAvailableBalanceAmount()
    {

	return availableBalanceAmount;
    }
    
    /**
     * @param availableBalanceAmount
     *            the availableBalanceAmount to set
     */
    public void setAvailableBalanceAmount(Double availableBalanceAmount)
    {

	this.availableBalanceAmount = availableBalanceAmount;
    }
    
    @Override
    public boolean equals(Object obj)
    {

	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (!(obj instanceof MemberCardProgramAccount))
	    return false;
	MemberCardProgramAccount other = (MemberCardProgramAccount) obj;
	if (floorLimit == null)
	{
	    if (other.floorLimit != null)
		return false;
	}
	else if (!floorLimit.equals(other.floorLimit))
	    return false;
	if (availableBalanceAmount == null)
	{
	    if (other.availableBalanceAmount != null)
		return false;
	}
	else if (!availableBalanceAmount.equals(other.availableBalanceAmount))
	    return false;
	if (balanceAmount == null)
	{
	    if (other.balanceAmount != null)
		return false;
	}
	else if (!balanceAmount.equals(other.balanceAmount))
	    return false;
	return true;
    }
}
