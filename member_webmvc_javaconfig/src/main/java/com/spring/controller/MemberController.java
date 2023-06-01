package com.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.domain.AuthDTO;
import com.spring.domain.ChangeDTO;
import com.spring.domain.LoginDTO;
import com.spring.domain.MemberDTO;
import com.spring.service.MemberService;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import oracle.jdbc.proxy.annotation.Post;

@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService service;

	@GetMapping("/login")
	// login.jsp 보여주는 컨트롤러 작성
	public void loginGet() {
		log.info("로그인 폼 요청");
	}

	@PostMapping("/login")
	public String loginPost(LoginDTO loginDTO, HttpSession session) {
		log.info("로그인 요청 " + loginDTO);

		AuthDTO authDTO = service.login(loginDTO);

		if (authDTO != null) {
			// session 로그인 정보 담기
			session.setAttribute("authDTO", authDTO);
			// index 이동
			return "redirect:/";
		} else {
			return "redirect:/member/login";
		}

	}

	@GetMapping("/logout")
	public String logoutGet(HttpSession session) {
		log.info("로그아웃 요청");

		session.removeAttribute("authDTO");

		// session 해제 index 이동
		return "redirect:/";
	}

	@GetMapping("/step1")
	public void stepGet() {
		// member/step1.jsp 보여주기
		log.info("약관페이지 보여주기");
	}

	@PostMapping("/step1")
	public String stepPost(boolean agree, RedirectAttributes rttr) {
		log.info("약관동의" + agree);
		// 약관동의 여부

		if (agree) {
			// true 인 경우 register.jsp 보여주기
			return "member/register";
		} else {
			// false 인 경우 step1.jsp 보여주기
			rttr.addFlashAttribute("check", false);
			return "redirect:/member/step1";
			// return "/member/step1"; // View Resolver
		}
	}

	@PostMapping("/register")
	public String registerPost(MemberDTO dto) {
		log.info("회원가입 요청" + dto);

		if (service.register(dto)) {
			return "redirect:/member/login";
		} else {
			return "/member/login";
		}

	}

	// 중복 아이디
	@PostMapping("/dupId")
	@ResponseBody // 컨트롤러 작업이 완료될 때 결과값으로 리턴시킴(viewresolver)
	public String dupIdCheck(String userid) {
		log.info("중복 아이디 체크 " + userid);

		boolean idCheck = service.dupid(userid);

		if (idCheck) {
			return "true"; // viewresolver 돌아서 /WEB-INF/views/true.jsp
		} else {
			return "false"; // viewresolver 돌아서 /WEB-INF/views/false.jsp
		}

	}

	// 회원 탈퇴
	@GetMapping("/leave")
	public void leaveGet() {
		log.info("회원 탈퇴 페이지 요청 ");
	}

	@PostMapping("/leave")
	public String leavePost(LoginDTO loginDTO, HttpSession session) {
		log.info("회원 탈퇴 페이지 요청 " + loginDTO);

		if (service.remove(loginDTO)) {
			session.invalidate();
			return "redirect:/";
		} else {
			return "redirect:/member/leave";
		}
	}

	// changePwd.jsp 보여주기
	@GetMapping("/changePwd")
	public void changePwdGet() {
		log.info("비밀번호 수정 요청 ");
	}

	// changePwd.jsp 보여주기
	@PostMapping("/changePwd")
	public String changePwdPost(ChangeDTO changeDTO, HttpSession session) {
		log.info("비밀번호 수정 요청 " + changeDTO);

		if (changeDTO.passwordEquals()) {
			// 현재 비밀번호 일치 확인
			// true : 비밀번호 변경 ==> session 제거 ==> 로그인 페이지 보여주기
			// false : 비빌번호변경 페이지 보여주기

			if (service.update(changeDTO)) {
				session.invalidate();
				return "redirect:/member/login";

			}

		}
		return "redirect:/member/changePwd";

	}

}
