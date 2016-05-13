package networkStructure;

public class NetworkUtils {
	
	public static PerceptronNetwork inverterPerceptronNetwork(){
		PerceptronNetwork network = new PerceptronNetwork(1);
		network.addLayer(1);
		
		
		return network;
	}
	
	public static PerceptronNetwork orGatePerceptronNetwork(){
		PerceptronNetwork network = new PerceptronNetwork(2);
		
		return network;
	}
}
