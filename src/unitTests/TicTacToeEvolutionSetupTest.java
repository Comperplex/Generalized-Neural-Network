package unitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import networkStructure.Network;
import networkTraining.TwoPlayerGameEvoHandler;
import tictactoe.TicTacToeTrainingSet;

public class TicTacToeEvolutionSetupTest {
	
	@Test
	public void test(){ //This test tests the basic initialization of a ticTacToe evolution set, this includes making sure that the initial random mutation took place
		TicTacToeTrainingSet set = new TicTacToeTrainingSet();
		TwoPlayerGameEvoHandler handler = new TwoPlayerGameEvoHandler(10, set);
		
		ArrayList<Network> currentGeneration = handler.getCurrentGeneration(); 
		
		assertEquals(currentGeneration.size(), 10);
		assertEquals(currentGeneration.get(0).getNumInputs(), 19);
		assertEquals(currentGeneration.get(0).getAllLayers().get(0).getNumOutputs(), 19);
		assertEquals(currentGeneration.get(9).getNumOutputs(), 9); //Testing that the last layer has 9 outputs

	}
}
