package graph.rottingOrangesLeetcode994;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/rotting-oranges/description/
public class Solution {

    public static void main(String[] args) {

    }

    public int orangesRottingEfficient(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        boolean [][] visited = new boolean[rows][columns];

        Queue<Pair>queue = new LinkedList<>();
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                if(grid[i][j] == 2){
                    queue.add(new Pair(i,j));
                }
            }
        }

        int minMin = BFS(queue, grid, visited);
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                if(grid[i][j] == 1 ) return -1;
            }
        }

        return minMin;

    }

    public int BFS( Queue<Pair> queue, int[][]grid, boolean[][]visited){
        int rows = grid.length;
        int columns = grid[0].length;
        int count = -1;
        while(queue.size() > 0){
            count++;
            int size = queue.size();
            for(int k=0; k<size; k++){
                Pair pair = queue.poll();
                int i = pair.first;
                int j = pair.second;
                grid[i][j] = 2;
                if(i+1 < rows && !visited[i+1][j] && grid[i+1][j]== 1){
                    visited[i+1][j] = true;
                    queue.add(new Pair(i+1, j));
                }
                if(i-1 >=0 && !visited[i-1][j] && grid[i-1][j]== 1){
                    visited[i-1][j] = true;
                    queue.add(new Pair(i-1, j));
                }
                if(j+1 < columns && !visited[i][j+1] && grid[i][j+1]== 1){
                    visited[i][j+1] = true;
                    queue.add(new Pair(i, j+1));
                }
                if(j-1 >=0 && !visited[i][j-1] && grid[i][j-1]== 1){
                    visited[i][j-1] = true;
                    queue.add(new Pair(i, j-1));
                }
            }
        }
        return count == -1 ? 0 : count;
    }

    public int orangesRottingBruteForce(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        int [][]values = new int[rows][columns];

        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                values[i][j] = -1;
            }
        }

        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                boolean [][] visited = new boolean[rows][columns];
                if(grid[i][j] == 2){
                    BFS(i, j, grid, visited, values);
                }
            }
        }

        int minMin = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                if(grid[i][j] == 1 && values[i][j] == -1) return -1;
                minMin = Math.max(minMin, values[i][j]);
            }
        }

        return minMin;

    }

    public void BFS(int i, int j, int[][]grid, boolean[][]visited, int[][] values){
        int rows = grid.length;
        int columns = grid[0].length;
        Queue<Pair> queue =new LinkedList<>();
        visited[i][j] = true;
        queue.add(new Pair(i,j));
        int count =-1;
        while(queue.size() > 0){
            int size = queue.size();
            count++;
            for(int k=0; k<size; k++){
                Pair pair = queue.poll();
                i = pair.first;
                j = pair.second;
                values[i][j] = values[i][j] == -1 ? count : Math.min(count, values[i][j]);
                if(i+1 < rows && !visited[i+1][j] && grid[i+1][j]== 1){
                    visited[i+1][j] = true;
                    queue.add(new Pair(i+1, j));
                }
                if(i-1 >=0 && !visited[i-1][j] && grid[i-1][j]== 1){
                    visited[i-1][j] = true;
                    queue.add(new Pair(i-1, j));
                }
                if(j+1 < columns && !visited[i][j+1] && grid[i][j+1]== 1){
                    visited[i][j+1] = true;
                    queue.add(new Pair(i, j+1));
                }
                if(j-1 >=0 && !visited[i][j-1] && grid[i][j-1]== 1){
                    visited[i][j-1] = true;
                    queue.add(new Pair(i, j-1));
                }
            }
        }
    }
}

class Pair{
    int first;
    int second;
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
