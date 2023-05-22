package com.enjoytrip.ws.attraction.model;

public class AttractionPlanDto {
	private int index;
	private int planId;
	private int contentId;
	private String time;
	private String userId;
	private String userName;
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getPlanId() {
		return planId;
	}
	public void setPlanId(int planId) {
		this.planId = planId;
	}
	public int getContentId() {
		return contentId;
	}
	public void setContentId(int contentId) {
		this.contentId = contentId;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
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
	@Override
	public String toString() {
		return "AttractionPlanDto [index=" + index + ", planId=" + planId + ", contentId=" + contentId + ", time="
				+ time + ", userId=" + userId + ", userName=" + userName + "]";
	}
	
}
