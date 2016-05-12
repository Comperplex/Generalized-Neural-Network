package unitTesting;

import org.junit.Test;

import networkStructure.Network;
import networkStructure.PerceptronLayer;


public class XorNetworkTest{
	
	@Test
	public void testXorNetwork(){
		Network network = new Network(2);
		network.addLayer(2);
		network.addLayer(1);
		network.addLayer(1);
		PerceptronLayer layer1 = network.getLayer(1);
		PerceptronLayer layer2 = network.getLayer(2);
		PerceptronLayer layer3 = network.getLayer(3);
		
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
	
		network.printNetworkStats();
		
		boolean[] networkInputs = new boolean[2];
		
		networkInputs[0] = false;
		networkInputs[1] = false;
		
		boolean[] networkOutputs = network.runNetwork(networkInputs);
		
		for(boolean b: networkOutputs){
			System.out.println("Network result: " + b);
		}
	}
}
