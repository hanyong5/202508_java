package com.study.spring.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MyDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<MyDto> list(){
		String query = "select * from simple_bbs";
		List<MyDto> list = jdbcTemplate.
				query(query, new BeanPropertyRowMapper(MyDto.class));
		
		return list;
	}
	
}
