class Solution {
    final int[][] directs = { { 2, 1 }, { 1, 2 }, { -1, 2 }, { -2, 1 }, { -2, -1 }, { -1, -2 }, { 1, -2 }, { 2, -1 } };

    public double knightProbability(int N, int K, int r, int c) {
        double[][][] rec = new double[2][N][N];
        rec[0][r][c] = 1.0;
        for (int i = 1; i <= K; i++) {
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    rec[i % 2][row][col] = 0.0;
                    for (int d = 0; d < directs.length; d++) {
                        int pre_row = row + directs[d][0];
                        int pre_col = col + directs[d][1];
                        if (pre_row >= 0 && pre_row < N && pre_col >= 0 && pre_col < N) {
                            rec[i % 2][row][col] += rec[(i - 1) % 2][pre_row][pre_col] / 8.0;
                        }
                    }
                }
            }
        }
        double ret = 0.0;
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                ret += rec[K % 2][row][col];
            }
        }
        return ret;
    }
}