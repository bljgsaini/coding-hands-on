package graph;


import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class GraphRepresentation {

	public static void main(String[] args) throws IOException {
		
		
		graphRepresentationUsingLinkedListArray();
	}
	
	public static void graphRepresentationUsingLinkedListArray() {
		int V = 5;
		
		LinkedList<Integer> adj[] = new LinkedList[V];
		
		for(int i=0; i<V; i++) {
			adj[i] = new LinkedList<Integer>();
		}
		
		addEdge(adj, 0, 1);
		addEdge(adj, 0, 4);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);
        
        
        for(int i=0; i<V; i++) {
			System.out.print(i);
			for(int j = 0; j< adj[i].size(); j++) {
				System.out.print( " -> " +  adj[i].get(j));
			}
			System.out.println();
		}
		
		
	}
	
	public static void graphRepresentationUsingList() {
		
		int V = 5;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for(int i=0; i<V; i++) {
			adj.add(i, new ArrayList<Integer>());
		}
		
		addEdge(adj, 0, 1);
		addEdge(adj, 0, 4);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);
		
		for(int i=0; i<V; i++) {
			System.out.print(i);
			for(int j = 0; j< adj.get(i).size(); j++) {
				System.out.print( " -> " +  adj.get(i).get(j));
			}
			System.out.println();
		}
		
	}
	
	
	public static void addEdge( ArrayList< ArrayList<Integer> > adj, int u, int v) {
		adj.get(u).add(v);
		adj.get(v).add(u);
	}
	
	public static void addEdge( LinkedList<Integer> adj[], int u, int v) {
		adj[u].add(v);
		adj[v].add(u);
	}
	

}
