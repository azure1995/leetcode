class Solution {
    final int[][] directs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> queue = new LinkedList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.add(new int[] { i, j, 0 });
                }
            }
        }
        int[][] ret = new int[m][n];
        while (!queue.isEmpty()) {
            int[] head = queue.remove();
            for (int d = 0; d < directs.length; d++) {
                int next_row = head[0] + directs[d][0];
                int next_col = head[1] + directs[d][1];
                if (next_row >= 0 && next_row < m && next_col >= 0 && next_col < n 
                && ret[next_row][next_col] == 0 && matrix[next_row][next_col] == 1) {
                    ret[next_row][next_col] = head[2] + 1;
                    queue.add(new int[] { next_row, next_col, head[2] + 1 });
                }
            }
        }
        return ret;
    }
}