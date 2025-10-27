package com.study.spring.bbs;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface IBbsDao {
	public List<BbsDto> listDao();
	public int countDao();
	public BbsDto viewDao(String id);
	
}
