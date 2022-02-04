package tree;

import java.util.HashSet;
import java.util.Set;

//653. Two Sum IV - Input is a BST
public class TwoSumIV_BST_653 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        if(findTarget(root, 18)){
            System.out.println("true");
        }else{
            System.out.println("false");
        }

    }

    public static boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return findTargetUtil(root, set, k);
    }

    public static boolean findTargetUtil(TreeNode root, Set<Integer>set, int k){
        if(root == null ) return false;
        if(findTargetUtil(root.left, set, k)) return true;
        if(set.contains(k-root.val)) return true;
        set.add(root.val);
        return findTargetUtil(root.right, set, k);
    }

}
