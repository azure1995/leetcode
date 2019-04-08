class Solution {
    public int profitableSchemes(int G, int P, int[] group, int[] profit) {
        int mod = (int) 1e9 + 7;
        int N = group.length;
        int[][] dp = new int[G + 1][P + 1];
        dp[0][0] = 1;
        for (int i = 0; i < N; i++) {
            for (int g = G; g >= group[i]; g--) {
                for (int p = P; p >= Math.max(0, P - profit[i]); p--) {
                    dp[g][P] = (dp[g][P] + dp[g - group[i]][p]) % mod;
                }
                for (int p = P - 1; p >= profit[i]; p--) {
                    dp[g][p] = (dp[g][p] + dp[g - group[i]][p - profit[i]]) % mod;
                }
            }
        }
        int ans = 0;
        for (int g = 0; g <= G; g++) {
            ans = (ans + dp[g][P]) % mod;
        }
        return ans;
    }
}