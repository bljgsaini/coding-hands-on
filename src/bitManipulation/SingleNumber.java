package bitManipulation;

import java.util.HashMap;
import java.util.Map;

//136. Single Number
public class SingleNumber {
    public static void main(String[] args) {

    }

    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int i=0; i<nums.length; i++){
            ans = ans^nums[i];
        }
        return ans;
    }

    public int singleNumber1(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        for(Map.Entry<Integer,Integer> element : map.entrySet()){
            if(element.getValue() == 1){
                return element.getKey();
            }
        }
        return 0;
    }


}
