package graph.minStepsByKnightGFG;

import java.util.ArrayDeque;
import java.util.Queue;

//https://practice.geeksforgeeks.org/problems/steps-by-knight5927/1
class Solution {

    public static void main(String[] args) {

    }

    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int targetPos[], int N){
        boolean[][] visited = new boolean[N+1][N+1];

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(KnightPos[0], KnightPos[1]));
        visited[KnightPos[0]][KnightPos[1]] = true;
        int result = 0;

        int [][] values = new int[8][2];
        buildPossibleCordinateValues(values);

        while(queue.size() > 0){
            int size = queue.size();
            for(int qIndex = 0; qIndex < size; qIndex++){
                Node node = queue.poll();
                if(node.i == targetPos[0] && node.j == targetPos[1]) return result;
                for(int i=0; i<8; i++){
                    int x = node.i + values[i][0];
                    int y = node.j + values[i][1];
                    if(x > 0 && y > 0 && x <= N && y <= N && !visited[x][y] ){
                        visited[x][y] = true;
                        queue.add(new Node(x, y));
                    }
                }
            }
            result++;
        }

        return -1;
    }

    public void buildPossibleCordinateValues(int [][] values){
        values[0][0] = -2;values[0][1] = -1;
        values[1][0] = -2;values[1][1] = 1;
        values[2][0] = 2;values[2][1] = -1;
        values[3][0] = 2;values[3][1] = 1;

        values[4][0] = -1;values[4][1] = -2;
        values[5][0] = 1;values[5][1] = -2;
        values[6][0] = -1;values[6][1] = 2;
        values[7][0] = 1;values[7][1] = 2;
    }
}

class Node{
    int i;
    int j;
    public Node(int i, int j){
        this.i = i;
        this.j = j;
    }
}
