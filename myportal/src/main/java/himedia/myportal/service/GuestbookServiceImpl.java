package himedia.myportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.myportal.dao.GuestbookDAO;
import himedia.myportal.vo.GuestbookVO;

@Service("guestbookService")
public class GuestbookServiceImpl implements GuestbookService {
	@Autowired
	private GuestbookDAO guestbookDAO;
	
	@Override
	public List<GuestbookVO> getMessageList() {
		List<GuestbookVO> lst = guestbookDAO.selectAll();
		return lst;
	}

	@Override
	public boolean writeNessage(GuestbookVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteNessage(GuestbookVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateMessage(GuestbookVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
