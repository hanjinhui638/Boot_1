package com.jh.b1.board;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jh.b1.member.MemberService;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
	@Resource(name = "noticeService")
	private NoticeService noticeService;
	
	//notice를 boardVO로 보내주는 방법 4 (controller 안에서 가장 먼저 실행)
	@ModelAttribute(name = "noticeVO")
	public NoticeVO getNoticeVO()throws Exception{
		return new NoticeVO();
	}

	
	//@GetMapping("noticeWrite")				//notice를 boardVO로 보내주는 방법 3
	//public String noticeWrite(Model model, @ModelAttribute(name = "boardVO") NoticeVO noticeVO)throws Exception{
		//noticeVO로 받으면 noticeWrite에서 noticeVO로만 받아줌 
		
		//notice를 boardVO로 보내주는 방법 1
	//	model.addAttribute("boardVO", new NoticeVO());
		
		//notice를 boardVO로 보내주는 방법 2
		// ModelAndView mv = new ModelAndView();
		// mv.addObject("boardVO", new NoticeVO());
		
	//	return "board/boardWrite";
	//}
	
	@GetMapping("noticeWrite")
	public String noticeWrite()throws Exception{
		
		return "board/boardWrite";
	}
	
	
	

	@PostMapping("noticeWrite")
	public ModelAndView noticeWrite(@Valid NoticeVO noticeVO, BindingResult bindingResult, MultipartFile[] files)throws Exception{
		
		ModelAndView mv = new ModelAndView();
		
		if(bindingResult.hasErrors()) {
			
			mv.setViewName("notice/noticeWrite");
		}else {
		
		
		int result = noticeService.noticeWrite(noticeVO, files);
		
		String message = "Write Fail";
	
		if(result>0) {
			message = "Write Success";
		}
		mv.setViewName("common/result");
		mv.addObject("message", message);
		mv.addObject("path", "./noticeList");
		}
		return mv;
		
	}
	
	@GetMapping("noticeList")
	public ModelAndView noticeList()throws Exception{
		ModelAndView mv = new ModelAndView();
		
		List<NoticeVO> ar = noticeService.boardList();
		mv.addObject("list", ar);
		mv.setViewName("board/boardList");
		
		return mv;
	}
	
}
