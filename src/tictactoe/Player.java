package tictactoe;

import networkStructure.Network;
import networkStructure.PerceptronNetwork;

public class Player { //TODO it might be nice to have a perceptron Player and a Sigmoid player. Both would have to extend an abstract player class
	private GameObject playerObject;
	private String playerType;
	private PerceptronNetwork network;
	
	public Player(GameObject playerObject, PerceptronNetwork network){
		playerType = "Network";
		this.playerObject = playerObject; 
		this.network = network; 
	}
	
	public Player(GameObject playerObject){
		playerType = "Human";
		this.playerObject = playerObject;
	}
	
	public int[] getNextCoords(GameObject[][] board){
		int[] coords = new int[2]; //coords[0] is xLoc, coords[1] is yLoc
		
		switch(playerType){
			case "Network":
				if(network != null){
					Boolean[] networkInputs = new Boolean[19]; //creating the input feed for the network
					networkInputs[0] = playerObject == GameObject.X;
					
					for(int i = 0; i < 3; i++){ //Should cycle through all 9 of the possible cases here. It assigns each respective network input a value based on the board. 
						for(int j = 0; j < 3; j++){
							if(board[i][j] == GameObject.X){
								networkInputs[(j + 1) + (3 * i)] = true;
							} else if(board[i][j] == GameObject.O){
								networkInputs[(j + 1) + (3 * i) + 9] = true;
							}
						}
					}
					
					Boolean[] networkOutputs = (Boolean[]) network.propagateInput(networkInputs);
					
					if(networkOutputs.length == 9){ //just in case...
						
						int outputCount = 0;
						int locationOfOutput = 0; 
						//TODO it may be more efficient to have the network output in binary instead? Or maybe just pick the first output if it outputs more than one
						
						for(int i = 0; i < 9; i++){
							if(networkOutputs[i]){
								outputCount++;
								locationOfOutput = i;
							}
						}
						
						if(outputCount == 1){
							coords[0] = locationOfOutput % 3; //Mod 3 should give the x coord of the output
							coords[1] = (locationOfOutput - coords[0]) / 3;
						} else{
							coords[0] = -1; //Causes the turn to fail for the network
							coords[1] = -1; //Causes the turn to fail for the network
						}
					}
				}
			case "Human":
				//TODO Add human input parsing here
				
			default: break;
		}
		
		return coords;
	}
	
	public void setNetwork(PerceptronNetwork network){
		this.network = network; 
	}
	
	public Network getNetwork(){
		return network;
	}
	
	public void setPlayerType(String playerType){
		this.playerType = playerType;
	}
	
	
}
