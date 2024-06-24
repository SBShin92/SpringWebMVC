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
	public boolean writeMessage(GuestbookVO vo) {
		
		int insertedCount = guestbookDAO.insert(vo);
		
		return insertedCount == 1;
	}

	@Override
	public boolean deleteMessage(GuestbookVO vo) {
		return guestbookDAO.delete(vo) == 1;
	}

	@Override
	public boolean updateMessage(GuestbookVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
