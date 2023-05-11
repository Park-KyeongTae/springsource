package com.spring.service;

import java.util.List;

import com.spring.domain.MemberDTO;

public interface MemberService { // mapper interface 메소드 가져오는 작업

	public boolean insertMember(MemberDTO dto);
	public boolean updateMember(MemberDTO dto);
	public boolean deleteMember(String userid, String password);
	public MemberDTO getRow(String userid, String password);
	public List<MemberDTO> getRows();
}
