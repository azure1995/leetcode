class Solution {
    public double largestSumOfAverages(int[] A, int K) {
        double[] dp = new double[A.length + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        for (int k = 1; k <= K; k++) {
            for (int i = A.length; i >= k; i--) {
                double sum = 0;
                for (int j = i - 1; j >= k - 1; j--) {
                    sum += A[j];
                    dp[i] = Math.max(dp[i], dp[j] + sum / (i - j));
                }
            }
        }
        return dp[A.length];
    }
}