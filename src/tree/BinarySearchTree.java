package tree;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.w3c.dom.ls.LSOutput;

public class BinarySearchTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        //root = binarySearchTree.searchBST(root, 2);

        root = binarySearchTree.insertIntoBST(root, 5);

        binarySearchTree.printBSTInorder(root);

    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
            if(root == null ) return new TreeNode(val);
            TreeNode head = root;
            TreeNode prev = null;
            while(root != null ) {
                prev = root;
                if(root.val < val) root = root.right;
                else root = root.left;
            }
            if(prev.val < val) prev.right = new TreeNode(val);
            else prev.left = new TreeNode(val);
            return head;


        /*if(root == null ) return new TreeNode(val);
        if(root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }else{
            root.left = insertIntoBST(root.left, val);
        }
        return root;*/
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null || root.val == val) return root;
        if(root.val < val ) return searchBST(root.right, val);
        return searchBST(root.left, val);
    }

    public void printBSTInorder(TreeNode root){
        if(root == null ) return;
        printBSTInorder(root.left);
        System.out.print(root.val + " ");
        printBSTInorder(root.right);
    }

}
