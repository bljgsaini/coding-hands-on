package tree;

import java.util.ArrayList;
import java.util.Collections;

public class BoundryTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	ArrayList <Integer> printBoundary(TreeNode node)
	{
	   
	    ArrayList<Integer> ans = new ArrayList<>();
	    if(node == null ) return ans;
	    ans.add(node.val);
	    //PRINT LEFT BOUNDRY
	    printLeftBoundry(node.left, ans);
        // PRINT LEAF BOUNDRY
        printLeaf(node, ans);
        // PRINT RIGHT BOUNDRY
        printRightBoundry(node.right, ans);
        
        return ans;
	    
	}
	
	void printRightBoundry(TreeNode node, ArrayList<Integer> ans){
	    ArrayList<Integer> temp = new ArrayList<>();
	    while(node != null){
	        while(node.right!=null){
	            temp.add(node.val);
	            node = node.right;
	        }
	        if(node.left != null){
	            temp.add(node.val);
	        }
	        node = node.left;
	    }
	    
	    Collections.reverse(temp);
	    ans.addAll(temp);
	    
	}
	
	void printLeftBoundry(TreeNode node, ArrayList<Integer> ans){
	    while(node != null){
	        while(node.left!=null){
	            ans.add(node.val);
	            node = node.left;
	        }
	        if(node.right != null){
	            ans.add(node.val);
	        }
	        node = node.right;
	    }
	}
	
	void printLeaf(TreeNode node, ArrayList<Integer> ans){
	    if(node == null ) return;
	    if(node.left == null && node.right == null) ans.add(node.val);
	    printLeaf(node.left, ans);
	    printLeaf(node.right, ans);
	}

}
