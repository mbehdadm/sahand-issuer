package com.sahand.cms.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.hibernate.validator.NotNull;



@Embeddable
public class TransactionId implements Serializable,Cloneable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Date requestDate;
	
	public TransactionId(Long id, java.sql.Date requestDate) {
		this.id = id;
		this.requestDate = requestDate;
	}
	
	public TransactionId() {
	}
	
	@Column(name="TXUNQID" , unique=true , nullable= false , precision=6 , scale=0)
	@NotNull
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
//	@Temporal(TemporalType.DATE)
	@Column(name = "TXREQDT", nullable=false)
	@NotNull
	public Date getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((requestDate == null) ? 0 : requestDate.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof TransactionId))
			return false;
		TransactionId other = (TransactionId) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (requestDate == null) {
			if (other.requestDate != null)
				return false;
		} else if (!requestDate.equals(other.requestDate))
			return false;
		return true;
	}
	  
    public TransactionId clone()throws CloneNotSupportedException {
   
    	TransactionId that;
			that = (TransactionId)super.clone();
			return that;
    }
	
}
