package datastructs.graphs;

import datastructs.simplelist.SimpleList;

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
	public SimpleList<Edge<K>> getConnections() {
		return this._vertexPointers;
	}

	public K getElement() {
		return this._element;
	}

	public void setElement(K pk) {
		this._element = pk;
	}

	public boolean getIfProcessed() {
		return this._Processed;
	}

	public void setIfProcessed(boolean pProcessed) {
		this._Processed = pProcessed;
	}

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
