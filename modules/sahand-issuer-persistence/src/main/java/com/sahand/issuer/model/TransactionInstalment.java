package com.sahand.issuer.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sahand.acquirer.model.Institute;

//import org.hibernate.validator.Length;
//import org.hibernate.validator.NotNull;

@Entity
@Table(name="TXNINSTAL")
public class TransactionInstalment implements Serializable {


	private static final long serialVersionUID = 1L;
	private TransactionInstalmentId transactionInstalmentId;
	private BigDecimal amount;
	private Date date;
	private Date payDate;
	private Byte status;
	private Date statusDate;
	private Program program;
	private Institute cardAcceptor;
	private Institute investor;
	private Long paymentTransactionId;
	private Date paymentTransactionDate;
	private String pan;
	private BigDecimal payAmount;


	@EmbeddedId
	@AttributeOverrides({
		@AttributeOverride(name = "txunqid", column = @Column(name = "TXUNQID", nullable = false, precision = 6, scale = 0)),		
		@AttributeOverride(name = "txreqdt", column = @Column(name = "TXREQDT", nullable=false, length = 7)),
		@AttributeOverride(name = "tirow", column = @Column(name = "TIROW", nullable = false, precision = 4, scale = 0))
	})
	//    	@NotNull
	public TransactionInstalmentId getTransactionInstalmentId() {
		return transactionInstalmentId;
	}
	public void setTransactionInstalmentId(
			TransactionInstalmentId transactionInstalmentId) {
		this.transactionInstalmentId = transactionInstalmentId;
	}

	@Column(name = "TIAMNT", nullable = false, precision = 14, scale = 0)
	//    	@NotNull
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	//    	@Temporal(TemporalType.DATE)
	@Column(name = "TIDATE", nullable=false, length = 7)
	//    	@Length(max = 7)
	//    	@NotNull
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	//    	@Temporal(TemporalType.DATE)
	@Column(name = "TIPAYDT", nullable=true, length = 7)
	//    	@Length(max = 7)
	//    	@Basic
	//    	@NotNull
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	@Column(name = "TISTS", nullable = false, precision = 2, scale = 0)
	//    	@NotNull
	public Byte getStatus() {
		return status;
	}
	public void setStatus(Byte status) {
		this.status = status;
	}

	//    	@Temporal(TemporalType.DATE)
	@Column(name = "TISTSDT", nullable=false, length = 7)
	//    	@Length(max = 7)
	//    	@NotNull
	public Date getStatusDate() {
		return statusDate;
	}
	public void setStatusDate(Date statusDate) {
		this.statusDate = statusDate;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PGID", nullable = false)
	//    	@NotNull
	public Program getProgram() {
		return program;
	}
	public void setProgram(Program program) {
		this.program = program;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ISID", nullable = false)
	//    	@NotNull
	public Institute getCardAcceptor() {
		return cardAcceptor;
	}
	public void setCardAcceptor(Institute cardAcceptor) {
		this.cardAcceptor = cardAcceptor;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "INS_ISID",referencedColumnName="ISID", nullable = false)
	//    	@NotNull
	public Institute getInvestor() {
		return investor;
	}
	public void setInvestor(Institute investor) {
		this.investor = investor;
	}

	/**
	 * @return the pan
	 */
	@Column(name="TIPAN",nullable = false,length=19)
	//	@NotNull
	public String getPan()
	{

		return pan;
	}

	/**
	 * @param pan the pan to set
	 */
	public void setPan(String pan)
	{

		this.pan = pan;
	}

	/**
	 * @return the payAmount
	 */
	@Column(name ="TIPAYAMNT" , nullable= true , precision = 14, scale = 0)
	public BigDecimal getPayAmount()
	{

		return payAmount;
	}

	/**
	 * @param payAmount the payAmount to set
	 */
	public void setPayAmount(BigDecimal payAmount)
	{

		this.payAmount = payAmount;
	}

	/**
	 * @return the paymentTransactionId
	 */
	@Column(name = "TI_TXUNQID", nullable = true, precision = 6, scale = 0)
	public Long getPaymentTransactionId()
	{
		return paymentTransactionId;
	}

	/**
	 * @param paymentTransactionId the paymentTransactionId to set
	 */
	public void setPaymentTransactionId(Long paymentTransactionId)
	{
		this.paymentTransactionId = paymentTransactionId;
	}

	/**
	 * @return the paymentTransactionDate
	 */
	@Column(name = "TI_TXREQDT", nullable = true)
	public Date getPaymentTransactionDate()
	{
		return paymentTransactionDate;
	}

	/**
	 * @param paymentTransactionDate the paymentTransactionDate to set
	 */
	public void setPaymentTransactionDate(Date paymentTransactionDate)
	{
		this.paymentTransactionDate = paymentTransactionDate;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{

		return "TransactionInstalment [amount=" + amount + ", cardAcceptor=" + cardAcceptor + ", date=" + date + ", investor=" + investor + ", pan=" + pan + ", payAmount=" + payAmount
				+ ", payDate=" + payDate + ", paymentTransactionDate=" + paymentTransactionDate + ", paymentTransactionId=" + paymentTransactionId + ", program=" + program + ", status=" + status
				+ ", statusDate=" + statusDate + ", transactionInstalmentId=" + transactionInstalmentId + "]";
	}


}
