package designProblems.serializeAndDeserializeBinaryTreeLeetcode297;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SerializeAndDeserializeBinaryTree297 {


    public static void main(String[] args) {


        // Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));

    }




}


class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null ) return null;
        Stack<TreeNode> s = new Stack();
        StringBuilder ans = new StringBuilder();
        while(root!= null){
            ans.append(","+ root.val);
            s.push(root);
            root = root.left;
        }
        ans.append(",N");
        while(!s.isEmpty()){
            TreeNode node = s.pop();
            if(node.right != null ){
                node = node.right;
                while(node!= null ){
                    ans.append(","+node.val);
                    s.push(node);
                    node = node.left;
                }
            }
            ans.append(",N");
        }
        //System.out.println("ans =>" + ans.toString());
        return ans.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0 ) return null;
        String[] arr = data.split(",");
        Stack<TreeNode> s = new Stack<>();
        int k = 1;
        TreeNode root = new TreeNode(Integer.parseInt(arr[k]));
        k++;
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


class Codec2 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null ) return null;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        String ans = "";
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                ans += " " + String.valueOf(node.val);
                String ch = "N";
                if(node.left != null){
                    ch = "Y";
                    q.add(node.left);
                }
                ans+= " "+ch;
                ch = "N";
                if(node.right != null ) {
                    ch = "Y";
                    q.add(node.right);
                }
                ans+= " "+ch;
            }
        }
        System.out.println("ans =>" + ans);
        return ans;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0 ) return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] arr = data.split(" ");
        int k = 1;
        TreeNode root = new TreeNode(Integer.parseInt(arr[k]));
        q.add(root);
        int childIndex = 4;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                TreeNode leftNode = null;
                if(arr[k+1].equals("Y")){
                    leftNode = new TreeNode(Integer.parseInt(arr[childIndex]));
                    q.add(leftNode);
                    childIndex+= 3;
                }
                node.left = leftNode;

                TreeNode rightNode = null;
                if(arr[k+2].equals("Y")){
                    rightNode = new TreeNode(Integer.parseInt(arr[childIndex]));
                    q.add(rightNode);
                    childIndex+=3;
                }
                node.right = rightNode;
                k+=3;
            }
        }
        return root;
    }

}


class Codec3 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null ) return null;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        String ans = "";
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                String ch = "N";
                if(node != null ){
                    ch = String.valueOf(node.val);
                    q.add(node.left);
                    q.add(node.right);
                }
                ch = " " + ch;
                ans+= ch;
            }
        }
        return ans;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0 ) return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] nodes = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(String.valueOf(nodes[1])));
        q.add(root);
        int k = 2;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                String leftNodeString = nodes[k++];
                node.left = getChild(leftNodeString, q);
                String rightNodeString = nodes[k++];
                node.right = getChild(rightNodeString, q);
            }
        }
        return root;
    }

    public TreeNode getChild(String childString, Queue<TreeNode> q){
        TreeNode child = null;
        if(!childString.equals("N")) {
            int nodeValue = Integer.parseInt(String.valueOf(childString));
            child = new TreeNode(nodeValue);
            q.add(child);
        }
        return child;
    }
}
