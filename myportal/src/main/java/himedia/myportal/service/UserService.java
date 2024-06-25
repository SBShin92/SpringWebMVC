package himedia.myportal.service;

import himedia.myportal.exception.UserDAOException;
import himedia.myportal.vo.UserVO;

public interface UserService {
	public boolean signUp(UserVO vo)  throws UserDAOException;
	public UserVO getUser(String email);
	public UserVO getUser(String email, String password);
	
}
