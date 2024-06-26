package himedia.myportal.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.myportal.dao.BoardDAO;
import himedia.myportal.vo.BoardVO;

@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO {

	private SqlSession sqlSession;
	
	@Autowired
	public BoardDAOImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<BoardVO> selectAll() {
		return sqlSession.selectList("board.selectAll");
	}

	@Override
	public BoardVO getContent(Integer no) {
		return sqlSession.selectOne("board.getContent", no);
	}

	@Override
	public int insert(BoardVO boardVO) {
		return sqlSession.insert("board.insert", boardVO);
	}

	@Override
	public int update(BoardVO boardVO) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int increaseHitCount(Integer no) {
		return sqlSession.update("increaseHitCount", no);
	}
	
	
}
