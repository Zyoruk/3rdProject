package networking;

import java.net.*;
import java.io.*;

import setup.Constants;

public class Client {
	
	Socket client;		//Creates communication tunnel
	int port = 61000;	//Selects a port
	String ip = Constants.SERVER_IP;	//Sets ip to connect to
	BufferedReader input;	//Stream used as input
	PrintStream output;	//Stream used as output

	public void start(){
		try{
			//Connect to server ip connection on a specific port
			client = new Socket(ip, port);

			//Establish object used to store answer from server
			input = new BufferedReader
					(new InputStreamReader(client.getInputStream()));
			
			//Establish ongoing stream
			output = new PrintStream(client.getOutputStream());
			//send request to server
			output.println("hunter");
			
			String response = input.readLine();
			
			
			input.close();
			output.close();
			client.close();			
			
		} catch(Exception e){}
	}
	
}
