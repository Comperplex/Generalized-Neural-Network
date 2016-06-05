package unitTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import tictactoe.GameBoard;
import tictactoe.GameObject;

public class GameBoardTest {
	@Test
	public void test(){
		GameBoard board = new GameBoard();
		
		assertEquals(board.placePieceAtLocation(0, 0, GameObject.O), true);
		assertEquals(board.placePieceAtLocation(0, 0, GameObject.X), false);
		assertEquals(board.placePieceAtLocation(1, 0, GameObject.X), true);
		assertEquals(board.placePieceAtLocation(2, 0, GameObject.X), true);
		assertEquals(board.placePieceAtLocation(0, 1, GameObject.X), true); 
		assertEquals(board.placePieceAtLocation(1, 1, GameObject.O), true); 
		assertEquals(board.placePieceAtLocation(2, 1, GameObject.X), true); 
		assertEquals(board.placePieceAtLocation(0, 2, GameObject.X), true); 
		assertEquals(board.placePieceAtLocation(1, 2, GameObject.X), true); 
		assertEquals(board.placePieceAtLocation(2, 2, GameObject.O), true); 
		
		assertEquals(board.detectWinAt(1, 1, -1, -1), true);
		assertEquals(board.getWinner(), GameObject.O);
		
		board.placePieceAtLocation(1, 1, GameObject.X);
		assertEquals(board.detectWinAt(1, 1, 1, 0), true);
		board.detectWinAt(1, 1, 0, 1);
	}
}
