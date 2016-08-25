package graph;

public class GraphDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph graph = new Graph();
		graph.addNode("A");
		graph.addNode("B");
		graph.addNode("C");
		graph.addNode("D");
		graph.addNode("E");
		graph.addNode("F");
		graph.addNode("G");
		graph.addNode("H");
		
		graph.addEdge("A", "B", 7);
		graph.addEdge("A", "C", 9);
		graph.addEdge("A", "F", 14);
		graph.addEdge("B", "C", 10);
		graph.addEdge("B", "D", 15);
		graph.addEdge("C", "D", 11);
		graph.addEdge("C", "F", 72);
		graph.addEdge("D", "E", 6);
		graph.addEdge("E", "F", 9);
		graph.addEdge("G", "H", 9);
		
		graph.dijkstra("A");
		graph.printAllPaths();
	}

}
