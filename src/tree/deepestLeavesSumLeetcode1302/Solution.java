package tree.deepestLeavesSumLeetcode1302;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {

    }


    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        int prevSum = 0;
        while(!queue.isEmpty()){
            int n =queue.size();
            int sum = 0;
            for(int i=0; i<n; i++){
                TreeNode node = queue.poll();
                sum += node.val;
                if(node.left != null ) queue.add(node.left);
                if(node.right != null ) queue.add(node.right);
            }
            prevSum = sum;
        }
        return prevSum;
    }

}

