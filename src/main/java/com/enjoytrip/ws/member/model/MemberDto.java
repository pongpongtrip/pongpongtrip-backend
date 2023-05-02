package com.enjoytrip.ws.member.model;

public class MemberDto {
	
	private String userId;
	private String userName;
	private String userPassword;
	private String joinDate;
	private Integer admin;
	
	
	
	public MemberDto(String userId, String userName, String userPassword, String joinDate, Integer admin) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.joinDate = joinDate;
		this.admin = admin;
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

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	public int isAdmin() {
		return admin;
	}

	public void setAdmin(Integer admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "MemberDto [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword
				+ ", joinDate=" + joinDate + ", admin=" + admin + "]";
	}

	
}
