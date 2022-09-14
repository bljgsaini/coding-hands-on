package assessmentProblems.MS;

import java.util.Comparator;
import java.util.PriorityQueue;


public class Solution {

    public static void main(String[] args) {
//        String s = "abccbd";
//        int []cost = new int[] {0,1,2,3,4,5};
//        String s = "aabbcc";
//        int []cost = new int[] {1,2,1,2,1,2};
//        System.out.println("Deleting cost=>" + solve(s, cost));


//        int[] num1 = new int[]{2,3,1,1,2};
//        int[] num2 = new int[]{5,4,6};

        int[] num1 = new int[]{5,4,1,2,6,5};
        int[] num2 = new int[]{2};

        System.out.println(solve2(num1, num2));

    }

    //https://www.google.com/amp/s/www.geeksforgeeks.org/remove-consecutive-duplicates-string/amp/
    public static int solve(String s, int [] cost){
        if(s == null || s.length() == 0 ) return 0;
        int ans = 0;
        int tempMaxCost =cost[0];
        int tempTotalCost = cost[0];
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i) == s.charAt(i-1)){
                tempTotalCost+= cost[i];
                tempMaxCost = Math.max(tempMaxCost, cost[i]);
            }else{
                ans += tempTotalCost - tempMaxCost;
                tempTotalCost = cost[i];
                tempMaxCost = cost[i];
            }
        }
        ans+= tempTotalCost - tempMaxCost;
        return ans;
    }


    //https://leetcode.com/discuss/interview-question/877070/Microsoft-Interview-Question
    public static int solve2(int [] nums1, int [] nums2){
        int firstSum = 0;
        for(int num : nums1) firstSum += num;
        int secondSum = 0;
        for(int num : nums2) secondSum += num;

        if(firstSum == secondSum ) return 0;

        if(firstSum > secondSum){
            int [] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            int x = firstSum;
            firstSum = secondSum;
            secondSum = x;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int num : nums1){
            minHeap.add(num);
        }

        Comparator<Integer> comparator = (a, b)-> b-a;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(comparator);
        for(int num : nums2){
            maxHeap.add(num);
        }

        int ans = 0;
        while( firstSum != secondSum ){
            if(nums1.length*6 == firstSum && nums2.length == secondSum) return -1;
            if(secondSum - firstSum > 6 - minHeap.peek() ){
                firstSum += 6 - minHeap.peek();
                if(minHeap.peek() != 6) ans++;
                minHeap.poll();
                minHeap.add(6);
            }else{
                ans++;
                return ans;
            }

            if(secondSum - firstSum > maxHeap.peek() -1 ){
                secondSum -= maxHeap.peek() -1;
                if(maxHeap.peek() != 1) ans++;
                maxHeap.poll();
                maxHeap.add(1);
            }else{
                ans++;
                return ans;
            }
        }

        return -1;
    }

}
