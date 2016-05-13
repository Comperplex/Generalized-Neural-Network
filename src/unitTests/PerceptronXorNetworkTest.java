package unitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import networkStructure.PerceptronNetwork;
import networkStructure.PerceptronLayer;


public class PerceptronXorNetworkTest{
	
	
	@Test
	public void test(){
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
  	
  		network.printNetworkStats();
  		
  		checkLGNetwork(false, false, false, network);
  		checkLGNetwork(true, false, true, network);
  		checkLGNetwork(false, true, true, network);
  		checkLGNetwork(true, true, false, network);
	}
	
  	public void checkLGNetwork(boolean input1, boolean input2, boolean expectedOutput, PerceptronNetwork network){ //LG = Logic Gate
  		Boolean[] testInputs = {input1, input2};
  		Boolean networkOutput = (Boolean) network.propagateInput(testInputs)[0];
  		assertEquals(networkOutput, expectedOutput);
  	}
}
