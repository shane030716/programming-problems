package graph;

public class GraphEdge{
	public GraphNode source;
	public GraphNode destination;
	public int weight;
	public GraphEdge(GraphNode source, GraphNode destination, int weight) {
		this.source = source;
		this.destination = destination;
		this.weight = weight;
		Integer c;
		
	}
	
	public GraphNode getSource() {
		return source;
	}


}
