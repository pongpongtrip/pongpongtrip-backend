package com.enjoytrip.ws.attraction.model.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.enjoytrip.ws.attraction.model.AttractionDetailDto;
import com.enjoytrip.ws.attraction.model.AttractionDto;
import com.enjoytrip.ws.attraction.model.AttractionPlanDto;
import com.enjoytrip.ws.attraction.model.mapper.AttractionMapper;

@Service
public class AttractionServiceImpl implements AttractionService {
	
//	private AttractionMapper attractionMapper;
//
//	@Autowired
//	private AttractionServiceImpl(AttractionMapper attractionMapper) {
//		super();
//		this.attractionMapper = attractionMapper;
//	}
//	
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<AttractionDetailDto> attractionList(int sido_code, int content_type_id, String title) throws SQLException {	
		return sqlSession.getMapper(AttractionMapper.class).attractionList(sido_code, content_type_id, title);
	}

	@Override
	public List<AttractionDto> hotAttractionList() throws SQLException {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(AttractionMapper.class).hotAttractionList();
	}

	@Override
	public int maxIndex() throws SQLException {
		return sqlSession.getMapper(AttractionMapper.class).maxIndex();
	}


	@Override
	public boolean writePlan(AttractionPlanDto planDto) throws SQLException {
		System.out.println("serimpl =>" +planDto);
		return sqlSession.getMapper(AttractionMapper.class).writePlan(planDto);
		
	}

}
