package com.enjoytrip.ws.attraction.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.enjoytrip.sort.QuickSort;
import com.enjoytrip.ws.attraction.model.AttractionDto;
import com.enjoytrip.ws.attraction.model.service.AttractionService;
import com.enjoytrip.ws.member.controller.MemberController;


@Controller
@RequestMapping("/attraction")
public class AttractionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	private AttractionService attractionService;
	
	@Autowired
    public AttractionController(AttractionService attractionService) {
        super();
        this.attractionService = attractionService;
    }
    
	@RequestMapping(value ="/tripsearch", method = RequestMethod.GET)
	public String tripSearch() {
		
		return "attraction/tripsearch";
	}
	
	@RequestMapping(value ="/search", method = RequestMethod.POST)
	public String search(@RequestParam String ssido_code, @RequestParam String scontent_type_id, 
			@RequestParam String title,Model model, HttpSession session) throws SQLException {
		int sido_code = Integer.parseInt(ssido_code);
		int content_type_id = Integer.parseInt(scontent_type_id);
		System.out.println(sido_code+" " + content_type_id +" "+ title);
		
		List<AttractionDto> attractionList = attractionService.attractionList(sido_code, content_type_id, title);

		QuickSort quickSort = new QuickSort();
		quickSort.pivotNaturalSort(attractionList, 0, attractionList.size() - 1);
		
		for(int i = 0; i < attractionList.size(); i++) {
			System.out.println(attractionList.get(i).getTitle());
		}
		
		model.addAttribute("list", attractionList);
		
		
		return "attraction/tripsearch";
	}
	
	@RequestMapping(value ="/searchPlan", method = RequestMethod.POST)
	@ResponseBody
	public List<AttractionDto> searchPlan(@RequestParam String ssido_code, @RequestParam String scontent_type_id, 
			@RequestParam String title) throws SQLException {
		System.out.println(ssido_code+" " + scontent_type_id +" "+ title);
		System.out.println("들어옴");
		
		Map<String, Object> resultMap = new HashMap<>();
		System.out.println(resultMap);
		int sido_code = Integer.parseInt(ssido_code);
		int content_type_id = Integer.parseInt(scontent_type_id);
		System.out.println(sido_code+" " + content_type_id +" "+ title);
		
		List<AttractionDto> attractionList = attractionService.attractionList(sido_code, content_type_id, title);

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
    
}
