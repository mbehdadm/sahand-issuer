package com.sahand.issuer.data;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * Class level constraints are useful if 
 * it is necessary to inspect more than a single property of the class to validate it 
 * or if a correlation between different state variables has to be evaluated
 *
 */

public class ProgramParameterInformation implements Serializable {

	@Max(value = 9999,message = "{program.parameter.type.LENGTH} {value}",groups=parametersValidation.class)
	@NotNull(message = "{program.parameter.type.NOTNULL}",groups=parametersValidation.class)
    private Integer programParameterTypes ;
	
	@Size(max = 100 ,message = "{program.parameter.value.LENGTH} {max}",groups=parametersValidation.class)
	@NotNull(message = "{program.parameter.value.NOTNULL}",groups=parametersValidation.class)
	private String value ;
	
	@Max(value = 99,message = "{program.parameter.value.DataType.LENGTH} {value}",groups=parametersValidation.class)
	@NotNull(message = "{program.parameter.value.DataType.NOTNULL}",groups=parametersValidation.class)
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
