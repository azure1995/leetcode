class Solution {
    static final int[][] directs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public void dfs(boolean[][] source, int[][] matrix, int row, int col) {
        for (int i = 0; i < directs.length; i++) {
            int next_row = row + directs[i][0];
            int next_col = col + directs[i][1];
            if (next_row >= 0 && next_row < source.length && next_col >= 0 && next_col < source[0].length
                    && matrix[row][col] <= matrix[next_row][next_col] && !source[next_row][next_col]) {
                source[next_row][next_col] = true;
                dfs(source, matrix, next_row, next_col);
            }
        }
    }

    public List<int[]> pacificAtlantic(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return Collections.EMPTY_LIST;
        }
        int n = matrix[0].length;
        boolean[][] sourceOfPacific = new boolean[m][n];
        for (int i = 0; i < n; i++) {
            if (!sourceOfPacific[0][i]) {
                sourceOfPacific[0][i] = true;
                dfs(sourceOfPacific, matrix, 0, i);
            }
        }
        for (int i = 0; i < m; i++) {
            if (!sourceOfPacific[i][0]) {
                sourceOfPacific[i][0] = true;
                dfs(sourceOfPacific, matrix, i, 0);
            }
        }
        boolean[][] sourceOfAtlantic = new boolean[m][n];
        for (int i = 0; i < n; i++) {
            if (!sourceOfAtlantic[m - 1][i]) {
                sourceOfAtlantic[m - 1][i] = true;
                dfs(sourceOfAtlantic, matrix, m - 1, i);
            }
        }
        for (int i = 0; i < m; i++) {
            if (!sourceOfAtlantic[i][n - 1]) {
                sourceOfAtlantic[i][n - 1] = true;
                dfs(sourceOfAtlantic, matrix, i, n - 1);
            }
        }
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (sourceOfPacific[i][j] && sourceOfAtlantic[i][j]) {
                    result.add(new int[] { i, j });
                }
            }
        }
        return result;
    }
}