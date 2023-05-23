package com.enjoytrip.ws.attraction.model.service;

import java.sql.SQLException;
import java.util.List;

import com.enjoytrip.ws.attraction.model.AttractionDetailDto;
import com.enjoytrip.ws.attraction.model.AttractionDto;
import com.enjoytrip.ws.attraction.model.AttractionLikeDto;
import com.enjoytrip.ws.attraction.model.AttractionPlanDetailDto;
import com.enjoytrip.ws.attraction.model.AttractionPlanDto;


public interface AttractionService {
	List<AttractionDetailDto> attractionList(int sido_code, int content_type_id, String title) throws SQLException;

	List<AttractionDto> hotAttractionList() throws SQLException;

	int maxIndex() throws SQLException;

	boolean writePlan(AttractionPlanDto planDto) throws SQLException;

	boolean like(AttractionLikeDto dto)throws SQLException;

	boolean dislike(AttractionLikeDto dto) throws SQLException;

	List<AttractionDetailDto> myHotPlace(AttractionLikeDto dto);

	List<AttractionPlanDetailDto> myplans(AttractionPlanDto dto);

	boolean updateHit(int contentId)throws SQLException;
}
