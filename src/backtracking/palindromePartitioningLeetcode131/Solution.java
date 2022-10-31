package backtracking.palindromePartitioningLeetcode131;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

    }


    List<List<String>> ans;

    public List<List<String>> partition(String s) {
        ans = new ArrayList();
        solve(s, 0, new ArrayList<String>());
        return ans;
    }

    public void solve(String str, int start, List<String> list){
        if(start >= str.length()){
            //System.out.println("true=>" + list);
            ans.add(new ArrayList(list));
            return;
        }
        //System.out.println("start=>" + start);
        for(int i=start; i<str.length(); i++){
            //System.out.println("i=>" + i);
            String firstString = str.substring(start, i+1);
            //System.out.println("firstString=>" + firstString);
            if(!isPallindrome(firstString)) continue;
            list.add(firstString);
            solve(str, i+1, list);
            list.remove(list.size()-1);
        }
    }

    public boolean isPallindrome(String str){
        int i=0, j=str.length()-1;
        while(i<=j){
            if(str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

}
