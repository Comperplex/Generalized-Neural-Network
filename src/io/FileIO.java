package io;

import java.io.File;
import java.io.IOException;

public class FileIO {
	
	public void createNewFile(String fileLocation){
			File file = new File(fileLocation);
			if(!file.exists()){
				try {
					file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	}
	
	public File readFileAtLocation(String fileLocation){
		File file = new File(fileLocation);
		if(file.exists()){
			return file;
		}else{
			System.out.println("File at " + fileLocation + " doesn't exist");
			return null;
		}
	}
}
	
