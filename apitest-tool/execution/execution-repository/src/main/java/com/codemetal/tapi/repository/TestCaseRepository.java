package com.codemetal.tapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.codemetal.tapi.metadata.TestCaseDetails;

@Repository
public interface TestCaseRepository extends PagingAndSortingRepository<TestCaseDetails, Long> {

	Page<TestCaseDetails> findByTestSuiteId(String id, Pageable pageable);

}
