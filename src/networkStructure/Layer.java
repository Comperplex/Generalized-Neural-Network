package networkStructure;

public abstract class Layer {
	protected int numInputs; 
	protected int numOutputs;
	
	protected double[][] inputWeights; 
	protected double[] biasWeights;
	
	public Layer(int numInputs, int numOutputs){
		this.numInputs = numInputs;
		this.numOutputs = numOutputs;
		inputWeights = new double[numInputs][numOutputs];
		biasWeights = new double[numOutputs];
	}
	
	public abstract Object[] propagateInput(Object[] input);
	
	public void setInputWeightAtLocation(int inputIndex, int outputIndex, double weightValue){
		if(inputIndex < 0 || inputIndex > numInputs || outputIndex < 0 || outputIndex > numOutputs){
			System.out.println("Invalid location for input weight set");
		} else{
			inputWeights[inputIndex][outputIndex] = weightValue;
		}
	}
	
	public void setBiasWeightAtLocation(int outputIndex, double weightValue){
		if(outputIndex < 0 || outputIndex > numOutputs){
			System.out.println("Invalid location for bias weight set");
		} else{
			biasWeights[outputIndex] = weightValue;
		}
	}
	
	public int getNumOutputs(){
		return numOutputs;
	}
	
	public int getNumInputs(){
		return numInputs;
	}
	
	public int getNumWeights(){
		return numOutputs * (1 + numInputs); //TODO check that this equals the size of the inputWeights array plus the size of the biasWeights array
	}
}
