package com.codemetal.tapi.metadata.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.codemetal.tapi.metadata.TestSuite;

/**
 * 
 * @author santhosh
 *
 */
public interface TestSuiteRepository extends MongoRepository<TestSuite,String>{
	
	public TestSuite findByName(String name);
}
