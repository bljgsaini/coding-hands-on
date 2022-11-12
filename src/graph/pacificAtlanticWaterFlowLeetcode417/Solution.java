package graph.pacificAtlanticWaterFlowLeetcode417;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//https://leetcode.com/problems/pacific-atlantic-water-flow/description/
class Solution {


    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        List<List<Integer>> solution = pacificAtlantic(grid);
        for(List<Integer> sol : solution){
            System.out.println(sol + " ");
        }
    }
    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList();
        int row = heights.length;
        int col = heights[0].length;
        boolean[][] atlanticSet = new boolean[row][col];
        boolean[][] pacificSet = new boolean[row][col];

        for(int j=0; j<col; j++){
            DFS(0, j,heights, pacificSet, heights[0][j]);
            DFS(row-1, j,heights, atlanticSet, heights[row-1][j]);
        }

        for(int i=0; i<row; i++){
            DFS(i, 0, heights, pacificSet, heights[i][0]);
            DFS(i, col-1, heights, atlanticSet, heights[i][col-1]);
        }

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(pacificSet[i][j] && atlanticSet[i][j]){
                    ans.add(Arrays.asList(i,j));
                }
            }
        }
        return ans;
    }


    public static void DFS(int i, int j, int grid[][], boolean[][]visited, int prevHeight){
        if(i<0 || j<0 || i>= grid.length || j>= grid[0].length || visited[i][j] || grid[i][j] < prevHeight)
            return;
        visited[i][j] = true;
        DFS(i+1, j, grid, visited, grid[i][j]);
        DFS(i, j+1, grid, visited, grid[i][j]);
        DFS(i-1, j, grid, visited, grid[i][j]);
        DFS(i, j-1, grid, visited, grid[i][j]);
    }


    public List<List<Integer>> pacificAtlanticBruteForce(int[][] heights) {
        List<List<Integer>> ans = new ArrayList();
        for(int i=0; i<heights.length; i++){
            for(int j=0; j<heights[0].length; j++){
                int [][] visited = new int[heights.length][heights[0].length];
                Pair pair = new Pair();
                solve(i, j, heights, pair, visited);
                if(pair.pacific && pair.atlantic){
                    List<Integer> temp = new ArrayList();
                    temp.add(i);
                    temp.add(j);
                    ans.add(temp);
                }
            }
        }
        return ans;
    }

    public void solve(int i, int j, int[][] grid, Pair pair, int[][]visited){
        if(visited[i][j]==1 ) return ;

        if(i==0 || j==0) {
            pair.pacific = true;
        }
        if(i== grid.length-1 || j== grid[0].length-1){
            pair.atlantic = true;
        }

        visited[i][j] = 1;
        if(i+1 < grid.length && grid[i+1][j] <= grid[i][j]){
            solve(i+1, j, grid, pair, visited);
        }

        if(j+1 < grid[0].length && grid[i][j+1] <= grid[i][j]){
            solve(i, j+1, grid, pair, visited);
        }

        if(i-1 >= 0 && grid[i-1][j] <= grid[i][j]){
            solve(i-1, j, grid, pair, visited);
        }

        if(j-1 >=0 && grid[i][j-1] <= grid[i][j]){
            solve(i, j-1, grid, pair, visited);
        }

    }
}

class Pair{
    boolean pacific;
    boolean atlantic;

    public Pair(){
        pacific = false;
        atlantic = false;
    }
}
