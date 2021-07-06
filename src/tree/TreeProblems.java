package tree;

public class TreeProblems {

	public static void main(String[] args) {
		

	}
	
	public static boolean isSubtree(Node T, Node S) {
        if(S == null ) return true;
        if( T == null ) return false;
        if(isIdentical(T, S) == true) return true;
        return isSubtree(T.left, S) || isSubtree(T.right, S);
    }
    
    public static boolean isIdentical(Node head1, Node head2){
        if(head1 == null && head2 == null) return true;
        if( (head1 == null && head2 != null) || (head1 != null && head2 == null) || (head1.data != head2.data) ) return false;
        return isIdentical(head1.left, head2.left) && isIdentical(head1.right, head2.right);
    }
    
    public static int pIndex = 0;
    
    public static Node buildTreeFromInOrderAndPreOrder(int inorder[], int preorder[], int n)
    {
        pIndex = 0;
        return buildTreeFromInOrderAndPreOrderUtil(inorder, preorder, 0, n-1);
    }
    
    
    public static Node buildTreeFromInOrderAndPreOrderUtil(int in[], int pre[], int start, int end){
        if(end < start ) return null;
        
        Node node = new Node(pre[pIndex]);
        //System.out.println("node = " + node.data);
        pIndex++;
        
        if(end == start ) return node;
        
        int index = search(in, start, end, node.data);
        
        node.left = buildTreeFromInOrderAndPreOrderUtil(in, pre, start, index-1);
        node.right = buildTreeFromInOrderAndPreOrderUtil(in, pre, index+1, end);
    
        return node;
        
    }
    
    
    public static Node buildTreeFromInOrderAndPostOrder(int in[], int post[], int n) {
        pIndex = n-1;
        return buildTreeFromInOrderAndPostOrderUtil(in, post, 0, n-1);
    }
    
    public static Node buildTreeFromInOrderAndPostOrderUtil(int in[], int post[], int start, int end){
        if(end < start ) return null;
        
        Node node = new Node(post[pIndex]);
        //System.out.println("node = " + node.data);
        pIndex--;
        
        if(end == start ) return node;
        
        int index = search(in, start, end, node.data);
        
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

class Node{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=null;
        right=null;
    }
}
