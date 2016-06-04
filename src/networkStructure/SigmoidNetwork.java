package networkStructure;

public class SigmoidNetwork extends Network {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SigmoidNetwork(int numInputs) {
		super(numInputs);
		for(int i = 0; i < numInputs; i++){
			((SigmoidLayer) layers.get(0)).setInputWeightAtLocation(i, i, 1); //weight is 0 because this causes sigmoid function to output 1
			//FIXME The behavior for the input to the sigmoid network may have to be different. The sigmoid function should NOT be applied directly to the inputs
		}
	}

	@Override
	public void addNetworkAsLayer(Network network) {
		if(network instanceof SigmoidNetwork){
			layers.add(network);
			this.numOutputs = network.getNumOutputs();
		} else{
			System.out.println("Error: Tried adding an invalid network type to a SigmoidNetwork");
		}
	}
}
