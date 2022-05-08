package array.bestTimeToBuyAndSellStockWithCooldownLeetcode309;

import java.util.HashMap;
import java.util.Map;


//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
public class Solution {
    public static void main(String[] args) {

    }

    Map<String, Integer> map;

    public int maxProfit(int[] prices) {
        map = new HashMap();
        return maxProfitRecDP(prices, 0, 0);
    }

    public int maxProfitRecDP(int []prices, int prevState, int index){
        if(index >= prices.length ) return 0;

        String key = prevState + "#" + index;

        if(map.containsKey(key)) map.get(key);

        int result = maxProfitRecDP(prices, prevState, index+1);

        if(prevState == 0 ) {
            result = Math.max(result, maxProfitRecDP(prices, 1, index+1) - prices[index]);
        }else if(prevState == 1){
            result = Math.max(result, maxProfitRecDP(prices, 0, index+2) + prices[index]);
        }

        map.put(key, result);

        return result;

    }


}
