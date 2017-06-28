package com.codemetal.tapi.metadata;

import java.util.List;

import org.springframework.http.HttpStatus;

/**
 * This class represents the expected result of a TestCase
 * @author Raghuveer Bhandarkar
 *
 */
public class TestCaseResult {
	/*Expected Response Status for a TestCase Response*/
	private HttpStatus responseStatus;
	
	/*Expected Response Body for a TestCase Response*/
	private Object responseBody;
	
	/*Expected Response Header for the API*/
	private Header responseHeader;
	
	/*List of Assertions required for asserting the TestCase Results*/
	private List<AssertionDetails> assertionList;

	public HttpStatus getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(HttpStatus responseStatus) {
		this.responseStatus = responseStatus;
	}

	public Object getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(Object responseBody) {
		this.responseBody = responseBody;
	}

	public Header getResponseHeader() {
		return responseHeader;
	}

	public void setResponseHeader(Header responseHeader) {
		this.responseHeader = responseHeader;
	}

	public List<AssertionDetails> getAssertionList() {
		return assertionList;
	}

	public void setAssertionList(List<AssertionDetails> assertionList) {
		this.assertionList = assertionList;
	}
	
	
	
}
