package trie.mplementTriePrefixTreeLeetcode208;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        String temp = "ans";
        System.out.println(temp.substring(5));
    }
}



class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            TrieNode temp =  curr.children.getOrDefault(ch, new TrieNode());
            curr.children.put(ch, temp);
            curr = temp;
        }
        curr.isEndOfWord = true;

    }

    public boolean search(String word) {
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            TrieNode temp = curr.children.getOrDefault(ch, null);
            if(temp == null ) return false;
            curr = temp;
        }
        if(curr.isEndOfWord) return true;
        return false;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i=0; i<prefix.length(); i++){
            char ch = prefix.charAt(i);
            TrieNode temp = curr.children.getOrDefault(ch, null);
            if(temp == null ) return false;
            curr = temp;
        }
        return true;
    }
}

class TrieNode {
    Map<Character, TrieNode> children;
    Boolean isEndOfWord;

    TrieNode() {
        children = new HashMap();
        isEndOfWord = false;
    }
}