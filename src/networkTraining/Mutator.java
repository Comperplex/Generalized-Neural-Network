package networkTraining;

import java.util.Random;

import networkStructure.Layer;
import networkStructure.Network;

public class Mutator {
	
	private static Random random = new Random();
	private static final double MUTATION_FREQUENCY_CONSTANT = 0.125;
	
	public static Network randomizeNetworkWeights(Network network, double maxIMinBias, double maxIMinInput, double mutationFrequency){
		int numPossibleMutations = network.getNumWeights(); //TODO implement mutation frequency scaling with size of network
		int numActualMutations = 0;
		System.out.println("Num Possible Mutations: " + numPossibleMutations);
		
		for(Layer l: network.getAllLayers()){
			for(int i = 0; i < l.getNumOutputs(); i++){
				for(int j = 0; j < l.getNumInputs(); j++){
					if(randomInRange(0, 1) < mutationFrequency){
						l.setInputWeightAtLocation(j, i, randomInRange(-maxIMinInput, maxIMinInput));
						numActualMutations++;
					}
				}
				if(randomInRange(0, 1) < mutationFrequency){
					l.setBiasWeightAtLocation(i, randomInRange(-maxIMinBias, maxIMinBias));
					numActualMutations++;
				}
			}
		}
		
		System.out.println("Num Actual Mutations: " + numActualMutations);
		return network; 
	}
	
	private static double randomInRange(double min, double max) { //TODO make sure this function doesn't start repeating itself. That could cause bad problems
	  double range = max - min;
	  double scaled = random.nextDouble() * range;
	  double shifted = scaled + min;
	  
	  return shifted; 
	}
	
	public static Network[] networkAsexualReproduction(Network network, int numChildren){
		Network[] children = new Network[numChildren];
		for(Network n: children){
			randomizeNetworkWeights(n, 1, 1, MUTATION_FREQUENCY_CONSTANT); 
		}
		return children; 
	}
}
