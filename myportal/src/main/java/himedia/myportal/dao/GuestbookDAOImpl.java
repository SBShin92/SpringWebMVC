package himedia.myportal.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.myportal.vo.GuestbookVO;

@Repository(value = "guestbookDAO")
public class GuestbookDAOImpl implements GuestbookDAO{

	@Autowired
	private SqlSession sqlSession;
	
	
	@Override
	public List<GuestbookVO> selectAll() {
		List<GuestbookVO> lst = sqlSession.selectList("guestbook.selectAll");
		return lst;
	}

	@Override
	public GuestbookVO select(Long no) {
		GuestbookVO vo = sqlSession.selectOne("guestbook.select", no);
		return vo;
	}

	@Override
	public int insert(GuestbookVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(GuestbookVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(GuestbookVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
}
