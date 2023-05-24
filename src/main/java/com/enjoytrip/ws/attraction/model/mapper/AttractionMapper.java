package com.enjoytrip.ws.attraction.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.enjoytrip.ws.attraction.model.AttractionDetailDto;
import com.enjoytrip.ws.attraction.model.AttractionDto;
import com.enjoytrip.ws.attraction.model.AttractionLikeDto;
import com.enjoytrip.ws.attraction.model.AttractionPlanDetailDto;
import com.enjoytrip.ws.attraction.model.AttractionPlanDto;

@Mapper
public interface AttractionMapper {
	List<AttractionDetailDto> attractionList(@Param("sido_code")int sido_code, 
			@Param("content_type_id") int content_type_id, @Param("title") String title) throws SQLException;

	List<AttractionDto> hotAttractionList() throws SQLException;

	int maxIndex() throws SQLException;

	boolean writePlan(AttractionPlanDto planDto) throws SQLException;

	boolean likeAttraction(AttractionLikeDto dto)throws SQLException;

	boolean dislikeAttraction(AttractionLikeDto dto)throws SQLException;

	List<AttractionDetailDto> myHotPlace(AttractionLikeDto dto);

	List<AttractionPlanDetailDto> myPlans(AttractionPlanDto dto);

	boolean updateHit(int contentId);

	boolean deletePlan(AttractionPlanDto dto);
}
