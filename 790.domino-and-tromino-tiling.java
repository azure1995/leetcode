class Solution {
    final int mod = (int)(1e9)+7;
    public int numTilings(int N) {
        if (N == 1) {
            return 1;
        }
        long[][] rec = new long[N + 1][N + 1];
        rec[0][0] = rec[1][1] = 1;
        for (int i = 2; i <= N; i++) {
            rec[i][i] = (rec[i - 1][i - 1] + rec[i - 2][i - 2] + 2 * rec[i - 2][i - 1]) % mod;
            rec[i - 1][i] = (rec[i - 2][i - 2] + rec[i - 2][i - 1]) % mod;
        }
        return (int)rec[N][N];
    }
}