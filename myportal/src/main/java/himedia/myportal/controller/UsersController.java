package himedia.myportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import himedia.myportal.exception.UserDAOException;
import himedia.myportal.service.UserService;
import himedia.myportal.vo.UserVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/users")
public class UsersController {
	
	private final UserService userService;
	
	@Autowired
	public UsersController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/join")
	public String join() {
		return "users/joinform";
	}
	
	@PostMapping("/join")
	public String join(@ModelAttribute UserVO userVO, RedirectAttributes redirectAttributes) {
		try {
			if ("".equals(userVO.getName()) || "".equals(userVO.getEmail()))
				throw new UserDAOException();
			userService.signUp(userVO);
			return "redirect:/users/joinsuccess";
		} catch (UserDAOException e){
			redirectAttributes.addFlashAttribute("errorMsg", "양식이 올바르지 않거나 이미 존재합니다.");
			return "redirect:/users/join";
		}
	}

	@GetMapping("/joinsuccess")
	public String joinsuccess() {
		return "users/joinsuccess";
	}
	
	@GetMapping({"", "/", "/login"})
	public String loginform() {	
		return "users/loginform";
	}
	
	@PostMapping("/login")
	public String loginform(@RequestParam(name = "email", required = false, defaultValue = "") String email, 
			@RequestParam(name = "password", required = false, defaultValue = "") String password, 
			HttpServletRequest request,
			RedirectAttributes redirectAttributes){
		
		UserVO authUser = userService.getUser(email, password);
		if (authUser != null) {
			HttpSession session = request.getSession();
			session.setAttribute("authUser", authUser);
			return "redirect:/";
		} else {
			redirectAttributes.addFlashAttribute("errorMsg", "로그인에 실패했습니다.");
			return "redirect:/users/login";
		}
	}
	
	@GetMapping("/logout")
	public String logoutform(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		
		return "redirect:/";
	}
	
	
}
