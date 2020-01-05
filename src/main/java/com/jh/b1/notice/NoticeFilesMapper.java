package com.jh.b1.notice;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoticeFilesMapper {

	public int noticefilesInsert(NoticeFilesVO noticeFilesVO)throws Exception;
	
}
