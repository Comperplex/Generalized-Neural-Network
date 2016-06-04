package tictactoe;

import networkStructure.Network;
import networkStructure.PerceptronNetwork;
import networkTraining.TrainingSet;

public class TicTacToeTrainingSet extends TrainingSet {
	
	private static final int NUM_LAYERS = 10; 
	private static final int NUM_INPUTS = 19; //One set of 9 inputs for X, one set for O, and one input for player color
	private static final int NUM_OUTPUTS = 9; //One output for each of the squares on the board. Game will keep track of which network is which color

	@Override
	public Network generateTrainingSetNetwork() {
		Network ticTacToeAI = new PerceptronNetwork(NUM_INPUTS);
		ticTacToeAI.addMultipleSimilarLayers(NUM_LAYERS - 1, 19);
		ticTacToeAI.addLayer(NUM_OUTPUTS);
		
		return ticTacToeAI;
	}

	@Override
	public double fitnessFunction() {
		// TODO Auto-generated method stub
		return 0;
	}

}
