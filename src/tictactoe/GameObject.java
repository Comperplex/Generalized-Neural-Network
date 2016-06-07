package tictactoe;

public enum GameObject {
	BLANK, X, O;
	
	public TurnResult getEquivalentTurnResultState(boolean isSuccess){
		switch(this){
			case X: 
				if(isSuccess){
					return TurnResult.X_SUCCEEDS;
					
				} else{
					return TurnResult.X_FAILS;
				}
			case O:
				if(isSuccess){
					return TurnResult.O_SUCCEEDS;
					
				} else{
					return TurnResult.O_FAILS;
				}
			default: return TurnResult.NO_TRY;
		}
	}
	
	public GameState getEquivalentGameState(){
		switch(this){
			case X: return GameState.X_WINS;
			case O: return GameState.O_WINS;
			default: return GameState.TIE;
		}
		
	}
}
