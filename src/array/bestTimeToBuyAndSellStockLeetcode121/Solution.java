package array.bestTimeToBuyAndSellStockLeetcode121;

//121. Best Time to Buy and Sell Stock
public class Solution {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int profit = 0;
        int minPrice = prices[0];

        for(int i=1; i<prices.length; i++){
            if(prices[i] > minPrice){
                profit = Math.max(profit, prices[i] - minPrice);
            }
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }
        }
        return profit;
    }

}
