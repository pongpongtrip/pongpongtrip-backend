package com.enjoytrip.ws.attraction.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
//		String ssido_code=request.getParameter("sido_code");
		int sido_code = Integer.parseInt(ssido_code);
//		String scontent_type_id=request.getParameter("content_type_id");
		int content_type_id = Integer.parseInt(scontent_type_id);
//		String title=request.getParameter("title");
		System.out.println(sido_code+" " + content_type_id +" "+ title);
		
		List<AttractionDto> attractionList = attractionService.attractionList(sido_code, content_type_id, title);

		QuickSort quickSort = new QuickSort();
		quickSort.pivotNaturalSort(attractionList, 0, attractionList.size() - 1);
		
		for(int i = 0; i < attractionList.size(); i++) {
			System.out.println(attractionList.get(i).getTitle());
		}
		
		// request.setAttribute("list", attractionList);
		model.addAttribute("list", attractionList);
		

//		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/attraction/tripsearch.jsp");
//		requestDispatcher.forward(request, response);
		
		return "attraction/tripsearch";
	}
    
	@RequestMapping(value = "/tripplan",method = RequestMethod.GET)
    public String tripPlan() {
		
		
		return "attraction/tripplan";
	}
    
	
//	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		try {
//			doProcess(request, response);
//		} catch (ServletException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	
//	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		try {
//			doProcess(request, response);
//		} catch (ServletException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
//		request.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html; charset=UTF-8");
//		
//		String action = request.getParameter("action");
//		String root = request.getContextPath();
//		
//		if(action.equalsIgnoreCase("tripsearch")) {
//			String ssido_code=request.getParameter("sido_code");
//			int sido_code = Integer.parseInt(ssido_code);
//			String scontent_type_id=request.getParameter("content_type_id");
//			int content_type_id = Integer.parseInt(scontent_type_id);
//			String title=request.getParameter("title");
//			System.out.println(sido_code+" " + content_type_id +" "+ title);
//			
//			List<AttractionDto> attractionList = attractionService.attractionList(sido_code, content_type_id, title);
//
//			QuickSort quickSort = new QuickSort();
//			quickSort.pivotNaturalSort(attractionList, 0, attractionList.size() - 1);
//			
//			for(int i = 0; i < attractionList.size(); i++) {
//				System.out.println(attractionList.get(i).getTitle());
//			}
//			
//			request.setAttribute("list", attractionList);
//			
//
//			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/attraction/tripsearch.jsp");
//			requestDispatcher.forward(request, response);
//					
//		} else if(action.equalsIgnoreCase("tripplan")) {
//			String ssido_code=request.getParameter("sido_code");
//			int sido_code = Integer.parseInt(ssido_code);
//			String scontent_type_id=request.getParameter("content_type_id");
//			int content_type_id = Integer.parseInt(scontent_type_id);
//			String title=request.getParameter("title");
//			System.out.println(sido_code+" " + content_type_id +" "+ title);
//			
//			request.setAttribute("list", attractionService.attractionList(sido_code, content_type_id, title));
//			
//			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/tripplan.jsp");
//			requestDispatcher.forward(request, response);
//					
//		} 
//
//		
//		
//	}

}
