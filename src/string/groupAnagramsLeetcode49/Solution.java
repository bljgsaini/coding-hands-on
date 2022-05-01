package string.groupAnagramsLeetcode49;

import java.util.*;


//https://leetcode.com/problems/group-anagrams/submissions/
public class Solution {

    public static void main(String[] args) {

    }


    public List<List<String>> groupAnagramsSortCharArray(String[] strs) {
        Map<String, List<String>> map = new HashMap();
        for( String str: strs ){
            char []charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            List<String> list = map.getOrDefault(key, new ArrayList());
            list.add(str);
            map.put(key, list );
        }
        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap();
        for( String str: strs ){
            int []freq = new int[26];
            char []charArray = str.toCharArray();
            for(int i=0; i<charArray.length; i++){
                char ch = charArray[i];
                freq[ch-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<26; i++){
                if(freq[i] > 0){
                    char ch = (char)(i + 'a');
                    sb.append( String.valueOf(ch) + freq[i] );
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList());
            list.add(str);
            map.put(key, list );
        }

        List<List<String>> list = new ArrayList();
        for(String key : map.keySet()){
            list.add(map.get(key));
        }
        return list;
    }

}
