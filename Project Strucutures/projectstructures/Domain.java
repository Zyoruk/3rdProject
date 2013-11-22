package projectstructures;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

import datastructs.simplelist.SimpleList;
import datastructs.graphs.Graph;

/**
 * @author zyoruk
 * A domain is a computer which contains several regions. It extends from the
 * graph data structure. This will send several messages to bounty hunters and
 * create them, as well.
 */
public class Domain<K> extends Graph<K> {

	private static String IP;
	private boolean _Halt;
	private SimpleList<BountyHunter> _MyBountyHunters;
	private int _MyCurrentPoints;

	/**
	 * The constructor will initialize the variables and set the Domain's IP
	 * using the current machine IP.
	 */
	public Domain(){
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
		SimpleList<BountyHunter> tempList = this._MyBountyHunters;
		for (int i = 0; i < this._MyBountyHunters.length();i++){
			tempList.deleteHead().returnPoints();
		}
	}

	/**
	 * Creates a new BountyHunter, cannot do it directly into a foreign domain.
	 * @param pWhereToBeCreated is the region to create the bounty hunter.
	 */	
	public void createbountyHunter(Region pWhereToBeCreated){
		BountyHunter newBountyHunter = new BountyHunter(this, pWhereToBeCreated);
		this._MyBountyHunters.append(newBountyHunter);
	}

	/**
	 * Each Domain will be able to send a "Halt" message which means that the 
	 * domain wants to end the game. Then, every single bounty hunter must
	 * return to their respective home domain. This method receives the message
	 * and do the respective operations.
	 * @param pHaltMessage it is a boolean.
	 */
	public void endBountyRecollection(boolean pHaltMessage){}

	/**
	 * The programm will need somehow to know the Bounty Hunter list for some 
	 * methods. So, we don't want to make the local fields public , we just 
	 * implement a getter when needed.
	 * @return List of bounty hunters
	 */
	public SimpleList<BountyHunter> getBountyHunterList(){
		return this._MyBountyHunters;
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
	 * Tells every bounty hunter to return home.
	 */
	public void recallBountyHunter(){
		SimpleList<BountyHunter> tempList = this._MyBountyHunters;
		for (int i = 0; i < this._MyBountyHunters.length();i++){
			tempList.deleteHead().returnHome();
		}
	}


	/**
	 * Tells the bounty hunter to visit a new Arduino.
	 * @param pBountyHunterID the ID of the Bounty hunter.	
	 */
	public void setNewMision(int pBountyHunterID, Region RegionToVisit){
		SimpleList<BountyHunter> temp = this._MyBountyHunters;
		for (int i = 0; i < this._MyBountyHunters.length();i++){
			BountyHunter tempHunter = temp.deleteHead();
			if (tempHunter.getID() == pBountyHunterID){
				tempHunter.setNewTargetRegion(RegionToVisit);
			}
		}
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
