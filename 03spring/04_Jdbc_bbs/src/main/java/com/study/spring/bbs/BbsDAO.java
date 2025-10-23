package com.study.spring.bbs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;


//simple logging facade for java

@Repository
@Slf4j
public class BbsDAO implements IBbsDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<BbsDTO> listDAO() {
		
		log.info("========================== 글리스트");

		String query = "select * from simple_bbs order by id desc";
		List<BbsDTO> list = jdbcTemplate.query(query, 
				new BeanPropertyRowMapper<>(BbsDTO.class)
				);
		
		return list;
	}

	@Override
	public Integer countDAO() {
//		System.out.println("====================갯수 countDAO");
		log.info("========================== 갯수");
		String query = "select count(*) from simple_bbs";
		Integer count = jdbcTemplate.queryForObject(query, Integer.class);
		return count;
	}

	@Override
	public BbsDTO viewDAO(String id) {
//		System.out.println("==================== 글보기 viewDAO");
		log.info("========================== 글보기");
		String query = "select * from simple_bbs where id =" + id;
		BbsDTO dto = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(BbsDTO.class));
		return dto;
	}

	@Override
	public int writeDAO(String writer, String title, String content) {
//		System.out.println("==================== 글작성 writeDAO");
		log.info("========================== 글작성");
		String query = "insert into simple_bbs (writer,title,content) values (?,?,?)";
		return jdbcTemplate.update(query,writer,title,content);
	}

	@Override
	public int deleteDAO(String id) {
//		System.out.println("==================== 글삭제 deleteDAO");
		log.info("========================== 글삭제");
		String query = "delete from simple_bbs where id=?"; 
		return jdbcTemplate.update(query,Integer.parseInt(id)); // id String -> integer / Integer.parseInt(id)
	}

}
