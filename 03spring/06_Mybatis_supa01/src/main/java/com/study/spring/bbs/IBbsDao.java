package com.study.spring.bbs;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface IBbsDao {

	@Select("select * from posts order by id desc")
	List<BbsDto> findAll();

	@Select("select * from posts where id=#{id}")
	BbsDto findById(Long id);
	
	
	//@Insert("INSERT INTO menu(store_id, name, price,created_at) VALUES(#{store_id}, #{name}, #{price}, now())")
	@Insert("insert into posts(name,title,content,created_at) values (#{name},#{title},#{content},now())")
	void create(BbsDto request);

	@Update("update posts set title=#{title}, name=#{name}, content=#{content} where id=#{id}")
	int update(BbsDto request);
	

	
}
