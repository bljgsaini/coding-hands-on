package slidingWindowProblem.subarraysWithKDifferentIntegersLeetcode992;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {

    }

    //Solution3
    public int subarraysWithKDistinctOptimized(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        int ans = 0;
        int i=0; int j=0;
        int repeatingNumber = 0;
        while(j < nums.length){
            // add the element in the map
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            // when window size is more than k then remove the first element from the window which is having one freq in map
            if(map.size() > k){
                map.remove(nums[i]);
                repeatingNumber = 0;
                i++;
            }
            // count the number which are occuring more than once from start of the window
            while(map.get(nums[i]) > 1 ){
                repeatingNumber++;
                map.put(nums[i], map.get(nums[i])-1);
                i++;
            }
            if(map.size() == k ) ans+= (repeatingNumber + 1);
            j++;
        }
        return ans;
    }

    //Solution2
    public int subarraysWithKDistinctSolution1(int[] nums, int k) {
        return subarraysWithAtMostKDistinct(nums, k) - subarraysWithAtMostKDistinct(nums, k-1);
    }

    public int subarraysWithAtMostKDistinct(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        int ans = 0;
        int i=0; int j=0;
        while(j < nums.length){

            // add the element in the map
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            //window size greater than k then remove or update the freq of element in the map
            while(map.size() > k){
                map.put(nums[i], map.get(nums[i])-1);
                if(map.get(nums[i]) == 0) map.remove(nums[i]);
                i++;
            }
            ans+= j-i+1;
            j++;
        }
        return ans;
    }

    //solution1 brute force
    public int subarraysWithKDistinctBruteForce(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        int ans = 0;
        int i=0; int j=0;
        while(j < nums.length){
            // add the element in the map
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            //window size greater than k then remove or update the freq of element in the map
            while(map.size() > k){
                map.put(nums[i], map.get(nums[i])-1);
                if(map.get(nums[i]) == 0) map.remove(nums[i]);
                i++;
            }
            if(map.size() == k ){
                Map<Integer, Integer> tempMap = new HashMap(map);
                int start = i;
                while(tempMap.size() == k ){
                    ans++;
                    tempMap.put(nums[start], tempMap.get(nums[start])-1);
                    if(tempMap.get(nums[start]) == 0) tempMap.remove(nums[start]);
                    start++;
                }
            }
            j++;
        }
        return ans;
    }

}
