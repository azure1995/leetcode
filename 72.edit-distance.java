class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i < len2; i++) {
            dp[len1][i] = len2 - i;
        }
        for (int i = 0; i < len1; i++) {
            dp[i][len2] = len1 - i;
        }
        for (int i1 = len1 - 1; i1 >= 0; i1--) {
            for (int i2 = len2 - 1; i2 >= 0; i2--) {
                if (word1.charAt(i1) == word2.charAt(i2)) {
                    dp[i1][i2] = dp[i1 + 1][i2 + 1];
                } else {
                    dp[i1][i2] = 1 + Math.min(dp[i1 + 1][i2 + 1], Math.min(dp[i1][i2 + 1], dp[i1 + 1][i2]));
                }
            }
        }
        return dp[0][0];
    }
}
