package tictactoe;

public enum GameState {
	X_WINS, O_WINS, TIE, X_TURN, O_TURN;
	
	public GameState switchTurn(){ //returns the opposite of the GameObject which calls this method
		switch(this){
			case X_TURN: return O_TURN;
			case O_TURN: return X_TURN;
			default: return TIE;
		}
	}
	
	public GameObject getGameObjectForTurn(){
		switch(this){
			case X_TURN: return GameObject.X;
			case O_TURN: return GameObject.O;
			default: return GameObject.BLANK;
		}
	}
}
