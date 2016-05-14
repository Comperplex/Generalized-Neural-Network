package unitTests;

import org.junit.Test;
import static org.junit.Assert.*;

import networkStructure.NetworkUtils;
import networkStructure.PerceptronNetwork;

public class PerceptronInverterTest {
	
	@Test
	public void test(){
		PerceptronNetwork pNetwork = NetworkUtils.inverterPerceptronNetwork();
		Boolean[] networkInput = {false};
		Boolean expectedNetworkOutput = true;
		Boolean networkOutput = ((Boolean[]) pNetwork.propagateInput(networkInput))[0];
		assertEquals(expectedNetworkOutput, networkOutput);
		
		networkInput[0] = true;
		expectedNetworkOutput = false;
		networkOutput = ((Boolean[]) pNetwork.propagateInput(networkInput))[0];
		assertEquals(expectedNetworkOutput, networkOutput);
	}
}
