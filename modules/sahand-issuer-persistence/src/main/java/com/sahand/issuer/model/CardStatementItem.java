
package com.sahand.issuer.model;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "CARDSTMITM")
public class CardStatementItem implements Serializable
{
	@EmbeddedId
	@AttributeOverrides( { @AttributeOverride(name = "txunqid", column = @Column(name = "TXUNQID", nullable = false, precision = 6, scale = 0)),
		@AttributeOverride(name = "txreqdt", column = @Column(name = "TXREQDT", nullable = false, length = 7)),
		@AttributeOverride(name = "tirow", column = @Column(name = "TIROW", nullable = false, precision = 4, scale = 0)) })
	private TransactionInstalmentId transactionInstalmentId;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns( { @JoinColumn(name = "txunqid", referencedColumnName = "TXUNQID", nullable = false), @JoinColumn(name = "txreqdt", referencedColumnName = "TXREQDT", nullable = false),
		@JoinColumn(name = "yirow", referencedColumnName = "TIROW", nullable = false) })
	private TransactionInstalment transactionInstalment;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns( { @JoinColumn(name = "csid", referencedColumnName = "CSID", nullable = false), @JoinColumn(name = "csissdt", referencedColumnName = "CSISSDT", nullable = false) })
	private CardStatement cardStatement;


	public TransactionInstalmentId getTransactionInstalmentId()
	{

		return transactionInstalmentId;
	}

	public void setTransactionInstalmentId(TransactionInstalmentId transactionInstalmentId)
	{

		this.transactionInstalmentId = transactionInstalmentId;
	}


	public TransactionInstalment getTransactionInstalment()
	{

		return transactionInstalment;
	}

	public void setTransactionInstalment(TransactionInstalment transactionInstalment)
	{

		this.transactionInstalment = transactionInstalment;
	}


	public CardStatement getCardStatement()
	{

		return cardStatement;
	}

	public void setCardStatement(CardStatement cardStatement)
	{

		this.cardStatement = cardStatement;
	}

}
