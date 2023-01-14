package graph.detectCycleInUndirectedGraphGFG;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
class Solution {

    public static void main(String[] args) {

    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        Set<Integer> visited = new HashSet<Integer>();
        for(int i=0; i<V; i++){
            if(!visited.contains(i) && DFS(i, -1, adj, visited)) return true;
        }
        return false;
    }

    public boolean DFS(int root, int parent, ArrayList<ArrayList<Integer>> adj, Set<Integer> visited){
        if(visited.contains(root)) return true;
        visited.add(root);
        for(  int child :  adj.get(root) ){
            if(child != parent && DFS(child, root, adj, visited)) return true;
        }
        return false;
    }


    public boolean BFS(int root, ArrayList<ArrayList<Integer>> adj, Set<Integer> visited){
        Queue<Node> queue = new ArrayDeque<Node>();
        queue.add(new Node(root, -1));
        visited.add(root);
        while(queue.size() != 0){
            Node node = queue.poll();
            for(int child : adj.get(node.val)){
                if(!visited.contains(child)){
                    queue.add(new Node(child, node.val));
                    visited.add(child);
                }else if(child != node.parent) return true;
            }
        }
        return false;
    }

}

class Node{
    int val;
    int parent;
    public Node(int val, int parent){
        this.val = val;
        this.parent = parent;
    }
}
