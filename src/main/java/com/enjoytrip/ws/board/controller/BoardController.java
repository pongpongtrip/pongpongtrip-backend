package com.enjoytrip.ws.board.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.enjoytrip.util.PageNavigation;
import com.enjoytrip.ws.board.model.BoardDto;
import com.enjoytrip.ws.board.model.CommentDto;
import com.enjoytrip.ws.board.model.FileInfoDto;
import com.enjoytrip.ws.board.model.service.BoardService;
import com.enjoytrip.ws.member.model.MemberDto;




@RestController
@CrossOrigin("*")
@RequestMapping("/board")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Value("${file.path}")
	private String uploadPath;
	
	@Value("${file.imgPath}")
	private String uploadImgPath;
	
	private BoardService boardService;

	public BoardController(BoardService boardService) {
		super();
		this.boardService = boardService;
	}

	@GetMapping("/list")
	public List<BoardDto> list(@RequestParam Map<String, String> map) throws Exception {
		logger.debug("list parameter pgno : {}", map.get("pgno"));
		
		List<BoardDto> list = boardService.listArticle(map);
		Collections.sort(list, new Comparator<BoardDto>() {
			@Override
			public int compare(BoardDto o1, BoardDto o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1.getArticleNo(), o2.getArticleNo());
			}
		});
		return list;
	}
	
	
	@PostMapping("/write")
	public void write(@RequestBody BoardDto boardDto) throws Exception {
		logger.debug("write boardDto : {}", boardDto);
		//여기
		System.out.println(boardDto);

		boardService.writeArticle(boardDto);
		
	}
	
	@GetMapping("/view")
	public BoardDto view(BoardDto dto)
			throws Exception {
//		logger.debug("view articleNo : {}", );
		System.out.println(dto.getArticleNo());
		BoardDto boardDto = boardService.getArticle(dto.getArticleNo());
		boardService.updateHit(dto.getArticleNo());

		return boardDto;
	}

	@PostMapping("/modify")
	public void modify(@RequestBody BoardDto boardDto) throws Exception {
		logger.debug("modify boardDto : {}", boardDto);
		System.out.println(boardDto.getArticleNo());
		System.out.println(boardDto.getContent());
		boardService.modifyArticle(boardDto);
		
	}

	@GetMapping("/delete")
	public void delete(BoardDto dto) throws Exception {
		logger.debug("delete articleNo : {}", dto.getArticleNo());
		System.out.println("삭제" + dto.getArticleNo());
		boardService.deleteArticle(dto.getArticleNo(), uploadPath);
	}

	@GetMapping("/download")
	public ModelAndView downloadFile(@RequestParam("sfolder") String sfolder, @RequestParam("ofile") String ofile,
			@RequestParam("sfile") String sfile) {
		Map<String, Object> fileInfo = new HashMap<String, Object>();
		fileInfo.put("sfolder", sfolder);
		fileInfo.put("ofile", ofile);
		fileInfo.put("sfile", sfile);
		return new ModelAndView("fileDownLoadView", "downloadFile", fileInfo);
	}
	
	@PostMapping("/comment/write")
	public ResponseEntity<String> writeComment(@RequestBody CommentDto commentDto){
		logger.debug("memberDto info : {}", commentDto);
		
		System.out.println(commentDto.getUserName());
		
		try {
			if(boardService.writeComment(commentDto)) {
				return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.OK);
	}
	
	@GetMapping("/comment/list/{articleno}")
	public ResponseEntity<?> commentList(@PathVariable("articleno") String articleNo){
//		logger.debug("articleNo : ", articleNo);
		
		List<CommentDto> list;
		try {
			list = boardService.listComment(Integer.parseInt(articleNo));
			
			System.out.println(list.toString());
			
			if(list!= null && !list.isEmpty()) {
				return new ResponseEntity<List<CommentDto>>(list, HttpStatus.OK);
			}else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return new ResponseEntity<String>(FAIL, HttpStatus.OK);
	}
	
	@GetMapping(value = "/list/userid/{key}")
	public ResponseEntity<?> userListById(@PathVariable("key") String userId) {
		logger.debug("userListById call");
		
		try {
			List<BoardDto> list = boardService.listArticleById(userId);
			
			if(list != null && !list.isEmpty()) {
				return new ResponseEntity<List<BoardDto>>(list, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.OK);
	}
	
	@GetMapping(value = "/list/subject/{key}")
	public ResponseEntity<?> userListBySubject(@PathVariable("key") String subject) {
		logger.debug("userListById call");

		try {
			List<BoardDto> list = boardService.listArticleBySubject(subject);
			System.out.println(list.toString());
			
			if(list != null && !list.isEmpty()) {
				return new ResponseEntity<List<BoardDto>>(list, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.OK);
	}



	
}
