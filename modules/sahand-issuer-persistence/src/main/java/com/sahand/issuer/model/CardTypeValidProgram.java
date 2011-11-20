
package com.sahand.issuer.model;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "CRDTYP2PROG")
public class CardTypeValidProgram implements Serializable
{
    
    private CardTypeValidProgramId cardTypeValidProgramId;
    private CardType cardType;
    private Program program;
    
    public CardTypeValidProgram()
    {

    }
    
    public CardTypeValidProgram(CardTypeValidProgramId cardTypeValidProgramId,
			CardType cardType, Program program)
    {

	this.cardTypeValidProgramId = cardTypeValidProgramId;
	this.cardType = cardType;
	this.program = program;
    }
    
    @EmbeddedId
    @AttributeOverrides(
    {
		@AttributeOverride(name = "ctid", column = @Column(name = "CTID", nullable = false, precision = 3, scale = 0)),
		@AttributeOverride(name = "pgid", column = @Column(name = "PGID", nullable = false, precision = 6, scale = 0)) })
    @NotNull
    public CardTypeValidProgramId getCardTypeValidProgramId()
    {

	return cardTypeValidProgramId;
    }
    
    public void setCardTypeValidProgramId(
			CardTypeValidProgramId cardTypeValidProgramId)
    {

	this.cardTypeValidProgramId = cardTypeValidProgramId;
    }
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ctid", nullable = false)
    @NotNull
    public CardType getCardType()
    {

	return cardType;
    }
    
    public void setCardType(CardType cardType)
    {

	this.cardType = cardType;
    }
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pgid", nullable = false)
    @NotNull
    public Program getProgram()
    {

	return program;
    }
    
    public void setProgram(Program program)
    {

	this.program = program;
    }
    
}
