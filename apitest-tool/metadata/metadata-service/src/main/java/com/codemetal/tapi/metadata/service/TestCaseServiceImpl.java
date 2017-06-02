package com.codemetal.tapi.metadata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codemetal.tapi.metadata.TestCaseDetails;
import com.codemetal.tapi.metadata.TestSuite;
import com.codemetal.tapi.metadata.repository.TestCaseRepository;
import com.codemetal.tapi.metadata.service.TestCaseService;
/**
 * 
 * @author santhosh
 *
 */

@Service
public class TestCaseServiceImpl implements TestCaseService{

	@Autowired
	TestCaseRepository testCaseRepository;
	
	@Autowired
	TestCaseValidator testCaseValidator;
	
	@Override
	public TestCaseDetails createTestCase(TestCaseDetails testCase) {
		testCaseValidator.validateTestCase(testCase);
		return testCaseRepository.save(testCase);
	}

	@Override
	public TestCaseDetails updateTestcase(TestCaseDetails testCase) {
		testCaseValidator.validateTestCase(testCase);
		return testCaseRepository.save(testCase);
	}

	@Override
	public void deleteTestCase(String id) {
		testCaseRepository.delete(id);
	}

	@Override
	public List<TestCaseDetails> getTestCases() {
		
		return (List<TestCaseDetails>)testCaseRepository.findAll(); 

		
	}

}
