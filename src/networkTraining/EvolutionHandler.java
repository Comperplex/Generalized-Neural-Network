package networkTraining;

import java.util.ArrayList;

import networkStructure.Network;

//Types of network trainings:
	//Two player finite-state games
	//One player real-time games
	//Data set fitting: Training set and expected outputs
	
	//network evolution first attempt
	//1: Create a set of random networks.
	//2: Have every network play against every other. Sum a set of fitness values to determine the network's relative fitness in the population

public abstract class EvolutionHandler {
	
	//BEGIN TRAINING PARAMETERS
	private static final double MAXIMIN_BIAS = 1;
	private static final double MAXIMIN_INPUT = 1; 
	//END TRAINING PARAMETERS
	
	protected ArrayList<Network> currentGeneration;
	protected int generationCount = 0; 
	protected int generationSize;
	protected TrainingSet set; 
	
	
	public EvolutionHandler(int generationSize, TrainingSet set){
		this.set = set; 
		this.generationSize = generationSize; 
		currentGeneration = new ArrayList<Network>();
		
		for(int i = 0; i < generationSize; i++){
			Network trainingSetNetwork = Mutator.randomizeNetworkWeights(set.generateTrainingSetNetwork(), MAXIMIN_BIAS, MAXIMIN_INPUT, 1);
			currentGeneration.add(trainingSetNetwork);
		}
	}
	
	public abstract ArrayList<Network> runEvolution(int numGenerations); //Returns an arrayList of networks representing the current generation after the end of the evolution sequence 
	
	public ArrayList<Network> getCurrentGeneration(){
		return currentGeneration;
	}
	
}
