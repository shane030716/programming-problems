package graph;

import java.util.*;

public class GraphNode implements Comparable<GraphNode> {
	public String data;
	public List<GraphEdge> edges = new ArrayList<GraphEdge>();
	
	public GraphNode previous; //previous node for shortest path
	public int distance = Integer.MAX_VALUE; //distance from source for shortest path
	
	public GraphNode(String data) {
		this.data = data;
	}
	
	public void addEdge(GraphEdge edge) {
		this.edges.add(edge);
	}
	
	public void printPath() {
		if (this == this.previous) {
			System.out.print(this.data);
		} else if (this.previous == null){
			System.out.print("Cannot reach " + this.data);
		} else {
			this.previous.printPath();
			System.out.printf(" -> %s(%d)", this.data, this.distance);
		}
		
	}

	public int compareTo(GraphNode other) {
		return this.distance - other.distance;
	}
	
	
}
