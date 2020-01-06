package com.jh.b1.board;


import java.awt.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface NoticeMapper {

	public int boardWrite(NoticeVO noticeVO)throws Exception;
	
	public java.util.List<NoticeVO> boardList()throws Exception;
}
