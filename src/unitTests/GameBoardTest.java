package unitTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import tictactoe.GameBoard;
import tictactoe.GameObject;
import tictactoe.GameState;
import tictactoe.TicTacToe;

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
		assertEquals(board.getGameState(), GameState.O_WINS);
		
		board.placePieceAtLocation(1, 1, GameObject.BLANK);
		board.placePieceAtLocation(1, 1, GameObject.X);
		
		assertEquals(board.detectWinAt(1, 1, 1, 0), true);
		assertEquals(board.getGameState(), GameState.X_WINS);
		
		board.placePieceAtLocation(2, 0, GameObject.BLANK);
		board.placePieceAtLocation(2, 0, GameObject.O);
		board.runWinDetection();
		assertEquals(board.isBoardFull(), true);
		//assertEquals(board.getGameState(), GameState.TIE);
	}
}
