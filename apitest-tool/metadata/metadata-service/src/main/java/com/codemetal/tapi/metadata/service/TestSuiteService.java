package com.codemetal.tapi.metadata.service;

import java.util.List;

import com.codemetal.tapi.metadata.TestSuite;

/**
 * 
 * @author santhosh
 *
 */
public interface TestSuiteService {

	public TestSuite createTestSuite(TestSuite testSuite);
	
	public TestSuite updateTestSuite(TestSuite testSuite);
	
	public void deleteTestSuite(String id);
	
	public List<TestSuite> getTestSuites();
	
	public TestSuite findByName(String name);
	
}
