package graph.findWeatherPathExistGFG;

//https://practice.geeksforgeeks.org/problems/find-whether-path-exist5238/1
class Solution{

    public static void main(String[] args) {

    }

    //Function to find whether a path exists from the source to destination.
    public boolean is_Possible(int[][] grid){
        int n = grid.length;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                boolean [][] visited = new boolean[n][n];
                if(grid[i][j] == 1 ) return DFS(i, j, grid, visited);
            }
        }
        return false;
    }

    public boolean DFS(int i, int j, int [][]grid, boolean[][] visited){
        if(i<0 || j<0 || i>= grid.length || j>= grid.length || visited[i][j] || grid[i][j] == 0) return false;
        if(grid[i][j] == 2) return true;
        visited[i][j] = true;
        if(DFS(i+1, j, grid,visited) || DFS(i-1, j, grid, visited)
                || DFS(i, j+1, grid, visited) || DFS(i, j-1, grid, visited) ) return true;
        return false;
    }

}
