package networking;

import java.net.*;
import java.io.*;

public class Server {

	ServerSocket server;	//Creates server
	Socket sockets;		//Creates communication tunnel
	int port = 61000;	//Selects a port
	DataOutputStream output;	//Stream to use as output
	BufferedReader input;	//Stream used as input

	public String start(){
		try{
			server = new ServerSocket(port);	//Inits server on a specific port
			sockets = new Socket();		
			sockets = server.accept();	//On that tunnel accept requests
			
			//From tunnel get stream
			input = new BufferedReader(new InputStreamReader(sockets.
															 getInputStream()));
			//read data and stores it for decisions.
			String request = input.readLine();
			
			//Answer from the server
			output = new DataOutputStream(sockets.getOutputStream());
			output.writeUTF("Data Received ...");
			sockets.close();
			return request;
			
		} catch(Exception e){return null;}
		
	}
	
}
