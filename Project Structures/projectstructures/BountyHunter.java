package projectstructures;		


/**
 * Class that it the BountyHunter of the game
 * Where's my arduino 
 * @author zyoruk
 *
 */
public class BountyHunter {
	private String _HomeDomain;
	private String _ForeignDomain;
	private String _ForeignRegion;
	private String _TargetRegion;
	private int _HomeRegion;
	private int _MyID;
	private int _Bounty;
	
	public BountyHunter (Domain domain ,
						 Region pWhereToBeCreated){
		this._HomeDomain = domain.getIP();
		this._HomeRegion = pWhereToBeCreated.getRegionID();
		this._ForeignDomain = this._HomeDomain;
		this._ForeignRegion = this._HomeDomain + this._HomeRegion;
		this._Bounty = 000000;
		this._MyID = 007;
		pWhereToBeCreated.setBountyHunter(this);
	}
	/**
	 * Method that returns all the points that 
	 * the BountyHunter have catch through all the 
	 * game 
	 * @return
	 */
	public int returnPoints(){
		int PointsToReturn = this._Bounty;
		this._Bounty = 0;
		return PointsToReturn;
	}
	/**
	 * Method that return a BountyHunter of
	 * a region
	 * @param currentRegion
	 * @return
	 */
	public int takeBounty(Region currentRegion){
			this._Bounty = this._Bounty + currentRegion.getBounty();	
			currentRegion.setBounty(0);
			return this._Bounty;
	}
	/**
	 * Method that indicates to the BountyHunter to 
	 * go to his home
	 * @return
	 */
	public boolean returnHome(){
		if (this._ForeignDomain != this._HomeDomain){
			this._ForeignDomain = this._HomeDomain;
			return true;
		}else{
			System.out.print("BT is in home domain.");
			return false;
		}		
	}
	/**
	 * Method that gives a new mission to the
	 * BountyHunter that makes him move to an 
	 * Arduino using Dijkstra in order to get
	 * the shortest way to it.
	 * @param newRegionToVisit
	 * @return
	 */
	public boolean receiveNewMission(Region<String> newRegionToVisit){
		if (!(this._PlacesToVisit.exists(newRegionToVisit))){
			this._PlacesToVisit.append(newRegionToVisit);
			return true;
		}else{
			System.out.println("Can't take a new mission");
			return false;
		}
	}
	/**
	 * Method that set a new region as a
	 * target for the BountyHunter 
	 * @param newTargetRegion
	 */
	public void setNewTargetRegion(Region<String> newTargetRegion){
		this._TargetRegion = newTargetRegion.getID();
		
	}
	/**
	 * Method that return where is the
	 * BountyHunter 
	 * @return
	 */
	public String getPosition(){
		return this._ForeignRegion;
	}
	/**
	 * Method that returns the ID of
	 * the BountyHUnter 
	 * @return
	 */
	public int getID(){
		return this._MyID;
	}
	
	public String getHomeDomain(){
		return this._HomeDomain;
	}
	
	public int getHomeRegion(){
		return this._HomeRegion;
	}
	
	public String getForeignDomain(){
		return this._ForeignDomain;
	}
	
	public int getBounty(){
		return this._Bounty;
	}
	
	public int getMyID(){
		return this._MyID;
	}
	
	public String getTargetRegion(){
		return this._TargetRegion;
	}
	
	
	public void setHomeDomain(String pHomeDomain){
		this._HomeDomain = pHomeDomain;
	}
	
	public void setTargetRegion(String newTargetRegion){
		this._TargetRegion = newTargetRegion;		
	}
	
	public void setForeignDomain(String newForeignDomain){
		this._ForeignDomain = newForeignDomain;
	}
	
	public void setForeignRegion(String newForeignRegion){
		this._ForeignRegion = newForeignRegion;
	}
	
	public void setHomeRegion(int newHomeRegion){
		this._HomeRegion = newHomeRegion;
	}
	
	public void setID(int pID){
		this._MyID = pID;
	}
	
	public void setBounty(int pBounty){
		this._Bounty = pBounty;
	}
}
