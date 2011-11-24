package com.sahand.issuer.message;

import com.sahand.acquirer.data.InstituteInformation;
import com.sahand.common.util.message.RequestHeader;
import com.sahand.issuer.data.CardInformation;
import com.sahand.issuer.data.CardTypeInformation;
import com.sahand.issuer.data.MemberInformation;
import com.sahand.issuer.data.ProgramInformation;
import com.sahand.issuer.data.ProgramParameterInformation;

public class IssuerSetupRequest extends RequestHeader{
	
	private ProgramInformation program;
	
	private InstituteInformation institute;
	private CardTypeInformation cardType;
	
	private MemberInformation member;
	private CardInformation card;


	public ProgramInformation getProgram() {
		return program;
	}
	public void setProgram(ProgramInformation program) {
		this.program = program;
	}
	public InstituteInformation getInstitute() {
		return institute;
	}
	public void setInstitute(InstituteInformation institute) {
		this.institute = institute;
	}
	public CardTypeInformation getCardType() {
		return cardType;
	}
	public void setCardType(CardTypeInformation cardType) {
		this.cardType = cardType;
	}
	
	public MemberInformation getMember() {
		return member;
	}
	public void setMember(MemberInformation member) {
		this.member = member;
	}
	
	public CardInformation getCard() {
		return card;
	}
	public void setCard(CardInformation card) {
		this.card = card;
	}
	@Override
	public String toString() {
		return "IssuerSetupRequest [program=" + program + ", institute="
				+ institute + ", cardType=" + cardType + ", member=" + member
				+ ", card=" + card + ", toString()=" + super.toString() + "]";
	}
	
	
	
	
	
	
	
}
