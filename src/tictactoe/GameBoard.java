package tictactoe;

import java.util.Arrays;

public class GameBoard {
	private GameObject[][] board; 
	private GameObject currentTurn;
	private GameObject winner;
	
	public GameBoard(){
		board = new GameObject[3][3];
		winner = GameObject.BLANK;
		currentTurn = GameObject.BLANK;
		for(GameObject[] row : board){
			Arrays.fill(row, GameObject.BLANK);
		}
	}
	
	public boolean placePieceAtLocation(int xLoc, int yLoc, GameObject piece){
		boolean isSuccess = false; 
		
		if(xLoc >=0 && xLoc <= 2 && yLoc >=0 && yLoc <= 2){ //Checks that the piece is trying to placed into a valid location
			if(board[xLoc][yLoc] == GameObject.BLANK || piece == GameObject.BLANK){ //Checks that a nonblank piece is not being placed over one that already exists
				board[xLoc][yLoc] = piece;
				System.out.println(currentTurn + " placed an " + piece + " piece at: " + xLoc + " , " + yLoc);
				isSuccess = true; 
			}
		} else{
			System.out.println("Invalid Piece location" + xLoc + " , " + yLoc);
			//TODO This might get spammy during evolution
		}
		return isSuccess;
	}
	
	public boolean detectWinAt(int xOrigin, int yOrigin, int xScope, int yScope){ //This is the potential source of every single ArrayIndexOutOfBoundsException that ever existed
		boolean winFound = false;
		GameObject originPiece = board[xOrigin][yOrigin];
		
		if(originPiece != GameObject.BLANK){
			GameObject positiveAdjacency = board[xOrigin + xScope][yOrigin + yScope];
			GameObject negativeAdjacency = board[xOrigin - xScope][yOrigin - yScope];
			
			System.out.println(positiveAdjacency);
			System.out.println(negativeAdjacency);
			System.out.println(originPiece);
			
			if(originPiece.equals(positiveAdjacency) && originPiece.equals(negativeAdjacency)){
				System.out.println(winner + " won!");
				 winner = originPiece;
				 winFound = true; 
			}
		}
		
		return winFound; 
	}
	
	public boolean isBoardFull(){
		return Arrays.asList(board).contains(GameObject.BLANK);
	}
	
	public GameObject testAllWins(){
		detectWinAt(1, 1, 1, 0); //Middle row horizontal
		detectWinAt(1, 1, 0, 1); //Middle column vertical
		detectWinAt(1, 1, -1, -1); //Negative diagonal
		detectWinAt(1, 1, 1, -1); //Positive diagonal
		detectWinAt(0, 1, 0, 1); //Left column vertical
		detectWinAt(2, 1, 0, 1); //Right column vertical
		detectWinAt(1, 0, 1, 0); //Top row horizontal
		detectWinAt(1, 2, 1, 0); //Bottom row horizontal
		
		return winner; 
	}
	
	public GameObject getWinner(){
		return winner; 
	}
	
	public GameObject[][] getBoard(){
		return board; 
	}
	
}
