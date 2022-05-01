package tree.balanceBSTLeetcode1382;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

//1382. Balance a Binary Search Tree
public class Solution {


    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList();

        inOrderTraversal(root, list);

        return constructBST(list, 0, list.size()-1);

    }

    public void inOrderTraversal(TreeNode root, List<Integer> list){
        if(root == null ) return;
        inOrderTraversal(root.left, list);
        list.add(root.val);
        inOrderTraversal(root.right, list);
    }


    public TreeNode constructBST(List<Integer> list, int low, int high){
        if(low > high ) return null;
        int mid = (low + high) / 2;
        TreeNode root = new TreeNode( list.get(mid));;
        root.left = constructBST(list, low, mid-1);
        root.right = constructBST(list, mid+1, high);
        return root;
    }

}
