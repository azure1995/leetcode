class Solution {
    public int removeBoxes(int[] boxes) {
        int N = boxes.length;
        int[][][] dp = new int[N][N][N];
        for (int i = 0; i < N; i++) {
            for (int k = 0; k <= i; k++) {
                dp[i][i][k] = (k + 1) * (k + 1);
            }
        }
        for (int d = 1; d < N; d++) {
            for (int i = 0; i < N - d; i++) {
                int j = i + d;
                for (int k = 0; k <= i; k++) {
                    int res = (k + 1) * (k + 1) + dp[i + 1][j][0];
                    for (int m = i + 1; m <= j; m++) {
                        if (boxes[m] == boxes[i]) {
                            res = Math.max(res, dp[i + 1][m - 1][0] + dp[m][j][k + 1]);
                        }
                    }
                    dp[i][j][k] = res;
                }
            }
        }
        return N == 0 ? 0 : dp[0][N - 1][0];
    }
}