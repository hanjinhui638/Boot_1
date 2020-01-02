package com.jh.b1.member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberFilesMapper {
	
	public int memberfilesInsert(MemberFilesVO memberFilesVO)throws Exception;
	
	public MemberFilesVO memberfilesSelect(MemberFilesVO memberFilesVO)throws Exception;
}
