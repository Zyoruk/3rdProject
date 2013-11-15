package projectstructures;

import datastructs.graphs.GraphNode;

public class Region<K> extends GraphNode<K>{
	private String _ID;
	private int _IndividualID;
	private boolean _BountyHunter;
	
	public String getID(){
		return this._ID;
	}
	
	public int getRegionID(){
		return this._IndividualID;
	}
}
