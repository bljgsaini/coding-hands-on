package array;

public class MaximumSubArray {

    public static void main(String[] args) {
        int [] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int subArrayLargestSum = Integer.MIN_VALUE, maxSum = 0;

        for(int i=0; i<nums.length; i++){
            maxSum += nums[i];
            subArrayLargestSum = Math.max(subArrayLargestSum, maxSum);
            if(maxSum < 0) maxSum = 0;
        }
        return subArrayLargestSum;
    }

    public int checkSum(int currSum, int maxSum){
        return (maxSum < currSum) ? currSum : maxSum;
    }

    public int maxSubArray1(int[] nums) {
        int maxAns = Integer.MIN_VALUE;
        int n = nums.length;
        for(int i=0; i<n; i++){
            int currSum = nums[i];
            maxAns = checkSum(currSum, maxAns);
            for(int x = 1; i+x < n || i-x >=0 ; x++){
                if(i-x >= 0){
                    currSum += nums[i-x];
                    maxAns = checkSum(currSum, maxAns);
                }
                if(i+x < n){
                    currSum += nums[i+x];
                    maxAns = checkSum(currSum, maxAns);
                }
            }
        }
        return maxAns;
    }

}
