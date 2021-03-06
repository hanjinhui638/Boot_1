package com.jh.b1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.jh.b1.interceptor.CustomInterceptor;
import com.jh.b1.interceptor.MemberInterceptor;
import com.jh.b1.interceptor.NoticeInterceptor;

@Configuration 	//XML 설정
public class InterceptorConfig implements WebMvcConfigurer{
											//web에 관련된 설정들 
	
	@Autowired
	private CustomInterceptor customInterceptor;
	
	@Autowired
	private MemberInterceptor memberInterceptor;
	
	@Autowired
	private NoticeInterceptor noticeInterceptor;
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		
		//Interceptor 등록 
		registry.addInterceptor(customInterceptor)
		//Interceptor를 사용할 URL 패턴 등록
		.addPathPatterns("/member/*")
		//.addPathPatterns("/member/memberPage");
		
		//Interceptor를 제외할 URL 패턴 등록 
		.excludePathPatterns("/member/memberLogin")
		.excludePathPatterns("/member/memberJoin");
		
		
		registry.addInterceptor(memberInterceptor)
		.addPathPatterns("/member/memberPage");
			
		registry.addInterceptor(noticeInterceptor)
		.addPathPatterns("/notice/noticeWrite");
		
		//WebMvcConfigurer.super.addInterceptors(registry); - 생략가능 
	}
	
}
