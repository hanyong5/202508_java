package com.study.spring.bbs;

import java.util.List;

public interface IBbsDAO {
	public List<BbsDTO> listDAO();  // list
	public Integer countDAO();   	//count 데이터갯수 null
	public BbsDTO viewDAO(String id); // view 글내용
	public int writeDAO(String writer,String title,String content); //글작성
	public int deleteDAO(String id); // 글삭제
}
