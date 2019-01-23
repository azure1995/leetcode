class Solution {
    final int mod = (int) (1e9 + 7);
    final int[][] directs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public int findPaths(int m, int n, int N, int i, int j) {
        if (N == 0) {
            return 0;
        }
        int[][][] record = new int[2][m][n];
        record[0][i][j] = 1;
        int result = 0;
        for (int d = 0; d < directs.length; d++) {
            if (i + directs[d][0] < 0 || i + directs[d][0] >= m || j + directs[d][1] < 0 || j + directs[d][1] >= n) {
                result++;
            }
        }
        for (int t = 1; t < N; t++) {
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    record[t % 2][r][c] = 0;
                    for (int d = 0; d < directs.length; d++) {
                        int nr = r + directs[d][0];
                        int nc = c + directs[d][1];
                        if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                            record[t % 2][r][c] += record[(t - 1) % 2][nr][nc];
                            record[t % 2][r][c] %= mod;
                        }
                    }
                }
            }
            for (int u = 0; u < m; u++) {
                result = (result + (record[t % 2][u][0] + record[t % 2][u][n - 1]) % mod) % mod;
            }
            for (int u = 0; u < n; u++) {
                result = (result + (record[t % 2][0][u] + record[t % 2][m - 1][u]) % mod) % mod;
            }
        }
        return result;
    }
}