package com.codemetal.tapi.metadata.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.codemetal.tapi.metadata.TestCaseDetails;

/**
 * 
 * @author santhosh
 *
 */
public interface TestCaseRepository extends MongoRepository<TestCaseDetails, String>{

}
