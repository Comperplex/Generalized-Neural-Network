package unitTests;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;
import org.junit.Assert;

import org.junit.Test;
import org.mockito.Mockito;

import networkStructure.PerceptronNetwork;
import tictactoe.GameObject;
import tictactoe.Player;

public class PlayerTestNextCoordsNetworkTest {

	@Test
	public void test() {
		//Basic maths stuff
//		Boolean[] testNetworkInputs = new Boolean[19];
//		
//		for(int i = 0; i < 3; i++){ 
//			for(int j = 0; j < 3; j++){
//				System.out.println((j + 1) + (3 * i));
//				System.out.println((j + 1) + (3 * i) + 9);
//				testNetworkInputs[(j + 1) + (3 * i)] = true;
//				testNetworkInputs[(j + 1) + (3 * i) + 9] = true;
//			}
//		}
		
//		for(int i = 0; i < 9; i++){
//			System.out.println(i % 3);
//			System.out.println((i - (i % 3)) / 3);
//		}
		
		PerceptronNetwork networkMock = Mockito.mock(PerceptronNetwork.class);
		Player player = new Player(GameObject.X, networkMock);
		
		Boolean[] networkOutput = new Boolean[9];
		int[] expectedOutput = new int[2];
		
		for(int i = 0; i < 9; i++){
			networkOutput[i] = false; 
		}
		
		for(int j = 0; j < 9; j++){
			if(j > 0){
				networkOutput[j - 1] = false; 
			} 
			networkOutput[j] = true;
			
	 		when(networkMock.propagateInput(anyObject())).thenReturn(networkOutput);
	 		
	 		
	 		switch(j){ //Here I'm manually entering these expected values because it's more reliable than using the same function that I'm supposed to be testing to generate them
	 			case 0: expectedOutput[0] = 0; expectedOutput[1] = 0; break;
	 			case 1: expectedOutput[0] = 1; expectedOutput[1] = 0; break;
	 			case 2: expectedOutput[0] = 2; expectedOutput[1] = 0; break;
	 			case 3: expectedOutput[0] = 0; expectedOutput[1] = 1; break;
	 			case 4: expectedOutput[0] = 1; expectedOutput[1] = 1; break;
	 			case 5: expectedOutput[0] = 2; expectedOutput[1] = 1; break;
	 			case 6: expectedOutput[0] = 0; expectedOutput[1] = 2; break;
	 			case 7: expectedOutput[0] = 1; expectedOutput[1] = 2; break;
	 			case 8: expectedOutput[0] = 2; expectedOutput[1] = 2; break;
	 		}
	 		
	 		Assert.assertArrayEquals(player.getNextCoords(new GameObject[3][3]), expectedOutput); //Makes sure the player class outputs the correct values for each possible VALID network output
		}
		
		networkOutput[0] = true;
		networkOutput[8] = true;
		
		when(networkMock.propagateInput(anyObject())).thenReturn(networkOutput);
		
		expectedOutput[0] = -1; 
		expectedOutput[1] = -1;
		
		Assert.assertArrayEquals(player.getNextCoords(new GameObject[3][3]), expectedOutput); //Making sure that an invalid network output will cause the player class to output -1 for both coords
	}
}
