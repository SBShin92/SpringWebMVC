package com.example.phonebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.phonebook.data.vo.PhonebookVO;
import com.example.phonebook.service.PhonebookService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@RequestMapping("/")
@Controller
public class MainController {
	private PhonebookService phonebookService;
	
	@Autowired
	public MainController(PhonebookService phonebookService) {
		this.phonebookService = phonebookService;
	}
	
	
	@GetMapping("")
	public String phonebookView(@RequestParam(name = "keyword", required = false, defaultValue = "") String keyword, Model model) {
		if ("".equals(keyword))
			model.addAttribute("phonebookLst", phonebookService.getList());
		else
			model.addAttribute("phonebookLst", phonebookService.searchListByNameKeyword(keyword));
		
		return "list";
	}
	
	@GetMapping("/add")
	public String phonebookAddView() {
		return "addform";
	}
	
	@PostMapping("/add")
	public String phonebookAddAction(@ModelAttribute PhonebookVO phonebookVO, RedirectAttributes redirectAttributes) {
		if (phonebookVO.getName().isBlank() || phonebookVO.getHp().isBlank() || phonebookVO.getTel().isBlank()) {
			redirectAttributes.addFlashAttribute("errorMsg", "빈칸을 두지 마세요");
			return "redirect:/add";
		} else if (phonebookVO.getName().length() > 10 || phonebookVO.getHp().length() > 20 || phonebookVO.getTel().length() > 20) {
			redirectAttributes.addFlashAttribute("errorMsg", "너무길어요 [이름 10자, hp 10자, tel 10자");
			return "redirect:/add";
		}
		phonebookService.addNewPhonebookRow(phonebookVO);	
		return "redirect:/";
	}

	
	@PostMapping("/delete/{id}")
	public String deleteButton(@PathVariable("id") Integer id) {
		
		PhonebookVO vo = phonebookService.getOne(id);
		if (vo != null)
			phonebookService.deletePhonebookRow(vo);
		
		return "redirect:/";
	}
	

}
