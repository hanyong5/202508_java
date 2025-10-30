package com.study.spring.api;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface IPostDao {
	
	@Select("select * from posts order by id desc")
	public List<PostDto> listDao();
}
