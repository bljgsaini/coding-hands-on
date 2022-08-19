package stack.generateParenthesesLeetcode22;


//https://leetcode.com/problems/generate-parentheses/

/* Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
Example 1:
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]

Constraints:
1 <= n <= 8
*/

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

    }


    List<String> result;

    public List<String> generateParenthesis(int n) {
        result = new ArrayList();
        solution("", 0, 0, n);
        return result;
    }

    public void solution(String str, int open, int close, int n){
        if(open == n && close == n ) {
            result.add(str);
            return ;
        }
        if(open == n){
            solution(str+ ")", open, close+1, n);
        }else if(open == close){
            solution(str + "(", open+1, close, n);
        }else{
            solution(str + "(", open+1, close, n);
            solution(str+ ")", open, close+1, n);
        }
    }


    public List<String> generateParenthesisFaster(int n) {
        result = new ArrayList();
        solution( new StringBuilder(), 0, 0, n);
        return result;
    }

    public void solution(StringBuilder sb, int open, int close, int n){
        if(open == n && close == n ) {
            result.add(sb.toString());
            return ;
        }

        if(open < n ){
            sb.append("(");
            solution(sb, open+1, close, n);
            sb.setLength(sb.length() -1);
        }

        if(close < open ){
            sb.append(")");
            solution(sb, open, close+1, n);
            sb.setLength(sb.length() -1);
        }

    }


}
