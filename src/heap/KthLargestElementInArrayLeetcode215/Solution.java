package heap.KthLargestElementInArrayLeetcode215;


import java.util.Comparator;
import java.util.PriorityQueue;

//https://leetcode.com/problems/kth-largest-element-in-an-array/
public class Solution {
    public static void main(String[] args) {

    }


    // using quick sort approach => avg time complexity O(n) and worst case O(n*2)
    public int findKthLargest(int[] nums, int k) {
        return solve(nums, k, 0, nums.length-1);
    }

    public int solve(int []arr, int k, int low, int high ){
        if(low > high) return -1;
        int pIndex = low;
        for(int i=low; i<high; i++){
            if(arr[i] < arr[high]){
                int temp = arr[i];
                arr[i] = arr[pIndex];
                arr[pIndex] = temp;
                pIndex++;
            }
        }
        int temp = arr[high];
        arr[high] = arr[pIndex];
        arr[pIndex] = temp;
        int n = arr.length;
        if(pIndex == n-k) return arr[pIndex];
        else if(pIndex > n-k ) return solve(arr, k, low, pIndex-1);
        return solve(arr, k, pIndex+1, high);
    }

    // using PriorityQueue => time complexity -> nLog(k)
    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue();
        for(int num : nums){
            if(pq.size() < k ) pq.add(num);
            else if(pq.peek() < num ){
                pq.poll();
                pq.add(num);
            }
        }
        return pq.peek();

        // common Area
        // Heap, Java Method Area, Runtime constant pool
        //thread specific => Program Counter Register, JVM Stacks, Native Method Stack
    }


    // using Heap => time complexity -> n +  kLog(n)
    public int findKthLargest2(int[] nums, int k) {
        Comparator<Integer> comparator = (a, b)-> b-a;
        PriorityQueue<Integer> pq = new PriorityQueue(comparator);
        for(int num : nums){
            pq.add(num);
        }
        if(pq.size() < k ) return 0;
        for(int i=1; i<k; i++){
            pq.poll();
        }
        return pq.peek();
    }


}
