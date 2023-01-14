package graph.wallsAndGateLeetcode286;

import java.util.ArrayDeque;
import java.util.Queue;

//https://www.lintcode.com/problem/663/
public class Solution {

    /* Input:
        [[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1],[2147483647,-1,2147483647,-1],[0,-1,2147483647,2147483647]]
        Output:
        [[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,3,4]]

        Explanation:
        the 2D grid is:
        INF  -1  0  INF
        INF INF INF  -1
        INF  -1 INF  -1
        0  -1 INF INF
        the answer is:
        3  -1   0   1
        2   2   1  -1
        1  -1   2  -1
        0  -1   3   4
      */

    public static void main(String[] args) {
        //int [][] rooms = {{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
        int [][] rooms = {{0,-1},{2147483647,2147483647}};
        wallsAndGates(rooms);
        for(int[] nums : rooms){
            for(int num : nums){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;
        boolean [][] visited = new boolean[m][n];
        Queue<Pair> queue = new ArrayDeque();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(rooms[i][j] == 0){
                    visited[i][j] = true;
                    queue.add(new Pair(i, j));
                }
            }
        }
        BFS(rooms, visited, queue);
    }

    public static void BFS(int [][] rooms, boolean [][]visited, Queue<Pair> queue){
        int m = rooms.length;
        int n = rooms[0].length;
        while(queue.size() != 0){
            int size = queue.size();
            for(int k=0; k<size; k++){
                Pair pair = queue.poll();
                int i = pair.first; int j = pair.second;
                if(i+1 < m && !visited[i+1][j] && rooms[i+1][j] == 2147483647){
                    rooms[i+1][j] = rooms[i][j] + 1;
                    visited[i+1][j] = true;
                    queue.add(new Pair(i+1, j));
                }
                if(i-1 >= 0 && !visited[i-1][j] && rooms[i-1][j] == 2147483647){
                    rooms[i-1][j] = rooms[i][j] + 1;
                    visited[i-1][j] = true;
                    queue.add(new Pair(i-1, j));
                }
                if(j+1 < n && !visited[i][j+1] && rooms[i][j+1] == 2147483647){
                    rooms[i][j+1] = rooms[i][j] + 1;
                    visited[i][j+1] = true;
                    queue.add(new Pair(i, j+1));
                }
                if(j-1 >=0  && !visited[i][j-1] && rooms[i][j-1] == 2147483647){
                    rooms[i][j-1] = rooms[i][j] + 1;
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
