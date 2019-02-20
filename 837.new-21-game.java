class Solution {
    public double new21Game(int N, int K, int W) {
        if (N < K) {
            return 0.0;
        }
        if (N >= K + W - 1) {
            return 1.0;
        }
        double[] dp = new double[K + W];
        for (int i = K; i <= N; i++) {
            dp[i] = 1.0;
        }
        double S = N - K + 1;
        for (int i = K - 1; i >= 0; i--) {
            dp[i] = S / W;
            S += dp[i] - dp[i + W];
        }
        return dp[0];
    }
}
