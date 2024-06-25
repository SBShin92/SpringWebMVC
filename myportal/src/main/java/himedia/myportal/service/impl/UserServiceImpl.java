package himedia.myportal.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.myportal.dao.UserDAO;
import himedia.myportal.service.UserService;
import himedia.myportal.vo.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {

	private final UserDAO userDAO;
	
	@Autowired
	public UserServiceImpl(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public boolean signUp(UserVO vo) {
		int insertedCount = 0;
		insertedCount = userDAO.insert(vo);
		return 1 == insertedCount;
	}

	@Override
	public UserVO getUser(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVO getUser(String email, String password) {		
		UserVO userVO = userDAO.selectUser(email, password);
		
		return userVO;
	}
}
