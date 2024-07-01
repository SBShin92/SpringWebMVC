package himedia.myportal.dao;

import java.util.List;

import himedia.myportal.vo.BoardFilesBridgeVO;

public interface BoardFilesBridgeDAO {
	public List<BoardFilesBridgeVO> selectList();
	public BoardFilesBridgeVO selectOneByBoardNo(Integer boardNo);
	public BoardFilesBridgeVO selectOneByFileNo(Integer fileNo);
	
	public Integer insert(BoardFilesBridgeVO vo);
	public Integer delete(BoardFilesBridgeVO vo);
}
