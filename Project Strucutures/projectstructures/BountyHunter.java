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
		return this._Bounty;
	}
	
	public void takeBounty(){
		
	}
	
	public void returnHome(){
		
	}
	
	public void receiveNewMission(Region newRegionToVisit){
		
	}
	
	public void setNewTargetRegion(Region newTargetRegion){
		this._TargetRegion = newTargetRegion.getID();
	}
	
	public String getPosition(){
		return this._ForeignRegion;
	}
}
