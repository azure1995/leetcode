class Solution {
    public int splitArray(int[] nums, int m) {
        int N = nums.length;
        int[] sum = new int[N];
        for (int i = 0; i < N; i++) {
            sum[i] = i == 0 ? nums[i] : sum[i - 1] + nums[i];
        }
        int[][] dp = new int[N][m];
        for (int i = 0; i < N; i++) {
            dp[i][0] = sum[i];
            for (int j = 1; j <= Math.min(i, m - 1); j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i - 1; k  >= j - 1; k--) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(sum[i] - sum[k], dp[k][j - 1]));   
                }
            }
        }
        return dp[N - 1][m - 1];
    }
}