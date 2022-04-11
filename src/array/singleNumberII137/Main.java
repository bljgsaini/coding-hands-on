package array.singleNumberII137;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


//137. Single Number II
/* Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.

You must implement a solution with a linear runtime complexity and use only constant extra space.



Example 1:

Input: nums = [2,2,3,2]
Output: 3
Example 2:

Input: nums = [0,1,0,1,0,1,99]
Output: 99


Constraints:

1 <= nums.length <= 3 * 104
-231 <= nums[i] <= 231 - 1
Each element in nums appears exactly three times except for one element which appears once. */


public class Main {
    public static void main(String[] args) {

    }
}


class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        for(Integer key: map.keySet()){
            if(map.get(key) == 1) return key;
        }
        return -1;
    }

    public int singleNumber2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if(n == 1 || nums[0] != nums[1]) return nums[0];
        if(nums[n-1] != nums[n-2]) return nums[n-1];

        int k = 1;
        while(k < n && nums[k-1] == nums[k]) k+=3;

        return nums[k-1];
    }

    public int singleNumber3(int[] nums) {
        int ans = 0;
        for(int k=0; k<32; k++){
            int count = 0;
            for(int i=0; i<nums.length; i++){
                if( ((nums[i]>>k) & 1) == 1) count++;
            }
            ans = ans | (count%3 << k);
        }
        return ans;
    }

    public int singleNumber4(int[] nums) {

        int oneTime = 0;
        int twoTime  = 0;

        for(int i=0; i<nums.length; i++){
            oneTime = (oneTime ^ nums[i]) & (~twoTime);
            twoTime = (twoTime ^ nums[i]) & (~oneTime);
        }

        return oneTime;

    }

}
