class Solution {
    public int maxCoins(int[] nums) {
        int[] eNums = new int[nums.length + 2];
        int N = 1;
        for (int num : nums) {
            if (num > 0) {
                eNums[N++] = num;
            }
        }
        eNums[0] = eNums[N++] = 1;
        int[][] dp = new int[N][N];
        for (int d = 2; d < N; d++) {
            for (int left = 0; left < N - d; left++) {
                int right = left + d;
                for (int m = left + 1; m < right; m++) {
                    dp[left][right] = Math.max(dp[left][right],
                            dp[left][m] + eNums[left] * eNums[m] * eNums[right] + dp[m][right]);
                }
            }
        }
        return dp[0][N - 1];
    }
}
