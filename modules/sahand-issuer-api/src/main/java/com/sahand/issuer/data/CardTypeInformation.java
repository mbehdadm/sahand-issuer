package com.sahand.issuer.data;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CardTypeInformation implements Serializable {

	
	@NotNull( message="{card.type.id.NOTNULL}" ,groups=CardTypeIdValidation.class)
	private Integer id;
	
	@Size(max=30,message="{card.type.pin.format.LENGTH} {max}")
	private String panFormat;
	
	@Max(value = 99,message="{card.type.pin.encription.MAX} {value}")
	@NotNull(message = "{card.type.pin.encryption.NOTNULL}")
	private Byte pinEncrytion;
	
	
	@Max(value = 99,message="{card.type.pin.format.MAX} {value}")
	@NotNull(message = "{card.type.pin.format.NOTNULL}")
	private Byte pinFormat;
	
	private Byte authorization;
	private Byte authentication;
	
	@NotNull(message="{card.type.application.NOTNULL}")
	private Integer application;
	
	@Max(value = 999,message="{card.type.service.code.MAX} {value}")
	@NotNull(message="{card.type.service.code.NOTNULL}")
	private Short defaultServiceCode;
	
	@Size(max=2,message="{card.type.date.format.LENGTH}{max}")
	@NotNull(message="{card.type.date.format.NOTNULL}")
	private Byte trackDataFormat;
	@NotNull(message="{card.type.description.NOTNULL}")
	private String description;
	//generate type
	private boolean autoGenerate;
	
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
	
	public boolean isAutoGenerate() {
		return autoGenerate;
	}
	public void setAutoGenerate(boolean autoGenerate) {
		this.autoGenerate = autoGenerate;
	}
	@Override
	public String toString() {
		return "CardTypeInformation [id=" + id + ", panFormat=" + panFormat
				+ ", pinEncrytion=" + pinEncrytion + ", pinFormat=" + pinFormat
				+ ", authorization=" + authorization + ", authentication="
				+ authentication + ", application=" + application
				+ ", defaultServiceCode=" + defaultServiceCode
				+ ", trackDataFormat=" + trackDataFormat + ", description="
				+ description + ", autoGenerate=" + autoGenerate + "]";
	}
	
	



}
