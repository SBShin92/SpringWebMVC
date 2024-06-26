package himedia.myportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import himedia.myportal.service.BoardService;
import himedia.myportal.vo.BoardVO;
import himedia.myportal.vo.UserVO;
import jakarta.servlet.http.HttpSession;

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
	public String view(@PathVariable("no") Integer no, 
			Model model,
			HttpSession session) {
		
		if (session.getAttribute("authUser") == null)
			return "redirect:/";
		
		model.addAttribute("selectedBoard", boardService.getContent(no));
		return "board/view";
	}
	
	@GetMapping("/modify/{no}")
	public String modify(@PathVariable("no") Integer no, Model model) {
		
		// TODO
		
		return "board/modify";
	}
	
	@GetMapping("/write")
	public String write(Model model, HttpSession session) {
		if (session.getAttribute("authUser") == null)
			return "redirect:/";
		return "board/write";
	}	
	
	@PostMapping("/write")
	public String write(@ModelAttribute BoardVO boardVO, HttpSession session) {
		UserVO authUser = (UserVO)session.getAttribute("authUser");
		if (authUser == null)
			return "redirect:/";
		
		boardVO.setUserNo(authUser.getNo().intValue());
		
		boardService.write(boardVO);
		return "redirect:/board/list";
	}

}
