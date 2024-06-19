package sbc.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class helloController {
	@RequestMapping("/hello")
	public ModelAndView hello(@RequestParam("name") String name) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", "Hello~ " + name + "!!");
		mav.setViewName("/WEB-INF/views/hello.jsp");

		return mav;
	}
}
