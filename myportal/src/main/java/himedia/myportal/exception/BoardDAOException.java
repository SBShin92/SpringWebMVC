package himedia.myportal.exception;

import himedia.myportal.vo.BoardVO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDAOException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private BoardVO boardVO = null;

	public BoardDAOException() {
		super("This is BoardDAOException!!");
	}

	public BoardDAOException(String message) {
		super(message);
	}
	public BoardDAOException(String message, BoardVO boardVO) {
		super(message);
		this.boardVO = boardVO;
	}
	
}
