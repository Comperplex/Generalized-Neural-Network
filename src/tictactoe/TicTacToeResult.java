package tictactoe;

public class TicTacToeResult{
	private GameState finalState;
	
	private int xMoveCount; //TODO are these variables still necessary? 
	private int xFailCount; 
	
	private int oMoveCount;
	private int oFailCount;
	
	private int turnCount; 
	
	public GameState getFinalState() {
		return finalState;
	}
	public void setFinalState(GameState finalState) {
		this.finalState = finalState;
	}
	
	public void addGameTurn(TurnResult result){
		turnCount++;
		switch(result){
			case O_SUCCEEDS: oMoveCount++; 
			case O_FAILS: oFailCount++;
			case X_SUCCEEDS: xMoveCount++;
			case X_FAILS: xFailCount++;
			default: break; 
		}
		
	}
	
	public int getxMoveCount() {
		return xMoveCount;
	}

	public int getxFailCount() {
		return xFailCount;
	}

	public int getoMoveCount() {
		return oMoveCount;
	}

	public int getoFailCount() {
		return oFailCount;
	}
	
	public int getTurnCount(){
		return turnCount; 
	}
}
