package com.sahand.cms.entity;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;



@Embeddable
public class TransactionIso87Id implements java.io.Serializable {

	private Long txunqid;
	private Date txreqdt;

	public TransactionIso87Id() {
	}

	public TransactionIso87Id(Long txunqid, Date txreqdt) {
		this.txunqid = txunqid;
		this.txreqdt = txreqdt;
	}

	@Column(name = "TXUNQID", nullable = false, precision = 6, scale = 0)
	public Long getTxunqid() {
		return this.txunqid;
	}

	public void setTxunqid(Long txunqid) {
		this.txunqid = txunqid;
	}

	@Column(name = "TXREQDT", nullable = false, length = 7)
	public Date getTxreqdt() {
		return this.txreqdt;
	}

	public void setTxreqdt(Date txreqdt) {
		this.txreqdt = txreqdt;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TransactionIso87Id))
			return false;
		TransactionIso87Id castOther = (TransactionIso87Id) other;

		return (this.getTxunqid() == castOther.getTxunqid())
				&& ((this.getTxreqdt() == castOther.getTxreqdt()) || (this
						.getTxreqdt() != null
						&& castOther.getTxreqdt() != null && this.getTxreqdt()
						.equals(castOther.getTxreqdt())));
	}

	public int hashCode() {
		int result = 17;

		result = (int) (37 * result + this.getTxunqid());
		result = 37 * result
				+ (getTxreqdt() == null ? 0 : this.getTxreqdt().hashCode());
		return result;
	}

}
