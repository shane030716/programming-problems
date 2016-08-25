import java.util.*;
import graph.*;

/*Given a undirected graph with weights, 
 * return the sum of the weight of each path between two nodes (shortest path between two vertices). 
 * Assume there are no cycles.

Example:
Input:
       A
       | 1
       B
   2 /   \ 3
    C     D
    
Output:
18
since 
A to B has weight 1
A to C has weight 3
A to D has weight 4
B to C has weight 2
B to D has weight 3
C to D has weight 5 

 */

class GraphNodePair implements Comparable<GraphNodePair> {
	String first;
	String second;

	public GraphNodePair(String first, String second) {
		if (first.compareTo(second) < 0) {
			this.first = first;
			this.second = second;	
		} else {
			this.first = second;
			this.second = first;
		}
		
	}
	
	@Override
	public int compareTo(GraphNodePair another) {
		// TODO Auto-generated method stub
		int firstCompare = this.first.compareTo(another.first);
		if (firstCompare == 0) {
			return this.second.compareTo(another.second);
		} else {
			return firstCompare;
		}
	}
}
public class SumOfWeightOfEachPathBetweenTwoNodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph graph = new Graph();
		graph.addNode("A");
		graph.addNode("B");
		graph.addNode("C");
		graph.addNode("D");
		
		graph.addEdge("A", "B", 1);
		graph.addEdge("B", "C", 2);
		graph.addEdge("B", "D", 3);
		
		TreeSet<GraphNodePair> pairSet = new TreeSet<GraphNodePair>();
		for (String nodeKey1 : graph.nodes.keySet()) {
			for (String nodeKey2: graph.nodes.keySet()) {
				if (nodeKey1.compareTo(nodeKey2) != 0) {
					GraphNodePair pair = new GraphNodePair(nodeKey1, nodeKey2);
					pairSet.add(pair);
				}
			}
		}
		
		HashSet<String> usedKey = new HashSet<String>();
		int sum = 0;
		for (GraphNodePair pair : pairSet) {
			System.out.println(pair.first + ", " + pair.second);
			if (!usedKey.contains(pair.first)) {
				graph.dijkstra(pair.first);
				usedKey.add(pair.first);
			}
			sum += graph.nodes.get(pair.second).distance;
		}
		
		System.out.println(sum);
	}

}
