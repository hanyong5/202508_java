package com.study.spring.store;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface IStoreDao {

	@Select("select * from store order by id desc")
	List<StoreDto> findAll();

	@Select("select * from menu order by id desc")
	List<MenuDto> findMenuAll();

	@Select("select * from store where id=#{id}")
	StoreDto storeView(Long id);

	@Insert("insert into store(name,addr) values(#{name},#{addr})")
	void createStore(StoreDto request);



}
