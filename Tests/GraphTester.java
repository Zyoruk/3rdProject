import org.junit.Test;

import datastructs.graphs.Graph;
import datastructs.graphs.Vertex;
import datastructs.simplelist.SimpleList;
import datastructs.simplelist.SimpleListNode;


public class GraphTester<K> {
	Graph<String> ourGraph = CreateSetAddNode();
	@Test
	public void test() {

		System.out.println("Test Begin \n");
		System.out.println(ourGraph.describe()+ "\n");
		
		System.out.println("Is there a node <A>? " + ourGraph.exists("A"));
		System.out.println("Is there a node <Z>? " + ourGraph.exists("Z"));
		System.out.println("Is there a node <B>? " + ourGraph.exists("B"));
		System.out.println("Is there a node <as>? " + ourGraph.exists("as"));
		System.out.println("Is there a node <C>? " + ourGraph.exists("C"));
		System.out.println("Is there a node <J>? " + ourGraph.exists("J"));
		
		
		ourGraph.linkNodes("A", "B", 45);
		ourGraph.linkNodes("B", "C", 50);
		ourGraph.linkNodes("C", "D", 4);
		ourGraph.linkNodes("D", "E", 5);
		ourGraph.linkNodes("E", "F", 3);
		System.out.println("Number of vertexes" + ourGraph.getOrder() + "\n");
		System.out.println("Number of edges" + ourGraph.getSize() + "\n");
				
		ourGraph.removeVertex("A");
		ourGraph.removeVertex("D");
		System.out.println(ourGraph.describe());
		
		ourGraph.removeLink("A", "B");
		ourGraph.removeLink("A", "B");
		ourGraph.removeLink("B", "C");
		
		System.out.println(ourGraph.getSize());
		
		System.out.println(ourGraph.describe());
		
		ourGraph.Dijsktra("E", "F");

		
	}
	

	
	private Graph<String> CreateSetAddNode(){
		this.ourGraph = new Graph<String>();
		//Create vertexes to add
		Vertex<String> vertex1 =  new Vertex<String>("A",this.ourGraph);
		Vertex<String> vertex2 =  new Vertex<String>("B",this.ourGraph);
		Vertex<String> vertex3 =  new Vertex<String>("C",this.ourGraph);
		Vertex<String> vertex4 =  new Vertex<String>("D",this.ourGraph);
		Vertex<String> vertex5 =  new Vertex<String>("E",this.ourGraph);
		Vertex<String> vertex6 =  new Vertex<String>("F",this.ourGraph);
		Vertex<String> vertex7 =  new Vertex<String>("G",this.ourGraph);
		Vertex<String> vertex8 =  new Vertex<String>("H",this.ourGraph);
		Vertex<String> vertex9 =  new Vertex<String>("I",this.ourGraph);
		Vertex<String> vertex0 =  new Vertex<String>("J",this.ourGraph);
		
		this.ourGraph.addNode(vertex1);
		this.ourGraph.addNode(vertex2);
		this.ourGraph.addNode(vertex3);
		this.ourGraph.addNode(vertex4);
		this.ourGraph.addNode(vertex5);
		this.ourGraph.addNode(vertex6);
		this.ourGraph.addNode(vertex7);
		this.ourGraph.addNode(vertex8);
		this.ourGraph.addNode(vertex9);
		this.ourGraph.addNode(vertex0);
		
		ourGraph.linkNodes("A", "B", 45);
		ourGraph.linkNodes("B", "C", 50);
		ourGraph.linkNodes("C", "D", 4);
		ourGraph.linkNodes("D", "E", 5);
		ourGraph.linkNodes("E", "F", 3);
		
		
		return this.ourGraph;
	}
	
	public void describe(Graph<String> testGraph){
		SimpleList<Vertex<String>>temp =testGraph.getVertexes();
		SimpleListNode<Vertex<String>> current = temp.getHead();
		SimpleListNode<Vertex<String>> nextTo = current.getNext();
		for(int i = 0 ; i < testGraph.getVertexes().length();i++){
			try{
				System.out.println(current.getElem().getElement() + "  "+nextTo.getElem().getElement());
				current = nextTo;
				nextTo = nextTo.getNext();
			}catch(NullPointerException e){
				break;
			}
		}
	}
}
