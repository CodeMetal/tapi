package com.codemetal.tapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.codemetal.tapi.metadata.repository.TestCaseRepository;
import com.codemetal.tapi.metadata.repository.TestSuiteRepository;
import com.codemetal.tapi.metadata.service.TestCaseServiceImpl;
import com.codemetal.tapi.metadata.service.TestSuiteService;
import com.codemetal.tapi.metadata.service.TestSuiteServiceImpl;


@SpringBootApplication(scanBasePackages= {
        "com.codemetal.tapi.metadata.controller",
        "com.codemetal.tapi.metadata.service",
        "com.codemetal.tapi.metadata.repository"
}, 
scanBasePackageClasses = {RestExceptionProcessor.class}

        )


@EnableMongoRepositories(basePackageClasses = {TestCaseRepository.class,TestSuiteRepository.class})
public class ApiTestTool {
	public static void main(String[] args) {
        SpringApplication.run(ApiTestTool.class, args);
    }
}
