package slidingWindowProblem.LongestRepeatingCharReplacementLeetcode424;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/longest-repeating-character-replacement/

/* You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.



Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.


Constraints:

1 <= s.length <= 105
s consists of only uppercase English letters.
0 <= k <= s.length */

public class Solution {
    public static void main(String[] args) {

    }

    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap();
        int i=0, j=0;
        int ans = 0;
        while(j < s.length()){
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0 ) + 1);
            int maxFreq = getMaxOccurringCharFreq(map); // time complexity O(26)
            if(j-i+1 - maxFreq <= k ){
                ans = Math.max(ans, j-i+1);
            }else{
                while(!map.isEmpty() && j-i+1 - maxFreq > k){
                    char ch2 = s.charAt(i);
                    int freq = map.get(ch2);
                    if(freq == 1 ) map.remove(ch2);
                    else map.put(ch2, freq-1);
                    maxFreq = getMaxOccurringCharFreq(map);
                    i++;
                }
            }
            j++;
        }
        return ans;
    }

    public int getMaxOccurringCharFreq(Map<Character, Integer> map){
        int max = 0;
        for( Character ch : map.keySet() ) max = Math.max(max, map.get(ch));
        return max;
    }

    public int characterReplacement1(String s, int k) {
        Map<Character, Integer> map = new HashMap();
        int i=0, j=0;
        int ans = 0; int maxFreq = 0;
        while(j < s.length()){
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0 ) + 1);
            maxFreq = Math.max(maxFreq, map.get(ch));
            if(j-i+1 - maxFreq <= k ){
                ans = Math.max(ans, j-i+1);
            }else{
                while(!map.isEmpty() && j-i+1 - maxFreq > k){
                    char ch2 = s.charAt(i);
                    int freq = map.get(ch2);
                    if(freq == 1 ) map.remove(ch2);
                    else map.put(ch2, freq-1);
                    i++;
                }
            }
            j++;
        }
        return ans;
    }

}
