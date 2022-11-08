package graph.maxAreaOfIslandLeetcode695;


//https://leetcode.com/problems/max-area-of-island/description/
public class Solution {
    
    public static void main(String[] args) {

    }

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    int tempAns = DFS(i, j, grid, m, n);
                    ans = Math.max(ans, tempAns);
                }
            }
        }
        return ans;
    }

    public int DFS(int i, int j, int[][]grid, int m, int n){
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j] == 0) return 0;
        grid[i][j] = 0;
        return 1 + DFS(i+1, j, grid, m, n) + DFS(i, j+1, grid, m, n)
                + DFS(i-1, j, grid, m, n) + DFS(i, j-1, grid, m, n);
    }

}
