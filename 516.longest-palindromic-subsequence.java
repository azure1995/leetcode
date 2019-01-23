class Solution {
    public int longestPalindromeSubseq(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int[][] dp = new int[s.length()][s.length()];
        for (int d = 0; d < s.length(); d++) {
            for (int i = 0; i < s.length() - d; i++) {
                if (d == 0) {
                    dp[i][i] = 1;
                } else {
                    if (s.charAt(i) == s.charAt(i + d)) {
                        dp[i][i + d] = 2 + dp[i + 1][i + d - 1];
                    } else {
                        dp[i][i + d] = Math.max(dp[i + 1][i + d], dp[i][i + d - 1]);
                    }
                }
            }
        }
        return dp[0][s.length() - 1];
    }
}