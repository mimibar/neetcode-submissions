class Solution {
  public int maxProfit(int[] prices) {
    // buy, sell
    int i = 0, j = prices.length - 1;
    int profit = Integer.MIN_VALUE;
    while (i < j) {
      profit = Math.max(profit, prices[j] - prices[i]);
      if (prices[i + 1] < prices[i]) {
        i++;
      } else
        j--;
    }
    return profit > 0 ? profit : 0;
  }
}
