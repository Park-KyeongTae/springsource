package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/security")
public class SecurityController {

	@GetMapping("/login")
	public void LoginGet() {
		log.info("로그인 폼 요청");
	}
	@GetMapping("/userpage")
	public void userPage() {
		log.info("유저 페이지 요청");
	}
	@GetMapping("/adminpage")
	public void adminPage() {
		log.info("관리자 페이지 요청");
	}
	@GetMapping("/login-error")
	public String loginError(Model model) {
		model.addAttribute("error", "아이디나 비빌번호를 확인해주세요");
		return "/security/login";
	}
}
