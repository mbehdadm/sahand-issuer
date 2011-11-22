package com.sahand.issuer.message;

import com.sahand.acquirer.data.InstituteInformation;
import com.sahand.common.util.message.ResponseHeader;
import com.sahand.issuer.data.CardTypeInformation;
import com.sahand.issuer.data.MemberInformation;
import com.sahand.issuer.data.ProgramInformation;

public class IssuerSetupResponse extends ResponseHeader {

	private ProgramInformation program;
	
	private InstituteInformation institute;
	private CardTypeInformation cardType;
	
	private MemberInformation member;
	
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
	@Override
	public String toString() {
		return "IssuerSetupResponse [program=" + program + ", institute="
				+ institute + ", cardType=" + cardType + ", member=" + member
				+ "]";
	}
	
	
	
	
}
