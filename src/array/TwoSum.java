package array;

import java.util.HashMap;
import java.util.Map;

//1. Two Sum
public class TwoSum {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans[] = new int[2];
        int n = nums.length;
        for(int i=0; i<n; i++ ){
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                ans[0] = map.get(complement);
                ans[1] = i;
                break;
            }else{
                map.put(nums[i], i);
            }
        }
        return ans;
    }

}
