package com.codemetal.tapi;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMethod;

import com.codemetal.tapi.metadata.Header;
import com.codemetal.tapi.metadata.RequestParam;
import com.codemetal.tapi.metadata.TestCaseDetails;
import com.codemetal.tapi.metadata.TestCaseInput;

import io.swagger.models.HttpMethod;
import junit.framework.TestCase;

public class TestCaseRunner {
	public static void main(String[] args) {
		
		
		
		testPost();
		
	}
	
	private void testget(){
		
		
		TestCaseDetails td = new TestCaseDetails();
		td.setScenarioName( "Hi");
		td.setHttp(true);
		td.setEndPointHost("localhost");
		td.setEndPointURI("user/getUserInfoByUserName");
		td.setEndPointPort(5050);
		TestCaseInput in = new TestCaseInput();
		RequestParam rp = new  RequestParam();
		Map<String,String> m = new HashMap<String,String>();
		m.put("userName", "eforms1");
		m.put("age", "20");
		rp.setParams(m);
		in.setParam(rp);
		td.setInput(in);
		td.setRequestMethod(RequestMethod.GET);
		//RestApiTestCase ratc = 
		TestCase tc = new  RestApiTestCase(td);
		
		tc.run();
	}
	
	private static void testPost(){
		
		
		TestCaseDetails td = new TestCaseDetails();
		td.setScenarioName( "Hi");
		td.setHttp(true);
		td.setEndPointHost("localhost");
		td.setEndPointURI("authority/createAuthority");
		td.setEndPointPort(8090);
		
		TestCaseInput in = new TestCaseInput();
		String input = "{\"authorityName\":\"Myauth\",\"phoneNumber\":1111111111,	\"address\":{	\"street\":\"ui1\",	\"postalCode\":35001,	\"city\":\"NA\",\"state\":\"CA\",\"country\":\"US\"	}}";
		
		
		in.setInput(input);
		RequestParam rp = new  RequestParam();
		Map<String,String> m = new HashMap<String,String>();
		m.put("userName", "eforms1");
		m.put("age", "20");
		rp.setParams(m);
		in.setParam(rp);
		td.setInput(in);
		td.setRequestMethod(RequestMethod.POST);
		//RestApiTestCase ratc = 
		TestCase tc = new  RestApiTestCase(td);
		Header rh = new Header();
		rh.addHeader("username", "eforms1");
		td.setRequestHeader(rh);
		
		tc.run();
	}
	
	
}
