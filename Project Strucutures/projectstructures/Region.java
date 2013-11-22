package projectstructures;

import datastructs.graphs.Vertex;

@SuppressWarnings("hiding")
public class Region<String> extends Vertex<String>{
	private String _ID;
	private boolean _BountyHunter;
	private int _IndividualID;
	private int _Bounty;
	private  Domain<Region<String>> myDomain;
	
	public Region(Domain<Region<String>> domain){
		this.myDomain = domain;
		this._IndividualID = domain.getOrder() + 1;
		this._Bounty =  (int) (Math.random() * ((50)));
		this._BountyHunter = false;
		setID();
	}
	
	public String getID(){
		return this._ID;
	}
	
	public int getRegionID(){
		return this._IndividualID;
	}
	
	public int getBounty(){
		return this._Bounty;
	}
	
	public void setBounty(int pBountyToSet){
		this._Bounty = pBountyToSet;
	}
	
	public boolean haveBountyHunter(){
		return this._BountyHunter;
	}
	
	public void setID(){
		String DomainIP = this.myDomain.getIP();
		this._ID = DomainIP.concat(":" + Integer.toString(this._IndividualID));
	}
	
	public boolean setBountyHunter(BountyHunter pBountyHunterToSet){
		if(this._BountyHunter){
			return false;
		}else{
			this._BountyHunter = true;
			return true;
		}
	}
}
