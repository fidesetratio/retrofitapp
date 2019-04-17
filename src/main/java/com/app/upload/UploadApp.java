package com.app.upload;

import java.io.IOException;
import java.util.List;

import com.app.GitHubBasicService;

public class UploadApp {
	 public static void main(String[] args) throws IOException {
	        String file = "davechild_linux-command-line.pdf";
	        UploadService uploadService = new UploadService();
	        uploadService.uploadFile("images/"+file);
	        

	     
	 
	 }

}
