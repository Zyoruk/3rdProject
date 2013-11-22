package projectstructures;

import networking.Client;

public class ClientRegion<K> extends Region<K>{
	Client client;
	public ClientRegion(Domain domain) {
		super(domain);
		client = new Client();
		// TODO Auto-generated constructor stub
	}

	}

