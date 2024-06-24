package himedia.myportal.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.myportal.exception.GuestbookDAOException;
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
		int insertedCount = 0;
		try {
			insertedCount = sqlSession.insert("guestbook.insert", vo);			
//		} catch (PersistenceException e) {
		} catch (Exception e) {
			System.err.println("INSERT 실패!!!!");
			throw new GuestbookDAOException("Guestbook INSERT Error: ", vo);
		}
		return insertedCount;
	}

	@Override
	public int delete(GuestbookVO vo) {
		int deletedCount = 0;
		try {
			deletedCount = sqlSession.delete("guestbook.delete", vo);
		} catch (Exception e) {
			throw new GuestbookDAOException("Guestbook DELETE ERROR: ", vo);
		}
		return deletedCount;
	}

	@Override
	public int update(GuestbookVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
}
