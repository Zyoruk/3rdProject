package projectstructures;

import datastructs.graphs.Vertex;

public class Region<K> extends Vertex<K>{
	private String _ID;
	private boolean _ifBountyHunter;
	private BountyHunter bountyHunter;
	private int _IndividualID;
	private int _Bounty;
	private  Domain<String> myDomain;
	
	public Region(Domain<String> domain){
		super();
		this.myDomain = domain;
		this._IndividualID = domain.getOrder() + 1;
		this._Bounty =  (int) (Math.random() * ((50)));
		this._ifBountyHunter = false;
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
		return this._ifBountyHunter;
	}
	
	public void setID(){
		String DomainIP = this.myDomain.getIP();
		this._ID =  DomainIP.toString().concat(":" +  this._IndividualID);
	}
	
	public boolean setBountyHunter(BountyHunter pBountyHunterToSet){
		if(this._ifBountyHunter){
			return false;
		}else{
			this._ifBountyHunter = true;
			return true;
		}
	}
	
	public boolean receiveBountyHunter(BountyHunter toReceive){
		if (this._ifBountyHunter){
			return false;
		}else{
			this.bountyHunter = toReceive;
			this._ifBountyHunter = true;
			return true;
		}		
	}
	
	public boolean giveToOtherRegion(Region OtherRegion){
		if (OtherRegion._ifBountyHunter){
			return false;
		}else{
			OtherRegion.receiveBountyHunter(this.bountyHunter);
			this.bountyHunter = null;
			this._ifBountyHunter = false;
			return true;
		}
	}
	
}
