package com.sahand.issuer.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TransactionInstalmentId implements Serializable {
	
	private Long transactionId;
	private Integer row;
	private Date requestDate;	
	
	
	public TransactionInstalmentId() {
	}
	public TransactionInstalmentId(Long transactionId, Integer row) {	
		this.transactionId = transactionId;
		this.row = row;
	}	
	
	@Column(name = "TXUNQID", nullable = false, precision = 6, scale = 0)
//	@NotNull
	public Long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}
	
//	@Temporal(TemporalType.DATE)
	@Column(name = "TXREQDT", nullable=false, length = 7)
//	@Length(max = 7)
//	@NotNull
	public Date getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}
	
	@Column(name = "TIROW", nullable = false, precision = 4, scale = 0)
//	@NotNull
	public Integer getRow() {
		return row;
	}
	public void setRow(Integer row) {
		this.row = row;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((requestDate == null) ? 0 : requestDate.hashCode());
		result = prime * result + ((row == null) ? 0 : row.hashCode());
		result = prime * result
				+ ((transactionId == null) ? 0 : transactionId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof TransactionInstalmentId))
			return false;
		TransactionInstalmentId other = (TransactionInstalmentId) obj;
		if (requestDate == null) {
			if (other.requestDate != null)
				return false;
		} else if (!requestDate.equals(other.requestDate))
			return false;
		if (row == null) {
			if (other.row != null)
				return false;
		} else if (!row.equals(other.row))
			return false;
		if (transactionId == null) {
			if (other.transactionId != null)
				return false;
		} else if (!transactionId.equals(other.transactionId))
			return false;
		return true;
	}
	
	

}
