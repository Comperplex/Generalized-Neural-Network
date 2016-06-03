package networkStructure;

public class PerceptronNetwork extends Network {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double fitnessValue; 
	
	public PerceptronNetwork(int numInputs){
		super(numInputs);
		layers.add(new PerceptronLayer(numInputs, numInputs));
		for(int i = 0; i < numInputs; i++){
			((PerceptronLayer) layers.get(0)).setInputWeightAtLocation(i, i, PerceptronLayer.getFiringThreshold()); //Sets up input layer by creating a direct connection from input to output at firing threshold
		}
	}
	
	@Override
	public void addLayer(int numOutputs){
		super.addLayer(numOutputs);
		layers.add(new PerceptronLayer(previousLayerOutputs, numOutputs));
	}

	public double getFitnessValue() {
		return fitnessValue;
	}

	public void setFitnessValue(double fitnessValue) {
		this.fitnessValue = fitnessValue;
	}
}
