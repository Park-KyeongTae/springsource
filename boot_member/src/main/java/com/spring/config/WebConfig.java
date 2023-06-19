package com.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.spring.interceptor.AuthCheckInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer{

	// 인터셉터 메소드
	// 로그인 정보가 없을 때 /member/changePwd 들어가는 걸 막는 기능
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new AuthCheckInterceptor())
		        .addPathPatterns("/member/changePwd");
	}
}
