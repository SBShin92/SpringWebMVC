package himedia.myportal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.myportal.dao.UserDAO;
import himedia.myportal.service.UserService;
import himedia.myportal.vo.UserVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service("userService")
public class UserServiceImpl implements UserService {

	private final UserDAO userDAO;
	
	@Autowired
	public UserServiceImpl(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public boolean signUp(UserVO vo) {
		return 1 == userDAO.insert(vo);
	}

	@Override
	public UserVO getUser(String email) {
		UserVO userVO = userDAO.selectUser(email);
		return userVO;
	}

	@Override
	public UserVO getUser(String email, String password) {		
		UserVO userVO = userDAO.selectUser(email, password);
		
		return userVO;
	}

	@Override
	public boolean isAuthenticated(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			UserVO authUser = (UserVO)session.getAttribute("authUser");
			return authUser != null;
		}
		return false;
	}
}
