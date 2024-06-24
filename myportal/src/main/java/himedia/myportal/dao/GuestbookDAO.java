package himedia.myportal.dao;

import java.util.List;

import himedia.myportal.vo.GuestbookVO;

public interface GuestbookDAO {
	public List<GuestbookVO> selectAll();
	public GuestbookVO select(Long no);
	
	public int insert(GuestbookVO vo);
	public int delete(GuestbookVO vo);
	public int update(GuestbookVO vo);
		
}
