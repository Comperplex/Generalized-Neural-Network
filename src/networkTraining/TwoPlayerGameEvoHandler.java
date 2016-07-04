package networkTraining;

import java.util.ArrayList;
import java.util.ListIterator;

import networkStructure.Network;

public class TwoPlayerGameEvoHandler extends EvolutionHandler {
	
	//Evolution handler for a Two Player Finite State Game such as tic tac toe, Connect 4, or chess
	public TwoPlayerGameEvoHandler(int numStartingNetworks, TwoPlayerGameTrainingSet set){
		super(numStartingNetworks, set);
	}

	@Override
	public ArrayList<Network> runEvolution(int numGenerations) {
//		int n1Index = 0;
//		int n2Index = 0; 
//		
//		for(Network n1: currentGeneration){
//			for(Network n2: currentGeneration){
//				System.out.println(n1Index + " " + n2Index + " " + (n1Index != n2Index));
//				if(n1Index != n2Index){
//					((TwoPlayerGameTrainingSet) set).playTrainingGame(n1, n2, generationSize); //Every network plays with every other network as both pA and pB
//				}
//				n2Index++;
//			}
//			n2Index = 0; 
//			n1Index++;
//		}
		
		for(ListIterator<Network> it1 = currentGeneration.listIterator(); it1.hasNext(); ){
			for(ListIterator<Network> it2 = currentGeneration.listIterator(); it2.hasNext(); ){
				System.out.println("hi");
				if(it1.nextIndex() != it2.nextIndex()){
					((TwoPlayerGameTrainingSet) set).playTrainingGame(it1.next(), it2.next(), generationSize); //Every network plays with every other network as both pA and pB
				}
			}
		}
		
		
		return null;
	}

}
