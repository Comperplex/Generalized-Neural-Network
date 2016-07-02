package tictactoe;

import networkStructure.Network;
import networkStructure.PerceptronNetwork;
import networkTraining.TwoPlayerGameTrainingSet;

public class TicTacToeTrainingSet implements TwoPlayerGameTrainingSet { 
	
	public static final String NETWORK_NAME = "TicTacToe";
	
	private static final int NUM_LAYERS = 10; 
	private static final int NUM_INPUTS = 19; //One set of 9 inputs for X, one set for O, and one input for player color
	private static final int NUM_OUTPUTS = 9; //One output for each of the squares on the board. Game will keep track of which network is which color
	
	private TicTacToe toe;
	private TicTacToeResult currentResult; 
	
	//Begin fitness function parameters

	@Override
	public Network generateTrainingSetNetwork() {
		Network ticTacToeAI = new PerceptronNetwork(NUM_INPUTS);
		ticTacToeAI.addMultipleSimilarLayers(NUM_LAYERS - 1, 19);
		ticTacToeAI.addLayer(NUM_OUTPUTS);
		
		ticTacToeAI.setNetworkName(NETWORK_NAME);
		
		return ticTacToeAI;
	}
	
	public void playTrainingGame(Network pANet, Network pBNet, int generationSize){
		if(pANet.getNetworkName() == NETWORK_NAME && pBNet.getNetworkName() == NETWORK_NAME //Making sure the networks in question are the right type.
				&& pANet instanceof PerceptronNetwork && pBNet instanceof PerceptronNetwork){ 
			
			Player pO = new Player(GameObject.O, (PerceptronNetwork) pBNet);
			Player pX = new Player(GameObject.X, (PerceptronNetwork) pANet);
			
			toe = new TicTacToe();
			toe.start();
			currentResult = toe.runGame(pO, pX);
			
			pANet.setFitnessValue(fitnessFunction(pANet, generationSize)); 
			pBNet.setFitnessValue(fitnessFunction(pBNet, generationSize));
		}
	}

	@Override
	public double fitnessFunction(Network network, int generationSize) { 
		double fitnessValue = 0; //Zero is a base score, neither positive nor negative
		//BEGIN TENTATIVE FITNESS FUNCTION CODE
		
		fitnessValue = network.getFitnessValue() + fitnessValue / (2 * generationSize); 
		//This combines the new fitness value for the current game with the running total.
		//Fitnessvalue is scaled down by twice the generation size since each network plays against each other network twice.
		//END TENTATIVE FITNESS FUNCTION CODE
		
		return fitnessValue; 
		//Fitness function for tic tac toe should take into account the following things; 
		//Number of wins out of 2 rounds with its opponent. Wins should have high priority over ties and dead games. 
		//win > tie > loss > dead game
		//Count the number of correctly placed pieces per match. Use this as a secondary contribution to the fitness function. 
	}
}
