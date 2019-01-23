class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        if (matrix.length > matrix[0].length) {
            int[][] tmp = matrix;
            matrix = new int[tmp[0].length][tmp.length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = tmp[j][i];
                }
            }
        }
        int m = matrix.length, n = matrix[0].length;
        int[][] upSum = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                upSum[i][j] = i == 0 ? matrix[i][j] : upSum[i - 1][j] + matrix[i][j];
            }
        }
        long ret = Integer.MIN_VALUE - 1l;
        boolean found = false;
        for (int i = 0; i < m; i++) {
            for (int j = i; j < m; j++) {
                TreeSet<Long> sorted_set = new TreeSet<>();
                sorted_set.add(0l);
                long sum = 0;
                for (int l = 0; l < n; l++) {
                    sum += upSum[j][l] - (i == 0 ? 0 : upSum[i - 1][l]);
                    if (sorted_set.ceiling(sum - k) != null) {
                        found = true;
                        ret = Math.max(ret, sum - sorted_set.ceiling(sum - k));
                    }
                    sorted_set.add(sum);
                }
            }
        }
        return found ? (int) ret : 0;
    }
}
