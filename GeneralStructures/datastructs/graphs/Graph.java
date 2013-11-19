package datastructs.graphs;

import datastructs.interfaces.DataStructure;
import datastructs.simplelist.SimpleList;

public class Graph<K> implements DataStructure<K> {

	private SimpleList<Vertex<K>> _NodeList;
	private SimpleList<Edge<K>> _EdgeList;
	
	public Graph(){
		this._NodeList = new SimpleList<Vertex<K>>();
		this._EdgeList = new SimpleList<Edge<K>>();
	}
	public void addNode(Vertex<K> pNewNode){
		if(this._NodeList.exists(pNewNode)==false){
			this._NodeList.append(pNewNode);
		}
	}
	
	public void linkNodes(Vertex<K> pFromNode , Vertex<K> pToNode ,
						  int pWeight){
		SimpleList<Edge<K>> temp = this._EdgeList;
		
		for(int i = 0 ; i < this._EdgeList.length() ; i++){
			Edge<K> LinkToEvaluate = temp.deleteHead();
			
			if ((LinkToEvaluate.getFromNode() != pFromNode &&
				LinkToEvaluate.getToNode() != pToNode) &&
				LinkToEvaluate.getWeight() != pWeight){
				
				Edge<K> LinkToAdd = new Edge<K>(pFromNode , pToNode , pWeight);
				this._EdgeList.append(LinkToAdd);
				break;
			}
		}
	}
	
	public int getOrder(){
		return this._NodeList.length();
	}

	public int getSize(){
		return this._EdgeList.length();
	}
	
	@Override
	public String describe() {
		SimpleList<Vertex<K>> backup = this._NodeList;
        StringBuilder result = new StringBuilder();
        result.append("List: ");
        SimpleList<Vertex<K>>  temp = this._NodeList;
        for(int i = 0; i < this._NodeList.length(); i++) {
        	Vertex<K> temporal = temp.deleteHead();
        	if (temporal != null){
        		result.append(String.format("%s ", temporal.getElement().toString()));
        	}
        }
        result.append("\n");
        this._NodeList = backup;
        return result.toString();
	}

	@Override
	public boolean exists(K pk) {
		SimpleList<Vertex<K>> temp = this._NodeList;
		for(int i = 0; i < this._NodeList.length();i++){
			Vertex<K>  nodetodelete = temp.deleteHead();
			if (nodetodelete == null){
				break;
			}
			if (nodetodelete.getElement() == pk){
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
		return 0;
	}
	
	public SimpleList<Vertex<K>> getNodes(){
		return this._NodeList;
	}
	
	public SimpleList<Edge<K>> getEdges(){
		return this._EdgeList;
	}
	
	// calcular ruta más rapida.
	
	public void DijsktraAlgorithm(){}

}
