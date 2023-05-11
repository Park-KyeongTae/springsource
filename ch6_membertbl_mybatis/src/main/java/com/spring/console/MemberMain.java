package com.spring.console;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.domain.MemberDTO;
import com.spring.service.MemberService;

public class MemberMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		
		MemberService service = (MemberService)ctx.getBean("member");
		
		// 전체 조회
//		List<MemberDTO> list = service.getRows();
//		for (MemberDTO memberDTO : list) {
//			System.out.println(memberDTO);
//		}
		// 멤버 정보 수정
//		MemberDTO updatedDto = new MemberDTO();
//		updatedDto.setUserid("parkkt96!");
//		updatedDto.setPassword("@pkt961225");
//		updatedDto.setEmail("pkt96song@naver.com");
//		System.out.println(service.updateMember(updatedDto)?"수정성공":"수정실패");
		
		// 멤버 추가
//		MemberDTO dto = new MemberDTO("pkt96song", "@pkt961225", "박경태", "남", "pkt96@naver.com");
//		boolean insertdto = service.insertMember(dto);
//		System.out.println(insertdto ? "추가성공":"추가실패");
		 
		// 멤버 삭제
//        boolean deletedto = service.deleteMember("pkt96song", "@pkt961225");
//        System.out.println(deletedto);
        
        // 한명 조회
//        System.out.println(service.getRow("parkkt96!", "@pkt961225"));
	}

}
