package networkStructure;

public class PerceptronLayer extends Layer {
	private static final double FIRING_THRESHOLD = 0.5; 
	
	public PerceptronLayer(int numInputs, int numOutputs){
		super(numInputs, numOutputs);
	}
	
	@Override
	public Boolean[] propagateInput(Object[] input){
		
		if(!(input instanceof Boolean[])){
			System.out.println("Input to perceptron layer is not an array of booleans");
			return null; 
		}
		
		Boolean[] output = new Boolean[numOutputs];
		if(input.length == numInputs){
			for(int i = 0; i < numOutputs; i++){
				double weightSum = 0;
				for(int j = 0; j < numInputs; j++){
					if((Boolean) input[j]){
						weightSum += inputWeights[j][i];
					}
				}
				weightSum += biasWeights[i];
				output[i] = weightSum >= FIRING_THRESHOLD;
				//System.out.println("weightSum is: " + weightSum);
			}
			return output;
		} else{
			System.out.println("Invalid number of inputs in layer. Expected: " + numInputs + " got " + input.length);
			return null;
		}
	}
	
	public static double getFiringThreshold() {
		return FIRING_THRESHOLD;
	}
}
