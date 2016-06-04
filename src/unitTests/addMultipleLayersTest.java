package unitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import networkStructure.PerceptronNetwork;

public class addMultipleLayersTest {
	@Test
	public void test(){
		PerceptronNetwork pNetwork = new PerceptronNetwork(2);
		pNetwork.addMultipleSimilarLayers(3, 5);
		assertEquals(pNetwork.getAllLayers().size(), 4);
		assertEquals(pNetwork.getNumOutputs(), 5);
		assertEquals(pNetwork.getAllLayers().get(0).getNumOutputs(), 2);
	}
}
