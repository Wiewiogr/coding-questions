package pl.tw.leetCode;

public class BestTimeToBuyAndSellStocks {

    public int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int maxProfit = 0;

        while(right < prices.length) {
            if(prices[left] > prices[right]) { // było droższe, nie ma sensu sprzedawać
                left = right;
                right++;
            } else {
                maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
                right++;
            }
        }
        return maxProfit;
    }
}
