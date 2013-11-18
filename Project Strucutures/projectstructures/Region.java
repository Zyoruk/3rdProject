package projectstructures;

import datastructs.graphs.Vertex;

public class Region<K> extends Vertex<K>{
	private String _ID;
	private int _IndividualID;
	private boolean _BountyHunter;
	private int _Bounty;
	
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
	
	public boolean setBountyHunter(BountyHunter pBountyHunterToSet){
		if(this._BountyHunter){
			return false;
		}else{
			this._BountyHunter = true;
			return true;
		}
	}
}
