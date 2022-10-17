package graph.wordSearchLeetcode79;



//https://leetcode.com/problems/word-search/
public class Solution {
    public static void main(String[] args) {

    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                boolean[][] visited = new boolean[m][n];
                if(DFS(board, i, j, visited, word, 0)) return true;
            }
        }
        return false;
    }

    public boolean DFS(char[][] board, int i, int j, boolean[][]visited, String word, int k){
        if(i < 0 || j < 0 || i>= board.length || j >= board[0].length || visited[i][j]) return false;
        if(k == word.length()) return true;

        char ch = board[i][j];
        if(k == word.length()-1){
            return word.charAt(k) == ch;
        }

        if(word.charAt(k) != ch) return false;
        visited[i][j] = true;
        if(DFS(board, i, j+1, visited, word, k+1)) return true;
        if(DFS(board, i+1, j, visited, word, k+1)) return true;
        if(DFS(board, i, j-1, visited, word, k+1)) return true;
        if(DFS(board, i-1, j, visited, word, k+1)) return true;
        visited[i][j] = false;
        return false;
    }

}


class SolutionV2 {
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                boolean visited[][] = new boolean[board.length][board[0].length];
                if(solve(i, j, board, visited, word, 0)) return true;
            }
        }
        return false;
    }

    public boolean solve(int i, int j, char[][]board, boolean[][]visited, String word, int k){
        if(board[i][j] != word.charAt(k)) return false;
        if(k+1 == word.length()) return true;
        visited[i][j] = true;
        if( i-1 >= 0 && !visited[i-1][j]) {
            if(solve(i-1, j, board, visited, word, k+1)) return true;
        }
        if( i+1 < board.length && !visited[i+1][j]) {
            if(solve(i+1, j, board, visited, word, k+1)) return true;
        }
        if( j-1 >= 0 && !visited[i][j-1]) {
            if(solve(i, j-1, board, visited, word, k+1)) return true;
        }
        if( j+1 < board[0].length && !visited[i][j+1]) {
            if(solve(i, j+1, board, visited, word, k+1)) return true;
        }
        visited[i][j] = false;
        return false;
    }
}
