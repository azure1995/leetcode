class Solution {
    public int numPermsDISequence(String S) {
        int MOD = (int) 1e9 + 7;
        int N = S.length();
        int[][] dp = new int[N + 1][N + 1];
        Arrays.fill(dp[0], 1);
        for (int i = 0; i < N; ++i) {
            if (S.charAt(i) == 'D') {
                for (int j = N - i - 1, cc = 0; j >= 0; j--) {
                    dp[i + 1][j] = cc = (cc + dp[i][j + 1]) % MOD;
                }
            } else {
                for (int j = 0, cc = 0; j < N - i; j++) {
                    dp[i + 1][j] = cc = (cc + dp[i][j]) % MOD;
                }
            }
        }
        return dp[N][0];
    }
}