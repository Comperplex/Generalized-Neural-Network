package tictactoe;

import java.util.Arrays;

public class GameBoard {
	private GameObject[][] board; 
	private GameState gameState;
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
	
	public TurnResult runTurn(Player pO, Player pX){ //returns a boolean to pass on the success/failure of the piece placement //no bad.. make this return an ENUM for the game state.
		
		GameObject attemptedPlace = gameState.getGameObjectForTurn();
		boolean isSuccess = false;
		int[] coords;
		
		switch(gameState){
			case X_TURN:
				coords = pX.getNextCoords(board); 
				isSuccess = placePieceAtLocation(coords[0], coords[1], GameObject.X);
				gameState = testAllWins();
				return attemptedPlace.getEquivalentTurnResultState(isSuccess);
				
			case O_TURN:
				coords = pO.getNextCoords(board);
				isSuccess = placePieceAtLocation(coords[0], coords[1], GameObject.O);
				gameState = testAllWins();
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
		return Arrays.asList(board).contains(GameObject.BLANK);
	}
	
	public boolean isGameOver(){
		return gameState == GameState.TIE || gameState == GameState.X_WINS || gameState == GameState.O_WINS;
	}
	
	public GameState testAllWins(){
		detectWinAt(1, 1, 1, 0); //Middle row horizontal
		detectWinAt(1, 1, 0, 1); //Middle column vertical
		detectWinAt(1, 1, -1, -1); //Negative diagonal
		detectWinAt(1, 1, 1, -1); //Positive diagonal
		detectWinAt(0, 1, 0, 1); //Left column vertical
		detectWinAt(2, 1, 0, 1); //Right column vertical
		detectWinAt(1, 0, 1, 0); //Top row horizontal
		detectWinAt(1, 2, 1, 0); //Bottom row horizontal
		
		if(gameState == GameState.X_TURN || gameState == GameState.O_TURN){
			gameState = gameState.switchTurn();
		}
		
		return gameState;
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
		
		for(GameObject[] row : board){
			Arrays.fill(row, GameObject.BLANK);
		}
	}
	
}
