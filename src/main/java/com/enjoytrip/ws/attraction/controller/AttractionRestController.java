package com.enjoytrip.ws.attraction.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.enjoytrip.sort.QuickSort;
import com.enjoytrip.ws.attraction.model.AttractionDetailDto;
import com.enjoytrip.ws.attraction.model.AttractionDto;
import com.enjoytrip.ws.attraction.model.AttractionPlanDto;
import com.enjoytrip.ws.attraction.model.AttractionSearchDto;
import com.enjoytrip.ws.attraction.model.service.AttractionService;
import com.enjoytrip.ws.board.model.BoardDto;
import com.enjoytrip.ws.member.controller.MemberRestController;


@RestController
@CrossOrigin("*")
@RequestMapping("/attraction")
public class AttractionRestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private final Logger logger = LoggerFactory.getLogger(MemberRestController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	private AttractionService attractionService;
	
	@Autowired
    public AttractionRestController(AttractionService attractionService) {
        super();
        this.attractionService = attractionService;
    }
	
	@RequestMapping(value ="/tripsearch", method = RequestMethod.GET)
	public String tripSearch() {
		
		return "attraction/tripsearch";
	}
	
	@PostMapping(value ="/search")
	public List<AttractionDetailDto> search(@RequestBody AttractionSearchDto dto) throws SQLException {
		System.out.println(dto.getSido_code());
		System.out.println(dto.getContent_type_id());
		System.out.println(dto.getSearch_keyword());
		int sido_code = Integer.parseInt(dto.getSido_code());
		int content_type_id = Integer.parseInt(dto.getContent_type_id());
		String title = dto.getSearch_keyword();
		System.out.println(sido_code+" " + content_type_id +" "+ title);

		List<AttractionDetailDto> attractionList = attractionService.attractionList(sido_code, content_type_id, title);

		QuickSort quickSort = new QuickSort();
		quickSort.pivotNaturalSort(attractionList, 0, attractionList.size() - 1);
		
		for(int i = 0; i < attractionList.size(); i++) {
			System.out.println(attractionList.get(i).getTitle());
		}
		
		return attractionList;
	}
	
	@PostMapping(value="/hotplace/search")
	public List<AttractionDetailDto> hotplace(@RequestBody AttractionSearchDto dto) throws SQLException {
		List<AttractionDetailDto> attractionList = attractionService.attractionList(Integer.parseInt(dto.getSido_code()), Integer.parseInt(dto.getContent_type_id()), dto.getSearch_keyword());
//		List<AttractionDto> attractionList = attractionService.hotAttractionList();
		
		return attractionList;
	}
	
	@PostMapping(value="/hotplace")
	public List<AttractionDto> hotplace() throws SQLException {
		
//		List<AttractionDto> attractionList = attractionService.hotAttractionList(Integer.parseInt(dto.getSido_code()), Integer.parseInt(dto.getContent_type_id()));
		List<AttractionDto> attractionList = attractionService.hotAttractionList();
		
		return attractionList;
	}
	
	
    
	
//	@RequestMapping(value ="/search", method = RequestMethod.POST)
//	public String search(@RequestParam String ssido_code, @RequestParam String scontent_type_id, 
//			@RequestParam String title,Model model, HttpSession session) throws SQLException {
//		int sido_code = Integer.parseInt(ssido_code);
//		int content_type_id = Integer.parseInt(scontent_type_id);
//		System.out.println(sido_code+" " + content_type_id +" "+ title);
//		
//		List<AttractionDto> attractionList = attractionService.attractionList(sido_code, content_type_id, title);
//
//		QuickSort quickSort = new QuickSort();
//		quickSort.pivotNaturalSort(attractionList, 0, attractionList.size() - 1);
//		
//		for(int i = 0; i < attractionList.size(); i++) {
//			System.out.println(attractionList.get(i).getTitle());
//		}
//		
//		model.addAttribute("list", attractionList);
//		
//		
//		return "attraction/tripsearch";
//	}
	
	@RequestMapping(value ="/searchPlan", method = RequestMethod.POST)
	@ResponseBody
	public List<AttractionDetailDto> searchPlan(@RequestParam String ssido_code, @RequestParam String scontent_type_id, 
			@RequestParam String title) throws SQLException {
		System.out.println(ssido_code+" " + scontent_type_id +" "+ title);
		System.out.println("들어옴");
		
		Map<String, Object> resultMap = new HashMap<>();
		System.out.println(resultMap);
		int sido_code = Integer.parseInt(ssido_code);
		int content_type_id = Integer.parseInt(scontent_type_id);
		System.out.println(sido_code+" " + content_type_id +" "+ title);
		
		List<AttractionDetailDto> attractionList = attractionService.attractionList(sido_code, content_type_id, title);

		QuickSort quickSort = new QuickSort();
		quickSort.pivotNaturalSort(attractionList, 0, attractionList.size() - 1);
		
		for(int i = 0; i < attractionList.size(); i++) {
			System.out.println(attractionList.get(i).getTitle());
		}
//		
//		model.addAttribute("list", attractionList);
		
		return attractionList;
	}
	
//	@RequestMapping(value ="/searchPlan", method = RequestMethod.POST)
//	public String searchPlan(@RequestParam String ssido_code, @RequestParam String scontent_type_id, 
//			@RequestParam String title,Model model, HttpSession session) throws SQLException {
//		int sido_code = Integer.parseInt(ssido_code);
//		int content_type_id = Integer.parseInt(scontent_type_id);
//		System.out.println(sido_code+" " + content_type_id +" "+ title);
//		
//		List<AttractionDto> attractionList = attractionService.attractionList(sido_code, content_type_id, title);
//
//		QuickSort quickSort = new QuickSort();
//		quickSort.pivotNaturalSort(attractionList, 0, attractionList.size() - 1);
//		
//		for(int i = 0; i < attractionList.size(); i++) {
//			System.out.println(attractionList.get(i).getTitle());
//		}
//		
//		model.addAttribute("list", attractionList);
//		
//		return "attraction/tripplan";
//	}
    
	@RequestMapping(value = "/tripplan",method = RequestMethod.GET)
    public String tripPlan() {
		return "attraction/tripplan";
	}
	
	
	@GetMapping("myplan/maxindex")
	public int maxindex() throws SQLException {
		int count = attractionService.maxIndex();
		return count;
	}
	

	@PostMapping("/myplan/write")
	public ResponseEntity<String> planwrite(@RequestBody AttractionPlanDto planDto) {
		logger.debug("myplan write planDto : {}", planDto);
		
		try {
			if(attractionService.writePlan(planDto)) {
				return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
			};
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.OK);
	}
	
    
}
