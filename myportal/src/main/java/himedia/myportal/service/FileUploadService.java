package himedia.myportal.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
	public String uploadFile(MultipartFile multipartFile);
	public String uploadFile(MultipartFile multipartFile, Integer boardNo);
	
}
