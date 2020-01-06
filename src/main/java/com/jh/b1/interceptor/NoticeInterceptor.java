package com.jh.b1.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.jh.b1.member.MemberVO;

@Component
public class NoticeInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler
			)throws Exception {
		
		ModelAndView modelAndView = new ModelAndView();
		MemberVO memberVO = (MemberVO)request.getSession().getAttribute("member");
		
		if(!memberVO.getId().equals("admin")) {
			
			modelAndView.addObject("msg", "권한이 없음");
			modelAndView.addObject("path", "noticeWrite");
			modelAndView.setViewName("common/common_result");
			
		}
		
		return super.preHandle(request, response, handler);
	}
	


}
