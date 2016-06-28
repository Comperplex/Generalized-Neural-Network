package tictactoe;

import networkStructure.Network;
import networkStructure.PerceptronNetwork;
import networkTraining.TrainingSet;

public class TicTacToeTrainingSet implements TrainingSet { 
	
	public static final String NETWORK_NAME = "TicTacToe";
	
	private static final int NUM_LAYERS = 10; 
	private static final int NUM_INPUTS = 19; //One set of 9 inputs for X, one set for O, and one input for player color
	private static final int NUM_OUTPUTS = 9; //One output for each of the squares on the board. Game will keep track of which network is which color
	
	private TicTacToe toe;
	
	//Begin fitness function parameters

	@Override
	public Network generateTrainingSetNetwork() {
		Network ticTacToeAI = new PerceptronNetwork(NUM_INPUTS);
		ticTacToeAI.addMultipleSimilarLayers(NUM_LAYERS - 1, 19);
		ticTacToeAI.addLayer(NUM_OUTPUTS);
		
		ticTacToeAI.setNetworkName(NETWORK_NAME);
		
		return ticTacToeAI;
	}
	
	public void playGamePerceptron(PerceptronNetwork pA, PerceptronNetwork pB){
		if(pA.getNetworkName() == NETWORK_NAME && pB.getNetworkName() == NETWORK_NAME){ //Making sure the networks in question are the right type
			toe = new TicTacToe();
			toe.start();
			GameBoard game = toe.getBoard();
		}
	}

	@Override
	public double fitnessFunction() {
		//Each network should play twice. Once as X and once as O against the same network opponent
		//Fitness function for tic tac toe should take into account the following things; 
		//Number of wins out of 2 rounds with its opponent. Wins should have high priority over ties and dead games. 
		//win > tie > loss > dead game
		//Count the number of correctly placed pieces per match. Use this as a secondary contribution to the fitness function. 
		
		
		return 0;
	}

}
