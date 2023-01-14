package graph.dijkstraAlgorithmGFG;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1
class Solution{

    public static void main(String[] args) {

    }

    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S){
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a, b)-> a.dist - b.dist);
        Map<Integer, Pair> map = new HashMap<Integer, Pair>();
        for(int i=0; i<V; i++){
            Pair pair = (i==S) ?  new Pair(i, 0) : new Pair(i, Integer.MAX_VALUE);
            pq.offer(pair);
            map.put(i, pair);
        }

        List<Pair> result = new ArrayList<Pair>();
        while(pq.size() > 0){
            Pair pair = pq.poll();
            result.add(pair);
            for( ArrayList<Integer> child : adj.get(pair.vertex)){
                if(pair.dist + child.get(1) < map.get(child.get(0)).dist ){
                    pq.remove(map.get(child.get(0)));
                    map.put(child.get(0), new Pair(child.get(0), pair.dist + child.get(1)));
                    pq.offer(map.get(child.get(0)));
                }
            }
        }

        int []ans = new int[V];
        for(Pair pair : result){
            ans[pair.vertex] = pair.dist;
        }
        return ans;
    }
}

class Pair{
    int vertex;
    int dist;
    public Pair(int vertex, int dist){
        this.vertex = vertex;
        this.dist = dist;
    }
}
