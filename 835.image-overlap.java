class Solution {
    public int largestOverlap(int[][] A, int[][] B) {
        int side = A.length;
        int ret = 0;
        for (int i = -side + 1; i < side; i++) {
            for (int j = -side + 1; j < side; j++) {
                int overlap = 0;
                for (int r = Math.max(i, 0); r < Math.min(side + i, side); r++) {
                    for (int c = Math.max(j, 0); c < Math.min(side + j, side); c++) {
                        overlap += A[r - i][c - j] & B[r][c];
                    }
                }
                ret = Math.max(ret, overlap);
            }
        }
        return ret;
    }
}
