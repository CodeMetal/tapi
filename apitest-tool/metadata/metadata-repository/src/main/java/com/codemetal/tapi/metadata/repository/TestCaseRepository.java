package com.codemetal.tapi.metadata.repository;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.codemetal.tapi.metadata.TestCaseDetails;

/**
 * 
 * @author santhosh
 *
 */
@Repository
public interface TestCaseRepository extends PagingAndSortingRepository<TestCaseDetails, String>{

}
