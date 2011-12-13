package com.sahand.issuer.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProgramInformation implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull(message = "{program.id.NOTNULL}",groups = ProgramIdValidation.class)
    private Long programId;
	
	@Size(max = 100,message = "{program.name.LENGTH} {max}")
	@NotNull(message = "{program.name.NOTNULL}")
    private String name;

	@Size(max = 32,message = "{program.display.name.LENGTH} {max}")
	@NotNull(message = "{program.display.name.NOTNULL}")
    private String displayName;
    private String description;
    private String rules;
    private String limitation;
	
    @NotNull(message = "{program.parameters.NOTNULL}",groups = parametersValidation.class)
    private List<ProgramParameterInformation> parameterInformations = new ArrayList<ProgramParameterInformation>();
    
    @NotNull(message = "{program.parameters.NOTNULL}",groups = partnersValidation.class)
    private List<ProgramPartnerInformation> partnerInformations = new ArrayList<ProgramPartnerInformation>();
    
    //generate type
    private boolean autoGenerate;
    
	public Long getProgramId() {
		return programId;
	}
	public void setProgramId(Long programId) {
		this.programId = programId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRules() {
		return rules;
	}
	public void setRules(String rules) {
		this.rules = rules;
	}
	public String getLimitation() {
		return limitation;
	}
	public void setLimitation(String limitation) {
		this.limitation = limitation;
	}
	
	public boolean isAutoGenerate() {
		return autoGenerate;
	}
	public void setAutoGenerate(boolean autoGenerate) {
		this.autoGenerate = autoGenerate;
	}
	public List<ProgramParameterInformation> getParameterInformations() {
		return parameterInformations;
	}
	public void setParameterInformations(
			List<ProgramParameterInformation> parameterInformations) {
		this.parameterInformations = parameterInformations;
	}
	public List<ProgramPartnerInformation> getPartnerInformations() {
		return partnerInformations;
	}
	public void setPartnerInformations(
			List<ProgramPartnerInformation> partnerInformations) {
		this.partnerInformations = partnerInformations;
	}
	@Override
	public String toString() {
		return "ProgramInformation [programId=" + programId + ", name=" + name
				+ ", displayName=" + displayName + ", description="
				+ description + ", rules=" + rules + ", limitation="
				+ limitation + ", parameterInformations="
				+ parameterInformations + ", partnerInformations="
				+ partnerInformations + ", autoGenerate=" + autoGenerate + "]";
	}
	
	
	
}
