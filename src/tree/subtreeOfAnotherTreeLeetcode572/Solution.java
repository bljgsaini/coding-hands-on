package tree.subtreeOfAnotherTreeLeetcode572;

import tree.TreeNode;

//https://leetcode.com/problems/subtree-of-another-tree/

/* Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.

Example 1:
Input: root = [3,4,5,1,2], subRoot = [4,1,2]
Output: true

Example 2:
Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
Output: false

Constraints:

The number of nodes in the root tree is in the range [1, 2000].
The number of nodes in the subRoot tree is in the range [1, 1000].
-104 <= root.val <= 104
-104 <= subRoot.val <= 104
*/
public class Solution {
    public static void main(String[] args) {

    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) return true;
        if(root == null || subRoot == null ) return false;
        if(isIdentical(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean isIdentical(TreeNode p, TreeNode q) {
        if(p == null && q == null ) return true;
        if(p == null || q == null ) return false;
        return p.val == q.val && isIdentical(p.left, q.left) && isIdentical(p.right, q.right);
    }


    public boolean isSubtreeString(TreeNode root, TreeNode subRoot) {
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        String rootString = sb.toString();
        sb = new StringBuilder();
        preOrder(subRoot, sb);
        String subRootString = sb.toString();
        return rootString.indexOf(subRootString)>=0;
    }

    public void preOrder(TreeNode root, StringBuilder sb){
        if(root == null ){
            sb.append("null");
            return;
        }
        sb.append("#");
        sb.append(root.val);
        preOrder(root.left, sb);
        preOrder(root.right, sb);
    }


}
