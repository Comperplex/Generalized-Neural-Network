package networkTraining;

import networkStructure.Network;

public abstract class TrainingSet {
	//Training set should have some kind of fitness function for the network trainer to call. Make this changable depending on the application
	
	public abstract Network generateTrainingSetNetwork();
}
