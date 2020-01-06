package com.jh.b1.board;


import java.awt.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.jh.b1.util.Pager;

@Repository
@Mapper
public interface NoticeMapper {

	public int boardWrite(NoticeVO noticeVO)throws Exception;
	
	public java.util.List<NoticeVO> boardList(Pager pager)throws Exception;
	
	public int boardCount(Pager pager)throws Exception;
	
	public NoticeVO noticeSelect(NoticeVO noticeVO)throws Exception;
}
