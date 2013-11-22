package datastructs.graphs;

import datastructs.simplelist.SimpleList;


public class Dijkstra <K> {
	private Vertex<Character> startNode;
	private Vertex<K> toNode;
	private Graph<K> graph;
	private SimpleList<Vertex<K>> unprocessed;
	private SimpleList<Vertex<K>> processed;
	private char[][] arrayVertexes;
	private int[] arrayDistances;
	private int distance;
	
	public Dijkstra(K pstartNode ,K toEndNode, Graph<K> pgraph){
		this.graph= pgraph;
		pgraph.getVertexThatContains(pstartNode).setIfProcessed(true);
		this.processed = pgraph.getProcessedOnes();
		this.unprocessed = pgraph.getUnprocessedOnes();
		this.startNode = (Vertex<Character>) evaluatedNode((Character) pstartNode);
		this.toNode = (Vertex<K>) toEndNode;

		this.arrayVertexes = new char [this.graph.getOrder()][2];
		this.arrayDistances = new int [this.graph.getOrder()];
		
		this.distance = 0;
		
		for (int i = 0 ; i < this.arrayDistances.length;i++){
			this.arrayDistances[i] = Integer.MAX_VALUE;
		}
		for (Vertex<K> k : this.graph.getVertexes()){
			int i = 0;
			this.arrayVertexes[i][1] = (Character) k.getElement();
			i++;
		}
		
	}
	
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
	

	
	private Vertex<K> evaluatedNode(char node){
		for(Vertex<K> k : this.graph.getVertexes()){
			if(k.equals(node) && this.unprocessed.exists(k)){
				return k;
			}
		}
		return null;
	}
	
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
