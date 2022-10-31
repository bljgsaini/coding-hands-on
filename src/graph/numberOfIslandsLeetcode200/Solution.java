package graph.numberOfIslandsLeetcode200;


//https://leetcode.com/problems/number-of-islands/
public class Solution {

    public static void main(String[] args) {

    }

    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    DFS(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    public void DFS(char grid[][], int i, int j, boolean[][]visited){
        if(i<0 || i>= grid.length || j<0 || j>=grid[0].length) return;
        if(visited[i][j] || grid[i][j] == '0') return;
        visited[i][j] = true;
        DFS(grid, i+1, j, visited);
        DFS(grid, i, j+1, visited);
        DFS(grid, i-1, j, visited);
        DFS(grid, i, j-1, visited);
    }

}
