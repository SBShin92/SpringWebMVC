package himedia.myportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import himedia.myportal.exception.MainControllerException;

@Controller
public class MyportalController {

	@RequestMapping("/")
	public String myportal() {
		
		return "home";
	}
	
	@GetMapping("/except")
	public String raiseExcept() {
		throw new MainControllerException();
	}
	
	@ExceptionHandler(MainControllerException.class)
	public String exceptionHandler(MainControllerException e, Model model) {
		
		model.addAttribute("name", e.getClass().getSimpleName());
		model.addAttribute("message", e.getMessage());
		
		return "errors/exception";
	}
}
