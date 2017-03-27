package com.codemetal.tapi.metadata.service;

import java.util.List;

import com.codemetal.tapi.metadata.TestCaseDetails;

public interface TestCaseService {
	
	public TestCaseDetails createTestCase(TestCaseDetails testCase);
	
	public TestCaseDetails updateTestcase(TestCaseDetails testCase);
	
	public void deleteTestCase(String id);
	
	public List<TestCaseDetails> getTestCases();
}
