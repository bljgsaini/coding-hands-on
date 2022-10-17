package backtracking.permutationsLeetcode46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/permutations/
public class Solution {
    public static void main(String[] args) {


    }


    List<List<Integer>> result;

    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        solve(0, nums);
        return result;
    }

    public void solve(int start, int []nums){
        if(start == nums.length -1) {
            List<Integer> temp = new ArrayList();
            for(int num : nums){
                temp.add(num);
            }
            result.add(temp);
            return;
        }

        for(int i=start; i<nums.length; i++){
            swap(nums, start, i);
            solve(start+1, nums);
            swap(nums, start, i);
        }
    }

    public void swap(int []arr, int start, int end){
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

}
