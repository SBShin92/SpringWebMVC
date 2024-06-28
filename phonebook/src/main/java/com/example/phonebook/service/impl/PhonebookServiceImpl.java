package com.example.phonebook.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.phonebook.data.dao.PhonebookDAO;
import com.example.phonebook.data.vo.PhonebookVO;
import com.example.phonebook.service.PhonebookService;

@Service
public class PhonebookServiceImpl implements PhonebookService{

	private PhonebookDAO phonebookDAO;
	
	@Autowired
	public PhonebookServiceImpl(PhonebookDAO phonebookDAO) {
		this.phonebookDAO = phonebookDAO;
	}
	
	
	@Override
	public List<PhonebookVO> getList() {
		return phonebookDAO.selectAll();
	}

	@Override
	public List<PhonebookVO> searchListByNameKeyword(String keyword) {
		return phonebookDAO.selectListByKeyword(keyword);
	}

	@Override
	public PhonebookVO getOne(Integer id) {
		return phonebookDAO.selectOne(id);
	}

	@Override
	public boolean addNewPhonebookRow(PhonebookVO phonebookVO) {
		return 1 == phonebookDAO.insert(phonebookVO);
	}

	@Override
	public boolean deletePhonebookRow(PhonebookVO phonebookVO) {
		return 1 == phonebookDAO.delete(phonebookVO);
	}
	
}
