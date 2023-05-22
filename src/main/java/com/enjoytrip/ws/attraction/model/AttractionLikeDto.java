package com.enjoytrip.ws.attraction.model;

public class AttractionLikeDto {
	private String user_id;
	private String content_id;
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getContent_id() {
		return content_id;
	}
	public void setContent_id(String content_id) {
		this.content_id = content_id;
	}
	
	@Override
	public String toString() {
		return "AttractionLikeDto [user_id=" + user_id + ", content_id=" + content_id + "]";
	}
	
}
