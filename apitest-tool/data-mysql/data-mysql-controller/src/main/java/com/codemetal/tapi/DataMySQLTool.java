package com.codemetal.tapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.codemetal.tapi.datamysql.controller.DataController;
import com.codemetal.tapi.datamysql.dao.DataDao;
import com.codemetal.tapi.datamysql.service.DataService;
import com.codemetal.tapi.datamysql.service.DataServiceImpl;

@SpringBootApplication(scanBasePackageClasses={DataService.class,DataServiceImpl.class,DataDao.class,DataController.class})
public class DataMySQLTool {
	public static void main(String[] args) {
        SpringApplication.run(DataMySQLTool.class, args);
    }
}
