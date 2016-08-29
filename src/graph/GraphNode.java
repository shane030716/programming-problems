package graph;

import java.util.*;

public class GraphNode implements Comparable<GraphNode> {
	public String data;
	public List<GraphEdge> edges = new ArrayList<GraphEdge>();
	public Set<GraphNode> neighbors = new HashSet<GraphNode>();
	
	public GraphNode previous; //previous node for shortest path
	public int distance = Integer.MAX_VALUE; //distance from source for shortest path
	public boolean checked = false;
	public int level = 0;
	
	public GraphNode(String data) {
		this.data = data;
	}
	
	public void addEdge(GraphEdge edge) {
		this.edges.add(edge);
		this.neighbors.add(edge.destination);
		
	}
	
	public void reset() {
		this.previous = null;
		this.distance = Integer.MAX_VALUE;
		this.checked = false;
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
	
	public String toString() {
		return this.data;
	}

	public int compareTo(GraphNode other) {
		return this.distance - other.distance;
	}
	
	
}
