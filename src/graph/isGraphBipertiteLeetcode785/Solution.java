
package graph.isGraphBipertiteLeetcode785;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

//https://leetcode.com/problems/is-graph-bipartite/description/
class Solution {

    public static void main(String[] args) {

    }

    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int []color = new int[V];
        Arrays.fill(color, -1);
        for(int i=0; i<V; i++){
            if(color[i] == -1 && !bfs(i, color, graph)) return false;
        }
        return true;
    }

    public boolean bfs(int start, int []color, int [][] graph){
        Queue<Integer> queue = new ArrayDeque();
        color[start] = 0;
        queue.offer(start);
        while(queue.size() > 0){
            int node = queue.poll();
            for(int i=0; i<graph[node].length; i++){
                int v = graph[node][i];
                if( node != v ){
                    if(color[v] == -1){
                        color[v] = 1 - color[node];
                        queue.offer(v);
                    }else{
                        if(color[node] == color[v]) return false;
                    }
                }
            }
        }
        return true;
    }


}
