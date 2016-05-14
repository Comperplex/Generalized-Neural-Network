package unitTests;

import static org.junit.Assert.assertEquals;

import networkStructure.PerceptronNetwork;

public abstract class PerceptronBooleanLogicTest {
	
	public abstract void test();
	
	public void runLogicGateWithExpectedOutputs(boolean caseFF, boolean caseTF, boolean caseFT, boolean caseTT, PerceptronNetwork network){
		checkLGNetwork(false, false, caseFF, network);
  		checkLGNetwork(true, false, caseTF, network);
  		checkLGNetwork(false, true, caseFT, network);
  		checkLGNetwork(true, true, caseTT, network);
	}
	
	public void checkLGNetwork(boolean input1, boolean input2, boolean expectedOutput, PerceptronNetwork network){ //LG = Logic Gate
  		Boolean[] testInputs = {input1, input2};
  		Boolean networkOutput = (Boolean) network.propagateInput(testInputs)[0];
  		assertEquals(networkOutput, expectedOutput);
  	}

}
