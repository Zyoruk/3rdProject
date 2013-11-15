package datastructs.graphs;

public class Link<K> {
	
	private int _Weight;
	private GraphNode<K> _ConnectFrom;
	private GraphNode<K> _ConnetTo;

	public Link(GraphNode<K> pConnectFromNode, GraphNode<K> pConnectToNode) {
		this._Weight = 0;
		this._ConnectFrom = pConnectFromNode;
		this._ConnetTo = pConnectToNode;
	}

	public Link(GraphNode<K> pConnectFromNode, GraphNode<K> pConnectToNode,
				int pDistance) {		
		this._Weight = pDistance;
		this._ConnectFrom = pConnectFromNode;
		this._ConnetTo = pConnectToNode;
	}
	
	
	public void setFromNode(GraphNode<K> pFromNode){
		this._ConnectFrom = pFromNode;
	}
	
	public GraphNode<K> getFromNode(){
		return this._ConnectFrom;
	}
	
	public GraphNode<K> getToNode(){
		return this._ConnetTo;
	}
	
	public int getWeight(){
		return this._Weight;
	}
}
