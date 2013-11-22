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
	
	/**
	 * This changes the place where the edge begins
	 * @param pFromNode is the new start of the edge
	 */
	public void setFromNode(Vertex<K> pFromNode){
		this._ConnectFrom = pFromNode;
	}
	
	/**
	 * Changes the current weight
	 * @param pWeight integer to change for
	 */
	public void setWeight(int pWeight){
		this._Weight = pWeight;
	}
	
	/**
	 * Returns the node where the edge begins
	 * @return beginning of the edge
	 */
	public Vertex<K> getFromNode(){
		return this._ConnectFrom;
	}
	
	/**
	 * Return the node where the edge ends
	 * @return end of the edge
	 */
	public Vertex<K> getToNode(){
		return this._ConnetTo;
	}
	
	/**
	 * Returns the weight of the edge
	 * @return value of the weight
	 */
	public int getWeight(){
		return this._Weight;
	}
}
