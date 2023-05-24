package com.enjoytrip.ws.board.model.service;

import java.util.List;
import java.util.Map;

import com.enjoytrip.util.PageNavigation;
import com.enjoytrip.ws.board.model.BoardDto;
import com.enjoytrip.ws.board.model.CommentDto;
import com.enjoytrip.ws.member.model.MemberDto;

public interface BoardService {

	List<BoardDto> listArticle(Map<String, String> map) throws Exception;
	PageNavigation makePageNavigation(Map<String, String> map) throws Exception;
	void writeArticle(BoardDto boardDto) throws Exception;
	BoardDto getArticle(int articleNo) throws Exception;
	void updateHit(int articleNo) throws Exception;
	void modifyArticle(BoardDto boardDto) throws Exception;
	void deleteArticle(int articleNo, String uploadPath) throws Exception;
	boolean writeComment(CommentDto commentDto)throws Exception;
	List<CommentDto> listComment(int articleNo)throws Exception;
	List<BoardDto> listArticleById(String userId) throws Exception;
	List<BoardDto> listArticleBySubject(String subject)throws Exception;
	
	
}
