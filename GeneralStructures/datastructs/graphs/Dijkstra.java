package datastructs.graphs;

import datastructs.simplelist.SimpleList;
import datastructs.simplelist.SimpleListNode;


public class Dijkstra <K> {
	private Vertex<K> startNode;
	private Graph<K> graph;
	private SimpleList<Vertex<K>> dadVertexes;
	private int[] arrayDistances;
	private int distance;
	private int index;
	SimpleList<Vertex<K>> path;
	
	public Dijkstra(Vertex<K> pstartNode, Graph<K> pgraph){
		this.index = 0;
		this.graph = pgraph;
		path = new SimpleList<Vertex<K>>();
		
		//Set start node visited
//		pgraph.getVertex(pstartNode).setIfProcessed(true);
		
		//Sets starting and ending nodes
		this.startNode = evaluatedNode(pstartNode);

		// Dijkstra lists
		this.dadVertexes = new SimpleList<Vertex<K>>();
		for (int i = 0 ; i < this.graph.getOrder();i++){
			dadVertexes.append(new Vertex<K>());
		}
		this.arrayDistances = new int [this.graph.getOrder()];

		this.distance = 0;
		
		//Sets all the distances to infinity
		for (int i = 0 ; i < this.arrayDistances.length;i++){
			this.arrayDistances[i] = Integer.MAX_VALUE;
		}		
	}
	
	public void execute(){
		
		//Checks if there are no more visited vertexes
//		while(this.graph.getUnVisitedOnes().length() != 0){
		while(index < this.arrayDistances.length){	
			//Iterates over graph vertexes
			for (Vertex<K> k : this.graph.getVertexes()){				
				
				//If current and start nodes are not the same
				if (!this.startNode.getElement().equals(k.getElement())){
					
					//Iterates over startnode adjacent list
					for(SimpleListNode<Vertex<K>> current = 
							startNode.getAdjacentVertexes().getHead(); 
						current != null; current = current.getNext()){
						
						//checks to establish node dad
						if(k.getElement().equals(current.getElem().getElement())){
							dadVertexes.replace(index, this.startNode);
							System.out.println("Hola" + this.graph.getOrder());
							this.arrayDistances[index] = weightEvaluation(this.arrayDistances[index] , this.startNode ,current.getElem());
							
						}
					}
				}else{
					this.arrayDistances[index] = 0; //assign lenght 0
					
				}
				index++;
				System.out.println(index);
			}
			this.startNode = getNextLighterNode();
			this.startNode.setIfProcessed(true);
		}
		System.out.println(this.dadVertexes.describe());
	}

	
	private Vertex<K> evaluatedNode(Vertex<K> node){
		for(Vertex<K> k : this.graph.getVertexes()){
			if(k.getElement() == node.getElement()  && !k.getIfProcessed()){
				return k;
			}
		}
		return null;
	}
	
	private Vertex<K> getNextLighterNode(){
		int lighter = Integer.MAX_VALUE;
		Vertex<K> vertex = new Vertex<K>();; 
		for (int i = 0 ; i < this.arrayDistances.length - 1 ; i++){
			for(Vertex<K> V : this.graph.getVertexes()){
				for (Vertex<K> k : this.graph.getUnVisitedOnes()){
					if (k.getElement().equals(V.getElement())){
						if(this.arrayDistances[i] < lighter){
							lighter = this.arrayDistances[i];
							vertex = k;
						}

					}
				}
			}
		}
		return vertex;
	}
	
	private int weightEvaluation(int i , Vertex<K> startNode , Vertex<K> toNode){
		for ( Edge<K> k : this.graph.getEdges()){
			if (k.getFromNode().getElement() == startNode.getElement() && k.getToNode().getElement() == toNode.getElement()){
				if(k.getWeight() < this.distance + i){
					i = k.getWeight();
					distance = distance + i;
					return i;
				}else{
					break;
				}
			}
		}
		return i;
		
	}
	public SimpleList<Vertex<K>> getdadVertexes(){
		return this.dadVertexes;
	}
	
	public SimpleList<Vertex<K>> getShortestPath(K start , K end){
		
		if(start == end){
			return this.path;
		}
		Vertex<K> beginningNode = this.graph.getVertexThatContains(start);
		Vertex<K> endNode = this.graph.getVertexThatContains(end);
		Vertex<K> startNode = endNode;
		SimpleListNode<Vertex<K>> head = this.graph.getVertexes().getHead();
		SimpleListNode<Vertex<K>> dad = this.dadVertexes.getHead();
		while(head.getElem() != startNode){
			head = head.getNext();
			dad = dad.getNext();
		}
		if (head.getElem() == startNode){
			path.append(startNode);
			return getShortestPath(beginningNode.getElement() , dad.getElem().getElement());			
		}else{
			return this.path;
		}
	}
	
}
