package SlidingWindowMaximumLeetcode239;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;


//239. Sliding Window Maximum
//https://leetcode.com/problems/sliding-window-maximum/
public class Solutions {



    public int[] maxSlidingWindowV2AfterRefactoring(int[] nums, int k) {
        int i=0, j= 0;
        Deque<Integer> deque = new ArrayDeque();
        int []max = new int[nums.length - k + 1];
        int maxIndex = 0;
        while(j < nums.length){

            while(!deque.isEmpty() && deque.getLast() < nums[j]){
                deque.removeLast();
            }

            deque.addLast(nums[j]);

            if(j-i+1 == k){
                max[maxIndex++] = deque.getFirst();
                if(nums[i] == deque.getFirst()){
                    deque.removeFirst();
                }
                i++;
            }

            j++;

        }

        return max;
    }

    public int[] maxSlidingWindowV2(int[] nums, int k) {
        int i=0, j= 0;
        Deque<Integer> deque = new ArrayDeque();
        int []max = new int[nums.length - k + 1];
        int maxIndex = 0;
        while(j < nums.length){

            if(j == 0){
                deque.addLast(nums[j]);
            }else{
                if(!deque.isEmpty() && deque.getLast() > nums[j]) deque.addLast(nums[j]);
                else{
                    while(!deque.isEmpty() && deque.getLast() < nums[j]){
                        deque.removeLast();
                    }
                    deque.addLast(nums[j]);
                }
            }

            if(j-i+1 == k){
                max[maxIndex++] = deque.getFirst();
                if(nums[i] == deque.getFirst()){
                    deque.removeFirst();
                }
                i++;
            }

            j++;

        }

        return max;
    }


    public int[] maxSlidingWindow(int[] nums, int k) {
        int i=0, j= 0;
        int []max = new int[nums.length - k + 1];
        int a = 0;
        Comparator<Integer> comparator = (a1, b) -> -a1 + b;
        PriorityQueue<Integer> pq = new PriorityQueue(comparator);

        while(j < nums.length){
            pq.add(nums[j]);
            if(pq.size() == k){
                max[a++] = pq.peek();
                pq.remove(nums[i]);
                i++;
            }
            j++;
        }

        return max;
    }

}
