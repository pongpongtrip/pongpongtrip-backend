package com.enjoytrip.ws.maincontroller;

import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Locale locale, Model model) {
		logger.info("Welcome index! The client locale is {}.", locale);
		
		return "index";
	}
	
//	@RequestMapping(value ="/tripsearch", method = RequestMethod.GET)
//	public String tripSearch() {
//		
//		
//		return "tripsearch";
//	}
//    
//	@RequestMapping(value = "/tripplan",method = RequestMethod.GET)
//    public String tripPlan() {
//		
//		
//		return "tripplan";
//	}
	
}