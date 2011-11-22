package com.sahand.issuer.data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MemberInformation implements Serializable {

	//member
	private Long memberId;
	private String latinName;
	private String loginPassword;
	private String loginUser;
	private String name;
	private Byte status;
	private Date statusDate;
	private Byte type;
	private String instituteId;
	//member info
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
	private String homePostalCode;
	private String homeTel;
	private String motherName;
	private Date marriageDate;
	private Byte marriageStatus;
	private String nationalId;
	private String passportId;
	private String picture;
	private Byte[] photo;
	private String postAddress;
	private String miprsweburl;
	private String signature;
	private String workAddress;
	private String workPostalCode;
	private String workTel;
	//member card
	private List<CardInformation> cardInformations = new ArrayList<CardInformation>();
	//generate type
	private boolean autoGenerate = true;
	
	public Long getMemberId() {
		return memberId;
	}
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	public String getLatinName() {
		return latinName;
	}
	public void setLatinName(String latinName) {
		this.latinName = latinName;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	public String getLoginUser() {
		return loginUser;
	}
	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Byte getStatus() {
		return status;
	}
	public void setStatus(Byte status) {
		this.status = status;
	}
	public Date getStatusDate() {
		return statusDate;
	}
	public void setStatusDate(Date statusDate) {
		this.statusDate = statusDate;
	}
	public Byte getType() {
		return type;
	}
	public void setType(Byte type) {
		this.type = type;
	}
	public String getInstituteId() {
		return instituteId;
	}
	public void setInstituteId(String instituteId) {
		this.instituteId = instituteId;
	}
	public String getBirthcity() {
		return birthcity;
	}
	public void setBirthcity(String birthcity) {
		this.birthcity = birthcity;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Byte getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(Byte bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getCellPhone() {
		return cellPhone;
	}
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
	public BigDecimal getEducationLevel() {
		return educationLevel;
	}
	public void setEducationLevel(BigDecimal educationLevel) {
		this.educationLevel = educationLevel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public BigDecimal getFavoriteColor() {
		return favoriteColor;
	}
	public void setFavoriteColor(BigDecimal favoriteColor) {
		this.favoriteColor = favoriteColor;
	}
	public Byte getGender() {
		return gender;
	}
	public void setGender(Byte gender) {
		this.gender = gender;
	}
	public String getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}
	public String getHomePostalCode() {
		return homePostalCode;
	}
	public void setHomePostalCode(String homePostalCode) {
		this.homePostalCode = homePostalCode;
	}
	public String getHomeTel() {
		return homeTel;
	}
	public void setHomeTel(String homeTel) {
		this.homeTel = homeTel;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public Date getMarriageDate() {
		return marriageDate;
	}
	public void setMarriageDate(Date marriageDate) {
		this.marriageDate = marriageDate;
	}
	public Byte getMarriageStatus() {
		return marriageStatus;
	}
	public void setMarriageStatus(Byte marriageStatus) {
		this.marriageStatus = marriageStatus;
	}
	public String getNationalId() {
		return nationalId;
	}
	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}
	public String getPassportId() {
		return passportId;
	}
	public void setPassportId(String passportId) {
		this.passportId = passportId;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public Byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(Byte[] photo) {
		this.photo = photo;
	}
	public String getPostAddress() {
		return postAddress;
	}
	public void setPostAddress(String postAddress) {
		this.postAddress = postAddress;
	}
	public String getMiprsweburl() {
		return miprsweburl;
	}
	public void setMiprsweburl(String miprsweburl) {
		this.miprsweburl = miprsweburl;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getWorkAddress() {
		return workAddress;
	}
	public void setWorkAddress(String workAddress) {
		this.workAddress = workAddress;
	}
	public String getWorkPostalCode() {
		return workPostalCode;
	}
	public void setWorkPostalCode(String workPostalCode) {
		this.workPostalCode = workPostalCode;
	}
	public String getWorkTel() {
		return workTel;
	}
	public void setWorkTel(String workTel) {
		this.workTel = workTel;
	}
	
	public List<CardInformation> getCardInformations() {
		return cardInformations;
	}
	public void setCardInformations(List<CardInformation> cardInformations) {
		this.cardInformations = cardInformations;
	}
	
	public boolean isAutoGenerate() {
		return autoGenerate;
	}
	public void setAutoGenerate(boolean autoGenerate) {
		this.autoGenerate = autoGenerate;
	}
	@Override
	public String toString() {
		return "MemberInformation [memberId=" + memberId + ", latinName="
				+ latinName + ", loginPassword=" + loginPassword
				+ ", loginUser=" + loginUser + ", name=" + name + ", status="
				+ status + ", statusDate=" + statusDate + ", type=" + type
				+ ", instituteId=" + instituteId + ", birthcity=" + birthcity
				+ ", birthday=" + birthday + ", bloodGroup=" + bloodGroup
				+ ", cellPhone=" + cellPhone + ", educationLevel="
				+ educationLevel + ", email=" + email + ", fatherName="
				+ fatherName + ", favoriteColor=" + favoriteColor + ", gender="
				+ gender + ", homeAddress=" + homeAddress + ", homePostalCode="
				+ homePostalCode + ", homeTel=" + homeTel + ", motherName="
				+ motherName + ", marriageDate=" + marriageDate
				+ ", marriageStatus=" + marriageStatus + ", nationalId="
				+ nationalId + ", passportId=" + passportId + ", picture="
				+ picture + ", photo=" + Arrays.toString(photo)
				+ ", postAddress=" + postAddress + ", miprsweburl="
				+ miprsweburl + ", signature=" + signature + ", workAddress="
				+ workAddress + ", workPostalCode=" + workPostalCode
				+ ", workTel=" + workTel + ", cardInformations="
				+ cardInformations + ", autoGenerate=" + autoGenerate + "]";
	}
	
	
	
	
	
}
