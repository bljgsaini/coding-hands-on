package dynamicProgramming.longestIncreasingSubsequenceLeetcode300;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {

    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[]LIS = new int[n];
        int ans = Integer.MIN_VALUE;
        for(int i = n-1; i>=0; i--){
            int tempAns = 1;
            for(int j = i+1; j<n; j++){
                if(nums[j] > nums[i]){
                    tempAns = Math.max(tempAns, 1+LIS[j]);
                }
            }
            LIS[i] = tempAns;
            ans = Math.max(ans, tempAns);
        }
        return ans;
    }


}

class Solution1 {
    Map<String, Integer> map;
    public int lengthOfLIS(int[] nums) {
        map = new HashMap();
        return solve(Integer.MIN_VALUE, 0, nums);
    }

    public int solve(int prev, int start, int [] nums){
        if(start == nums.length ) return 0;
        String key = prev + "#" + start;
        if(map.containsKey(key)) return map.get(key);
        int tempAns;
        if(nums[start] > prev){
            tempAns = Math.max(1+ solve(nums[start], start+1, nums), solve(prev, start+1, nums));
        }else{
            tempAns = solve(prev, start+1, nums);
        }
        map.put(key, tempAns);
        return map.get(key);
    }

}
