package com.app.dto.file;

import lombok.Data;

@Data
public class FileInfo {

	String fileId;
	String fileName; //저장된 파일이름
	String originalFileName; //우너래 파일 이름
	String filePath; //저장된 경로
	String urlFilePath; //url로 요청할때 경로
}
