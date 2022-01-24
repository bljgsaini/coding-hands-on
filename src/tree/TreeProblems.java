package tree;

public class TreeProblems {

	public static void main(String[] args) {
		

	}
	
	public static boolean isSubtree(TreeNode S, TreeNode T) {
        if(S == null ) return true;
        if( T == null ) return false;
        if(isIdentical(T, S) == true) return true;
        return isSubtree(S, T.left) || isSubtree(S, T.right);
    }
    
    public static boolean isIdentical(TreeNode head1, TreeNode head2){
        if(head1 == null && head2 == null) return true;
        if( (head1 == null && head2 != null) || (head1 != null && head2 == null) || (head1.val != head2.val) ) return false;
        return isIdentical(head1.left, head2.left) && isIdentical(head1.right, head2.right);
    }
    
    public static int pIndex = 0;
    
    public static TreeNode buildTreeFromInOrderAndPreOrder(int inorder[], int preorder[], int n)
    {
        pIndex = 0;
        return buildTreeFromInOrderAndPreOrderUtil(inorder, preorder, 0, n-1);
    }
    
    
    public static TreeNode buildTreeFromInOrderAndPreOrderUtil(int in[], int pre[], int start, int end){
        if(end < start ) return null;
        
        TreeNode node = new TreeNode(pre[pIndex]);
        //System.out.println("node = " + node.data);
        pIndex++;
        
        if(end == start ) return node;
        
        int index = search(in, start, end, node.val);
        
        node.left = buildTreeFromInOrderAndPreOrderUtil(in, pre, start, index-1);
        node.right = buildTreeFromInOrderAndPreOrderUtil(in, pre, index+1, end);
    
        return node;
        
    }
    
    
    public static TreeNode buildTreeFromInOrderAndPostOrder(int in[], int post[], int n) {
        pIndex = n-1;
        return buildTreeFromInOrderAndPostOrderUtil(in, post, 0, n-1);
    }
    
    public static TreeNode buildTreeFromInOrderAndPostOrderUtil(int in[], int post[], int start, int end){
        if(end < start ) return null;
        
        TreeNode node = new TreeNode(post[pIndex]);
        //System.out.println("node = " + node.data);
        pIndex--;
        
        if(end == start ) return node;
        
        int index = search(in, start, end, node.val);
        
        node.right = buildTreeFromInOrderAndPostOrderUtil(in, post, index+1, end);
        node.left = buildTreeFromInOrderAndPostOrderUtil(in, post, start, index-1);
        
        return node;
        
    }
    
    public static int search(int in[], int start, int end, int value){
        for(int i=start; i<= end; i++){
            if(in[i] == value){
                return i;
            }
        }
        return -1;
    }

}

