package com.example.phonebook.data.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.phonebook.data.dao.PhonebookDAO;
import com.example.phonebook.data.vo.PhonebookVO;


@Repository
public class PhonebookDAOImpl implements PhonebookDAO {

	private SqlSession sqlSession;
	
	@Autowired
	public PhonebookDAOImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	
	@Override
	public List<PhonebookVO> selectAll() {
		
		return sqlSession.selectList("phonebook.selectAll");
	}

	@Override
	public List<PhonebookVO> selectListByKeyword(String keyword) {
		return sqlSession.selectList("phonebook.selectListByKeyword", keyword);
	}

	@Override
	public PhonebookVO selectOne(Integer id) {
		return sqlSession.selectOne("phonebook.selectOne", id);
	}

	@Override
	public int insert(PhonebookVO phonebookVO) {
		return sqlSession.insert("phonebook.insert", phonebookVO);
	}

	@Override
	public int delete(PhonebookVO phonebookVO) {
		return sqlSession.delete("phonebook.delete", phonebookVO);
	}


	
}
