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
	public String raiseExcept() throws MainControllerException {
		throw new MainControllerException();
	}
}
