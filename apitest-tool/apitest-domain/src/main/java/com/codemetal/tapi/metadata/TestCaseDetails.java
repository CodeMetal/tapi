package com.codemetal.tapi.metadata;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;



/**
 * This class represents a TestCase which will be executed as a JUnit testcase
 * 
 * @author Raghuveer Bhandarkar
 *
 */

public class TestCaseDetails implements Serializable {

	private static final long serialVersionUID = 102L;

	/* Mongodb id for the TestCaseDetails */
	@Id
	public String id;

	/* Id of the testsuite to which this testcase belongs */
	public String testSuiteId;

	

	/* Scenario Name for the TestCase */
	private String scenarioName;

	/* Scenario Description for the TestCase */
	private String scenarioDescription;

	/* API End point URI (Excluding the host address) */
	private String endPointURI;

	/* API End point Host address (either domain name or IP) */
	private String endPointHost;

	/* API End point Port */
	private int endPointPort;

	/* HTTP Request Method for the API */
	private RequestMethod requestMethod;

	/* HTTP Response Type for the API */
	private String responseType;

	/* Request Header for the API */
	private Header requestHeader;

	/*
	 * Flag to indicate if the environment value should take precedence
	 * over @endPointHost
	 */
	private boolean shouldOverrideHostAddress;

	/* Input to a TestCase */
	private TestCaseInput input;

	/* Output of a TestCase */
	private TestCaseResult result;

	/* Flag for http */
	boolean isHttp;

	public String getScenarioName() {
		return scenarioName;
	}

	public void setScenarioName(String scenarioName) {
		this.scenarioName = scenarioName;
	}

	public String getScenarioDescription() {
		return scenarioDescription;
	}

	public void setScenarioDescription(String scenarioDescription) {
		this.scenarioDescription = scenarioDescription;
	}

	public String getEndPointURI() {
		return endPointURI;
	}

	public void setEndPointURI(String endPointURI) {
		this.endPointURI = endPointURI;
	}

	public String getEndPointHost() {
		return endPointHost;
	}

	public void setEndPointHost(String endPointHost) {
		this.endPointHost = endPointHost;
	}

	public RequestMethod getRequestMethod() {
		return requestMethod;
	}

	public void setRequestMethod(RequestMethod requestMethod) {
		this.requestMethod = requestMethod;
	}

	public String getResponseType() {
		return responseType;
	}

	public void setResponseType(String responseType) {
		this.responseType = responseType;
	}

	public Header getRequestHeader() {
		return requestHeader;
	}

	public void setRequestHeader(Header requestHeader) {
		this.requestHeader = requestHeader;
	}

	public boolean isShouldOverrideHostAddress() {
		return shouldOverrideHostAddress;
	}

	public void setShouldOverrideHostAddress(boolean shouldOverrideHostAddress) {
		this.shouldOverrideHostAddress = shouldOverrideHostAddress;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public TestCaseInput getInput() {
		return input;
	}

	public void setInput(TestCaseInput input) {
		this.input = input;
	}

	public TestCaseResult getResult() {
		return result;
	}

	public void setResult(TestCaseResult result) {
		this.result = result;
	}

	public boolean isHttp() {
		return isHttp;
	}

	public void setHttp(boolean isHttp) {
		this.isHttp = isHttp;
	}

	public int getEndPointPort() {
		return endPointPort;
	}

	public void setEndPointPort(int endPointPort) {
		this.endPointPort = endPointPort;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTestSuiteId() {
		return testSuiteId;
	}

	public void setTestSuiteId(String testSuiteId) {
		this.testSuiteId = testSuiteId;
	}

}
