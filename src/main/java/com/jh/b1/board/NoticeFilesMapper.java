package com.jh.b1.board;



import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoticeFilesMapper {

	//public int noticefilesInsert(NoticeFilesVO noticeFilesVO)throws Exception;
	
	public int noticefilesInsert(java.util.List<NoticeFilesVO> noticeFilesVOs)throws Exception;
}
