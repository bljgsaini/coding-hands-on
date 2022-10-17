package backtracking.subsetsIILeetcode90;

import java.util.*;


//https://leetcode.com/problems/subsets-ii/
public class Solution {

    public static void main(String[] args) {

    }

    List<List<Integer>> result;
    Map<Integer, Integer> map;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        result = new ArrayList();
        map = new HashMap();
        Arrays.sort(nums);
        int prev = nums.length;
        map.put(nums[prev-1], prev);
        for(int i=nums.length-2; i>=0; i--){
            if(nums[i] != nums[i+1]){
                prev = i+1;
                map.put(nums[i], prev);
            }
        }

        subsetsUtil(nums, 0, new ArrayList());
        return result;
    }

    public void subsetsUtil(int arr[], int start, List<Integer> list){
        if(start >= arr.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        subsetsUtil(arr, map.get(arr[start]), list);
        list.add(arr[start]);
        subsetsUtil(arr, start+1, list);
        list.remove(list.size()-1);
    }
}

class SolutionBruteForceApproach {

    public static void main(String[] args) {

    }

    List<List<Integer>> result;
    Set<String> set;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        result = new ArrayList();
        set = new HashSet();
        List<Integer> list = new ArrayList();
        subsetsUtil(nums, 0, list);
        return result;
    }

    public void subsetsUtil(int arr[], int start, List<Integer> list){
        if(start == arr.length) {
            StringBuilder sb = new StringBuilder();
            Map<Integer, Integer> map = new TreeMap();
            for(int num : list){
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            for(Integer key : map.keySet()){
                sb.append(key + "#" + map.get(key));
            }

            if(!set.contains(sb.toString())){
                result.add(new ArrayList(list));
                set.add(sb.toString());
            }
            return;
        }
        subsetsUtil(arr, start+1, list);
        list.add(arr[start]);
        subsetsUtil(arr, start+1, list);
        list.remove(list.size()-1);
    }

}
