package com.codemetal.tapi.metadata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codemetal.tapi.exception.RequiredFieldException;
import com.codemetal.tapi.metadata.TestSuite;
import com.codemetal.tapi.metadata.repository.TestSuiteRepository;

/**
 * 
 * @author santhosh
 *
 */

@Service
public class TestSuiteServiceImpl implements TestSuiteService{
	
	@Autowired
	private TestSuiteRepository testSuiteRepository;

	@Autowired
	private TestSuiteValidator testSuiteValidator;
	
	
	@Override
	public TestSuite createTestSuite(TestSuite testSuite) {
		testSuiteValidator.validateTestSuite(testSuite);
		return testSuiteRepository.save(testSuite);
	}
	
	

	@Override
	public TestSuite updateTestSuite(TestSuite testSuite) {
		testSuiteValidator.validateTestSuite(testSuite);
		return testSuiteRepository.save(testSuite);
	}

	@Override
	public void deleteTestSuite(String id) {
		testSuiteRepository.delete(id);
		
	}

	@Override
	public List<TestSuite> getTestSuites() {
		return (List<TestSuite>)testSuiteRepository.findAll();
	}

	@Override
	public TestSuite findByName(String name) {
		return testSuiteRepository.findByName(name);
	}

	
}
