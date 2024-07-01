package himedia.myportal.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.myportal.dao.BoardFilesBridgeDAO;
import himedia.myportal.vo.BoardFilesBridgeVO;

@Repository
public class BoardFilesBridgeDAOImpl implements BoardFilesBridgeDAO{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<BoardFilesBridgeVO> selectList() {
		return sqlSession.selectList("boardFilesBridge.selectAll");
	}

	@Override
	public BoardFilesBridgeVO selectOneByBoardNo(Integer boardNo) {
		return sqlSession.selectOne("boardFilesBridge.selectOneByBoardNo", boardNo);
	}

	@Override
	public BoardFilesBridgeVO selectOneByFileNo(Integer fileNo) {
		return sqlSession.selectOne("boardFilesBridge.selectOneByFileNo", fileNo);
	}

	@Override
	public Integer insert(BoardFilesBridgeVO vo) {
		return sqlSession.selectOne("boardFilesBridge.insert", vo);
	}

	@Override
	public Integer delete(BoardFilesBridgeVO vo) {
		return sqlSession.selectOne("boardFilesBridge.delete", vo);
	}
	
	
	
}
