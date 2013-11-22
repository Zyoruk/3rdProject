package datastructs.graphs;

import datastructs.simplelist.SimpleList;

public class DijkstraAlgorithm<K> {
	private final SimpleList<Vertex<K>> _Nodes;
	private final SimpleList<Edge<K>> _Edges;
	private SimpleList<Vertex<K>> _ProcessedNodes;
	private SimpleList<Vertex<K>> _NotProcessedNodes;
	private int distance;

	public DijkstraAlgorithm(Graph pGraph) {
		this._Nodes = pGraph.getVertexes();
		this._Edges = pGraph.getEdges();
	}

	public void execute(Vertex<K> FromNode) {
		this._ProcessedNodes = new SimpleList<Vertex<K>>();
		this._NotProcessedNodes = this._Nodes;
		// this.distance =
	}

	private void findMinimalDistances(Vertex<K> node) {
	}

	private int getDistance(Vertex<K> node, Vertex<K> target) {
		return 0;
	}

	private SimpleList<Vertex<K>> getNeighbors(Vertex<K> node) {
		return node.getAdjacentVertexes();
	}

	private SimpleList<Vertex<K>> getMinimum(SimpleList<Vertex> nodes) {
		return null;
	}

	private boolean isSettled(Vertex node) {
		return this._ProcessedNodes.exists(node);
	}

	private int getShortestDistance(Vertex<K> destination) {
		return 0;
	}

	public SimpleList<Vertex<K>> getPath(Vertex target) {
		return null;
	}
}
