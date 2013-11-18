package projectstructures;

import datastructs.queue.QueueWithList;

public class BountyHunter {
	private String _HomeDomain;
	private int _HomeRegion;
	private String _ForeignDomain;
	private String _ForeignRegion;
	private String _TargetRegion;
	private int _MyID;
	private int _Bounty;
	private QueueWithList<Region> _PlacesToVisit;
	
	public BountyHunter (Domain pWhoCreatesMe , Region WhereToBeCreated){
		this._HomeDomain = pWhoCreatesMe.getIP();
		this._HomeRegion = WhereToBeCreated.getRegionID();
		this._ForeignDomain = this._HomeDomain;
		this._ForeignRegion = this._HomeDomain + this._HomeRegion;
		this._Bounty = 000000;
		this._MyID = pWhoCreatesMe.getBountyHunterList().length() + 1;
		this._PlacesToVisit = null;
	}
	
	public int returnPoints(){
		int PointsToReturn = this._Bounty;
		this._Bounty = 0;
		return PointsToReturn;
	}
	
	public int takeBounty(Region currentRegion){
			this._Bounty = this._Bounty + currentRegion.getBounty();
			this._TargetRegion = this._PlacesToVisit.Dequeue().getID();		
			return this._Bounty;
	}
	
	public String returnHome(){
		if (this._ForeignDomain != this._HomeDomain){
			//exitCurrentDomain();
			this._ForeignDomain = this._HomeDomain;
		}else{
			System.out.print("BT is in home domain.");
		}
		return this._ForeignDomain;
		
	}
	
	public boolean receiveNewMission(Region newRegionToVisit){
		if (!(this._PlacesToVisit.exists(newRegionToVisit))){
			this._PlacesToVisit.append(newRegionToVisit);
			return true;
		}else{
			System.out.println("Region already in the list");
			return false;
		}
	}
	
	public void setNewTargetRegion(Region newTargetRegion){
		this._TargetRegion = newTargetRegion.getID();
	}
	
	public String getPosition(){
		return this._ForeignRegion;
	}
	
	public int getID(){
		return this._MyID;
	}
}
