package himedia.myportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import himedia.myportal.service.GuestbookService;
import himedia.myportal.vo.GuestbookVO;

@Controller
@RequestMapping("/guestbook")
public class GuestbookController {

	@Autowired
	private GuestbookService guestbookService;
	
	@RequestMapping({"", "/", "/list"})
	public String list(Model model) {
		List<GuestbookVO> lst = guestbookService.getMessageList();
		
		model.addAttribute("guestbookList", lst);
		
		return "guestbook/list";
	}
}
