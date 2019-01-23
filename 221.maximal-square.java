class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        if (n == 0) {
            return 0;
        }
        int m = matrix[0].length;
        int[] dp = new int[m + 1];
        int maxSide = 0;
        for (int i = 0; i < n; i++) {
            int pre = 0;
            for (int j = 1; j <= m; j++) {
                int temp = dp[j];
                if (matrix[i][j - 1] == '1') {
                    dp[j] = Math.min(Math.min(pre, dp[j]), dp[j - 1]) + 1;
                    maxSide = Math.max(maxSide, dp[j]);
                } else {
                    dp[j] = 0;
                }
                pre = temp;
            }
        }
        return maxSide * maxSide;
    }
}