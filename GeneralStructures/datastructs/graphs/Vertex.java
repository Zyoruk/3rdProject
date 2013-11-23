package datastructs.graphs;

import datastructs.simplelist.SimpleList;

/**
 * 
 * @author zyoruk
 *Class that made the connection between two nodes 
 * @param <K>
 */
public class Vertex<K> {
	private K _element;
	private SimpleList<Edge<K>> _vertexPointers;
	private SimpleList<Vertex<K>> adjacentVertexes;
	private boolean _Processed;

	public Vertex() {
		this(null, null);
	}

	public Vertex(K pElement, Graph<K> pOwnerGraph) {
		this._element = pElement;
		this._vertexPointers = new SimpleList<Edge<K>>();
		this._Processed = false;
	}

	/**
	 * Connects two graph nodes with the given weight.
	 * 
	 * @param pOtherNode
	 *            Is the node to get connected to.
	 * @param pWeight
	 *            It is the weight associated to the link between the nodes
	 */
	public void connectTo(Vertex<K> pOtherNode, int pWeight) {
		Edge<K> link = new Edge<K>(this, pOtherNode, pWeight);
		if (!this._vertexPointers.exists(link)) {
			this._vertexPointers.append(link);
		}
	}

	/**
	 * Method that return the connections on the vertex 
	 * @return SimpleList<Edge<K>>
	 */
	public SimpleList<Edge<K>> getConnections() {
		return this._vertexPointers;
	}
	/**
	 * Method that return the element of the vertex 
	 * @return K
	 */
	public K getElement() {
		return this._element;
	}
	/**
	 * Method that set the element of the vertex 
	 * @param pk
	 */
	public void setElement(K pk) {
		this._element = pk;
	}
	/**
	 * Method that return if an vertex has being
	 * processed 
	 * @return boolean 
	 */
	public boolean getIfProcessed() {
		return this._Processed;
	}
	/**
	 * Method that set the vertex as a
	 * processed 
	 * @param pProcessed
	 */
	public void setIfProcessed(boolean pProcessed) {
		this._Processed = pProcessed;
	}
	/**
	 * Method that return the Adjacent Vertexes 
	 * @return SimpleList<Vertex<K>>
	 */
	public SimpleList<Vertex<K>> getAdjacentVertexes() {
		for (int i = 0; i < this._vertexPointers.length(); i++) {
			try {
				this.adjacentVertexes.append(this._vertexPointers.getHead()
						.getElem().getToNode());
			} catch (NullPointerException e) {
				break;
			}
		}
		return this.adjacentVertexes;
	}
}
