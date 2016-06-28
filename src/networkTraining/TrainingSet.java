package networkTraining;

import networkStructure.Network;

public interface TrainingSet { //The purpose of the training set is to act as a game-specific interface for the EvolutionHandler. Each training set handles one network at a time.
	//Training set should have some kind of fitness function for the network trainer to call. Make this changable depending on the application
	
	public abstract Network generateTrainingSetNetwork(); //Generates a network that is valid for the particular set being trained
	public abstract double fitnessFunction(); //The fitness function method should return a double value based on the fitness of a network the set is handling
}
