package com.mediAssist.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/project")
public class FileUploadController {

	/**
	 * Upload single file using Spring Controller
	 
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public @ResponseBody String uploadFileHandler(String name, MultipartFile file) {

		/*if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = "C:/FileUpload";
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath() + File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				//logger.info("Server File Location=" + serverFile.getAbsolutePath());

				return "You successfully uploaded file=" + name;
			} catch (Exception e) {
				return "You failed to upload " + name + " => " + e.getMessage();
			}
		} else {
			return "You failed to upload " + name + " because the file was empty.";
		}
	}*/

	/**
	 * Upload multiple file using Spring Controller
	 */
	@RequestMapping(value = "/uploadMultipleFile", method = RequestMethod.POST, consumes="multipart/form-data")
	public @ResponseBody
	String uploadMultipleFileHandler(@RequestParam("name") String names,
			@RequestParam("file") MultipartFile[] files) {
		System.out.println(files.length);
		/*if (files.length != names.length)
			return "Mandatory information missing";*/

		
		 //File convFile = new File(file.getOriginalFilename());
		 
		 
		String message = "";
		for (int i = 0; i < files.length; i++) {
			MultipartFile file = files[i];
			System.out.println(file.getOriginalFilename());
			System.out.println(file.getSize());
			//String name = names[i];
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath =  "C:/FileUpload";
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + "temp");
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();


				message = message + "You successfully uploaded file=" + "temp";
			} catch (Exception e) {
				return "You failed to upload " + "temp" + " => " + e.getMessage();
			}
		}
		return null;
	}
}
