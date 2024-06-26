package himedia.myportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import himedia.myportal.service.BoardService;

@RequestMapping("/board")
@Controller
public class BoardController {
	
	private BoardService boardService;
	
	@Autowired
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	
	@GetMapping({"", "/", "/list"})
	public String list(Model model) {
		
		model.addAttribute("boardList", boardService.getList());
		
		return "board/list";
	}
	
	@GetMapping("/view/{no}")
	public String view(@PathVariable("no") Integer no, Model model) {
		
		model.addAttribute("selectedBoard", boardService.getContent(no));
		return "board/view";
	}
	
	
	

}
