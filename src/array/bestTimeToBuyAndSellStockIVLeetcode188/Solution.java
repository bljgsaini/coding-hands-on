package array.bestTimeToBuyAndSellStockIVLeetcode188;

import java.util.HashMap;
import java.util.Map;

//188. Best Time to Buy and Sell Stock IV
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
public class Solution {
    public static void main(String[] args) {

    }

    Map<String, Integer> map;

    public int maxProfit(int k, int[] prices) {
        map = new HashMap();
        return maxProfitRec(prices, 0, false, k);
    }

    public int maxProfitRec(int []prices, int index, boolean bought, int t){

        if(index == prices.length || t == 0 ) return 0;

        String key = index + String.valueOf(bought) + t;
        if(map.containsKey(key)) return map.get(key);

        int result = maxProfitRec(prices, index+1, bought, t );
        if(bought){
            result = Math.max(result, maxProfitRec(prices, index+1, false, t-1) + prices[index]);
        }else{
            result = Math.max(result, maxProfitRec(prices, index+1, true, t) - prices[index]);
        }
        map.put(key, result);
        return result;
    }

    //https://www.youtube.com/watch?v=oDhu5uGq_ic
    public int maxProfitBottomUp(int k, int []prices){
        int n = prices.length;
        int [][]dp = new int[k+1][n+1];

        for(int i=0; i<=k; i++) dp[i][0] = 0;
        for(int i=0; i<=n; i++) dp[0][i] = 0;

        /*
        * dp[i][j] = max of ( dp[i][j-1], maxOf( prices[j] - prices[m] + dp[i-1][m]  ) )
        * */

        for(int i=1; i<=k; i++){
            for(int j=1; j<=n; j++){
                int localMax = 0;
                for(int m = 0; m<j-1; m++){
                    localMax = Math.max(localMax, prices[j-1] - prices[m] + dp[i-1][m]);
                }
                dp[i][j] = Math.max(dp[i][j-1], localMax);
            }
        }
        return dp[k][n];
    }

    //https://www.youtube.com/watch?v=oDhu5uGq_ic
    public int maxProfitBottomUpOptimized(int k, int []prices){

        /*
         * dp[i][j] = max of ( dp[i][j-1], maxOf( prices[j] - prices[m] + dp[i-1][m]  ) )
         *
         * maxOf( prices[j] - prices[m] + dp[i-1][m]  ) =>  dp[i-1][m] - prices[m] + prices[j] (constant in every m)
         * store dp[i-1][m] - prices[m] this to maxDiff and update everytime with the new max
         * */

        int n = prices.length;
        if(k-1 > n/2 ) return 0;

        int [][]dp = new int[k+1][n];

        for(int i=0; i<=k; i++) dp[i][0] = 0;
        for(int j=0; j<n; j++) dp[0][j] = 0;

        for(int i=1; i<=k; i++){
            int maxDiff = dp[i-1][0] - prices[0];
            for(int j=1; j<n; j++){
                int localMax = maxDiff + prices[j];
                dp[i][j] = Math.max(dp[i][j-1], localMax);
                maxDiff = Math.max( maxDiff, dp[i-1][j] - prices[j] );
            }
        }
        return dp[k][n-1];

    }

}
