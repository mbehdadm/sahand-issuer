package com.sahand.issuer.model;

import java.io.Serializable;
import javax.persistence.*;


import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the MMBRINFO database table.
 * 
 */
@Entity
@Table(name="MMBRINFO")
public class MemberInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	private long memberId;
	private String birthcity;
	private Date birthday;
	private Byte bloodGroup;
	private String cellPhone;
	private BigDecimal educationLevel;
	private String email;
	private String fatherName;
	private BigDecimal favoriteColor;
	private Byte gender;
	private String homeAddress;
	private BigDecimal homePostalCode;
	private String homeTel;
	private String motherName;
	private Date marriageDate;
	private Byte marriageStatus;
	private String nationalId;
	private String passportId;
	private String picture;
	private BigDecimal postAddress;
	private String miprsweburl;
	private String signature;
	private String workAddress;
	private BigDecimal workPostalCode;
	private String workTel;
	private Byte[] photo;
	private Members member;

    public MemberInfo() {
    }


	@Id
	@Column(name="MMID")
	public long getMemberId() {
		return memberId;
	}

	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}

	@Column(name="MIBIRTHCITY")
	public String getBirthcity() {
		return this.birthcity;
	}

	public void setBirthcity(String birthcity) {
		this.birthcity = birthcity;
	}


    @Temporal( TemporalType.DATE)
	@Column(name="MIBIRTHDT")
	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	@Column(name="MIBLDGRP")
	public Byte getBloodGroup() {
		return this.bloodGroup;
	}

	public void setBloodGroup(Byte bloodGroup) {
		this.bloodGroup = bloodGroup;
	}


	@Column(name="MICELLPHONE")
	public String getCellPhone() {
		return this.cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}


	@Column(name="MIEDULVL")
	public BigDecimal getEducationLevel() {
		return this.educationLevel;
	}

	public void setEducationLevel(BigDecimal educationLevel) {
		this.educationLevel = educationLevel;
	}


	@Column(name="MIEMAIL")
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Column(name="MIFATHER")
	public String getFatherName() {
		return this.fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}


	@Column(name="MIFAVCOLOR")
	public BigDecimal getFavoriteColor() {
		return this.favoriteColor;
	}

	public void setFavoriteColor(BigDecimal favoriteColor) {
		this.favoriteColor = favoriteColor;
	}


	@Column(name="MIGENDER")
	public Byte getGender() {
		return this.gender;
	}

	public void setGender(Byte gender) {
		this.gender = gender;
	}


	@Column(name="MIHOMEADR")
	public String getHomeAddress() {
		return this.homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}


	@Column(name="MIHOMEPST")
	public BigDecimal getHomePostalCode() {
		return this.homePostalCode;
	}

	public void setHomePostalCode(BigDecimal homePostalCode) {
		this.homePostalCode = homePostalCode;
	}


	@Column(name="MIHOMETEL")
	public String getHomeTel() {
		return this.homeTel;
	}

	public void setHomeTel(String homeTel) {
		this.homeTel = homeTel;
	}


	@Column(name="MIMOTHER")
	public String getMotherName() {
		return this.motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}


    @Temporal( TemporalType.DATE)
	@Column(name="MIMRGDT")
	public Date getMarriageDate() {
		return this.marriageDate;
	}

	public void setMarriageDate(Date marriageDate) {
		this.marriageDate = marriageDate;
	}


	@Column(name="MIMRGSTS")
	public Byte getMarriageStatus() {
		return this.marriageStatus;
	}

	public void setMarriageStatus(Byte marriageStatus) {
		this.marriageStatus = marriageStatus;
	}


	@Column(name="MINATIONALID")
	public String getNationalId() {
		return this.nationalId;
	}

	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}


	@Column(name="MIPASSPORTID")
	public String getPassportId() {
		return this.passportId;
	}

	public void setPassportId(String passportId) {
		this.passportId = passportId;
	}


	@Column(name="MIPIC")
	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}


	@Column(name="MIPOSTADRS")
	public BigDecimal getPostAddress() {
		return this.postAddress;
	}

	public void setPostAddress(BigDecimal postAddress) {
		this.postAddress = postAddress;
	}


	public String getMiprsweburl() {
		return this.miprsweburl;
	}

	public void setMiprsweburl(String miprsweburl) {
		this.miprsweburl = miprsweburl;
	}


	@Column(name="MISIGN")
	public String getSignature() {
		return this.signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}


	@Column(name="MIWORKADR")
	public String getWorkAddress() {
		return this.workAddress;
	}

	public void setWorkAddress(String workAddress) {
		this.workAddress = workAddress;
	}


	@Column(name="MIWORKPST")
	public BigDecimal getWorkPostalCode() {
		return this.workPostalCode;
	}

	public void setWorkPostalCode(BigDecimal workPostalCode) {
		this.workPostalCode = workPostalCode;
	}


	@Column(name="MIWORKTEL")
	public String getWorkTel() {
		return this.workTel;
	}

	public void setWorkTel(String workTel) {
		this.workTel = workTel;
	}

	@Column(name="MIPHOTO")
	public Byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(Byte[] photo) {
		this.photo = photo;
	}


	//bi-directional one-to-one association to Member
	@OneToOne
	@JoinColumn(name="MMID")
	public Members getMember() {
		return this.member;
	}

	public void setMember(Members member) {
		this.member = member;
	}


	@Override
	public String toString() {
		return "MemberInfo [mmid=" + memberId + ", birthcity=" + birthcity
				+ ", birthday=" + birthday + ", bloodGroup=" + bloodGroup
				+ ", cellPhone=" + cellPhone + ", educationLevel="
				+ educationLevel + ", email=" + email + ", fatherName="
				+ fatherName + ", favoriteColor=" + favoriteColor + ", gender="
				+ gender + ", homeAddress=" + homeAddress + ", homePostalCode="
				+ homePostalCode + ", homeTel=" + homeTel + ", motherName="
				+ motherName + ", marriageDate=" + marriageDate
				+ ", marriageStatus=" + marriageStatus + ", nationalId="
				+ nationalId + ", passportId=" + passportId + ", picture="
				+ picture + ", postAddress=" + postAddress + ", miprsweburl="
				+ miprsweburl + ", signature=" + signature + ", workAddress="
				+ workAddress + ", workPostalCode=" + workPostalCode
				+ ", workTel=" + workTel /*+ ", member=" + member */+ "]";
	}
	
	
	
}