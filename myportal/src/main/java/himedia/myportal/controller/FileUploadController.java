package himedia.myportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/fileupload")
@Controller
public class FileUploadController {
	
	@GetMapping({"", "/", "/form"})
	public String formForwarding() {
		
		
		return "fileupload/form";
	}
	
}
