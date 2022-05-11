package dynamicProgramming.longestSubstringWithoutRepeatingCharactersLeetcode3;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {

    }

    public int lengthOfLongestSubstring(String s) {
        int i=0, j= 0;
        int ans = 0;
        char[] charArray = s.toCharArray();
        while(j < charArray.length ){
            ans = Math.max(ans, j-i+1);
            j++;
            if(j == charArray.length ) return ans;
            int index = findIndex(charArray, i, j);
            if(index != -1 ) i = index+1;
        }
        return ans;
    }

    public int findIndex(char[] charArray, int i, int j){
        char ch = charArray[j];
        for(int k=i; k<j; k++){
            if(charArray[k] == ch){
                return k;
            }
        }
        return -1;
    }


    public int lengthOfLongestSubstringUsingMap(String s) {
        int i=0, j= 0;
        int ans = 0;
        int n = s.length();
        char[] charArray = s.toCharArray();
        Map<Character, Integer> map = new HashMap();
        while(j < n ){
            if(!map.containsKey(charArray[j])){
                ans = Math.max(ans, j-i+1);
            }else{
                for(int k = i; k<map.get(charArray[j]); k++){
                    map.remove(charArray[k]);
                }
                i = map.get(charArray[j]) + 1;
            }

            map.put(charArray[j], j);
            j++;
        }
        return ans;
    }

}
