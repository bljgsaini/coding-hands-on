package graph;

import java.util.ArrayList;

public class DFS {

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
        
        ArrayList<Integer> ans = dfsOfGraph(V, adj);
        
        for(Integer value : ans) {
        	System.out.println(value + " ");
        }

	}
	
	
	public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean visited[] = new boolean[V];
        ArrayList<Integer> ans = new ArrayList<>();
        DFSUtil(0, adj, visited, ans);
        return ans;
    }
    
    public static void DFSUtil(int u, ArrayList<ArrayList<Integer>> adj, boolean visited[], ArrayList<Integer> ans){
        ans.add(u);
        visited[u] = true;
        for(int i=0; i<adj.get(u).size(); i++ ){
            int v = adj.get(u).get(i);
            if(!visited[v]){
                DFSUtil(v, adj, visited, ans);
            }
        } 
    }
    
    public static void addEdge( ArrayList< ArrayList<Integer> > adj, int u, int v) {
		adj.get(u).add(v);
		adj.get(v).add(u);
	}
	

}
