package networkStructure;

public class PerceptronNetwork extends Network {
	
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
}
