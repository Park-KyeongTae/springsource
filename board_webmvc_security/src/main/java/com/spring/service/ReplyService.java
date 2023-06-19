package com.spring.service;

import java.util.List;

import com.spring.domain.Criteria;
import com.spring.domain.ReplyDTO;
import com.spring.domain.ReplyPageDTO;

public interface ReplyService {

	//특정 댓글 조회
	public ReplyDTO read(int rno);
	// 댓글 입력
	public boolean insert(ReplyDTO dto);
	// 댓글 전체 조회
	
	// 댓글 목록만 처리
	// public List<ReplyDTO> getList(Criteria cri, int bno);
	
	// 댓글 총 수, 댓글 목록 처리
	 public ReplyPageDTO getList(Criteria cri, int bno);
	// 댓글 업데이트
	public boolean update(ReplyDTO dto);
	// 댓글 삭제
	public boolean delete(int rno);
}
