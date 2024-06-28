package himedia.myportal.service;

import java.net.http.HttpRequest;

import himedia.myportal.exception.UserDAOException;
import himedia.myportal.vo.UserVO;
import jakarta.servlet.http.HttpServletRequest;

public interface UserService {
	public boolean signUp(UserVO vo)  throws UserDAOException;
	public UserVO getUser(String email);
	public UserVO getUser(String email, String password);
	
	public boolean isAuthenticated(HttpServletRequest request);
	
}
