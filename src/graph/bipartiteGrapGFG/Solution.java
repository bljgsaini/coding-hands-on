package graph.bipartiteGrapGFG;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {

    }


    public boolean isBipartiteV2(int V, ArrayList<ArrayList<Integer>>adj){
        int[] color = new int[V];
        for(int i=0; i<V; i++){
            color[i] = -1;
        }
        for(int i=0; i<V; i++){
            if(color[i] == -1 && !DFS(i, 1, adj, color)) return false;
        }
        return true;
    }

    public boolean DFS(int start, int parentColor, ArrayList<ArrayList<Integer>>adj, int []color ){
        if(color[start] != -1){
            if(color[start] == parentColor) return false;
            return true;
        }
        color[start] = 1 - parentColor;
        for(int child : adj.get(start)){
            if(start != child && !DFS(child, color[start], adj, color) ) return false;
        }
        return true;
    }

    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj){
        Set<Integer> visited = new HashSet<Integer>();
        int[] color = new int[V];
        for(int i=0; i<V; i++){
            if(!DFS(i, adj, visited, color)) return false;
        }
        return true;
    }

    public boolean DFS(int source, ArrayList<ArrayList<Integer>>adj, Set<Integer> visited, int[] color  ){
        visited.add(source);
        for(int child : adj.get(source)){
            if(!visited.contains(child)){
                color[child] = color[source] == 0 ? 1 : 0;
                if(!DFS(child, adj, visited, color)) return false;
            }else{
                if(source != child && color[source] == color[child]) return false;
            }
        }
        return true;
    }





}
