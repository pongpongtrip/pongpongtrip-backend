package com.enjoytrip.ws.attraction.model;

public class AttractionDto {
	private String first_image;
	private String content_id;
	private String title;
	private String addr1;
	private String latitude;
	private String longitude;
	
	public AttractionDto() {
		super();
	}
	

	public AttractionDto(String first_image, String content_id, String title, String addr1, String latitude,
			String longitude) {
		super();
		this.first_image = first_image;
		this.content_id = content_id;
		this.title = title;
		this.addr1 = addr1;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	@Override
	public String toString() { 
		return "{ [`first_image`]:`" + first_image + "`,[`content_id`]:`" + content_id + "`,[`title`]:`" + title.replaceAll("`", "'")
				+ "`,[`addr1`]:`" + addr1 + "`,[`latitude`]:`" + latitude + "`,[`longitude`]:`" + longitude + "`}";
	}
	

	

	public String getFirst_image() {
		return first_image;
	}

	public void setFirst_image(String first_image) {
		this.first_image = first_image;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
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
	
	
	
	
	
}
