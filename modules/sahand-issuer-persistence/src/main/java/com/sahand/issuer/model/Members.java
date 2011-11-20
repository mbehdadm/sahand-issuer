package com.sahand.issuer.model;

import java.io.Serializable;
import javax.persistence.*;


import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the MEMBER database table.
 * 
 */
@Entity
@Table(name="MEMBER")
@SequenceGenerator(name="MEMBERS_SEQ",sequenceName="MEMBER_SEQ")
public class Members implements Serializable {
	private static final long serialVersionUID = 1L;
	private long memberId;
	private String latinName;
	private String loginPassword;
	private String loginUser;
	private String name;
	private Byte status;
	private Date statusDate;
	private Byte type;
	private CreditOrganization crreditOrganization;
	private Set<MemberCard> membrCards;
	private MemberInfo memberInfo;

    public Members() {
    }


	@Id
	@GeneratedValue(generator="MEMBERS_SEQ",strategy=GenerationType.SEQUENCE)
	@Column(name="MMID")
	public long getMemberId() {
		return this.memberId;
	}

	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}


	@Column(name="MMLATINAME")
	public String getLatinName() {
		return this.latinName;
	}

	public void setLatinName(String latinName) {
		this.latinName = latinName;
	}


	@Column(name="MMLOGPASS")
	public String getLoginPassword() {
		return this.loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}


	@Column(name="MMLOGUSER")
	public String getLoginUser() {
		return this.loginUser;
	}

	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}


	@Column(name="MMNAME")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Column(name="MMSTS")
	public Byte getStatus() {
		return this.status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}


    @Temporal( TemporalType.DATE)
	@Column(name="MMSTSDT")
	public Date getStatusDate() {
		return this.statusDate;
	}

	public void setStatusDate(Date statusDate) {
		this.statusDate = statusDate;
	}


	@Column(name="MMTYPE")
	public Byte getType() {
		return this.type;
	}

	public void setType(Byte type) {
		this.type = type;
	}


	//bi-directional many-to-one association to CreditOrganization
    @ManyToOne
	@JoinColumn(name="ISID")
	public CreditOrganization getCrreditOrganization() {
		return this.crreditOrganization;
	}

	public void setCrreditOrganization(CreditOrganization crreditOrganization) {
		this.crreditOrganization = crreditOrganization;
	}
	

	//bi-directional many-to-one association to MemberCard
	@OneToMany(mappedBy="member")
	public Set<MemberCard> getMembrCards() {
		return this.membrCards;
	}

	public void setMembrCards(Set<MemberCard> membrCards) {
		this.membrCards = membrCards;
	}
	

	//bi-directional one-to-one association to MemberInfo
	@OneToOne(mappedBy="member")
	public MemberInfo getMemberInfo() {
		return this.memberInfo;
	}

	public void setMemberInfo(MemberInfo memberInfo) {
		this.memberInfo = memberInfo;
	}
	



	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", latinName=" + latinName
				+ ", loginPassword=" + loginPassword + ", loginUser="
				+ loginUser + ", name=" + name + ", status=" + status
				+ ", statusDate=" + statusDate + ", type=" + type
				+ ", crreditOrganization=" + crreditOrganization
				/*+ ", membrCards=" + membrCards + ", memberInfo=" + memberInfo*/
				/*+ ", visitors=" + visitors*/ + "]";
	}
	
	
}