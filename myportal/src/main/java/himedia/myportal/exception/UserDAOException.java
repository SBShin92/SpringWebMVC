package himedia.myportal.exception;

import himedia.myportal.vo.UserVO;

public class UserDAOException extends RuntimeException {
	private UserVO userVO = null;
	
	public UserDAOException() {
		super("UserDAOException Occurs!!: ");
	}
	
	public UserDAOException(String message) {
		super(message);
	}

	public UserDAOException(String message, UserVO userVO) {
		super(message);
		this.userVO = userVO;
	}

	public UserVO getUserVO() {
		return userVO;
	}

	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}
	
}
