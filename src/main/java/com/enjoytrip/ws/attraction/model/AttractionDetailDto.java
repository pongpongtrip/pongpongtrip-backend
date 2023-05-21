package com.enjoytrip.ws.attraction.model;

public class AttractionDetailDto {
	private String first_image;
	private String content_id;
	private String title;
	private String addr1;
	private String latitude;
	private String longitude;
	private int hit;
	private String homepage;
	private String overview;
	private String telname;
	
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
	public String getTelname() {
		return telname;
	}
	public void setTelname(String telname) {
		this.telname = telname;
	}
	
	@Override
	public String toString() {
		return "AttractionDetailDto [first_image=" + first_image + ", content_id=" + content_id + ", title=" + title
				+ ", addr1=" + addr1 + ", latitude=" + latitude + ", longitude=" + longitude + ", hit=" + hit
				+ ", homepage=" + homepage + ", overview=" + overview + ", telname=" + telname + "]";
	}
	
	
}
