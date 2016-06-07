package tictactoe;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Screen {
	
	private int width;
	private int height;
	private BufferedImage image; 
	private Graphics g;
	private JFrame frame;
	
	private static final int LINE_THICKNESS = 4; 
	
	//Some relative constants for window drawing
	private int firstHorizLineLoc;
	private int secondHorizLineLoc;
	
	private int firstVertLineLoc;
	private int secondVertLineLoc;
	
	private int cellHalfWidth; 
	private int cellHalfHeight;
	
	public Screen(JFrame frame){
		this.frame = frame;
		updateImageSize();
	}
	
	public void update(GameObject[][] board){
		updateImageSize();
		drawBackground();
		renderPieces(board);
		//The various draw commands for the game will go here. Use the graphics object g. Have it reference whatever it needs from outside the class. 
		g.drawImage(image, 0, 0, null);
	}
	
	private void drawBackground(){
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
		
		g.setColor(Color.WHITE);
		g.fillRect(0, firstHorizLineLoc, width, LINE_THICKNESS);
		g.fillRect(0, secondHorizLineLoc, width, LINE_THICKNESS);
		g.fillRect(firstVertLineLoc, 0, LINE_THICKNESS, height);
		g.fillRect(secondVertLineLoc, 0, LINE_THICKNESS, height);
	}
	
	private void renderPieces(GameObject[][] board){
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				switch(board[i][j]){
					case X: drawX(i, j); break;
					case O: drawO(i, j); break;
					default: break;
				}
			}
		}
	}
	
	private void drawX(int xGridLoc, int yGridLoc){ 
		if(checkGridLocs(xGridLoc, yGridLoc)){
			int[] squareCenter = getTileCenters(xGridLoc, yGridLoc);
			int xWidth = (int)(cellHalfWidth / 1.5);
			int xHeight = (int)(cellHalfHeight / 1.5);
			
			drawThickLine(squareCenter[0], squareCenter[1], squareCenter[0] - xWidth, squareCenter[1] - xHeight, LINE_THICKNESS, Color.RED);
			drawThickLine(squareCenter[0], squareCenter[1], squareCenter[0] +  xWidth, squareCenter[1] + xHeight, LINE_THICKNESS, Color.RED);
			drawThickLine(squareCenter[0], squareCenter[1], squareCenter[0] + xWidth, squareCenter[1] - xHeight, LINE_THICKNESS, Color.RED);
			drawThickLine(squareCenter[0], squareCenter[1], squareCenter[0] - xWidth, squareCenter[1] + xHeight, LINE_THICKNESS, Color.RED);
		}
	}
	
	private void drawO(int xGridLoc, int yGridLoc){
		
		if(checkGridLocs(xGridLoc, yGridLoc)){
			int[] squareCenter = getTileCenters(xGridLoc, yGridLoc);
			int oWidth = (int)(cellHalfWidth * 1.5);
			int oHeight = (int)(cellHalfHeight * 1.5);
			
			g.setColor(Color.BLUE);
			g.fillOval(squareCenter[0] - oWidth / 2, squareCenter[1] - oHeight / 2, oWidth, oHeight);
			
			oWidth -= LINE_THICKNESS * 2; 
			oHeight -= LINE_THICKNESS * 2; 
			
			g.setColor(Color.BLACK);
			g.fillOval(squareCenter[0] - oWidth / 2, squareCenter[1] - oHeight / 2, oWidth, oHeight);
		}
	}
	
	private int[] getTileCenters(int xGridLoc, int yGridLoc){
		int[] squareCenters = new int[2];
		
		if(checkGridLocs(xGridLoc, yGridLoc)){
			switch(xGridLoc){
				case 0: squareCenters[0] = firstVertLineLoc - cellHalfWidth; break;
				case 1: squareCenters[0] = secondVertLineLoc - cellHalfWidth; break; 
				case 2: squareCenters[0] = width - cellHalfWidth; break;
			}
			
			switch(yGridLoc){
				case 0: squareCenters[1] = firstHorizLineLoc - cellHalfHeight; break;
				case 1: squareCenters[1] = secondHorizLineLoc - cellHalfHeight; break; 
				case 2: squareCenters[1] = height - cellHalfHeight; break;
			}
		}
		return squareCenters;
	}
	
	private boolean checkGridLocs(int xGridLoc, int yGridLoc){
		return xGridLoc >= 0 && xGridLoc <= 2 && yGridLoc >=0 && yGridLoc <= 2;
	}
	
	private void updateImageSize(){
		width = frame.getWidth();
		height = frame.getHeight() - 39; //Minus 39 here because JFrame is stupid and counts the title bar as part of the frame
		if(width > 0 && height > 0){
			image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			g = image.getGraphics();
			
			firstVertLineLoc = (int) ((width - (2 * LINE_THICKNESS)) / 3);
			secondVertLineLoc = (int) (LINE_THICKNESS + ((width - (2 * LINE_THICKNESS)) / 1.5));
			
			firstHorizLineLoc = (int) ((height - (2 * LINE_THICKNESS)) / 3);
			secondHorizLineLoc = (int) (LINE_THICKNESS + ((height - (2 * LINE_THICKNESS)) / 1.5));
			
			cellHalfWidth = firstVertLineLoc / 2;
			cellHalfHeight = firstHorizLineLoc / 2;
		}
	}
	
	public Image getImage(){
		return image;
	}
	
	//BEGIN CODE COPIED FROM WEB
	 private void drawThickLine(int x1, int y1, int x2, int y2, int thickness, Color c) {
		  // The thick line is in fact a filled polygon
		  g.setColor(c);
		  int dX = x2 - x1;
		  int dY = y2 - y1;
		  // line length
		  double lineLength = Math.sqrt(dX * dX + dY * dY);

		  double scale = (double)(thickness) / (2 * lineLength);

		  double ddx = -scale * (double)dY;
		  double ddy = scale * (double)dX;
		  ddx += (ddx > 0) ? 0.5 : -0.5;
		  ddy += (ddy > 0) ? 0.5 : -0.5;
		  int dx = (int)ddx;
		  int dy = (int)ddy;

		  // Now we can compute the corner points...
		  int xPoints[] = new int[4];
		  int yPoints[] = new int[4];

		  xPoints[0] = x1 + dx; yPoints[0] = y1 + dy;
		  xPoints[1] = x1 - dx; yPoints[1] = y1 - dy;
		  xPoints[2] = x2 - dx; yPoints[2] = y2 - dy;
		  xPoints[3] = x2 + dx; yPoints[3] = y2 + dy;

		  g.fillPolygon(xPoints, yPoints, 4);
		  }
}
