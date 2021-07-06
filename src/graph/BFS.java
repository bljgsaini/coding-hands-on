package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

	public static void main(String[] args) {
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
        
        ArrayList<Integer> ans = bfsOfGraph(V, adj);
        
        for(Integer value : ans) {
        	System.out.println(value + " ");
        }

	}
	
	//Function to return Breadth First Traversal of given graph.
    public static ArrayList<Integer> bfsOfGraph(int V,ArrayList<ArrayList<Integer>> adj)
    {
        boolean visited[] = new boolean[V];
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        
        q.add(0);
        visited[0] = true;
        
        while(q.size() > 0){
            int u = q.poll();
            ans.add(u);
            
            for(int i=0; i< adj.get(u).size(); i++){
                int v = adj.get(u).get(i);
                if(visited[v] == false){
                    q.add(v);
                    visited[v] = true;
                }
            }
        }
        return ans;
        
    }

    public static void addEdge( ArrayList< ArrayList<Integer> > adj, int u, int v) {
		adj.get(u).add(v);
		adj.get(v).add(u);
	}
    
}
