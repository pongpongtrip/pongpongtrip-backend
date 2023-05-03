package com.enjoytrip.ws.board.model.service;

import java.util.List;
import java.util.Map;

import com.enjoytrip.util.PageNavigation;
import com.enjoytrip.ws.board.model.BoardDto;

public interface BoardService {

	List<BoardDto> listArticle(Map<String, String> map) throws Exception;
	PageNavigation makePageNavigation(Map<String, String> map) throws Exception;
	
	
}
