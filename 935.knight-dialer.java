class Solution {
    public int knightDialer(int N) {
        int mod = (int) 1e9 + 7;
        int[][] from = { { 4, 6 }, { 6, 8 }, { 7, 9 }, { 4, 8 }, { 0, 3, 9 }, {}, { 0, 1, 7 }, { 2, 6 }, { 1, 3 },
                { 2, 4 } };
        int[] dp = new int[10];
        Arrays.fill(dp, 1);
        for (int i = 1; i < N; i++) {
            int[] tmp = new int[10];
            for (int n = 0; n <= 9; n++) {
                for (int f = 0; f < from[n].length; f++) {
                    tmp[n] = (tmp[n] + dp[from[n][f]]) % mod;
                }
            }
            dp = tmp;
        }
        int ret = 0;
        for (int n = 0; n <= 9; n++) {
            ret = (ret + dp[n]) % mod;
        }
        return ret;
    }
}