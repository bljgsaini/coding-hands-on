package array.climbingStairsLeetcode70;

public class Solution {
    public static void main(String[] args) {

    }
    public int climbStairsSolution2(int n) {
        int second = 0;
        int first = 1;
        for(int i=1; i<=n; i++){
            int temp = first+second;
            second = first;
            first = temp;
        }
        return first;
    }

    public int climbStairsDPSolution1(int n) {
        int []dp = new int[n+1];
        return count(n, dp);
    }

    public int count(int n, int []dp){
        if(n == 0 || n==1) return 1;
        if(n < 0) return 0;
        if(dp[n] > 0) return dp[n];
        dp[n] = count(n-1, dp) + count(n-2, dp);
        return dp[n];
    }


}
