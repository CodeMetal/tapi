package com.codemetal.tapi.metadata.service;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.codemetal.tapi.exception.RequiredFieldException;
import com.codemetal.tapi.metadata.TestCaseDetails;

@Component
public class TestCaseValidator {
	
	public Boolean validateTestCase(TestCaseDetails testCaseDetails)
	{
		if(StringUtils.isEmpty(testCaseDetails.getScenarioName()))
		{
			throw new RequiredFieldException("Test Case Scenario Name cannot be empty", "001");
		}			
		else
			return true;
	}

}
