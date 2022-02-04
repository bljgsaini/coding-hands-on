package tree;

//235. Lowest Common Ancestor of a Binary Search Tree
public class LowestCommonAncestorBST {

    public static void main(String[] args) {

    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lowestCommonAncestorUtil(root, Math.min(p.val, q.val), Math.max(p.val, q.val));
    }

    public TreeNode lowestCommonAncestorUtil(TreeNode root, int p, int q) {
        if(root == null ) return null;
        if(p <= root.val && root.val <= q) return root;
        else if(q < root.val) return lowestCommonAncestorUtil(root.left, p, q);
        else return lowestCommonAncestorUtil(root.right, p, q);
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null ) return null;
        if(Math.min(p.val, q.val) <= root.val && root.val <= Math.max(p.val, q.val)) return root;
        else if(q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        else return lowestCommonAncestor(root.right, p, q);
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root.val > p.val && root.val > q.val ) return lowestCommonAncestor(root.left, p, q);
        else if(root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
        return root;
    }

}
