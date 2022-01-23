package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDublicate {


    public static void main(String[] args) {
        int nums[] = {1,1,1,3,3,4,3,2,4,2};
        System.out.println(containsDuplicate(nums) );
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<nums.length; i++){
            if(set.contains(nums[i])) return true;
            else set.add(nums[i]);
        }
        return false;
    }

    public boolean containsDuplicate1(int[] nums) {
        //Set<Integer> set = new HashSet<>();
        Arrays.sort(nums);
        for(int i=1; i<nums.length; i++){
            if(nums[i] == nums[i-1]) return true;
        }
        return false;
    }


}
