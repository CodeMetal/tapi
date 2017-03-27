package com.codemetal.tapi.metadata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codemetal.tapi.metadata.TestCaseDetails;
import com.codemetal.tapi.metadata.repository.TestCaseRepository;

/**
 * 
 * @author santhosh
 *
 */

@Service
public class TestCaseServiceImpl implements TestCaseService{

	@Autowired
	TestCaseRepository testCaseRepository;
	
	@Override
	public TestCaseDetails createTestCase(TestCaseDetails testCase) {
		return testCaseRepository.save(testCase);
	}

	@Override
	public TestCaseDetails updateTestcase(TestCaseDetails testCase) {
		return testCaseRepository.save(testCase);
	}

	@Override
	public void deleteTestCase(String id) {
		testCaseRepository.delete(id);
	}

	@Override
	public List<TestCaseDetails> getTestCases() {
		return testCaseRepository.findAll();
	}

}
