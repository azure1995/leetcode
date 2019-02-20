class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int[][] memo = new int[m][n];
        int ret = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (memo[r][c] > 0)
                    continue;
                ret = Math.max(ret, dfs(matrix, m, n, r, c, memo));
            }
        }
        return ret;
    }

    private int dfs(int[][] matrix, int m, int n, int r, int c, int[][] memo) {
        int ret = 0;
        if (r - 1 >= 0 && matrix[r - 1][c] < matrix[r][c]) {
            ret = Math.max(ret, memo[r - 1][c] > 0 ? memo[r - 1][c] : dfs(matrix, m, n, r - 1, c, memo));
        }
        if (r + 1 < m && matrix[r + 1][c] < matrix[r][c]) {
            ret = Math.max(ret, memo[r + 1][c] > 0 ? memo[r + 1][c] : dfs(matrix, m, n, r + 1, c, memo));
        }
        if (c - 1 >= 0 && matrix[r][c - 1] < matrix[r][c]) {
            ret = Math.max(ret, memo[r][c - 1] > 0 ? memo[r][c - 1] : dfs(matrix, m, n, r, c - 1, memo));
        }
        if (c + 1 < n && matrix[r][c + 1] < matrix[r][c]) {
            ret = Math.max(ret, memo[r][c + 1] > 0 ? memo[r][c + 1] : dfs(matrix, m, n, r, c + 1, memo));
        }
        ret++;
        memo[r][c] = ret;
        return ret;
    }
}
