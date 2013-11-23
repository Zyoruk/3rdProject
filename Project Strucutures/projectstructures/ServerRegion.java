package projectstructures;

import networking.Client;
import networking.Server;

public class ServerRegion<K>  extends Region<K>{
	Server server;
	Domain domain;
	public ServerRegion(Domain pDomain) {
		super(pDomain);
		this.domain = pDomain;
		server = new Server();
		// TODO Auto-generated constructor stub
	}
	
	public void receiveHunter(){
		BountyHunter Hunter = new BountyHunter(this.domain , this);
		this.setBountyHunter(Hunter);
		this.getHunter().setHomeDomain(server.start());
		this.getHunter().setTargetRegion(server.start());
		this.getHunter().setHomeRegion(Integer.parseInt(server.start()));
		this.getHunter().setID(Integer.parseInt(server.start()));
		this.getHunter().setBounty(Integer.parseInt(server.start()));
	}
}
