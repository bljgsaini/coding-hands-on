package graph.edundantConnectionLeetcode684;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/redundant-connection/description/
public class Solution {

    public static void main(String[] args) {

    }

    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, Integer> parentMap = new HashMap<>();
        for( int[] edge : edges){
            if(!parentMap.containsKey(edge[0])) {
                parentMap.put(edge[0], edge[0]);
            }
            if(!parentMap.containsKey(edge[1])) {
                parentMap.put(edge[1], edge[1]);
            }
            int rootU = find(parentMap, edge[0]);
            int rootV = find(parentMap, edge[1]);
            if(rootU == rootV){
                return new int[]{edge[0], edge[1]};
            }
            union(parentMap, rootU, rootV);
        }
        return new int[]{-1, -1};
    }

    public int find(Map<Integer, Integer> parentMap, int v){
        if(parentMap.get(v) == v) return v;
        parentMap.put(v, find(parentMap, parentMap.get(v)));
        return parentMap.get(v);
    }

    public void union(Map<Integer, Integer> parentMap, int u, int v){
        parentMap.put(v, u);
    }

}
