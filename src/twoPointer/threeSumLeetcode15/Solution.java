package twoPointer.threeSumLeetcode15;

import java.util.*;

public class Solution {
    public static void main(String[] args) {

    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            if(i > 0 && (nums[i] == nums[i-1]) ) continue;
            int target = - nums[i];
            int j = i+1; int k = nums.length-1;
            while(j < k){
                if( isPairValidAndUnique(i, j, k, nums) && nums[j] + nums[k] == target ){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    ans.add(temp);
                    j++;
                    k--;
                }
                else if( (j != i+1 && nums[j] == nums[j-1]) || j ==i || ((nums[j] + nums[k]) < target) ){
                    j++;
                }
                else{
                    k--;
                }
            }
        }
        return ans;
    }

    public boolean isPairValidAndUnique(int i, int j, int k, int[] nums){
        return (j == i+1 || nums[j] != nums[j-1] ) && ( k== nums.length-1 || nums[k] != nums[k+1] ) && j!= i && k != i;
    }

    public List<List<Integer>> threeSum1(int[] nums) {
        Set<String> set = new HashSet();
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            int target = - nums[i];
            int j = 0; int k = nums.length-1;
            while(j < k && j!= i && k != i){
                if(nums[j] + nums[k] == target){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    Collections.sort(temp);
                    String key = temp.get(0) + "#" + temp.get(1) + "#" + temp.get(2);
                    if(!set.contains(key)){
                        set.add(key);
                        ans.add(temp);
                    }
                    j++;
                    k--;
                }
                else if(nums[j] + nums[k] < target){
                    j++;
                }
                else{
                    k--;
                }
            }
        }
        return ans;
    }

}
