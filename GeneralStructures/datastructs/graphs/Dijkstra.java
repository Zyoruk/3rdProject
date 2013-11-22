package datastructs.graphs;

import datastructs.simplelist.SimpleList;
/**
 * This class resolves the problem to get the shortest path from one node to
 * another
 * @author zyoruk
 *
 * @param <K>
 */

public class Dijkstra <K> {
	private Vertex<Character> startNode;
	private Vertex<K> toNode;
	private Graph<K> graph;
	private SimpleList<Vertex<K>> unprocessed;
	private SimpleList<Vertex<K>> processed;
	private K[][] arrayVertexes;
	private K[] arrayDistances;
	private int distance;
	
	public Dijkstra(K pstartNode ,K toEndNode, Graph<K> pgraph){
		this.graph= pgraph;
		pgraph.getVertexThatContains(pstartNode).setIfProcessed(true);
		this.processed = pgraph.getProcessedOnes();
		this.unprocessed = pgraph.getUnprocessedOnes();
		this.startNode = (Vertex<Character>) evaluatedNode((Character) pstartNode);
		this.toNode = (Vertex<K>) toEndNode;

		this.arrayVertexes = new char[this.graph.getOrder()][2];
		this.arrayDistances = new int [this.graph.getOrder()];
		
		this.distance = 0;
		// Sets all the distances to infinity
		for (int i = 0 ; i < this.arrayDistances.length;i++){
			this.arrayDistances[i] = Integer.MAX_VALUE;
		}
		// Builds the array of vertexes
		for (Vertex<K> k : this.graph.getVertexes()){
			int i = 0;
			this.arrayVertexes[i][1] = (Character) k.getElement();
			i++;
		}
		
	}
	
	/**
	 * Calculates the shortest path
	 */
	public void execute(){
		while(this.unprocessed.length() !=0){
			for (int i = 0 ; i < this.arrayVertexes.length;i++){
				if (this.startNode.getElement().equals(this.arrayVertexes[i][0])){
					this.arrayDistances[i] = 0;
				}else{
					for(Vertex<Character> k : this.startNode.getAdjacentVertexes()){
						if (k.equals(this.arrayVertexes[i][0])){
							for (Edge<K> h : this.graph.getEdges()){
								if(h.getWeight() + this.distance < this.arrayDistances[i]){
									this.arrayDistances[i] = h.getWeight() + this.distance;
									this.arrayVertexes[i][1] = this.startNode.getElement();
								}
							}
						}else{
							break;
						}
					}
				}
			}
			this.startNode = getLighter();
		}
	}
	
	public SimpleList<Integer> getDistances(){
		SimpleList<Integer> distances = new SimpleList<Integer>();
		for (int i = 0 ; i < this.arrayDistances.length; i ++){
			distances.append(this.arrayDistances[i]);
		}
		return distances;
	}

	public char[][] getVertexesArray(){
		return this.arrayVertexes;
	}
	/**
	 * The class needs to know the exact node we are going to evaluate
	 * @param node data the node should have
	 * @return the node that contains such data
	 */
	private Vertex<K> evaluatedNode(char node){
		for(Vertex<K> k : this.graph.getVertexes()){
			if(k.equals(node) && this.unprocessed.exists(k)){
				return k;
			}
		}
		return null;
	}
	
	/**
	 * The class needs to set another node to be evaluated
	 * @return the node with the lightest weight
	 */
	private Vertex<Character> getLighter(){
		int lighter = Integer.MAX_VALUE;
		Vertex<Character> vertex; 
		for (int i = 0 ; i < this.arrayDistances.length ; i++){
			for (Vertex<K> k : this.graph.getProcessedOnes()){
				if (k.equals(this.arrayVertexes[i][0])){
					return null;
				}else{
					if(this.arrayDistances[i] < lighter){
						lighter = this.arrayDistances[i];
						vertex = (Vertex<Character>) k;
						return vertex;
					}
				}
			}
		}
		return null;
	}
	
}
