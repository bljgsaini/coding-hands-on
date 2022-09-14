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
