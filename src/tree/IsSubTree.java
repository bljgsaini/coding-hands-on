package tree;

public class IsSubTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	boolean isSumTree(TreeNode root)
	{
             if(root == null) return true;
            
            if(root.val*2 == treeSum(root)){
                return true;
            }
            return false;
             
	}
	
	int treeSum(TreeNode root)
	{
	    if(root == null) return 0;
	    if(root.left ==null && root.right == null) return root.val;
	    return root.val + treeSum(root.left) + treeSum(root.right);
             
	}
	
}
