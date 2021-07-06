package tree;

import java.util.ArrayList;
import java.util.Collections;

public class BoundryTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	ArrayList <Integer> printBoundary(Node node)
	{
	   
	    ArrayList<Integer> ans = new ArrayList<>();
	    if(node == null ) return ans;
	    ans.add(node.data);
	    //PRINT LEFT BOUNDRY
	    printLeftBoundry(node.left, ans);
        // PRINT LEAF BOUNDRY
        printLeaf(node, ans);
        // PRINT RIGHT BOUNDRY
        printRightBoundry(node.right, ans);
        
        return ans;
	    
	}
	
	void printRightBoundry(Node node, ArrayList<Integer> ans){
	    ArrayList<Integer> temp = new ArrayList<>();
	    while(node != null){
	        while(node.right!=null){
	            temp.add(node.data);
	            node = node.right;
	        }
	        if(node.left != null){
	            temp.add(node.data);
	        }
	        node = node.left;
	    }
	    
	    Collections.reverse(temp);
	    ans.addAll(temp);
	    
	}
	
	void printLeftBoundry(Node node, ArrayList<Integer> ans){
	    while(node != null){
	        while(node.left!=null){
	            ans.add(node.data);
	            node = node.left;
	        }
	        if(node.right != null){
	            ans.add(node.data);
	        }
	        node = node.right;
	    }
	}
	
	void printLeaf(Node node, ArrayList<Integer> ans){
	    if(node == null ) return;
	    if(node.left == null && node.right == null) ans.add(node.data);
	    printLeaf(node.left, ans);
	    printLeaf(node.right, ans);
	}

}
