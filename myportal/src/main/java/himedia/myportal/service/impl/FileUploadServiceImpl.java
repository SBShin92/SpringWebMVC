package himedia.myportal.service.impl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import himedia.myportal.dao.BoardFilesBridgeDAO;
import himedia.myportal.dao.FilesDAO;
import himedia.myportal.service.FileUploadService;
import himedia.myportal.vo.BoardFilesBridgeVO;
import himedia.myportal.vo.FileVO;

@Service
public class FileUploadServiceImpl implements FileUploadService {
	@Autowired
	private FilesDAO filesDAO;
	@Autowired
	private BoardFilesBridgeDAO boardFilesBridgeDAO;
	
	private static String SAVE_PATH = "/home/ubuntu/myResources";
	
	
	public String uploadFile(MultipartFile multipartFile) {
		String originalFileName = multipartFile.getOriginalFilename();
		String extName = originalFileName.substring(originalFileName.lastIndexOf("."));
		String saveFileName = getSaveFilename(extName);
		
		try {
			writeFile(multipartFile, saveFileName);
			filesDAO.insert(new FileVO(saveFileName));
		} catch (IOException e) {
			System.err.println("파일을 쓰는 데 실패했습니다.");
		}
		return saveFileName;
	}
	
	public String uploadFile(MultipartFile multipartFile, Integer boardNo) {
		String originalFileName = multipartFile.getOriginalFilename();
		String extName = originalFileName.substring(originalFileName.lastIndexOf("."));
		String saveFileName = getSaveFilename(extName);
		
		try {
			writeFile(multipartFile, saveFileName);
			filesDAO.insert(new FileVO(saveFileName));
			FileVO fileVO = filesDAO.selectOneByName(saveFileName);
			System.out.println(fileVO.getNo());
			boardFilesBridgeDAO.insert(new BoardFilesBridgeVO(boardNo, fileVO.getNo()));
		} catch (IOException e) {
			System.err.println("파일을 쓰는 데 실패했습니다.");
		}
		return saveFileName;
	}
		
	
	private void writeFile(MultipartFile multipartFile, String saveFileName) throws IOException {
		byte[] fileData = multipartFile.getBytes();
		FileOutputStream fos = new FileOutputStream(SAVE_PATH + "/" + saveFileName);
		fos.write(fileData);
		fos.flush();
		fos.close();
	}
	
	private String getSaveFilename(String extName) {
		Calendar cal = Calendar.getInstance();
		return String.valueOf(cal.getTimeInMillis()) + extName.toLowerCase();
		
	}
	
}
