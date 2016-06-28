package unitTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import tictactoe.GameBoard;
import tictactoe.GameObject;
import tictactoe.Player;
import tictactoe.TurnResult;

public class RunTurnTest {
	@Test
	public void test(){
		GameBoard board = new GameBoard();
		Player pX = new Player(GameObject.X, "test");
		Player pO = new Player(GameObject.O, "test");
		
		//Will run the turn pattern given in the "test" case of the player class
		
		assertEquals(board.runTurn(pO, pX), TurnResult.X_SUCCEEDS); //Will fail if the starting player is changed to O
		assertEquals(board.runTurn(pO, pX), TurnResult.O_SUCCEEDS);
		
		board.placePieceAtLocation(2, 2, GameObject.BLANK);
		board.resetBoard();
	}
}
