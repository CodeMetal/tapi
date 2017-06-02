package com.codemetal.tapi.metadata.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codemetal.tapi.metadata.Header;
import com.codemetal.tapi.metadata.RequestParam;
import com.codemetal.tapi.metadata.TestCaseDetails;
import com.codemetal.tapi.metadata.TestCaseInput;
import com.codemetal.tapi.metadata.TestCaseResult;
import com.codemetal.tapi.metadata.service.TestCaseService;

/**
 * 
 * @author santhosh
 *
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/testCase")
public class TestCaseController {

	@Autowired
	TestCaseService testCaseService;

	/**
	 * 
	 * @param testCase
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TestCaseDetails> saveTestCase(@RequestBody TestCaseDetails testCase) {
		TestCaseDetails testCaseResp = testCaseService.createTestCase(testCase);
		return new ResponseEntity<TestCaseDetails>(testCaseResp, HttpStatus.OK);
	}

	/**
	 * 
	 * @param testCase
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TestCaseDetails> updateTestCase(@RequestBody TestCaseDetails testCase) {
		TestCaseDetails testCaseResp = testCaseService.updateTestcase(testCase);
		return new ResponseEntity<TestCaseDetails>(testCaseResp, HttpStatus.OK);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TestCaseDetails> deleteTestCase(@PathVariable String id) {
		testCaseService.deleteTestCase(id);
		return new ResponseEntity<TestCaseDetails>(HttpStatus.OK);
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TestCaseDetails>> testCaseList() {
		List<TestCaseDetails> testCaseList = testCaseService.getTestCases();
		return new ResponseEntity<List<TestCaseDetails>>(testCaseList, HttpStatus.OK);
	}

	@RequestMapping(value = "/jsonBody", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TestCaseDetails> getTestCaseJson() {
		TestCaseDetails testCaseDet = new TestCaseDetails();
		testCaseDet.setEndPointHost("localhost:");
		testCaseDet.setEndPointPort(8080);
		testCaseDet.setEndPointURI("/getTestCase");
		testCaseDet.setHttp(true);
		TestCaseInput input = new TestCaseInput();
		RequestParam rp = new RequestParam();
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("header1", "abc");
		paramMap.put("header2", "def");
		rp.setParams(paramMap);

		input.setParam(rp);

		Object obj = new String("Obj");
		input.setInput(obj);
		testCaseDet.setInput(input);

		Header requestHeader = new Header();
		requestHeader.setHeaders(paramMap);

		testCaseDet.setRequestHeader(requestHeader);

		testCaseDet.setRequestMethod(RequestMethod.GET);

		//testCaseDet.setResponseType(MediaType.APPLICATION_JSON);

		TestCaseResult result = new TestCaseResult();
		result.setResponseStatus(HttpStatus.PROCESSING);
		Header responseHeader = new Header();
		responseHeader.setHeaders(paramMap);

		result.setResponseHeader(responseHeader);
		Object responseBody = new String("responseBody");

		result.setResponseBody(responseBody);

		testCaseDet.setResult(result);
		testCaseDet.setScenarioDescription("Scenario");
		testCaseDet.setScenarioName("name");
		testCaseDet.setShouldOverrideHostAddress(true);
		testCaseDet.setTestSuiteId("123");
		return new ResponseEntity<TestCaseDetails>(testCaseDet, HttpStatus.OK);

	}

}
