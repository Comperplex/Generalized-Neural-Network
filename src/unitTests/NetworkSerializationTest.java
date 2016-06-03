package unitTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import io.FileIO;
import networkStructure.Network;
import networkStructure.NetworkUtils;

public class NetworkSerializationTest {
	
	@Test
	public void testNetworkSerialization(){
		
		//String path = String.format("%s/%s", System.getProperty("user.dir"), this.getClass().getPackage().getName().replace(".", "/"));
		//System.out.println(path); //This prints out the working directory of this class
		
		Network networkSaveTest = NetworkUtils.xorNetwork();
		FileIO.saveNetwork(networkSaveTest, "./res/SerializationTest.ser"); //The dot before the /res I think tells it to look a level up in the folder hierarchy.
		
		Network networkLoadTest = FileIO.loadNetwork("./res/SerializationTest.ser");
		assertEquals(networkSaveTest.toString(), networkLoadTest.toString());
	}
}
