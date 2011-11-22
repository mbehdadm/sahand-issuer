package com.sahand.issuer.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProgramInformation implements Serializable {

    private Long programId;
    private boolean autoGenerate;
    private String name;
    private String displayName;
    private String description;
    private String rules;
    private String limitation;
	
    private List<ProgramParameterInformation> parameterInformations = new ArrayList<ProgramParameterInformation>();
	
	
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
	@Override
	public String toString() {
		return "ProgramInformation [programId=" + programId + ", autoGenerate="
				+ autoGenerate + ", name=" + name + ", displayName="
				+ displayName + ", description=" + description + ", rules="
				+ rules + ", limitation=" + limitation
				+ ", parameterInformations=" + parameterInformations + "]";
	}
	
	
	
}
