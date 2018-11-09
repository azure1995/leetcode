class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int d = 1; d < n; d++) {
            for (int i = 1; i <= n - d; i++) {
                if (d == 1) {
                    dp[i][i + 1] = i;
                    continue;
                }
                int min = Integer.MAX_VALUE;
                for (int j = i + 1; j < i + d; j++) {
                    min = Math.min(min, j + Math.max(dp[i][j - 1], dp[j + 1][i + d]));
                }
                dp[i][i + d] = min;
            }
        }
        return dp[1][n];
    }
}