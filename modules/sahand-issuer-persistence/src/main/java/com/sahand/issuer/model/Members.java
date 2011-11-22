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
//@SequenceGenerator(name="MEMBERS_SEQ",sequenceName="MEMBER_SEQ")
public class Members implements Serializable {

	@Id
//	@GeneratedValue(generator="MEMBERS_SEQ",strategy=GenerationType.SEQUENCE)
	@Column(name="MMID")
	private long memberId;
	@Column(name="MMLATINAME")
	private String latinName;
	@Column(name="MMLOGPASS")
	private String loginPassword;
	@Column(name="MMLOGUSER")
	private String loginUser;
	@Column(name="MMNAME")
	private String name;
	@Column(name="MMSTS")
	private Byte status;
	@Temporal( TemporalType.TIMESTAMP)
	@Column(name="MMSTSDT")
	private Date statusDate;
	@Column(name="MMTYPE")
	private Byte type;
	@ManyToOne
	@JoinColumn(name="ISID")
	private CreditOrganization crreditOrganization;
	@OneToMany(mappedBy="member")
	private Set<MemberCard> membrCards;
	@OneToOne(mappedBy="member")
	private MemberInfo memberInfo;

    public Members() {
    }


	
	public long getMemberId() {
		return this.memberId;
	}

	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}


	
	public String getLatinName() {
		return this.latinName;
	}

	public void setLatinName(String latinName) {
		this.latinName = latinName;
	}


	
	public String getLoginPassword() {
		return this.loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}


	
	public String getLoginUser() {
		return this.loginUser;
	}

	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}


	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	
	public Byte getStatus() {
		return this.status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}


    
	public Date getStatusDate() {
		return this.statusDate;
	}

	public void setStatusDate(Date statusDate) {
		this.statusDate = statusDate;
	}


	
	public Byte getType() {
		return this.type;
	}

	public void setType(Byte type) {
		this.type = type;
	}


	//bi-directional many-to-one association to CreditOrganization
	public CreditOrganization getCrreditOrganization() {
		return this.crreditOrganization;
	}

	public void setCrreditOrganization(CreditOrganization crreditOrganization) {
		this.crreditOrganization = crreditOrganization;
	}
	

	//bi-directional many-to-one association to MemberCard
	public Set<MemberCard> getMembrCards() {
		return this.membrCards;
	}

	public void setMembrCards(Set<MemberCard> membrCards) {
		this.membrCards = membrCards;
	}
	

	//bi-directional one-to-one association to MemberInfo
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