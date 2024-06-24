package himedia.myportal.service;

import java.util.List;

import himedia.myportal.vo.GuestbookVO;

public interface GuestbookService {
	public List<GuestbookVO> getMessageList();

	public boolean writeMessage(GuestbookVO vo);
	public boolean deleteMessage(GuestbookVO vo);
	public boolean updateMessage(GuestbookVO vo);
}
