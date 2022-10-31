package backtracking.letterCombinationsOfPhoneNumLeetcode17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



//https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class Solution {


    Map<Character, String> map;
    List<String> ans;

    public static void main(String[] args) {

    }


    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList();
        map = getMapping();
        return solve(0, digits);
    }


    public List<String> solve(int start, String digits){
        if(start == digits.length()){
            List<String> list =new ArrayList();
            list.add("");
            return list;
        }

        List<String> temp = solve(start+1, digits);
        String mapping = map.get(digits.charAt(start));
        List<String> ans = new ArrayList();

        for(int i=0; i<mapping.length(); i++){
            char ch = mapping.charAt(i);
            for(String str : temp){
                ans.add(ch + str);
            }
        }

        return ans;
    }


    public List<String> letterCombinationsDFS(String digits) {
        ans = new ArrayList();
        if(digits.length() == 0) return ans;
        map = getMapping();
        DFS(0, digits, new StringBuilder());
        return ans;
    }


    public void DFS(int start, String digits, StringBuilder sb){
        if(start == digits.length()){
            ans.add(sb.toString());
            return;
        }
        String mapping = map.get(digits.charAt(start));
        for(int i=0; i<mapping.length(); i++){
            char ch = mapping.charAt(i);
            sb.append(ch);
            DFS(start+1, digits, sb);
            sb.setLength(sb.length()-1);
        }
    }


    public Map<Character, String> getMapping(){
        Map<Character, String> map = new HashMap();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        return map;
    }

}

