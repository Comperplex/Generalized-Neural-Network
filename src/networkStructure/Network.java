package networkStructure;

import java.util.ArrayList;
import java.util.List;

public abstract class Network extends Layer {
	
	protected List<Layer> layers;
	protected int previousLayerOutputs;
	
	public Network(int numInputs){
		this.numInputs = numInputs; 
		layers = new ArrayList<Layer>();
	}

	@Override
	public Object[] propagateInput(Object[] networkInputs){
		Object[] layerOutputs = layers.get(0).propagateInput(networkInputs);
		for(int i = 1; i < layers.size(); i++){ //i = 1 because the first layer was already propagated
			System.out.println("Propagating layer " + i);	
			layerOutputs = layers.get(i).propagateInput(layerOutputs);
		}
		return layerOutputs;
	}
	
	public void addLayer(int numOutputs){
		previousLayerOutputs = layers.get(layers.size() - 1).getNumOutputs(); //Minus 1 here because layers.size() starts at 1 but the collection indexing system starts at 0
		this.numOutputs = numOutputs;
	}
	
	public void addNetworkAsLayer(Network network){
		//FIXME Add protection so that the wrong type of network isn't added by mistake
		layers.add(network);
		this.numOutputs = network.getNumOutputs();
	}
	
	public List<Layer> getAllLayers(){
		return layers; 
	}

}
