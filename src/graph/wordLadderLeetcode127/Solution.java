package graph.wordLadderLeetcode127;

import java.util.*;

//127. Word Ladder
public class Solution {

    public static void main(String[] args) {

    }


    public int ladderLengthOptimized(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> adjList = new HashMap();
        wordList.add(beginWord);
        boolean flag = true;
        for(String word: wordList){
            if(word.equals(endWord)) flag = false;
            for(int i=0; i<word.length(); i++){
                String pattern = word.substring(0, i) + "*" + word.substring(i+1);
                List<String> list = adjList.getOrDefault(pattern, new ArrayList());
                list.add(word);
                adjList.put(pattern, list);
            }
        }

        if(flag) return 0;

        Set<String> visited = new HashSet();
        Queue<String> q = new LinkedList();
        q.add(beginWord);
        visited.add(beginWord);
        int ans = 1;
        while(!q.isEmpty()){
            int qSize = q.size();
            for(int a=0; a<qSize; a++){
                String currNode = q.remove();
                if(currNode.equals(endWord)) return ans;
                for(int i=0; i<currNode.length(); i++){
                    String pattern = currNode.substring(0, i) + "*" + currNode.substring(i+1);
                    List<String> patternList = adjList.get(pattern);
                    for(String word: patternList){
                        if(!visited.contains(word)){
                            q.add(word);
                            visited.add(word);
                        }
                    }
                }

            }
            ans+=1;
        }
        return 0;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Map<String, List<String>> adjList = new HashMap();
        wordList.add(beginWord);

        for(String word: wordList){
            List<String> connectedWords = new ArrayList();
            for(String word2: wordList){
                if(getDistance(word, word2) == 1){
                    connectedWords.add(word2);
                }
            }
            //System.out.println(word + " : " + connectedWords);
            adjList.put(word, connectedWords);
        }

        if(!adjList.containsKey(endWord)) return 0;

        Set<String> visited = new HashSet();
        Queue<String> q = new LinkedList();
        q.add(beginWord);
        visited.add(beginWord);
        int ans = 1;
        while(!q.isEmpty()){
            int qSize = q.size();
            for(int i=0; i<qSize; i++){
                String currNode = q.remove();
                if(currNode.equals(endWord)) return ans;
                List<String> currNodeList = adjList.get(currNode);
                for(String word: currNodeList){
                    if(!visited.contains(word)){
                        q.add(word);
                        visited.add(word);
                    }
                }
            }
            ans+=1;
        }

        return 0;

    }

    public int getDistance(String word1, String word2){
        int count = 0;
        for(int i=0; i<word1.length(); i++){
            if(word1.charAt(i) != word2.charAt(i)) count++;
        }
        return count;
    }

}
