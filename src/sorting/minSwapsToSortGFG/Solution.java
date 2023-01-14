package sorting.minSwapsToSortGFG;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://practice.geeksforgeeks.org/problems/minimum-swaps/1
class Solution{

    public static void main(String[] args) {

    }

    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[]){
        int []tempArr = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            tempArr[i] = nums[i];
        }
        Arrays.sort(tempArr);
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int i =0;
        for(int num : tempArr){
            map.put(num, i);
            i++;
        }

        int result = 0;
        for(i=0; i<nums.length; i++){
            int num = nums[i];
            while(map.get(num) != i){
                swap(nums, i, map.get(num));
                result++;
                num = nums[i];
            }
        }
        return result;
    }

    public void swap(int nums[], int first, int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
