package unitTests;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mockito;

import networkStructure.PerceptronNetwork;
import networkTraining.TwoPlayerGameEvoHandler;
import tictactoe.TicTacToeTrainingSet;

public class TicTacToeEvolutionTest {
	
	@Test 
	public void test(){
		TicTacToeTrainingSet mockSet = Mockito.mock(TicTacToeTrainingSet.class); 
		TicTacToeTrainingSet set = new TicTacToeTrainingSet(); 
		
		when(mockSet.generateTrainingSetNetwork()).thenReturn(set.generateTrainingSetNetwork());	
		
		TwoPlayerGameEvoHandler handler = new TwoPlayerGameEvoHandler(3, mockSet);
		verify(mockSet, times(3)).generateTrainingSetNetwork();
		
		handler.runEvolution(3);
		verify(mockSet, times(6)).playTrainingGame(anyObject(), anyObject(), anyInt());
	}
	
}
