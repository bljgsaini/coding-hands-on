package tree;

public class IsSubTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	boolean isSumTree(Node root)
	{
             if(root == null) return true;
            
            if(root.data*2 == treeSum(root)){
                return true;
            }
            return false;
             
	}
	
	int treeSum(Node root)
	{
             if(root == null) return 0;
             
             if(root.left ==null && root.right == null) return root.data;
            
            
            return root.data + treeSum(root.left) + treeSum(root.right);
             
	}
	
}
