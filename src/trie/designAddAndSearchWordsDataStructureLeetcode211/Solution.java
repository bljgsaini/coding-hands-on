package trie.designAddAndSearchWordsDataStructureLeetcode211;

import java.util.HashMap;
import java.util.Map;


//https://leetcode.com/problems/design-add-and-search-words-data-structure/
public class Solution {
    public static void main(String[] args) {

    }
}


class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++){
            Character ch = word.charAt(i);
            TrieNode temp = curr.children.getOrDefault(ch, new TrieNode());
            curr.children.put(ch, temp);
            curr = temp;
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        char[] charArr = word.toCharArray();
        return searchUtil(charArr, 0, root);
    }

    public boolean searchUtil(char[] charArr, int i, TrieNode head){
        if(head == null) return false;
        char ch = charArr[i];
        if(i == charArr.length-1){
            if(ch == '.'){
                for( Character key : head.children.keySet()){
                    TrieNode temp = head.children.get(key);
                    if(temp.isEndOfWord) return true;
                }
                return false;
            }
            TrieNode temp = head.children.getOrDefault(ch, null);
            if(temp == null) return false;
            return temp.isEndOfWord;
        }

        if(ch == '.'){
            for( Character key : head.children.keySet()){
                TrieNode temp = head.children.get(key);
                if(searchUtil(charArr, i+1, temp)) return true;
            }
            return false;
        }else{
            TrieNode temp = head.children.getOrDefault(ch, null);
            if(temp == null) return false;
            return searchUtil(charArr, i+1, temp);
        }

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