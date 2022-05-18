package tree.maxSumNodesInBinaryTreeNoTwoAdjacent;

import java.util.HashMap;
import java.util.Map;

//https://www.geeksforgeeks.org/maximum-sum-nodes-binary-tree-no-two-adjacent/
public class Solution {

    public static void main(String[] args) {

    }

    static Map<String, Integer> map;

    static int getMaxSum(Node root){
        map = new HashMap();
        return getMaxSumUtil(root, false);
    }

    static int getMaxSumUtil(Node root, boolean prevSelected){
        if(root == null ) return 0;

        String key = String.valueOf(root) + "#" + String.valueOf(prevSelected);
        if(map.containsKey(key)) return map.get(key);

        if(prevSelected){
            map.put(key, callToChildWithFlagBasedOnCurrentNodeSelected(root, false));
        }else{
            map.put(key, Math.max(root.data + callToChildWithFlagBasedOnCurrentNodeSelected(root, true),
                    callToChildWithFlagBasedOnCurrentNodeSelected(root, false)));
        }
        return map.get(key);
    }

    private static int callToChildWithFlagBasedOnCurrentNodeSelected(Node root, boolean flag) {
        return getMaxSumUtil(root.left, flag) + getMaxSumUtil(root.right, flag);
    }


    //using Pair in response

    static Map<Node, Pair> map1;

    private static Pair getMaxSumUtil(Node root){
        if(root == null ) return new Pair(0,0);

        if(map.containsKey(root)) return map1.get(root);

        int sum1 = root.data;
        if(root.left != null ){
            Pair pair1 = getMaxSumUtil(root.left.left);
            Pair pair2 = getMaxSumUtil(root.left.right);
            sum1+= Math.max(pair1.first, pair1.second) + Math.max(pair2.first, pair2.second);
        }

        if(root.right != null ){
            Pair pair1 = getMaxSumUtil(root.right.left);
            Pair pair2 = getMaxSumUtil(root.right.right);
            sum1+= Math.max(pair1.first, pair1.second) + Math.max(pair2.first, pair2.second);
        }

        Pair pair1 = getMaxSumUtil(root.left);
        Pair pair2 = getMaxSumUtil(root.right);

        int sum2 = Math.max(pair1.first, pair1.second) + Math.max(pair2.first, pair2.second);

        map1.put(root, new Pair(sum1, sum2));

        return map1.get(root);
    }

}


class Node{
    int data;
    Node left, right;
    Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}


class Pair{
    int first;
    int second;
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
