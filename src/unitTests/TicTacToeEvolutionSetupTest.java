package unitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import networkStructure.Network;
import networkTraining.TwoPlayerGameEvoHandler;
import tictactoe.TicTacToeTrainingSet;

public class TicTacToeEvolutionSetupTest {
	
	@Test
	public void test(){
		TicTacToeTrainingSet set = new TicTacToeTrainingSet();
		TwoPlayerGameEvoHandler handler = new TwoPlayerGameEvoHandler(10, 5, set);
		
		ArrayList<Network> currentGeneration = handler.getCurrentGeneration(); 
		
		assertEquals(currentGeneration.size(), 10);
		
//		for(int i = 0; i < 9; i++){ //Technically this could fail without any issues, but the chance of it happening is very very very very low. 
//				assertNotSame(currentGeneration.get(i).toString(), currentGeneration.get(i + 1).toString());
//		}
		
		assertEquals(currentGeneration.get(0).getNumInputs(), 19);
		assertEquals(currentGeneration.get(0).getAllLayers().get(0).getNumOutputs(), 19);
		assertEquals(currentGeneration.get(9).getNumOutputs(), 9); //Testing that the last layer has 9 outputs

	}
}
