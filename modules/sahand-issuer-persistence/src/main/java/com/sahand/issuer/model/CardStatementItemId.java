
package com.sahand.issuer.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

public class CardStatementItemId implements Serializable
{
	@Column(name = "TXUNQID", unique = true, nullable = false, precision = 6, scale = 0)
	private Long transactionId;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TXREQDT", nullable = false, length = 7)
	private Date transactionRequestDate;
	@Column(name = "TIROW", nullable = false, precision = 4, scale = 0)
	private Integer transactionInstalmentRow;


	public Long getTransactionId()
	{

		return transactionId;
	}

	public void setTransactionId(Long transactionId)
	{

		this.transactionId = transactionId;
	}


	public Date getTransactionRequestDate()
	{

		return transactionRequestDate;
	}

	public void setTransactionRequestDate(Date transactionRequestDate)
	{

		this.transactionRequestDate = transactionRequestDate;
	}


	public Integer getTransactionInstalmentRow()
	{

		return transactionInstalmentRow;
	}

	public void setTransactionInstalmentRow(Integer transactionInstalmentRow)
	{

		this.transactionInstalmentRow = transactionInstalmentRow;
	}

}
