package tree.balancedBinaryTreeLeetcode110;

import tree.TreeNode;

//https://leetcode.com/problems/balanced-binary-tree/
/* Given a binary tree, determine if it is height-balanced.
For this problem, a height-balanced binary tree is defined as:
a binary tree in which the left and right subtrees of every node differ in height by no more than 1.

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: true

Example 2:
Input: root = [1,2,2,3,3,null,null,4,4]
Output: false

Example 3:
Input: root = []
Output: true

Constraints:

The number of nodes in the tree is in the range [0, 5000].
-104 <= Node.val <= 104 */
public class Solution {
    public static void main(String[] args) {

    }

    boolean ans = true;

    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return ans;
    }

    public int maxDepth(TreeNode root ){
        if(root == null ) return 0;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        if( Math.abs(l-r) > 1) ans= false;
        return 1 + Math.max(l, r);
    }

}
