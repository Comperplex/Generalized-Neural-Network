package unitTests;

import org.junit.Test;

import networkStructure.NetworkUtils;
import networkStructure.PerceptronNetwork;

public class PerceptronORTest extends PerceptronBooleanLogicTest{

	@Test
	public void test() {
		PerceptronNetwork network = NetworkUtils.orPerceptronNetwork();
		runLogicGateWithExpectedOutputs(false, true, true, true, network);
	}
}
