package tree.binaryTreePathsLeetcode257;

import tree.TreeNode;

import java.util.*;

public class Solution {

    public static void main(String[] args) {


    }

    public List<String> binaryTreePathsBFS(TreeNode root) {
        List<String> list = new ArrayList();
        Queue<TreeNode> q= new LinkedList();
        Queue<String> qStr = new LinkedList();

        q.offer(root);
        qStr.offer("");

        while(!q.isEmpty()){

            TreeNode node = q.poll();
            String prevStr = qStr.poll();

            if(node.left == null && node.right == null ) {
                list.add(prevStr + node.val);
            }
            if(node.left != null ){
                q.offer(node.left);
                qStr.offer(prevStr + node.val + "->");
            }
            if(node.right != null ){
                q.offer(node.right);
                qStr.offer(prevStr + node.val + "->");
            }
        }

        return list;
    }

    public List<String> binaryTreePathsDFS(TreeNode root) {
        List<String> list = new ArrayList();
        Deque<TreeNode> dequeNodes = new ArrayDeque();
        Deque<String> dequeStr = new ArrayDeque();

        dequeNodes.push(root);
        dequeStr.push("");

        while(!dequeNodes.isEmpty()){

            TreeNode node = dequeNodes.pop();
            String prevStr = dequeStr.pop();

            if(node.left == null & node.right == null ) {
                list.add(prevStr + String.valueOf(node.val));
            }
            if(node.left != null ){
                dequeNodes.push(node.left);
                dequeStr.push(prevStr + node.val + "->");
            }
            if(node.right != null ){
                dequeNodes.push(node.right);
                dequeStr.push(prevStr + node.val + "->");
            }
        }

        return list;
    }


    public List<String> binaryTreePaths(TreeNode root) {

        List<String> list = new LinkedList();

        if(root == null ) return list;

        if(root.left == null && root.right == null ) {
            list.add(String.valueOf(root.val));
            return list;
        }

        for(String s: binaryTreePaths(root.left)){
            list.add(String.valueOf(root.val) + "->" + s);
        }

        for(String s : binaryTreePaths(root.right)){
            list.add(String.valueOf(root.val) + "->" + s);
        }

        return list;

    }
}
