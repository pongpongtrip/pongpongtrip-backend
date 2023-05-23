package com.enjoytrip.ws.board.model;

import java.util.List;

import com.enjoytrip.ws.attraction.model.AttractionPlanDetailDto;

public class BoardDto {

	private int articleNo;
	private String userId;
	private String userName;
	private String plan;
	private String subject;
	private String content;
	private int hit;
	private String registerTime;
	private List<FileInfoDto> fileInfos;
	
	

//	public BoardDto(String userId, String subject, String content) {
//		super();
//		this.userId = userId;
//		this.subject = subject;
//		this.content = content;
//	}
	
//	public BoardDto(int articleNo) {
//		this.articleNo = articleNo;
//	}
	public int getArticleNo() {
		return articleNo;
	}

	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}

	public List<FileInfoDto> getFileInfos() {
		return fileInfos;
	}

	public void setFileInfos(List<FileInfoDto> fileInfos) {
		this.fileInfos = fileInfos;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	@Override
	public String toString() {
		return "BoardDto [articleNo=" + articleNo + ", userId=" + userId + ", userName=" + userName + ", subject="
				+ subject + ", content=" + content + ", hit=" + hit + ", registerTime=" + registerTime + ", fileInfos="
				+ fileInfos + "]";
	}

}
