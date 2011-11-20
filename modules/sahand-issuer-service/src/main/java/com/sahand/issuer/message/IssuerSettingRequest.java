package com.sahand.issuer.message;

import com.sahand.common.util.message.RequestHeader;
import com.sahand.issuer.data.CardSetting;
import com.sahand.issuer.data.MemberInformation;


public class IssuerSettingRequest extends RequestHeader{
	
	private MemberInformation memberInformation;
	private CardSetting cardSetting;
	public MemberInformation getMemberInformation() {
		return memberInformation;
	}
	public void setMemberInformation(MemberInformation memberInformation) {
		this.memberInformation = memberInformation;
	}
	public CardSetting getCardSetting() {
		return cardSetting;
	}
	public void setCardSetting(CardSetting cardSetting) {
		this.cardSetting = cardSetting;
	}
	@Override
	public String toString() {
		return "IssuerSettingRequest [memberInformation=" + memberInformation
				+ ", cardSetting=" + cardSetting + "]";
	}
	
	
	
	
}
