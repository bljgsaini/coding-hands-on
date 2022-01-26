package tree;

public class InsertInBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        InsertInBST insertInBST = new InsertInBST();

        root = insertInBST.insertIntoBST(root, 5);

        insertInBST.printBSTInorder(root);

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

    }

    public TreeNode insertIntoBST1(TreeNode root, int val) {
        if(root == null ) return new TreeNode(val);
        if(root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }else{
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }

    public void printBSTInorder(TreeNode root){
        if(root == null ) return;
        printBSTInorder(root.left);
        System.out.print(root.val + " ");
        printBSTInorder(root.right);
    }

}
