class Solution {
    public int lenLongestFibSubseq(int[] A) {
        int N = A.length;
        int[][] dp = new int[N][N];
        int ret = 0;
        for (int i = 1; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                int index = Arrays.binarySearch(A, 0, i, A[j] - A[i]);
                if (index >= 0) {
                    dp[i][j] = dp[index][i] + 1;
                    ret = Math.max(ret, dp[i][j]);
                }
            }
        }
        return ret == 0 ? 0 : ret + 2;
    }
}
