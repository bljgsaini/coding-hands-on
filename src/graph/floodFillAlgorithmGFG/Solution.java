package graph.floodFillAlgorithmGFG;

//https://practice.geeksforgeeks.org/problems/flood-fill-algorithm1856/1
class Solution{

    public static void main(String[] args) {

    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor){
        boolean [][]visited= new boolean[image.length][image[0].length];
        DFS(sr, sc, image, image[sr][sc], newColor, visited);
        return image;
    }

    public void DFS(int i, int j, int[][] image, int oldColor, int newColor, boolean [][]visited){
        if(i<0 || j<0 || i>= image.length || j>= image[0].length
                || visited[i][j] || image[i][j] != oldColor ) return ;

        image[i][j] = newColor;
        visited[i][j] = true;
        DFS(i+1, j, image, oldColor, newColor, visited);
        DFS(i-1, j, image, oldColor, newColor, visited);
        DFS(i, j+1, image, oldColor, newColor, visited);
        DFS(i, j-1, image, oldColor, newColor, visited);
    }
}