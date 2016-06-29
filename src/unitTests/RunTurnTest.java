package unitTests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mockito;

import tictactoe.GameBoard;
import tictactoe.GameState;
import tictactoe.Player;
import tictactoe.TurnResult;

public class RunTurnTest {
	
	@Test
	public void test(){ //This test ensures that turns switch as they should and that no turns try to happen after someone has won
		GameBoard board = new GameBoard();
		Player mockPX = Mockito.mock(Player.class);
		Player mockPO = Mockito.mock(Player.class);
		
		int[] mockPieceLocation1 = {0,0};
		int[] mockPieceLocation2 = {1,0};
		
		when(mockPX.getNextCoords(anyObject())).thenReturn(mockPieceLocation1);
		when(mockPO.getNextCoords(anyObject())).thenReturn(mockPieceLocation2);
		
		assertEquals(board.runTurn(mockPX, mockPO), TurnResult.X_SUCCEEDS);
		assertEquals(board.runTurn(mockPX, mockPO), TurnResult.O_SUCCEEDS);
		assertEquals(board.runTurn(mockPX, mockPO), TurnResult.X_FAILS);
		
		board.setGameState(GameState.O_WINS);
		assertEquals(board.runTurn(mockPX, mockPO), TurnResult.NO_TRY);
		
		//Based on the pattern runTurn should exhibit, mockPX should have been used twice and mockPO should have been used once
		
		verify(mockPX, times(2)).getNextCoords(anyObject()); 
		verify(mockPO, times(1)).getNextCoords(anyObject());
	}
}
