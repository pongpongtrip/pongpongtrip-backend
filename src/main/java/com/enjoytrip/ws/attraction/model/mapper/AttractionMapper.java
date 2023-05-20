package com.enjoytrip.ws.attraction.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.enjoytrip.ws.attraction.model.AttractionDto;

@Mapper
public interface AttractionMapper {
	List<AttractionDto> attractionList(@Param("sido_code")int sido_code, 
			@Param("content_type_id") int content_type_id, @Param("title") String title) throws SQLException;

	List<AttractionDto> hotAttractionList() throws SQLException;
}
