package networkStructure;

import java.util.ArrayList;
import java.util.List;

public class Network extends Layer {
	private List<PerceptronLayer> layers; 
	private int numInputs;
	
	public Network(int numInputs){
		this.numInputs = numInputs;
		layers = new ArrayList<PerceptronLayer>();
		layers.add(new PerceptronLayer(numInputs, numInputs));
		
		for(int i = 0; i < numInputs; i++){
			layers.get(0).setInputWeightAtLocation(i, i, PerceptronLayer.getFiringThreshold()); //Sets up input layer by creating a direct connection from input to output at firing threshold
		}
	}
	
	public void addLayer(int numOutputs){
		int previousLayerOutputs = layers.get(layers.size() - 1).getNumOutputs(); //Minus 1 here because layers.size() starts at 1 but the collection indexing system starts at 0
		layers.add(new PerceptronLayer(previousLayerOutputs, numOutputs));
	}
	
	public boolean[] runNetwork(boolean[] networkInputs){
		boolean[] layerOutputs = layers.get(0).propageteInput(networkInputs);
		for(int i = 1; i < layers.size(); i++){ //i = 1 because the first layer was already propagated
			System.out.println("Propagating layer " + i);	
			layerOutputs = layers.get(i).propageteInput(layerOutputs);
			for(boolean b: layerOutputs){
				System.out.println(b);
			}
		}
		return layerOutputs;
	}
	
	public PerceptronLayer getLayer(int layerIndex){
		PerceptronLayer layer = layers.get(layerIndex);
		return layer;
	}
	
	public void printNetworkStats(){
		int loopIterator = 0;
		for(PerceptronLayer l: layers){
			System.out.println("For layer: " + loopIterator);
			System.out.println("Num inputs: " + l.getNumInputs() + " Num outputs: " + l.getNumOutputs());
			loopIterator++;
		}
	}
}
