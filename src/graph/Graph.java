package graph;


import java.util.*;

public class Graph {

	public Map<String, GraphNode> nodes = new HashMap<String, GraphNode>();
	
	public void addNode(String key) {
		if (nodes.containsKey(key)) {
			System.out.print("Key \"" + key + "\" already exists");
			return;
		}
		GraphNode node = new GraphNode(key);
		nodes.put(key, node);
	}
	
	public GraphNode getNode(String key) {
		return this.nodes.get(key);
	}
	
	public void addEdge(String start, String end) {
		addEdge(start, end, 1);
	}
	
	public void addEdge(String start, String end, int weight) {
		GraphNode startNode = nodes.get(start);
		if (startNode == null){
			System.out.println("Node \"" + start + "\" does not exist");
			return;
		}
		GraphNode endNode = nodes.get(end);
		if (endNode == null){
			System.out.println("Node \"" + end + "\" does not exist");
			return;
		}
		
		GraphEdge edgeStart = new GraphEdge(startNode, endNode, weight);
		GraphEdge edgeEnd = new GraphEdge(endNode, startNode, weight);
		
		startNode.addEdge(edgeStart);
		endNode.addEdge(edgeEnd);
	}
	
	public void dijkstra(String start) {
		GraphNode source = nodes.get(start);
		if (source == null){
			System.out.println("Node \"" + start + "\" does not exist");
		}
		
		NavigableSet<GraphNode> queue = new TreeSet<GraphNode>();
		for (GraphNode node: this.nodes.values()) {
			node.previous = node == source ? source : null;
			node.distance = node == source ? 0 : Integer.MAX_VALUE;
			queue.add(node);
		}
		
		dijkstra(queue);
	}
	
	private void dijkstra(NavigableSet<GraphNode> queue) {
		GraphNode u, v;
		while (!queue.isEmpty()) {
			u = queue.pollFirst();
			for (GraphEdge edge : u.edges) {
				 v = edge.destination;
				 int alternateDistance = u.distance + edge.weight;
				 if (alternateDistance < v.distance) {
					 queue.remove(v);
					 v.distance = alternateDistance;
					 v.previous = u;
					 queue.add(v);
				 }
			}
		}
	}
	
	public void breadthFristSearch(GraphNode node) {
		LinkedList<GraphNode> queue = new LinkedList<GraphNode>();
		node.checked = true;
		queue.addLast(node);
		
		while (!queue.isEmpty()) {
			GraphNode n = queue.pollFirst();
			System.out.print(n);
			System.out.print(", ");
			for (GraphNode neighbor: n.neighbors) {
				if (!neighbor.checked) {
					neighbor.checked = true;
					neighbor.level = n.level + 1;
					queue.addLast(neighbor);
				}
			}
		}
	}
	
	public void reset() {
		for (GraphNode node: this.nodes.values()) {
			node.reset();
		}
	}
	
	public void printPath(String end) {
		GraphNode endNode = nodes.get(end);
		if (endNode == null){
			System.out.println("Node \"" + end + "\" does not exist");
		}
		
		endNode.printPath();
		System.out.println();
	}
	
	public void printAllPaths() {
		for (GraphNode node: this.nodes.values()) {
			node.printPath();
			System.out.println();
		}
	}
}
