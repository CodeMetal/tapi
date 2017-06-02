package com.codemetal.tapi.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.codemetal.tapi.repository.TestCaseRepository;
import com.codemetal.tapi.repository.TestSuiteRepository;

import com.codemetal.tapi.metadata.TestCaseDetails;
import com.codemetal.tapi.metadata.TestSuite;

/**
 * This class provides services to execute the testsuites.
 * 
 * @author Amy Tripathi
 *
 */
public class ExecutionServiceMgr {

	public static final int TESTSUITE_PAGESIZE = 10;
	public static final int TESTCASE_PAGESIZE = 50;

	@Autowired
	TestSuiteRepository testSuiteRepo;

	@Autowired
	TestCaseRepository testCaseRepo;

	/**
	 * This method returns all the testsuites in paginated format using the
	 * criteria provided in pageable
	 * 
	 * @param pageable
	 *            This specifies the pagenumber, pagesize, sortkey and
	 *            sortdirection to do the pagination of result
	 * @return the collection containing all the testsuites
	 */
	public Collection<TestSuite> findAllTestSuites(Pageable pageable) {

		return testSuiteRepo.findAll(pageable).getContent();

	}

	/**
	 * 
	 * @param testSuiteId
	 *            The Id of a testSuite for which all testcases are to be
	 *            fetched
	 * @param pageable
	 *            This specifies the pagenumber, pagesize, sortkey and
	 *            sortdirection to do the pagination of result
	 * @return
	 */
	public Collection<TestCaseDetails> findTestCasesByTestSuiteId(String testSuiteId, Pageable pageable) {

		Page<TestCaseDetails> results = testCaseRepo.findByTestSuiteId(testSuiteId, pageable);

		Collection<TestCaseDetails> testCaseDetailsResultList = results.getContent();
		return testCaseDetailsResultList;

	}

	/**
	 * This method executes all the testsuites present in the database
	 */
	public void executeTest() {

		Collection<TestCaseDetails> testCaseDetails = null;
		int testCasePageNumber = 0;
		int testSuitePageNumber = 0;
		Direction sortDir = Sort.Direction.ASC;
		String sortKey = "name";
		Long testSuiteCount = testSuiteRepo.count();
		Long testCaseCount = testCaseRepo.count();
		for (long i = 0; i < testSuiteCount / ExecutionServiceMgr.TESTSUITE_PAGESIZE; i++) {
			Pageable pageable1 = new PageRequest(testSuitePageNumber, ExecutionServiceMgr.TESTSUITE_PAGESIZE, sortDir,
					sortKey);
			for (TestSuite testSuite : findAllTestSuites(pageable1)) {
				for (long j = 0; j < testCaseCount / ExecutionServiceMgr.TESTCASE_PAGESIZE; j++) {
					Pageable pageable = new PageRequest(testCasePageNumber, ExecutionServiceMgr.TESTCASE_PAGESIZE,
							sortDir, sortKey);
					testCaseDetails = findTestCasesByTestSuiteId(testSuite.getId(), pageable);
					for (TestCaseDetails details : testCaseDetails) {
						System.out.println(details.getScenarioDescription());

					}
					testCasePageNumber = testCasePageNumber + 1;
				}

			}
			testSuitePageNumber = testSuitePageNumber + 1;

		}

	}

}
