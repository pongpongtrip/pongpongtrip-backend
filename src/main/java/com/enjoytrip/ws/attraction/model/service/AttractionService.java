package com.enjoytrip.ws.attraction.model.service;

import java.sql.SQLException;
import java.util.List;

import com.enjoytrip.ws.attraction.model.AttractionDto;


public interface AttractionService {
	List<AttractionDto> attractionList(int sido_code, int content_type_id, String title) throws SQLException;

	List<AttractionDto> hotAttractionList() throws SQLException;
}
