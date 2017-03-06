package com.codemetal.tapi;

import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.codemetal.tapi.metadata.TestCaseDetails;

import junit.framework.TestCase;

public class RestApiTestCase extends TestCase{
	
	static final String HTTP = "http";
	
	static final String HTTPS = "https";
	
	/*Test Case data details */
	private TestCaseDetails testCaseDetails;
	
	public RestApiTestCase(TestCaseDetails testCaseDetails){
		/*Invoke super constructor with test method name (testApi in this case)*/
		super("testApi");
		this.testCaseDetails = testCaseDetails;
	}
	
	public void testApi(){
		RestTemplate restTemplate = new RestTemplate();
		String url = buildURL();
		HttpEntity<Object> requestEntity = null;
		
		MultiValueMap<String,String> headers = buildRequestHeaders();		
			
		
		/*Build Input for the API*/
		if( testCaseDetails.getInput() !=null){
			Object requestInput = testCaseDetails.getInput().getInput();			
			requestEntity = new HttpEntity<Object>(requestInput , headers);
		}
		else if(headers != null){
			requestEntity = new HttpEntity<Object>(headers);
		}
		
		restTemplate.exchange(url,
				convertRequestMethod(testCaseDetails.getRequestMethod()),  
				requestEntity,	
				Object.class);
	}
		
		
	
	/**
	 * Constructs the API URL including Query Parameters (if any)
	 * @return
	 */
	private String buildURL(){
		/*Construct url as Host + URI */
		UriComponentsBuilder  builder = UriComponentsBuilder.newInstance().scheme(http(testCaseDetails.isHttp()))
										.host(testCaseDetails.getEndPointHost())
										.path(testCaseDetails.getEndPointURI());
										
		/*Set the port if provided*/
		if(testCaseDetails.getEndPointPort() > 0){
			builder.port(testCaseDetails.getEndPointPort());
		}
		
		/*Check if input is empty*/
		if (testCaseDetails.getInput() == null){
			return builder.toUriString();
		}
		
		/*Check if request param is empty*/
		if (testCaseDetails.getInput().getParam() == null){
			return builder.toUriString();
		}
		
		/*Build the query parameters into the URI*/
		Map<String,String> paramMap  =testCaseDetails.getInput().getParam().getParams();
		if(paramMap!=null){			
			MultiValueMap<String,String> mv = new LinkedMultiValueMap<String,String>();
			mv.setAll(paramMap);
			builder.queryParams(mv);
		}
		return builder.toUriString();
		
		
	}
	/**
	 * Checks for the flag and returns HTTP/HTTPS accordingly
	 * @param isHttp
	 * @return
	 */
	private String http(boolean isHttp){
		return (isHttp ? HTTP : HTTPS);
	}
	
	/**
	 * Convert RequestMethod to HttpMethod
	 * @param req
	 * @return
	 */
	private HttpMethod convertRequestMethod(RequestMethod req){
		return HttpMethod.valueOf(req.name());
	}
	
	/**
	 * Builds a MultiValueMap of Request Headers
	 * @return
	 */
	private MultiValueMap<String,String> buildRequestHeaders(){
		if (testCaseDetails.getRequestHeader() != null){
			Map<String,String> map = testCaseDetails.getRequestHeader().getHeaders();
			MultiValueMap<String,String> headers = new LinkedMultiValueMap<String,String>();
			headers.setAll(map);
			return headers;
		}
		return null;
	}
}
