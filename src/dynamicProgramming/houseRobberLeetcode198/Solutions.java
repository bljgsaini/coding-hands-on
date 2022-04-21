package dynamicProgramming.houseRobberLeetcode198;

// 198. House Robber
public class Solutions {

    public static void main(String[] args) {

    }

    // can be recursion + dp o(n2)

    public int rob(int[] nums) {

        //O(n)

        int first = 0, second = 0, third = 0;

        int n = nums.length-1;

        while(n >=0){
            int temp = Math.max(second, third) + nums[n];
            third = second;
            second = first;
            first = temp;
            n--;
        }

        return Math.max(first, second);

    }

}
