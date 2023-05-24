package com.enjoytrip.ws.board.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.enjoytrip.ws.board.model.BoardDto;
import com.enjoytrip.ws.board.model.CommentDto;
import com.enjoytrip.ws.board.model.FileInfoDto;
import com.enjoytrip.ws.member.model.MemberDto;

@Mapper
public interface BoardMapper {

	List<BoardDto> listArticle(Map<String, Object> param) throws SQLException;

	int getTotalArticleCount(Map<String, Object> param) throws SQLException;

	void writeArticle(BoardDto boardDto) throws SQLException;

	void registerFile(BoardDto boardDto)throws Exception;

	BoardDto getArticle(int articleNo)throws SQLException;

	void updateHit(int articleNo)throws SQLException;

	void modifyArticle(BoardDto boardDto)throws SQLException;

	List<FileInfoDto> fileInfoList(int articleNo) throws Exception;

	void deleteFile(int articleNo) throws Exception;

	void deleteArticle(int articleNo)throws SQLException;

	boolean writeComment(CommentDto commentDto)throws SQLException;

	List<CommentDto> listComment(int articleNo) throws SQLException;

}
