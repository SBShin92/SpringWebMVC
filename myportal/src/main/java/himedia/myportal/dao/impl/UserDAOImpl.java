package himedia.myportal.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.myportal.dao.UserDAO;
import himedia.myportal.exception.UserDAOException;
import himedia.myportal.vo.UserVO;


@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	private final SqlSession sqlSession;
	
	@Autowired
	public UserDAOImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public int insert(UserVO vo) throws UserDAOException {
		try {
			return sqlSession.insert("users.insert", vo);
		} catch (Exception e) {
			throw new UserDAOException("Users INSERT Error: ", vo);
		}
	}

	@Override
	public UserVO selectUser(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVO selectUser(String email, String password) {
		Map<String, String> userMap = new HashMap<String, String>();
		userMap.put("email", email);
		userMap.put("password", password);
		
		UserVO userVO = sqlSession.selectOne("users.selectUserByEmailAndPassword", userMap);
		return userVO;
	}
}
