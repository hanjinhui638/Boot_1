package com.jh.b1.notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jh.b1.member.MemberService;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@GetMapping("noticeWrite")
	public String noticeWrite()throws Exception{
		
		return "notice/noticeWrite";
	}

	@PostMapping("noticeWrite")
	public ModelAndView noticeWrite(NoticeVO noticeVO, MultipartFile files)throws Exception{
		
		ModelAndView mv = new ModelAndView();
		
		int result = noticeService.noticeWrite(noticeVO, files);
		
		String message = "Write Fail";
		String path = "../";
		if(result>0) {
			message = "Write Success";
		}
		mv.setViewName("common/result");
		mv.addObject("message", message);
		mv.addObject("path", path);
		
		return mv;
		
	}
	
}
