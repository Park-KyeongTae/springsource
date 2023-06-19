package com.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // 환경설정파일이야 
public class SecurityConfig {

	// 비밀번호 암호화
		@Bean
		public BCryptPasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		}
		/*
		 *  spirng-boot-starter-security : 시큐리티 라이브러리 모음
		 *  프로젝트에 시큐리티가 적용이 되어 버림 => 이 프로젝트는 비밀번호 암호화만 필요함
		 *  form login 동작이 되어버림
		 */
	
		// spirng-boot-starter-security : 시큐리티 라이브러리 모음을 안쓰고 비밀번호 암호화만 하겠다
		@Bean
		public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
			http.authorizeHttpRequests().anyRequest().permitAll().and().httpBasic().and().csrf().disable();
			
			return http.getOrBuild();
		}
}
    