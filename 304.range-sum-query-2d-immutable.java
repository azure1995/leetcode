<<<<<<< HEAD
class NumMatrix {
    int[][] BIT;
    int m, n;

    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        m = matrix.length;
        n = matrix[0].length;
        BIT = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int i1 = i, j1;
                while (i1 <= m) {
                    j1 = j;
                    while (j1 <= n) {
                        BIT[i1][j1] += matrix[i - 1][j - 1];
                        j1 += (j1 & -j1);
                    }
                    i1 += (i1 & -i1);
                }
            }
        }
    }

    public int getSum(int row, int col) {
        int col1, sum = 0;
        row = row + 1;
        col = col + 1;
        while (row > 0) {
            col1 = col;
            while (col1 > 0) {
                sum += BIT[row][col1];
                col1 -= (col1 & -col1);
            }
            row -= (row & -row);
        }
        return sum;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return getSum(row1, col1) + getSum(row2 - 1, col2 - 1) - getSum(row1, col2 - 1) - getSum(row2 - 1, col1);
    }
=======
class NumMatrix {
    int[][] BIT;
    int m, n;

    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        m = matrix.length;
        n = matrix[0].length;
        BIT = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int i1 = i, j1;
                while (i1 <= m) {
                    j1 = j;
                    while (j1 <= n) {
                        BIT[i1][j1] += matrix[i - 1][j - 1];
                        j1 += (j1 & -j1);
                    }
                    i1 += (i1 & -i1);
                }
            }
        }
    }

    public int getSum(int row, int col) {
        int col1, sum = 0;
        row = row + 1;
        col = col + 1;
        while (row > 0) {
            col1 = col;
            while (col1 > 0) {
                sum += BIT[row][col1];
                col1 -= (col1 & -col1);
            }
            row -= (row & -row);
        }
        return sum;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return getSum(row1, col1) + getSum(row2 - 1, col2 - 1) - getSum(row1, col2 - 1) - getSum(row2 - 1, col1);
    }
>>>>>>> a07c39f2ecee05469bc7938cd2530a4d83ca0284
}