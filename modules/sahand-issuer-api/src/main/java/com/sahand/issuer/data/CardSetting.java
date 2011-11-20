package com.sahand.issuer.data;

import com.sahand.issuer.enumeration.CardStatus;
import com.sahand.issuer.enumeration.CardStatusReason;

public class CardSetting {

	
    private String confirmNewPassword;
    private String confirmNewPin;
    private String newPassword;
    private String newPin;
    private String pan;
    private String password;
    private String pin;
    private CardStatus status;
    private CardStatusReason statusReason;
    
	public String getConfirmNewPassword() {
		return confirmNewPassword;
	}
	public void setConfirmNewPassword(String confirmNewPassword) {
		this.confirmNewPassword = confirmNewPassword;
	}
	public String getConfirmNewPin() {
		return confirmNewPin;
	}
	public void setConfirmNewPin(String confirmNewPin) {
		this.confirmNewPin = confirmNewPin;
	}
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
	public CardStatus getStatus() {
		return status;
	}
	public void setStatus(CardStatus status) {
		this.status = status;
	}
	public CardStatusReason getStatusReason() {
		return statusReason;
	}
	public void setStatusReason(CardStatusReason statusReason) {
		this.statusReason = statusReason;
	}
	@Override
	public String toString() {
		return "CardSetting [confirmNewPassword=" + confirmNewPassword
				+ ", confirmNewPin=" + confirmNewPin + ", newPassword="
				+ newPassword + ", newPin=" + newPin + ", pan=" + pan
				+ ", password=" + password + ", pin=" + pin + ", status="
				+ status + ", statusReason=" + statusReason + "]";
	}
    
    
    
}
