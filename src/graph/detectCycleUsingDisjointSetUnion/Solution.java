package graph.detectCycleUsingDisjointSetUnion;

import java.util.ArrayList;

//https://practice.geeksforgeeks.org/problems/detect-cycle-using-dsu/1
// https://www.geeksforgeeks.org/union-by-rank-and-path-compression-in-union-find-algorithm/ -> optimized
class Solution {

    public static void main(String[] args) {

    }

    //Function to detect cycle using DSU in an undirected graph.
    public int detectCycle(int V, ArrayList<ArrayList<Integer>> adj){
        int []parent = new int[V];
        for(int i=0; i<V; i++){
            parent[i] = i;
        }
        for(int u=0; u<V; u++){
            for(int v : adj.get(u)){
                if(u <=v && unionFindCycle(u, v, parent)) return 1;
            }
        }
        return 0;
    }

    public boolean unionFindCycle(int u, int v, int []parent){
        int rootU = find(u, parent);
        int rootV = find(v, parent);
        if( rootU == rootV ) return true;
        union(parent, rootU, rootV);
        return false;
    }

    public int find(int node, int []parent){
        if(parent[node] == node) return node;
        return find(parent[node], parent);
    }

    /* The idea is to always attach smaller depth tree under the root of the deeper tree.
    This technique is called union by rank.
    The term rank is preferred instead of height because if path compression technique
    (we have discussed it below) is used, then rank is not always equal to height.
    Also, size (in place of height) of trees can also be used as rank.
    Using size as rank also yields worst case time complexity as O(Logn). */
    public int findOptimized(int node, int []parent){
        if(parent[node] == node) return node;
        parent[node] = find(parent[node], parent);
        return parent[node];
    }

    public void union(int []parent, int u, int v){
        parent[v] = u;
    }

}
