package com.codemetal.tapi.datamysql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codemetal.tapi.datamysql.dao.DataDao;
import com.codemetal.tapi.datamysql.service.DataService;

@Component
public class DataServiceImpl implements DataService {

	@Autowired
	DataDao dataDao;
	
	@Override
	public Object getDataForQuery(String query) {
		return dataDao.findResultByValue(query);
	}

}
