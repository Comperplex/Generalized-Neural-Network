package networkStructure;

public abstract class Layer {
	protected int numInputs; 
	protected int numOutputs; 
	
	public abstract Object[] propagateInput(Object[] input);
	
	public int getNumOutputs(){
		return numOutputs;
	}
	
	public int getNumInputs(){
		return numInputs;
	}
}
