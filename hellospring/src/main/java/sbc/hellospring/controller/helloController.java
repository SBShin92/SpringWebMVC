package sbc.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import sbc.hellospring.vo.UserVO;


@Controller
public class helloController {
//	@RequestMapping("/hello")
//	public ModelAndView hello(@RequestParam("name") String name) {
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("message", "Hello~ " + name + "!!");
//		mav.setViewName("/WEB-INF/views/hello.jsp");
//
//		return mav;
//	}
	
	// hello 요청 시 'hello null'이 출력된다.
	// defaultValue로 기본값을 지정할 수 있다.
	@RequestMapping("/hello")
	public ModelAndView hello(@RequestParam(value = "name", required = false) String name) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", "Hello~ " + name + "!!");
		mav.setViewName("/WEB-INF/views/hello.jsp");

		return mav;
	}
	
	@ResponseBody
	@RequestMapping("/hello2")
	public String hello2(@ModelAttribute UserVO userVO) {
		System.out.println("no: " + userVO.getNo());
		System.out.println("name: " + userVO.getName());
		System.out.println("password: " + userVO.getPassword());
				
		return ("<p>" + userVO + "</p>");
	}
	
}
