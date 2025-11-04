package com.study.spring.store;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.*;


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
	
	@Select("select * from menu where store_id=#{store_id} order by id desc")
	List<MenuDto> findMenuByStoreId(Long store_id);

	
	@Select("select * from store order by id desc")
	@Results({
		@Result(property="id",column="id"),
		@Result(property="name",column="name"),
		@Result(property="addr",column="addr"),
		@Result(property="menus",column="id",many = @Many(select="findMenuByStoreId")
				),

	})
	List<StoreMenuDto> storeAndMenuAll();

	
	
	@Select("select * from menu order by id desc")
	@Results({
		@Result(property="id",column="id"),
		@Result(property="name",column="name"),
		@Result(property="price",column="price"),
		@Result(property="store_id",column="store_id"),
		@Result(property="store",column="store_id",one = @One(select="storeView")
				),

	})
	List<MenuStoreNameDto> menuStoreName();
	
	
	
	



}
