package com.agroshop.app.model.service.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.agroshop.app.model.service.IUploadFileService;
import com.agroshop.app.util.Constants;

@Service
public class UploadFileServiceImpl implements IUploadFileService {
	
	private final Logger log = LoggerFactory.getLogger(UploadFileServiceImpl.class);

    @Override
    public String copy(MultipartFile file) throws IOException {
        String nameImage = UUID.randomUUID().toString() + "_" + file.getOriginalFilename().replace(" ", "");

        Path pathImage = getPath(nameImage);
        log.info(pathImage.toString());

        Files.copy(file.getInputStream(), pathImage);
        return pathImage.toString();
    }


    @Override
    public Path getPath(String nameImage) {
    	String directory = System.getProperty("user.dir");
		String separator = System.getProperty("file.separator");
		String randomUIID = UUID.randomUUID().toString();
		String ruta = directory + separator + Constants.DIRECTORY_UPLOAD + separator + randomUIID + nameImage;

        Path pathImage = Paths.get(Constants.DIRECTORY_UPLOAD).resolve(nameImage).toAbsolutePath();
        return pathImage;
    }


	@Override
	public Resource load(String nameImage) throws MalformedURLException {
		
		Path pathImage = getPath(nameImage);

        Resource resource = new UrlResource(pathImage.toUri());

        if (!resource.exists() && !resource.isReadable()) {

            resource = new UrlResource(pathImage.toAbsolutePath().toUri());
        }
        return resource;
	}
	
}
