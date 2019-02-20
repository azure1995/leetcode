class Solution {
    public int minFallingPathSum(int[][] A) {
        int N = A.length;
        int[] dp = A[0].clone();
        for (int r = 1; r < N; r++) {
            for (int c = 0, pre = Integer.MAX_VALUE; c < N; c++) {
                int tmp = dp[c];
                dp[c] = Math.min(dp[c], Math.min(pre, c + 1 == N ? Integer.MAX_VALUE : dp[c + 1])) + A[r][c];
                pre = tmp;
            }
        }
        return Arrays.stream(dp).min().getAsInt();
    }
}