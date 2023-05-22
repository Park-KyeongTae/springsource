package com.spring.mapper;

import org.apache.ibatis.annotations.Insert;

public interface SampleMapper2 {
	
	 @Insert("insert into tbl_sample2(col1) values(#{date})")
	 public int insertCol1(String data);
	 
	 
	 
}
