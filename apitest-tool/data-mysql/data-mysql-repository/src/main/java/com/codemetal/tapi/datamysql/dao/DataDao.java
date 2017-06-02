package com.codemetal.tapi.datamysql.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.codemetal.tapi.data.Result;

@Repository
public class DataDao
{
    @Autowired
    private JdbcTemplate jdbcTemplate;
 
    
 
   
    public Result findResultByValue(String query) {
        return jdbcTemplate.queryForObject(
            query,
            null , new ResultRowMapper());
    }
 
    
}
 
class ResultRowMapper implements RowMapper<Result>
{
    public Result mapRow(ResultSet rs, int rowNum) throws SQLException {
    	Result result = new Result();
    	result.setValue(rs.getString(0));
        return result;
    }
}