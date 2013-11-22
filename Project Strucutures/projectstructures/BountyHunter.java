package projectstructures;

import datastructs.queue.QueueWithList;


public class BountyHunter {
	private String _HomeDomain;
	private String _ForeignDomain;
	private String _ForeignRegion;
	private String _TargetRegion;
	private int _HomeRegion;
	private int _MyID;
	private int _Bounty;
	private QueueWithList<Region> _PlacesToVisit;
	
	public BountyHunter (Domain domain ,
						 Region pWhereToBeCreated){
		this._HomeDomain = domain.getIP();
		this._HomeRegion = pWhereToBeCreated.getRegionID();
		this._ForeignDomain = this._HomeDomain;
		this._ForeignRegion = this._HomeDomain + this._HomeRegion;
		this._Bounty = 000000;
		this._MyID = domain.getBountyHunterList().length() + 1;
		this._PlacesToVisit = null;
		pWhereToBeCreated.setBountyHunter(this);
	}
	
	public int returnPoints(){
		int PointsToReturn = this._Bounty;
		this._Bounty = 0;
		return PointsToReturn;
	}
	
	public int takeBounty(Region currentRegion){
			this._Bounty = this._Bounty + currentRegion.getBounty();
			this._TargetRegion = this._PlacesToVisit.Dequeue().getID();	
			currentRegion.setBounty(0);
			return this._Bounty;
	}
	
	public boolean returnHome(){
		if (this._ForeignDomain != this._HomeDomain){
			this._ForeignDomain = this._HomeDomain;
			return true;
		}else{
			System.out.print("BT is in home domain.");
			return false;
		}		
	}
	
	public boolean receiveNewMission(Region<String> newRegionToVisit){
		if (!(this._PlacesToVisit.exists(newRegionToVisit))){
			this._PlacesToVisit.append(newRegionToVisit);
			return true;
		}else{
			System.out.println("Region already in the list");
			return false;
		}
	}
	
	public void setNewTargetRegion(Region<String> newTargetRegion){
		this._TargetRegion = newTargetRegion.getID();
		
	}
	
	public String getPosition(){
		return this._ForeignRegion;
	}
	
	public int getID(){
		return this._MyID;
	}
}
