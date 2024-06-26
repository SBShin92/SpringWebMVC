package himedia.myportal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.myportal.dao.BoardDAO;
import himedia.myportal.service.BoardService;
import himedia.myportal.vo.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	private BoardDAO boardDAO;
	
	@Autowired
	public BoardServiceImpl(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}
		
	@Override
	public List<BoardVO> getList() {
		return boardDAO.selectAll();
	}


	@Override
	public BoardVO getContent(Integer no) {
		boardDAO.increaseHitCount(no);
		return boardDAO.getContent(no);
	}

	@Override
	public boolean write(BoardVO boardVO) {
		return 1 == boardDAO.insert(boardVO);
	}

	@Override
	public boolean update(BoardVO boardVO) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
