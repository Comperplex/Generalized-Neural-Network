package networkStructure;

public class SigmoidLayer extends Layer {
	
	private double[][] inputWeights;
	private double[] biasWeights;
	
	@Override
	public Double[] propagateInput(Object[] input) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void setInputWeightAtLocation(int inputIndex, int outputIndex, double weightValue){
		if(inputIndex < 0 || inputIndex > numInputs || outputIndex < 0 || outputIndex > numOutputs){
			System.out.println("Invalid location for input weight set");
		} else{
			inputWeights[inputIndex][outputIndex] = weightValue;
		}
	}

}
