package tictactoe;

import java.util.Arrays;

public class GameBoard {
	private GameObject[][] board; 
	private GameState gameState;
	private int turnCount = 0;
	
	private static final GameState STARTING_PLAYER = GameState.X_TURN;
	
	public GameBoard(){
		board = new GameObject[3][3];
		gameState = STARTING_PLAYER;
		for(GameObject[] row : board){
			Arrays.fill(row, GameObject.BLANK);
		}
	}
	
	public boolean placePieceAtLocation(int xLoc, int yLoc, GameObject piece){
		boolean isSuccess = false; 
		
		if(xLoc >=0 && xLoc <= 2 && yLoc >=0 && yLoc <= 2){ //Checks that the piece is trying to placed into a valid location
			if(board[xLoc][yLoc] == GameObject.BLANK || piece == GameObject.BLANK){ //Checks that a nonblank piece is not being placed over one that already exists
				board[xLoc][yLoc] = piece;
				System.out.println(gameState + " placed an " + piece + " piece at: " + xLoc + " , " + yLoc);
				isSuccess = true; 
			}
		} else{
			System.out.println("Invalid Piece location" + xLoc + " , " + yLoc);
			//TODO This might get spammy during evolution
		}
		return isSuccess;
	}
	
	public TurnResult runTurn(Player pX, Player pO){ //returns a boolean to pass on the success/failure of the piece placement //no bad.. make this return an ENUM for the game state.
		GameObject attemptedPlace = gameState.getGameObjectForTurn();
		boolean isSuccess = false;
		int[] coords;
		
		turnCount++;
		
		switch(gameState){
			case X_TURN:
				coords = pX.getNextCoords(board); 
				if(coords[0] < 0 || coords[0] > 2 || coords[1] < 0 || coords[1] > 2){
					return TurnResult.X_FAILS; 
				}
				isSuccess = placePieceAtLocation(coords[0], coords[1], GameObject.X);
				runWinDetection();
				return attemptedPlace.getEquivalentTurnResultState(isSuccess);
				
			case O_TURN:
				coords = pO.getNextCoords(board);
				if(coords[0] < 0 || coords[0] > 2 || coords[1] < 0 || coords[1] > 2){
					return TurnResult.O_FAILS; 
				}
				isSuccess = placePieceAtLocation(coords[0], coords[1], GameObject.O);
				runWinDetection();
				return attemptedPlace.getEquivalentTurnResultState(isSuccess);
				
			default: return TurnResult.NO_TRY;
		}
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
				System.out.println(gameState + " won!");
				 gameState = originPiece.getEquivalentGameState();
				 winFound = true; 
			}
		}
		
		return winFound; 
	}
	
	public boolean isBoardFull(){
		boolean isFull = true;
		
		for(GameObject[] g: board){
			if(Arrays.asList(g).contains(GameObject.BLANK)){
				isFull = false; 
			}
		}
		return isFull;
	}
	
	public boolean isGameOver(){
		return gameState != GameState.O_TURN && gameState != GameState.X_TURN;
	}
	
	public void runWinDetection(){
		detectWinAt(1, 1, 1, 0); //Middle row horizontal
		detectWinAt(1, 1, 0, 1); //Middle column vertical
		detectWinAt(1, 1, -1, -1); //Negative diagonal
		detectWinAt(1, 1, 1, -1); //Positive diagonal
		detectWinAt(0, 1, 0, 1); //Left column vertical
		detectWinAt(2, 1, 0, 1); //Right column vertical
		detectWinAt(1, 0, 1, 0); //Top row horizontal
		detectWinAt(1, 2, 1, 0); //Bottom row horizontal
		
		System.out.println(isBoardFull());
		
		if(gameState == GameState.X_TURN || gameState == GameState.O_TURN){
			if(isBoardFull()){
				gameState = GameState.TIE;
			} else{
				gameState = gameState.switchTurn();
			}
		} else if(turnCount > 18){
			gameState = GameState.INCOMPLETE;
		}
	}
	
	public void setGameState(GameState state){
		gameState = state; 
	}
	
	public GameState getGameState(){
		return gameState; 
	}
	
	public GameObject[][] getBoard(){
		return board; 
	}
	
	public void resetBoard(){
		gameState = STARTING_PLAYER;
		turnCount = 0;
		
		for(GameObject[] row : board){
			Arrays.fill(row, GameObject.BLANK);
		}
	}
	
}
