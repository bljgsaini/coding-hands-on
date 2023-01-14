package graph.minCostPathGFG;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


//https://practice.geeksforgeeks.org/problems/minimum-cost-path3833/1
class Solution{

    public static void main(String[] args) {

    }

    public int minimumCostPath(int[][] grid){
        int n = grid.length;
        boolean [][]visited = new boolean[grid.length][grid.length];
        int [][]dist = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        solve(0, 0, grid, visited, dist);

        return dist[n-1][n-1];
    }

    public void solve(int sourceI, int sourceJ, int [][]grid, boolean [][]visited, int [][]dist){
        dist[sourceI][sourceJ] = grid[sourceI][sourceJ];
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b)-> a.value - b.value);
        Map<String, Node> map = new HashMap<>();
        String key = sourceI + "#" + sourceJ;
        map.put( key, new Node(sourceI, sourceJ, dist[sourceI][sourceJ]) );
        pq.offer(map.get(key));
        int n = grid.length;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid.length; j++){
                Node node = pq.poll();
                visited[node.i][node.j] = true;
                updateAdjacentNode(node.i+1, node.j, visited, grid, pq, map, node, dist);
                updateAdjacentNode(node.i-1, node.j, visited, grid, pq, map, node, dist);
                updateAdjacentNode(node.i, node.j+1, visited, grid, pq, map, node, dist);
                updateAdjacentNode(node.i, node.j-1, visited, grid, pq, map, node, dist);
            }
        }

    }

    public void updateAdjacentNode(int i, int j, boolean [][]visited, int [][]grid, PriorityQueue<Node> pq, Map<String, Node> map, Node node, int [][]dist){
        if(i<0 || j < 0 || i>= grid.length || j>= grid.length || visited[i][j] || grid[i][j] + node.value >= dist[i][j] ) return ;
        dist[i][j] = grid[i][j] + node.value;
        String key = i + "#" + j;
        if(map.containsKey(key)){
            pq.remove(map.get(key));
            map.remove(key);
        }
        map.put(key, new Node(i, j, grid[i][j] + node.value) );
        pq.offer(map.get(key));
    }

    public int minimumCostPathBruteForceRecursiveBacktracking(int[][] grid){
        boolean [][]visited = new boolean[grid.length][grid.length];
        return DFS(0, 0, grid, visited);
    }

    public int DFS(int i, int j, int [][]grid, boolean [][]visited){
        if(i<0 || j<0 || i>=grid.length || j>=grid.length || visited[i][j]) return Integer.MAX_VALUE;
        if(i == grid.length-1 && j == grid.length-1 ) return grid[i][j];
        visited[i][j] = true;
        int []values = new int[4];
        values[0] = DFS(i+1, j, grid, visited);
        values[1] = DFS(i-1, j, grid, visited);
        values[2] = DFS(i, j+1, grid, visited);
        values[3] = DFS(i, j-1, grid, visited);
        visited[i][j] = false;
        int minValue = Integer.MAX_VALUE;
        for(int k=0; k<4; k++){
            minValue = Math.min(minValue, values[k]);
        }
        return (minValue == Integer.MAX_VALUE) ? minValue : minValue + grid[i][j];
    }

}

class Node{
    int i;
    int j;
    int value;
    public Node(int i, int j, int value){
        this.i = i;
        this.j = j;
        this.value = value;
    }
}

