package dynamicProgramming;

public class RegularExpressionMatching {

    public static void main(String[] args) {

    }


    Boolean dp[][] = null;

    public boolean isMatch(String s, String p) {
        dp = new Boolean[s.length()+1][p.length()+1]; // to save the already computed data
        return isMatchUtilRecursionDP(s, 0, p, 0);
    }

    public boolean isMatchUtilRecursionDP(String s, int sIndex, String p, int pIndex){

        if(dp[sIndex][pIndex] != null ) return dp[sIndex][pIndex]; // if result present in boolean array return it

        if(pIndex == p.length()) {
            dp[sIndex][pIndex] =  sIndex == s.length(); // storing the result in array for later use
            return dp[sIndex][pIndex];
        }
        boolean flag = false;
        if(sIndex < s.length()){
            flag = (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '.') ;
        }

        if(pIndex < p.length() - 1 && p.charAt(pIndex+1) == '*'){
            // storing the result in array for later use
            dp[sIndex][pIndex] = isMatchUtilRecursionDP(s, sIndex, p, pIndex+2) || flag && isMatchUtilRecursionDP(s, sIndex+1, p, pIndex );
            return dp[sIndex][pIndex];
        }

        dp[sIndex][pIndex] =  flag && isMatchUtilRecursionDP(s, sIndex+1, p, pIndex+1); // storing the result in array for later use

        return dp[sIndex][pIndex];

    }

    public boolean isMatchBottomUp(String s, String p){

        Boolean dp[][] = new Boolean[p.length()+1][s.length()+1];

        dp[0][0] = true;

        for(int i=1; i<=s.length(); i++){
            dp[0][i] = false;
        }

        for(int i=1; i<=p.length(); i++){
            if(p.charAt(i-1) == '*'){
                dp[i][0] = dp[i-2][0];
            }else{
                dp[i][0] = false;
            }
        }

        for(int i=1; i<= p.length(); i++){
            for(int j = 1; j<= s.length(); j++){
                if(p.charAt(i-1) == '*'){
                    boolean flag = p.charAt(i-2) == s.charAt(j-1) || p.charAt(i-2) == '.';
                    dp[i][j] = flag && dp[i][j-1] || dp[i-2][j];
                }else{
                    boolean flag = p.charAt(i-1) == s.charAt(j-1) || p.charAt(i-1) == '.';
                    dp[i][j] = flag && dp[i-1][j-1];
                }
            }
        }

        return dp[p.length()][s.length()];

    }

}
