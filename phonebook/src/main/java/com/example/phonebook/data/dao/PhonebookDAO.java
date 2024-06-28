package com.example.phonebook.data.dao;

import java.util.List;

import com.example.phonebook.data.vo.PhonebookVO;

public interface PhonebookDAO {
	public List<PhonebookVO> selectAll();
	public List<PhonebookVO> selectListByKeyword(String keyword);
	public PhonebookVO selectOne(Integer id);
	public int insert(PhonebookVO phonebookVO);
	public int delete(PhonebookVO phonebookVO);
}
