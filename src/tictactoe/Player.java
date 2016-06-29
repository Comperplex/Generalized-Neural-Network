package tictactoe;

import networkStructure.Network;
import networkStructure.PerceptronNetwork;

public class Player {
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
		int[] coords = new int[2];

		
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
					
				}
			case "Human":
				
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
