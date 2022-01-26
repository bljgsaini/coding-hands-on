package tree;

public class IsValidBinarySearchTree {

    /* Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.


Example 1:


Input: root = [2,1,3]
Output: true
Example 2:


Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.


Constraints:

The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1
*/

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(8);
        IsValidBinarySearchTree isValidBinarySearchTree = new IsValidBinarySearchTree();

        System.out.println(isValidBinarySearchTree.isValidBST(root));
        System.out.println(isValidBinarySearchTree.isValidBST1(root));

    }

    public boolean isValidBST(TreeNode root) {
        return isValidBSTUtil(root, -2147483649.0, 2147483648.0);
    }

    public boolean isValidBSTUtil(TreeNode root, double min, double max){
        if(root == null ) return true;
        if( root.val <= min || root.val >= max ) return false;
        return isValidBSTUtil(root.left, min, root.val ) && isValidBSTUtil(root.right, root.val, max);
    }

    //another solution using Inorder Traversal - List should be sorted

    Long prev = Long.MIN_VALUE;
    public boolean isValidBST1(TreeNode root) {
        if(root == null ) return true;

        if(isValidBST(root.left) == false ) return false;
        if(prev >= root.val ) return false;
        prev = (long)root.val;
        return isValidBST(root.right);

    }


    /*public boolean isValidBST(TreeNode root) {
        return isValidBSTUtil(root, "#", "#");
    }

    public boolean isValidBSTUtil(TreeNode root, String min, String max){
        if(root == null ) return true;
        if( !min.equals("#") && root.val <= Integer.parseInt(min)
           || !max.equals("#") && root.val >= Integer.parseInt(max) ) return false;
        return isValidBSTUtil(root.left, min, String.valueOf(root.val)) && isValidBSTUtil(root.right, String.valueOf(root.val), max);
    }*/
}
