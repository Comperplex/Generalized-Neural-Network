package tictactoe;

public class TicTacToeResult{
	private GameState finalState;
	
	private int aMoveCount; //TODO are these variables still necessary? 
	private int aFailCount; 
	
	private int bMoveCount;
	private int bFailCount;
	
	public GameState getFinalState() {
		return finalState;
	}
	public void setFinalState(GameState finalState) {
		this.finalState = finalState;
	}
	
	public void addGameTurn(TurnResult result){
		switch(result){
			case O_SUCCEEDS: bMoveCount++; 
			case O_FAILS: bFailCount++;
			case X_SUCCEEDS: aMoveCount++;
			case X_FAILS: aFailCount++;
			default: break; 
		}
		
	}
	
	public int getxMoveCount() {
		return aMoveCount;
	}

	public int getxFailCount() {
		return aFailCount;
	}

	public int getoMoveCount() {
		return bMoveCount;
	}

	public int getoFailCount() {
		return bFailCount;
	}
}
