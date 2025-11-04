package com.study.spring.api;

import java.util.List;

import org.apache.ibatis.annotations.*;

@Mapper
public interface IStoreDao {
	
	@Select("SELECT * FROM menu WHERE store_id = #{storeId}")
    List<MenuDto> findMenusByStoreId(Long storeId);
 
	@Select("select * from store order by id desc")
	@Results({
	    @Result(property = "id", column = "id"),
	    @Result(property = "name", column = "name"),
	    @Result(property = "address", column = "addr"),
	    @Result(property = "menus", column = "id",
	            many = @Many(select = "findMenusByStoreId"))
	})
	public List<StoreDto> findeAllWidthMenus();
	
	@Select("SELECT * FROM store WHERE id = #{id}")
	@Results({
	    @Result(property = "id", column = "id"),
	    @Result(property = "name", column = "name"),
	    @Result(property = "address", column = "addr"),
	    @Result(property = "menus", column = "id",
	            many = @Many(select = "findMenusByStoreId"))
	})
	public StoreDto findById(Long id);
	
	
	@Insert("INSERT INTO store(name, addr,created_at) VALUES(#{name}, #{address},now())")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insertStore(StoreDto store);
	
	@Insert("INSERT INTO menu(store_id, name, price,created_at) VALUES(#{store_id}, #{name}, #{price}, now())")
	int insertMenu(MenuDto menu);
}
