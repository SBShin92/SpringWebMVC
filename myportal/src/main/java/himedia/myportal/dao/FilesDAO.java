package himedia.myportal.dao;

import java.util.List;

import himedia.myportal.vo.FileVO;

public interface FilesDAO {
	public List<FilesDAO> selectList();
	public FileVO selectOne(Integer no);
	public FileVO selectOneByName(String name);
	public Integer insert(FileVO fileVO);
	public Integer delete(FileVO fileVO);
}
