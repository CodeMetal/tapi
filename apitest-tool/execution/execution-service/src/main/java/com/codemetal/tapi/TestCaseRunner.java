package com.codemetal.tapi;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMethod;

import com.codemetal.tapi.metadata.RequestParam;
import com.codemetal.tapi.metadata.TestCaseDetails;
import com.codemetal.tapi.metadata.TestCaseInput;

import io.swagger.models.HttpMethod;
import junit.framework.TestCase;

public class TestCaseRunner {
	public static void main(String[] args) {
		
		HttpMethod hm = con(RequestMethod.GET);
		System.out.println(hm);
		
		TestCaseDetails td = new TestCaseDetails();
		td.setScenarioName( "Hi");
		td.setEndPointHost("www.empl.com");
		td.setEndPointURI("employees/employee");
		td.setEndPointPort(0);
		TestCaseInput in = new TestCaseInput();
		RequestParam rp = new  RequestParam();
		Map<String,String> m = new HashMap<String,String>();
		m.put("name", "1");
		m.put("age", "20");
		rp.setParams(m);
		in.setParam(rp);
		td.setInput(in);
		//RestApiTestCase ratc = 
		TestCase tc = new  RestApiTestCase(td);
		tc.run();
		
	
		
	}
	
	private static HttpMethod con(RequestMethod req){
		return HttpMethod.valueOf(req.name());
	}
}
