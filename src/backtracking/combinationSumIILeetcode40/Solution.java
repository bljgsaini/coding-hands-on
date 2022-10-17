package backtracking.combinationSumIILeetcode40;

import java.util.*;

//https://leetcode.com/problems/combination-sum-ii/
public class Solution {
    public static void main(String[] args) {

    }


    Map<Integer, Integer> map;
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        map = new HashMap();
        Arrays.sort(candidates);
        map.put(candidates[candidates.length-1], candidates.length);
        for(int i=candidates.length-2; i>=0; i--){
            if(candidates[i] != candidates[i+1]){
                map.put(candidates[i], i+1);
            }
        }
        result = new ArrayList();
        solve(0, candidates, target, new ArrayList());
        return result;
    }

    public void solve(int start, int []arr, int target, List<Integer> list){
        if(target == 0 ){
            result.add(new ArrayList<>(list));
            return;
        }
        if(start == arr.length) return ;

        if(target - arr[start] >= 0){
            solve(map.get(arr[start]), arr, target, list);
            list.add(arr[start]);
            solve(start+1, arr, target-arr[start], list);
            list.remove(list.size()-1);
        }else{
            solve(map.get(arr[start]), arr, target, list);
        }
    }

}
