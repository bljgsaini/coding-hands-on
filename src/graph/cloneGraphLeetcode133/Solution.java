package graph.cloneGraphLeetcode133;

import java.util.*;


//https://leetcode.com/problems/clone-graph/
public class Solution {
    public static void main(String[] args) {

    }

    Node root;

    public Node cloneGraph(Node node) {
        root = null;
        if(node == null ) return root;
        Set<Integer> visited = new HashSet();
        Map<Integer, Node> map = new HashMap();
        solve(node, -1, visited, map);
        return root;
    }

    public void solve(Node node, int parent, Set<Integer> visited, Map<Integer, Node> map){
        if(parent == -1){
            root = new Node(node.val);
            map.put(node.val, root);
        }else{
            Node childNode = map.getOrDefault(node.val, new Node(node.val));
            map.put(node.val, childNode);
            Node parentNode = map.get(parent);
            parentNode.neighbors.add(childNode);
        }

        if(visited.contains(node.val)) return;
        visited.add(node.val);

        for(Node temp: node.neighbors){
            solve(temp, node.val, visited, map);
        }
    }

    public Node cloneGraphArray(Node node) {
        root = null;
        if(node == null ) return root;
        boolean []visited = new boolean[101];
        Node[] map = new Node[101];
        solve(node, -1, visited, map);
        return root;
    }

    public void solve(Node node, int parent, boolean[] visited, Node[] map){
        if(parent == -1){
            root = new Node(node.val);
            map[node.val] =  root;
        }else{

            if(map[node.val] == null){
                map[node.val] = new Node(node.val);
            }
            Node childNode = map[node.val];
            Node parentNode = map[parent];
            parentNode.neighbors.add(childNode);
        }

        if(visited[node.val]) return;
        visited[node.val] = true;

        for(Node temp: node.neighbors){
            solve(temp, node.val, visited, map);
        }
    }


    public Node cloneGraphWithDFS(Node node) {
        return DFS(node);
    }


    public Node DFS(Node node){
        if(node == null ) return null;
        Map<Integer, Node> map = new HashMap();
        Set<Integer> visited = new HashSet();
        Deque<Node> stack = new ArrayDeque();

        Node root = new Node(node.val);
        map.put(node.val, root);
        visited.add(node.val);
        stack.push(node);
        while(stack.size() != 0){
            Node parent = stack.pop();
            for(Node child: parent.neighbors){
                Node newChild = map.getOrDefault(child.val, new Node(child.val));
                map.put(child.val, newChild);
                map.get(parent.val).neighbors.add(newChild);
                if(!visited.contains(child.val)){
                    visited.add(child.val);
                    stack.push(child);
                }
            }
        }

        return root;
    }


    public Node cloneGraphWithBFS(Node node) {
        return BFS(node);
    }

    public Node BFS(Node node){
        if(node == null ) return null;
        Map<Integer, Node> map = new HashMap();
        Set<Integer> visited = new HashSet();
        Deque<Node> stack = new ArrayDeque();

        Node root = new Node(node.val);
        map.put(node.val, root);
        visited.add(node.val);
        stack.offer(node);
        while(stack.size() != 0){
            Node parent = stack.poll();
            for(Node child: parent.neighbors){
                Node newChild = map.getOrDefault(child.val, new Node(child.val));
                map.put(child.val, newChild);
                map.get(parent.val).neighbors.add(newChild);
                if(!visited.contains(child.val)){
                    visited.add(child.val);
                    stack.offer(child);
                }
            }
        }

        return root;
    }


}


class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
