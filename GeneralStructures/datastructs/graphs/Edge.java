package datastructs.graphs;

/**
 * Edge is the link between two vertexes. It has a weight or "distance" between
 * them.
 * @author zyoruk
 *
 * @param <K> Generics
 */
public class Edge<K> {
	
	private int _Weight;
	private Vertex<K> _ConnectFrom;
	private Vertex<K> _ConnetTo;

	public Edge(Vertex<K> pConnectFromNode, Vertex<K> pConnectToNode) {
		this._Weight = 0;
		this._ConnectFrom = pConnectFromNode;
		this._ConnetTo = pConnectToNode;
	}

	public Edge(Vertex<K> pConnectFromNode, Vertex<K> pConnectToNode,
				int pDistance) {		
		this._Weight = pDistance;
		this._ConnectFrom = pConnectFromNode;
		this._ConnetTo = pConnectToNode;
	}
	
	public void setFromNode(Vertex<K> pFromNode){
		this._ConnectFrom = pFromNode;
	}
	
	public void setWeight(int pWeight){
		this._Weight = pWeight;
	}
	
	public Vertex<K> getFromNode(){
		return this._ConnectFrom;
	}
	
	public Vertex<K> getToNode(){
		return this._ConnetTo;
	}
	
	public int getWeight(){
		return this._Weight;
	}
}
