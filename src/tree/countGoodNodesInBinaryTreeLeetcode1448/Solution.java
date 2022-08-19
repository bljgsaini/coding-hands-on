package tree.countGoodNodesInBinaryTreeLeetcode1448;

import tree.TreeNode;

//https://leetcode.com/problems/count-good-nodes-in-binary-tree/
public class Solution {
    public static void main(String[] args) {

    }

    public int goodNodes(TreeNode root) {
        return goodNodesUtil(root, Integer.MIN_VALUE);
    }

    public int goodNodesUtil(TreeNode root, int prevMaxValue){
        if(root == null ) return 0;

        if(root.val >= prevMaxValue){
            prevMaxValue = root.val;
            return 1 + goodNodesUtil(root.left, prevMaxValue) + goodNodesUtil(root.right, prevMaxValue);
        }

        return goodNodesUtil(root.left, prevMaxValue) + goodNodesUtil(root.right, prevMaxValue);

    }

}
