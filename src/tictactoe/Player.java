package tictactoe;

import networkStructure.Network;
import networkStructure.PerceptronNetwork;

public class Player {
	private GameObject playerObject;
	private String playerType;
	private PerceptronNetwork network;
	
	private int testCount = 0; //Used for testing the runTurn class
	
	public Player(GameObject playerObject, String playerType){
		this.playerType = playerType; 
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
								networkInputs[(i + 1) + 3 * (j+ 1)] = true;
							} else if(board[i][j] == GameObject.O){
								networkInputs[(i + 1) + 3 * (j+ 1) + 9] = true;
							}
						}
					}
					
					Boolean[] networkOutputs = (Boolean[]) network.propagateInput(networkInputs);
					
				}
			case "Human":
			case "Test":
				
				testCount++;
				int[] testCoords = new int[2];
				
				switch(testCount){
					case 0: 
						testCoords[0] = 0;
						testCoords[1] = 0;
						;
					case 1: 
						testCoords[0] = 1; 
						testCoords[1] = 0;
				}
				
				return testCoords;
				
				
			default:
		}
		
		return coords;
	}
	
	public void setNetwork(PerceptronNetwork network){
		this.network = network; 
	}
	
	public void setPlayerType(String playerType){
		this.playerType = playerType;
	}
	
	
}
