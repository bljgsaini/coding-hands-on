package graph.detectCycleInDirectedGraph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

//https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
class Solution {

    public static void main(String[] args) {

    }

    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        for(int i=0; i<V; i++){
            Set<Integer> visited = new HashSet<Integer>();
            if(!visited.contains(i) && DFS(i, adj, visited)) return true;
        }
        return false;
    }

    public boolean DFS(int root, ArrayList<ArrayList<Integer>> adj, Set<Integer> visited){
        if(visited.contains(root)) return true;
        visited.add(root);
        for(  int child : adj.get(root) ){
            if(DFS(child, adj, visited)) return true;
        }
        return false;
    }

}
