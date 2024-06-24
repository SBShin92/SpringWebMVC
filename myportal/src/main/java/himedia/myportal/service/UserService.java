package himedia.myportal.service;

import himedia.myportal.vo.UserVO;

public interface UserService {
	public int signUp(UserVO vo);
	public UserVO getUser(String email);
	public UserVO getUser(String email, String password);
	
}
