package himedia.myportal.exception;

import himedia.myportal.vo.GuestbookVO;

public class GuestbookDAOException extends RuntimeException {
	private GuestbookVO vo = null;
	
	
	public GuestbookDAOException() {
		super("SQL Exception caused by Guestbook accession");
	}

	public GuestbookDAOException(String message) {
		super(message);
	}

	public GuestbookDAOException(String message, GuestbookVO vo) {
		super(message);
		this.vo = vo;
	}

	public GuestbookVO getVo() {
		return vo;
	}

	
}
