package com.spring.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller  //http://localhost:8080 요청 응답 컨트롤러
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * 
	 	
	 	RequestMapping-value : 해당 컨트럴로가 어떤 요청을 처리할 것인지 작성
	 	
	 	@RequestMapping(value = "/", method = RequestMethod.GET)
	 	- http://localhost:8080/ + get 으로 들어오면 실행됨
	 */
	//@RequestMapping(value = "/", method = RequestMethod.GET)
	@GetMapping("/")
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "index"; // ==> ViewResolver : /WEB-INF/views/home.jsp
	}
	//@RequestMapping(value="/doA",method=RequestMethod.GET)
	@GetMapping("/doA")
	public String doA() {
		logger.info("doA...");
		//result.jsp 보여주고 싶다면
		return "result";
	}
	
	
}
