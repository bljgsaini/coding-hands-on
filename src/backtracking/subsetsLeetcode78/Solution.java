package backtracking.subsetsLeetcode78;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/subsets/
public class Solution {
    public static void main(String[] args) {

    }

    List<List<Integer>> ans;

    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList();
        List<Integer> list = new ArrayList();
        subsetsUtil(nums, 0, list);
        return ans;
    }

    public void subsetsUtil(int arr[], int start, List<Integer> list){
        if(start == arr.length) {
            ans.add(new ArrayList(list));
            return;
        }
        subsetsUtil(arr, start+1, list);
        list.add(arr[start]);
        subsetsUtil(arr, start+1, list);
        list.remove(list.size()-1);
    }

}
