package networkTraining;

import java.util.ArrayList;

import networkStructure.Network;

public class TwoPlayerGameEvoHandler extends EvolutionHandler {
	
	//Evolution handler for a Two Player Finite State Game such as tic tac toe, Connect 4, or chess
	public TwoPlayerGameEvoHandler(int numStartingNetworks, TwoPlayerGameTrainingSet set){
		super(numStartingNetworks, set);
	}

	@Override
	public ArrayList<Network> runEvolution(int numGenerations) {
		for(Network n1: currentGeneration){
			for(Network n2: currentGeneration){
				((TwoPlayerGameTrainingSet) set).playTrainingGame(n1, n2, generationSize); //Every network plays with every other network as both pA and pB
				((TwoPlayerGameTrainingSet) set).playTrainingGame(n2, n1, generationSize);
			}
		}
		return null;
	}

}
