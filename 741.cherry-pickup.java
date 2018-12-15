class Solution {
    public int cherryPickup(int[][] grid) {
        int N = grid.length;
        int[][] dp = new int[N][N];
        dp[0][0] = grid[0][0];
        for (int t = 1; t <= 2 * N - 2; t++) {
            int[][] temp = new int[N][N];
            for (int[] row : temp) {
                Arrays.fill(row, Integer.MIN_VALUE);
            }
            for (int i1 = Math.max(0, t - N + 1); i1 <= Math.min(N - 1, t); i1++) {
                for (int i2 = Math.max(0, t - N + 1); i2 <= Math.min(N - 1, t); i2++) {
                    if (grid[i1][t - i1] == -1 || grid[i2][t - i2] == -1) continue;
                    for (int p1 = i1 - 1; p1 <= i1; p1++) {
                        for (int p2 = i2 - 1; p2 <= i2; p2++) {
                            if (p1 < 0 || p2 < 0) continue;
                            temp[i1][i2] = Math.max(temp[i1][i2], dp[p1][p2]);
                        }
                    }
                    temp[i1][i2] += i1 == i2 ? grid[i1][t - i1] : grid[i1][t - i1] + grid[i2][t - i2];
                }
            }
            dp = temp;
        }
        return Math.max(0, dp[N - 1][N - 1]);
    }
}