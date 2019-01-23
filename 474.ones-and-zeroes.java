class Solution {

    public int[] format(String s) {
        int[] ret = new int[2];
        for (int i = 0; i < s.length(); i++) {
            ret[s.charAt(i) - '0']++;
        }
        return ret;
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][0] = 0;
        int maxForm = 0;
        for (int k = 0; k < strs.length; k++) {
            int[] counts = format(strs[k]);
            for (int i = m; i >= counts[0]; i--) {
                for (int j = n; j >= counts[1]; j--) {
                    int d0 = i - counts[0];
                    int d1 = j - counts[1];
                    if (dp[d0][d1] >= 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[d0][d1] + 1);
                        maxForm = Math.max(maxForm, dp[i][j]);
                    }
                }
            }
        }
        return maxForm;
    }
}