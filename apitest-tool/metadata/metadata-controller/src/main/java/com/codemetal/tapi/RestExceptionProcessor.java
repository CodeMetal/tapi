package com.codemetal.tapi;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.codemetal.tapi.exception.RequiredFieldException;
import com.codemetal.tapi.metadata.RestResponse;

/**
 * 
 * @author Mohit Singh
 * This class acts as handler for all custom exceptions
 *
 */

@ControllerAdvice
public class RestExceptionProcessor {
     
    @Autowired
    private MessageSource messageSource;
     
    /**
     * This method is used to handle custom exceptions and return a meaningful response
     * @param req
     * @param ex
     * @return
     */
    
    @ExceptionHandler(RequiredFieldException.class)
    @ResponseStatus(value=HttpStatus.BAD_REQUEST)
    @ResponseBody
    public RestResponse badRequest(HttpServletRequest req, RequiredFieldException ex) {
       
    	RestResponse resp = new RestResponse();
    	resp.setMessage(ex.toString());
    	resp.setCode(ex.getCode());
    	
    	return resp;
        
    }

}
