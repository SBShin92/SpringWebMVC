package himedia.myportal.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.myportal.dao.FilesDAO;
import himedia.myportal.vo.BoardFilesBridgeVO;
import himedia.myportal.vo.BoardVO;
import himedia.myportal.vo.FileVO;

@Repository
public class FilesDAOImpl implements FilesDAO{
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<FilesDAO> selectList() {
		return sqlSession.selectList("files.selectAll");
	}	

	@Override
	public FileVO selectOne(Integer no) {
		return sqlSession.selectOne("files.selectOne", no);
	}

	@Override
	public FileVO selectOneByName(String name) {
		return sqlSession.selectOne("files.selectOneByName", name);
	}

	@Override
	public Integer insert(FileVO fileVO) {
		return sqlSession.insert("files.insert", fileVO);
	}

	@Override
	public Integer delete(FileVO fileVO) {
		return sqlSession.delete("files.delete", fileVO);
	}
	
	
	
	
}
