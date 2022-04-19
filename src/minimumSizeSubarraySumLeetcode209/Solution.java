package minimumSizeSubarraySumLeetcode209;


//https://leetcode.com/problems/minimum-size-subarray-sum/submissions/
public class Solution {


    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int i =0;
        int j = 0;
        int ans = Integer.MAX_VALUE;
        while(j<nums.length){
            sum+= nums[j];
            while(i<=j && sum >= target){
                ans = Math.min(ans, j-i+1);
                sum -= nums[i];
                i++;
            }
            j++;
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
