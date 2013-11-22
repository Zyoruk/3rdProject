package datastructs.graphs;

import datastructs.simplelist.SimpleList;
/**
 * A vertex is part of a graph, and it can contains several kind of data.
 * Also, you can connect the vertex to another one.
 * @author zyoruk
 *
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

	// Getters and setters
	/**
	 * Returns the list of edges the vertex has
	 * @return Simpl List of edges
	 */
	public SimpleList<Edge<K>> getConnections() {
		return this._vertexPointers;
	}

	/**
	 * returns the element of the vertex
	 * @return element of the vertex
	 */
	public K getElement() {
		return this._element;
	}

	/**
	 * Sets this vertex element
	 * @param pk element to set
	 */
	public void setElement(K pk) {
		this._element = pk;
	}

	/**
	 * Returns a boolean
	 * @return true or false
	 */
	public boolean getIfProcessed() {
		return this._Processed;
	}

	/**
	 * Sets the vertex as processed
	 * @param pProcessed true or false
	 */
	public void setIfProcessed(boolean pProcessed) {
		this._Processed = pProcessed;
	}

	/**
	 * Searches all the vertexes that are connected to this one
	 * @return SimpleList that contains all the adjacent vertexes
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
