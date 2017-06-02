package com.codemetal.tapi.exception;

public class RequiredFieldException extends RuntimeException {

	private String code;
	
	
	 public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}



	public RequiredFieldException(String message, String code) {
	        super(message);
	        this.code = code;
	    }
	 
}
