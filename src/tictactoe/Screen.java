package tictactoe;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class Screen {
	
	private int width;
	private int height;
	private BufferedImage image; 
	private Graphics g;
	
	public Screen(int width, int height){
		this.width = width;
		this.height = height;
		
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		g = image.getGraphics();
	}
	
	public void update(){
		//The various draw commands for the game will go here. Use the graphics object g. Have it reference whatever it needs from outside the class. 
		g.drawImage(image, 0, 0, null);
	}
	
	public Image getImage(){
		return image;
	}
}
