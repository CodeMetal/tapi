package com.codemetal.tapi.metadata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codemetal.tapi.metadata.TestCaseDetails;
import com.codemetal.tapi.metadata.service.TestCaseService;

/**
 * 
 * @author santhosh
 *
 */

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
	public ResponseEntity<TestCaseDetails> saveTestCase(@RequestBody TestCaseDetails testCase){
		TestCaseDetails testCaseResp = testCaseService.createTestCase(testCase);
		return new ResponseEntity<TestCaseDetails>(testCaseResp, HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param testCase
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TestCaseDetails> updateTestCase(@RequestBody TestCaseDetails testCase){
		TestCaseDetails testCaseResp = testCaseService.updateTestcase(testCase);
		return new ResponseEntity<TestCaseDetails>(testCaseResp, HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TestCaseDetails> deleteTestCase(@PathVariable String id){
		testCaseService.deleteTestCase(id);
		return new ResponseEntity<TestCaseDetails>(HttpStatus.OK);
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TestCaseDetails>> testCaseList(){
		List<TestCaseDetails> testCaseList = testCaseService.getTestCases();
		return new ResponseEntity<List<TestCaseDetails>>(testCaseList, HttpStatus.OK);
	}

}
