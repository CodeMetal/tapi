package com.codemetal.tapi.datamysql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codemetal.tapi.datamysql.service.DataService;


@RestController
@RequestMapping(value = "/data/sql")
public class DataController {

	@Autowired
	DataService dataService;
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveTestData(@RequestBody String query){
		
		Object caseResp = dataService.getDataForQuery(query);
		return new ResponseEntity<Object>(caseResp, HttpStatus.OK); 
	}
	
}
