<<<<<<< HEAD
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int[] dp = new int[prices.length];
        int[] max = new int[prices.length];
        for (int i = 1; i < prices.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (prices[i] > prices[j]) {
                    dp[i] = Math.max(dp[i], prices[i] - prices[j] + (j >= 2 ? max[j - 2] : 0));
                }
            }
            max[i] = Math.max(max[i - 1], dp[i]);
        }
        return max[prices.length - 1];
    }
=======
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int[] dp = new int[prices.length];
        int[] max = new int[prices.length];
        for (int i = 1; i < prices.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (prices[i] > prices[j]) {
                    dp[i] = Math.max(dp[i], prices[i] - prices[j] + (j >= 2 ? max[j - 2] : 0));
                }
            }
            max[i] = Math.max(max[i - 1], dp[i]);
        }
        return max[prices.length - 1];
    }
>>>>>>> a07c39f2ecee05469bc7938cd2530a4d83ca0284
}