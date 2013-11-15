package datastructs.graphs;

import datastructs.simplelist.SimpleList;

public class GraphNode<K> {
	private K _element;
	private Graph<K> _MyOwner;
	private SimpleList <Link<K>> _nodePointers;
	private boolean _Processed;
	
	public GraphNode(){
		this(null, null);
	}
	
	public GraphNode(K pElement, Graph<K> pOwnerGraph){
		this._element = pElement;
		this._nodePointers = new SimpleList<Link<K>>();
		this._MyOwner = pOwnerGraph;
		this._Processed = false;
	}
	
	/**
	 * Connects two graph nodes with the given weight.
	 * @param pOtherNode Is the node to get connected to.
	 * @param pWeight	It is the weight associated to the link between the
	 * nodes
	 */
	public void connectTo(GraphNode<K> pOtherNode, int pWeight){
		Link <K> link = new Link<K> (this, pOtherNode, pWeight);
		if(!this._nodePointers.exists(link)){
			this._nodePointers.append(link);
		}
		SimpleList<Link<K>> OtherNodeConnections = pOtherNode.getConnections();
		if (!OtherNodeConnections.exists(link)){
			OtherNodeConnections.append(link);
		}
	}
	
	//Getters and setters
	public SimpleList<Link<K>> getConnections(){
		return this._nodePointers;
	}
		
	public K getElement(){
		return this._element;
	}
		
	public void setElement(K pk){
		this._element = pk;
	}
	
	public boolean getIfProcessed(){
		return this._Processed;
	}
	
	public void setIfProcessed(boolean pProcessed){
		this._Processed = pProcessed;
	}
}
