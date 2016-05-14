package unitTests;

import org.junit.Test;

import networkStructure.NetworkUtils;
import networkStructure.PerceptronNetwork;


public class PerceptronXorNetworkTest extends PerceptronBooleanLogicTest {
	
	
	@Test
	public void test(){
  		PerceptronNetwork network = NetworkUtils.xorNetwork();
  		runLogicGateWithExpectedOutputs(false, true, true, false, network);
	}
	
  
}
