package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.domain.Criteria;
import com.spring.domain.ReplyDTO;
import com.spring.domain.ReplyPageDTO;
import com.spring.service.ReplyService;

import lombok.extern.slf4j.Slf4j;

//http://localhost:8080/replies

@Slf4j
@RestController
@RequestMapping("/replies")
public class ReplyController {

	@Autowired
	private ReplyService reService;

//  MediaType.APPLICATION_JSON_VALUE 웹페이지에 제이슨으로 보여줄거야
//	http://localhost:8080/replies/1 + GET : 1번 댓글 데이터 가져오기
	@GetMapping(value = "/{rno}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ReplyDTO> get(@PathVariable("rno") int rno) { // <>화면에 어떻게 나타날지 선택   
		log.info("댓글 조회" + rno);

		return new ResponseEntity<ReplyDTO>(reService.read(rno), HttpStatus.OK);

	}

//	http://localhost:8080/replies/new + POST + 입력데이터
	@PostMapping("/new")
	public ResponseEntity<String> create(@RequestBody ReplyDTO dto) {
		log.info("댓글 삽입" + dto);

		return reService.insert(dto) ? new ResponseEntity<String>("success", HttpStatus.OK)
				: new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	}
         
	
//	http://localhost:8080/replies/pages/bno/ + GET 
	@GetMapping("/pages/{bno}/{page}")    
	public ResponseEntity<ReplyPageDTO> select(@PathVariable("bno") int bno, @PathVariable("page") int page) {
		log.info("댓글 조회" + bno);

		Criteria cri = new Criteria(page, 10);
		return new ResponseEntity<ReplyPageDTO>(reService.getList(cri,bno), HttpStatus.OK);
	}
	
//	http://localhost:8080/replies/rno + PUT + 수정데이터(JSON)
	
	@PutMapping("/{rno}")
    public ResponseEntity<String> modify(@RequestBody ReplyDTO dto){
    	log.info("댓글 수정" + dto);
    	
    	return reService.update(dto)?
    			new ResponseEntity<String>("success", HttpStatus.OK):
    				new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    	
    }
	
//	http://localhost:8080/replies/rno + DELETE : 댓글 삭제
	
	@DeleteMapping("/{rno}")
	public ResponseEntity<String> remove(@PathVariable("rno") int rno){
		log.info("댓글 삭제" + rno);
		return reService.delete(rno)?
				new ResponseEntity<String>("success",HttpStatus.OK):
					new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
