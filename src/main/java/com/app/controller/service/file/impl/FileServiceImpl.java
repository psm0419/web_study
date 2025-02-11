package com.app.controller.service.file.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.controller.dao.file.FileDAO;
import com.app.controller.service.file.FileService;
import com.app.dto.file.FileInfo;

@Service
public class FileServiceImpl implements FileService{
	@Autowired
	FileDAO fileDAO;
	
	@Override
	public int saveFileInfo(FileInfo fileInfo) {
		
		int result = fileDAO.saveFileInfo(fileInfo);
		return result;
	}

	@Override
	public FileInfo findFileInfoByFileName(String fileName) {
		
		FileInfo fileInfo = fileDAO.findFileInfoByFileName(fileName);
		return fileInfo;
		
	}

}
