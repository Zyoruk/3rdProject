package datastructs.graphs;

import datastructs.interfaces.DataStructure;
import datastructs.simplelist.SimpleList;
import datastructs.simplelist.SimpleListNode;

/**
 * A graph is a structure that contains vertexes,and edges. There are several
 * methods a graph provides us.
 * 
 * @author zyoruk
 * 
 * @param <K>
 *            which means that the graph can contain different types of data.
 */
public class Graph<K> implements DataStructure<K> {

	private SimpleList<Vertex<K>> _NodeList;
	private SimpleList<Edge<K>> _EdgeList;

	public Graph() {
		this._NodeList = new SimpleList<Vertex<K>>();
		this._EdgeList = new SimpleList<Edge<K>>();
	}

	/**
	 * Adds a new node to the graph, not connected.
	 * 
	 * @param pNewNode
	 *            to add
	 */
	public void addNode(Vertex<K> pNewNode) {
		
		if (this._NodeList.exists(pNewNode) == false) {
			this._NodeList.append(pNewNode);
		}
	}

	/**
	 * Removes a vertex that contains the data specified.
	 * 
	 * @return removed vertex.
	 */
	public Vertex<K> removeVertex(K pData) {
		Vertex<K> vertex = getVertexThatContains(pData);
		if (vertex != null) {
			this._NodeList.delete(vertex);
			this.clearReferences(vertex);
			return vertex;
		} else {
			System.out.println("There was no vertex to remove");
			return null;
		}
	}

	/**
	 * Connects two nodes. If the existent link between those two nodes is the
	 * exactly the same, then it doesnt perform the action.
	 * 
	 * @param pFromNode
	 * @param pToNode
	 * @param pWeight
	 */
	public void linkNodes(K pFromNode, K pToNode, int pWeight) {
		if (this.exists(pFromNode) && this.exists(pToNode)) {

			Vertex<K> fromVertex = getVertexThatContains(pFromNode);
			Vertex<K> toVertex = getVertexThatContains(pToNode);
			if (this._EdgeList.length() == 0) {
				Edge<K> LinkToAdd = new Edge<K>(
						getVertexThatContains(pFromNode),
						getVertexThatContains(pToNode), pWeight);
				this._EdgeList.append(LinkToAdd);
				fromVertex.connectTo(toVertex, pWeight);

			} else {

				for (int i = 0; i < this._EdgeList.length(); i++) {
					try {
						Edge<K> LinkToEvaluate = this._EdgeList.getHead()
								.getElem();
						if (LinkToEvaluate.getFromNode() == pFromNode
							&& LinkToEvaluate.getToNode() == pToNode) {

							if (LinkToEvaluate.getWeight() <= pWeight) {
								break;
							} else {
								LinkToEvaluate.setWeight(pWeight);
								break;
							}

						} else if ((LinkToEvaluate.getFromNode() != pFromNode
									&& LinkToEvaluate.getToNode() != pToNode)
									&& LinkToEvaluate.getWeight() != pWeight) {

							Edge<K> LinkToAdd = new Edge<K>(
									getVertexThatContains(pFromNode),
									getVertexThatContains(pToNode), pWeight);
							this._EdgeList.append(LinkToAdd);
							fromVertex.connectTo(toVertex, pWeight);
							break;
						}
					} catch (NullPointerException e) {
						System.out.println("Can't link");
						break;
					}
				}
			}
		}else{
			System.out.println("The vertexes specified don't exist");
		}
	}

	/**
	 * There are times when we would like to know the quantity of vertexes the
	 * graph contains. This is called "Order".
	 * 
	 * @return Quantity of vertexes
	 */
	public int getOrder() {
		return this._NodeList.length();
	}

	/**
	 * There are times when we would like to know the quantity of edges the
	 * graph contains. This is called "Size".
	 * 
	 * @return Quantity of edges
	 */
	public int getSize() {
		return this._EdgeList.length();
	}

	@Override
	/**
	 * We would to like see how the graph is structured.
	 */
	public String describe() {
		StringBuilder result = new StringBuilder();
		result.append("Vertexes: ");
		SimpleListNode<Vertex<K>> temporalVertex = this._NodeList.getHead();
		for (int i = 0; i < this._NodeList.length(); i++) {
			try {
				result.append(String.format("%s ", temporalVertex.getElem().
							  getElement().toString()));
				temporalVertex =temporalVertex.getNext();
			} catch (NullPointerException e) {
				break;
			}
		}
		result.append("\nEdges: \n");
		SimpleListNode<Edge<K>> temporalEdge = this._EdgeList.getHead();
		for ( int i = 0 ; i < this._EdgeList.length();i++){
			result.append("From: ");
			result.append(String.format("%s ", temporalEdge.getElem().
						  getFromNode().getElement().toString()));
			result.append(" To: ");
			result.append(String.format("%s ", temporalEdge.getElem().
						  getToNode().getElement().toString()));
			result.append("Weight: ");
			result.append(String.format("%s ", temporalEdge.getElem()
						  .getWeight()));
			result.append("\n");
			temporalEdge = temporalEdge.getNext();
		}
		return result.toString();
	}

	@Override
	/**
	 * Method that checks if the Vertex exists
	 * @param pk Vertex to check.
	 * @return boolean depending if the vertex existed.
	 */
	public boolean exists(K pk) {
		return this._NodeList.exists(getVertexThatContains(pk));
	}

	@Override
	/**
	 * Method that will check if the graph is empty.
	 * @return a boolean depending
	 */
	public boolean isEmpty() {
		return getOrder() == 0 && getSize() == 0;
	}

	@Override
	/**
	 * Instead of length we use "getOrder" or "getSize". So, length is not
	 * implemented for a graph.
	 */
	public int length() {
		return 0;
	}

	/**
	 * To know the list of vertexes.
	 * 
	 * @return the list of vertexes the graph has.
	 */
	public SimpleList<Vertex<K>> getVertexes() {
		return this._NodeList;
	}

	/**
	 * To know the list of edges
	 * 
	 * @return the list of edges the grpah has.
	 */
	public SimpleList<Edge<K>> getEdges() {
		return this._EdgeList;
	}

	/**
	 * Checks if there is a vertex that contains the data specified
	 * 
	 * @param pk
	 *            Data we want to know if a vertex has it.
	 * @return the vertex that contains the date, null if there is no vertex.
	 */
	public Vertex<K> getVertexThatContains(K pk) {
		SimpleListNode<Vertex<K>> current = this._NodeList.getHead();
		for (int i = 0; i < this._NodeList.length(); i++) {
			if (current.getElem().getElement() == pk) {
				return current.getElem();
			} else {
				try {
					current = current.getNext();
				} catch (NullPointerException e) {
					break;
				}
			}
		}
		return null;
	}
	
	/**
	 * Removes the link that contains both specified vertexes
	 * @param pFromNode vertex data
	 * @param pToNode vertex data
	 */
	public void removeLink(K pFromNode , K pToNode){
		try{
			SimpleListNode<Edge<K>> current = this._EdgeList.getHead();
			for (int i = 0 ; i < this._EdgeList.length();i++){
				if (current.getElem().getFromNode().getElement() == pFromNode &&
					current.getElem().getToNode().getElement() == pToNode){
					this._EdgeList.delete(current.getElem());
					System.out.println("removed");
				}else{
					current = current.getNext();
					System.out.println("Nothing to remove");
				}
			}
		}catch(NullPointerException e){
			System.out.println("Can't remove");
		}
	}
	
	/**
	 * when we delete a vertex, then we need to search for any edge related to
	 * it and clear it.
	 * @param vertex The one we removed
	 */
	private void clearReferences(Vertex<K> vertex){
		SimpleListNode<Edge<K>> current = this._EdgeList.getHead();
		for (int i = 0 ; i< this._EdgeList.length();i++){
			if ( current.getElem().getFromNode() == vertex | current.getElem().getToNode()== vertex){
				this._EdgeList.delete(current.getElem());
			}else{
				current = current.getNext();
			}
		}
	}
	
	/**
	 * returns the list of nodes that have not been processed
	 * @return SimpleList the contains all the unprocessed vertexes
	 */
	public SimpleList<Vertex<K>> getUnprocessedOnes(){
		SimpleList<Vertex<K>> unprocessed = new SimpleList<Vertex<K>>();
		for (Vertex<K> k : this._NodeList){
			if(!k.getIfProcessed()){
				unprocessed.append(k);
			}else{
				
			}
		}
		return unprocessed;
	}
	
	/**
	 * returns the list of nodes that have been processed
	 * @return SimpleList the contains all the processed vertexes
	 */
	public SimpleList<Vertex<K>> getProcessedOnes(){
		SimpleList<Vertex<K>> Processed = new SimpleList<Vertex<K>>();
		for (Vertex<K> k : this._NodeList){
			if(k.getIfProcessed()){
				Processed.append(k);
			}else{
				
			}
		}
		return Processed;
	}
	
	/**
	 * Set the vertex as processed
	 * @param data that the node should have
	 */
	public void setAsProcessed(K data){
		Vertex<K> ToSet = this.getVertexThatContains(data);
		ToSet.setIfProcessed(true);
	}

	/**
	 * This method calls the already implemented Dijsktra Algorithm, because we
	 * want to know the shortest path from one node to another.
	 * 
	 * @param fromNode
	 *            Vertex where we start the path
	 * @param toNode
	 *            Vertex where we end the path
	 * @param graph
	 *            Since we need to know all the methods of it and its current
	 *            lists.
	 */
//	public void DijsktraAlgorithm(String fromNode) {
<<<<<<< HEAD
//		Dijkstra<K> Dijkstra = new Dijkstra(fromNode,fromNode,this);
=======
//		DijkstraV2<K> Dijkstra = new DijkstraV2(fromNode, this);
>>>>>>> parent of 3a41259... We need to create a generic array example k[][] array and after that cast it to the data type we receive.
//		Dijkstra.execute();
//	}

}
