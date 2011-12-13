package com.sahand.issuer.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.sahand.acquirer.data.InstituteIdValidation;

public class ProgramPartnerInformation implements Serializable {

    
	@NotNull(message = "{institute.id.NOTNULL}",groups = partnersValidation.class)
	private String institueId;
	
	@Size(max = 99 ,message = "{program.partner.type.LENGTH} {max}",groups = partnersValidation.class)
	@NotNull(message = "{program.partner.type.NOTNULL}",groups = partnersValidation.class)
    private Integer partnerType;
	
    private Long feeSchemeId;
	
 
	public String getInstitueId() {
		return institueId;
	}


	public void setInstitueId(String institueId) {
		this.institueId = institueId;
	}


	public Integer getPartnerType() {
		return partnerType;
	}


	public void setPartnerType(Integer partnerType) {
		this.partnerType = partnerType;
	}


	public Long getFeeSchemeId() {
		return feeSchemeId;
	}


	public void setFeeSchemeId(Long feeSchemeId) {
		this.feeSchemeId = feeSchemeId;
	}

	@Override
	public String toString() {
		return "ProgramPartnerInformation [institueId=" + institueId
				+ ", partnerType=" + partnerType + ", feeSchemeId="
				+ feeSchemeId + "]";
	}
	
	
	
}
