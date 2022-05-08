package array.bestTimeToBuyAndSellStockIILeetcode122;


//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
public class Solution {
    public static void main(String[] args) {

    }


    public int maxProfit1(int[] prices) {
        int n = prices.length;
        int profit = 0;
        for(int i=0; i<n-1; i++) profit+= Math.max(0, prices[i+1] -prices[i]);
        return profit;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int profit = 0;
        for(int i=0; i<n; i++){
            // find local minima
            while(i+1<n && prices[i] > prices[i+1]) i++;
            if(i == n-1 ) return profit;
            int localMinimaIndex = i;
            i++;
            // find local maxima
            while(i<n && prices[i] > prices[i-1]) i++;
            i--;
            profit += prices[i] - prices[localMinimaIndex];
        }
        return profit;
    }
}
