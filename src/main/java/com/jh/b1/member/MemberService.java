package com.jh.b1.member;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import com.jh.b1.util.FilePathGenerator;
import com.jh.b1.util.FileSaver;

@Service
@Transactional(rollbackFor = Exception.class)
public class MemberService {

	@Autowired
	private MemberMapper memberMapper;
	
	//@Autowired
	//private ServletContext servletContext;
	
	@Autowired
	private FilePathGenerator filePathGenerator;
	
	@Autowired
	private MemberFilesMapper memberFilesMapper;
	
	@Autowired
	private FileSaver fileSaver;
	
	public boolean memberJoinValidate(MemberVO memberVO, BindingResult bindingResult)throws Exception{
		boolean check = false; // true -> error, false -> ok
		
		//annotaion 검증 결과 return 
		if(bindingResult.hasErrors()) {
			check = true;
		}
		
		//pw가 일치 하는 지 검증 
		if(!memberVO.getPw().equals(memberVO.getPw2())) {
			check = true;
			bindingResult.rejectValue("pw2", "memberVO.pw.notEqual" );
										//form의 path명 , properties의 키 
		}
		
		
		//id가 증복 검사 
		memberVO = memberMapper.memberCheckId(memberVO);
		
		if(memberVO != null) {
					check = true;
					bindingResult.rejectValue("id", "memberVO.id.notNull");
		}
		
		
		return check;
		
	}
	
	
	
	//@Transactional
	public int memberJoin(MemberVO memberVO, MultipartFile files)throws Exception{
			
		 // String filePath = servletContext.getRealPath("upload");
		 //System.out.println(filePath);		 	
		// filePathGenerator.getUseResourceLoader(); 
		
		
		File file = filePathGenerator.getUseClassPathResource("upload");
		String fileName = fileSaver.save(file, files);
		System.out.println(fileName);
		
		int result = memberMapper.memberJoin(memberVO);
		MemberFilesVO memberFilesVO = new MemberFilesVO();
		memberFilesVO.setId(memberVO.getId());
		memberFilesVO.setFname(fileName);
		memberFilesVO.setOname(files.getOriginalFilename());
		result = memberFilesMapper.memberfilesInsert(memberFilesVO);
		
		return result; //memberMapper.memberJoin(memberVO);
	}
	
	public MemberVO memberLogin(MemberVO memberVO)throws Exception{
		
		return memberMapper.memberLogin(memberVO);
		
	}
	
	public MemberFilesVO memberfilesSelect(MemberFilesVO memberFilesVO)throws Exception{
		
		return memberFilesMapper.memberfilesSelect(memberFilesVO);
	}
	
	
	
	}
	
	

