package networking.interpreter;

import projectstructures.BountyHunter;
import networking.Server;

public class Interpreter {

	Server server;
	
	public Interpreter(){
		this.server = new Server();
	}
	
	public BountyHunter setBH(){
		String[] names = new String [5];
		names = server.start().split(",");
		BountyHunter BubbaFet = new BountyHunter(names[0], names[1]);
		BubbaFet.setBounty(Integer.parseInt(names[4]));
		BubbaFet.setID(Integer.parseInt(names[3]));
		BubbaFet.setHomeRegion(Integer.parseInt(names[2]));		
		return BubbaFet;
	}
	

}
