package com.jh.b1.member;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jh.b1.util.FilePathGenerator;
import com.jh.b1.util.FileSaver;

@Service
public class MemberService {

	@Autowired
	private MemberMapper memberMapper;
	
	//@Autowired
	//private ServletContext servletContext;
	
	@Autowired
	private FilePathGenerator filePathGenerator;
	
	@Autowired
	private FileSaver fileSaver;
	
	public int memberJoin(MemberVO memberVO, MultipartFile files)throws Exception{
		
		/*
		 * String filePath = servletContext.getRealPath("upload");
		 * System.out.println(filePath);
		 */
		
		/* filePathGenerator.getUseResourceLoader(); */
		
		File file = filePathGenerator.getUseClassPathResource("upload");
		String fileName = fileSaver.save(file, files);
		System.out.println(fileName);
		
		return 0; //memberMapper.memberJoin(memberVO);
	}
}
