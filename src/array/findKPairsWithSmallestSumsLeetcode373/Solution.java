package array.findKPairsWithSmallestSumsLeetcode373;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
public class Solution {
    public static void main(String[] args) {

    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>( (a, b)-> a.sum - b.sum );

        for(int i=0; i<nums1.length; i++){
            pq.add(new Node( i, 0, nums1[i] + nums2[0] ));
        }

        List<List<Integer>> ans = new ArrayList();
        while( k > 0 && !pq.isEmpty()){
            Node node = pq.poll();
            List<Integer> list = new ArrayList();
            list.add(nums1[node.i]);
            list.add(nums2[node.j]);
            ans.add(list);

            if(node.j < nums2.length-1 ){
                pq.add( new Node(node.i, node.j + 1, nums1[node.i] + nums2[node.j+1]) );
            }
            k--;
        }

        return ans;

    }

}

class Node{

    int i;
    int j;
    int sum;

    Node(int first, int second, int sum){
        this.i = first;
        this.j = second;
        this.sum = sum;
    }

}
