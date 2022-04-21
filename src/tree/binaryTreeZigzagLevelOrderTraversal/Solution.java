package tree.binaryTreeZigzagLevelOrderTraversal;

import tree.TreeNode;

import java.util.*;

//103. Binary Tree Zigzag Level Order Traversal
public class Solution {
    public static void main(String[] args) {

    }

    public List<List<Integer>> zigzagLevelOrderOther(TreeNode root) {

        List<List<Integer>> ans = new ArrayList();
        if(root == null ) return ans;

        Deque<TreeNode> queue = new ArrayDeque();
        int count = -1;
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList();
            int n = queue.size();
            if(count == -1 ){
                for(int i=0; i<n; i++){
                    TreeNode node = queue.removeFirst();
                    list.add(node.val);
                    if(node.left != null ) queue.addLast(node.left);
                    if(node.right != null ) queue.addLast(node.right);
                }
            }else{
                for(int i=0; i<n; i++){
                    TreeNode node = queue.removeLast();
                    list.add(node.val);
                    if(node.right != null ) queue.addFirst(node.right);
                    if(node.left != null ) queue.addFirst(node.left);
                }

            }
            ans.add(list);
            count = -count;
        }
        return ans;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList();
        if(root == null ) return ans;

        Queue<TreeNode> queue = new LinkedList();
        int count = 1;
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList();
            int n = queue.size();
            for(int i=0; i<n; i++){
                TreeNode node = queue.poll();
                if(node.left != null ) queue.add(node.left);
                if(node.right != null ) queue.add(node.right);
                list.add(node.val);
            }
            if(count%2 == 0 ){
                Collections.reverse(list);
            }
            ans.add(list);
            count++;
        }
        return ans;
    }

}
