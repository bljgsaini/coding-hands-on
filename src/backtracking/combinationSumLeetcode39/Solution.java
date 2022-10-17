package backtracking.combinationSumLeetcode39;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combination-sum/
public class Solution {

    public static void main(String[] args) {

    }

    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList();
        solve(0, candidates, target, new ArrayList<Integer>());
        return result;
    }


    public void solve(int index, int []candidates, int target, List<Integer> list){
        if(target == 0 ) {
            result.add(new ArrayList(list));
            return;
        }

        if(index == candidates.length) return ;

        if(target - candidates[index] >= 0){
            solve(index+1, candidates, target, list);
            list.add(candidates[index]);
            solve(index, candidates, target-candidates[index], list);
            list.remove(list.size()-1);
        }else{
            solve(index+1, candidates, target, list);
        }

    }

}
