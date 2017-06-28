package com.codemetal.tapi.service;

import org.json.JSONObject;

/**
 * This class would parse the JSON path provided (as a.b.c) and apply it on Json elements
 * 
 * @author Raghuveer Bhandarkar
 *
 */
public class JsonPathParser {
	private String path;
	
	private JSONObject jsonObject;
	
	static final String PERIOD = ".";
	
	static final String INDEX_FORMAT_START = "[";
	
	static final String INDEX_FORMAT_END = "]";
	
	public JsonPathParser(String path, JSONObject jsonObject){
		this.path = path;
		this.jsonObject = jsonObject;
	}
	
	/**
	 * Parses the given Json expression and returns the matching element
	 * @return
	 */
	public JSONObject parseJsonPath(){
		String[] expressions = path.split(PERIOD);
		for(String expr: expressions){
			int position = 0;
			if(hasArrayFormat(expr)){
				position = parseArrayIndex(expr);
				expr = stripArrayExpression(expr);				
			}
			Object currObj = jsonObject.get(expr);
			if(currObj instanceof JSONObject){
				jsonObject = (JSONObject)currObj;
			}
			/*TODO: array format*/
			
			
		}
		return jsonObject;
	}
	
	/**
	 * Checks if the Json expression has a array index in it (For ex. a.b[0] returns true)
	 * @param expr
	 * @return
	 */
	private boolean hasArrayFormat(String expr){
		if(expr.contains(INDEX_FORMAT_START)){
			return true;
		}
		return false;
	}
	
	/**
	 * Parses the Json expression and returns the value of the array index (For ex. b[9] returns 9)
	 * @param expr
	 * @return
	 */
	private int parseArrayIndex(String expr){
		
		int beginIndex = expr.indexOf(INDEX_FORMAT_START);
		int endIndex = expr.indexOf(INDEX_FORMAT_END);
		
		String arrPosition = expr.substring(beginIndex, endIndex);
		int position = 0;
		try{
			position = Integer.valueOf(arrPosition);
		}
		catch(NumberFormatException ne){
			throw new RuntimeException("Parser Error: Invalid array index format");
		}
		return position;			
		
	}
	
	/**
	 * Removes the array expression from the Json expression (For ex. b[9] returns b)
	 * @param expr
	 * @return
	 */
	private String stripArrayExpression(String expr){
		int beginIndex = expr.indexOf(INDEX_FORMAT_START);
		return expr.substring(0, beginIndex);
	}
	
}
