package projectstructures;

import networking.Client;

public class ClientRegion<K> extends Region<K>{
	Client<?> client;
	public ClientRegion(Domain domain) {
		super(domain);
		client = new Client<Object>();
		
	}

	public void SendHunter(){
		client.start(this.getHunter().getHomeDomain() + 
				"," + this.getHunter().getTargetRegion() + 
				"," + Integer.toString(this.getHunter().getHomeRegion()) + 
				"," + Integer.toString(this.getHunter().getID()) + 
				"," + Integer.toString(this.getHunter().getBounty()));
		this.KillBountyHunter();
	}
}

