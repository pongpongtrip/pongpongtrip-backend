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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
import com.enjoytrip.ws.board.model.FileInfoDto;
import com.enjoytrip.ws.board.model.service.BoardService;
import com.enjoytrip.ws.member.model.MemberDto;




@RestController
@CrossOrigin("*")
@RequestMapping("/board")
public class BoardController {
	
	private final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
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
		System.out.println("map 출력 -----------------------------");
		System.out.println(map);
		ModelAndView mav = new ModelAndView();
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
	
	
//	@GetMapping("/write")
//	public String write(@RequestParam Map<String, String> map, Model model) {
//		logger.debug("write call parameter {}", map);
//		model.addAttribute("pgno", map.get("pgno"));
//		model.addAttribute("key", map.get("key"));
//		model.addAttribute("word", map.get("word"));
//		return "board/boardwrite";
//	}

	@PostMapping("/write")
	public void write(@RequestBody BoardDto boardDto) throws Exception {
		logger.debug("write boardDto : {}", boardDto);
		//여기
		
		// 임시로 설정
		MemberDto memberDto = new MemberDto("admin", "관리자", "1234", "2023-05-02", 0);
		boardDto.setUserId(memberDto.getUserId());
		// 원래 코드
//		MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
//		boardDto.setUserId(memberDto.getUserId());
		

//		FileUpload 관련 설정.
//		logger.debug("MultipartFile.isEmpty : {}", files[0].isEmpty());
//		if (!files[0].isEmpty()) {
//			String today = new SimpleDateFormat("yyMMdd").format(new Date());
//			String saveFolder = uploadPath + File.separator + today;
//			logger.debug("저장 폴더 : {}", saveFolder);
//			File folder = new File(saveFolder);
//			if (!folder.exists())
//				folder.mkdirs();
//			List<FileInfoDto> fileInfos = new ArrayList<FileInfoDto>();
//			for (MultipartFile mfile : files) {
//				FileInfoDto fileInfoDto = new FileInfoDto();
//				String originalFileName = mfile.getOriginalFilename();
//				if (!originalFileName.isEmpty()) {
//					String saveFileName = UUID.randomUUID().toString()
//							+ originalFileName.substring(originalFileName.lastIndexOf('.'));
//					fileInfoDto.setSaveFolder(today);
//					fileInfoDto.setOriginalFile(originalFileName);
//					fileInfoDto.setSaveFile(saveFileName);
//					logger.debug("원본 파일 이름 : {}, 실제 저장 파일 이름 : {}", mfile.getOriginalFilename(), saveFileName);
//					mfile.transferTo(new File(folder, saveFileName));
//				}
//				fileInfos.add(fileInfoDto);
//			}
//			boardDto.setFileInfos(fileInfos);
//		}

		boardService.writeArticle(boardDto);
		
//		return "write test";
	}
	
	@GetMapping("/view")
	public BoardDto view(BoardDto dto)
			throws Exception {
//		logger.debug("view articleNo : {}", );
		System.out.println(dto.getArticleNo());
		BoardDto boardDto = boardService.getArticle(dto.getArticleNo());
		boardService.updateHit(dto.getArticleNo());
		
//		Map<String, Object> responseMap = new HashMap<>();
		// Populate the responseMap with the necessary data from the boardDto
//		responseMap.put("article", boardDto);
//		responseMap.put("pgno", map.get("pgno"));
//		responseMap.put("key", map.get("key"));
//		responseMap.put("word", map.get("word"));
		
//		model.addAttribute("article", boardDto);
//		model.addAttribute("pgno", map.get("pgno"));
//		model.addAttribute("key", map.get("key"));
//		model.addAttribute("word", map.get("word"));
		return boardDto;
	}
	
//	@GetMapping("/view")
//	public Map<String, Object> view(@RequestParam("articleno") int articleNo, @RequestParam Map<String, String> map, Model model)
//			throws Exception {
//		logger.debug("view articleNo : {}", articleNo);
//		BoardDto boardDto = boardService.getArticle(articleNo);
//		boardService.updateHit(articleNo);
//		
//		Map<String, Object> responseMap = new HashMap<>();
//		// Populate the responseMap with the necessary data from the boardDto
//		responseMap.put("article", boardDto);
//		responseMap.put("pgno", map.get("pgno"));
//		responseMap.put("key", map.get("key"));
//		responseMap.put("word", map.get("word"));
//		
////		model.addAttribute("article", boardDto);
////		model.addAttribute("pgno", map.get("pgno"));
////		model.addAttribute("key", map.get("key"));
////		model.addAttribute("word", map.get("word"));
//		return responseMap;
//	}

//	@GetMapping("/modify")
//	public void modify(@RequestParam("articleno") int articleNo, @RequestParam Map<String, String> map, Model model)
//			throws Exception {
//		logger.debug("modify articleNo : {}", articleNo);
//		BoardDto boardDto = boardService.getArticle(articleNo);
//		
//		Map<String, Object> responseMap = new HashMap<>();
//		// Populate the responseMap with the necessary data from the boardDto
//		responseMap.put("article", boardDto);
//		responseMap.put("pgno", map.get("pgno"));
//		responseMap.put("key", map.get("key"));
//		responseMap.put("word", map.get("word"));
//		
////		return "board/boardmodify";
//	}

	@PostMapping("/modify")
	public void modify(@RequestBody BoardDto boardDto) throws Exception {
		logger.debug("modify boardDto : {}", boardDto);
		System.out.println(boardDto.getArticleNo());
		System.out.println(boardDto.getContent());
		boardService.modifyArticle(boardDto);
		
//		redirectAttributes.addAttribute("pgno", map.get("pgno"));
//		redirectAttributes.addAttribute("key", map.get("key"));
//		redirectAttributes.addAttribute("word", map.get("word"));
//		return "redirect:/board/list";
	}

	@GetMapping("/delete")
	public void delete(BoardDto dto) throws Exception {
		logger.debug("delete articleNo : {}", dto.getArticleNo());
		System.out.println("삭제" + dto.getArticleNo());
		boardService.deleteArticle(dto.getArticleNo(), uploadPath);
//		redirectAttributes.addAttribute("pgno", map.get("pgno"));
//		redirectAttributes.addAttribute("key", map.get("key"));
//		redirectAttributes.addAttribute("word", map.get("word"));
//		return "redirect:/board/list";
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


	
}
