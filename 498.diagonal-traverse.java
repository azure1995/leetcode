class Solution {

    public int[] findDiagonalOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return new int[] {};
        }
        int n = matrix[0].length;
        int[] move = { -1, 1 };
        int[] ret = new int[m * n];
        int i = 0, j = 0, counter = 0;
        while (counter < m * n) {
            do {
                ret[counter++] = matrix[i][j];
                i += move[0];
                j += move[1];
            } while (i >= 0 && i < m && j >= 0 && j < n);
            if (i == -1) {
                if (j < n) {
                    i = 0;
                } else {
                    i = 1;
                    j = n - 1;
                }
            } else if (i == m) {
                i = m - 1;
                j += 2;
            }
            if (j == -1) {
                if (i < m) {
                    j = 0;
                } else {
                    j = 1;
                    i = m - 1;
                }
            } else if (j == n) {
                j = n - 1;
                i += 2;
            }
            move[0] *= -1;
            move[1] *= -1;
        }
        return ret;
    }
}