package array.bestTimeToBuyAndSellStockIIILeetcode123;

import java.util.HashMap;
import java.util.Map;

//123. Best Time to Buy and Sell Stock III
public class Solution {
    public static void main(String[] args) {

    }



    // decide and conquer approach
    //https://www.youtube.com/watch?v=37s1_xBiqH0
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int leftMin = prices[0];
        int leftProfit[] = new int[n];
        leftProfit[0] = 0;
        for(int i=1; i<n; i++){
            leftProfit[i] = Math.max(leftProfit[i-1], prices[i] - leftMin );
            leftMin = Math.min(leftMin, prices[i]);
        }

        int rightMax = prices[n-1];
        int rightProfit[] = new int[n];
        rightProfit[n-1] = 0;
        for(int i=n-2; i>=0; i--){
            rightProfit[i] = Math.max(rightProfit[i+1], rightMax - prices[i]);
            rightMax = Math.max(rightMax, prices[i]);
        }

        int profit = rightProfit[0];
        for(int i=1; i<n; i++){
            profit = Math.max(profit, leftProfit[i-1] + rightProfit[i]);
        }

        return profit;

    }


    Map<String, Integer> map;

    // O(n*2)
    public int maxProfitRecursion(int[] prices) {
        map = new HashMap();
        return maxProfitRec(prices, 0, false, 2);
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

}
