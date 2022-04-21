package uniquePathsLeetcode62;

import java.util.HashMap;
import java.util.Map;


//62. Unique Paths
public class Solution {

    public static void main(String[] args) {

    }


    public int uniquePathsTabular(int m, int n) {
        int [][]dp = new int[m+1][n+1];

        for(int j=1; j<=n; j++){
            dp[m][j] = 1;
        }

        for(int i=1; i<=m; i++){
            dp[i][n] = 1;
        }

        for(int i=m-1; i>=1; i--){
            for(int j=n-1; j>=1; j--){
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }

        return dp[1][1];

    }



    Map<String, Integer> map;

    public int uniquePathsRecursion(int m, int n) {
        map = new HashMap();
        return uniquePathsUtil(0, 0, m,n);
    }

    public int uniquePathsUtil(int i, int j, int m, int n){
        if(i >= m || j >= n) return 0;
        if(i == m-1 && j == n-1 ) return 1;

        if(map.containsKey(i+"#"+j)) return map.get(i+"#"+j);

        int paths = uniquePathsUtil(i+1, j, m, n) + uniquePathsUtil(i, j+1, m, n);
        map.put(i+"#"+j, paths);

        return paths;
    }

}
