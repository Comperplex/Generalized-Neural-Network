package networkTraining;

import java.util.ArrayList;

import networkStructure.Network;

public class TwoPlayerFiniteStateGame extends EvolutionHandler {
	
	//Evolution handler for a Two Player Finite State Game such as tic tac toe, Connect 4, or chess
	public TwoPlayerFiniteStateGame(int numStartingNetworks, int numGenerations){
		super(numStartingNetworks, numGenerations);
	}

	@Override
	public ArrayList<Network> runEvolution(int numGenerations, TrainingSet set) {
		// TODO Auto-generated method stub
		return null;
	}

}
