package networkTraining;

import networkStructure.Network;

public abstract class TrainingSet { //Should this be an interface and not an abstract class?
	//Training set should have some kind of fitness function for the network trainer to call. Make this changable depending on the application
	
	public abstract Network generateTrainingSetNetwork(); //Generates a network that is valid for the particular set being trained
	public abstract double fitnessFunction();
}
