package projectstructures;

import networking.Client;
import networking.Server;

public class ServerRegion<K>  extends Region<K>{
	Server server;
	
	public ServerRegion(Domain domain) {
		super(domain);
		server = new Server();
		// TODO Auto-generated constructor stub
	}

}
