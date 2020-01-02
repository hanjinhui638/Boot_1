package com.jh.b1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/**")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("memberJoin")
	public String memberJoin()throws Exception{
		return "member/memberJoin";
	}
	
	
	@PostMapping("memberJoin")
	public ModelAndView memberJoin(MemberVO memberVO, MultipartFile files)throws Exception{
														/* 파라미터와 동일하게 */
		ModelAndView mv = new ModelAndView();
		int result = memberService.memberJoin(memberVO, files);
		
		String message = "Join Fail";
		String path = "../";
		
		if(result>0) {
			message="Join Success";
		}
		mv.setViewName("common/result");
		mv.addObject("message",message);
		mv.addObject("path", path);
		return mv;
		
	}
	
}
