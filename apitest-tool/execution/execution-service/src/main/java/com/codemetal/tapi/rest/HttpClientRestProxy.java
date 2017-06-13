package com.codemetal.tapi.rest;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Proxy Implementation for invoking HTTP end points
 * @author Raghuveer Bhandarkar
 *
 */
public class HttpClientRestProxy implements RestProxy{
	
	/*Key/Value pairs for HTTP Headers */
	private Map<String,String> headers;
	
	/*URL to be invoked for invocation*/
	private String url;
	
	/*Input to the HTTP method body*/
	private String requestEntity;
	
	/*HTTP Request method*/
	private RequestMethod requestMethod;
	
	public HttpClientRestProxy(HttpClientRestProxyBuilder builder){
		this.headers = builder.headers;
		this.url = builder.url;
		this.requestEntity = builder.requestEntity;
		this.requestMethod = builder.requestMethod;
	}
	
		
	public void invoke() throws IOException{
		if(RequestMethod.GET.equals(requestMethod)){
			invokeGet();
		}
		else if(RequestMethod.POST.equals(requestMethod)){
			invokePost();
		}
	}
	
	/**
	 * Invoke a HTTP GET request
	 * @throws IOException
	 */
	public void invokeGet() throws IOException{
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		try {
			/*Add HTTP Headers*/
			addHeaders(httpGet);
			
			CloseableHttpResponse response = client.execute(httpGet);
			System.out.println("Code is "+response.getStatusLine().getStatusCode());
		} catch (IOException e) {
			throw e;
		}
		finally{
			client.close();
		}
	}
	
	/**
	 * Invoke a HTTP Post Request
	 * @throws IOException
	 */
	public void invokePost() throws IOException{
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		try {
			/*Add HTTP Headers*/
			addHeaders(httpPost);
			
			/*Add request body*/
			StringEntity entity = new StringEntity(requestEntity);
			httpPost.setEntity(entity); 
			CloseableHttpResponse response = client.execute(httpPost);
		} catch (IOException e) {
			throw e;
		}
		finally{
			client.close();
		}
	}
	
	/**
	 * Add HTTP Headers to request
	 * @param httpRequest
	 */
	private void addHeaders(HttpRequestBase httpRequest){
		if(this.headers == null){
			/*Empty headers, do nothing*/
			return;
		}
		for(Entry<String, String> entry: headers.entrySet()){
			httpRequest.setHeader(entry.getKey(), entry.getValue());
		}
		httpRequest.setHeader("Content-type", "application/json");
	}
	
	/**
	 * Builder Class for HttpClientRestProxy
	 * @author Raghuveer Bhandarkar
	 *
	 */
	public static class HttpClientRestProxyBuilder{
		/*Key/Value pairs for HTTP Headers */
		Map<String,String> headers;
		
		/*URL to be invoked for invocation*/
		String url;
		
		/*Input to the HTTP method body*/
		String requestEntity;
		
		/*HTTP Request method*/
		RequestMethod requestMethod;
		
		public HttpClientRestProxyBuilder(String url, RequestMethod requestMethod){
			this.url = url;
			this.requestMethod = requestMethod;
		}
		
		public HttpClientRestProxyBuilder setHeaders(Map<String,String> headers){
			this.headers = headers;
			return this;
		}
				
		public HttpClientRestProxyBuilder setRequestEntity(String requestEntity){
			this.requestEntity = requestEntity;
			return this;
		}
				
		public RestProxy build(){
			return new HttpClientRestProxy(this);
		}
	}

}
