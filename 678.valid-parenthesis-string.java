class Solution {
    public boolean checkValidString(String s) {
        if (s.length() == 0) {
            return true;
        }
        boolean[][] dp = new boolean[s.length() + 1][s.length()];
        for (int d = 0; d < s.length(); d++) {
            for (int i = 0; i < s.length() - d; i++) {
                if (d == 0) {
                    dp[i][i] = s.charAt(i) == '*';
                    dp[i + 1][i] = true;
                } else {
                    if (s.charAt(i) != ')') {
                        if (s.charAt(i) == '*') {
                            if (dp[i][i + d] = dp[i + 1][i + d]) {
                                continue;
                            }
                        }
                        for (int j = i + 1; j <= i + d; j++) {
                            if (s.charAt(j) == ')' || s.charAt(j) == '*') {
                                if (dp[i][i + d] = dp[i + 1][j - 1] && dp[j + 1][i + d]) {
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        return dp[0][s.length() - 1];
    }
}