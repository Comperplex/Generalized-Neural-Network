package networkStructure;

import java.util.ArrayList;
import java.util.List;

public abstract class Network extends Layer {
	
	protected List<Layer> layers;
	protected int previousLayerOutputs; //TODO this may be redundant. All the information necessary to add a new layer is contained within layers
	protected String networkName;
	protected double fitnessValue; 
	
	public abstract void addNetworkAsLayer(Network network);
	
	public Network(int numInputs){
		super(numInputs, 0); //FIXME It makes no sense for the Layer constructor which super calls to establish a set of weights for the network itself
		layers = new ArrayList<Layer>();
	}

	@Override
	public Object[] propagateInput(Object[] networkInputs){
		Object[] layerOutputs = layers.get(0).propagateInput(networkInputs);
		for(int i = 1; i < layers.size(); i++){ //i = 1 because the first layer was already propagated
			//System.out.println("Propagating layer " + i);	
			layerOutputs = layers.get(i).propagateInput(layerOutputs);
		}
		return layerOutputs;
	}
	
	public void addLayer(int numOutputs){
		previousLayerOutputs = layers.get(layers.size() - 1).getNumOutputs(); //Minus 1 here because layers.size() starts at 1 but the collection indexing system starts at 0
		this.numOutputs = numOutputs;
	}
	
	public void addMultipleSimilarLayers(int numNewLayers, int numOutputsPerLayer){
		for(int i = 0; i < numNewLayers; i++){
			addLayer(numOutputsPerLayer);
		}
	}
	
	public List<Layer> getAllLayers(){
		return layers; 
	}
	
	public void printNetworkStats(){
		int loopIterator = 0;
		for(Layer l: layers){
			System.out.println("For layer: " + loopIterator);
			System.out.println("Num inputs: " + l.getNumInputs() + " Num outputs: " + l.getNumOutputs());
			loopIterator++;
		}
	}
	
	@Override
	public int getNumWeights(){
		int weights = 0;
		for(Layer l: layers){
			weights += l.getNumWeights();
		}
		return weights; 
	}
	
	@Override
	public String toString(){
		String networkString = null; 
		for(Layer l : layers){
			networkString += layers.toString();
		}
		
		return networkString;
	}
	
	public String getNetworkName() {
		return networkName;
	}

	public void setNetworkName(String networkName) {
		this.networkName = networkName;
	}

	public double getFitnessValue() {
		return fitnessValue;
	}

	public void setFitnessValue(double fitnessValue) {
		this.fitnessValue = fitnessValue;
	}

}
