package io;

import networkStructure.NetworkUtils;
import networkStructure.PerceptronLayer;
import networkStructure.PerceptronNetwork;

public class Main {
	public static void main(String[] args){
//		FileIO fileIO = new FileIO();
//		fileIO.createNewFile("D:\\Programming\\JavaStuff\\Generalized Neural Network\\res\\testFile.txt");
//		Layer layer = new Layer(3, 3);
//		boolean[] layerTestInputs = new boolean[3];
//		boolean[] layerTestOutputs = new boolean[3];
//		
//		for(int i = 0; i < 3; i++){
//			layerTestInputs[i] = true;
//			for(int j = 0; j < 3; j++){
//				layer.setInputWeightAtLocation(i, j, 1);
//			}
//		}
//		
//		layerTestOutputs = layer.propageteInput(layerTestInputs);
//		for(boolean b : layerTestOutputs){
//			System.out.println(b);
//		}
		
//		Layer norGate = new Layer(2, 1);
//		boolean[] norInput = new boolean[2];
//		norInput[0] = true;
//		norInput[1] = true;
//		
//		boolean[] norOutput = new boolean[1];
//		norGate.setInputWeightAtLocation(0, 0, -0.5);
//		norGate.setInputWeightAtLocation(1, 0, -0.5);
//		norGate.setBiasWeightAtLocation(0, 1.1);
//		
//		norOutput = norGate.propageteInput(norInput);
//		System.out.println(norOutput[0]);
		
//		PerceptronNetwork network = new PerceptronNetwork(2);
//		network.addLayer(2);
//		network.addLayer(1);
//		network.addLayer(1);
//		PerceptronLayer layer1 = (PerceptronLayer) network.getAllLayers().get(1);
//		PerceptronLayer layer2 = (PerceptronLayer) network.getAllLayers().get(2);
//		PerceptronLayer layer3 = (PerceptronLayer) network.getAllLayers().get(3);
//		
//		layer1.setBiasWeightAtLocation(0, -0.5);
//		layer1.setBiasWeightAtLocation(1, 1); 
//		
//		layer1.setInputWeightAtLocation(0, 0, 0.5);
//		layer1.setInputWeightAtLocation(0, 1, -0.6);
//		
//		layer1.setInputWeightAtLocation(1, 0, 0.5);
//		layer1.setInputWeightAtLocation(1, 1, -0.6);
//		
//		layer2.setInputWeightAtLocation(0, 0, 0.5);
//		layer2.setInputWeightAtLocation(1, 0, 0.5);
//		
//		layer3.setBiasWeightAtLocation(0, 0.5);
//		layer3.setInputWeightAtLocation(0, 0, -0.1);
//	
//		network.printNetworkStats();
//		
//		Boolean[] networkInputs = new Boolean[2];
//		
//		networkInputs[0] = true;
//		networkInputs[1] = false;
//		
//		Object[] networkOutputs = network.propagateInput(networkInputs);
//		
//		for(Object o: networkOutputs){
//			System.out.println("Network result: " + o);
//		}
		
		PerceptronNetwork network = NetworkUtils.xorNetwork();
		network.addNetworkAsLayer(NetworkUtils.inverterPerceptronNetwork());
		network.addNetworkAsLayer(NetworkUtils.inverterPerceptronNetwork());
		network.addNetworkAsLayer(NetworkUtils.inverterPerceptronNetwork());
		network.addNetworkAsLayer(NetworkUtils.inverterPerceptronNetwork());
		network.addNetworkAsLayer(NetworkUtils.inverterPerceptronNetwork());
		NetworkUtils.printAllPossiblePerceptronIOStates(network);
	}
}
