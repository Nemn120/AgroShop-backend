package com.agroshop.app.model.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface IUploadFileService {
	
	
	public String copy(MultipartFile file) throws IOException;
	
	public Path getPath(String image);
	
	public Resource load(String nameImage) throws MalformedURLException;
	
}
