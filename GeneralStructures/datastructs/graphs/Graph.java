package datastructs.graphs;

import datastructs.interfaces.DataStructure;
import datastructs.simplelist.SimpleList;

public class Graph<K> implements DataStructure<K> {

	private SimpleList<GraphNode<K>> _NodeList;
	//Adjacency
	private SimpleList<Link<K>> _LinkList;
	
	public void addNode(GraphNode<K> pNewNode){
		if(!this._NodeList.exists(pNewNode)){
			this._NodeList.append(pNewNode);
		}
	}
	
	public void linkNodes(GraphNode<K> pFromNode , GraphNode<K> pToNode ,
						  int pWeight){
		SimpleList<Link<K>> temp = this._LinkList;
		
		for(int i = 0 ; i < this._LinkList.length() ; i++){
			Link<K> LinkToEvaluate = temp.deleteHead();
			
			if ((LinkToEvaluate.getFromNode() != pFromNode &&
				LinkToEvaluate.getToNode() != pToNode) &&
				LinkToEvaluate.getWeight() != pWeight){
				
				Link<K> LinkToAdd = new Link(pFromNode , pToNode , pWeight);
				this._LinkList.append(LinkToAdd);
				break;
			}
		}
	}
	@Override
	public String describe() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(K pk) {
		GraphNode<K> NodeToCompare = new GraphNode<K> (pk , this);
		SimpleList<GraphNode<K>> temp = this._NodeList;
		for (int i = 0 ; i < this._NodeList.length() ; i++){
			GraphNode<K> current = temp.deleteHead();
			if(current.getElement() == NodeToCompare.getElement()){
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		return this._NodeList.length() == 0;
	}

	@Override
	public int length() {
		return this._NodeList.length();
	}
	
	// calcular ruta más rapida.

}
