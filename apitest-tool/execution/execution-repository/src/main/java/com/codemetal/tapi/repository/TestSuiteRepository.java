package com.codemetal.tapi.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.codemetal.tapi.metadata.TestSuite;

@Repository
public interface TestSuiteRepository extends PagingAndSortingRepository<TestSuite, Long> {

}
