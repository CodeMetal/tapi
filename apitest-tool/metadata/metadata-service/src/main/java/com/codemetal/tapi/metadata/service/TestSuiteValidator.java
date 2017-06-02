package com.codemetal.tapi.metadata.service;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.codemetal.tapi.exception.RequiredFieldException;
import com.codemetal.tapi.metadata.TestSuite;

@Component
public class TestSuiteValidator {

	public Boolean validateTestSuite(TestSuite testSuite)
	{
		if(StringUtils.isEmpty(testSuite.getName()))
		{
			throw new RequiredFieldException("Test Suite Name cannot be empty", "001");
		}			
		else
			return true;
	}
}
