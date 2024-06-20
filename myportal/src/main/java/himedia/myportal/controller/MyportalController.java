package himedia.myportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyportalController {

	@RequestMapping("/")
	public String myportal() {
		
		return "/WEB-INF/views/home.jsp";
	}
	
}
