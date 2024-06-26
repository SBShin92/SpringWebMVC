package himedia.myportal.service;

import java.util.List;

import himedia.myportal.vo.BoardVO;

public interface BoardService {
	public List<BoardVO> getList();
	public BoardVO getContent(Integer no);
	public boolean write(BoardVO boardVO);
	public boolean update(BoardVO boardVO);
	
	public void increasementHitCount(Integer no);

	public boolean delete(Integer no, Integer userNo);
}

