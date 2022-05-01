package dynamicProgramming.decodeWaysLeetcode91;


import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/decode-ways/
public class Solution {

    public static void main(String[] args) {

    }


    Map<Integer, Integer> map;

    public int numDecodings(String s) {
        map = new HashMap();
        return numDecodingsUtil(s, 0);

    }

    public int numDecodingsUtil(String str, int i){

        int n = str.length();
        if(i == n) return 0;

        if(i == n-1) {
            char ch = str.charAt(i);
            if(ch-'0' >= 1 && ch-'0' <= 9) return 1;
            return 0;
        }

        int digit1 = str.charAt(i) - '0';
        int digit2 = str.charAt(i+1) - '0';
        if( digit1 == 0) return 0;

        if( i == n-2){
            int count = 0;
            if( digit1 >= 1 && digit1 <= 9 && digit2 >= 1 && digit2 <= 9 ) count++;
            int num = digit1 * 10 + digit2;
            if(num >= 1 && num <= 26 ) count++;
            return count;
        }

        if( map.containsKey(i) ) return map.get(i);

        int count = 0;
        if(digit1 >= 1 && digit1 <= 9) {
            count += numDecodingsUtil(str, i+1);
        }

        int num = digit1 * 10 + digit2;
        if(num >= 1 && num <= 26 ) {
            count+= numDecodingsUtil(str, i+2);
        }

        map.put(i, count);
        return count;

    }


    public int numDecodingsTabular(String s) {

        int firstLast = 1;
        int secondLast = 0;
        int n= s.length();
        for(int i = n-1; i>=0; i--){
            int temp = 0;
            int digit1 = s.charAt(i) - '0';
            if(digit1 != 0){
                if( digit1 >= 1 && digit1 <= 9) temp+= firstLast;
                if(i+1 <= n-1){
                    int digit2 = s.charAt(i+1) - '0';
                    int num = digit1 * 10 + digit2;
                    if(num >= 1 && num <= 26 ) temp+= secondLast;
                }
            }
            secondLast = firstLast;
            firstLast = temp;
        }

        return firstLast;


    }

}
