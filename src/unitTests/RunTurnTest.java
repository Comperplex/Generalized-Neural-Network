package unitTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import tictactoe.GameBoard;
import tictactoe.GameObject;
import tictactoe.TurnResult;

public class RunTurnTest {
	@Test
	public void test(){
		GameBoard board = new GameBoard(); 
		
		assertEquals(board.runTurn(0, 0), TurnResult.X_SUCCEEDS); //X plays at 0,0
		assertEquals(board.runTurn(1, 0), TurnResult.O_SUCCEEDS); //O plays at 1,0
		assertEquals(board.runTurn(1, 1), TurnResult.X_SUCCEEDS); //X plays at 1,1
		assertEquals(board.runTurn(2, 0), TurnResult.O_SUCCEEDS); //O plays at 2,0
		assertEquals(board.runTurn(2, 2), TurnResult.X_SUCCEEDS); //X plays at 2,2
		assertEquals(board.runTurn(1, 0), TurnResult.NO_TRY); //Since there is a win, the turn result won't work
		
		board.placePieceAtLocation(2, 2, GameObject.BLANK);
		board.resetBoard();
		assertEquals(board.runTurn(2, 2), TurnResult.X_SUCCEEDS);
	}
}
