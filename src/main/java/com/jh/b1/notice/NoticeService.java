package com.jh.b1.notice;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import com.jh.b1.util.FilePathGenerator;
import com.jh.b1.util.FileSaver;

@Service
public class NoticeService {
	
	@Autowired
	private NoticeMapper noticeMapper;
	
	@Autowired
	private NoticeFilesMapper noticeFilesMapper;
	
	@Autowired
	private FilePathGenerator filePathGenerator;
	
	@Autowired
	private FileSaver fileSaver;
	
	/*public boolean noticeWriteValidate(NoticeVO noticeVO, BindingResult bindingResult)throws Exception{
		boolean check = false;
		
		if(bindingResult.hasErrors()) {
			check = true;
		}
		
		return check;
	}*/
	
	public int noticeWrite(NoticeVO noticeVO, MultipartFile files)throws Exception{
		
		File file = filePathGenerator.getUseClassPathResource("upload");
		String fileName = fileSaver.save(file, files);
		
		int result = noticeMapper.noticeWrite(noticeVO);
		NoticeFilesVO noticeFilesVO = new NoticeFilesVO();
		noticeFilesVO.setNum(noticeVO.getNum());
		noticeFilesVO.setFname(fileName);
		noticeFilesVO.setOname(files.getOriginalFilename());
		result = noticeFilesMapper.noticefilesInsert(noticeFilesVO);
		
		return result;
	}
	

}
