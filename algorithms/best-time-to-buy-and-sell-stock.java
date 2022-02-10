class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0;
        int sell = 0;
        int maxProfit = 0;
        
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[buy];
            sell = i;
            buy = diff < 0 ? i : buy;
            
            if (diff >= maxProfit) {
                maxProfit = diff;
            }
        }
        
        return maxProfit;
    }
}
