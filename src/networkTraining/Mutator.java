package networkTraining;

import java.util.Random;

import networkStructure.Layer;
import networkStructure.Network;

public class Mutator {
	
	private static Random random = new Random();
	
	public Network randomizeNetworkWeights(Network network, double maxIMinBias, double maxIMinInput){
		for(Layer l: network.getAllLayers()){
			for(int i = 0; i < l.getNumOutputs(); i++){
				for(int j = 0; j < l.getNumInputs(); j++){
					l.setInputWeightAtLocation(j, i, randomInRange(-maxIMinInput, maxIMinInput));
				}
				l.setBiasWeightAtLocation(i, randomInRange(-maxIMinBias, maxIMinBias));
			}
		}
		
		return network; 
	}
	
	public static double randomInRange(double min, double max) {
	  double range = max - min;
	  double scaled = random.nextDouble() * range;
	  double shifted = scaled + min;
	  
	  return shifted; 
	}
}
