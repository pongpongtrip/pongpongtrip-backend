package com.enjoytrip.ws.board.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.enjoytrip.ws.board.model.BoardDto;
import com.enjoytrip.ws.member.model.MemberDto;

@Mapper
public interface BoardMapper {

	List<BoardDto> listArticle(Map<String, Object> param) throws SQLException;

	int getTotalArticleCount(Map<String, Object> param) throws SQLException;

}
