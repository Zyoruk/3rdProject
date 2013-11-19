import static org.junit.Assert.*;

import org.junit.Test;

import datastructs.graphs.Graph;
import datastructs.graphs.Vertex;


public class GraphTester<K> {

	@Test
	public void test() {
		createGraph();
	}
	
	private void createGraph(){
		Graph<String> testGraph = new Graph<String>();
		
		//Create vertexes to add
		Vertex<String> vertex1 =  new Vertex<String>();
		Vertex<String> vertex2 =  new Vertex<String>();
		Vertex<String> vertex3 =  new Vertex<String>();
		Vertex<String> vertex4 =  new Vertex<String>();
		Vertex<String> vertex5 =  new Vertex<String>();
		Vertex<String> vertex6 =  new Vertex<String>();
		Vertex<String> vertex7 =  new Vertex<String>();
		Vertex<String> vertex8 =  new Vertex<String>();
		Vertex<String> vertex9 =  new Vertex<String>();
		Vertex<String> vertex0 =  new Vertex<String>();
		
		//Setting every node an element
		System.out.println("Testing if every node got the element set");
		vertex1.setElement("A");
		System.out.println("-Set A" + " got " + vertex1.getElement());
		vertex2.setElement("B");
		System.out.println("-"+"Set B" + " got "+vertex2.getElement());
		vertex3.setElement("C");
		System.out.println("-"+ "Set C" + " got " +vertex3.getElement());
		vertex4.setElement("D");
		System.out.println("-"+"Set D" + " got " +vertex4.getElement());
		vertex5.setElement("E");
		System.out.println("-"+"Set E" + " got " +vertex5.getElement());
		vertex6.setElement("F");
		System.out.println("-"+"Set F" + " got " +vertex6.getElement());
		vertex7.setElement("G");
		System.out.println("-"+"Set G" + " got " +vertex7.getElement());
		vertex8.setElement("H");
		System.out.println("-"+"Set H" + " got " +vertex8.getElement());
		vertex9.setElement("I");
		System.out.println("-"+ "Set I" + " got " +vertex9.getElement());
		vertex0.setElement("J");
		System.out.println("-"+"Set J" + " got " +vertex0.getElement());
		System.out.println("END OF TEST\n");
		
		//Add them to the graph
		System.out.println("Testing to add every node");
		testGraph.addNode(vertex1);
		testGraph.addNode(vertex2);
		testGraph.addNode(vertex3);
		testGraph.addNode(vertex4);
		testGraph.addNode(vertex5);
		testGraph.addNode(vertex6);
		testGraph.addNode(vertex7);
		testGraph.addNode(vertex8);
		testGraph.addNode(vertex9);
		testGraph.addNode(vertex0);
		System.out.println("Graph Nodes : ");
		System.out.println(testGraph.describe());
		System.out.println("END OF TEST\n");
		
		//
		System.out.println("testing if a node exists");
		System.out.println(testGraph.describe());
		System.out.println("Is there a node <A>? " + testGraph.exists("A"));
		System.out.println("Is there a node <Z>? " + testGraph.exists("Z"));
		System.out.println("Is there a node <B>? " + testGraph.exists("B"));
		System.out.println("END OF TEST\n");
		//
	}
}
