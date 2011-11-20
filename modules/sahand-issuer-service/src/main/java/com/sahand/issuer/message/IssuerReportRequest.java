package com.sahand.issuer.message;

import com.sahand.common.util.message.RequestHeader;
import com.sahand.issuer.data.CardSetting;


public class IssuerReportRequest extends RequestHeader{
	
	
	private CardSetting cardSetting;

	public CardSetting getCardSetting() {
		return cardSetting;
	}

	public void setCardSetting(CardSetting cardSetting) {
		this.cardSetting = cardSetting;
	}

	@Override
	public String toString() {
		return "IssuerReportRequest [cardSetting=" + cardSetting + "]";
	}
	
	
	
}
