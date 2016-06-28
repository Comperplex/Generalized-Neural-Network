package tictactoe;

public enum GameObject {
	BLANK(0), X(1), O(2);
	
	private int index; 
	
	private GameObject(int index){
		this.index = index; 
	}
	
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
	
	public int getIntEquivalentInt(){
		return this.index;
	}
	
	public GameObject getEquivalentGameObject(int index){
		switch(index){
			case 0: return BLANK;
			case 1: return X;
			case 2: return O;
			default: return BLANK;
		}
	}
}
