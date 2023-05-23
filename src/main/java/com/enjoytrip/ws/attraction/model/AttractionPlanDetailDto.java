package com.enjoytrip.ws.attraction.model;

public class AttractionPlanDetailDto {
	private String first_image;
	private String content_id;
	private String title;
	private String addr1;
	private String latitude;
	private String longitude;
	private int hit;
	private String homepage;
	private String overview;
	private int planId;
	private int contentId;
	private String time;
	private String userId;
	private String userName;
	private String planName;
	
	
	
	public String getFirst_image() {
		return first_image;
	}



	public void setFirst_image(String first_image) {
		this.first_image = first_image;
	}



	public String getContent_id() {
		return content_id;
	}



	public void setContent_id(String content_id) {
		this.content_id = content_id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getAddr1() {
		return addr1;
	}



	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}



	public String getLatitude() {
		return latitude;
	}



	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}



	public String getLongitude() {
		return longitude;
	}



	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}



	public int getHit() {
		return hit;
	}



	public void setHit(int hit) {
		this.hit = hit;
	}



	public String getHomepage() {
		return homepage;
	}



	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}



	public String getOverview() {
		return overview;
	}



	public void setOverview(String overview) {
		this.overview = overview;
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
	
	public String getPlanName() {
		return planName;
	}



	public void setPlanName(String planName) {
		this.planName = planName;
	}



	@Override
	public String toString() {
		return "AttractionPlanDetailDto [first_image=" + first_image + ", content_id=" + content_id + ", title=" + title
				+ ", addr1=" + addr1 + ", latitude=" + latitude + ", longitude=" + longitude + ", hit=" + hit
				+ ", homepage=" + homepage + ", overview=" + overview + ", planId=" + planId + ", contentId="
				+ contentId + ", time=" + time + ", userId=" + userId + ", userName=" + userName + "]";
	}
}
