package com.codemetal.tapi.metadata.repository;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.codemetal.tapi.metadata.TestSuite;

/**
 * 
 * @author santhosh
 *
 */
@Repository
public interface TestSuiteRepository extends PagingAndSortingRepository<TestSuite,String>{
	
	public TestSuite findByName(String name);
}
