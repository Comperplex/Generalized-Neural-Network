package tictactoe;

import java.util.ArrayList;

public class TicTacToeResult {
	private GameState finalState;
	private ArrayList<TurnResult> gameTurns;
	
	private int xMoveCount;
	private int xFailCount; 
	
	private int yMoveCount;
	private int yFailCount;
	
	public TicTacToeResult(){
		gameTurns = new ArrayList<TurnResult>(); 
	}
	
	public GameState getFinalState() {
		return finalState;
	}
	public void setFinalState(GameState finalState) {
		this.finalState = finalState;
	}
	
	public void addGameTurn(TurnResult result){
		gameTurns.add(result); 
	}

}
