package com.enjoytrip.ws.member.model;

public class MemberDto {
	
	private String userId;
	private String userName;
	private String userPassword;
	private String joinDate;
	private Integer admin;
	private String email;
	
	
	
	public MemberDto() {
		super();
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

	public void setAdmin(int admin) {
		this.admin = admin;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "MemberDto [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword
				+ ", joinDate=" + joinDate + ", admin=" + admin + ", email=" + email + "]";
	}

	
	
}
