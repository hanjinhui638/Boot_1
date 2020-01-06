package com.jh.b1.board;

import java.sql.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;

public class NoticeVO {
	
	private int num;
	
	@NotEmpty
	private String title;
	@NotEmpty
	private String writer;
	private String contents;
	private Date regDate;
	private int hit;
	
	
	private List<NoticeFilesVO> files;
	
	
	
	
	public List<NoticeFilesVO> getFiles() {
		return files;
	}
	public void setFiles(List<NoticeFilesVO> files) {
		this.files = files;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	
	
	

}
