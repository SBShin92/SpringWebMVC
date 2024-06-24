package himedia.myportal.dao;

import himedia.myportal.vo.UserVO;

public interface UserDAO {
	public int insert(UserVO vo);
	public UserVO selectUser(String email);
	public UserVO selectUser(String email, String password);
	
	
}
