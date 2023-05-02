package com.enjoytrip.ws.attraction.model;

public class AttractionPlanDto {
	private int plan_id;
	private int content_id;
	private String user_id;
	private int content_order;
	
	public AttractionPlanDto(int plan_id, String user_id) {
		super();
		this.plan_id = plan_id;
		this.user_id = user_id;
	}
	
	public AttractionPlanDto(int plan_id, int content_id) {
		super();
		this.plan_id = plan_id;
		this.content_id = content_id;
	}

	public int getPlan_id() {
		return plan_id;
	}

	public void setPlan_id(int plan_id) {
		this.plan_id = plan_id;
	}

	public int getContent_id() {
		return content_id;
	}

	public void setContent_id(int content_id) {
		this.content_id = content_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getContent_order() {
		return content_order;
	}

	public void setContent_order(int content_order) {
		this.content_order = content_order;
	}
	
	
}
