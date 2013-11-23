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

	public void start(String hunter){
		try{
			//Connect to server ip connection on a specific port
			client = new Socket(ip, port);
			System.out.println("Connecting...");

			//Establish object used to store answer from server
			input = new BufferedReader
					(new InputStreamReader(client.getInputStream()));
			
			//Establish ongoing stream
			output = new PrintStream(client.getOutputStream());
			
			System.out.println("Sending Data...");
			//send request to server
			output.println(hunter);
			
			String response = input.readLine();
			
			System.out.println(response);
			
			
			input.close();
			output.close();
			client.close();	
			System.out.println("Disconnecting...");
			
		} catch(Exception e){}
		
	}
	
}
