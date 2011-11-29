package com.sahand.issuer.message;

import com.sahand.common.util.message.RequestHeader;
import com.sahand.issuer.data.MissingTransactionInformation;
import com.sahand.issuer.enumeration.RegisterarType;

public class IssuerAuthorizerSetupRequest extends RequestHeader{
	
	private MissingTransactionInformation missingTransactionInformation;
	private InstituteInformation institute;
	private RegisterarType registerarType;

	public MissingTransactionInformation getMissingTransactionInformation() {
		return missingTransactionInformation;
	}

	public void setMissingTransactionInformation(
			MissingTransactionInformation missingTransactionInformation) {
		this.missingTransactionInformation = missingTransactionInformation;
	}
	public InstituteInformation getInstitute() {
		return institute;
	}
	public void setInstitute(InstituteInformation institute) {
		this.institute = institute;
	}

	public RegisterarType getRegisterarType() {
		return registerarType;
	}

	public void setRegisterarType(RegisterarType registerarType) {
		this.registerarType = registerarType;
	}

	@Override
	public String toString() {
		return "IssuerAuthorizerSetupRequest [missingTransactionInformation="
				+ missingTransactionInformation + ", registerarType="
				+ registerarType + "]";
	}

}
