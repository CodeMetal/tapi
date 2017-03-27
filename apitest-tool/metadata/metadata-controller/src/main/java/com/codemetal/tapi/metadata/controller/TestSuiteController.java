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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codemetal.tapi.metadata.TestSuite;
import com.codemetal.tapi.metadata.service.TestSuiteService;

/**
 * 
 * @author santhosh
 *
 */

@RestController
@RequestMapping(value="/testSuite")
public class TestSuiteController {
	
	@Autowired
	private TestSuiteService testSuiteService;
	
	/**
	 * creates new testSuite
	 * @param testSuite
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TestSuite> createTestSuite(@RequestBody TestSuite testSuite){
		TestSuite testSuiteResp = testSuiteService.createTestSuite(testSuite);
		return new ResponseEntity<TestSuite>(testSuiteResp, HttpStatus.OK);
	}
	
	/***
	 * updates existing testSuite
	 * @param testSuite
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TestSuite> updateTestSuite(@RequestBody TestSuite testSuite){
		TestSuite testSuiteResp = testSuiteService.updateTestSuite(testSuite);
		return new ResponseEntity<TestSuite>(testSuiteResp, HttpStatus.OK);
	}
	
	/***
	 * lists all testSuites 
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TestSuite>> testSuiteList(){
		List<TestSuite> testSuiteList = testSuiteService.getTestSuites();
		return new ResponseEntity<List<TestSuite>>(testSuiteList, HttpStatus.OK);
	}
	
	/***
	 * gets testSuite by name
	 * @param name
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TestSuite> testSuiteByName(@RequestParam("name") String name){
		TestSuite testSuiteResp = testSuiteService.findByName(name);
		return new ResponseEntity<TestSuite>(testSuiteResp, HttpStatus.OK);
	}
	
	/**
	 * deletes existing testSuite
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TestSuite> deleteTestSuite(@PathVariable String id){
		testSuiteService.deleteTestSuite(id);
		return new ResponseEntity<TestSuite>(HttpStatus.OK);
	}

}
