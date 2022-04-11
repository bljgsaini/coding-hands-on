package tree;

import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        System.out.println(new Test().deserialize(",1,2,N,N,3,4,N,N,5,N,N"));
    }


    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0 ) return null;
        String[] arr = data.split(",");
        Stack<TreeNode> s = new Stack<>();
        int k = 1;
        TreeNode root = new TreeNode(Integer.parseInt(arr[k]));k++;
        s.push(root);
        k = iterateLeftTree(arr, k, s);

        while(!s.isEmpty()){
            TreeNode node = s.pop();
            node.right = getRightChild(arr[k]);k++;
            if(node.right != null){
                s.push(node.right);
                k = iterateLeftTree(arr, k, s);
            }
        }

        return root;
    }

    public int iterateLeftTree(String []arr, int k, Stack<TreeNode>s){
        while(!arr[k].equals("N")){
            TreeNode node = s.peek();
            node.left = new TreeNode(Integer.parseInt(arr[k]));
            k++;
            s.push(node.left);
        }
        s.peek().left = null;
        k++;
        return k;
    }

    public TreeNode getRightChild(String str){
        if(str.equals("N")) return null;
        return new TreeNode(Integer.parseInt(str));
    }

}
