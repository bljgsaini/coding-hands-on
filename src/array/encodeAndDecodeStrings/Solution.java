package array.encodeAndDecodeStrings;

import java.util.ArrayList;
import java.util.List;

//https://www.lintcode.com/problem/659/description

/*
* Description
Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.

Please implement encode and decode

Contact me on wechat to get Amazon、Google requent Interview questions . (wechat id : jiuzhang0607)


Example
Example1

Input: ["lint","code","love","you"]
Output: ["lint","code","love","you"]
Explanation:
One possible encode method is: "lint:;code:;love:;you"
Example2

Input: ["we", "say", ":", "yes"]
Output: ["we", "say", ":", "yes"]
Explanation:
One possible encode method is: "we:;say:;:::;yes"
*
*
* */

public class Solution {
    public static void main(String[] args) {

    }

    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str: strs){
            int n = str.length();
            sb.append(n);
            sb.append(",");
            sb.append(str);
        }
        return sb.toString();
    }
    /*
     * @param str: A string
     * @return: dcodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        List<String> strs = new ArrayList();
        for(int i=0; i<str.length();){
            int numOfChars = 0;
            while(i<str.length() && str.charAt(i) != ','){
                int digit = str.charAt(i) - '0';
                numOfChars = numOfChars*10 + digit;
                i++;
            }
            i++;
            StringBuilder sb = new StringBuilder();
            for(int k=0; k<numOfChars; k++){
                sb.append(str.charAt(i+k));
            }
            strs.add(sb.toString());
            i += numOfChars;
        }
        return strs;
    }

}
