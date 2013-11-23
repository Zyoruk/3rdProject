package projectstructures;

import networking.Client;

public class ClientRegion<K> extends Region<K>{
	Client client;
	public ClientRegion(Domain domain) {
		super(domain);
		client = new Client();
		
	}

	public void SendHunter(){
		client.start(this.getHunter().getHomeDomain());
		client.start(this.getHunter().getTargetRegion());
		client.start(Integer.toString(this.getHunter().getHomeRegion()));
		client.start(Integer.toString(this.getHunter().getID()));	
		client.start(Integer.toString(this.getHunter().getBounty()));
		this.KillBountyHunter();
	}
}

