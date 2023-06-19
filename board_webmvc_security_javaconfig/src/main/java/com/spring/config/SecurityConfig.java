package com.spring.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.spring.handler.CustomLoginSuccessHandler;
import com.spring.service.CustomUserDetailService;

// 5.7.X security 환경 설정 작성 방법은 변경됨

@Configuration // 환경설정파일입니다
@EnableWebSecurity // 웹시큐리티를 담당하는 어노테이션
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	//데이터베이스와의 연결을 관리하는 객체
	private DataSource datasource;

	// 비밀번호 암호화
	@Bean
	// PasswordEncoder는 암호화된 비밀번호를 생성하고 비밀번호 검증을 수행하는 인터페이스
	public PasswordEncoder passwordEncoder() {
		// BCryptPasswordEncoder는 Spring Security에서 제공하는 PasswordEncoder 인터페이스를 구현한 클래스
		// BCrypt 알고리즘을 사용하여 비밀번호를 암호화하고 검증하는 기능
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	// 로그인 성공했을 때 추가 동작 수행 인증된 사용자에 대한 후속작업 설정 역활
	// Spring Security에서 제공하는 AuthenticationSuccessHandler 인터페이스를 구현한 사용자 정의 로그인 성공 핸들러
	//
	public CustomLoginSuccessHandler loginSuccessHandler() {
		return new CustomLoginSuccessHandler();
	}
	
	// CustomUserDetailService 대체
	// Spring Security에서 사용자 인증과 권한 검사 등의 작업에 활용
	@Bean
	public UserDetailsService customUserService() {
		return new CustomUserDetailService();
	}
	// security-context 시큐리티설정
	//이 설정은 Spring Security가 사용자 인증 및 인가 작업을 수행할 때 사용
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserService()).passwordEncoder(passwordEncoder());
	}
	
	// 한글필터
	@Override 
	protected void configure(HttpSecurity http) throws Exception {
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("utf-8");
		filter.setForceEncoding(true);
		http.addFilterBefore(filter, CsrfFilter.class);

		http.formLogin().loginPage("/member/login")
						.loginProcessingUrl("/login")
						.failureUrl("/member/login-error")
						.successHandler(loginSuccessHandler());

		http.logout()
			.logoutSuccessUrl("/");
		
		http.rememberMe()
			.tokenRepository(perTokenRepository())
			.tokenValiditySeconds(604800);
	}
	// JDBC 기반의 영구 토큰 저장소를 생성
	// 사용자의 로그인 기억 기능과 관련하여 영구적으로 토큰을 저장하고 관리하는 역할
	public PersistentTokenRepository perTokenRepository() {
		JdbcTokenRepositoryImpl repo = new JdbcTokenRepositoryImpl();
		repo.setDataSource(datasource);
		return repo;
	}
	
}
