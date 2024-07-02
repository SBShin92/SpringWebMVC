package himedia.myportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import himedia.myportal.exception.GuestbookDAOException;
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
	
	@PostMapping("/write")
	public String writeList(@ModelAttribute GuestbookVO vo) {
		
		System.out.println("html form: " + vo);
		
		boolean success = guestbookService.writeMessage(vo);
		System.out.println("write result: " + success);
		
		return "redirect:/guestbook";
	}
	
	@GetMapping("/delete/{no}")
	public String deleteList(@PathVariable("no") Long no, Model model) {
		model.addAttribute("no", no);
		return "guestbook/deleteform";
	}
	
	@PostMapping("/delete")
	public String delete(@ModelAttribute GuestbookVO vo) {
		
		System.out.println("html form: " + vo);
		
		boolean success = guestbookService.deleteMessage(vo);
		
		System.out.println("delete result: " + success);
		
		return "redirect:/guestbook";
	}
	
}
