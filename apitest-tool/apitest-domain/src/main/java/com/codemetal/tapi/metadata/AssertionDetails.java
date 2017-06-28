package com.codemetal.tapi.metadata;

/**
 * This class represents the various Assertions that would be performed on the Test Case Result
 * @author Raghuveer Bhandarkar
 *
 */
public class AssertionDetails {
	
	/*Predicate Expression which would be evaluated for assertion*/
	private String predicate;
	
	/*DataType of the Predicate expression value*/
	private DataType dataType;
	
	/*Format of the data (if any), for example, Date format*/
	private String dataFormat;
	
	/*String representation of the expected value of a Predicate*/
	private String expectedValue;
	
	/*Operator used for evaluating the predicate*/
	private Operator operator; 
	
	private AssertionType assertionType;
	
	/*Result of the assertion*/
	private boolean result;
	
	public String getPredicate() {
		return predicate;
	}

	public void setPredicate(String predicate) {
		this.predicate = predicate;
	}

	public DataType getDataType() {
		return dataType;
	}

	public void setDataType(DataType dataType) {
		this.dataType = dataType;
	}

	public AssertionType getAssertionType() {
		return assertionType;
	}

	public void setAssertionType(AssertionType assertionType) {
		this.assertionType = assertionType;
	}

	public String getExpectedValue() {
		return expectedValue;
	}

	public void setExpectedValue(String expectedValue) {
		this.expectedValue = expectedValue;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public String getDataFormat() {
		return dataFormat;
	}

	public void setDataFormat(String dataFormat) {
		this.dataFormat = dataFormat;
	}
	
	
}
