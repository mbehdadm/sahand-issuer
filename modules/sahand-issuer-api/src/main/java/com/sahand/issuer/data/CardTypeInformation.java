package com.sahand.issuer.data;

import java.io.Serializable;

public class CardTypeInformation implements Serializable {

	private Integer id;
	private String panFormat;
	private Byte pinEncrytion;
	private Byte pinFormat;
	private Byte authorization;
	private Byte authentication;
	private Integer application;
	private Short defaultServiceCode;
	private Byte trackDataFormat;
	private String description;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPanFormat() {
		return panFormat;
	}
	public void setPanFormat(String panFormat) {
		this.panFormat = panFormat;
	}
	public Byte getPinEncrytion() {
		return pinEncrytion;
	}
	public void setPinEncrytion(Byte pinEncrytion) {
		this.pinEncrytion = pinEncrytion;
	}
	public Byte getPinFormat() {
		return pinFormat;
	}
	public void setPinFormat(Byte pinFormat) {
		this.pinFormat = pinFormat;
	}
	public Byte getAuthorization() {
		return authorization;
	}
	public void setAuthorization(Byte authorization) {
		this.authorization = authorization;
	}
	public Byte getAuthentication() {
		return authentication;
	}
	public void setAuthentication(Byte authentication) {
		this.authentication = authentication;
	}
	public Integer getApplication() {
		return application;
	}
	public void setApplication(Integer application) {
		this.application = application;
	}
	public Short getDefaultServiceCode() {
		return defaultServiceCode;
	}
	public void setDefaultServiceCode(Short defaultServiceCode) {
		this.defaultServiceCode = defaultServiceCode;
	}
	public Byte getTrackDataFormat() {
		return trackDataFormat;
	}
	public void setTrackDataFormat(Byte trackDataFormat) {
		this.trackDataFormat = trackDataFormat;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "CardTypeInformation [id=" + id + ", panFormat=" + panFormat
				+ ", pinEncrytion=" + pinEncrytion + ", pinFormat=" + pinFormat
				+ ", authorization=" + authorization + ", authentication="
				+ authentication + ", application=" + application
				+ ", defaultServiceCode=" + defaultServiceCode
				+ ", trackDataFormat=" + trackDataFormat + ", description="
				+ description + "]";
	}
	
	



}
