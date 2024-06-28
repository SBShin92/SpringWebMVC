package com.example.phonebook.service;

import java.util.List;

import com.example.phonebook.data.vo.PhonebookVO;

public interface PhonebookService {

	public List<PhonebookVO> getList();
	public List<PhonebookVO> searchListByNameKeyword(String keyword);
	public PhonebookVO getOne(Integer id);
	public boolean addNewPhonebookRow(PhonebookVO phonebookVO);
	public boolean deletePhonebookRow(PhonebookVO phonebookVO);
	
}
