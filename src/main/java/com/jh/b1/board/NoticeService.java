package com.jh.b1.board;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import com.jh.b1.util.FilePathGenerator;
import com.jh.b1.util.FileSaver;
import com.jh.b1.util.Pager;


@Service
public class NoticeService {
	
	@Resource(name = "noticeMapper")
	private NoticeMapper noticeMapper;
	
	@Autowired
	private NoticeFilesMapper noticeFilesMapper;
	
	@Autowired
	private FilePathGenerator filePathGenerator;
	
	@Autowired
	private FileSaver fileSaver;
	
	public boolean noticeWriteValidate(NoticeVO noticeVO, BindingResult bindingResult)throws Exception{
		boolean check = false;
		
		if(bindingResult.hasErrors()) {
			check = true;
		}
		
		return check;
	}
	
	@Transactional
	public int noticeWrite(NoticeVO noticeVO, MultipartFile[] files)throws Exception{
		
		int result = noticeMapper.boardWrite(noticeVO);
		
		File file = filePathGenerator.getUseClassPathResource("notice");
		
		List<NoticeFilesVO> noticeFilesVOs = new ArrayList<>();
		for(int i=1; i<files.length;i++) {
			String fileName = fileSaver.save(file, files[i]);
			NoticeFilesVO noticeFilesVO = new NoticeFilesVO();
			noticeFilesVO.setNum(noticeVO.getNum());
			noticeFilesVO.setFname(fileName);
			noticeFilesVO.setOname(files[i].getOriginalFilename());
			//mapper 호출
			noticeFilesVOs.add(noticeFilesVO);
		}
	
		noticeFilesMapper.noticefilesInsert(noticeFilesVOs);
		return result;
	}
	
	
	public List<NoticeVO> boardList(Pager pager)throws Exception{
		int totalCount = noticeMapper.boardCount(pager);
		pager.makePage(totalCount);
		pager.makeStartRow();
		
		return noticeMapper.boardList(pager);
		
	}
	

}
