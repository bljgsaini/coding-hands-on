package slidingWindowProblem;

//3. Longest Substring Without Repeating Characters
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcbcd"));
    }

    public static int lengthOfLongestSubstring(String s) {

        int i=0, j= 0;
        int ans = 0;
        int n = s.length();
        while(j < n ){
            ans = Math.max(ans, j-i+1);
            j++;
            if(j == n ) return ans;
            int index = findIndex(s, i, j);
            if(index != -1 ) i = index+1;
        }
        return ans;
    }

    public static int findIndex(String s, int i, int j){
        char ch = s.charAt(j);
        for(int k=i; k<j; k++){
            if(s.charAt(k) == ch){
                return k;
            }
        }
        return -1;
    }

}
