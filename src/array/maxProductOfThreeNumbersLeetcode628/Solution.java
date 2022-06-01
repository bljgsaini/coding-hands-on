package array.maxProductOfThreeNumbersLeetcode628;

public class Solution {
    public static void main(String[] args) {

    }

    public int maximumProduct(int[] nums) {
        int min1 = Integer.MAX_VALUE; int min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE; int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){
            if(nums[i] < min1){
                min2 = min1;
                min1 = nums[i];
            }else if(nums[i] < min2 ){
                min2 = nums[i];
            }

            if(nums[i] > max1 ){
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            }else if(nums[i] > max2){
                max3 = max2;
                max2 = nums[i];
            }else if(nums[i] > max3){
                max3 = nums[i];
            }
        }

        return Math.max(min1*min2*max1, max1*max2*max3);

    }

    /*
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if(nums[0] < 0 && nums[n-1] < 0 || nums[0] > 0 && nums[n-1] > 0){
            return nums[n-1]*nums[n-2]*nums[n-3];
        }else{
            int product1= nums[0]*nums[1]*nums[n-1];
            int product2 = nums[n-1]*nums[n-2]*nums[n-3];
            if(product1 > product2 ) return product1;
            return product2;
        }
    }
    */

}
