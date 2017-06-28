package com.codemetal.tapi.assertion;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.codemetal.tapi.metadata.AssertionDetails;
import com.codemetal.tapi.metadata.AssertionType;
import com.codemetal.tapi.metadata.TestCaseResult;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;

/**
 * This class would implement Assertions for validating the Test Scenarios
 * @author Raghuveer Bhandarkar
 *
 */
public class AssertionService {
	
	/*Expected Result for this Test Case*/
	private TestCaseResult expectedResult;
	
	/*Result returned after the actual Rest Call*/
	private String actualResultJson;
	
	/*HTTP Status code returned after the actual Rest Call */
	private int actualStatusCode;
	
	/*Document representation of the actualResultJson*/
	private Object document;
	
	public AssertionService(int actualStatusCode, String actualResultJson, TestCaseResult expectedResult){
		this.actualResultJson = actualResultJson;
		this.expectedResult = expectedResult;
		this.actualStatusCode = actualStatusCode;
		parseJson();
	}
	
	/**
	 * Parse the provided Json expression once
	 */
	private synchronized void parseJson(){
		this.document = Configuration.defaultConfiguration().jsonProvider().parse(actualResultJson);		
	}
	
	/**
	 * Asserts all the expressions provided by parsing the Json expressions.
	 */
	public void assertPredicates(){
		
		for(AssertionDetails assertion: expectedResult.getAssertionList()){	
			if(assertion.getAssertionType().equals(AssertionType.PREDICATE)){
				String value = retrieveResult(assertion.getPredicate());
				DataComparator comparator = new DataComparator(assertion.getExpectedValue(), value, assertion.getDataType(), 
																assertion.getOperator(), assertion.getDataFormat());
				boolean match = comparator.compare();
				
				assertion.setResult(match);
			}
			else if(assertion.getAssertionType().equals(AssertionType.RESPONSE_STATUS)){
				/*Assert status code*/
				HttpStatus actualStatus = HttpStatus.valueOf(actualStatusCode);
				if(actualStatus.equals(expectedResult.getResponseStatus())){
					assertion.setResult(true);
				}
			}
			
						
		}
	}
	
	/**
	 * Retrieve  a single result from the expression provided
	 * @param expression
	 * @return
	 */
	public String retrieveResult(String expression){
		return JsonPath.read(document, expression);
	}
	
	
}
