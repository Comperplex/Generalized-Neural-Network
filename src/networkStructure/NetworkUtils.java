package networkStructure;

public class NetworkUtils {
	
	public static PerceptronNetwork inverterPerceptronNetwork(){
		PerceptronNetwork network = new PerceptronNetwork(1);
		network.addLayer(1);
		PerceptronLayer layer1 = ((PerceptronLayer) network.getAllLayers().get(1));
		layer1.setBiasWeightAtLocation(0, 1);
		layer1.setInputWeightAtLocation(0, 0,  -1);
		
		return network;
	}
	
	public static PerceptronNetwork orPerceptronNetwork(){
		PerceptronNetwork network = new PerceptronNetwork(2);
		network.addLayer(1);
		PerceptronLayer layer1 = ((PerceptronLayer) network.getAllLayers().get(1));
		layer1.setInputWeightAtLocation(0, 0, 1);
		layer1.setInputWeightAtLocation(1, 0, 1);
		
		return network;
	}
	
	public static PerceptronNetwork xorNetwork(){
		PerceptronNetwork network = new PerceptronNetwork(2);
  		network.addLayer(2);
  		network.addLayer(1);
  		network.addLayer(1);
  		PerceptronLayer layer1 = (PerceptronLayer) network.getAllLayers().get(1);
		PerceptronLayer layer2 = (PerceptronLayer) network.getAllLayers().get(2);
		PerceptronLayer layer3 = (PerceptronLayer) network.getAllLayers().get(3);
  		
  		layer1.setBiasWeightAtLocation(0, -0.5);
  		layer1.setBiasWeightAtLocation(1, 1); 
  		
  		layer1.setInputWeightAtLocation(0, 0, 0.5);
  		layer1.setInputWeightAtLocation(0, 1, -0.6);
  		
  		layer1.setInputWeightAtLocation(1, 0, 0.5);
  		layer1.setInputWeightAtLocation(1, 1, -0.6);
  		
  		layer2.setInputWeightAtLocation(0, 0, 0.5);
  		layer2.setInputWeightAtLocation(1, 0, 0.5);
  		
  		layer3.setBiasWeightAtLocation(0, 0.5);
  		layer3.setInputWeightAtLocation(0, 0, -0.1);
  		
  		return network; 
	}
	
	public static void printAllPossiblePerceptronIOStates(PerceptronNetwork network){
		
		int numInputs = network.getNumInputs();
		int numPossibleInputs = (int) Math.pow(2, numInputs);
		int numOutputs = network.getNumOutputs();
		
		Boolean[] bits = new Boolean[numInputs];
	    
		for(int i = 0; i < numPossibleInputs; i++){
			
			System.out.println("For network input: ");
			for (int j = numInputs - 1; j >= 0; j--) {
		        bits[j] = (i & (1 << j)) != 0; //Creates a boolean array of length numInputs that represents the binary value of i 
		        System.out.println(bits[j]);
		    }
			
			Boolean[] networkOutput = (Boolean[]) network.propagateInput(bits);
			
			System.out.println("The network output is: ");
			for(Boolean b: networkOutput){
				System.out.println(b + "\n");
			}
		}
	}
}
