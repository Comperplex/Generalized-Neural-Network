package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import networkStructure.Network;

public class FileIO {

	public static void createNewFile(String fileLocation){
			File file = new File(fileLocation);
			if(!file.exists()){
				try {
					file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	}
	
	public static File readFileAtLocation(String fileLocation){
		File file = new File(fileLocation);
		if(file.exists()){
			return file;
		}else{
			System.out.println("File at " + fileLocation + " doesn't exist");
			return null;
		}
	}
	
	public static void saveNetwork(Network network, String fileLocation){
		
		createNewFile(fileLocation); //Ensures that a file exists at the given directory
		
		try {
				FileOutputStream fileOut = new FileOutputStream(fileLocation);
				ObjectOutputStream outStream = new ObjectOutputStream(fileOut);
				outStream.writeObject(network);
				System.out.println("Saved network to: " + fileLocation);
				
				fileOut.close();
				outStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static Network loadNetwork(String fileLocation){
		
		File file = readFileAtLocation(fileLocation); //This prevents the file from being nonexistent. 
		Network network = null; 
			try {
				if(file.exists()){
					FileInputStream fileIn = new FileInputStream(fileLocation);
					ObjectInputStream inStream = new ObjectInputStream(fileIn);
					network = (Network) inStream.readObject();
				}
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		return network;
	}
}
	
