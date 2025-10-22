package com.study.spring.bbs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class BbsDAO implements IBbsDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<BbsDTO> listDAO() {
		System.out.println("글보기 listDAO");
		String query = "select * from simple_bbs order by id desc";
		List<BbsDTO> list = jdbcTemplate.query(query, 
				new BeanPropertyRowMapper<>(BbsDTO.class)
				);
		
		return list;
	}

	@Override
	public Integer countDAO() {
		System.out.println("====================갯수 countDAO");
		String query = "select count(*) from simple_bbs";
		Integer count = jdbcTemplate.queryForObject(query, Integer.class);
		return count;
	}

	@Override
	public BbsDTO viewDAO(String id) {
		System.out.println("==================== 글보기 viewDAO");
		String query = "select * from simple_bbs where id =" + id;
		BbsDTO dto = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(BbsDTO.class));
		return dto;
	}

	@Override
	public int writeDAO(String writer, String title, String content) {
		
		return 0;
	}

	@Override
	public int deleteDAO(String id) {
		
		return 0;
	}

}
