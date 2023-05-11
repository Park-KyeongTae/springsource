package com.spring.console;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.domain.PersonDTO;
import com.spring.service.PersonService;

public class PersonMain {

	public static void main(String[] args) {
	 ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
	 
	 PersonService service = (PersonService)ctx.getBean("person");
	 
	     // 삽입
		  //PersonDTO insertPerson = new PersonDTO("kim123", "김길동");
		  //System.out.println(service.insertPerson(insertPerson)?"성공":"실패");
  
	     // 전체조회
		 //List<PersonDTO> list = service.getRows();
		 //for (PersonDTO personDTO : list) {
		 //System.out.println(personDTO);
		 //}
		 
		 
		// 수정
		//System.out.println(service.updatePerson(new PersonDTO("park123","박경민"))?"성공":"실패");
		 
		// 삭제
		// System.out.println(service.deletePerson("park123")?"성공":"실패");
		 
		// 특정 사람 조회
		// System.out.println(service.getRow("hong123"));
	 
	}

}
