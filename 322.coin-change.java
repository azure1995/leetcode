import java.util.Arrays;

/*
 * [322] Coin Change
 *
 * https://leetcode.com/problems/coin-change/description/
 *
 * algorithms
 * Medium (27.50%)
 * Total Accepted:    127.5K
 * Total Submissions: 463.3K
 * Testcase Example:  '[1,2,5]\n11'
 *
 * You are given coins of different denominations and a total amount of money
 * amount. Write a function to compute the fewest number of coins that you need
 * to make up that amount. If that amount of money cannot be made up by any
 * combination of the coins, return -1.
 * 
 * Example 1:
 * 
 * 
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3 
 * Explanation: 11 = 5 + 5 + 1
 * 
 * Example 2:
 * 
 * 
 * Input: coins = [2], amount = 3
 * Output: -1
 * 
 * 
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 * 
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        int[] sorted_coins = coins.clone();
        Arrays.sort(sorted_coins);
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int c = 0; c < sorted_coins.length; c++) {
                if (sorted_coins[c] > i) {
                    break;
                } else if (dp[i - sorted_coins[c]] >= 0) {
                    dp[i] = Math.min(dp[i] == -1 ? Integer.MAX_VALUE : dp[i], dp[i - sorted_coins[c]] + 1);
                }
            }
        }
        return dp[amount];
    }
}
