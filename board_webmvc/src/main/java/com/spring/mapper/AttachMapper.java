package com.spring.mapper;

import java.util.List;

import com.spring.domain.AttachFileDTO;

public interface AttachMapper {
	
	public int insert(AttachFileDTO dto);
	public List<AttachMapper> select(int bno);
}
