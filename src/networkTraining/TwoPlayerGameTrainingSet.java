package networkTraining;

import networkStructure.Network;

public interface TwoPlayerGameTrainingSet extends TrainingSet{
	
	//This class adds the extra functionality of being able to call a method that plays two networks against each other. 
	public abstract void playTrainingGame(Network pANet, Network pBNet, int generationSize);
}
