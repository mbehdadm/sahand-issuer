package com.sahand.issuer.data;


public class CardSetting {
	
    private String newPassword;
    private String newPin;
    private String pan;
    private String password;
    private String pin;
    private Byte status;
    private Byte statusReason;
    
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getNewPin() {
		return newPin;
	}
	public void setNewPin(String newPin) {
		this.newPin = newPin;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public Byte getStatus() {
		return status;
	}
	public void setStatus(Byte status) {
		this.status = status;
	}
	public Byte getStatusReason() {
		return statusReason;
	}
	public void setStatusReason(Byte statusReason) {
		this.statusReason = statusReason;
	}
	@Override
	public String toString() {
		return "CardSetting [newPassword=" + newPassword + ", newPin=" + newPin
				+ ", pan=" + pan + ", password=" + password + ", pin=" + pin
				+ ", status=" + status + ", statusReason=" + statusReason + "]";
	}
    
    
    
}
