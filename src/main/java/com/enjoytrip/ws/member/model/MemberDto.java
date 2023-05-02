package com.enjoytrip.ws.member.model;

public class MemberDto {
	private String user_name;
	private String user_id;
	private String user_password;
	private String join_date;
	private boolean admin;
	private boolean dflag;
	public MemberDto( String id, String name, String password) {
		super();
		this.user_name = name;
		this.user_id = id;
		this.user_password = password;
	}
	public MemberDto( String id, String name, String password, boolean admin) {
		super();
		this.user_name = name;
		this.user_id = id;
		this.user_password = password;
		this.admin = admin;
	}
	public MemberDto(String id, String name,  String password, String joinDate, boolean admin, boolean dflag) {
		super();
		this.user_name = name;
		this.user_id = id;
		this.user_password = password;
		this.join_date = joinDate;
		this.admin = admin;
	}
	public MemberDto(String id, String name, boolean admin) {
		super();
		this.user_id = id;
		this.user_name = name;
		this.admin = admin;
	}
	public MemberDto(String id, String password) {
		super();
		this.user_id = id;
		this.user_password = password;
	}
	public String getName() {
		return user_name;
	}
	public void setName(String name) {
		this.user_name = name;
	}
	public String getId() {
		return user_id;
	}
	public void setId(String id) {
		this.user_id = id;
	}
	public String getPassword() {
		return user_password;
	}
	public void setPassword(String password) {
		this.user_password = password;
	}
	public String getJoinDate() {
		return join_date;
	}
	public void setJoinDate(String joinDate) {
		this.join_date = joinDate;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public boolean isDflag() {
		return dflag;
	}
	public void setDflag(boolean dflag) {
		this.dflag = dflag;
	}
	
}
