package tree.sameTreeLeetcode100;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/same-tree/
/* Given the roots of two binary trees p and q, write a function to check if they are the same or not.
Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

Example 1:
Input: p = [1,2,3], q = [1,2,3]
Output: true

Example 2:
Input: p = [1,2], q = [1,null,2]
Output: false

Example 3:
Input: p = [1,2,1], q = [1,1,2]
Output: false

Constraints:
The number of nodes in both trees is in the range [0, 100].
-104 <= Node.val <= 104 */
public class Solution {
    public static void main(String[] args) {

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSameTreeIterative(p, q);
    }

    public boolean isSameTreeIterative(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList();
        queue.add(p);
        queue.add(q);
        while(!queue.isEmpty()){
            TreeNode root1 = queue.poll();
            TreeNode root2 = queue.poll();
            if(root1==null && root2==null) continue;
            if(root1==null || root2==null || root1.val!=root2.val) return false;
            queue.add(root1.left);
            queue.add(root2.left);
            queue.add(root1.right);
            queue.add(root2.right);
        }
        return true;
    }

    public boolean isSameTreeRecursive(TreeNode p, TreeNode q) {
        if(p == null && q == null ) return true;
        if(p == null || q == null ) return false;
        return p.val == q.val && isSameTreeRecursive(p.left, q.left) && isSameTreeRecursive(p.right, q.right);
    }

}
