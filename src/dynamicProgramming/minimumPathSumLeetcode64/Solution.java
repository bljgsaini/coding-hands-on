package dynamicProgramming.minimumPathSumLeetcode64;

//https://leetcode.com/problems/minimum-path-sum/
public class Solution {
    public static void main(String[] args) {

    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int cost[][] = new int[m][n];
        cost[0][0] = grid[0][0];
        for(int i=1; i<m; i++){
            cost[i][0] = grid[i][0] + cost[i-1][0];
        }
        for(int j=1; j<n; j++){
            cost[0][j] = grid[0][j] + cost[0][j-1];
        }
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                cost[i][j] = grid[i][j] + Math.min(cost[i-1][j], cost[i][j-1]);
            }
        }
        return cost[m-1][n-1];
    }
}
