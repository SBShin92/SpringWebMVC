package himedia.myportal.dao;

import java.util.List;

import himedia.myportal.vo.BoardVO;

public interface BoardDAO {
	public List<BoardVO> selectAll();
	public BoardVO getContent(Integer no);
	public int insert(BoardVO boardVO);
	public int update(BoardVO boardVO);
	public int increaseHitCount(Integer no);
	
	public int delete(Integer no, Integer userNo);
}