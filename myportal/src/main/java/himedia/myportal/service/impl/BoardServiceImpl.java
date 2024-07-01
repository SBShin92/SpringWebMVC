package himedia.myportal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.myportal.dao.BoardDAO;
import himedia.myportal.dao.BoardFilesBridgeDAO;
import himedia.myportal.dao.FilesDAO;
import himedia.myportal.service.BoardService;
import himedia.myportal.vo.BoardFilesBridgeVO;
import himedia.myportal.vo.BoardVO;
import himedia.myportal.vo.FileVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO boardDAO;
	@Autowired
	private BoardFilesBridgeDAO boardFilesBridgeDAO;
	@Autowired
	private FilesDAO filesDAO;
	
	@Override
	public List<BoardVO> getList() {
		return boardDAO.selectAll();
	}


	@Override
	public BoardVO getContent(Integer no) {
		return boardDAO.getContent(no);
	}

	@Override
	public boolean write(BoardVO boardVO) {
		return 1 == boardDAO.insert(boardVO);
	}

	@Override
	public boolean update(BoardVO boardVO) {
		return 1 == boardDAO.update(boardVO);
	}

	@Override
	public boolean delete(Integer no, Integer userNo) {
		return 1 == boardDAO.delete(no, userNo);
	}

	@Override
	public void increasementHitCount(Integer no) {
		boardDAO.increaseHitCount(no);		
	}

	@Override
	public FileVO getFileRelatedByBoard(Integer boardNo) {
		BoardFilesBridgeVO getBFBVO = boardFilesBridgeDAO.selectOneByBoardNo(boardNo);
		if (getBFBVO != null)
			return filesDAO.selectOne(getBFBVO.getFileNo());
		else
			return null;
	}

	
	
	
}
