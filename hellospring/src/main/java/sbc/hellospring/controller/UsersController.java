package sbc.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sbc.hellospring.vo.UserVO;

@Controller
@RequestMapping("/users")
public class UsersController {
	
	@GetMapping({"", "/", "/join"})
	public String joinform(Model model) {

		
		
		return "/WEB-INF/views/users/joinform.jsp";
	}
	
	@PostMapping("/join")
	public String joinAction(@ModelAttribute UserVO vo, @RequestParam("a") String a) {
		System.out.println("data: " + vo);
		
		
		System.out.println("a: " + a);  
		
		return "redirect:/users/joinsuccess";
	}
	
	@GetMapping("/joinsuccess")
	public String joinsuccess() {
		return "/WEB-INF/views/users/joinsuccess.jsp";
	}
	
}
