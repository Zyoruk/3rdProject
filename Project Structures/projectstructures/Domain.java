package projectstructures;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

import datastructs.graphs.Graph;

/**
 * @author zyoruk, jeukel
 * A domain is a computer which contains several regions. It extends from the
 * graph data structure. This will send several messages to bounty hunters and
 * create them, as well.
 */
public class Domain<K> extends Graph<K> {

	private static String IP;
	private boolean _Halt;
	private BountyHunter _MyBountyHunter;
	private int _MyCurrentPoints;

	/**
	 * The constructor will initialize the variables and set the Domain's IP
	 * using the current machine IP.
	 */
	public Domain(){
		super();
		this._Halt = false;
		this._MyCurrentPoints= 0;
		try {
			Domain.IP = this.setIp();
		} catch (SocketException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This will make every bounty hunter to send their carried points to the
	 * home domain.
	 */
	public void askForBountyPoints(){
		this._MyCurrentPoints = this._MyBountyHunter.returnPoints();
		this.client.start("return points");
	}

	/**
	 * Creates a new BountyHunter, cannot do it directly into a foreign domain.
	 * @param pWhereToBeCreated is the region to create the bounty hunter.
	 */	
	public void createbountyHunter(Region<?> pWhereToBeCreated){
		this._MyBountyHunter = new BountyHunter(this , pWhereToBeCreated);
	}

	/**
	 * Each Domain will be able to send a "Halt" message which means that the 
	 * domain wants to end the game. Then, every single bounty hunter must
	 * return to their respective home domain. This method receives the message
	 * and do the respective operations.
	 * @param pHaltMessage it is a boolean.
	 */
	public void endBountyRecollection(boolean pHaltMessage){
		this.client.start("halt");
	}

	/**
	 * We will need to do stuff with the bounty hunter
	 * @return BountyHunter
	 */
	public BountyHunter getBountyHunter(){
		return this._MyBountyHunter;
	}

	/**
	 * This gets the current Domain's IP.
	 * @return Domain's IP
	 */
	public String getIP(){
		return Domain.IP;
	}

	/**
	 * Sets flag to True, this means that the game ends.
	 * @return Domain's halt flag as true.
	 */
	public boolean halt(){		
		this._Halt = true;
		return this._Halt;
	}

	/**
	 * The Domain will give a bounty hunter a new region to visit.
	 * @param pBountyHunterID this is the ID of a bounty hunter
	 * @param pRegionToVisitID this the ID of the region to visit. 
	 */
	public void addRegionToVisit(int pBountyHunterID, String pRegionToVisitID){}

	/**
	 * Tells the bounty hunter to return home.
	 */
	public void recallBountyHunter(){
		this.client.start("call back");
	}


	/**
	 * Tells the bounty hunter to visit a new Arduino.
	 * @param pBountyHunterID the ID of the Bounty hunter.	
	 */
	public void setNewMision(int pBountyHunterID, Region<?> RegionToVisit){
		this.client.start("new mission");
	}
	
	
	/**
	 * Method to get the IP of the running computer.
	 * @throws SocketException
	 */
	public String setIp() throws SocketException{
		Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
		String tempIP = "There is no IP";
		while (interfaces.hasMoreElements()){
		    NetworkInterface current = interfaces.nextElement();
		    if (!current.isUp() || current.isLoopback() || current.isVirtual()) continue;
		    Enumeration<InetAddress> addresses = current.getInetAddresses();
		    while (addresses.hasMoreElements()){
		        InetAddress current_addr = addresses.nextElement();
		        if (current_addr.isLoopbackAddress()) continue;
		        if (current_addr.isLinkLocalAddress())continue; 
		        tempIP = current_addr.getHostAddress();
		    }
		}
		return tempIP;
	}
	
	public int getCurrentPoints(){
		return this._MyCurrentPoints;
	}
}
