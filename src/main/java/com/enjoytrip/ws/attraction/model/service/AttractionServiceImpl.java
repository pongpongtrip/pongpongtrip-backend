package com.enjoytrip.ws.attraction.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enjoytrip.ws.attraction.model.AttractionDto;
import com.enjoytrip.ws.attraction.model.mapper.AttractionMapper;

@Service
public class AttractionServiceImpl implements AttractionService {
	
	private AttractionMapper attractionMapper;
	
	@Autowired
	private AttractionServiceImpl(AttractionMapper attractionMapper) {
		super();
		this.attractionMapper = attractionMapper;
	}
	
	// --- �̱���

	@Override
	public List<AttractionDto> attractionList(int sido_code, int content_type_id, String title) throws SQLException {	
		return attractionMapper.attractionList(sido_code, content_type_id, title);
	}

}
