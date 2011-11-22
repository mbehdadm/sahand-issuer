package com.sahand.issuer.data;

import java.io.Serializable;

public class ProgramParameterInformation implements Serializable {

    private Integer programParameterTypes ;
	private String value ;
	private Integer valueDataType ;
	
	public Integer getProgramParameterTypes() {
		return programParameterTypes;
	}
	public void setProgramParameterTypes(Integer programParameterTypes) {
		this.programParameterTypes = programParameterTypes;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Integer getValueDataType() {
		return valueDataType;
	}
	public void setValueDataType(Integer valueDataType) {
		this.valueDataType = valueDataType;
	}
	@Override
	public String toString() {
		return "ProgramParameterInformation [programParameterTypes="
				+ programParameterTypes + ", value=" + value
				+ ", valueDataType=" + valueDataType + "]";
	}
	
	

	
}
