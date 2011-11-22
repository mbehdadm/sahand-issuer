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

	@Id
	@Column(name="MMID")
	private long memberId;
	@Column(name="MIBIRTHCITY")
	private String birthcity;
	@Temporal( TemporalType.DATE)
	@Column(name="MIBIRTHDT")
	private Date birthday;
	@Column(name="MIBLDGRP")
	private Byte bloodGroup;
	@Column(name="MICELLPHONE")
	private String cellPhone;
	@Column(name="MIEDULVL")
	private BigDecimal educationLevel;
	@Column(name="MIEMAIL")
	private String email;
	@Column(name="MIFATHER")
	private String fatherName;
	@Column(name="MIFAVCOLOR")
	private BigDecimal favoriteColor;
	@Column(name="MIGENDER")
	private Byte gender;
	@Column(name="MIHOMEADR")
	private String homeAddress;
	@Column(name="MIHOMEPST")
	private BigDecimal homePostalCode;
	@Column(name="MIHOMETEL")
	private String homeTel;
	@Column(name="MIMOTHER")
	private String motherName;
	@Temporal( TemporalType.DATE)
	@Column(name="MIMRGDT")
	private Date marriageDate;
	@Column(name="MIMRGSTS")
	private Byte marriageStatus;
	@Column(name="MINATIONALID")
	private String nationalId;
	@Column(name="MIPASSPORTID")
	private String passportId;
	@Column(name="MIPIC")
	private String picture;
	@Column(name="MIPOSTADRS")
	private BigDecimal postAddress;
	@Column(name="MIPRSWEBURL")
	private String miprsweburl;
	@Column(name="MISIGN")
	private String signature;
	@Column(name="MIWORKADR")
	private String workAddress;
	@Column(name="MIWORKPST")
	private BigDecimal workPostalCode;
	@Column(name="MIWORKTEL")
	private String workTel;
//	private Byte[] photo;
	@OneToOne
	@JoinColumn(name="MMID")
	private Members member;

    public MemberInfo() {
    }


	
	public long getMemberId() {
		return memberId;
	}

	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}

	
	public String getBirthcity() {
		return this.birthcity;
	}

	public void setBirthcity(String birthcity) {
		this.birthcity = birthcity;
	}


   
	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	
	public Byte getBloodGroup() {
		return this.bloodGroup;
	}

	public void setBloodGroup(Byte bloodGroup) {
		this.bloodGroup = bloodGroup;
	}


	
	public String getCellPhone() {
		return this.cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}


	
	public BigDecimal getEducationLevel() {
		return this.educationLevel;
	}

	public void setEducationLevel(BigDecimal educationLevel) {
		this.educationLevel = educationLevel;
	}


	
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	
	public String getFatherName() {
		return this.fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}


	
	public BigDecimal getFavoriteColor() {
		return this.favoriteColor;
	}

	public void setFavoriteColor(BigDecimal favoriteColor) {
		this.favoriteColor = favoriteColor;
	}


	
	public Byte getGender() {
		return this.gender;
	}

	public void setGender(Byte gender) {
		this.gender = gender;
	}


	
	public String getHomeAddress() {
		return this.homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}


	
	public BigDecimal getHomePostalCode() {
		return this.homePostalCode;
	}

	public void setHomePostalCode(BigDecimal homePostalCode) {
		this.homePostalCode = homePostalCode;
	}


	
	public String getHomeTel() {
		return this.homeTel;
	}

	public void setHomeTel(String homeTel) {
		this.homeTel = homeTel;
	}


	
	public String getMotherName() {
		return this.motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}


    
	public Date getMarriageDate() {
		return this.marriageDate;
	}

	public void setMarriageDate(Date marriageDate) {
		this.marriageDate = marriageDate;
	}


	
	public Byte getMarriageStatus() {
		return this.marriageStatus;
	}

	public void setMarriageStatus(Byte marriageStatus) {
		this.marriageStatus = marriageStatus;
	}


	
	public String getNationalId() {
		return this.nationalId;
	}

	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}


	
	public String getPassportId() {
		return this.passportId;
	}

	public void setPassportId(String passportId) {
		this.passportId = passportId;
	}


	
	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}


	
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


	
	public String getSignature() {
		return this.signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}


	
	public String getWorkAddress() {
		return this.workAddress;
	}

	public void setWorkAddress(String workAddress) {
		this.workAddress = workAddress;
	}


	
	public BigDecimal getWorkPostalCode() {
		return this.workPostalCode;
	}

	public void setWorkPostalCode(BigDecimal workPostalCode) {
		this.workPostalCode = workPostalCode;
	}


	
	public String getWorkTel() {
		return this.workTel;
	}

	public void setWorkTel(String workTel) {
		this.workTel = workTel;
	}

//	@Column(name="MIPHOTO")
//	public Byte[] getPhoto() {
//		return photo;
//	}
//
//	public void setPhoto(Byte[] photo) {
//		this.photo = photo;
//	}


	//bi-directional one-to-one association to Member
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