package dynamicProgramming;

public class DPInTrees {
	
	public static int res;

	public static void main(String[] args) {
		res = Integer.MIN_VALUE;
		
		// TODO Auto-generated method stub

	}
	
	public static int treeDiameter(Node root) {
		
		if(root == null ) return 0;
		
		int left = treeDiameter(root.left);
		int right = treeDiameter(root.right);
		
		int temp = 1 + Math.max(left, right);
		
		int ans = Math.max(temp, left+right+1);
		
		res = Math.max(res, ans);
				
		return temp;
	}
	
	
	public static int treeMaximumPathSum(Node root) {
		
		if(root == null) return 0;
		
		int left = treeDiameter(root.left);
		int right = treeDiameter(root.right);
		
		int temp = Math.max(Math.max(left, right)+root.val, root.val );
		
		int ans = Math.max(temp, left+right+ root.val);
		
		res = Math.max(res, ans);
				
		return temp;
	}
	
	
public static int treeMaximumPathSumLeafToLeaf(Node root) {
		
		if(root == null) return 0;
		
		int left = treeDiameter(root.left);
		int right = treeDiameter(root.right);
		
		int temp = root.val + Math.max(left, right);
		
		int ans = Math.max(temp, left+right+ root.val);
		
		res = Math.max(res, ans);
				
		return temp;
	}

}


class Node{
	int val;
	Node left, right;
	
	Node(int val){
		this.val = val;
		left = null;
		right = null;
	}
	
}
