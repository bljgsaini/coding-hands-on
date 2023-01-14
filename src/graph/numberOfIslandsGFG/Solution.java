package graph.numberOfIslandsGFG;

//https://practice.geeksforgeeks.org/problems/find-the-number-of-islands/1
class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean [][]visited = new boolean[m][n];
        int count = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1' && !visited[i][j] ){
                    DFS(i, j, grid, visited);
                    count++;
                }
            }
        }
        return count;
    }

    public void DFS(int i, int j, char [][]grid, boolean[][] visited){
        int m = grid.length;
        int n = grid[0].length;
        if(i < 0 || i>=m || j<0 || j>= n || visited[i][j] || grid[i][j] == '0') return ;
        visited[i][j] = true;
        DFS(i+1, j, grid, visited);
        DFS(i-1, j, grid, visited);
        DFS(i, j+1, grid, visited);
        DFS(i, j-1, grid, visited);
        DFS(i+1, j+1, grid, visited);
        DFS(i+1, j-1, grid, visited);
        DFS(i-1, j+1, grid, visited);
        DFS(i-1, j-1, grid, visited);
    }
}
