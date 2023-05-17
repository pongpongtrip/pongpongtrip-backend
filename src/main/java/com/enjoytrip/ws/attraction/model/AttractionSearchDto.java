package com.enjoytrip.ws.attraction.model;

public class AttractionSearchDto {
	private String sido_code;
	private String content_type_id;
	private String search_keyword;
	
	public AttractionSearchDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AttractionSearchDto(String sido_code, String content_type_id, String search_keyword) {
		super();
		this.sido_code = sido_code;
		this.content_type_id = content_type_id;
		this.search_keyword = search_keyword;
	}

	public String getSido_code() {
		return sido_code;
	}

	public void setSido_code(String sido_code) {
		this.sido_code = sido_code;
	}

	public String getContent_type_id() {
		return content_type_id;
	}

	public void setContent_type_id(String content_type_id) {
		this.content_type_id = content_type_id;
	}

	public String getSearch_keyword() {
		return search_keyword;
	}

	public void setSearch_keyword(String search_keyword) {
		this.search_keyword = search_keyword;
	}
	
	
	
}
