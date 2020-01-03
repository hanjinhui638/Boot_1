package com.jh.b1.member;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/**")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("memberFileDown")
	public ModelAndView memberfileDown(MemberFilesVO memberFilesVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		memberFilesVO = memberService.memberfilesSelect(memberFilesVO);
		if(memberFilesVO !=null) {
			mv.addObject("memberfiles", memberFilesVO);
			mv.addObject("path", "upload");
			mv.setViewName("fileDown");
			/* 클래스 이름의 첫글자를 소문자로 바꾼 이름 */
			
		}else {
			mv.addObject("message", "No Image File");
			mv.addObject("path", "./memberPage");
			mv.setViewName("common/result");
			
		}
		
		return mv;
	}
	
	@GetMapping("memberJoin")
	public String memberJoin()throws Exception{
		//MemberVO memberVO new MemberVO();
		//model.addAttribute("memberVO", memberVO);
		//model.addAttribute("memberVO", new MemberVO());
		return "member/memberJoin";
	}
	
	
	@PostMapping("memberJoin")
	public ModelAndView memberJoin(@Valid MemberVO memberVO, BindingResult bindingResult, MultipartFile files)throws Exception{
								/* bindingResult의 위치는 @Valid 바로 뒤  검증하고 옴*/							/* 파라미터와 동일하게 */
		ModelAndView mv = new ModelAndView();
		
		if(memberService.memberJoinValidate(memberVO, bindingResult)){
		
		mv.setViewName("member/memberJoin");
		}else {		
			
			
		int result = memberService.memberJoin(memberVO, files);
		
		String message = "Join Fail";
		String path = "../";
		
		if(result>0) {
			message="Join Success";
		}
		mv.setViewName("common/result");
		mv.addObject("message",message);
		mv.addObject("path", path);
		}
		return mv;
		
	}
	
	
	
	@GetMapping("memberLogin")
	public void memberLogin()throws Exception{
		
	}
	
	
	@ModelAttribute
	public MemberVO getMemberVO()throws Exception{
		//모든 메서드의 MemberVO를 Model에 담음 
		//MemberVO memberVO new MemberVO();
		//model.addAttribute("memberVO", memberVO);
		return new MemberVO();
	}
	
	
	@PostMapping("memberLogin")
	public ModelAndView memberLogin( MemberVO memberVO, HttpSession session,MemberFilesVO memberFilesVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		memberVO = memberService.memberLogin(memberVO);
		memberFilesVO = memberService.memberfilesSelect(memberFilesVO);
		
		String message ="Login Fail";
		
		if(memberVO !=null) {
			message = "Login Success";
			session.setAttribute("member", memberVO);
			session.setAttribute("file", memberFilesVO);
		}
		mv.setViewName("common/result");
		mv.addObject("message", message);
		mv.addObject("path","../");
		return mv;
	
	}
	
	@GetMapping("memberPage")
	public void memberPage()throws Exception{
			
	}
	
	@GetMapping("memberLogout")
	public String memberLogout(HttpSession session)throws Exception{
		session.invalidate();
		return "redirect:../";
	}
	
}
