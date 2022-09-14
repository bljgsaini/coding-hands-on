package trie.wordSearchIILeetcode212;

import java.util.*;


//https://leetcode.com/problems/word-search-ii/
public class Solution {
    public static void main(String[] args) {

    }


    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for(String word: words){
            addWord(root, word);
        }
        Set<String> set = new HashSet();
        int m = board.length;
        int n = board[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                boolean[][] visited = new boolean[m][n];
                DFS(board, i, j, root, "", set, visited);
            }
        }
        List<String> ans = new ArrayList();
        for(String str: set){
            ans.add(str);
        }
        return ans;
    }

    public void DFS(char[][] board, int i, int j, TrieNode root, String word, Set<String> ans, boolean[][] visited){
        if( i< 0 || j < 0 || i>= board.length || j>= board[0].length || visited[i][j]) return;
        char ch = board[i][j];
        TrieNode temp = root.children.getOrDefault(ch, null);
        if( temp == null) return;
        word += ch;
        if(temp.isEndOfWord) ans.add(word);
        visited[i][j] = true;
        DFS(board, i+1, j, temp, word, ans, visited);
        DFS(board, i, j+1, temp, word, ans, visited);
        DFS(board, i-1, j, temp, word, ans, visited);
        DFS(board, i, j-1, temp, word, ans, visited);
        visited[i][j] = false;
    }

    public void addWord(TrieNode root, String word){
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            TrieNode temp = root.children.getOrDefault(ch, new TrieNode());
            root.children.put(ch, temp);
            root =temp;
        }
        root.isEndOfWord = true;
    }

}


class TrieNode{
    Map<Character, TrieNode> children;
    Boolean isEndOfWord;
    TrieNode(){
        children = new HashMap();
        isEndOfWord = false;
    }
}


