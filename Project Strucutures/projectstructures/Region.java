package projectstructures;

import datastructs.graphs.Vertex;
/**
 * Class that create a region
 * @author zyoruk
 *
 * @param <K>
 */
public class Region<K> extends Vertex<K>{
	private String _ID;
	private boolean _ifBountyHunter;
	private BountyHunter bountyHunter;
	private int _IndividualID;
	private int _Bounty;
	private  Domain<String> myDomain;
	
	public Region(Domain<String> domain){
		this.myDomain = domain;
		this._IndividualID = domain.getOrder() + 1;
		this._Bounty =  (int) (Math.random() * ((50)));
		this._ifBountyHunter = false;
		setID();
	}
	/**
	 * Method that return the region ID 
	 * @return
	 */
	public String getID(){
		return this._ID;
	}
	/**
	 * Method that return the Individual Region ID
	 * @return
	 */
	public int getRegionID(){
		return this._IndividualID;
	}
	/**
	 * Method that return the Region's BountyHunter 
	 * @return
	 */
	public int getBounty(){
		return this._Bounty;
	}
	/**
	 * Method that set the Region's Bounty
	 * @param pBountyToSet
	 */
	public void setBounty(int pBountyToSet){
		this._Bounty = pBountyToSet;
	}
	/**
	 * Method that shows if the region has a
	 * BountyHUnter 
	 * @return
	 */
	public boolean haveBountyHunter(){
		return this._ifBountyHunter;
	}
	/**
	 * Method that sets the Region ID 
	 */
	public void setID(){
		String DomainIP = this.myDomain.getIP();
		this._ID = (String) DomainIP.toString();
	}
	/**
	 * Method that sets the Region's BountyHunter 
	 * @param pBountyHunterToSet
	 * @return
	 */
	public boolean setBountyHunter(BountyHunter pBountyHunterToSet){
		if(this._ifBountyHunter){
			return false;
		}else{
			this._ifBountyHunter = true;
			return true;
		}
	}
	/**
	 * Method that shows if the Regions has received 
	 * a BountyHunther 
	 * @param toReceive
	 * @return
	 */
	public boolean receiveBountyHunter(BountyHunter toReceive){
		if (this._ifBountyHunter){
			return false;
		}else{
			this.bountyHunter = toReceive;
			this._ifBountyHunter = true;
			return true;
		}		
	}
	/**
	 * Method that gives a Region a BountyHunther of another
	 * Region 
	 * @param OtherRegion
	 * @return
	 */
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
